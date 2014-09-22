package net.zhinet.travel.inf.impl;

public class OrderManageImplProxy implements net.zhinet.travel.inf.impl.OrderManageImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.OrderManageImpl orderManageImpl = null;
  
  public OrderManageImplProxy() {
    _initOrderManageImplProxy();
  }
  
  public OrderManageImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initOrderManageImplProxy();
  }
  
  private void _initOrderManageImplProxy() {
    try {
      orderManageImpl = (new net.zhinet.travel.inf.impl.OrderManageImplServiceLocator()).getOrderManageImpl();
      if (orderManageImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)orderManageImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)orderManageImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (orderManageImpl != null)
      ((javax.xml.rpc.Stub)orderManageImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.OrderManageImpl getOrderManageImpl() {
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Order_ChangeRes order_change(net.zhinet.travel.pojo.reqandrespojo.Order_ChangeReq order_ChangeReq) throws java.rmi.RemoteException{
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl.order_change(order_ChangeReq);
  }
  
  public net.zhinet.travel.pojo.basepojo.ResponseHead order_cancel(net.zhinet.travel.pojo.reqandrespojo.Order_CancelReq order_CancelReq) throws java.rmi.RemoteException{
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl.order_cancel(order_CancelReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Order_CreateRes order_create(net.zhinet.travel.pojo.reqandrespojo.Order_CreateReq order_CreateReq) throws java.rmi.RemoteException{
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl.order_create(order_CreateReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Order_SourceRes order_source(net.zhinet.travel.pojo.reqandrespojo.Order_SoureReq order_SourceReq) throws java.rmi.RemoteException{
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl.order_source(order_SourceReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmRes order_pay_confirm(net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmReq order_Pay_ConfirmReq) throws java.rmi.RemoteException{
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl.order_pay_confirm(order_Pay_ConfirmReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Order_ListRes order_list(net.zhinet.travel.pojo.reqandrespojo.Order_ListReq order_ListReq) throws java.rmi.RemoteException{
    if (orderManageImpl == null)
      _initOrderManageImplProxy();
    return orderManageImpl.order_list(order_ListReq);
  }
  
  
}