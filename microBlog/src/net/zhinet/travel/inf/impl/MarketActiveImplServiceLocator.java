/**
 * MarketActiveImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class MarketActiveImplServiceLocator extends org.apache.axis.client.Service implements net.zhinet.travel.inf.impl.MarketActiveImplService {

    public MarketActiveImplServiceLocator() {
    }


    public MarketActiveImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MarketActiveImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MarketActiveImpl
    private java.lang.String MarketActiveImpl_address = "http://192.168.1.33:8080/travel-interface/services/MarketActiveImpl";

    public java.lang.String getMarketActiveImplAddress() {
        return MarketActiveImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MarketActiveImplWSDDServiceName = "MarketActiveImpl";

    public java.lang.String getMarketActiveImplWSDDServiceName() {
        return MarketActiveImplWSDDServiceName;
    }

    public void setMarketActiveImplWSDDServiceName(java.lang.String name) {
        MarketActiveImplWSDDServiceName = name;
    }

    public net.zhinet.travel.inf.impl.MarketActiveImpl getMarketActiveImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MarketActiveImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMarketActiveImpl(endpoint);
    }

    public net.zhinet.travel.inf.impl.MarketActiveImpl getMarketActiveImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.zhinet.travel.inf.impl.MarketActiveImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.MarketActiveImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getMarketActiveImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMarketActiveImplEndpointAddress(java.lang.String address) {
        MarketActiveImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.zhinet.travel.inf.impl.MarketActiveImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                net.zhinet.travel.inf.impl.MarketActiveImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.MarketActiveImplSoapBindingStub(new java.net.URL(MarketActiveImpl_address), this);
                _stub.setPortName(getMarketActiveImplWSDDServiceName());
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
        if ("MarketActiveImpl".equals(inputPortName)) {
            return getMarketActiveImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "MarketActiveImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "MarketActiveImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MarketActiveImpl".equals(portName)) {
            setMarketActiveImplEndpointAddress(address);
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
