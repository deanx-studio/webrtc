/**
 * ResponseHead.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class ResponseHead  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.String msgRespTime;

    private java.lang.String msgSerail;

    private int msgType;

    private int resultCode;

    private java.lang.String resultMsg;

    public ResponseHead() {
    }

    public ResponseHead(
           java.lang.Integer id,
           java.lang.String msgRespTime,
           java.lang.String msgSerail,
           int msgType,
           int resultCode,
           java.lang.String resultMsg) {
           this.id = id;
           this.msgRespTime = msgRespTime;
           this.msgSerail = msgSerail;
           this.msgType = msgType;
           this.resultCode = resultCode;
           this.resultMsg = resultMsg;
    }


    /**
     * Gets the id value for this ResponseHead.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this ResponseHead.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the msgRespTime value for this ResponseHead.
     * 
     * @return msgRespTime
     */
    public java.lang.String getMsgRespTime() {
        return msgRespTime;
    }


    /**
     * Sets the msgRespTime value for this ResponseHead.
     * 
     * @param msgRespTime
     */
    public void setMsgRespTime(java.lang.String msgRespTime) {
        this.msgRespTime = msgRespTime;
    }


    /**
     * Gets the msgSerail value for this ResponseHead.
     * 
     * @return msgSerail
     */
    public java.lang.String getMsgSerail() {
        return msgSerail;
    }


    /**
     * Sets the msgSerail value for this ResponseHead.
     * 
     * @param msgSerail
     */
    public void setMsgSerail(java.lang.String msgSerail) {
        this.msgSerail = msgSerail;
    }


    /**
     * Gets the msgType value for this ResponseHead.
     * 
     * @return msgType
     */
    public int getMsgType() {
        return msgType;
    }


    /**
     * Sets the msgType value for this ResponseHead.
     * 
     * @param msgType
     */
    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }


    /**
     * Gets the resultCode value for this ResponseHead.
     * 
     * @return resultCode
     */
    public int getResultCode() {
        return resultCode;
    }


    /**
     * Sets the resultCode value for this ResponseHead.
     * 
     * @param resultCode
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }


    /**
     * Gets the resultMsg value for this ResponseHead.
     * 
     * @return resultMsg
     */
    public java.lang.String getResultMsg() {
        return resultMsg;
    }


    /**
     * Sets the resultMsg value for this ResponseHead.
     * 
     * @param resultMsg
     */
    public void setResultMsg(java.lang.String resultMsg) {
        this.resultMsg = resultMsg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseHead)) return false;
        ResponseHead other = (ResponseHead) obj;
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
            ((this.msgRespTime==null && other.getMsgRespTime()==null) || 
             (this.msgRespTime!=null &&
              this.msgRespTime.equals(other.getMsgRespTime()))) &&
            ((this.msgSerail==null && other.getMsgSerail()==null) || 
             (this.msgSerail!=null &&
              this.msgSerail.equals(other.getMsgSerail()))) &&
            this.msgType == other.getMsgType() &&
            this.resultCode == other.getResultCode() &&
            ((this.resultMsg==null && other.getResultMsg()==null) || 
             (this.resultMsg!=null &&
              this.resultMsg.equals(other.getResultMsg())));
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
        if (getMsgRespTime() != null) {
            _hashCode += getMsgRespTime().hashCode();
        }
        if (getMsgSerail() != null) {
            _hashCode += getMsgSerail().hashCode();
        }
        _hashCode += getMsgType();
        _hashCode += getResultCode();
        if (getResultMsg() != null) {
            _hashCode += getResultMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseHead.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgRespTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgRespTime"));
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
        elemField.setFieldName("msgType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultMsg"));
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
