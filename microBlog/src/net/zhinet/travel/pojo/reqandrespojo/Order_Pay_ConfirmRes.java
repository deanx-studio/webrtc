/**
 * Order_Pay_ConfirmRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Order_Pay_ConfirmRes  implements java.io.Serializable {
    private java.lang.String orderId;

    private java.lang.String orderMemo;

    private int payState;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    private java.lang.String validateDate;

    public Order_Pay_ConfirmRes() {
    }

    public Order_Pay_ConfirmRes(
           java.lang.String orderId,
           java.lang.String orderMemo,
           int payState,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead,
           java.lang.String validateDate) {
           this.orderId = orderId;
           this.orderMemo = orderMemo;
           this.payState = payState;
           this.responseHead = responseHead;
           this.validateDate = validateDate;
    }


    /**
     * Gets the orderId value for this Order_Pay_ConfirmRes.
     * 
     * @return orderId
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this Order_Pay_ConfirmRes.
     * 
     * @param orderId
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the orderMemo value for this Order_Pay_ConfirmRes.
     * 
     * @return orderMemo
     */
    public java.lang.String getOrderMemo() {
        return orderMemo;
    }


    /**
     * Sets the orderMemo value for this Order_Pay_ConfirmRes.
     * 
     * @param orderMemo
     */
    public void setOrderMemo(java.lang.String orderMemo) {
        this.orderMemo = orderMemo;
    }


    /**
     * Gets the payState value for this Order_Pay_ConfirmRes.
     * 
     * @return payState
     */
    public int getPayState() {
        return payState;
    }


    /**
     * Sets the payState value for this Order_Pay_ConfirmRes.
     * 
     * @param payState
     */
    public void setPayState(int payState) {
        this.payState = payState;
    }


    /**
     * Gets the responseHead value for this Order_Pay_ConfirmRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this Order_Pay_ConfirmRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }


    /**
     * Gets the validateDate value for this Order_Pay_ConfirmRes.
     * 
     * @return validateDate
     */
    public java.lang.String getValidateDate() {
        return validateDate;
    }


    /**
     * Sets the validateDate value for this Order_Pay_ConfirmRes.
     * 
     * @param validateDate
     */
    public void setValidateDate(java.lang.String validateDate) {
        this.validateDate = validateDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_Pay_ConfirmRes)) return false;
        Order_Pay_ConfirmRes other = (Order_Pay_ConfirmRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orderId==null && other.getOrderId()==null) || 
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
            ((this.orderMemo==null && other.getOrderMemo()==null) || 
             (this.orderMemo!=null &&
              this.orderMemo.equals(other.getOrderMemo()))) &&
            this.payState == other.getPayState() &&
            ((this.responseHead==null && other.getResponseHead()==null) || 
             (this.responseHead!=null &&
              this.responseHead.equals(other.getResponseHead()))) &&
            ((this.validateDate==null && other.getValidateDate()==null) || 
             (this.validateDate!=null &&
              this.validateDate.equals(other.getValidateDate())));
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
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
        }
        if (getOrderMemo() != null) {
            _hashCode += getOrderMemo().hashCode();
        }
        _hashCode += getPayState();
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        if (getValidateDate() != null) {
            _hashCode += getValidateDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_Pay_ConfirmRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Order_Pay_ConfirmRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
