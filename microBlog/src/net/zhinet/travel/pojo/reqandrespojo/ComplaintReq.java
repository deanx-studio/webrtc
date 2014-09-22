/**
 * ComplaintReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class ComplaintReq  implements java.io.Serializable {
    private java.lang.String content;

    private java.lang.Integer cusId;

    private java.lang.String orderNo;

    private java.lang.String reply;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private java.lang.Integer state;

    private java.lang.String submitDate;

    private java.lang.Integer type;

    public ComplaintReq() {
    }

    public ComplaintReq(
           java.lang.String content,
           java.lang.Integer cusId,
           java.lang.String orderNo,
           java.lang.String reply,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           java.lang.Integer state,
           java.lang.String submitDate,
           java.lang.Integer type) {
           this.content = content;
           this.cusId = cusId;
           this.orderNo = orderNo;
           this.reply = reply;
           this.requestHead = requestHead;
           this.state = state;
           this.submitDate = submitDate;
           this.type = type;
    }


    /**
     * Gets the content value for this ComplaintReq.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this ComplaintReq.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the cusId value for this ComplaintReq.
     * 
     * @return cusId
     */
    public java.lang.Integer getCusId() {
        return cusId;
    }


    /**
     * Sets the cusId value for this ComplaintReq.
     * 
     * @param cusId
     */
    public void setCusId(java.lang.Integer cusId) {
        this.cusId = cusId;
    }


    /**
     * Gets the orderNo value for this ComplaintReq.
     * 
     * @return orderNo
     */
    public java.lang.String getOrderNo() {
        return orderNo;
    }


    /**
     * Sets the orderNo value for this ComplaintReq.
     * 
     * @param orderNo
     */
    public void setOrderNo(java.lang.String orderNo) {
        this.orderNo = orderNo;
    }


    /**
     * Gets the reply value for this ComplaintReq.
     * 
     * @return reply
     */
    public java.lang.String getReply() {
        return reply;
    }


    /**
     * Sets the reply value for this ComplaintReq.
     * 
     * @param reply
     */
    public void setReply(java.lang.String reply) {
        this.reply = reply;
    }


    /**
     * Gets the requestHead value for this ComplaintReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this ComplaintReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the state value for this ComplaintReq.
     * 
     * @return state
     */
    public java.lang.Integer getState() {
        return state;
    }


    /**
     * Sets the state value for this ComplaintReq.
     * 
     * @param state
     */
    public void setState(java.lang.Integer state) {
        this.state = state;
    }


    /**
     * Gets the submitDate value for this ComplaintReq.
     * 
     * @return submitDate
     */
    public java.lang.String getSubmitDate() {
        return submitDate;
    }


    /**
     * Sets the submitDate value for this ComplaintReq.
     * 
     * @param submitDate
     */
    public void setSubmitDate(java.lang.String submitDate) {
        this.submitDate = submitDate;
    }


    /**
     * Gets the type value for this ComplaintReq.
     * 
     * @return type
     */
    public java.lang.Integer getType() {
        return type;
    }


    /**
     * Sets the type value for this ComplaintReq.
     * 
     * @param type
     */
    public void setType(java.lang.Integer type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComplaintReq)) return false;
        ComplaintReq other = (ComplaintReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.cusId==null && other.getCusId()==null) || 
             (this.cusId!=null &&
              this.cusId.equals(other.getCusId()))) &&
            ((this.orderNo==null && other.getOrderNo()==null) || 
             (this.orderNo!=null &&
              this.orderNo.equals(other.getOrderNo()))) &&
            ((this.reply==null && other.getReply()==null) || 
             (this.reply!=null &&
              this.reply.equals(other.getReply()))) &&
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.submitDate==null && other.getSubmitDate()==null) || 
             (this.submitDate!=null &&
              this.submitDate.equals(other.getSubmitDate()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getCusId() != null) {
            _hashCode += getCusId().hashCode();
        }
        if (getOrderNo() != null) {
            _hashCode += getOrderNo().hashCode();
        }
        if (getReply() != null) {
            _hashCode += getReply().hashCode();
        }
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getSubmitDate() != null) {
            _hashCode += getSubmitDate().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComplaintReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "ComplaintReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cusId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cusId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reply");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reply"));
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
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("submitDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "submitDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
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
