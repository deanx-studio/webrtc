/**
 * CityGuideImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public interface CityGuideImpl extends java.rmi.Remote {
    public net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes city_actives(net.zhinet.travel.pojo.reqandrespojo.City_ActivesReq city_ActivesReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Province_ListRes province_list(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.City_ListRes city_list(net.zhinet.travel.pojo.reqandrespojo.City_ListReq city_ListReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.View_ListRes view_list(net.zhinet.travel.pojo.reqandrespojo.View_ListReq view_ListReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes tickets_list(net.zhinet.travel.pojo.reqandrespojo.Tickets_ListReq tickets_ListReq) throws java.rmi.RemoteException;
}
