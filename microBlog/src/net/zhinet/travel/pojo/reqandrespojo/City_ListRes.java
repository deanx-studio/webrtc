/**
 * City_ListRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class City_ListRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.ContentInfo[] cityInfos;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    public City_ListRes() {
    }

    public City_ListRes(
           net.zhinet.travel.pojo.basepojo.ContentInfo[] cityInfos,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
           this.cityInfos = cityInfos;
           this.responseHead = responseHead;
    }


    /**
     * Gets the cityInfos value for this City_ListRes.
     * 
     * @return cityInfos
     */
    public net.zhinet.travel.pojo.basepojo.ContentInfo[] getCityInfos() {
        return cityInfos;
    }


    /**
     * Sets the cityInfos value for this City_ListRes.
     * 
     * @param cityInfos
     */
    public void setCityInfos(net.zhinet.travel.pojo.basepojo.ContentInfo[] cityInfos) {
        this.cityInfos = cityInfos;
    }


    /**
     * Gets the responseHead value for this City_ListRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this City_ListRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof City_ListRes)) return false;
        City_ListRes other = (City_ListRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cityInfos==null && other.getCityInfos()==null) || 
             (this.cityInfos!=null &&
              java.util.Arrays.equals(this.cityInfos, other.getCityInfos()))) &&
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
        if (getCityInfos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCityInfos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCityInfos(), i);
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
        new org.apache.axis.description.TypeDesc(City_ListRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_ListRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityInfos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityInfos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ContentInfo"));
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
