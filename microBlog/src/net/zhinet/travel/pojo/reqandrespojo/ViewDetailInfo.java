/**
 * ViewDetailInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class ViewDetailInfo  implements java.io.Serializable {
    private java.lang.String PCUrl;

    private int mediaType;

    private java.lang.String pc_text;

    private java.lang.String smartDeviceUrl;

    private java.lang.String smart_text;

    public ViewDetailInfo() {
    }

    public ViewDetailInfo(
           java.lang.String PCUrl,
           int mediaType,
           java.lang.String pc_text,
           java.lang.String smartDeviceUrl,
           java.lang.String smart_text) {
           this.PCUrl = PCUrl;
           this.mediaType = mediaType;
           this.pc_text = pc_text;
           this.smartDeviceUrl = smartDeviceUrl;
           this.smart_text = smart_text;
    }


    /**
     * Gets the PCUrl value for this ViewDetailInfo.
     * 
     * @return PCUrl
     */
    public java.lang.String getPCUrl() {
        return PCUrl;
    }


    /**
     * Sets the PCUrl value for this ViewDetailInfo.
     * 
     * @param PCUrl
     */
    public void setPCUrl(java.lang.String PCUrl) {
        this.PCUrl = PCUrl;
    }


    /**
     * Gets the mediaType value for this ViewDetailInfo.
     * 
     * @return mediaType
     */
    public int getMediaType() {
        return mediaType;
    }


    /**
     * Sets the mediaType value for this ViewDetailInfo.
     * 
     * @param mediaType
     */
    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }


    /**
     * Gets the pc_text value for this ViewDetailInfo.
     * 
     * @return pc_text
     */
    public java.lang.String getPc_text() {
        return pc_text;
    }


    /**
     * Sets the pc_text value for this ViewDetailInfo.
     * 
     * @param pc_text
     */
    public void setPc_text(java.lang.String pc_text) {
        this.pc_text = pc_text;
    }


    /**
     * Gets the smartDeviceUrl value for this ViewDetailInfo.
     * 
     * @return smartDeviceUrl
     */
    public java.lang.String getSmartDeviceUrl() {
        return smartDeviceUrl;
    }


    /**
     * Sets the smartDeviceUrl value for this ViewDetailInfo.
     * 
     * @param smartDeviceUrl
     */
    public void setSmartDeviceUrl(java.lang.String smartDeviceUrl) {
        this.smartDeviceUrl = smartDeviceUrl;
    }


    /**
     * Gets the smart_text value for this ViewDetailInfo.
     * 
     * @return smart_text
     */
    public java.lang.String getSmart_text() {
        return smart_text;
    }


    /**
     * Sets the smart_text value for this ViewDetailInfo.
     * 
     * @param smart_text
     */
    public void setSmart_text(java.lang.String smart_text) {
        this.smart_text = smart_text;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ViewDetailInfo)) return false;
        ViewDetailInfo other = (ViewDetailInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PCUrl==null && other.getPCUrl()==null) || 
             (this.PCUrl!=null &&
              this.PCUrl.equals(other.getPCUrl()))) &&
            this.mediaType == other.getMediaType() &&
            ((this.pc_text==null && other.getPc_text()==null) || 
             (this.pc_text!=null &&
              this.pc_text.equals(other.getPc_text()))) &&
            ((this.smartDeviceUrl==null && other.getSmartDeviceUrl()==null) || 
             (this.smartDeviceUrl!=null &&
              this.smartDeviceUrl.equals(other.getSmartDeviceUrl()))) &&
            ((this.smart_text==null && other.getSmart_text()==null) || 
             (this.smart_text!=null &&
              this.smart_text.equals(other.getSmart_text())));
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
        if (getPCUrl() != null) {
            _hashCode += getPCUrl().hashCode();
        }
        _hashCode += getMediaType();
        if (getPc_text() != null) {
            _hashCode += getPc_text().hashCode();
        }
        if (getSmartDeviceUrl() != null) {
            _hashCode += getSmartDeviceUrl().hashCode();
        }
        if (getSmart_text() != null) {
            _hashCode += getSmart_text().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ViewDetailInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ViewDetailInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PCUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediaType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mediaType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pc_text");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pc_text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smartDeviceUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smartDeviceUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smart_text");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smart_text"));
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
