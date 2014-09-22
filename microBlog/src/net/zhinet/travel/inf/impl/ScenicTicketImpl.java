/**
 * ScenicTicketImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public interface ScenicTicketImpl extends java.rmi.Remote {
    public net.zhinet.travel.pojo.reqandrespojo.View_InfoRes view_info(net.zhinet.travel.pojo.reqandrespojo.View_InfoReq view_InfoReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.View_InfoRes view_catalog(net.zhinet.travel.pojo.reqandrespojo.View_CatalogReq view_CatalogReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_info(net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoReq ticket_InfoReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes catalog_info(net.zhinet.travel.pojo.reqandrespojo.CatalogListReq catalogListReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes priceCanledar(net.zhinet.travel.pojo.reqandrespojo.PriceCanledarReq priceCanledarReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_detail(net.zhinet.travel.pojo.reqandrespojo.Ticket_DetailReq ticket_DetailReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_catalog(net.zhinet.travel.pojo.reqandrespojo.Ticket_CatalogReq ticket_catalogReq) throws java.rmi.RemoteException;
}
