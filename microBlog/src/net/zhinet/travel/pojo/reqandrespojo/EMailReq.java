/**
 * EMailReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class EMailReq  implements java.io.Serializable {
    private java.lang.String content;

    private java.lang.String copytoAddr;

    private java.lang.String destAddr;

    private net.zhinet.travel.pojo.basepojo.RequestHead requestHead;

    private java.lang.String title;

    public EMailReq() {
    }

    public EMailReq(
           java.lang.String content,
           java.lang.String copytoAddr,
           java.lang.String destAddr,
           net.zhinet.travel.pojo.basepojo.RequestHead requestHead,
           java.lang.String title) {
           this.content = content;
           this.copytoAddr = copytoAddr;
           this.destAddr = destAddr;
           this.requestHead = requestHead;
           this.title = title;
    }


    /**
     * Gets the content value for this EMailReq.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this EMailReq.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the copytoAddr value for this EMailReq.
     * 
     * @return copytoAddr
     */
    public java.lang.String getCopytoAddr() {
        return copytoAddr;
    }


    /**
     * Sets the copytoAddr value for this EMailReq.
     * 
     * @param copytoAddr
     */
    public void setCopytoAddr(java.lang.String copytoAddr) {
        this.copytoAddr = copytoAddr;
    }


    /**
     * Gets the destAddr value for this EMailReq.
     * 
     * @return destAddr
     */
    public java.lang.String getDestAddr() {
        return destAddr;
    }


    /**
     * Sets the destAddr value for this EMailReq.
     * 
     * @param destAddr
     */
    public void setDestAddr(java.lang.String destAddr) {
        this.destAddr = destAddr;
    }


    /**
     * Gets the requestHead value for this EMailReq.
     * 
     * @return requestHead
     */
    public net.zhinet.travel.pojo.basepojo.RequestHead getRequestHead() {
        return requestHead;
    }


    /**
     * Sets the requestHead value for this EMailReq.
     * 
     * @param requestHead
     */
    public void setRequestHead(net.zhinet.travel.pojo.basepojo.RequestHead requestHead) {
        this.requestHead = requestHead;
    }


    /**
     * Gets the title value for this EMailReq.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this EMailReq.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EMailReq)) return false;
        EMailReq other = (EMailReq) obj;
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
            ((this.copytoAddr==null && other.getCopytoAddr()==null) || 
             (this.copytoAddr!=null &&
              this.copytoAddr.equals(other.getCopytoAddr()))) &&
            ((this.destAddr==null && other.getDestAddr()==null) || 
             (this.destAddr!=null &&
              this.destAddr.equals(other.getDestAddr()))) &&
            ((this.requestHead==null && other.getRequestHead()==null) || 
             (this.requestHead!=null &&
              this.requestHead.equals(other.getRequestHead()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
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
        if (getCopytoAddr() != null) {
            _hashCode += getCopytoAddr().hashCode();
        }
        if (getDestAddr() != null) {
            _hashCode += getDestAddr().hashCode();
        }
        if (getRequestHead() != null) {
            _hashCode += getRequestHead().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EMailReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "EMailReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("copytoAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "copytoAddr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destAddr"));
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
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
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
