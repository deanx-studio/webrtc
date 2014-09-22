/**
 * CityGuideImplSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class CityGuideImplSoapBindingStub extends org.apache.axis.client.Stub implements net.zhinet.travel.inf.impl.CityGuideImpl {
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
        oper.setName("city_actives");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "city_ActivesReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ActivesReq"), net.zhinet.travel.pojo.reqandrespojo.City_ActivesReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ActivesRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "city_activesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("province_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "requestHead"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"), net.zhinet.travel.pojo.basepojo.RequestHead.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Province_ListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Province_ListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "province_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("city_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "city_ListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ListReq"), net.zhinet.travel.pojo.reqandrespojo.City_ListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.City_ListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "city_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("view_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "view_ListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ListReq"), net.zhinet.travel.pojo.reqandrespojo.View_ListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.View_ListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "view_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("tickets_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tickets_ListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Tickets_ListReq"), net.zhinet.travel.pojo.reqandrespojo.Tickets_ListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Tickets_ListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "tickets_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

    }

    public CityGuideImplSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CityGuideImplSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CityGuideImplSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ActiveInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ActiveInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

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

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_ActiveInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.ActiveInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ActiveInfo");
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

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ActivesReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_ActivesReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ActivesRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_ListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.City_ListRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Province_ListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Province_ListRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Tickets_ListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Tickets_ListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Tickets_ListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_ListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_ListRes.class;
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

    public net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes city_actives(net.zhinet.travel.pojo.reqandrespojo.City_ActivesReq city_ActivesReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "city_actives"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {city_ActivesReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.City_ActivesRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Province_ListRes province_list(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "province_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestHead});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Province_ListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Province_ListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Province_ListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.City_ListRes city_list(net.zhinet.travel.pojo.reqandrespojo.City_ListReq city_ListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "city_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {city_ListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.City_ListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.City_ListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.City_ListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.View_ListRes view_list(net.zhinet.travel.pojo.reqandrespojo.View_ListReq view_ListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "view_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {view_ListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.View_ListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.View_ListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.View_ListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes tickets_list(net.zhinet.travel.pojo.reqandrespojo.Tickets_ListReq tickets_ListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "tickets_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {tickets_ListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Tickets_ListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
