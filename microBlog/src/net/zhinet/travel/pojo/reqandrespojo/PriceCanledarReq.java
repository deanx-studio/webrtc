/**
 * PriceCanledarReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class PriceCanledarReq  implements java.io.Serializable {
    private java.lang.String endTravelDate;

    private int productNo;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private java.lang.String travelDate;

    public PriceCanledarReq() {
    }

    public PriceCanledarReq(
           java.lang.String endTravelDate,
           int productNo,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           java.lang.String travelDate) {
           this.endTravelDate = endTravelDate;
           this.productNo = productNo;
           this.requestHead = requestHead;
           this.travelDate = travelDate;
    }


    /**
     * Gets the endTravelDate value for this PriceCanledarReq.
     * 
     * @return endTravelDate
     */
    public java.lang.String getEndTravelDate() {
        return endTravelDate;
    }


    /**
     * Sets the endTravelDate value for this PriceCanledarReq.
     * 
     * @param endTravelDate
     */
    public void setEndTravelDate(java.lang.String endTravelDate) {
        this.endTravelDate = endTravelDate;
    }


    /**
     * Gets the productNo value for this PriceCanledarReq.
     * 
     * @return productNo
     */
    public int getProductNo() {
        return productNo;
    }


    /**
     * Sets the productNo value for this PriceCanledarReq.
     * 
     * @param productNo
     */
    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }


    /**
     * Gets the requestHead value for this PriceCanledarReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this PriceCanledarReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the travelDate value for this PriceCanledarReq.
     * 
     * @return travelDate
     */
    public java.lang.String getTravelDate() {
        return travelDate;
    }


    /**
     * Sets the travelDate value for this PriceCanledarReq.
     * 
     * @param travelDate
     */
    public void setTravelDate(java.lang.String travelDate) {
        this.travelDate = travelDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PriceCanledarReq)) return false;
        PriceCanledarReq other = (PriceCanledarReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.endTravelDate==null && other.getEndTravelDate()==null) || 
             (this.endTravelDate!=null &&
              this.endTravelDate.equals(other.getEndTravelDate()))) &&
            this.productNo == other.getProductNo() &&
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
            ((this.travelDate==null && other.getTravelDate()==null) || 
             (this.travelDate!=null &&
              this.travelDate.equals(other.getTravelDate())));
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
        if (getEndTravelDate() != null) {
            _hashCode += getEndTravelDate().hashCode();
        }
        _hashCode += getProductNo();
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        if (getTravelDate() != null) {
            _hashCode += getTravelDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PriceCanledarReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceCanledarReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTravelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endTravelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "travelDate"));
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
