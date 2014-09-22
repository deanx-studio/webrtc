/**
 * Order_Pay_ConfirmReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Order_Pay_ConfirmReq  implements java.io.Serializable {
    private java.lang.String orderId;

    private java.lang.String payDate;

    private java.lang.String payMoney;

    private java.lang.String payOrderId;

    private int payType;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    public Order_Pay_ConfirmReq() {
    }

    public Order_Pay_ConfirmReq(
           java.lang.String orderId,
           java.lang.String payDate,
           java.lang.String payMoney,
           java.lang.String payOrderId,
           int payType,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
           this.orderId = orderId;
           this.payDate = payDate;
           this.payMoney = payMoney;
           this.payOrderId = payOrderId;
           this.payType = payType;
           this.requestHead = requestHead;
    }


    /**
     * Gets the orderId value for this Order_Pay_ConfirmReq.
     * 
     * @return orderId
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this Order_Pay_ConfirmReq.
     * 
     * @param orderId
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the payDate value for this Order_Pay_ConfirmReq.
     * 
     * @return payDate
     */
    public java.lang.String getPayDate() {
        return payDate;
    }


    /**
     * Sets the payDate value for this Order_Pay_ConfirmReq.
     * 
     * @param payDate
     */
    public void setPayDate(java.lang.String payDate) {
        this.payDate = payDate;
    }


    /**
     * Gets the payMoney value for this Order_Pay_ConfirmReq.
     * 
     * @return payMoney
     */
    public java.lang.String getPayMoney() {
        return payMoney;
    }


    /**
     * Sets the payMoney value for this Order_Pay_ConfirmReq.
     * 
     * @param payMoney
     */
    public void setPayMoney(java.lang.String payMoney) {
        this.payMoney = payMoney;
    }


    /**
     * Gets the payOrderId value for this Order_Pay_ConfirmReq.
     * 
     * @return payOrderId
     */
    public java.lang.String getPayOrderId() {
        return payOrderId;
    }


    /**
     * Sets the payOrderId value for this Order_Pay_ConfirmReq.
     * 
     * @param payOrderId
     */
    public void setPayOrderId(java.lang.String payOrderId) {
        this.payOrderId = payOrderId;
    }


    /**
     * Gets the payType value for this Order_Pay_ConfirmReq.
     * 
     * @return payType
     */
    public int getPayType() {
        return payType;
    }


    /**
     * Sets the payType value for this Order_Pay_ConfirmReq.
     * 
     * @param payType
     */
    public void setPayType(int payType) {
        this.payType = payType;
    }


    /**
     * Gets the requestHead value for this Order_Pay_ConfirmReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this Order_Pay_ConfirmReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_Pay_ConfirmReq)) return false;
        Order_Pay_ConfirmReq other = (Order_Pay_ConfirmReq) obj;
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
            ((this.payDate==null && other.getPayDate()==null) || 
             (this.payDate!=null &&
              this.payDate.equals(other.getPayDate()))) &&
            ((this.payMoney==null && other.getPayMoney()==null) || 
             (this.payMoney!=null &&
              this.payMoney.equals(other.getPayMoney()))) &&
            ((this.payOrderId==null && other.getPayOrderId()==null) || 
             (this.payOrderId!=null &&
              this.payOrderId.equals(other.getPayOrderId()))) &&
            this.payType == other.getPayType() &&
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
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
        }
        if (getPayDate() != null) {
            _hashCode += getPayDate().hashCode();
        }
        if (getPayMoney() != null) {
            _hashCode += getPayMoney().hashCode();
        }
        if (getPayOrderId() != null) {
            _hashCode += getPayOrderId().hashCode();
        }
        _hashCode += getPayType();
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_Pay_ConfirmReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Order_Pay_ConfirmReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payOrderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payOrderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payType"));
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
