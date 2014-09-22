package net.zhinet.travel.inf.impl;

public class MediaResourcesImplProxy implements net.zhinet.travel.inf.impl.MediaResourcesImpl {
  private String _endpoint = null;
  private net.zhinet.travel.inf.impl.MediaResourcesImpl mediaResourcesImpl = null;
  
  public MediaResourcesImplProxy() {
    _initMediaResourcesImplProxy();
  }
  
  public MediaResourcesImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initMediaResourcesImplProxy();
  }
  
  private void _initMediaResourcesImplProxy() {
    try {
      mediaResourcesImpl = (new net.zhinet.travel.inf.impl.MediaResourcesImplServiceLocator()).getMediaResourcesImpl();
      if (mediaResourcesImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mediaResourcesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mediaResourcesImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mediaResourcesImpl != null)
      ((javax.xml.rpc.Stub)mediaResourcesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.zhinet.travel.inf.impl.MediaResourcesImpl getMediaResourcesImpl() {
    if (mediaResourcesImpl == null)
      _initMediaResourcesImplProxy();
    return mediaResourcesImpl;
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes doc_list(net.zhinet.travel.pojo.reqandrespojo.Doc_ListReq doc_ListReq) throws java.rmi.RemoteException{
    if (mediaResourcesImpl == null)
      _initMediaResourcesImplProxy();
    return mediaResourcesImpl.doc_list(doc_ListReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.Media_ListRes media_list(net.zhinet.travel.pojo.reqandrespojo.Media_ListReq media_ListReq) throws java.rmi.RemoteException{
    if (mediaResourcesImpl == null)
      _initMediaResourcesImplProxy();
    return mediaResourcesImpl.media_list(media_ListReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes get_doc(net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoReq contentInfoReq) throws java.rmi.RemoteException{
    if (mediaResourcesImpl == null)
      _initMediaResourcesImplProxy();
    return mediaResourcesImpl.get_doc(contentInfoReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes general_doc_list(net.zhinet.travel.pojo.reqandrespojo.SpecificMediumReq mediumReq) throws java.rmi.RemoteException{
    if (mediaResourcesImpl == null)
      _initMediaResourcesImplProxy();
    return mediaResourcesImpl.general_doc_list(mediumReq);
  }
  
  public net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes get_view_detail(net.zhinet.travel.pojo.reqandrespojo.ViewDetailReq viewDetailReq) throws java.rmi.RemoteException{
    if (mediaResourcesImpl == null)
      _initMediaResourcesImplProxy();
    return mediaResourcesImpl.get_view_detail(viewDetailReq);
  }
  
  
}