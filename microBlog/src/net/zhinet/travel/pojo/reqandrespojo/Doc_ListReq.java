/**
 * Doc_ListReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Doc_ListReq  implements java.io.Serializable {
    private java.lang.String cityName;

    private java.lang.String provinceName;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private int scenicId;

    public Doc_ListReq() {
    }

    public Doc_ListReq(
           java.lang.String cityName,
           java.lang.String provinceName,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           int scenicId) {
           this.cityName = cityName;
           this.provinceName = provinceName;
           this.requestHead = requestHead;
           this.scenicId = scenicId;
    }


    /**
     * Gets the cityName value for this Doc_ListReq.
     * 
     * @return cityName
     */
    public java.lang.String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this Doc_ListReq.
     * 
     * @param cityName
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the provinceName value for this Doc_ListReq.
     * 
     * @return provinceName
     */
    public java.lang.String getProvinceName() {
        return provinceName;
    }


    /**
     * Sets the provinceName value for this Doc_ListReq.
     * 
     * @param provinceName
     */
    public void setProvinceName(java.lang.String provinceName) {
        this.provinceName = provinceName;
    }


    /**
     * Gets the requestHead value for this Doc_ListReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this Doc_ListReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the scenicId value for this Doc_ListReq.
     * 
     * @return scenicId
     */
    public int getScenicId() {
        return scenicId;
    }


    /**
     * Sets the scenicId value for this Doc_ListReq.
     * 
     * @param scenicId
     */
    public void setScenicId(int scenicId) {
        this.scenicId = scenicId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Doc_ListReq)) return false;
        Doc_ListReq other = (Doc_ListReq) obj;
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
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
            this.scenicId == other.getScenicId();
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
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        _hashCode += getScenicId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Doc_ListReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Doc_ListReq"));
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
        elemField.setFieldName("requestHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicId"));
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
