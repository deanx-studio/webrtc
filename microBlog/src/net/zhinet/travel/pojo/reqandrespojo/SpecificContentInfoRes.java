/**
 * SpecificContentInfoRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class SpecificContentInfoRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.ContentInfo contentInfo;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    public SpecificContentInfoRes() {
    }

    public SpecificContentInfoRes(
           net.zhinet.travel.pojo.basepojo.ContentInfo contentInfo,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
           this.contentInfo = contentInfo;
           this.responseHead = responseHead;
    }


    /**
     * Gets the contentInfo value for this SpecificContentInfoRes.
     * 
     * @return contentInfo
     */
    public net.zhinet.travel.pojo.basepojo.ContentInfo getContentInfo() {
        return contentInfo;
    }


    /**
     * Sets the contentInfo value for this SpecificContentInfoRes.
     * 
     * @param contentInfo
     */
    public void setContentInfo(net.zhinet.travel.pojo.basepojo.ContentInfo contentInfo) {
        this.contentInfo = contentInfo;
    }


    /**
     * Gets the responseHead value for this SpecificContentInfoRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this SpecificContentInfoRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SpecificContentInfoRes)) return false;
        SpecificContentInfoRes other = (SpecificContentInfoRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contentInfo==null && other.getContentInfo()==null) || 
             (this.contentInfo!=null &&
              this.contentInfo.equals(other.getContentInfo()))) &&
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
        if (getContentInfo() != null) {
            _hashCode += getContentInfo().hashCode();
        }
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SpecificContentInfoRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificContentInfoRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentInfo"));
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
