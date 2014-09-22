/**
 * City_CommentReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class City_CommentReq  implements java.io.Serializable {
    private java.util.Calendar commentDate;

    private java.lang.String provinceName;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHeader;

    public City_CommentReq() {
    }

    public City_CommentReq(
           java.util.Calendar commentDate,
           java.lang.String provinceName,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHeader) {
           this.commentDate = commentDate;
           this.provinceName = provinceName;
           this.requestHeader = requestHeader;
    }


    /**
     * Gets the commentDate value for this City_CommentReq.
     * 
     * @return commentDate
     */
    public java.util.Calendar getCommentDate() {
        return commentDate;
    }


    /**
     * Sets the commentDate value for this City_CommentReq.
     * 
     * @param commentDate
     */
    public void setCommentDate(java.util.Calendar commentDate) {
        this.commentDate = commentDate;
    }


    /**
     * Gets the provinceName value for this City_CommentReq.
     * 
     * @return provinceName
     */
    public java.lang.String getProvinceName() {
        return provinceName;
    }


    /**
     * Sets the provinceName value for this City_CommentReq.
     * 
     * @param provinceName
     */
    public void setProvinceName(java.lang.String provinceName) {
        this.provinceName = provinceName;
    }


    /**
     * Gets the requestHeader value for this City_CommentReq.
     * 
     * @return requestHeader
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHeader() {
        return requestHeader;
    }


    /**
     * Sets the requestHeader value for this City_CommentReq.
     * 
     * @param requestHeader
     */
    public void setRequestHeader(net.zhinet.travel.pojo.basepojo.RequestHead requestHeader) {
        this.requestHeader = requestHeader;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof City_CommentReq)) return false;
        City_CommentReq other = (City_CommentReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.commentDate==null && other.getCommentDate()==null) || 
             (this.commentDate!=null &&
              this.commentDate.equals(other.getCommentDate()))) &&
            ((this.provinceName==null && other.getProvinceName()==null) || 
             (this.provinceName!=null &&
              this.provinceName.equals(other.getProvinceName()))) &&
            ((this.requestHeader==null && other.getRequestHeader()==null) || 
             (this.requestHeader!=null &&
              this.requestHeader.equals(other.getRequestHeader())));
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
        if (getCommentDate() != null) {
            _hashCode += getCommentDate().hashCode();
        }
        if (getProvinceName() != null) {
            _hashCode += getProvinceName().hashCode();
        }
        if (getRequestHeader() != null) {
            _hashCode += getRequestHeader().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(City_CommentReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "City_CommentReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestHeader");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestHeader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "RequestHead"));
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
