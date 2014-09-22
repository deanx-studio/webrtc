/**
 * View_InfoRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.reqandrespojo;

public class View_InfoRes  implements java.io.Serializable {
    private net.zhinet.travel.pojo.basepojo.ResponseHead responseHead;

    private net.zhinet.travel.pojo.basepojo.ScenicInfo[] scenicDetail;

    public View_InfoRes() {
    }

    public View_InfoRes(
           net.zhinet.travel.pojo.basepojo.ResponseHead responseHead,
           net.zhinet.travel.pojo.basepojo.ScenicInfo[] scenicDetail) {
           this.responseHead = responseHead;
           this.scenicDetail = scenicDetail;
    }


    /**
     * Gets the responseHead value for this View_InfoRes.
     * 
     * @return responseHead
     */
    public net.zhinet.travel.pojo.basepojo.ResponseHead getResponseHead() {
        return responseHead;
    }


    /**
     * Sets the responseHead value for this View_InfoRes.
     * 
     * @param responseHead
     */
    public void setResponseHead(net.zhinet.travel.pojo.basepojo.ResponseHead responseHead) {
        this.responseHead = responseHead;
    }


    /**
     * Gets the scenicDetail value for this View_InfoRes.
     * 
     * @return scenicDetail
     */
    public net.zhinet.travel.pojo.basepojo.ScenicInfo[] getScenicDetail() {
        return scenicDetail;
    }


    /**
     * Sets the scenicDetail value for this View_InfoRes.
     * 
     * @param scenicDetail
     */
    public void setScenicDetail(net.zhinet.travel.pojo.basepojo.ScenicInfo[] scenicDetail) {
        this.scenicDetail = scenicDetail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof View_InfoRes)) return false;
        View_InfoRes other = (View_InfoRes) obj;
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
            ((this.scenicDetail==null && other.getScenicDetail()==null) || 
             (this.scenicDetail!=null &&
              java.util.Arrays.equals(this.scenicDetail, other.getScenicDetail())));
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
        if (getScenicDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getScenicDetail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getScenicDetail(), i);
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
        new org.apache.axis.description.TypeDesc(View_InfoRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://reqandrespojo.pojo.travel.zhinet.net", "View_InfoRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseHead");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseHead"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ResponseHead"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ScenicInfo"));
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
