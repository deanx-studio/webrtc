/**
 * PriceDef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class PriceDef  implements java.io.Serializable {
    private java.lang.String date;

    private int distributePrice;

    private int marketPrice;

    private int remainNum;

    private int salePrice;

    private int stockPrice;

    public PriceDef() {
    }

    public PriceDef(
           java.lang.String date,
           int distributePrice,
           int marketPrice,
           int remainNum,
           int salePrice,
           int stockPrice) {
           this.date = date;
           this.distributePrice = distributePrice;
           this.marketPrice = marketPrice;
           this.remainNum = remainNum;
           this.salePrice = salePrice;
           this.stockPrice = stockPrice;
    }


    /**
     * Gets the date value for this PriceDef.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this PriceDef.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the distributePrice value for this PriceDef.
     * 
     * @return distributePrice
     */
    public int getDistributePrice() {
        return distributePrice;
    }


    /**
     * Sets the distributePrice value for this PriceDef.
     * 
     * @param distributePrice
     */
    public void setDistributePrice(int distributePrice) {
        this.distributePrice = distributePrice;
    }


    /**
     * Gets the marketPrice value for this PriceDef.
     * 
     * @return marketPrice
     */
    public int getMarketPrice() {
        return marketPrice;
    }


    /**
     * Sets the marketPrice value for this PriceDef.
     * 
     * @param marketPrice
     */
    public void setMarketPrice(int marketPrice) {
        this.marketPrice = marketPrice;
    }


    /**
     * Gets the remainNum value for this PriceDef.
     * 
     * @return remainNum
     */
    public int getRemainNum() {
        return remainNum;
    }


    /**
     * Sets the remainNum value for this PriceDef.
     * 
     * @param remainNum
     */
    public void setRemainNum(int remainNum) {
        this.remainNum = remainNum;
    }


    /**
     * Gets the salePrice value for this PriceDef.
     * 
     * @return salePrice
     */
    public int getSalePrice() {
        return salePrice;
    }


    /**
     * Sets the salePrice value for this PriceDef.
     * 
     * @param salePrice
     */
    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }


    /**
     * Gets the stockPrice value for this PriceDef.
     * 
     * @return stockPrice
     */
    public int getStockPrice() {
        return stockPrice;
    }


    /**
     * Sets the stockPrice value for this PriceDef.
     * 
     * @param stockPrice
     */
    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PriceDef)) return false;
        PriceDef other = (PriceDef) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            this.distributePrice == other.getDistributePrice() &&
            this.marketPrice == other.getMarketPrice() &&
            this.remainNum == other.getRemainNum() &&
            this.salePrice == other.getSalePrice() &&
            this.stockPrice == other.getStockPrice();
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
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        _hashCode += getDistributePrice();
        _hashCode += getMarketPrice();
        _hashCode += getRemainNum();
        _hashCode += getSalePrice();
        _hashCode += getStockPrice();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PriceDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "PriceDef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distributePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marketPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "marketPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remainNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remainNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stockPrice"));
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
