/**
 * PriceCanledarRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class PriceCanledarRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.reqandrespojo.PriceDef priceResult;

    private net.zhinet.travel.pojo.reqandrespojo.PriceDef[] prices;

    private int productNo;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    public PriceCanledarRes() {
    }

    public PriceCanledarRes(
           net.zhinet.travel.pojo.reqandrespojo.PriceDef priceResult,
           net.zhinet.travel.pojo.reqandrespojo.PriceDef[] prices,
           int productNo,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
           this.priceResult = priceResult;
           this.prices = prices;
           this.productNo = productNo;
           this.responseHead = responseHead;
    }


    /**
     * Gets the priceResult value for this PriceCanledarRes.
     * 
     * @return priceResult
     */
    public net.zhinet.travel.pojo.reqandrespojo.PriceDef getPriceResult() {
        return priceResult;
    }


    /**
     * Sets the priceResult value for this PriceCanledarRes.
     * 
     * @param priceResult
     */
    public void setPriceResult(net.zhinet.travel.pojo.reqandrespojo.PriceDef priceResult) {
        this.priceResult = priceResult;
    }


    /**
     * Gets the prices value for this PriceCanledarRes.
     * 
     * @return prices
     */
    public net.zhinet.travel.pojo.reqandrespojo.PriceDef[] getPrices() {
        return prices;
    }


    /**
     * Sets the prices value for this PriceCanledarRes.
     * 
     * @param prices
     */
    public void setPrices(net.zhinet.travel.pojo.reqandrespojo.PriceDef[] prices) {
        this.prices = prices;
    }


    /**
     * Gets the productNo value for this PriceCanledarRes.
     * 
     * @return productNo
     */
    public int getProductNo() {
        return productNo;
    }


    /**
     * Sets the productNo value for this PriceCanledarRes.
     * 
     * @param productNo
     */
    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }


    /**
     * Gets the responseHead value for this PriceCanledarRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this PriceCanledarRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PriceCanledarRes)) return false;
        PriceCanledarRes other = (PriceCanledarRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.priceResult==null && other.getPriceResult()==null) || 
             (this.priceResult!=null &&
              this.priceResult.equals(other.getPriceResult()))) &&
            ((this.prices==null && other.getPrices()==null) || 
             (this.prices!=null &&
              java.util.Arrays.equals(this.prices, other.getPrices()))) &&
            this.productNo == other.getProductNo() &&
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
        if (getPriceResult() != null) {
            _hashCode += getPriceResult().hashCode();
        }
        if (getPrices() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrices());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrices(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getProductNo();
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PriceCanledarRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceCanledarRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priceResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "priceResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceDef"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prices");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceDef"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
