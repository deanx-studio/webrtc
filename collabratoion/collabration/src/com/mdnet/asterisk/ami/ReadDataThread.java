package com.mdnet.asterisk.ami;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.mdnet.asterisk.action.LoginActionMsg;
import com.mdnet.asterisk.ami.event.EventNotify;
import com.mdnet.travel.core.service.impl.ParamConfigInstance;

public class ReadDataThread extends Thread {
	private BufferedReader reader = null;
	private OutputStream writer = null;

	// private Socket socket;

	public OutputStream getWriter() {
		return writer;
	}

	public void setWriter(OutputStream writer) {
		this.writer = writer;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	private String text = "";
	private EventNotify event = null;
	private ResponseNotify resp = null;
	private boolean isConnect = false;

	public boolean isConnect() {
		return isConnect;
	}

	public void setConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}

	public void setEvent(EventNotify event) {
		this.event = event;
	}

	public void setResp(ResponseNotify resp) {
		this.resp = resp;
	}

	public ReadDataThread(BufferedReader Reader) {
		this.reader = Reader;
	}

	@Override
	public synchronized void run() {

		while (true) {
			if (reader != null) {
				try {
					// String msg = reader.readLine();
					int r = reader.read();
					// System.out.println("recv==" + r);
					if (r <= 0) {
						if (r < 0) {
							this.isConnect = false;
						}
						sleep(10);
						continue;
					}
					char c = (char) r;

					text += String.valueOf(c);
					if (text.indexOf("\r\n") > 0)
						// 处理接收的报文
						handle();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					this.isConnect = false;
				}

			}// end if
			else {
				sleep(10);
			}
		}// end while
	}

	protected void sleep(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handle() {
		while (true) {
			//System.out.println(this.text);
			int inx = this.text.indexOf("\r\n");
			if (inx < 0)
				return;// 处理结束，缓冲区中没有换行符啦
			// 检验是否是初始消息，接收到初始消息则发送登录消息
			if (this.text.indexOf("Asterisk Call Manager") >= 0) {
				sendLogin();
				// 清理缓冲区
				this.text = this.text.substring(inx + 2);
			} else if (this.text.indexOf("Event:") >= 0) {
				int last = this.text.indexOf("\r\n\r\n");
				if (last > 0) {
					String eventTxt = this.text.substring(0, last);
					if (this.event != null)// 出发事件
						this.isConnect = true;
						this.event.fireEvent(eventTxt);
					// 清理缓冲区
					this.text = this.text.substring(last + 4);
				}
				else//数据未接收完整
					return;
			} else if (this.text.indexOf("Response:") >= 0) {
				int last = this.text.indexOf("\r\n\r\n");
				if (last > 0) {
					String eventTxt = this.text.substring(0, last);
					if (this.resp != null)// 出发事件
						this.resp.fireResponse(eventTxt);
					// 清理缓冲区
					this.text = this.text.substring(last + 4);
				}
				else//数据未接收完整
					return;
			}
		}// end while

	}

	public int sendLogin() {
		LoginActionMsg msg = new LoginActionMsg();
		msg.setUsername(ParamConfigInstance.inst().getAmiUsername());
		msg.setSecret(ParamConfigInstance.inst().getAmiSecrect());

		try {

			this.writer.write(msg.toString().getBytes());
			System.out.println("--------------send data:-------------\r\n"+msg.toString());
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}
