/**
 * View_ListReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class View_ListReq  implements java.io.Serializable {
    private java.lang.String cityName;

    private int pageCount;

    private int pageNo;

    private java.lang.String provinceName;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    public View_ListReq() {
    }

    public View_ListReq(
           java.lang.String cityName,
           int pageCount,
           int pageNo,
           java.lang.String provinceName,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
           this.cityName = cityName;
           this.pageCount = pageCount;
           this.pageNo = pageNo;
           this.provinceName = provinceName;
           this.requestHead = requestHead;
    }


    /**
     * Gets the cityName value for this View_ListReq.
     * 
     * @return cityName
     */
    public java.lang.String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this View_ListReq.
     * 
     * @param cityName
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the pageCount value for this View_ListReq.
     * 
     * @return pageCount
     */
    public int getPageCount() {
        return pageCount;
    }


    /**
     * Sets the pageCount value for this View_ListReq.
     * 
     * @param pageCount
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    /**
     * Gets the pageNo value for this View_ListReq.
     * 
     * @return pageNo
     */
    public int getPageNo() {
        return pageNo;
    }


    /**
     * Sets the pageNo value for this View_ListReq.
     * 
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }


    /**
     * Gets the provinceName value for this View_ListReq.
     * 
     * @return provinceName
     */
    public java.lang.String getProvinceName() {
        return provinceName;
    }


    /**
     * Sets the provinceName value for this View_ListReq.
     * 
     * @param provinceName
     */
    public void setProvinceName(java.lang.String provinceName) {
        this.provinceName = provinceName;
    }


    /**
     * Gets the requestHead value for this View_ListReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this View_ListReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_ListReq)) return false;
        View_ListReq other = (View_ListReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cityName==null && other.getCityName()==null) || 
             (this.cityName!=null &&
              this.cityName.equals(other.getCityName()))) &&
            this.pageCount == other.getPageCount() &&
            this.pageNo == other.getPageNo() &&
            ((this.provinceName==null && other.getProvinceName()==null) || 
             (this.provinceName!=null &&
              this.provinceName.equals(other.getProvinceName()))) &&
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
        if (getCityName() != null) {
            _hashCode += getCityName().hashCode();
        }
        _hashCode += getPageCount();
        _hashCode += getPageNo();
        if (getProvinceName() != null) {
            _hashCode += getProvinceName().hashCode();
        }
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(View_ListReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ListReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceName"));
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
