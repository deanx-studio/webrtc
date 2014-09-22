package net.zhinet.travel.inf.impl;

public class CityGuideImplProxy implements net.zhinet.travel.inf.impl.CityGuideImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.CityGuideImpl cityGuideImpl = null;
  
  public CityGuideImplProxy() {
    _initCityGuideImplProxy();
  }
  
  public CityGuideImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initCityGuideImplProxy();
  }
  
  private void _initCityGuideImplProxy() {
    try {
      cityGuideImpl = (new net.zhinet.travel.inf.impl.CityGuideImplServiceLocator()).getCityGuideImpl();
      if (cityGuideImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cityGuideImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cityGuideImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cityGuideImpl != null)
      ((javax.xml.rpc.Stub)cityGuideImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.CityGuideImpl getCityGuideImpl() {
    if (cityGuideImpl == null)
      _initCityGuideImplProxy();
    return cityGuideImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes city_actives(net.zhinet.travel.pojo.reqandrespojo.City_ActivesReq city_ActivesReq) throws java.rmi.RemoteException{
    if (cityGuideImpl == null)
      _initCityGuideImplProxy();
    return cityGuideImpl.city_actives(city_ActivesReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Province_ListRes province_list(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) throws java.rmi.RemoteException{
    if (cityGuideImpl == null)
      _initCityGuideImplProxy();
    return cityGuideImpl.province_list(requestHead);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.City_ListRes city_list(net.zhinet.travel.pojo.reqandrespojo.City_ListReq city_ListReq) throws java.rmi.RemoteException{
    if (cityGuideImpl == null)
      _initCityGuideImplProxy();
    return cityGuideImpl.city_list(city_ListReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.View_ListRes view_list(net.zhinet.travel.pojo.reqandrespojo.View_ListReq view_ListReq) throws java.rmi.RemoteException{
    if (cityGuideImpl == null)
      _initCityGuideImplProxy();
    return cityGuideImpl.view_list(view_ListReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes tickets_list(net.zhinet.travel.pojo.reqandrespojo.Tickets_ListReq tickets_ListReq) throws java.rmi.RemoteException{
    if (cityGuideImpl == null)
      _initCityGuideImplProxy();
    return cityGuideImpl.tickets_list(tickets_ListReq);
  }
  
  
}