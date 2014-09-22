/**
 * Order_CreateReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Order_CreateReq  implements java.io.Serializable {
    private int channelType;

    private java.lang.String endTravelDate;

    private int gatType;

    private java.lang.String linkAddress;

    private java.lang.String linkCreditNo;

    private int linkCreditType;

    private java.lang.String linkEmail;

    private java.lang.String linkMan;

    private java.lang.String linkPhone;

    private java.lang.String linkPostCode;

    private java.lang.String msgSerail;

    private java.lang.String orderMemo;

    private int orderNum;

    private java.lang.String platformId;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private java.lang.String startTravelDate;

    private java.lang.String ticketId;

    private java.lang.String ticketName;

    public Order_CreateReq() {
    }

    public Order_CreateReq(
           int channelType,
           java.lang.String endTravelDate,
           int gatType,
           java.lang.String linkAddress,
           java.lang.String linkCreditNo,
           int linkCreditType,
           java.lang.String linkEmail,
           java.lang.String linkMan,
           java.lang.String linkPhone,
           java.lang.String linkPostCode,
           java.lang.String msgSerail,
           java.lang.String orderMemo,
           int orderNum,
           java.lang.String platformId,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           java.lang.String startTravelDate,
           java.lang.String ticketId,
           java.lang.String ticketName) {
           this.channelType = channelType;
           this.endTravelDate = endTravelDate;
           this.gatType = gatType;
           this.linkAddress = linkAddress;
           this.linkCreditNo = linkCreditNo;
           this.linkCreditType = linkCreditType;
           this.linkEmail = linkEmail;
           this.linkMan = linkMan;
           this.linkPhone = linkPhone;
           this.linkPostCode = linkPostCode;
           this.msgSerail = msgSerail;
           this.orderMemo = orderMemo;
           this.orderNum = orderNum;
           this.platformId = platformId;
           this.requestHead = requestHead;
           this.startTravelDate = startTravelDate;
           this.ticketId = ticketId;
           this.ticketName = ticketName;
    }


    /**
     * Gets the channelType value for this Order_CreateReq.
     * 
     * @return channelType
     */
    public int getChannelType() {
        return channelType;
    }


    /**
     * Sets the channelType value for this Order_CreateReq.
     * 
     * @param channelType
     */
    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }


    /**
     * Gets the endTravelDate value for this Order_CreateReq.
     * 
     * @return endTravelDate
     */
    public java.lang.String getEndTravelDate() {
        return endTravelDate;
    }


    /**
     * Sets the endTravelDate value for this Order_CreateReq.
     * 
     * @param endTravelDate
     */
    public void setEndTravelDate(java.lang.String endTravelDate) {
        this.endTravelDate = endTravelDate;
    }


    /**
     * Gets the gatType value for this Order_CreateReq.
     * 
     * @return gatType
     */
    public int getGatType() {
        return gatType;
    }


    /**
     * Sets the gatType value for this Order_CreateReq.
     * 
     * @param gatType
     */
    public void setGatType(int gatType) {
        this.gatType = gatType;
    }


    /**
     * Gets the linkAddress value for this Order_CreateReq.
     * 
     * @return linkAddress
     */
    public java.lang.String getLinkAddress() {
        return linkAddress;
    }


    /**
     * Sets the linkAddress value for this Order_CreateReq.
     * 
     * @param linkAddress
     */
    public void setLinkAddress(java.lang.String linkAddress) {
        this.linkAddress = linkAddress;
    }


    /**
     * Gets the linkCreditNo value for this Order_CreateReq.
     * 
     * @return linkCreditNo
     */
    public java.lang.String getLinkCreditNo() {
        return linkCreditNo;
    }


    /**
     * Sets the linkCreditNo value for this Order_CreateReq.
     * 
     * @param linkCreditNo
     */
    public void setLinkCreditNo(java.lang.String linkCreditNo) {
        this.linkCreditNo = linkCreditNo;
    }


    /**
     * Gets the linkCreditType value for this Order_CreateReq.
     * 
     * @return linkCreditType
     */
    public int getLinkCreditType() {
        return linkCreditType;
    }


    /**
     * Sets the linkCreditType value for this Order_CreateReq.
     * 
     * @param linkCreditType
     */
    public void setLinkCreditType(int linkCreditType) {
        this.linkCreditType = linkCreditType;
    }


    /**
     * Gets the linkEmail value for this Order_CreateReq.
     * 
     * @return linkEmail
     */
    public java.lang.String getLinkEmail() {
        return linkEmail;
    }


    /**
     * Sets the linkEmail value for this Order_CreateReq.
     * 
     * @param linkEmail
     */
    public void setLinkEmail(java.lang.String linkEmail) {
        this.linkEmail = linkEmail;
    }


    /**
     * Gets the linkMan value for this Order_CreateReq.
     * 
     * @return linkMan
     */
    public java.lang.String getLinkMan() {
        return linkMan;
    }


    /**
     * Sets the linkMan value for this Order_CreateReq.
     * 
     * @param linkMan
     */
    public void setLinkMan(java.lang.String linkMan) {
        this.linkMan = linkMan;
    }


    /**
     * Gets the linkPhone value for this Order_CreateReq.
     * 
     * @return linkPhone
     */
    public java.lang.String getLinkPhone() {
        return linkPhone;
    }


    /**
     * Sets the linkPhone value for this Order_CreateReq.
     * 
     * @param linkPhone
     */
    public void setLinkPhone(java.lang.String linkPhone) {
        this.linkPhone = linkPhone;
    }


    /**
     * Gets the linkPostCode value for this Order_CreateReq.
     * 
     * @return linkPostCode
     */
    public java.lang.String getLinkPostCode() {
        return linkPostCode;
    }


    /**
     * Sets the linkPostCode value for this Order_CreateReq.
     * 
     * @param linkPostCode
     */
    public void setLinkPostCode(java.lang.String linkPostCode) {
        this.linkPostCode = linkPostCode;
    }


    /**
     * Gets the msgSerail value for this Order_CreateReq.
     * 
     * @return msgSerail
     */
    public java.lang.String getMsgSerail() {
        return msgSerail;
    }


    /**
     * Sets the msgSerail value for this Order_CreateReq.
     * 
     * @param msgSerail
     */
    public void setMsgSerail(java.lang.String msgSerail) {
        this.msgSerail = msgSerail;
    }


    /**
     * Gets the orderMemo value for this Order_CreateReq.
     * 
     * @return orderMemo
     */
    public java.lang.String getOrderMemo() {
        return orderMemo;
    }


    /**
     * Sets the orderMemo value for this Order_CreateReq.
     * 
     * @param orderMemo
     */
    public void setOrderMemo(java.lang.String orderMemo) {
        this.orderMemo = orderMemo;
    }


    /**
     * Gets the orderNum value for this Order_CreateReq.
     * 
     * @return orderNum
     */
    public int getOrderNum() {
        return orderNum;
    }


    /**
     * Sets the orderNum value for this Order_CreateReq.
     * 
     * @param orderNum
     */
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }


    /**
     * Gets the platformId value for this Order_CreateReq.
     * 
     * @return platformId
     */
    public java.lang.String getPlatformId() {
        return platformId;
    }


    /**
     * Sets the platformId value for this Order_CreateReq.
     * 
     * @param platformId
     */
    public void setPlatformId(java.lang.String platformId) {
        this.platformId = platformId;
    }


    /**
     * Gets the requestHead value for this Order_CreateReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this Order_CreateReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the startTravelDate value for this Order_CreateReq.
     * 
     * @return startTravelDate
     */
    public java.lang.String getStartTravelDate() {
        return startTravelDate;
    }


    /**
     * Sets the startTravelDate value for this Order_CreateReq.
     * 
     * @param startTravelDate
     */
    public void setStartTravelDate(java.lang.String startTravelDate) {
        this.startTravelDate = startTravelDate;
    }


    /**
     * Gets the ticketId value for this Order_CreateReq.
     * 
     * @return ticketId
     */
    public java.lang.String getTicketId() {
        return ticketId;
    }


    /**
     * Sets the ticketId value for this Order_CreateReq.
     * 
     * @param ticketId
     */
    public void setTicketId(java.lang.String ticketId) {
        this.ticketId = ticketId;
    }


    /**
     * Gets the ticketName value for this Order_CreateReq.
     * 
     * @return ticketName
     */
    public java.lang.String getTicketName() {
        return ticketName;
    }


    /**
     * Sets the ticketName value for this Order_CreateReq.
     * 
     * @param ticketName
     */
    public void setTicketName(java.lang.String ticketName) {
        this.ticketName = ticketName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_CreateReq)) return false;
        Order_CreateReq other = (Order_CreateReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.channelType == other.getChannelType() &&
            ((this.endTravelDate==null && other.getEndTravelDate()==null) || 
             (this.endTravelDate!=null &&
              this.endTravelDate.equals(other.getEndTravelDate()))) &&
            this.gatType == other.getGatType() &&
            ((this.linkAddress==null && other.getLinkAddress()==null) || 
             (this.linkAddress!=null &&
              this.linkAddress.equals(other.getLinkAddress()))) &&
            ((this.linkCreditNo==null && other.getLinkCreditNo()==null) || 
             (this.linkCreditNo!=null &&
              this.linkCreditNo.equals(other.getLinkCreditNo()))) &&
            this.linkCreditType == other.getLinkCreditType() &&
            ((this.linkEmail==null && other.getLinkEmail()==null) || 
             (this.linkEmail!=null &&
              this.linkEmail.equals(other.getLinkEmail()))) &&
            ((this.linkMan==null && other.getLinkMan()==null) || 
             (this.linkMan!=null &&
              this.linkMan.equals(other.getLinkMan()))) &&
            ((this.linkPhone==null && other.getLinkPhone()==null) || 
             (this.linkPhone!=null &&
              this.linkPhone.equals(other.getLinkPhone()))) &&
            ((this.linkPostCode==null && other.getLinkPostCode()==null) || 
             (this.linkPostCode!=null &&
              this.linkPostCode.equals(other.getLinkPostCode()))) &&
            ((this.msgSerail==null && other.getMsgSerail()==null) || 
             (this.msgSerail!=null &&
              this.msgSerail.equals(other.getMsgSerail()))) &&
            ((this.orderMemo==null && other.getOrderMemo()==null) || 
             (this.orderMemo!=null &&
              this.orderMemo.equals(other.getOrderMemo()))) &&
            this.orderNum == other.getOrderNum() &&
            ((this.platformId==null && other.getPlatformId()==null) || 
             (this.platformId!=null &&
              this.platformId.equals(other.getPlatformId()))) &&
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
            ((this.startTravelDate==null && other.getStartTravelDate()==null) || 
             (this.startTravelDate!=null &&
              this.startTravelDate.equals(other.getStartTravelDate()))) &&
            ((this.ticketId==null && other.getTicketId()==null) || 
             (this.ticketId!=null &&
              this.ticketId.equals(other.getTicketId()))) &&
            ((this.ticketName==null && other.getTicketName()==null) || 
             (this.ticketName!=null &&
              this.ticketName.equals(other.getTicketName())));
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
        _hashCode += getChannelType();
        if (getEndTravelDate() != null) {
            _hashCode += getEndTravelDate().hashCode();
        }
        _hashCode += getGatType();
        if (getLinkAddress() != null) {
            _hashCode += getLinkAddress().hashCode();
        }
        if (getLinkCreditNo() != null) {
            _hashCode += getLinkCreditNo().hashCode();
        }
        _hashCode += getLinkCreditType();
        if (getLinkEmail() != null) {
            _hashCode += getLinkEmail().hashCode();
        }
        if (getLinkMan() != null) {
            _hashCode += getLinkMan().hashCode();
        }
        if (getLinkPhone() != null) {
            _hashCode += getLinkPhone().hashCode();
        }
        if (getLinkPostCode() != null) {
            _hashCode += getLinkPostCode().hashCode();
        }
        if (getMsgSerail() != null) {
            _hashCode += getMsgSerail().hashCode();
        }
        if (getOrderMemo() != null) {
            _hashCode += getOrderMemo().hashCode();
        }
        _hashCode += getOrderNum();
        if (getPlatformId() != null) {
            _hashCode += getPlatformId().hashCode();
        }
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        if (getStartTravelDate() != null) {
            _hashCode += getStartTravelDate().hashCode();
        }
        if (getTicketId() != null) {
            _hashCode += getTicketId().hashCode();
        }
        if (getTicketName() != null) {
            _hashCode += getTicketName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_CreateReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Order_CreateReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channelType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channelType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTravelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endTravelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gatType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gatType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkCreditNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkCreditNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkCreditType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkCreditType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkMan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkMan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkPostCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkPostCode"));
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
        elemField.setFieldName("orderMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("platformId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "platformId"));
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
        elemField.setFieldName("startTravelDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startTravelDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketName"));
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
