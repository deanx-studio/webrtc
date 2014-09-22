/**
 * Ticket_InfoRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class Ticket_InfoRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    private net.zhinet.travel.pojo.basepojo.TicketInfo[] scenicTickets;

    public Ticket_InfoRes() {
    }

    public Ticket_InfoRes(
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead,
           net.zhinet.travel.pojo.basepojo.TicketInfo[] scenicTickets) {
           this.responseHead = responseHead;
           this.scenicTickets = scenicTickets;
    }


    /**
     * Gets the responseHead value for this Ticket_InfoRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this Ticket_InfoRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }


    /**
     * Gets the scenicTickets value for this Ticket_InfoRes.
     * 
     * @return scenicTickets
     */
    public net.zhinet.travel.pojo.basepojo.TicketInfo[] getScenicTickets() {
        return scenicTickets;
    }


    /**
     * Sets the scenicTickets value for this Ticket_InfoRes.
     * 
     * @param scenicTickets
     */
    public void setScenicTickets(net.zhinet.travel.pojo.basepojo.TicketInfo[] scenicTickets) {
        this.scenicTickets = scenicTickets;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ticket_InfoRes)) return false;
        Ticket_InfoRes other = (Ticket_InfoRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responseHead==null && other.getResponseHead()==null) || 
             (this.responseHead!=null &&
              this.responseHead.equals(other.getResponseHead()))) &&
            ((this.scenicTickets==null && other.getScenicTickets()==null) || 
             (this.scenicTickets!=null &&
              java.util.Arrays.equals(this.scenicTickets, other.getScenicTickets())));
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
        if (getResponseHead() != null) {
            _hashCode += getResponseHead().hashCode();
        }
        if (getScenicTickets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScenicTickets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getScenicTickets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ticket_InfoRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "Ticket_InfoRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicTickets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicTickets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "TicketInfo"));
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
