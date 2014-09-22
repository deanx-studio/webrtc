/**
 * CatalogDef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class CatalogDef  implements java.io.Serializable {
    private java.lang.String catalogName;

    private int id;

    private int isShow;

    private java.lang.String maketime;

    private java.lang.String memo;

    private int showSequence;

    public CatalogDef() {
    }

    public CatalogDef(
           java.lang.String catalogName,
           int id,
           int isShow,
           java.lang.String maketime,
           java.lang.String memo,
           int showSequence) {
           this.catalogName = catalogName;
           this.id = id;
           this.isShow = isShow;
           this.maketime = maketime;
           this.memo = memo;
           this.showSequence = showSequence;
    }


    /**
     * Gets the catalogName value for this CatalogDef.
     * 
     * @return catalogName
     */
    public java.lang.String getCatalogName() {
        return catalogName;
    }


    /**
     * Sets the catalogName value for this CatalogDef.
     * 
     * @param catalogName
     */
    public void setCatalogName(java.lang.String catalogName) {
        this.catalogName = catalogName;
    }


    /**
     * Gets the id value for this CatalogDef.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this CatalogDef.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the isShow value for this CatalogDef.
     * 
     * @return isShow
     */
    public int getIsShow() {
        return isShow;
    }


    /**
     * Sets the isShow value for this CatalogDef.
     * 
     * @param isShow
     */
    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }


    /**
     * Gets the maketime value for this CatalogDef.
     * 
     * @return maketime
     */
    public java.lang.String getMaketime() {
        return maketime;
    }


    /**
     * Sets the maketime value for this CatalogDef.
     * 
     * @param maketime
     */
    public void setMaketime(java.lang.String maketime) {
        this.maketime = maketime;
    }


    /**
     * Gets the memo value for this CatalogDef.
     * 
     * @return memo
     */
    public java.lang.String getMemo() {
        return memo;
    }


    /**
     * Sets the memo value for this CatalogDef.
     * 
     * @param memo
     */
    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }


    /**
     * Gets the showSequence value for this CatalogDef.
     * 
     * @return showSequence
     */
    public int getShowSequence() {
        return showSequence;
    }


    /**
     * Sets the showSequence value for this CatalogDef.
     * 
     * @param showSequence
     */
    public void setShowSequence(int showSequence) {
        this.showSequence = showSequence;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CatalogDef)) return false;
        CatalogDef other = (CatalogDef) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.catalogName==null && other.getCatalogName()==null) || 
             (this.catalogName!=null &&
              this.catalogName.equals(other.getCatalogName()))) &&
            this.id == other.getId() &&
            this.isShow == other.getIsShow() &&
            ((this.maketime==null && other.getMaketime()==null) || 
             (this.maketime!=null &&
              this.maketime.equals(other.getMaketime()))) &&
            ((this.memo==null && other.getMemo()==null) || 
             (this.memo!=null &&
              this.memo.equals(other.getMemo()))) &&
            this.showSequence == other.getShowSequence();
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
        if (getCatalogName() != null) {
            _hashCode += getCatalogName().hashCode();
        }
        _hashCode += getId();
        _hashCode += getIsShow();
        if (getMaketime() != null) {
            _hashCode += getMaketime().hashCode();
        }
        if (getMemo() != null) {
            _hashCode += getMemo().hashCode();
        }
        _hashCode += getShowSequence();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CatalogDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "CatalogDef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("catalogName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "catalogName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isShow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isShow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maketime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maketime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showSequence");
        elemField.setXmlName(new javax.xml.namespace.QName("", "showSequence"));
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
