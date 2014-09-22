/**
 * ContentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class ContentInfo  implements java.io.Serializable {
    private java.lang.String contentBody;

    private java.lang.Integer contentId;

    private java.lang.String contentTitle;

    private short contentType;

    private java.lang.String contentUrl;

    private java.lang.String makeTime;

    public ContentInfo() {
    }

    public ContentInfo(
           java.lang.String contentBody,
           java.lang.Integer contentId,
           java.lang.String contentTitle,
           short contentType,
           java.lang.String contentUrl,
           java.lang.String makeTime) {
           this.contentBody = contentBody;
           this.contentId = contentId;
           this.contentTitle = contentTitle;
           this.contentType = contentType;
           this.contentUrl = contentUrl;
           this.makeTime = makeTime;
    }


    /**
     * Gets the contentBody value for this ContentInfo.
     * 
     * @return contentBody
     */
    public java.lang.String getContentBody() {
        return contentBody;
    }


    /**
     * Sets the contentBody value for this ContentInfo.
     * 
     * @param contentBody
     */
    public void setContentBody(java.lang.String contentBody) {
        this.contentBody = contentBody;
    }


    /**
     * Gets the contentId value for this ContentInfo.
     * 
     * @return contentId
     */
    public java.lang.Integer getContentId() {
        return contentId;
    }


    /**
     * Sets the contentId value for this ContentInfo.
     * 
     * @param contentId
     */
    public void setContentId(java.lang.Integer contentId) {
        this.contentId = contentId;
    }


    /**
     * Gets the contentTitle value for this ContentInfo.
     * 
     * @return contentTitle
     */
    public java.lang.String getContentTitle() {
        return contentTitle;
    }


    /**
     * Sets the contentTitle value for this ContentInfo.
     * 
     * @param contentTitle
     */
    public void setContentTitle(java.lang.String contentTitle) {
        this.contentTitle = contentTitle;
    }


    /**
     * Gets the contentType value for this ContentInfo.
     * 
     * @return contentType
     */
    public short getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this ContentInfo.
     * 
     * @param contentType
     */
    public void setContentType(short contentType) {
        this.contentType = contentType;
    }


    /**
     * Gets the contentUrl value for this ContentInfo.
     * 
     * @return contentUrl
     */
    public java.lang.String getContentUrl() {
        return contentUrl;
    }


    /**
     * Sets the contentUrl value for this ContentInfo.
     * 
     * @param contentUrl
     */
    public void setContentUrl(java.lang.String contentUrl) {
        this.contentUrl = contentUrl;
    }


    /**
     * Gets the makeTime value for this ContentInfo.
     * 
     * @return makeTime
     */
    public java.lang.String getMakeTime() {
        return makeTime;
    }


    /**
     * Sets the makeTime value for this ContentInfo.
     * 
     * @param makeTime
     */
    public void setMakeTime(java.lang.String makeTime) {
        this.makeTime = makeTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContentInfo)) return false;
        ContentInfo other = (ContentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contentBody==null && other.getContentBody()==null) || 
             (this.contentBody!=null &&
              this.contentBody.equals(other.getContentBody()))) &&
            ((this.contentId==null && other.getContentId()==null) || 
             (this.contentId!=null &&
              this.contentId.equals(other.getContentId()))) &&
            ((this.contentTitle==null && other.getContentTitle()==null) || 
             (this.contentTitle!=null &&
              this.contentTitle.equals(other.getContentTitle()))) &&
            this.contentType == other.getContentType() &&
            ((this.contentUrl==null && other.getContentUrl()==null) || 
             (this.contentUrl!=null &&
              this.contentUrl.equals(other.getContentUrl()))) &&
            ((this.makeTime==null && other.getMakeTime()==null) || 
             (this.makeTime!=null &&
              this.makeTime.equals(other.getMakeTime())));
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
        if (getContentBody() != null) {
            _hashCode += getContentBody().hashCode();
        }
        if (getContentId() != null) {
            _hashCode += getContentId().hashCode();
        }
        if (getContentTitle() != null) {
            _hashCode += getContentTitle().hashCode();
        }
        _hashCode += getContentType();
        if (getContentUrl() != null) {
            _hashCode += getContentUrl().hashCode();
        }
        if (getMakeTime() != null) {
            _hashCode += getMakeTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ContentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentBody");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentBody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("makeTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "makeTime"));
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
