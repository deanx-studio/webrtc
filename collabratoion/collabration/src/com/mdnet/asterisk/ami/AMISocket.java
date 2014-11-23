package com.mdnet.asterisk.ami;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdnet.asterisk.ami.event.EventNotify;

public class AMISocket {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String hostname;
	private int port;
	// private BufferedReader reader;
	private Socket socket = null;
	private OutputStream writer;
	private ReadDataThread readThread;

	private EventNotify event = new EventNotify();
	private ResponseNotify resp = new ResponseNotify();

	/**
	 * 构造函数
	 * 
	 * @param hostname
	 *            asterisk的AMI服务监听的ip，也就是我们安装asterisk的机器的ip
	 * @param port
	 *            asterisk的AMI端口，一般是5038，我们定义的ast0是5030
	 * @throws IOException
	 */
	public AMISocket(String HostName, int Port) {
		hostname = HostName;
		port = Port;

		// 建立读数据线程
		readThread = new ReadDataThread(null);
		readThread.setEvent(event);
		readThread.setResp(resp);
		readThread.start();
	}

	public void connect() {

		// 发送登录包
		int r = this.readThread.sendLogin();

//		System.out.println("available:" + r);

		if (this.readThread.isConnect()) {
			// logger.info("当前是连接状态，不进行重连。");
			return;
		}
		logger.info("当前是断开状态，建立新socket连接。");
		try {
			// 建立连接
			socket = new Socket(hostname, port);
			socket.setKeepAlive(true);
			// 获取输入输出流，并缓存
			this.readThread.setReader(new BufferedReader(new InputStreamReader(
					socket.getInputStream())));
			this.writer = socket.getOutputStream();
			this.readThread.setWriter(this.writer);

			this.readThread.setConnect(true);

			// LoginActionMsg msg = new LoginActionMsg();
			// msg.setUsername("lzj");
			// msg.setSecret("GhostLiu");
			// this.sendData(msg);
		} catch (Exception e) {
			this.readThread.setConnect(false);
		}
	}

	public void reconnect() {
		// if (this.socket.isConnected().isClosed()) {
		// this.readThread.setConnect(false);
		// connect();
		// }
		connect();
	}

	public synchronized ResponseMsg sendData(ActionMsg msg) {
		String text = msg.toString();
		try {

			// this.writer.write("11111111111111111111111111");

			this.writer.write(text.getBytes());
			System.out.println("已经发送消息:\r\n" + text);
			// return text.length();
			// 接收请求
			ResponseMsg r = resp.getResp(msg.getActionID());
			return r;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
