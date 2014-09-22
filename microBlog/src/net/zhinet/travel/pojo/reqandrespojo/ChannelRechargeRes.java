/**
 * ChannelRechargeRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class ChannelRechargeRes  implements java.io.Serializable {
    private java.lang.String rechargeId;

    private java.lang.String rechargeUrl;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    private int status;

    public ChannelRechargeRes() {
    }

    public ChannelRechargeRes(
           java.lang.String rechargeId,
           java.lang.String rechargeUrl,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead,
           int status) {
           this.rechargeId = rechargeId;
           this.rechargeUrl = rechargeUrl;
           this.responseHead = responseHead;
           this.status = status;
    }


    /**
     * Gets the rechargeId value for this ChannelRechargeRes.
     * 
     * @return rechargeId
     */
    public java.lang.String getRechargeId() {
        return rechargeId;
    }


    /**
     * Sets the rechargeId value for this ChannelRechargeRes.
     * 
     * @param rechargeId
     */
    public void setRechargeId(java.lang.String rechargeId) {
        this.rechargeId = rechargeId;
    }


    /**
     * Gets the rechargeUrl value for this ChannelRechargeRes.
     * 
     * @return rechargeUrl
     */
    public java.lang.String getRechargeUrl() {
        return rechargeUrl;
    }


    /**
     * Sets the rechargeUrl value for this ChannelRechargeRes.
     * 
     * @param rechargeUrl
     */
    public void setRechargeUrl(java.lang.String rechargeUrl) {
        this.rechargeUrl = rechargeUrl;
    }


    /**
     * Gets the responseHead value for this ChannelRechargeRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this ChannelRechargeRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }


    /**
     * Gets the status value for this ChannelRechargeRes.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ChannelRechargeRes.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChannelRechargeRes)) return false;
        ChannelRechargeRes other = (ChannelRechargeRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rechargeId==null && other.getRechargeId()==null) || 
             (this.rechargeId!=null &&
              this.rechargeId.equals(other.getRechargeId()))) &&
            ((this.rechargeUrl==null && other.getRechargeUrl()==null) || 
             (this.rechargeUrl!=null &&
              this.rechargeUrl.equals(other.getRechargeUrl()))) &&
            ((this.responseHead==null && other.getResponseHead()==null) || 
             (this.responseHead!=null &&
              this.responseHead.equals(other.getResponseHead()))) &&
            this.status == other.getStatus();
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
        if (getRechargeId() != null) {
            _hashCode += getRechargeId().hashCode();
        }
        if (getRechargeUrl() != null) {
            _hashCode += getRechargeUrl().hashCode();
        }
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        _hashCode += getStatus();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChannelRechargeRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelRechargeRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rechargeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rechargeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rechargeUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rechargeUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
