package com.mdnet.travel.core.weixin.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdnet.travel.core.weixin.pojo.AccessToken;
import com.mdnet.travel.core.weixin.pojo.Button;
import com.mdnet.travel.core.weixin.pojo.CommonButton;
import com.mdnet.travel.core.weixin.pojo.ComplexButton;
import com.mdnet.travel.core.weixin.pojo.Menu;
import com.mdnet.travel.core.weixin.pojo.ViewButton;
import com.mdnet.travel.core.weixin.utils.WeixinUtils;

/**
 * 菜单管理器类 调用封装的方法创建自定义的菜单
 * 
 * @author ldy
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuManager {

	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		String appId = "wxa0726e2cee6f7291";
		String appSecret = "eef5f0f274bf83b7996cc67d2c23f0d0";
		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		if (null != access_token) {
			// 调用接口创建菜单
			int result = WeixinUtils.createMenu(getMenu(),
					access_token.getToken());

			// 判断菜单创建结果
			if (0 == result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	public static Menu getMenu() {
		CommonButton btn11 = new CommonButton();
		btn11.setName("精品行程");
		btn11.setType("click");
		btn11.setKey("11");
		ViewButton vb12 = new ViewButton();
		vb12.setName("在线订购");
		vb12.setType("view");
		vb12.setUrl("http://192.168.1.33:8080/travel-core/sub/enter");
		CommonButton btn13 = new CommonButton();
		btn13.setName("景区导览");
		btn13.setType("click");
		btn13.setKey("13");

		CommonButton btn21 = new CommonButton();
		btn21.setName("我要投诉");
		btn21.setType("click");
		btn21.setKey("21");
		CommonButton btn22 = new CommonButton();
		btn22.setName("我的积分");
		btn22.setType("click");
		btn22.setKey("22");
		CommonButton btn23 = new CommonButton();
		btn23.setName("我的订单");
		btn23.setType("click");
		btn23.setKey("23");

		CommonButton btn31 = new CommonButton();
		btn31.setName("活动风采");
		btn31.setType("click");
		btn31.setKey("31");
		CommonButton btn32 = new CommonButton();
		btn32.setName("各乡特色");
		btn32.setType("click");
		btn32.setKey("32");
		CommonButton btn33 = new CommonButton();
		btn33.setName("栾川动态");
		btn33.setType("click");
		btn33.setKey("33");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("游在栾川");
		mainBtn1.setSub_button(new Button[]{btn11,vb12,btn13});

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("个人中心");
		mainBtn2.setSub_button(new Button[] { btn21,btn22,btn23});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("全景栾川");
		mainBtn3.setSub_button(new Button[] { btn31,btn32,btn33});

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;

	}
}
