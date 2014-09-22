/**
 * DistributorControlImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public interface DistributorControlImpl extends java.rmi.Remote {
    public net.zhinet.travel.pojo.reqandrespojo.My_AccountRes my_account(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes channel_recharge(net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeReq channelRechargeReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes recharge_confirm(net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmReq rechargeConfirmReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes channel_order_list(net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListReq channelOrderListReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes channel_withdraw_request(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawReq channelWithdrawReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes channel_withdraw_query(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryReq channelWithdrawQueryReq) throws java.rmi.RemoteException;
}
