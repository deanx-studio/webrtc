package net.zhinet.travel.pojo.basepojo;

import java.io.Serializable;
import java.util.Date;

public class TerminateInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String Channel;// : SIP/1000-00000014
	protected int ChannelState;// : 0
	protected String ChannelStateDesc;// : Down
	protected String CallerIDNum;// : 1000
	protected String CallerIDName;// :
	protected String AccountCode;// :
	protected String Exten;// : 9000
	protected String Context;// : from-sip
	protected String Uniqueid;// : 1409638154.22
	
	protected int Priority;
	protected String Application;
	protected String AppData;
	protected int ConnectedLineNum;
	protected String ConnectedLineName;
	protected String ChannelType;// : SIP
	protected String Peer;// : SIP/1000
	protected String PeerStatus;// : Registered
	protected String Address;// : 222.129.40.193:19965
	protected String Cause;// : Expired
	protected String CauseText;
	
	
	protected int id;
	protected Date lastRegisterTime;//上次注册时间
	protected Date UnRegisterTime;//注册失效时间
	protected Date lastCallStartTime;//最近一次发起呼叫发起时间
	protected Date lastCallEndTime;//
	protected String devicePassword;

	public String getDevicePassword() {
		return devicePassword;
	}
	public void setDevicePassword(String devicePassword) {
		this.devicePassword = devicePassword;
	}
	public String getCauseText() {
		return CauseText;
	}
	public void setCauseText(String causeText) {
		CauseText = causeText;
	}
	public Date getLastRegisterTime() {
		return lastRegisterTime;
	}
	public void setLastRegisterTime(Date lastRegisterTime) {
		this.lastRegisterTime = lastRegisterTime;
	}
	public Date getUnRegisterTime() {
		return UnRegisterTime;
	}
	public void setUnRegisterTime(Date unRegisterTime) {
		UnRegisterTime = unRegisterTime;
	}
	public Date getLastCallStartTime() {
		return lastCallStartTime;
	}
	public void setLastCallStartTime(Date lastCallStartTime) {
		this.lastCallStartTime = lastCallStartTime;
	}
	public Date getLastCallEndTime() {
		return lastCallEndTime;
	}
	public void setLastCallEndTime(Date lastCallEndTime) {
		this.lastCallEndTime = lastCallEndTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChannel() {
		return Channel;
	}
	public void setChannel(String channel) {
		Channel = channel;
	}
	public int getChannelState() {
		return ChannelState;
	}
	public void setChannelState(int channelState) {
		ChannelState = channelState;
	}
	public String getChannelStateDesc() {
		return ChannelStateDesc;
	}
	public void setChannelStateDesc(String channelStateDesc) {
		ChannelStateDesc = channelStateDesc;
	}
	public String getCallerIDNum() {
		return CallerIDNum;
	}
	public void setCallerIDNum(String callerIDNum) {
		CallerIDNum = callerIDNum;
	}
	public String getCallerIDName() {
		return CallerIDName;
	}
	public void setCallerIDName(String callerIDName) {
		CallerIDName = callerIDName;
	}
	public String getAccountCode() {
		return AccountCode;
	}
	public void setAccountCode(String accountCode) {
		AccountCode = accountCode;
	}
	public String getExten() {
		return Exten;
	}
	public void setExten(String exten) {
		Exten = exten;
	}
	public String getContext() {
		return Context;
	}
	public void setContext(String context) {
		Context = context;
	}
	public String getUniqueid() {
		return Uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}
	
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}
	public String getApplication() {
		return Application;
	}
	public void setApplication(String application) {
		Application = application;
	}
	public String getAppData() {
		return AppData;
	}
	public void setAppData(String appData) {
		AppData = appData;
	}
	public int getConnectedLineNum() {
		return ConnectedLineNum;
	}
	public void setConnectedLineNum(int connectedLineNum) {
		ConnectedLineNum = connectedLineNum;
	}
	public String getConnectedLineName() {
		return ConnectedLineName;
	}
	public void setConnectedLineName(String connectedLineName) {
		ConnectedLineName = connectedLineName;
	}
	public String getChannelType() {
		return ChannelType;
	}
	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}
	public String getPeer() {
		return Peer;
	}
	public void setPeer(String peer) {
		Peer = peer;
	}
	public String getPeerStatus() {
		return PeerStatus;
	}
	public void setPeerStatus(String peerStatus) {
		PeerStatus = peerStatus;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCause() {
		return Cause;
	}
	public void setCause(String cause) {
		Cause = cause;
	}
}
