/**
 * Order_CreateRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Order_CreateRes  implements java.io.Serializable {
    private int buyNum;

    private java.lang.String cancelMoney;

    private java.lang.String customerPayMoney;

    private java.lang.String distributorPayMoney;

    private java.lang.String isCancel;

    private int isOnLinePay;

    private java.lang.String orderDate;

    private java.lang.String orderId;

    private java.lang.String orderMemo;

    private int orderState;

    private java.lang.String payUrl;

    private int postPrice;

    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    private java.lang.String ticketMemo;

    private java.lang.String ticketPrice;

    public Order_CreateRes() {
    }

    public Order_CreateRes(
           int buyNum,
           java.lang.String cancelMoney,
           java.lang.String customerPayMoney,
           java.lang.String distributorPayMoney,
           java.lang.String isCancel,
           int isOnLinePay,
           java.lang.String orderDate,
           java.lang.String orderId,
           java.lang.String orderMemo,
           int orderState,
           java.lang.String payUrl,
           int postPrice,
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead,
           java.lang.String ticketMemo,
           java.lang.String ticketPrice) {
           this.buyNum = buyNum;
           this.cancelMoney = cancelMoney;
           this.customerPayMoney = customerPayMoney;
           this.distributorPayMoney = distributorPayMoney;
           this.isCancel = isCancel;
           this.isOnLinePay = isOnLinePay;
           this.orderDate = orderDate;
           this.orderId = orderId;
           this.orderMemo = orderMemo;
           this.orderState = orderState;
           this.payUrl = payUrl;
           this.postPrice = postPrice;
           this.responseHead = responseHead;
           this.ticketMemo = ticketMemo;
           this.ticketPrice = ticketPrice;
    }


    /**
     * Gets the buyNum value for this Order_CreateRes.
     * 
     * @return buyNum
     */
    public int getBuyNum() {
        return buyNum;
    }


    /**
     * Sets the buyNum value for this Order_CreateRes.
     * 
     * @param buyNum
     */
    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }


    /**
     * Gets the cancelMoney value for this Order_CreateRes.
     * 
     * @return cancelMoney
     */
    public java.lang.String getCancelMoney() {
        return cancelMoney;
    }


    /**
     * Sets the cancelMoney value for this Order_CreateRes.
     * 
     * @param cancelMoney
     */
    public void setCancelMoney(java.lang.String cancelMoney) {
        this.cancelMoney = cancelMoney;
    }


    /**
     * Gets the customerPayMoney value for this Order_CreateRes.
     * 
     * @return customerPayMoney
     */
    public java.lang.String getCustomerPayMoney() {
        return customerPayMoney;
    }


    /**
     * Sets the customerPayMoney value for this Order_CreateRes.
     * 
     * @param customerPayMoney
     */
    public void setCustomerPayMoney(java.lang.String customerPayMoney) {
        this.customerPayMoney = customerPayMoney;
    }


    /**
     * Gets the distributorPayMoney value for this Order_CreateRes.
     * 
     * @return distributorPayMoney
     */
    public java.lang.String getDistributorPayMoney() {
        return distributorPayMoney;
    }


    /**
     * Sets the distributorPayMoney value for this Order_CreateRes.
     * 
     * @param distributorPayMoney
     */
    public void setDistributorPayMoney(java.lang.String distributorPayMoney) {
        this.distributorPayMoney = distributorPayMoney;
    }


    /**
     * Gets the isCancel value for this Order_CreateRes.
     * 
     * @return isCancel
     */
    public java.lang.String getIsCancel() {
        return isCancel;
    }


    /**
     * Sets the isCancel value for this Order_CreateRes.
     * 
     * @param isCancel
     */
    public void setIsCancel(java.lang.String isCancel) {
        this.isCancel = isCancel;
    }


    /**
     * Gets the isOnLinePay value for this Order_CreateRes.
     * 
     * @return isOnLinePay
     */
    public int getIsOnLinePay() {
        return isOnLinePay;
    }


    /**
     * Sets the isOnLinePay value for this Order_CreateRes.
     * 
     * @param isOnLinePay
     */
    public void setIsOnLinePay(int isOnLinePay) {
        this.isOnLinePay = isOnLinePay;
    }


    /**
     * Gets the orderDate value for this Order_CreateRes.
     * 
     * @return orderDate
     */
    public java.lang.String getOrderDate() {
        return orderDate;
    }


    /**
     * Sets the orderDate value for this Order_CreateRes.
     * 
     * @param orderDate
     */
    public void setOrderDate(java.lang.String orderDate) {
        this.orderDate = orderDate;
    }


    /**
     * Gets the orderId value for this Order_CreateRes.
     * 
     * @return orderId
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this Order_CreateRes.
     * 
     * @param orderId
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the orderMemo value for this Order_CreateRes.
     * 
     * @return orderMemo
     */
    public java.lang.String getOrderMemo() {
        return orderMemo;
    }


    /**
     * Sets the orderMemo value for this Order_CreateRes.
     * 
     * @param orderMemo
     */
    public void setOrderMemo(java.lang.String orderMemo) {
        this.orderMemo = orderMemo;
    }


    /**
     * Gets the orderState value for this Order_CreateRes.
     * 
     * @return orderState
     */
    public int getOrderState() {
        return orderState;
    }


    /**
     * Sets the orderState value for this Order_CreateRes.
     * 
     * @param orderState
     */
    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }


    /**
     * Gets the payUrl value for this Order_CreateRes.
     * 
     * @return payUrl
     */
    public java.lang.String getPayUrl() {
        return payUrl;
    }


    /**
     * Sets the payUrl value for this Order_CreateRes.
     * 
     * @param payUrl
     */
    public void setPayUrl(java.lang.String payUrl) {
        this.payUrl = payUrl;
    }


    /**
     * Gets the postPrice value for this Order_CreateRes.
     * 
     * @return postPrice
     */
    public int getPostPrice() {
        return postPrice;
    }


    /**
     * Sets the postPrice value for this Order_CreateRes.
     * 
     * @param postPrice
     */
    public void setPostPrice(int postPrice) {
        this.postPrice = postPrice;
    }


    /**
     * Gets the responseHead value for this Order_CreateRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this Order_CreateRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }


    /**
     * Gets the ticketMemo value for this Order_CreateRes.
     * 
     * @return ticketMemo
     */
    public java.lang.String getTicketMemo() {
        return ticketMemo;
    }


    /**
     * Sets the ticketMemo value for this Order_CreateRes.
     * 
     * @param ticketMemo
     */
    public void setTicketMemo(java.lang.String ticketMemo) {
        this.ticketMemo = ticketMemo;
    }


    /**
     * Gets the ticketPrice value for this Order_CreateRes.
     * 
     * @return ticketPrice
     */
    public java.lang.String getTicketPrice() {
        return ticketPrice;
    }


    /**
     * Sets the ticketPrice value for this Order_CreateRes.
     * 
     * @param ticketPrice
     */
    public void setTicketPrice(java.lang.String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order_CreateRes)) return false;
        Order_CreateRes other = (Order_CreateRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.buyNum == other.getBuyNum() &&
            ((this.cancelMoney==null && other.getCancelMoney()==null) || 
             (this.cancelMoney!=null &&
              this.cancelMoney.equals(other.getCancelMoney()))) &&
            ((this.customerPayMoney==null && other.getCustomerPayMoney()==null) || 
             (this.customerPayMoney!=null &&
              this.customerPayMoney.equals(other.getCustomerPayMoney()))) &&
            ((this.distributorPayMoney==null && other.getDistributorPayMoney()==null) || 
             (this.distributorPayMoney!=null &&
              this.distributorPayMoney.equals(other.getDistributorPayMoney()))) &&
            ((this.isCancel==null && other.getIsCancel()==null) || 
             (this.isCancel!=null &&
              this.isCancel.equals(other.getIsCancel()))) &&
            this.isOnLinePay == other.getIsOnLinePay() &&
            ((this.orderDate==null && other.getOrderDate()==null) || 
             (this.orderDate!=null &&
              this.orderDate.equals(other.getOrderDate()))) &&
            ((this.orderId==null && other.getOrderId()==null) || 
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
            ((this.orderMemo==null && other.getOrderMemo()==null) || 
             (this.orderMemo!=null &&
              this.orderMemo.equals(other.getOrderMemo()))) &&
            this.orderState == other.getOrderState() &&
            ((this.payUrl==null && other.getPayUrl()==null) || 
             (this.payUrl!=null &&
              this.payUrl.equals(other.getPayUrl()))) &&
            this.postPrice == other.getPostPrice() &&
            ((this.responseHead==null && other.getResponseHead()==null) || 
             (this.responseHead!=null &&
              this.responseHead.equals(other.getResponseHead()))) &&
            ((this.ticketMemo==null && other.getTicketMemo()==null) || 
             (this.ticketMemo!=null &&
              this.ticketMemo.equals(other.getTicketMemo()))) &&
            ((this.ticketPrice==null && other.getTicketPrice()==null) || 
             (this.ticketPrice!=null &&
              this.ticketPrice.equals(other.getTicketPrice())));
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
        _hashCode += getBuyNum();
        if (getCancelMoney() != null) {
            _hashCode += getCancelMoney().hashCode();
        }
        if (getCustomerPayMoney() != null) {
            _hashCode += getCustomerPayMoney().hashCode();
        }
        if (getDistributorPayMoney() != null) {
            _hashCode += getDistributorPayMoney().hashCode();
        }
        if (getIsCancel() != null) {
            _hashCode += getIsCancel().hashCode();
        }
        _hashCode += getIsOnLinePay();
        if (getOrderDate() != null) {
            _hashCode += getOrderDate().hashCode();
        }
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
        }
        if (getOrderMemo() != null) {
            _hashCode += getOrderMemo().hashCode();
        }
        _hashCode += getOrderState();
        if (getPayUrl() != null) {
            _hashCode += getPayUrl().hashCode();
        }
        _hashCode += getPostPrice();
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        if (getTicketMemo() != null) {
            _hashCode += getTicketMemo().hashCode();
        }
        if (getTicketPrice() != null) {
            _hashCode += getTicketPrice().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order_CreateRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Order_CreateRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "buyNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerPayMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerPayMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributorPayMoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distributorPayMoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCancel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCancel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOnLinePay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isOnLinePay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderId"));
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
        elemField.setFieldName("orderState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orderState"));
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
        elemField.setFieldName("postPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketPrice"));
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
