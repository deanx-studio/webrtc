package net.zhinet.travel.inf.impl;

public class ScenicTicketImplProxy implements net.zhinet.travel.inf.impl.ScenicTicketImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.ScenicTicketImpl scenicTicketImpl = null;
  
  public ScenicTicketImplProxy() {
    _initScenicTicketImplProxy();
  }
  
  public ScenicTicketImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initScenicTicketImplProxy();
  }
  
  private void _initScenicTicketImplProxy() {
    try {
      scenicTicketImpl = (new net.zhinet.travel.inf.impl.ScenicTicketImplServiceLocator()).getScenicTicketImpl();
      if (scenicTicketImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)scenicTicketImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)scenicTicketImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (scenicTicketImpl != null)
      ((javax.xml.rpc.Stub)scenicTicketImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.ScenicTicketImpl getScenicTicketImpl() {
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.View_InfoRes view_info(net.zhinet.travel.pojo.reqandrespojo.View_InfoReq view_InfoReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.view_info(view_InfoReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.View_InfoRes view_catalog(net.zhinet.travel.pojo.reqandrespojo.View_CatalogReq view_CatalogReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.view_catalog(view_CatalogReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_info(net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoReq ticket_InfoReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.ticket_info(ticket_InfoReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes catalog_info(net.zhinet.travel.pojo.reqandrespojo.CatalogListReq catalogListReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.catalog_info(catalogListReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes priceCanledar(net.zhinet.travel.pojo.reqandrespojo.PriceCanledarReq priceCanledarReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.priceCanledar(priceCanledarReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_detail(net.zhinet.travel.pojo.reqandrespojo.Ticket_DetailReq ticket_DetailReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.ticket_detail(ticket_DetailReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_catalog(net.zhinet.travel.pojo.reqandrespojo.Ticket_CatalogReq ticket_catalogReq) throws java.rmi.RemoteException{
    if (scenicTicketImpl == null)
      _initScenicTicketImplProxy();
    return scenicTicketImpl.ticket_catalog(ticket_catalogReq);
  }
  
  
}