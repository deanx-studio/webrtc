package net.zhinet.travel.inf.impl;

public class MarketActiveImplProxy implements net.zhinet.travel.inf.impl.MarketActiveImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.MarketActiveImpl marketActiveImpl = null;
  
  public MarketActiveImplProxy() {
    _initMarketActiveImplProxy();
  }
  
  public MarketActiveImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initMarketActiveImplProxy();
  }
  
  private void _initMarketActiveImplProxy() {
    try {
      marketActiveImpl = (new net.zhinet.travel.inf.impl.MarketActiveImplServiceLocator()).getMarketActiveImpl();
      if (marketActiveImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)marketActiveImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)marketActiveImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (marketActiveImpl != null)
      ((javax.xml.rpc.Stub)marketActiveImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.MarketActiveImpl getMarketActiveImpl() {
    if (marketActiveImpl == null)
      _initMarketActiveImplProxy();
    return marketActiveImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.View_CommentRes view_comment(net.zhinet.travel.pojo.reqandrespojo.View_CommentReq view_CommentReq) throws java.rmi.RemoteException{
    if (marketActiveImpl == null)
      _initMarketActiveImplProxy();
    return marketActiveImpl.view_comment(view_CommentReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.City_CommentRes city_comment(net.zhinet.travel.pojo.reqandrespojo.City_CommentReq city_CommentReq) throws java.rmi.RemoteException{
    if (marketActiveImpl == null)
      _initMarketActiveImplProxy();
    return marketActiveImpl.city_comment(city_CommentReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes city_topten(net.zhinet.travel.pojo.reqandrespojo.City_ToptenReq city_ToptenReq) throws java.rmi.RemoteException{
    if (marketActiveImpl == null)
      _initMarketActiveImplProxy();
    return marketActiveImpl.city_topten(city_ToptenReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes view_topten(net.zhinet.travel.pojo.reqandrespojo.View_ToptenReq view_ToptenReq) throws java.rmi.RemoteException{
    if (marketActiveImpl == null)
      _initMarketActiveImplProxy();
    return marketActiveImpl.view_topten(view_ToptenReq);
  }
  
  
}