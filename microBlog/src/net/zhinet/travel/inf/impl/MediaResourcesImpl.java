/**
 * MediaResourcesImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public interface MediaResourcesImpl extends java.rmi.Remote {
    public net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes doc_list(net.zhinet.travel.pojo.reqandrespojo.Doc_ListReq doc_ListReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.Media_ListRes media_list(net.zhinet.travel.pojo.reqandrespojo.Media_ListReq media_ListReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes get_doc(net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoReq contentInfoReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes general_doc_list(net.zhinet.travel.pojo.reqandrespojo.SpecificMediumReq mediumReq) throws java.rmi.RemoteException;
    public net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes get_view_detail(net.zhinet.travel.pojo.reqandrespojo.ViewDetailReq viewDetailReq) throws java.rmi.RemoteException;
}
