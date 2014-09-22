/**
 * MediaResourcesImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class MediaResourcesImplServiceLocator extends org.apache.axis.client.Service implements net.zhinet.travel.inf.impl.MediaResourcesImplService {

    public MediaResourcesImplServiceLocator() {
    }


    public MediaResourcesImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MediaResourcesImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MediaResourcesImpl
    private java.lang.String MediaResourcesImpl_address = "http://192.168.1.101:8080/travel-interface/services/MediaResourcesImpl";

    public java.lang.String getMediaResourcesImplAddress() {
        return MediaResourcesImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MediaResourcesImplWSDDServiceName = "MediaResourcesImpl";

    public java.lang.String getMediaResourcesImplWSDDServiceName() {
        return MediaResourcesImplWSDDServiceName;
    }

    public void setMediaResourcesImplWSDDServiceName(java.lang.String name) {
        MediaResourcesImplWSDDServiceName = name;
    }

    public net.zhinet.travel.inf.impl.MediaResourcesImpl getMediaResourcesImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MediaResourcesImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMediaResourcesImpl(endpoint);
    }

    public net.zhinet.travel.inf.impl.MediaResourcesImpl getMediaResourcesImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.zhinet.travel.inf.impl.MediaResourcesImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.MediaResourcesImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getMediaResourcesImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMediaResourcesImplEndpointAddress(java.lang.String address) {
        MediaResourcesImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.zhinet.travel.inf.impl.MediaResourcesImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                net.zhinet.travel.inf.impl.MediaResourcesImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.MediaResourcesImplSoapBindingStub(new java.net.URL(MediaResourcesImpl_address), this);
                _stub.setPortName(getMediaResourcesImplWSDDServiceName());
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
        if ("MediaResourcesImpl".equals(inputPortName)) {
            return getMediaResourcesImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "MediaResourcesImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "MediaResourcesImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MediaResourcesImpl".equals(portName)) {
            setMediaResourcesImplEndpointAddress(address);
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
