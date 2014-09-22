/**
 * ChannelWithdraw.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class ChannelWithdraw  implements java.io.Serializable {
    private int avalible;

    private int procedureFee;

    private int status;

    private int withdraw;

    private java.lang.String withdrawSeq;

    public ChannelWithdraw() {
    }

    public ChannelWithdraw(
           int avalible,
           int procedureFee,
           int status,
           int withdraw,
           java.lang.String withdrawSeq) {
           this.avalible = avalible;
           this.procedureFee = procedureFee;
           this.status = status;
           this.withdraw = withdraw;
           this.withdrawSeq = withdrawSeq;
    }


    /**
     * Gets the avalible value for this ChannelWithdraw.
     * 
     * @return avalible
     */
    public int getAvalible() {
        return avalible;
    }


    /**
     * Sets the avalible value for this ChannelWithdraw.
     * 
     * @param avalible
     */
    public void setAvalible(int avalible) {
        this.avalible = avalible;
    }


    /**
     * Gets the procedureFee value for this ChannelWithdraw.
     * 
     * @return procedureFee
     */
    public int getProcedureFee() {
        return procedureFee;
    }


    /**
     * Sets the procedureFee value for this ChannelWithdraw.
     * 
     * @param procedureFee
     */
    public void setProcedureFee(int procedureFee) {
        this.procedureFee = procedureFee;
    }


    /**
     * Gets the status value for this ChannelWithdraw.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ChannelWithdraw.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the withdraw value for this ChannelWithdraw.
     * 
     * @return withdraw
     */
    public int getWithdraw() {
        return withdraw;
    }


    /**
     * Sets the withdraw value for this ChannelWithdraw.
     * 
     * @param withdraw
     */
    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }


    /**
     * Gets the withdrawSeq value for this ChannelWithdraw.
     * 
     * @return withdrawSeq
     */
    public java.lang.String getWithdrawSeq() {
        return withdrawSeq;
    }


    /**
     * Sets the withdrawSeq value for this ChannelWithdraw.
     * 
     * @param withdrawSeq
     */
    public void setWithdrawSeq(java.lang.String withdrawSeq) {
        this.withdrawSeq = withdrawSeq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChannelWithdraw)) return false;
        ChannelWithdraw other = (ChannelWithdraw) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.avalible == other.getAvalible() &&
            this.procedureFee == other.getProcedureFee() &&
            this.status == other.getStatus() &&
            this.withdraw == other.getWithdraw() &&
            ((this.withdrawSeq==null && other.getWithdrawSeq()==null) || 
             (this.withdrawSeq!=null &&
              this.withdrawSeq.equals(other.getWithdrawSeq())));
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
        _hashCode += getAvalible();
        _hashCode += getProcedureFee();
        _hashCode += getStatus();
        _hashCode += getWithdraw();
        if (getWithdrawSeq() != null) {
            _hashCode += getWithdrawSeq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChannelWithdraw.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ChannelWithdraw"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avalible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avalible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procedureFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "procedureFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("withdraw");
        elemField.setXmlName(new javax.xml.namespace.QName("", "withdraw"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("withdrawSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "withdrawSeq"));
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
