package com.mdnet.travel.core.weixin.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdnet.travel.core.weixin.message.resp.MusicMessage;
import com.mdnet.travel.core.weixin.message.resp.NewsMessage;
import com.mdnet.travel.core.weixin.message.resp.OrderInfoMessage;
import com.mdnet.travel.core.weixin.message.resp.TextMessage;
import com.mdnet.travel.core.weixin.pojo.AccessToken;
import com.mdnet.travel.core.weixin.pojo.Article;
import com.mdnet.travel.core.weixin.pojo.Menu;
import com.mdnet.travel.core.weixin.shop.AddProduct;
import com.mdnet.travel.core.weixin.shop.Category;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class WeixinUtils {
	private static Logger log = LoggerFactory.getLogger(WeixinUtils.class);

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	public static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取口令失败
				log.error("获取token失败 errcode:{} errmsg:{}",
						jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);

		// 将菜单对象转换为json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();

		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("创建菜单失败 errcode:{} errmsg:{}",
						jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return result;
	}

	public static void getProperties(String token, String cate_id)
	{
		
	}
	public static String upImage(String token, String filename) {
		 File file = new File(filename); //创建文件对象
		String url = "https://api.weixin.qq.com/merchant/common/upload_img?access_token="
				+ token + "&filename=" + file.getName();
		JSONObject respObj = httpsRequestFile(url, "POST", file);
		
		return respObj.getString("image_url");
	}

	/**
	 * 上传本地文件
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param filename
	 * @return
	 */
	public static JSONObject httpsRequestFile(String requestUrl,
			String requestMethod, File file) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并指定我们信任的管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());

			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpsConn = (HttpsURLConnection) url
					.openConnection();
			httpsConn.setSSLSocketFactory(ssf);

			httpsConn.setDoInput(true);
			httpsConn.setDoOutput(true);
			httpsConn.setUseCaches(false);

			// 设置请求方法(GET/POST)
			httpsConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpsConn.connect();
			}
			// 当数据需要提交时
			if (null != file) {
				OutputStream outputStream = httpsConn.getOutputStream();
				byte[] readBytes = new byte[8192];
				// 打开文件
				BufferedInputStream in = new BufferedInputStream(
						new FileInputStream(file));
				// outputStream.write(outputStr.getBytes("UTF-8"));
				while (true) {
					int len = in.read(readBytes);
					if (len <= 0)
						break;
					outputStream.write(readBytes, 0, len);
				}
				// 关闭文件
				in.close();
				outputStream.close();
			}

			// 将返回的输入流转换为字符串
			InputStream inputStream = httpsConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpsConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求的地址
	 * @param requestMethod
	 *            请求的方式(get post)
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject (通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并指定我们信任的管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());

			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpsConn = (HttpsURLConnection) url
					.openConnection();
			httpsConn.setSSLSocketFactory(ssf);

			httpsConn.setDoInput(true);
			httpsConn.setDoOutput(true);
			httpsConn.setUseCaches(false);

			// 设置请求方法(GET/POST)
			httpsConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpsConn.connect();
			}
			// 当数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpsConn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换为字符串
			InputStream inputStream = httpsConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpsConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request)
			throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage
	 *            文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicMessage
	 *            音乐消息对象
	 * @return xml
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage
	 *            图文消息对象
	 * @return xml
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	public static Menu getNow(String accessToken) {

		int result = 0;
		// 拼装创建菜单的url
		String url = menu_get_url.replace("ACCESS_TOKEN", accessToken);

		// 将菜单对象转换为json字符串
		String jsonMenu = "";

		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {

			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("清除菜单失败 errcode:{} errmsg:{}",
						jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return null;
	}

	public static int deleteMenu(String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = menu_delete_url.replace("ACCESS_TOKEN", accessToken);

		// 将菜单对象转换为json字符串
		String jsonMenu = "";

		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("清除菜单失败 errcode:{} errmsg:{}",
						jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return result;
	}

	public static OrderInfoMessage getOrderInfo(String token, String orderId) {
		OrderInfoMessage resp = new OrderInfoMessage();
		resp.setErrcode(-99999);
		resp.setErrmsg("读取数据返回NULL。");
		String url = "https://api.weixin.qq.com/merchant/order/getbyid?access_token="
				+ token;
		String jsonMenu = "{\"order_id\": \"" + orderId + "\"}";
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			resp.setErrcode(jsonObject.getInt("errcode"));
			resp.setErrmsg(jsonObject.getString("errmsg"));
			if (0 != jsonObject.getInt("errcode")) {
				int result = jsonObject.getInt("errcode");
				log.error("获取订单信息失败 errcode:{} errmsg:{}", resp.getErrcode(),
						resp.getErrmsg());

				return resp;
			} else {
				JSONObject orderObject = jsonObject.getJSONObject("order");

				resp.setOrder_id(orderObject.getString("order_id"));// "7197417460812533543",
				resp.setOrder_status(orderObject.getInt("order_status"));// 6,
				resp.setOrder_total_price(orderObject
						.getInt("order_total_price"));// 6,
				resp.setOrder_create_time(Integer.parseInt(orderObject
						.getString("order_create_time")));// 1394635817,
				resp.setOrder_express_price(orderObject
						.getInt("order_express_price"));// 5,
				resp.setBuyer_openid(orderObject.getString("buyer_openid"));// "oDF3iY17NsDAW4UP2qzJXPsz1S9Q",
				resp.setBuyer_nick(orderObject.getString("buyer_nick"));// "likeacat",
				resp.setReceiver_name(orderObject.getString("receiver_name"));// "张小猫",
				resp.setReceiver_province(orderObject
						.getString("receiver_province"));// "广东省",
				resp.setReceiver_city(orderObject.getString("receiver_city"));// "广州市",
				resp.setReceiver_address(orderObject
						.getString("receiver_address"));// "华景路一号南方通信大厦5楼",
				resp.setReceiver_mobile(orderObject
						.getString("receiver_mobile"));// "123456789",
				resp.setReceiver_phone(orderObject.getString("receiver_phone"));// "123456789",
				resp.setProduct_id(orderObject.getString("product_id"));// "pDF3iYx7KDQVGzB7kDg6Tge5OKFo",
				resp.setProduct_name(orderObject.getString("product_name"));// "安莉芳E-BRA专柜女士舒适内衣蕾丝3/4薄杯聚拢上托性感文胸KB0716",
				resp.setProduct_price(orderObject.getInt("product_price"));// 1,
				resp.setProduct_sku(orderObject.getString("product_sku"));// "10000983:10000995;10001007:10001010",
				resp.setProduct_count(orderObject.getInt("product_count"));// 1,
				resp.setProduct_img(orderObject.getString("product_img"));// "http://img2.paipaiimg.com/00000000/item-52B87243-63CCF66C00000000040100003565C1EA.0.300x300.jpg",
				resp.setDelivery_id(orderObject.getString("delivery_id"));// "1900659372473",
				resp.setDelivery_company(orderObject
						.getString("delivery_company"));// "059Yunda",
				resp.setTrans_id(orderObject.getString("trans_id"));

			}
		}

		return resp;
	}

	/**
	 * 获取产品分类信息，根分类categoryId为1
	 * 
	 * @param token
	 * @param categoryId
	 * @return
	 */
	public static List<Category> getCategory(String token, String categoryId) {
		List<Category> cates = new ArrayList<Category>();
		String url = "https://api.weixin.qq.com/merchant/category/getsub?access_token="
				+ token;

		JSONObject jsonObject = httpRequest(url, "POST",
				String.format("{\"cate_id\": %s}", categoryId));
		if (jsonObject.getInt("errcode") == 0) {
			JSONArray jsonarray = jsonObject.getJSONArray("cate_list");

			for (int i = 0; i < jsonarray.size(); i++) {
				JSONObject jsonObj = jsonarray.getJSONObject(i);

				Category c = new Category();
				c.setId(jsonObj.getString("id"));
				c.setName(jsonObj.getString("name"));
				cates.add(c);
			}
		}
		return cates;
	}

	/**
	 * 添加新的商品
	 * 
	 * @param token
	 * @param add
	 * @return
	 */
	public static String addProduct(String token, AddProduct add) {
		String url = "https://api.weixin.qq.com/merchant/create?access_token="
				+ token;

		JSONObject jsonObject = httpRequest(url, "POST", add.toJson());
		if (jsonObject.getInt("errcode") != 0) {
			log.error("添加商品失败，错误原因:" + jsonObject.getString("errmsg"));
			return "";
		} else
			return jsonObject.getString("product_id");
	}
}
