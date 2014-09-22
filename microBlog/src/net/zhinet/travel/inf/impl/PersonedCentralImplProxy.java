package net.zhinet.travel.inf.impl;

public class PersonedCentralImplProxy implements net.zhinet.travel.inf.impl.PersonedCentralImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.PersonedCentralImpl personedCentralImpl = null;
  
  public PersonedCentralImplProxy() {
    _initPersonedCentralImplProxy();
  }
  
  public PersonedCentralImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonedCentralImplProxy();
  }
  
  private void _initPersonedCentralImplProxy() {
    try {
      personedCentralImpl = (new net.zhinet.travel.inf.impl.PersonedCentralImplServiceLocator()).getPersonedCentralImpl();
      if (personedCentralImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personedCentralImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personedCentralImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personedCentralImpl != null)
      ((javax.xml.rpc.Stub)personedCentralImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.PersonedCentralImpl getPersonedCentralImpl() {
    if (personedCentralImpl == null)
      _initPersonedCentralImplProxy();
    return personedCentralImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.ComplaintDetailRes listComplaint(net.zhinet.travel.pojo.reqandrespojo.ComplaintDetailReq complaintDetailReq) throws java.rmi.RemoteException{
    if (personedCentralImpl == null)
      _initPersonedCentralImplProxy();
    return personedCentralImpl.listComplaint(complaintDetailReq);
  }
  
  public net.zhinet.travel.pojo.basepojo.ResponseHead saveComplaint(net.zhinet.travel.pojo.reqandrespojo.ComplaintReq complaintReq) throws java.rmi.RemoteException{
    if (personedCentralImpl == null)
      _initPersonedCentralImplProxy();
    return personedCentralImpl.saveComplaint(complaintReq);
  }
  
  
}