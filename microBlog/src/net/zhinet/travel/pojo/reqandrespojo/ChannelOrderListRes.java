/**
 * ChannelOrderListRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class ChannelOrderListRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.OrderInfo[] orderList;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    public ChannelOrderListRes() {
    }

    public ChannelOrderListRes(
           net.zhinet.travel.pojo.basepojo.OrderInfo[] orderList,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
           this.orderList = orderList;
           this.responseHead = responseHead;
    }


    /**
     * Gets the orderList value for this ChannelOrderListRes.
     * 
     * @return orderList
     */
    public net.zhinet.travel.pojo.basepojo.OrderInfo[] getOrderList() {
        return orderList;
    }


    /**
     * Sets the orderList value for this ChannelOrderListRes.
     * 
     * @param orderList
     */
    public void setOrderList(net.zhinet.travel.pojo.basepojo.OrderInfo[] orderList) {
        this.orderList = orderList;
    }


    /**
     * Gets the responseHead value for this ChannelOrderListRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this ChannelOrderListRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChannelOrderListRes)) return false;
        ChannelOrderListRes other = (ChannelOrderListRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orderList==null && other.getOrderList()==null) || 
             (this.orderList!=null &&
              java.util.Arrays.equals(this.orderList, other.getOrderList()))) &&
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
        if (getOrderList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrderList(), i);
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
        new org.apache.axis.description.TypeDesc(ChannelOrderListRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelOrderListRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "OrderInfo"));
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
