package com.mdnet.travel.core.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.mdnet.travel.core.common.Constant;

/**
 * 读取配置文件的工具类（包括txt文件和propertise文件）
 * @author ldy
 *
 */

public class FileOperationUtil {
	public static Logger logger = Logger.getLogger(FileOperationUtil.class);
	// 输入流，输出流---为了读取txt文件

	/**
	 * 处理propertise文件
	 * 
	 * @param classPath
	 * @return
	 * @throws IOException
	 */
	public static Properties getProp(String classpath){
		Properties prop = new Properties();
		InputStream in = FileOperationUtil.class.getClassLoader().getResourceAsStream(classpath);
		try {
			prop.load(in);
		} catch (IOException e) {
			System.out.println("------读取properties配置文件" + classpath + "时，出错:"
					+ e.getMessage().toString());
		}
		try {
			
		 if(in != null){
			in.close();
		 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	

	/**
	 * 读取非properties文件，获取每行的值 例如文本文件
	 * 
	 * @param classpath
	 *            文件名（文件 路径）
	 */
	public static BufferedReader getTextFile(String classpath){
		InputStream in = FileOperationUtil.class.getClassLoader().getResourceAsStream(classpath);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	/**
	 * 以网络的方式动态的改变指定属性文件中对应键的值
	 * @param request
	 * @param value
	 * @throws IOException 
	 */
	public static void abc(HttpServletRequest request) throws IOException{
		String pointer = request.getParameter("pointer");  
//		if(StringUtils.isNotBlank(pointer)){
//			String path = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/classes/"+Constant.classpath;  
//			OutputStream out = null;
//			try {  
//				Properties prop = getProp(Constant.classpath); 
//			    prop.setProperty("pointer",pointer); //更改或保存键值对  
//			    out = new FileOutputStream(path);   
//			    prop.store(out, null); //把prop键值对放入out输出流  
//			} catch (Exception e) {  
//			    e.printStackTrace();  
//			} finally {  
//			    out.close();  
//			}  
//		}
		
	}
	
	public void changeValue(HttpServletRequest request) {  
		String value = request.getParameter("pointer");
		String value1 = request.getParameter("news_id");
        String path = this.getClass().getProtectionDomain().getCodeSource()  
                .getLocation().getPath();  
        String rootPath = path.substring(0, path.lastIndexOf("/classes"));  
        String propertyFilePath = rootPath  
                + "/classes/com/mdnet/travel/weixin.properties";  
        Properties prop = new Properties();// 属性集合对象  
        FileInputStream fis;  
        try {  
            fis = new FileInputStream(propertyFilePath);// 属性文件输入流  
            prop.load(fis);// 将属性文件流装载到Properties对象中  
            fis.close();// 关闭流  
            // 修改sitename的属性值  
            if(null!=value){
            	prop.setProperty("pointer", value);  
            }
            if(null!=value1){
            	prop.setProperty("pointer", value1);
            }
            // 文件输出流  
            FileOutputStream fos = new FileOutputStream(propertyFilePath);  
            // 将Properties集合保存到流中  
            prop.store(fos, null);  
            fos.close();// 关闭流  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  

	/**
	 * 一行一行读取文本文件
	 * 由于中文乱码的问题，在遇到有中文时最好别用
	 * 
	 * @return 这个文本文件
	 */
	public static String getTextLines(BufferedReader br) {
		StringBuffer sb = new StringBuffer();
		String temp = null;
		try {
			while ((temp = br.readLine()) != null) {
				if (temp.trim().length() > 0 && (!temp.trim().startsWith("#"))) {// 这里说明文本文件里面也可以用#注释
					sb.append(temp);
					sb.append("\n");
				}
			}
		} catch (IOException e) {
			System.out.println("在读取文本文件时出错：" + e.getMessage().toString());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return sb.toString();
	}
}