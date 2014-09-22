/**
 * Tickets_ListReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Tickets_ListReq  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private int viewID;

    private java.lang.String viewName;

    public Tickets_ListReq() {
    }

    public Tickets_ListReq(
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           int viewID,
           java.lang.String viewName) {
           this.requestHead = requestHead;
           this.viewID = viewID;
           this.viewName = viewName;
    }


    /**
     * Gets the requestHead value for this Tickets_ListReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this Tickets_ListReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the viewID value for this Tickets_ListReq.
     * 
     * @return viewID
     */
    public int getViewID() {
        return viewID;
    }


    /**
     * Sets the viewID value for this Tickets_ListReq.
     * 
     * @param viewID
     */
    public void setViewID(int viewID) {
        this.viewID = viewID;
    }


    /**
     * Gets the viewName value for this Tickets_ListReq.
     * 
     * @return viewName
     */
    public java.lang.String getViewName() {
        return viewName;
    }


    /**
     * Sets the viewName value for this Tickets_ListReq.
     * 
     * @param viewName
     */
    public void setViewName(java.lang.String viewName) {
        this.viewName = viewName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tickets_ListReq)) return false;
        Tickets_ListReq other = (Tickets_ListReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
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
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        _hashCode += getViewID();
        if (getViewName() != null) {
            _hashCode += getViewName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Tickets_ListReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Tickets_ListReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
        elemField.setNillable(true);
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
