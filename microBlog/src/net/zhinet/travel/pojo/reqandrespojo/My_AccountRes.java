/**
 * My_AccountRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class My_AccountRes  implements java.io.Serializable {
    private java.lang.String banlance;

    private java.lang.String credit;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    private java.lang.String totalCredit;

    private java.lang.String totalValidate;

    private java.lang.String totlalOrders;

    public My_AccountRes() {
    }

    public My_AccountRes(
           java.lang.String banlance,
           java.lang.String credit,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead,
           java.lang.String totalCredit,
           java.lang.String totalValidate,
           java.lang.String totlalOrders) {
           this.banlance = banlance;
           this.credit = credit;
           this.responseHead = responseHead;
           this.totalCredit = totalCredit;
           this.totalValidate = totalValidate;
           this.totlalOrders = totlalOrders;
    }


    /**
     * Gets the banlance value for this My_AccountRes.
     * 
     * @return banlance
     */
    public java.lang.String getBanlance() {
        return banlance;
    }


    /**
     * Sets the banlance value for this My_AccountRes.
     * 
     * @param banlance
     */
    public void setBanlance(java.lang.String banlance) {
        this.banlance = banlance;
    }


    /**
     * Gets the credit value for this My_AccountRes.
     * 
     * @return credit
     */
    public java.lang.String getCredit() {
        return credit;
    }


    /**
     * Sets the credit value for this My_AccountRes.
     * 
     * @param credit
     */
    public void setCredit(java.lang.String credit) {
        this.credit = credit;
    }


    /**
     * Gets the responseHead value for this My_AccountRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this My_AccountRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }


    /**
     * Gets the totalCredit value for this My_AccountRes.
     * 
     * @return totalCredit
     */
    public java.lang.String getTotalCredit() {
        return totalCredit;
    }


    /**
     * Sets the totalCredit value for this My_AccountRes.
     * 
     * @param totalCredit
     */
    public void setTotalCredit(java.lang.String totalCredit) {
        this.totalCredit = totalCredit;
    }


    /**
     * Gets the totalValidate value for this My_AccountRes.
     * 
     * @return totalValidate
     */
    public java.lang.String getTotalValidate() {
        return totalValidate;
    }


    /**
     * Sets the totalValidate value for this My_AccountRes.
     * 
     * @param totalValidate
     */
    public void setTotalValidate(java.lang.String totalValidate) {
        this.totalValidate = totalValidate;
    }


    /**
     * Gets the totlalOrders value for this My_AccountRes.
     * 
     * @return totlalOrders
     */
    public java.lang.String getTotlalOrders() {
        return totlalOrders;
    }


    /**
     * Sets the totlalOrders value for this My_AccountRes.
     * 
     * @param totlalOrders
     */
    public void setTotlalOrders(java.lang.String totlalOrders) {
        this.totlalOrders = totlalOrders;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof My_AccountRes)) return false;
        My_AccountRes other = (My_AccountRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.banlance==null && other.getBanlance()==null) || 
             (this.banlance!=null &&
              this.banlance.equals(other.getBanlance()))) &&
            ((this.credit==null && other.getCredit()==null) || 
             (this.credit!=null &&
              this.credit.equals(other.getCredit()))) &&
            ((this.responseHead==null && other.getResponseHead()==null) || 
             (this.responseHead!=null &&
              this.responseHead.equals(other.getResponseHead()))) &&
            ((this.totalCredit==null && other.getTotalCredit()==null) || 
             (this.totalCredit!=null &&
              this.totalCredit.equals(other.getTotalCredit()))) &&
            ((this.totalValidate==null && other.getTotalValidate()==null) || 
             (this.totalValidate!=null &&
              this.totalValidate.equals(other.getTotalValidate()))) &&
            ((this.totlalOrders==null && other.getTotlalOrders()==null) || 
             (this.totlalOrders!=null &&
              this.totlalOrders.equals(other.getTotlalOrders())));
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
        if (getBanlance() != null) {
            _hashCode += getBanlance().hashCode();
        }
        if (getCredit() != null) {
            _hashCode += getCredit().hashCode();
        }
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        if (getTotalCredit() != null) {
            _hashCode += getTotalCredit().hashCode();
        }
        if (getTotalValidate() != null) {
            _hashCode += getTotalValidate().hashCode();
        }
        if (getTotlalOrders() != null) {
            _hashCode += getTotlalOrders().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(My_AccountRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "My_AccountRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("banlance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "banlance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "credit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalValidate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalValidate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totlalOrders");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totlalOrders"));
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
