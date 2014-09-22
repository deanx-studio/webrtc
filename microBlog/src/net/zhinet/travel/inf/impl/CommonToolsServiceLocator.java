/**
 * CommonToolsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class CommonToolsServiceLocator extends org.apache.axis.client.Service implements net.zhinet.travel.inf.impl.CommonToolsService {

    public CommonToolsServiceLocator() {
    }


    public CommonToolsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CommonToolsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CommonTools
    private java.lang.String CommonTools_address = "http://bob8.cn:8080/travel-interface/services/CommonTools";

    public java.lang.String getCommonToolsAddress() {
        return CommonTools_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CommonToolsWSDDServiceName = "CommonTools";

    public java.lang.String getCommonToolsWSDDServiceName() {
        return CommonToolsWSDDServiceName;
    }

    public void setCommonToolsWSDDServiceName(java.lang.String name) {
        CommonToolsWSDDServiceName = name;
    }

    public net.zhinet.travel.inf.impl.CommonTools getCommonTools() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CommonTools_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCommonTools(endpoint);
    }

    public net.zhinet.travel.inf.impl.CommonTools getCommonTools(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.zhinet.travel.inf.impl.CommonToolsSoapBindingStub _stub = new net.zhinet.travel.inf.impl.CommonToolsSoapBindingStub(portAddress, this);
            _stub.setPortName(getCommonToolsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCommonToolsEndpointAddress(java.lang.String address) {
        CommonTools_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.zhinet.travel.inf.impl.CommonTools.class.isAssignableFrom(serviceEndpointInterface)) {
                net.zhinet.travel.inf.impl.CommonToolsSoapBindingStub _stub = new net.zhinet.travel.inf.impl.CommonToolsSoapBindingStub(new java.net.URL(CommonTools_address), this);
                _stub.setPortName(getCommonToolsWSDDServiceName());
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
        if ("CommonTools".equals(inputPortName)) {
            return getCommonTools();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "CommonToolsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "CommonTools"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CommonTools".equals(portName)) {
            setCommonToolsEndpointAddress(address);
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
