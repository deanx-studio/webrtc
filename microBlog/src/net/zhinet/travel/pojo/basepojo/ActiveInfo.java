/**
 * ActiveInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class ActiveInfo  implements java.io.Serializable {
    private java.lang.String activeDesc;

    private java.lang.String activeEndDate;

    private java.lang.Integer activeId;

    private java.lang.String activeStartDate;

    private java.lang.String activeTitle;

    private java.lang.String cityIds;

    private java.lang.String scenicIds;

    private java.lang.String ticketId;

    public ActiveInfo() {
    }

    public ActiveInfo(
           java.lang.String activeDesc,
           java.lang.String activeEndDate,
           java.lang.Integer activeId,
           java.lang.String activeStartDate,
           java.lang.String activeTitle,
           java.lang.String cityIds,
           java.lang.String scenicIds,
           java.lang.String ticketId) {
           this.activeDesc = activeDesc;
           this.activeEndDate = activeEndDate;
           this.activeId = activeId;
           this.activeStartDate = activeStartDate;
           this.activeTitle = activeTitle;
           this.cityIds = cityIds;
           this.scenicIds = scenicIds;
           this.ticketId = ticketId;
    }


    /**
     * Gets the activeDesc value for this ActiveInfo.
     * 
     * @return activeDesc
     */
    public java.lang.String getActiveDesc() {
        return activeDesc;
    }


    /**
     * Sets the activeDesc value for this ActiveInfo.
     * 
     * @param activeDesc
     */
    public void setActiveDesc(java.lang.String activeDesc) {
        this.activeDesc = activeDesc;
    }


    /**
     * Gets the activeEndDate value for this ActiveInfo.
     * 
     * @return activeEndDate
     */
    public java.lang.String getActiveEndDate() {
        return activeEndDate;
    }


    /**
     * Sets the activeEndDate value for this ActiveInfo.
     * 
     * @param activeEndDate
     */
    public void setActiveEndDate(java.lang.String activeEndDate) {
        this.activeEndDate = activeEndDate;
    }


    /**
     * Gets the activeId value for this ActiveInfo.
     * 
     * @return activeId
     */
    public java.lang.Integer getActiveId() {
        return activeId;
    }


    /**
     * Sets the activeId value for this ActiveInfo.
     * 
     * @param activeId
     */
    public void setActiveId(java.lang.Integer activeId) {
        this.activeId = activeId;
    }


    /**
     * Gets the activeStartDate value for this ActiveInfo.
     * 
     * @return activeStartDate
     */
    public java.lang.String getActiveStartDate() {
        return activeStartDate;
    }


    /**
     * Sets the activeStartDate value for this ActiveInfo.
     * 
     * @param activeStartDate
     */
    public void setActiveStartDate(java.lang.String activeStartDate) {
        this.activeStartDate = activeStartDate;
    }


    /**
     * Gets the activeTitle value for this ActiveInfo.
     * 
     * @return activeTitle
     */
    public java.lang.String getActiveTitle() {
        return activeTitle;
    }


    /**
     * Sets the activeTitle value for this ActiveInfo.
     * 
     * @param activeTitle
     */
    public void setActiveTitle(java.lang.String activeTitle) {
        this.activeTitle = activeTitle;
    }


    /**
     * Gets the cityIds value for this ActiveInfo.
     * 
     * @return cityIds
     */
    public java.lang.String getCityIds() {
        return cityIds;
    }


    /**
     * Sets the cityIds value for this ActiveInfo.
     * 
     * @param cityIds
     */
    public void setCityIds(java.lang.String cityIds) {
        this.cityIds = cityIds;
    }


    /**
     * Gets the scenicIds value for this ActiveInfo.
     * 
     * @return scenicIds
     */
    public java.lang.String getScenicIds() {
        return scenicIds;
    }


    /**
     * Sets the scenicIds value for this ActiveInfo.
     * 
     * @param scenicIds
     */
    public void setScenicIds(java.lang.String scenicIds) {
        this.scenicIds = scenicIds;
    }


    /**
     * Gets the ticketId value for this ActiveInfo.
     * 
     * @return ticketId
     */
    public java.lang.String getTicketId() {
        return ticketId;
    }


    /**
     * Sets the ticketId value for this ActiveInfo.
     * 
     * @param ticketId
     */
    public void setTicketId(java.lang.String ticketId) {
        this.ticketId = ticketId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ActiveInfo)) return false;
        ActiveInfo other = (ActiveInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.activeDesc==null && other.getActiveDesc()==null) || 
             (this.activeDesc!=null &&
              this.activeDesc.equals(other.getActiveDesc()))) &&
            ((this.activeEndDate==null && other.getActiveEndDate()==null) || 
             (this.activeEndDate!=null &&
              this.activeEndDate.equals(other.getActiveEndDate()))) &&
            ((this.activeId==null && other.getActiveId()==null) || 
             (this.activeId!=null &&
              this.activeId.equals(other.getActiveId()))) &&
            ((this.activeStartDate==null && other.getActiveStartDate()==null) || 
             (this.activeStartDate!=null &&
              this.activeStartDate.equals(other.getActiveStartDate()))) &&
            ((this.activeTitle==null && other.getActiveTitle()==null) || 
             (this.activeTitle!=null &&
              this.activeTitle.equals(other.getActiveTitle()))) &&
            ((this.cityIds==null && other.getCityIds()==null) || 
             (this.cityIds!=null &&
              this.cityIds.equals(other.getCityIds()))) &&
            ((this.scenicIds==null && other.getScenicIds()==null) || 
             (this.scenicIds!=null &&
              this.scenicIds.equals(other.getScenicIds()))) &&
            ((this.ticketId==null && other.getTicketId()==null) || 
             (this.ticketId!=null &&
              this.ticketId.equals(other.getTicketId())));
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
        if (getActiveDesc() != null) {
            _hashCode += getActiveDesc().hashCode();
        }
        if (getActiveEndDate() != null) {
            _hashCode += getActiveEndDate().hashCode();
        }
        if (getActiveId() != null) {
            _hashCode += getActiveId().hashCode();
        }
        if (getActiveStartDate() != null) {
            _hashCode += getActiveStartDate().hashCode();
        }
        if (getActiveTitle() != null) {
            _hashCode += getActiveTitle().hashCode();
        }
        if (getCityIds() != null) {
            _hashCode += getCityIds().hashCode();
        }
        if (getScenicIds() != null) {
            _hashCode += getScenicIds().hashCode();
        }
        if (getTicketId() != null) {
            _hashCode += getTicketId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ActiveInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ActiveInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activeTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activeTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityIds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicIds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketId"));
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
