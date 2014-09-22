/**
 * Province_ListRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Province_ListRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.ContentInfo[] provinceInfos;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    public Province_ListRes() {
    }

    public Province_ListRes(
           net.zhinet.travel.pojo.basepojo.ContentInfo[] provinceInfos,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
           this.provinceInfos = provinceInfos;
           this.responseHead = responseHead;
    }


    /**
     * Gets the provinceInfos value for this Province_ListRes.
     * 
     * @return provinceInfos
     */
    public net.zhinet.travel.pojo.basepojo.ContentInfo[] getProvinceInfos() {
        return provinceInfos;
    }


    /**
     * Sets the provinceInfos value for this Province_ListRes.
     * 
     * @param provinceInfos
     */
    public void setProvinceInfos(net.zhinet.travel.pojo.basepojo.ContentInfo[] provinceInfos) {
        this.provinceInfos = provinceInfos;
    }


    /**
     * Gets the responseHead value for this Province_ListRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this Province_ListRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Province_ListRes)) return false;
        Province_ListRes other = (Province_ListRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.provinceInfos==null && other.getProvinceInfos()==null) || 
             (this.provinceInfos!=null &&
              java.util.Arrays.equals(this.provinceInfos, other.getProvinceInfos()))) &&
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
        if (getProvinceInfos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProvinceInfos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProvinceInfos(), i);
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
        new org.apache.axis.description.TypeDesc(Province_ListRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Province_ListRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceInfos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceInfos"));
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
