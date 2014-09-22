package net.zhinet.travel.inf.impl;

public class CommonToolsProxy implements net.zhinet.travel.inf.impl.CommonTools {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.CommonTools commonTools = null;
  
  public CommonToolsProxy() {
    _initCommonToolsProxy();
  }
  
  public CommonToolsProxy(String endpoint) {
    _endpoint = endpoint;
    _initCommonToolsProxy();
  }
  
  private void _initCommonToolsProxy() {
    try {
      commonTools = (new net.zhinet.travel.inf.impl.CommonToolsServiceLocator()).getCommonTools();
      if (commonTools != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)commonTools)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)commonTools)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (commonTools != null)
      ((javax.xml.rpc.Stub)commonTools)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.CommonTools getCommonTools() {
    if (commonTools == null)
      _initCommonToolsProxy();
    return commonTools;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.SMSResp sendSMS(net.zhinet.travel.pojo.reqandrespojo.SMSReq smsReq) throws java.rmi.RemoteException{
    if (commonTools == null)
      _initCommonToolsProxy();
    return commonTools.sendSMS(smsReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.EMailResp sendEmail(net.zhinet.travel.pojo.reqandrespojo.EMailReq emailReq) throws java.rmi.RemoteException{
    if (commonTools == null)
      _initCommonToolsProxy();
    return commonTools.sendEmail(emailReq);
  }
  
  
}