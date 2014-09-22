/**
 * ScenicInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class ScenicInfo  implements java.io.Serializable {
    private java.lang.String cityName;

    private java.util.Calendar makeTime;

    private java.lang.String scenicAddr;

    private java.lang.Integer scenicId;

    private java.lang.String scenicImages;

    private java.lang.String scenicImg;

    private java.lang.String scenicIntro;

    private double scenicLatitude;

    private double scenicLongitude;

    private java.lang.String scenicName;

    private int scenicSeaLevel;

    private net.zhinet.travel.pojo.basepojo.TicketInfo[] scenicTickets;

    private java.lang.String scenicTraffic;

    private java.lang.String scenicTrafficDetail;

    private short scenicType;

    private short status;

    private int userId;

    public ScenicInfo() {
    }

    public ScenicInfo(
           java.lang.String cityName,
           java.util.Calendar makeTime,
           java.lang.String scenicAddr,
           java.lang.Integer scenicId,
           java.lang.String scenicImages,
           java.lang.String scenicImg,
           java.lang.String scenicIntro,
           double scenicLatitude,
           double scenicLongitude,
           java.lang.String scenicName,
           int scenicSeaLevel,
           net.zhinet.travel.pojo.basepojo.TicketInfo[] scenicTickets,
           java.lang.String scenicTraffic,
           java.lang.String scenicTrafficDetail,
           short scenicType,
           short status,
           int userId) {
           this.cityName = cityName;
           this.makeTime = makeTime;
           this.scenicAddr = scenicAddr;
           this.scenicId = scenicId;
           this.scenicImages = scenicImages;
           this.scenicImg = scenicImg;
           this.scenicIntro = scenicIntro;
           this.scenicLatitude = scenicLatitude;
           this.scenicLongitude = scenicLongitude;
           this.scenicName = scenicName;
           this.scenicSeaLevel = scenicSeaLevel;
           this.scenicTickets = scenicTickets;
           this.scenicTraffic = scenicTraffic;
           this.scenicTrafficDetail = scenicTrafficDetail;
           this.scenicType = scenicType;
           this.status = status;
           this.userId = userId;
    }


    /**
     * Gets the cityName value for this ScenicInfo.
     * 
     * @return cityName
     */
    public java.lang.String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this ScenicInfo.
     * 
     * @param cityName
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the makeTime value for this ScenicInfo.
     * 
     * @return makeTime
     */
    public java.util.Calendar getMakeTime() {
        return makeTime;
    }


    /**
     * Sets the makeTime value for this ScenicInfo.
     * 
     * @param makeTime
     */
    public void setMakeTime(java.util.Calendar makeTime) {
        this.makeTime = makeTime;
    }


    /**
     * Gets the scenicAddr value for this ScenicInfo.
     * 
     * @return scenicAddr
     */
    public java.lang.String getScenicAddr() {
        return scenicAddr;
    }


    /**
     * Sets the scenicAddr value for this ScenicInfo.
     * 
     * @param scenicAddr
     */
    public void setScenicAddr(java.lang.String scenicAddr) {
        this.scenicAddr = scenicAddr;
    }


    /**
     * Gets the scenicId value for this ScenicInfo.
     * 
     * @return scenicId
     */
    public java.lang.Integer getScenicId() {
        return scenicId;
    }


    /**
     * Sets the scenicId value for this ScenicInfo.
     * 
     * @param scenicId
     */
    public void setScenicId(java.lang.Integer scenicId) {
        this.scenicId = scenicId;
    }


    /**
     * Gets the scenicImages value for this ScenicInfo.
     * 
     * @return scenicImages
     */
    public java.lang.String getScenicImages() {
        return scenicImages;
    }


    /**
     * Sets the scenicImages value for this ScenicInfo.
     * 
     * @param scenicImages
     */
    public void setScenicImages(java.lang.String scenicImages) {
        this.scenicImages = scenicImages;
    }


    /**
     * Gets the scenicImg value for this ScenicInfo.
     * 
     * @return scenicImg
     */
    public java.lang.String getScenicImg() {
        return scenicImg;
    }


    /**
     * Sets the scenicImg value for this ScenicInfo.
     * 
     * @param scenicImg
     */
    public void setScenicImg(java.lang.String scenicImg) {
        this.scenicImg = scenicImg;
    }


    /**
     * Gets the scenicIntro value for this ScenicInfo.
     * 
     * @return scenicIntro
     */
    public java.lang.String getScenicIntro() {
        return scenicIntro;
    }


    /**
     * Sets the scenicIntro value for this ScenicInfo.
     * 
     * @param scenicIntro
     */
    public void setScenicIntro(java.lang.String scenicIntro) {
        this.scenicIntro = scenicIntro;
    }


    /**
     * Gets the scenicLatitude value for this ScenicInfo.
     * 
     * @return scenicLatitude
     */
    public double getScenicLatitude() {
        return scenicLatitude;
    }


    /**
     * Sets the scenicLatitude value for this ScenicInfo.
     * 
     * @param scenicLatitude
     */
    public void setScenicLatitude(double scenicLatitude) {
        this.scenicLatitude = scenicLatitude;
    }


    /**
     * Gets the scenicLongitude value for this ScenicInfo.
     * 
     * @return scenicLongitude
     */
    public double getScenicLongitude() {
        return scenicLongitude;
    }


    /**
     * Sets the scenicLongitude value for this ScenicInfo.
     * 
     * @param scenicLongitude
     */
    public void setScenicLongitude(double scenicLongitude) {
        this.scenicLongitude = scenicLongitude;
    }


    /**
     * Gets the scenicName value for this ScenicInfo.
     * 
     * @return scenicName
     */
    public java.lang.String getScenicName() {
        return scenicName;
    }


    /**
     * Sets the scenicName value for this ScenicInfo.
     * 
     * @param scenicName
     */
    public void setScenicName(java.lang.String scenicName) {
        this.scenicName = scenicName;
    }


    /**
     * Gets the scenicSeaLevel value for this ScenicInfo.
     * 
     * @return scenicSeaLevel
     */
    public int getScenicSeaLevel() {
        return scenicSeaLevel;
    }


    /**
     * Sets the scenicSeaLevel value for this ScenicInfo.
     * 
     * @param scenicSeaLevel
     */
    public void setScenicSeaLevel(int scenicSeaLevel) {
        this.scenicSeaLevel = scenicSeaLevel;
    }


    /**
     * Gets the scenicTickets value for this ScenicInfo.
     * 
     * @return scenicTickets
     */
    public net.zhinet.travel.pojo.basepojo.TicketInfo[] getScenicTickets() {
        return scenicTickets;
    }


    /**
     * Sets the scenicTickets value for this ScenicInfo.
     * 
     * @param scenicTickets
     */
    public void setScenicTickets(net.zhinet.travel.pojo.basepojo.TicketInfo[] scenicTickets) {
        this.scenicTickets = scenicTickets;
    }


    /**
     * Gets the scenicTraffic value for this ScenicInfo.
     * 
     * @return scenicTraffic
     */
    public java.lang.String getScenicTraffic() {
        return scenicTraffic;
    }


    /**
     * Sets the scenicTraffic value for this ScenicInfo.
     * 
     * @param scenicTraffic
     */
    public void setScenicTraffic(java.lang.String scenicTraffic) {
        this.scenicTraffic = scenicTraffic;
    }


    /**
     * Gets the scenicTrafficDetail value for this ScenicInfo.
     * 
     * @return scenicTrafficDetail
     */
    public java.lang.String getScenicTrafficDetail() {
        return scenicTrafficDetail;
    }


    /**
     * Sets the scenicTrafficDetail value for this ScenicInfo.
     * 
     * @param scenicTrafficDetail
     */
    public void setScenicTrafficDetail(java.lang.String scenicTrafficDetail) {
        this.scenicTrafficDetail = scenicTrafficDetail;
    }


    /**
     * Gets the scenicType value for this ScenicInfo.
     * 
     * @return scenicType
     */
    public short getScenicType() {
        return scenicType;
    }


    /**
     * Sets the scenicType value for this ScenicInfo.
     * 
     * @param scenicType
     */
    public void setScenicType(short scenicType) {
        this.scenicType = scenicType;
    }


    /**
     * Gets the status value for this ScenicInfo.
     * 
     * @return status
     */
    public short getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ScenicInfo.
     * 
     * @param status
     */
    public void setStatus(short status) {
        this.status = status;
    }


    /**
     * Gets the userId value for this ScenicInfo.
     * 
     * @return userId
     */
    public int getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this ScenicInfo.
     * 
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ScenicInfo)) return false;
        ScenicInfo other = (ScenicInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cityName==null && other.getCityName()==null) || 
             (this.cityName!=null &&
              this.cityName.equals(other.getCityName()))) &&
            ((this.makeTime==null && other.getMakeTime()==null) || 
             (this.makeTime!=null &&
              this.makeTime.equals(other.getMakeTime()))) &&
            ((this.scenicAddr==null && other.getScenicAddr()==null) || 
             (this.scenicAddr!=null &&
              this.scenicAddr.equals(other.getScenicAddr()))) &&
            ((this.scenicId==null && other.getScenicId()==null) || 
             (this.scenicId!=null &&
              this.scenicId.equals(other.getScenicId()))) &&
            ((this.scenicImages==null && other.getScenicImages()==null) || 
             (this.scenicImages!=null &&
              this.scenicImages.equals(other.getScenicImages()))) &&
            ((this.scenicImg==null && other.getScenicImg()==null) || 
             (this.scenicImg!=null &&
              this.scenicImg.equals(other.getScenicImg()))) &&
            ((this.scenicIntro==null && other.getScenicIntro()==null) || 
             (this.scenicIntro!=null &&
              this.scenicIntro.equals(other.getScenicIntro()))) &&
            this.scenicLatitude == other.getScenicLatitude() &&
            this.scenicLongitude == other.getScenicLongitude() &&
            ((this.scenicName==null && other.getScenicName()==null) || 
             (this.scenicName!=null &&
              this.scenicName.equals(other.getScenicName()))) &&
            this.scenicSeaLevel == other.getScenicSeaLevel() &&
            ((this.scenicTickets==null && other.getScenicTickets()==null) || 
             (this.scenicTickets!=null &&
              java.util.Arrays.equals(this.scenicTickets, other.getScenicTickets()))) &&
            ((this.scenicTraffic==null && other.getScenicTraffic()==null) || 
             (this.scenicTraffic!=null &&
              this.scenicTraffic.equals(other.getScenicTraffic()))) &&
            ((this.scenicTrafficDetail==null && other.getScenicTrafficDetail()==null) || 
             (this.scenicTrafficDetail!=null &&
              this.scenicTrafficDetail.equals(other.getScenicTrafficDetail()))) &&
            this.scenicType == other.getScenicType() &&
            this.status == other.getStatus() &&
            this.userId == other.getUserId();
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
        if (getCityName() != null) {
            _hashCode += getCityName().hashCode();
        }
        if (getMakeTime() != null) {
            _hashCode += getMakeTime().hashCode();
        }
        if (getScenicAddr() != null) {
            _hashCode += getScenicAddr().hashCode();
        }
        if (getScenicId() != null) {
            _hashCode += getScenicId().hashCode();
        }
        if (getScenicImages() != null) {
            _hashCode += getScenicImages().hashCode();
        }
        if (getScenicImg() != null) {
            _hashCode += getScenicImg().hashCode();
        }
        if (getScenicIntro() != null) {
            _hashCode += getScenicIntro().hashCode();
        }
        _hashCode += new Double(getScenicLatitude()).hashCode();
        _hashCode += new Double(getScenicLongitude()).hashCode();
        if (getScenicName() != null) {
            _hashCode += getScenicName().hashCode();
        }
        _hashCode += getScenicSeaLevel();
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
        if (getScenicTraffic() != null) {
            _hashCode += getScenicTraffic().hashCode();
        }
        if (getScenicTrafficDetail() != null) {
            _hashCode += getScenicTrafficDetail().hashCode();
        }
        _hashCode += getScenicType();
        _hashCode += getStatus();
        _hashCode += getUserId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScenicInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "ScenicInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("makeTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "makeTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicAddr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicImages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicImages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicImg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicImg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicIntro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicIntro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicLatitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicLatitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicLongitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicLongitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicSeaLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicSeaLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicTickets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicTickets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "TicketInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicTraffic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicTraffic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicTrafficDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicTrafficDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scenicType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scenicType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
