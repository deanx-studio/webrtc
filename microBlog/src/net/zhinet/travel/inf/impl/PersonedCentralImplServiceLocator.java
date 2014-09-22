/**
 * PersonedCentralImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.inf.impl;

public class PersonedCentralImplServiceLocator extends org.apache.axis.client.Service implements net.zhinet.travel.inf.impl.PersonedCentralImplService {

    public PersonedCentralImplServiceLocator() {
    }


    public PersonedCentralImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonedCentralImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonedCentralImpl
    private java.lang.String PersonedCentralImpl_address = "http://localhost:8080/travel-interface/services/PersonedCentralImpl";

    public java.lang.String getPersonedCentralImplAddress() {
        return PersonedCentralImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonedCentralImplWSDDServiceName = "PersonedCentralImpl";

    public java.lang.String getPersonedCentralImplWSDDServiceName() {
        return PersonedCentralImplWSDDServiceName;
    }

    public void setPersonedCentralImplWSDDServiceName(java.lang.String name) {
        PersonedCentralImplWSDDServiceName = name;
    }

    public net.zhinet.travel.inf.impl.PersonedCentralImpl getPersonedCentralImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonedCentralImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonedCentralImpl(endpoint);
    }

    public net.zhinet.travel.inf.impl.PersonedCentralImpl getPersonedCentralImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.zhinet.travel.inf.impl.PersonedCentralImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.PersonedCentralImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getPersonedCentralImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonedCentralImplEndpointAddress(java.lang.String address) {
        PersonedCentralImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.zhinet.travel.inf.impl.PersonedCentralImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                net.zhinet.travel.inf.impl.PersonedCentralImplSoapBindingStub _stub = new net.zhinet.travel.inf.impl.PersonedCentralImplSoapBindingStub(new java.net.URL(PersonedCentralImpl_address), this);
                _stub.setPortName(getPersonedCentralImplWSDDServiceName());
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
        if ("PersonedCentralImpl".equals(inputPortName)) {
            return getPersonedCentralImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "PersonedCentralImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.inf.travel.zhinet.net", "PersonedCentralImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonedCentralImpl".equals(portName)) {
            setPersonedCentralImplEndpointAddress(address);
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
