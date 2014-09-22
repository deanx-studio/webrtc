/**
 * View_ToptenReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class View_ToptenReq  implements java.io.Serializable {
    private java.lang.String cityName;

    private java.lang.String provinceName;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHeader;

    private java.util.Calendar toptenDate;

    public View_ToptenReq() {
    }

    public View_ToptenReq(
           java.lang.String cityName,
           java.lang.String provinceName,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHeader,
           java.util.Calendar toptenDate) {
           this.cityName = cityName;
           this.provinceName = provinceName;
           this.requestHeader = requestHeader;
           this.toptenDate = toptenDate;
    }


    /**
     * Gets the cityName value for this View_ToptenReq.
     * 
     * @return cityName
     */
    public java.lang.String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this View_ToptenReq.
     * 
     * @param cityName
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the provinceName value for this View_ToptenReq.
     * 
     * @return provinceName
     */
    public java.lang.String getProvinceName() {
        return provinceName;
    }


    /**
     * Sets the provinceName value for this View_ToptenReq.
     * 
     * @param provinceName
     */
    public void setProvinceName(java.lang.String provinceName) {
        this.provinceName = provinceName;
    }


    /**
     * Gets the requestHeader value for this View_ToptenReq.
     * 
     * @return requestHeader
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHeader() {
        return requestHeader;
    }


    /**
     * Sets the requestHeader value for this View_ToptenReq.
     * 
     * @param requestHeader
     */
    public void setRequestHeader(net.zhinet.travel.pojo.basepojo.RequestHead requestHeader) {
        this.requestHeader = requestHeader;
    }


    /**
     * Gets the toptenDate value for this View_ToptenReq.
     * 
     * @return toptenDate
     */
    public java.util.Calendar getToptenDate() {
        return toptenDate;
    }


    /**
     * Sets the toptenDate value for this View_ToptenReq.
     * 
     * @param toptenDate
     */
    public void setToptenDate(java.util.Calendar toptenDate) {
        this.toptenDate = toptenDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_ToptenReq)) return false;
        View_ToptenReq other = (View_ToptenReq) obj;
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
            ((this.provinceName==null && other.getProvinceName()==null) || 
             (this.provinceName!=null &&
              this.provinceName.equals(other.getProvinceName()))) &&
            ((this.requestHeader==null && other.getRequestHeader()==null) || 
             (this.requestHeader!=null &&
              this.requestHeader.equals(other.getRequestHeader()))) &&
            ((this.toptenDate==null && other.getToptenDate()==null) || 
             (this.toptenDate!=null &&
              this.toptenDate.equals(other.getToptenDate())));
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
        if (getProvinceName() != null) {
            _hashCode += getProvinceName().hashCode();
        }
        if (getRequestHeader() != null) {
            _hashCode += getRequestHeader().hashCode();
        }
        if (getToptenDate() != null) {
            _hashCode += getToptenDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(View_ToptenReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_ToptenReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestHeader");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestHeader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toptenDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toptenDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
