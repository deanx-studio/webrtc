/**
 * SpecificMediumReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class SpecificMediumReq  implements java.io.Serializable {
    private java.lang.Integer cityId;

    private java.lang.String docType;

    private java.lang.Integer provinceId;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private java.lang.Integer scenicId;

    public SpecificMediumReq() {
    }

    public SpecificMediumReq(
           java.lang.Integer cityId,
           java.lang.String docType,
           java.lang.Integer provinceId,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           java.lang.Integer scenicId) {
           this.cityId = cityId;
           this.docType = docType;
           this.provinceId = provinceId;
           this.requestHead = requestHead;
           this.scenicId = scenicId;
    }


    /**
     * Gets the cityId value for this SpecificMediumReq.
     * 
     * @return cityId
     */
    public java.lang.Integer getCityId() {
        return cityId;
    }


    /**
     * Sets the cityId value for this SpecificMediumReq.
     * 
     * @param cityId
     */
    public void setCityId(java.lang.Integer cityId) {
        this.cityId = cityId;
    }


    /**
     * Gets the docType value for this SpecificMediumReq.
     * 
     * @return docType
     */
    public java.lang.String getDocType() {
        return docType;
    }


    /**
     * Sets the docType value for this SpecificMediumReq.
     * 
     * @param docType
     */
    public void setDocType(java.lang.String docType) {
        this.docType = docType;
    }


    /**
     * Gets the provinceId value for this SpecificMediumReq.
     * 
     * @return provinceId
     */
    public java.lang.Integer getProvinceId() {
        return provinceId;
    }


    /**
     * Sets the provinceId value for this SpecificMediumReq.
     * 
     * @param provinceId
     */
    public void setProvinceId(java.lang.Integer provinceId) {
        this.provinceId = provinceId;
    }


    /**
     * Gets the requestHead value for this SpecificMediumReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this SpecificMediumReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the scenicId value for this SpecificMediumReq.
     * 
     * @return scenicId
     */
    public java.lang.Integer getScenicId() {
        return scenicId;
    }


    /**
     * Sets the scenicId value for this SpecificMediumReq.
     * 
     * @param scenicId
     */
    public void setScenicId(java.lang.Integer scenicId) {
        this.scenicId = scenicId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SpecificMediumReq)) return false;
        SpecificMediumReq other = (SpecificMediumReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cityId==null && other.getCityId()==null) || 
             (this.cityId!=null &&
              this.cityId.equals(other.getCityId()))) &&
            ((this.docType==null && other.getDocType()==null) || 
             (this.docType!=null &&
              this.docType.equals(other.getDocType()))) &&
            ((this.provinceId==null && other.getProvinceId()==null) || 
             (this.provinceId!=null &&
              this.provinceId.equals(other.getProvinceId()))) &&
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
            ((this.scenicId==null && other.getScenicId()==null) || 
             (this.scenicId!=null &&
              this.scenicId.equals(other.getScenicId())));
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
        if (getCityId() != null) {
            _hashCode += getCityId().hashCode();
        }
        if (getDocType() != null) {
            _hashCode += getDocType().hashCode();
        }
        if (getProvinceId() != null) {
            _hashCode += getProvinceId().hashCode();
        }
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        if (getScenicId() != null) {
            _hashCode += getScenicId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SpecificMediumReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "SpecificMediumReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "docType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
