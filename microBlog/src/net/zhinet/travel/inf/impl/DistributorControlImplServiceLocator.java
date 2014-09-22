/**
 * DistributorControlImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class DistributorControlImplServiceLocator extends org.apache.axis.client.Service implements net.zhinet.travel.inf.impl.DistributorControlImplService {

    public DistributorControlImplServiceLocator() {
    }


    public DistributorControlImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DistributorControlImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DistributorControlImpl
    private java.lang.String DistributorControlImpl_address = "http://192.168.1.145:9090/travel-interface/services/DistributorControlImpl";

    public java.lang.String getDistributorControlImplAddress() {
        return DistributorControlImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DistributorControlImplWSDDServiceName = "DistributorControlImpl";

    public java.lang.String getDistributorControlImplWSDDServiceName() {
        return DistributorControlImplWSDDServiceName;
    }

    public void setDistributorControlImplWSDDServiceName(java.lang.String name) {
        DistributorControlImplWSDDServiceName = name;
    }

    public net.zhinet.travel.inf.impl.DistributorControlImpl getDistributorControlImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DistributorControlImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDistributorControlImpl(endpoint);
    }

    public net.zhinet.travel.inf.impl.DistributorControlImpl getDistributorControlImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.zhinet.travel.inf.impl.DistributorControlImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.DistributorControlImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getDistributorControlImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDistributorControlImplEndpointAddress(java.lang.String address) {
        DistributorControlImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.zhinet.travel.inf.impl.DistributorControlImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                net.zhinet.travel.inf.impl.DistributorControlImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.DistributorControlImplSoapBindingStub(new java.net.URL(DistributorControlImpl_address), this);
                _stub.setPortName(getDistributorControlImplWSDDServiceName());
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
        if ("DistributorControlImpl".equals(inputPortName)) {
            return getDistributorControlImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "DistributorControlImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "DistributorControlImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DistributorControlImpl".equals(portName)) {
            setDistributorControlImplEndpointAddress(address);
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
