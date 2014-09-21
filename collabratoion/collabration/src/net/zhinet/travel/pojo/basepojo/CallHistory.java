package net.zhinet.travel.pojo.basepojo;

public class CallHistory {
	private String localPeer;// 本端帐号例如：SIP/1000
	private String remotePeer;
	private int status;// 呼叫结果,0:接通、1:未接通</comment>
	private String makeTime;// 创建时间
	private String endTime;// 结束时间
	private String channel;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getLocalPeer() {
		return localPeer;
	}

	public void setLocalPeer(String localPeer) {
		this.localPeer = localPeer;
	}

	public String getRemotePeer() {
		return remotePeer;
	}

	public void setRemotePeer(String remotePeer) {
		this.remotePeer = remotePeer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
