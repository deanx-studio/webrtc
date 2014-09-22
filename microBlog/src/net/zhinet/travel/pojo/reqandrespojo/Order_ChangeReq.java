/**
 * Order_ChangeReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Order_ChangeReq  implements java.io.Serializable {
    private java.lang.String changeReason;

    private java.util.Calendar currentPlayDate;

    private java.util.Calendar newPlayDate;

    private java.lang.String orderId;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    public Order_ChangeReq() {
    }

    public Order_ChangeReq(
           java.lang.String changeReason,
           java.util.Calendar currentPlayDate,
           java.util.Calendar newPlayDate,
           java.lang.String orderId,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
           this.changeReason = changeReason;
           this.currentPlayDate = currentPlayDate;
           this.newPlayDate = newPlayDate;
           this.orderId = orderId;
           this.requestHead = requestHead;
    }


    /**
     * Gets the changeReason value for this Order_ChangeReq.
     * 
     * @return changeReason
     */
    public java.lang.String getChangeReason() {
        return changeReason;
    }


    /**
     * Sets the changeReason value for this Order_ChangeReq.
     * 
     * @param changeReason
     */
    public void setChangeReason(java.lang.String changeReason) {
        this.changeReason = changeReason;
    }


    /**
     * Gets the currentPlayDate value for this Order_ChangeReq.
     * 
     * @return currentPlayDate
     */
    public java.util.Calendar getCurrentPlayDate() {
        return currentPlayDate;
    }


    /**
     * Sets the currentPlayDate value for this Order_ChangeReq.
     * 
     * @param currentPlayDate
     */
    public void setCurrentPlayDate(java.util.Calendar currentPlayDate) {
        this.currentPlayDate = currentPlayDate;
    }


    /**
     * Gets the newPlayDate value for this Order_ChangeReq.
     * 
     * @return newPlayDate
     */
    public java.util.Calendar getNewPlayDate() {
        return newPlayDate;
    }


    /**
     * Sets the newPlayDate value for this Order_ChangeReq.
     * 
     * @param newPlayDate
     */
    public void setNewPlayDate(java.util.Calendar newPlayDate) {
        this.newPlayDate = newPlayDate;
    }


    /**
     * Gets the orderId value for this Order_ChangeReq.
     * 
     * @return orderId
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this Order_ChangeReq.
     * 
     * @param orderId
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the requestHead value for this Order_ChangeReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this Order_ChangeReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_ChangeReq)) return false;
        Order_ChangeReq other = (Order_ChangeReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.changeReason==null && other.getChangeReason()==null) || 
             (this.changeReason!=null &&
              this.changeReason.equals(other.getChangeReason()))) &&
            ((this.currentPlayDate==null && other.getCurrentPlayDate()==null) || 
             (this.currentPlayDate!=null &&
              this.currentPlayDate.equals(other.getCurrentPlayDate()))) &&
            ((this.newPlayDate==null && other.getNewPlayDate()==null) || 
             (this.newPlayDate!=null &&
              this.newPlayDate.equals(other.getNewPlayDate()))) &&
            ((this.orderId==null && other.getOrderId()==null) || 
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
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
        if (getChangeReason() != null) {
            _hashCode += getChangeReason().hashCode();
        }
        if (getCurrentPlayDate() != null) {
            _hashCode += getCurrentPlayDate().hashCode();
        }
        if (getNewPlayDate() != null) {
            _hashCode += getNewPlayDate().hashCode();
        }
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
        }
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_ChangeReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Order_ChangeReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "changeReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentPlayDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currentPlayDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newPlayDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newPlayDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
