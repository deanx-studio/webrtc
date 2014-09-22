package net.zhinet.travel.inf.impl;

public class DistributorControlImplProxy implements net.zhinet.travel.inf.impl.DistributorControlImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.DistributorControlImpl distributorControlImpl = null;
  
  public DistributorControlImplProxy() {
    _initDistributorControlImplProxy();
  }
  
  public DistributorControlImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initDistributorControlImplProxy();
  }
  
  private void _initDistributorControlImplProxy() {
    try {
      distributorControlImpl = (new net.zhinet.travel.inf.impl.DistributorControlImplServiceLocator()).getDistributorControlImpl();
      if (distributorControlImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)distributorControlImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)distributorControlImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (distributorControlImpl != null)
      ((javax.xml.rpc.Stub)distributorControlImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.DistributorControlImpl getDistributorControlImpl() {
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.My_AccountRes my_account(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) throws java.rmi.RemoteException{
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl.my_account(requestHead);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes channel_recharge(net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeReq channelRechargeReq) throws java.rmi.RemoteException{
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl.channel_recharge(channelRechargeReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes recharge_confirm(net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmReq rechargeConfirmReq) throws java.rmi.RemoteException{
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl.recharge_confirm(rechargeConfirmReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes channel_order_list(net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListReq channelOrderListReq) throws java.rmi.RemoteException{
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl.channel_order_list(channelOrderListReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes channel_withdraw_request(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawReq channelWithdrawReq) throws java.rmi.RemoteException{
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl.channel_withdraw_request(channelWithdrawReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes channel_withdraw_query(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryReq channelWithdrawQueryReq) throws java.rmi.RemoteException{
    if (distributorControlImpl == null)
      _initDistributorControlImplProxy();
    return distributorControlImpl.channel_withdraw_query(channelWithdrawQueryReq);
  }
  
  
}