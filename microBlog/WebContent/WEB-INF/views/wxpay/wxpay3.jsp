<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java" %>
<%@ page import="wxpay.*" %>
<%@ page import="java.net.URLEncoder" %>
		<% 
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");	
					
 			WxPayHelper wxPayHelper = new WxPayHelper();
			//先设置基本信息
			//NLJJ
			//wxPayHelper.SetAppId("wxdcd5c55e243e5c19");
			//wxPayHelper.SetAppKey("5cs2uZsdPIqHi8UDtG2uXnvZQnT4106jfQCdT71Tn7HvvHOfphUz5isKdQbG8xxM4hk4OmnWkS8kIHbk2ApAdQuWNFzHUt2hLzqHRh7Fr06uYqJGRrxY8mpCdkzDlUWZ");//2Wozy2aksie1puXUBpWD8oZxiD1DfQuEaiC7KcRATv1Ino3mdopKaPGQQ7TtkNySuAmCaDCrw4xhPY5qKTBl7Fzm0RgR3c0WaVYIXZARsxzHV2x7iwPPzOz94dnwPWSn");
			//wxPayHelper.SetPartnerKey("dff8b70998cdaca2d8de0e2837655781");
			//wxPayHelper.SetParameter("partner", "1218812401");
			//XZJZ
			wxPayHelper.SetAppId("wxb9da143d271d1008");
			wxPayHelper.SetAppKey("x1lGqwbAOGWV0f6XNoXrbgKqgsgh6TPly6mZbh1zSEJuhFLMAFeprvPvdR4UQhAwiSR8XveLWTpWiDiLzy8Sp1vbHIvTOiwzSdOWpqQ10uyV1vPRD9QtBL7sBWX637X6");
			wxPayHelper.SetPartnerKey("ebfcedbd3f4fe9554d31c7492b11b6fc");
			wxPayHelper.SetParameter("partner", "1219880101");
			
			wxPayHelper.SetSignType("sha1");
			//设置请求package信息
			wxPayHelper.SetParameter("bank_type", "WX");
			String valueStr=new String("德芙Dove");
			
			//valueStr = new String(valueStr.getBytes("GBK"),"UTF-8");//URLEncoder.encode(valueStr,"GBK");//
			//System.out.println(URLEncoder.encode(valueStr, "UTF-8"));
			//valueStr = new String(valueStr.getBytes("UTF-8"),"GBK");
			//System.out.println(valueStr);
			wxPayHelper.SetParameter("body", valueStr);
			
			wxPayHelper.SetParameter("out_trade_no", CommonUtil.CreateNoncestr());
			wxPayHelper.SetParameter("total_fee", "1");
			wxPayHelper.SetParameter("fee_type", "1");
			wxPayHelper.SetParameter("notify_url", "http://112.125.121.163/travel-weixin/wxpay/payNotify");
			wxPayHelper.SetParameter("spbill_create_ip", "127.0.0.1");
			wxPayHelper.SetParameter("input_charset", "UTF-8");
			String valStr= wxPayHelper.CreateBizPackage(); // new String(wxPayHelper.CreateBizPackage().getBytes("ISO-8859-1"),"UTF-8");

		%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>公众号JS API支付</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1; user-scalable=no;" />
    </head>
    <script language="javascript">
      
			function callpay()
			{
			
			// {"appId":"wxdcd5c55e243e5c19","timeStamp":"1401308802","signType":"sha1","package":"bank_type=WX&body=Dove&fee_type=1&input_charset=UTF-8&notify_url=http%3A%2F%2Fxiaobojiaoyi.duapp.com%2Ftenpay%2FpayReturnUrl.jsp&out_trade_no=DzTLAZQnFiGsYFtr&partner=1218812401&spbill_create_ip=127.0.0.1&total_fee=1&sign=2975B2BBF50536F62685614FF60A953E","nonceStr":"KIXlkpUDghQv8LoR","paySign":"fdded06b49bc387fe1fc96b914a5c5bdb153ccdc"} 
			// {"appId":"wxdcd5c55e243e5c19","timeStamp":"1401308410","signType":"sha1","package":"bank_type=WX&body=Dove&fee_type=1&input_charset=UTF-8&notify_url=http%3A%2F%2Fxiaobojiaoyi.duapp.com%2Ftenpay%2FpayReturnUrl.jsp&out_trade_no=EQ2Ux31OjhZ2GSIo&partner=1218812401&spbill_create_ip=127.0.0.1&total_fee=1&sign=6A014949293E406E96D16748AACD01DA","nonceStr":"eQ0znSybbT2DN0ek","paySign":"6f6844f8d6572862df1a5d2e41c0048de8526aa1"}, 
			
				WeixinJSBridge.invoke('getBrandWCPayRequest',
										<%=valStr%>,
										function(res){
										
					WeixinJSBridge.log(res.err_msg);
					// alert(res.err_code+res.err_desc+res.err_msg);
					
					if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                         window.location.href="http://jiujinhui.duapp.com/NLJJ/zfok.html"; 
                    }
                    if(res.err_msg == "get_brand_wcpay_request:cancel" ) {
                         window.location.href="http://jiujinhui.duapp.com/NLJJ/zfcancel.html"; 
                    }  
                    if(res.err_msg == "get_brand_wcpay_request:fail" ) {
                         window.location.href="http://jiujinhui.duapp.com/NLJJ/zffail.html"; 
                    }                                                                                                                                                                                                     		
						// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
                          //因此微信团队建议，当收到ok返回时，向商户后台询问是否收到交易成功的通知，若收到通知，前端展示交易成功的界面；若此时未收到通知，商户后台主动调用查询订单接口，查询订单的当前状态，并反馈给前端展示相应的界面。
				});
			}
			// document.write();
		</script>
 	<body>
 
		<button type="button" onclick="callpay()">JS API支付</button>
	</body>
</html>