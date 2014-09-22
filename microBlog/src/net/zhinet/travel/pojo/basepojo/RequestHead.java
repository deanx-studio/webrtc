/**
 * RequestHead.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class RequestHead  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.String msgReqTime;

    private java.lang.String msgSerail;

    private java.lang.String msgSource;

    private int msgType;

    private java.lang.String sign;

    public RequestHead() {
    }

    public RequestHead(
           java.lang.Integer id,
           java.lang.String msgReqTime,
           java.lang.String msgSerail,
           java.lang.String msgSource,
           int msgType,
           java.lang.String sign) {
           this.id = id;
           this.msgReqTime = msgReqTime;
           this.msgSerail = msgSerail;
           this.msgSource = msgSource;
           this.msgType = msgType;
           this.sign = sign;
    }


    /**
     * Gets the id value for this RequestHead.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this RequestHead.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the msgReqTime value for this RequestHead.
     * 
     * @return msgReqTime
     */
    public java.lang.String getMsgReqTime() {
        return msgReqTime;
    }


    /**
     * Sets the msgReqTime value for this RequestHead.
     * 
     * @param msgReqTime
     */
    public void setMsgReqTime(java.lang.String msgReqTime) {
        this.msgReqTime = msgReqTime;
    }


    /**
     * Gets the msgSerail value for this RequestHead.
     * 
     * @return msgSerail
     */
    public java.lang.String getMsgSerail() {
        return msgSerail;
    }


    /**
     * Sets the msgSerail value for this RequestHead.
     * 
     * @param msgSerail
     */
    public void setMsgSerail(java.lang.String msgSerail) {
        this.msgSerail = msgSerail;
    }


    /**
     * Gets the msgSource value for this RequestHead.
     * 
     * @return msgSource
     */
    public java.lang.String getMsgSource() {
        return msgSource;
    }


    /**
     * Sets the msgSource value for this RequestHead.
     * 
     * @param msgSource
     */
    public void setMsgSource(java.lang.String msgSource) {
        this.msgSource = msgSource;
    }


    /**
     * Gets the msgType value for this RequestHead.
     * 
     * @return msgType
     */
    public int getMsgType() {
        return msgType;
    }


    /**
     * Sets the msgType value for this RequestHead.
     * 
     * @param msgType
     */
    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }


    /**
     * Gets the sign value for this RequestHead.
     * 
     * @return sign
     */
    public java.lang.String getSign() {
        return sign;
    }


    /**
     * Sets the sign value for this RequestHead.
     * 
     * @param sign
     */
    public void setSign(java.lang.String sign) {
        this.sign = sign;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestHead)) return false;
        RequestHead other = (RequestHead) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.msgReqTime==null && other.getMsgReqTime()==null) || 
             (this.msgReqTime!=null &&
              this.msgReqTime.equals(other.getMsgReqTime()))) &&
            ((this.msgSerail==null && other.getMsgSerail()==null) || 
             (this.msgSerail!=null &&
              this.msgSerail.equals(other.getMsgSerail()))) &&
            ((this.msgSource==null && other.getMsgSource()==null) || 
             (this.msgSource!=null &&
              this.msgSource.equals(other.getMsgSource()))) &&
            this.msgType == other.getMsgType() &&
            ((this.sign==null && other.getSign()==null) || 
             (this.sign!=null &&
              this.sign.equals(other.getSign())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMsgReqTime() != null) {
            _hashCode += getMsgReqTime().hashCode();
        }
        if (getMsgSerail() != null) {
            _hashCode += getMsgSerail().hashCode();
        }
        if (getMsgSource() != null) {
            _hashCode += getMsgSource().hashCode();
        }
        _hashCode += getMsgType();
        if (getSign() != null) {
            _hashCode += getSign().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestHead.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgReqTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgReqTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgSerail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgSerail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sign"));
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
