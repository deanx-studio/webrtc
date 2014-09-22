/**
 * MediaResourcesImplSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class MediaResourcesImplSoapBindingStub extends org.apache.axis.client.Stub implements net.zhinet.travel.inf.impl.MediaResourcesImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doc_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "doc_ListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Doc_ListReq"), net.zhinet.travel.pojo.reqandrespojo.Doc_ListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Doc_ListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doc_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("media_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "media_ListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Media_ListReq"), net.zhinet.travel.pojo.reqandrespojo.Media_ListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Media_ListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Media_ListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "media_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_doc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contentInfoReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificContentInfoReq"), net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificContentInfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_docReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("general_doc_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mediumReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificMediumReq"), net.zhinet.travel.pojo.reqandrespojo.SpecificMediumReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificMediumRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "general_doc_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_view_detail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "viewDetailReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailReq"), net.zhinet.travel.pojo.reqandrespojo.ViewDetailReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_view_detailReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

    }

    public MediaResourcesImplSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MediaResourcesImplSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MediaResourcesImplSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ContentInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ContentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.RequestHead.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ResponseHead.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns1_ViewDetailInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ViewDetailInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_ContentInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ContentInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ContentInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Doc_ListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Doc_ListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Doc_ListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Media_ListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Media_ListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Media_ListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Media_ListRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificContentInfoReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificContentInfoRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificMediumReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.SpecificMediumReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificMediumRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ViewDetailInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ViewDetailReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes doc_list(net.zhinet.travel.pojo.reqandrespojo.Doc_ListReq doc_ListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "doc_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {doc_ListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Doc_ListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Media_ListRes media_list(net.zhinet.travel.pojo.reqandrespojo.Media_ListReq media_ListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "media_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {media_ListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Media_ListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Media_ListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Media_ListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes get_doc(net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoReq contentInfoReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "get_doc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {contentInfoReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.SpecificContentInfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes general_doc_list(net.zhinet.travel.pojo.reqandrespojo.SpecificMediumReq mediumReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "general_doc_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {mediumReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.SpecificMediumRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes get_view_detail(net.zhinet.travel.pojo.reqandrespojo.ViewDetailReq viewDetailReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "get_view_detail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {viewDetailReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
