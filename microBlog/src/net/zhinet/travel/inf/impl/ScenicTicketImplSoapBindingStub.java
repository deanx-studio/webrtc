/**
 * ScenicTicketImplSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class ScenicTicketImplSoapBindingStub extends org.apache.axis.client.Stub implements net.zhinet.travel.inf.impl.ScenicTicketImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("view_info");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "view_InfoReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_InfoReq"), net.zhinet.travel.pojo.reqandrespojo.View_InfoReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_InfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.View_InfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "view_infoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("view_catalog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "view_CatalogReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_CatalogReq"), net.zhinet.travel.pojo.reqandrespojo.View_CatalogReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_InfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.View_InfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "view_catalogReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ticket_info");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ticket_InfoReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoReq"), net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ticket_infoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("catalog_info");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "catalogListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "CatalogListReq"), net.zhinet.travel.pojo.reqandrespojo.CatalogListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Catalog_InfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "catalog_infoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("priceCanledar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "priceCanledarReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceCanledarReq"), net.zhinet.travel.pojo.reqandrespojo.PriceCanledarReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceCanledarRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "priceCanledarReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ticket_detail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ticket_DetailReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_DetailReq"), net.zhinet.travel.pojo.reqandrespojo.Ticket_DetailReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ticket_detailReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ticket_catalog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ticket_catalogReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_CatalogReq"), net.zhinet.travel.pojo.reqandrespojo.Ticket_CatalogReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ticket_catalogReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

    }

    public ScenicTicketImplSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ScenicTicketImplSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ScenicTicketImplSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "CatalogDef");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.CatalogDef.class;
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

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns1_PriceDef");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.PriceDef[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceDef");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_CatalogDef");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.CatalogDef[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "CatalogDef");
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

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Catalog_InfoRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "CatalogListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.CatalogListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceCanledarReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.PriceCanledarReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceCanledarRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceDef");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.PriceDef.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_CatalogReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Ticket_CatalogReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_DetailReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Ticket_DetailReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_CatalogReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_CatalogReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_InfoReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_InfoReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_InfoRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.View_InfoRes.class;
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

    public net.zhinet.travel.pojo.reqandrespojo.View_InfoRes view_info(net.zhinet.travel.pojo.reqandrespojo.View_InfoReq view_InfoReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "view_info"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {view_InfoReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.View_InfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.View_InfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.View_InfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.View_InfoRes view_catalog(net.zhinet.travel.pojo.reqandrespojo.View_CatalogReq view_CatalogReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "view_catalog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {view_CatalogReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.View_InfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.View_InfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.View_InfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_info(net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoReq ticket_InfoReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ticket_info"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ticket_InfoReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes catalog_info(net.zhinet.travel.pojo.reqandrespojo.CatalogListReq catalogListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "catalog_info"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {catalogListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes priceCanledar(net.zhinet.travel.pojo.reqandrespojo.PriceCanledarReq priceCanledarReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "priceCanledar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {priceCanledarReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_detail(net.zhinet.travel.pojo.reqandrespojo.Ticket_DetailReq ticket_DetailReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ticket_detail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ticket_DetailReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes ticket_catalog(net.zhinet.travel.pojo.reqandrespojo.Ticket_CatalogReq ticket_catalogReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ticket_catalog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ticket_catalogReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
