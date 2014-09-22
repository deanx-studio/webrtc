/**
 * OrderManageImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class OrderManageImplServiceLocator extends org.apache.axis.client.Service implements net.zhinet.travel.inf.impl.OrderManageImplService {

    public OrderManageImplServiceLocator() {
    }


    public OrderManageImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OrderManageImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OrderManageImpl
    private java.lang.String OrderManageImpl_address = "http://bob8.cn:8080/travel-interface/services/OrderManageImpl";

    public java.lang.String getOrderManageImplAddress() {
        return OrderManageImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OrderManageImplWSDDServiceName = "OrderManageImpl";

    public java.lang.String getOrderManageImplWSDDServiceName() {
        return OrderManageImplWSDDServiceName;
    }

    public void setOrderManageImplWSDDServiceName(java.lang.String name) {
        OrderManageImplWSDDServiceName = name;
    }

    public net.zhinet.travel.inf.impl.OrderManageImpl getOrderManageImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OrderManageImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOrderManageImpl(endpoint);
    }

    public net.zhinet.travel.inf.impl.OrderManageImpl getOrderManageImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.zhinet.travel.inf.impl.OrderManageImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.OrderManageImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getOrderManageImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOrderManageImplEndpointAddress(java.lang.String address) {
        OrderManageImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.zhinet.travel.inf.impl.OrderManageImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                net.zhinet.travel.inf.impl.OrderManageImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.OrderManageImplSoapBindingStub(new java.net.URL(OrderManageImpl_address), this);
                _stub.setPortName(getOrderManageImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("OrderManageImpl".equals(inputPortName)) {
            return getOrderManageImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "OrderManageImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "OrderManageImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OrderManageImpl".equals(portName)) {
            setOrderManageImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
