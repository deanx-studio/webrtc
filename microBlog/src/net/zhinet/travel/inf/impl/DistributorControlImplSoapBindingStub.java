/**
 * DistributorControlImplSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class DistributorControlImplSoapBindingStub extends org.apache.axis.client.Stub implements net.zhinet.travel.inf.impl.DistributorControlImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("my_account");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "requestHead"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"), net.zhinet.travel.pojo.basepojo.RequestHead.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "My_AccountRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.My_AccountRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "my_accountReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("channel_recharge");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "channelRechargeReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelRechargeReq"), net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelRechargeRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "channel_rechargeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("recharge_confirm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "rechargeConfirmReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "RechargeConfirmReq"), net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "RechargeConfirmRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "recharge_confirmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("channel_order_list");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "channelOrderListReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelOrderListReq"), net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelOrderListRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "channel_order_listReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("channel_withdraw_request");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "channelWithdrawReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawReq"), net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "channel_withdraw_requestReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("channel_withdraw_query");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "channelWithdrawQueryReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawQueryReq"), net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawQueryRes"));
        oper.setReturnClass(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "channel_withdraw_queryReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

    }

    public DistributorControlImplSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public DistributorControlImplSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public DistributorControlImplSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "OrderInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.OrderInfo.class;
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

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns1_OrderInfo");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.basepojo.OrderInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "OrderInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "ArrayOf_tns2_ChannelWithdraw");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelWithdraw[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdraw");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelOrderListReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelOrderListRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelRechargeReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelRechargeRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdraw");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelWithdraw.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawQueryReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawQueryRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdrawRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "My_AccountRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.My_AccountRes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "RechargeConfirmReq");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "RechargeConfirmRes");
            cachedSerQNames.add(qName);
            cls = net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes.class;
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

    public net.zhinet.travel.pojo.reqandrespojo.My_AccountRes my_account(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "my_account"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestHead});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.My_AccountRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.My_AccountRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.My_AccountRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes channel_recharge(net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeReq channelRechargeReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "channel_recharge"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {channelRechargeReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.ChannelRechargeRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes recharge_confirm(net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmReq rechargeConfirmReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "recharge_confirm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {rechargeConfirmReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.RechargeConfirmRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes channel_order_list(net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListReq channelOrderListReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "channel_order_list"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {channelOrderListReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.ChannelOrderListRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes channel_withdraw_request(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawReq channelWithdrawReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "channel_withdraw_request"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {channelWithdrawReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes channel_withdraw_query(net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryReq channelWithdrawQueryReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "channel_withdraw_query"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {channelWithdrawQueryReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes) org.apache.axis.utils.JavaUtils.convert(_resp, net.zhinet.travel.pojo.reqandrespojo.ChannelWithdrawQueryRes.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
