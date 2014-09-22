package com.mdnet.travel.core.utils;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlOperation {

	public void readStringXml(String xml) {
		Document doc = null;
		try {

			// 读取并解析XML文档
			// SAXReader就是一个管道，用一个流的方式，把xml文件读出来
			// SAXReader reader = new SAXReader(); //User.hbm.xml表示你要解析的xml文档
			// Document document = reader.read(new File("User.hbm.xml"));
			// 下面的是通过解析xml字符串的
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML

			Element rootElt = doc.getRootElement(); // 获取根节点
		//	System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称

			List<Element> elements = rootElt.elements();
			//elementIterator();
			//.elementIterator("notify"); // 获取根节点下的子节点head

			 for(Iterator<Element> it = elements.iterator();it.hasNext();){  
		            Element element = it.next();  
		            System.out.println(element.getName()+" : "+element.getTextTrim());  
		        }  
			 
		} catch (DocumentException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public static void main(String[] args){
		
		String xml = "<notify><payment_type>1</payment_type><subject>支付测试专用</subject><trade_no>2014042372689955</trade_no><buyer_email>13661119413</buyer_email><gmt_create>2014-04-23 17:37:52</gmt_create><notify_type>trade_status_sync</notify_type><quantity>1</quantity><out_trade_no>1390628422</out_trade_no><notify_time>2014-04-23 17:38:18</notify_time><seller_id>2088111975464271</seller_id><trade_status>TRADE_FINISHED</trade_status><is_total_fee_adjust>N</is_total_fee_adjust><total_fee>0.01</total_fee><gmt_payment>2014-04-23 17:38:18</gmt_payment><seller_email>tbshop@zhinet.net</seller_email><gmt_close>2014-04-23 17:38:18</gmt_close><price>0.01</price><buyer_id>2088302180405551</buyer_id><notify_id>4e127d6cc7ac3e426b8ed50363625d2f52</notify_id><use_coupon>N</use_coupon></notify>";
		
		XmlOperation xmlOperation = new XmlOperation();
		
	
		xmlOperation.readStringXml(xml);
		
		
		
		
	}
}
