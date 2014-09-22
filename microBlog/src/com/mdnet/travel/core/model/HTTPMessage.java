package com.mdnet.travel.core.model;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HTTPMessage {

	/**
	 * �����HTTP�ķ�ʽ���͵�ָ���ķ�����
	 * 
	 * @param url
	 * @param xml
	 * @return
	 */
	public static String Send(String url, String xml) {

		String respXML = "";
		try {
			URL ul = new URL(url+xml);
			URLConnection connection = ul.openConnection();
			connection.setReadTimeout(50000);
			connection.setConnectTimeout(25000);
			HttpURLConnection uc = (HttpURLConnection) connection;

			uc.setRequestMethod("GET");
			uc.setRequestProperty("Connection", "Keep-Alive");
			uc.setRequestProperty("Cache-Control", "no-cache");

			// uc.setRequestProperty("Content-Type",
			// "application/x-www-form-urlencoded");
			uc.setRequestProperty("Content-Type",
					"application/xml; charset=UTF-8");// <meta
			// http-equiv="Content-Type"
			// content="text/html; charset=UTF-8">

			uc.setRequestProperty("COOKIE", "william");

			uc.setDoOutput(true);
			uc.setDoInput(true);

			// byte[] bs = new String(xml).getBytes("GBK");

			uc.connect();
			// OutputStream om = uc.getOutputStream();
			//PrintWriter out = new PrintWriter(new OutputStreamWriter(
			//		uc.getOutputStream(), "UTF-8"));
			//改为GET方式，不在需要输出
			//out.write(xml);// .write(bs);
			//out.flush();
			//out.close();

			InputStreamReader im = new InputStreamReader(uc.getInputStream(),
					"UTF-8");

			// InputStream im = uc.getInputStream();

			char[] bb = new char[1024];
			while (true) {
				int length = im.read(bb);
				if (length == -1)
					break;
				char[] bc = new char[length];
				for (int i = 0; i < length; i++)
					bc[i] = bb[i];
				respXML += new String(bc);
			}
			// Logger.getLogger("error").info(cc);
			im.close();
			uc.disconnect();
		} catch (Exception e) {
			respXML = "request url:" + url + ",http request exception,cause:"
					+ e.getMessage();
			e.printStackTrace();
		}

		return respXML;

	}
}
