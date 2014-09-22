/**
 * RechargeConfirmReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class RechargeConfirmReq  implements java.io.Serializable {
    private java.lang.String rechargeId;

    private int rechargeMoney;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    public RechargeConfirmReq() {
    }

    public RechargeConfirmReq(
           java.lang.String rechargeId,
           int rechargeMoney,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
           this.rechargeId = rechargeId;
           this.rechargeMoney = rechargeMoney;
           this.requestHead = requestHead;
    }


    /**
     * Gets the rechargeId value for this RechargeConfirmReq.
     * 
     * @return rechargeId
     */
    public java.lang.String getRechargeId() {
        return rechargeId;
    }


    /**
     * Sets the rechargeId value for this RechargeConfirmReq.
     * 
     * @param rechargeId
     */
    public void setRechargeId(java.lang.String rechargeId) {
        this.rechargeId = rechargeId;
    }


    /**
     * Gets the rechargeMoney value for this RechargeConfirmReq.
     * 
     * @return rechargeMoney
     */
    public int getRechargeMoney() {
        return rechargeMoney;
    }


    /**
     * Sets the rechargeMoney value for this RechargeConfirmReq.
     * 
     * @param rechargeMoney
     */
    public void setRechargeMoney(int rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }


    /**
     * Gets the requestHead value for this RechargeConfirmReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this RechargeConfirmReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RechargeConfirmReq)) return false;
        RechargeConfirmReq other = (RechargeConfirmReq) obj;
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
            this.rechargeMoney == other.getRechargeMoney() &&
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead())));
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
        _hashCode += getRechargeMoney();
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RechargeConfirmReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "RechargeConfirmReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rechargeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rechargeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rechargeMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rechargeMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
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
