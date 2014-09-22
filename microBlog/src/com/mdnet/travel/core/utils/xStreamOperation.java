package com.mdnet.travel.core.utils;

import com.mdnet.travel.core.model.MobilePayReturn;
import com.thoughtworks.xstream.XStream;

public class xStreamOperation {
	
	public static XStream xS = null;
	
	static{
		
		xS = new XStream();
		
	}
	 /**
	  * 
	  * cla:对象的类
	  * name:需要包含此对象的外围标签
	  * @return 转成的xml字符串
	  */
	 public static String ToXML(Class cla,String name,Object object){
		
		 
		 /**************    设置类别名   ****************/ 
		 xStreamOperation.xS.alias(name, cla); 
	      
	     String xmlMessage =  xStreamOperation.xS.toXML(object);
		 
		 return xmlMessage;
	 }
	 
	 /**
	  * 
	  * param:String xml  需要转成对象的xml
	  * @param name xml的根节点元素名称
	  * @param tClass  需要转换成对象的类名称
	  * @return object
	  */
	 public static Object XMLToObject(String xml,String name,Class tClass){
		 
		 	xStreamOperation.xS.alias(name, tClass);
		 	Object object = xStreamOperation.xS.fromXML(xml);
		 
		 	return object;
	 }
	
	
	public static void main(String[] args){
		
		 System.out.println("----------XStream学习:http://lavasoft.blog.51cto.com----------"); 
	        //目标对象 
	//	MobilePayReturn mobilePayReturn = new MobilePayReturn();
		
		String xml = "<notify><payment_type>1</payment_type><subject>支付测试专用</subject><trade_no>2014042372689955</trade_no><buyer_email>13661119413</buyer_email><gmt_create>2014-04-23 17:37:52</gmt_create><notify_type>trade_status_sync</notify_type><quantity>1</quantity><out_trade_no>1390628422</out_trade_no><notify_time>2014-04-23 17:38:18</notify_time><seller_id>2088111975464271</seller_id><trade_status>TRADE_FINISHED</trade_status><is_total_fee_adjust>N</is_total_fee_adjust><total_fee>0.01</total_fee><gmt_payment>2014-04-23 17:38:18</gmt_payment><seller_email>tbshop@zhinet.net</seller_email><gmt_close>2014-04-23 17:38:18</gmt_close><price>0.01</price><buyer_id>2088302180405551</buyer_id><notify_id>4e127d6cc7ac3e426b8ed50363625d2f52</notify_id><use_coupon>N</use_coupon></notify>";
		
		MobilePayReturn mobilePayReturn = (MobilePayReturn) xStreamOperation.XMLToObject(xml,"notify",MobilePayReturn.class);
		
		System.out.println(mobilePayReturn.getOut_trade_no());
	        
	}

}
