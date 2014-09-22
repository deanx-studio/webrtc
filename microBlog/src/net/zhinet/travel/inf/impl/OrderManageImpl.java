/**
 * OrderManageImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public interface OrderManageImpl extends java.rmi.Remote {
    public net.zhinet.travel.pojo.reqandrespojo.Order_ChangeRes order_change(net.zhinet.travel.pojo.reqandrespojo.Order_ChangeReq order_ChangeReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.basepojo.ResponseHead order_cancel(net.zhinet.travel.pojo.reqandrespojo.Order_CancelReq order_CancelReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Order_CreateRes order_create(net.zhinet.travel.pojo.reqandrespojo.Order_CreateReq order_CreateReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Order_SourceRes order_source(net.zhinet.travel.pojo.reqandrespojo.Order_SoureReq order_SourceReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmRes order_pay_confirm(net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmReq order_Pay_ConfirmReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Order_ListRes order_list(net.zhinet.travel.pojo.reqandrespojo.Order_ListReq order_ListReq) throws java.rmi.RemoteException;
}
