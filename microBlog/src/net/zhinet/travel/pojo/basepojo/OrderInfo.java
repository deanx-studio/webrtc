/**
 * OrderInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class OrderInfo  implements java.io.Serializable {
    private int amount;

    private int cancelFee;

    private int changeFee;

    private java.lang.String channelSourceId;

    private int consumeCount;

    private java.lang.String customerPayMoney;

    private java.lang.Integer id;

    private int isCancel;

    private int isChangeDate;

    private java.lang.String lastSyncTime;

    private java.lang.String link_man;

    private java.lang.String link_phone;

    private java.lang.String msgSerail;

    private java.lang.String orderDate;

    private java.lang.String orderID;

    private java.lang.String orderSource;

    private int orderState;

    private java.lang.String orderTotalMoney;

    private int payChannel;

    private java.lang.String payDate;

    private int payMoney;

    private java.lang.String payOrderId;

    private int payState;

    private java.lang.String payUrl;

    private java.lang.String playDate;

    private int preDays;

    private int ticketId;

    private java.lang.String ticketName;

    private int ticketPrice;

    private int viewID;

    private java.lang.String viewName;

    public OrderInfo() {
    }

    public OrderInfo(
           int amount,
           int cancelFee,
           int changeFee,
           java.lang.String channelSourceId,
           int consumeCount,
           java.lang.String customerPayMoney,
           java.lang.Integer id,
           int isCancel,
           int isChangeDate,
           java.lang.String lastSyncTime,
           java.lang.String link_man,
           java.lang.String link_phone,
           java.lang.String msgSerail,
           java.lang.String orderDate,
           java.lang.String orderID,
           java.lang.String orderSource,
           int orderState,
           java.lang.String orderTotalMoney,
           int payChannel,
           java.lang.String payDate,
           int payMoney,
           java.lang.String payOrderId,
           int payState,
           java.lang.String payUrl,
           java.lang.String playDate,
           int preDays,
           int ticketId,
           java.lang.String ticketName,
           int ticketPrice,
           int viewID,
           java.lang.String viewName) {
           this.amount = amount;
           this.cancelFee = cancelFee;
           this.changeFee = changeFee;
           this.channelSourceId = channelSourceId;
           this.consumeCount = consumeCount;
           this.customerPayMoney = customerPayMoney;
           this.id = id;
           this.isCancel = isCancel;
           this.isChangeDate = isChangeDate;
           this.lastSyncTime = lastSyncTime;
           this.link_man = link_man;
           this.link_phone = link_phone;
           this.msgSerail = msgSerail;
           this.orderDate = orderDate;
           this.orderID = orderID;
           this.orderSource = orderSource;
           this.orderState = orderState;
           this.orderTotalMoney = orderTotalMoney;
           this.payChannel = payChannel;
           this.payDate = payDate;
           this.payMoney = payMoney;
           this.payOrderId = payOrderId;
           this.payState = payState;
           this.payUrl = payUrl;
           this.playDate = playDate;
           this.preDays = preDays;
           this.ticketId = ticketId;
           this.ticketName = ticketName;
           this.ticketPrice = ticketPrice;
           this.viewID = viewID;
           this.viewName = viewName;
    }


    /**
     * Gets the amount value for this OrderInfo.
     * 
     * @return amount
     */
    public int getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this OrderInfo.
     * 
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }


    /**
     * Gets the cancelFee value for this OrderInfo.
     * 
     * @return cancelFee
     */
    public int getCancelFee() {
        return cancelFee;
    }


    /**
     * Sets the cancelFee value for this OrderInfo.
     * 
     * @param cancelFee
     */
    public void setCancelFee(int cancelFee) {
        this.cancelFee = cancelFee;
    }


    /**
     * Gets the changeFee value for this OrderInfo.
     * 
     * @return changeFee
     */
    public int getChangeFee() {
        return changeFee;
    }


    /**
     * Sets the changeFee value for this OrderInfo.
     * 
     * @param changeFee
     */
    public void setChangeFee(int changeFee) {
        this.changeFee = changeFee;
    }


    /**
     * Gets the channelSourceId value for this OrderInfo.
     * 
     * @return channelSourceId
     */
    public java.lang.String getChannelSourceId() {
        return channelSourceId;
    }


    /**
     * Sets the channelSourceId value for this OrderInfo.
     * 
     * @param channelSourceId
     */
    public void setChannelSourceId(java.lang.String channelSourceId) {
        this.channelSourceId = channelSourceId;
    }


    /**
     * Gets the consumeCount value for this OrderInfo.
     * 
     * @return consumeCount
     */
    public int getConsumeCount() {
        return consumeCount;
    }


    /**
     * Sets the consumeCount value for this OrderInfo.
     * 
     * @param consumeCount
     */
    public void setConsumeCount(int consumeCount) {
        this.consumeCount = consumeCount;
    }


    /**
     * Gets the customerPayMoney value for this OrderInfo.
     * 
     * @return customerPayMoney
     */
    public java.lang.String getCustomerPayMoney() {
        return customerPayMoney;
    }


    /**
     * Sets the customerPayMoney value for this OrderInfo.
     * 
     * @param customerPayMoney
     */
    public void setCustomerPayMoney(java.lang.String customerPayMoney) {
        this.customerPayMoney = customerPayMoney;
    }


    /**
     * Gets the id value for this OrderInfo.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this OrderInfo.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the isCancel value for this OrderInfo.
     * 
     * @return isCancel
     */
    public int getIsCancel() {
        return isCancel;
    }


    /**
     * Sets the isCancel value for this OrderInfo.
     * 
     * @param isCancel
     */
    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }


    /**
     * Gets the isChangeDate value for this OrderInfo.
     * 
     * @return isChangeDate
     */
    public int getIsChangeDate() {
        return isChangeDate;
    }


    /**
     * Sets the isChangeDate value for this OrderInfo.
     * 
     * @param isChangeDate
     */
    public void setIsChangeDate(int isChangeDate) {
        this.isChangeDate = isChangeDate;
    }


    /**
     * Gets the lastSyncTime value for this OrderInfo.
     * 
     * @return lastSyncTime
     */
    public java.lang.String getLastSyncTime() {
        return lastSyncTime;
    }


    /**
     * Sets the lastSyncTime value for this OrderInfo.
     * 
     * @param lastSyncTime
     */
    public void setLastSyncTime(java.lang.String lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }


    /**
     * Gets the link_man value for this OrderInfo.
     * 
     * @return link_man
     */
    public java.lang.String getLink_man() {
        return link_man;
    }


    /**
     * Sets the link_man value for this OrderInfo.
     * 
     * @param link_man
     */
    public void setLink_man(java.lang.String link_man) {
        this.link_man = link_man;
    }


    /**
     * Gets the link_phone value for this OrderInfo.
     * 
     * @return link_phone
     */
    public java.lang.String getLink_phone() {
        return link_phone;
    }


    /**
     * Sets the link_phone value for this OrderInfo.
     * 
     * @param link_phone
     */
    public void setLink_phone(java.lang.String link_phone) {
        this.link_phone = link_phone;
    }


    /**
     * Gets the msgSerail value for this OrderInfo.
     * 
     * @return msgSerail
     */
    public java.lang.String getMsgSerail() {
        return msgSerail;
    }


    /**
     * Sets the msgSerail value for this OrderInfo.
     * 
     * @param msgSerail
     */
    public void setMsgSerail(java.lang.String msgSerail) {
        this.msgSerail = msgSerail;
    }


    /**
     * Gets the orderDate value for this OrderInfo.
     * 
     * @return orderDate
     */
    public java.lang.String getOrderDate() {
        return orderDate;
    }


    /**
     * Sets the orderDate value for this OrderInfo.
     * 
     * @param orderDate
     */
    public void setOrderDate(java.lang.String orderDate) {
        this.orderDate = orderDate;
    }


    /**
     * Gets the orderID value for this OrderInfo.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this OrderInfo.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the orderSource value for this OrderInfo.
     * 
     * @return orderSource
     */
    public java.lang.String getOrderSource() {
        return orderSource;
    }


    /**
     * Sets the orderSource value for this OrderInfo.
     * 
     * @param orderSource
     */
    public void setOrderSource(java.lang.String orderSource) {
        this.orderSource = orderSource;
    }


    /**
     * Gets the orderState value for this OrderInfo.
     * 
     * @return orderState
     */
    public int getOrderState() {
        return orderState;
    }


    /**
     * Sets the orderState value for this OrderInfo.
     * 
     * @param orderState
     */
    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }


    /**
     * Gets the orderTotalMoney value for this OrderInfo.
     * 
     * @return orderTotalMoney
     */
    public java.lang.String getOrderTotalMoney() {
        return orderTotalMoney;
    }


    /**
     * Sets the orderTotalMoney value for this OrderInfo.
     * 
     * @param orderTotalMoney
     */
    public void setOrderTotalMoney(java.lang.String orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }


    /**
     * Gets the payChannel value for this OrderInfo.
     * 
     * @return payChannel
     */
    public int getPayChannel() {
        return payChannel;
    }


    /**
     * Sets the payChannel value for this OrderInfo.
     * 
     * @param payChannel
     */
    public void setPayChannel(int payChannel) {
        this.payChannel = payChannel;
    }


    /**
     * Gets the payDate value for this OrderInfo.
     * 
     * @return payDate
     */
    public java.lang.String getPayDate() {
        return payDate;
    }


    /**
     * Sets the payDate value for this OrderInfo.
     * 
     * @param payDate
     */
    public void setPayDate(java.lang.String payDate) {
        this.payDate = payDate;
    }


    /**
     * Gets the payMoney value for this OrderInfo.
     * 
     * @return payMoney
     */
    public int getPayMoney() {
        return payMoney;
    }


    /**
     * Sets the payMoney value for this OrderInfo.
     * 
     * @param payMoney
     */
    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }


    /**
     * Gets the payOrderId value for this OrderInfo.
     * 
     * @return payOrderId
     */
    public java.lang.String getPayOrderId() {
        return payOrderId;
    }


    /**
     * Sets the payOrderId value for this OrderInfo.
     * 
     * @param payOrderId
     */
    public void setPayOrderId(java.lang.String payOrderId) {
        this.payOrderId = payOrderId;
    }


    /**
     * Gets the payState value for this OrderInfo.
     * 
     * @return payState
     */
    public int getPayState() {
        return payState;
    }


    /**
     * Sets the payState value for this OrderInfo.
     * 
     * @param payState
     */
    public void setPayState(int payState) {
        this.payState = payState;
    }


    /**
     * Gets the payUrl value for this OrderInfo.
     * 
     * @return payUrl
     */
    public java.lang.String getPayUrl() {
        return payUrl;
    }


    /**
     * Sets the payUrl value for this OrderInfo.
     * 
     * @param payUrl
     */
    public void setPayUrl(java.lang.String payUrl) {
        this.payUrl = payUrl;
    }


    /**
     * Gets the playDate value for this OrderInfo.
     * 
     * @return playDate
     */
    public java.lang.String getPlayDate() {
        return playDate;
    }


    /**
     * Sets the playDate value for this OrderInfo.
     * 
     * @param playDate
     */
    public void setPlayDate(java.lang.String playDate) {
        this.playDate = playDate;
    }


    /**
     * Gets the preDays value for this OrderInfo.
     * 
     * @return preDays
     */
    public int getPreDays() {
        return preDays;
    }


    /**
     * Sets the preDays value for this OrderInfo.
     * 
     * @param preDays
     */
    public void setPreDays(int preDays) {
        this.preDays = preDays;
    }


    /**
     * Gets the ticketId value for this OrderInfo.
     * 
     * @return ticketId
     */
    public int getTicketId() {
        return ticketId;
    }


    /**
     * Sets the ticketId value for this OrderInfo.
     * 
     * @param ticketId
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    /**
     * Gets the ticketName value for this OrderInfo.
     * 
     * @return ticketName
     */
    public java.lang.String getTicketName() {
        return ticketName;
    }


    /**
     * Sets the ticketName value for this OrderInfo.
     * 
     * @param ticketName
     */
    public void setTicketName(java.lang.String ticketName) {
        this.ticketName = ticketName;
    }


    /**
     * Gets the ticketPrice value for this OrderInfo.
     * 
     * @return ticketPrice
     */
    public int getTicketPrice() {
        return ticketPrice;
    }


    /**
     * Sets the ticketPrice value for this OrderInfo.
     * 
     * @param ticketPrice
     */
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


    /**
     * Gets the viewID value for this OrderInfo.
     * 
     * @return viewID
     */
    public int getViewID() {
        return viewID;
    }


    /**
     * Sets the viewID value for this OrderInfo.
     * 
     * @param viewID
     */
    public void setViewID(int viewID) {
        this.viewID = viewID;
    }


    /**
     * Gets the viewName value for this OrderInfo.
     * 
     * @return viewName
     */
    public java.lang.String getViewName() {
        return viewName;
    }


    /**
     * Sets the viewName value for this OrderInfo.
     * 
     * @param viewName
     */
    public void setViewName(java.lang.String viewName) {
        this.viewName = viewName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrderInfo)) return false;
        OrderInfo other = (OrderInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.amount == other.getAmount() &&
            this.cancelFee == other.getCancelFee() &&
            this.changeFee == other.getChangeFee() &&
            ((this.channelSourceId==null && other.getChannelSourceId()==null) || 
             (this.channelSourceId!=null &&
              this.channelSourceId.equals(other.getChannelSourceId()))) &&
            this.consumeCount == other.getConsumeCount() &&
            ((this.customerPayMoney==null && other.getCustomerPayMoney()==null) || 
             (this.customerPayMoney!=null &&
              this.customerPayMoney.equals(other.getCustomerPayMoney()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            this.isCancel == other.getIsCancel() &&
            this.isChangeDate == other.getIsChangeDate() &&
            ((this.lastSyncTime==null && other.getLastSyncTime()==null) || 
             (this.lastSyncTime!=null &&
              this.lastSyncTime.equals(other.getLastSyncTime()))) &&
            ((this.link_man==null && other.getLink_man()==null) || 
             (this.link_man!=null &&
              this.link_man.equals(other.getLink_man()))) &&
            ((this.link_phone==null && other.getLink_phone()==null) || 
             (this.link_phone!=null &&
              this.link_phone.equals(other.getLink_phone()))) &&
            ((this.msgSerail==null && other.getMsgSerail()==null) || 
             (this.msgSerail!=null &&
              this.msgSerail.equals(other.getMsgSerail()))) &&
            ((this.orderDate==null && other.getOrderDate()==null) || 
             (this.orderDate!=null &&
              this.orderDate.equals(other.getOrderDate()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.orderSource==null && other.getOrderSource()==null) || 
             (this.orderSource!=null &&
              this.orderSource.equals(other.getOrderSource()))) &&
            this.orderState == other.getOrderState() &&
            ((this.orderTotalMoney==null && other.getOrderTotalMoney()==null) || 
             (this.orderTotalMoney!=null &&
              this.orderTotalMoney.equals(other.getOrderTotalMoney()))) &&
            this.payChannel == other.getPayChannel() &&
            ((this.payDate==null && other.getPayDate()==null) || 
             (this.payDate!=null &&
              this.payDate.equals(other.getPayDate()))) &&
            this.payMoney == other.getPayMoney() &&
            ((this.payOrderId==null && other.getPayOrderId()==null) || 
             (this.payOrderId!=null &&
              this.payOrderId.equals(other.getPayOrderId()))) &&
            this.payState == other.getPayState() &&
            ((this.payUrl==null && other.getPayUrl()==null) || 
             (this.payUrl!=null &&
              this.payUrl.equals(other.getPayUrl()))) &&
            ((this.playDate==null && other.getPlayDate()==null) || 
             (this.playDate!=null &&
              this.playDate.equals(other.getPlayDate()))) &&
            this.preDays == other.getPreDays() &&
            this.ticketId == other.getTicketId() &&
            ((this.ticketName==null && other.getTicketName()==null) || 
             (this.ticketName!=null &&
              this.ticketName.equals(other.getTicketName()))) &&
            this.ticketPrice == other.getTicketPrice() &&
            this.viewID == other.getViewID() &&
            ((this.viewName==null && other.getViewName()==null) || 
             (this.viewName!=null &&
              this.viewName.equals(other.getViewName())));
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
        _hashCode += getAmount();
        _hashCode += getCancelFee();
        _hashCode += getChangeFee();
        if (getChannelSourceId() != null) {
            _hashCode += getChannelSourceId().hashCode();
        }
        _hashCode += getConsumeCount();
        if (getCustomerPayMoney() != null) {
            _hashCode += getCustomerPayMoney().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        _hashCode += getIsCancel();
        _hashCode += getIsChangeDate();
        if (getLastSyncTime() != null) {
            _hashCode += getLastSyncTime().hashCode();
        }
        if (getLink_man() != null) {
            _hashCode += getLink_man().hashCode();
        }
        if (getLink_phone() != null) {
            _hashCode += getLink_phone().hashCode();
        }
        if (getMsgSerail() != null) {
            _hashCode += getMsgSerail().hashCode();
        }
        if (getOrderDate() != null) {
            _hashCode += getOrderDate().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        if (getOrderSource() != null) {
            _hashCode += getOrderSource().hashCode();
        }
        _hashCode += getOrderState();
        if (getOrderTotalMoney() != null) {
            _hashCode += getOrderTotalMoney().hashCode();
        }
        _hashCode += getPayChannel();
        if (getPayDate() != null) {
            _hashCode += getPayDate().hashCode();
        }
        _hashCode += getPayMoney();
        if (getPayOrderId() != null) {
            _hashCode += getPayOrderId().hashCode();
        }
        _hashCode += getPayState();
        if (getPayUrl() != null) {
            _hashCode += getPayUrl().hashCode();
        }
        if (getPlayDate() != null) {
            _hashCode += getPlayDate().hashCode();
        }
        _hashCode += getPreDays();
        _hashCode += getTicketId();
        if (getTicketName() != null) {
            _hashCode += getTicketName().hashCode();
        }
        _hashCode += getTicketPrice();
        _hashCode += getViewID();
        if (getViewName() != null) {
            _hashCode += getViewName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrderInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "OrderInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "changeFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channelSourceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channelSourceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consumeCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consumeCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerPayMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerPayMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCancel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCancel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isChangeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isChangeDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastSyncTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastSyncTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("link_man");
        elemField.setXmlName(new javax.xml.namespace.QName("", "link_man"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("link_phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "link_phone"));
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
        elemField.setFieldName("orderDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderTotalMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderTotalMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payChannel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payChannel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payOrderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payOrderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("playDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "playDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viewID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "viewID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("viewName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "viewName"));
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
