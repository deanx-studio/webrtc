/**
 * City_ActivesRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class City_ActivesRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.ActiveInfo[] activeInfos;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    public City_ActivesRes() {
    }

    public City_ActivesRes(
           net.zhinet.travel.pojo.basepojo.ActiveInfo[] activeInfos,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
           this.activeInfos = activeInfos;
           this.responseHead = responseHead;
    }


    /**
     * Gets the activeInfos value for this City_ActivesRes.
     * 
     * @return activeInfos
     */
    public net.zhinet.travel.pojo.basepojo.ActiveInfo[] getActiveInfos() {
        return activeInfos;
    }


    /**
     * Sets the activeInfos value for this City_ActivesRes.
     * 
     * @param activeInfos
     */
    public void setActiveInfos(net.zhinet.travel.pojo.basepojo.ActiveInfo[] activeInfos) {
        this.activeInfos = activeInfos;
    }


    /**
     * Gets the responseHead value for this City_ActivesRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this City_ActivesRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof City_ActivesRes)) return false;
        City_ActivesRes other = (City_ActivesRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.activeInfos==null && other.getActiveInfos()==null) || 
             (this.activeInfos!=null &&
              java.util.Arrays.equals(this.activeInfos, other.getActiveInfos()))) &&
            ((this.responseHead==null && other.getResponseHead()==null) || 
             (this.responseHead!=null &&
              this.responseHead.equals(other.getResponseHead())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getActiveInfos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getActiveInfos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActiveInfos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(City_ActivesRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ActivesRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeInfos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeInfos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ActiveInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
