/**
 * MarketActiveImplSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class MarketActiveImplSoapBindingStub extends org.apache.axis.client.Stub implements net.zhinet.travel.inf.impl.MarketActiveImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("view_comment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "view_CommentReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_CommentReq"), net.zhinet.travel.pojo.reqandrespojo.View_CommentReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_CommentRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.View_CommentRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "view_commentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("city_comment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "city_CommentReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_CommentReq"), net.zhinet.travel.pojo.reqandrespojo.City_CommentReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_CommentRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.City_CommentRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "city_commentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("city_topten");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "city_ToptenReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ToptenReq"), net.zhinet.travel.pojo.reqandrespojo.City_ToptenReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ToptenRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "city_toptenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("view_topten");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "view_ToptenReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ToptenReq"), net.zhinet.travel.pojo.reqandrespojo.View_ToptenReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ToptenRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "view_toptenReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

    }

    public MarketActiveImplSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MarketActiveImplSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MarketActiveImplSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "CityInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.CityInfo.class;
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

            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ScenicInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ScenicInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "TicketInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.TicketInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_CityInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.CityInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "CityInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_ScenicInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ScenicInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ScenicInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_TicketInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.TicketInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "TicketInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_CommentReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_CommentReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_CommentRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_CommentRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ToptenReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_ToptenReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ToptenRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_CommentReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_CommentReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_CommentRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_CommentRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ToptenReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_ToptenReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ToptenRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes.class;
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

    public net.zhinet.travel.pojo.reqandrespojo.View_CommentRes view_comment(net.zhinet.travel.pojo.reqandrespojo.View_CommentReq view_CommentReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "view_comment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {view_CommentReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.View_CommentRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.View_CommentRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.View_CommentRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.City_CommentRes city_comment(net.zhinet.travel.pojo.reqandrespojo.City_CommentReq city_CommentReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "city_comment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {city_CommentReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.City_CommentRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.City_CommentRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.City_CommentRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes city_topten(net.zhinet.travel.pojo.reqandrespojo.City_ToptenReq city_ToptenReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "city_topten"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {city_ToptenReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.City_ToptenRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes view_topten(net.zhinet.travel.pojo.reqandrespojo.View_ToptenReq view_ToptenReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "view_topten"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {view_ToptenReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.View_ToptenRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
