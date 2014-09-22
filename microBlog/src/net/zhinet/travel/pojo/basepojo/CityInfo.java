/**
 * CityInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.zhinet.travel.pojo.basepojo;

public class CityInfo  implements java.io.Serializable {
    private int cityCode;

    private java.lang.String cityContentLists;

    private java.lang.Integer cityId;

    private java.lang.String cityImages;

    private java.lang.String cityIntro;

    private double cityLatitude;

    private double cityLongitude;

    private java.lang.String cityName;

    private int citySeaLevel;

    private int provinceCode;

    public CityInfo() {
    }

    public CityInfo(
           int cityCode,
           java.lang.String cityContentLists,
           java.lang.Integer cityId,
           java.lang.String cityImages,
           java.lang.String cityIntro,
           double cityLatitude,
           double cityLongitude,
           java.lang.String cityName,
           int citySeaLevel,
           int provinceCode) {
           this.cityCode = cityCode;
           this.cityContentLists = cityContentLists;
           this.cityId = cityId;
           this.cityImages = cityImages;
           this.cityIntro = cityIntro;
           this.cityLatitude = cityLatitude;
           this.cityLongitude = cityLongitude;
           this.cityName = cityName;
           this.citySeaLevel = citySeaLevel;
           this.provinceCode = provinceCode;
    }


    /**
     * Gets the cityCode value for this CityInfo.
     * 
     * @return cityCode
     */
    public int getCityCode() {
        return cityCode;
    }


    /**
     * Sets the cityCode value for this CityInfo.
     * 
     * @param cityCode
     */
    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }


    /**
     * Gets the cityContentLists value for this CityInfo.
     * 
     * @return cityContentLists
     */
    public java.lang.String getCityContentLists() {
        return cityContentLists;
    }


    /**
     * Sets the cityContentLists value for this CityInfo.
     * 
     * @param cityContentLists
     */
    public void setCityContentLists(java.lang.String cityContentLists) {
        this.cityContentLists = cityContentLists;
    }


    /**
     * Gets the cityId value for this CityInfo.
     * 
     * @return cityId
     */
    public java.lang.Integer getCityId() {
        return cityId;
    }


    /**
     * Sets the cityId value for this CityInfo.
     * 
     * @param cityId
     */
    public void setCityId(java.lang.Integer cityId) {
        this.cityId = cityId;
    }


    /**
     * Gets the cityImages value for this CityInfo.
     * 
     * @return cityImages
     */
    public java.lang.String getCityImages() {
        return cityImages;
    }


    /**
     * Sets the cityImages value for this CityInfo.
     * 
     * @param cityImages
     */
    public void setCityImages(java.lang.String cityImages) {
        this.cityImages = cityImages;
    }


    /**
     * Gets the cityIntro value for this CityInfo.
     * 
     * @return cityIntro
     */
    public java.lang.String getCityIntro() {
        return cityIntro;
    }


    /**
     * Sets the cityIntro value for this CityInfo.
     * 
     * @param cityIntro
     */
    public void setCityIntro(java.lang.String cityIntro) {
        this.cityIntro = cityIntro;
    }


    /**
     * Gets the cityLatitude value for this CityInfo.
     * 
     * @return cityLatitude
     */
    public double getCityLatitude() {
        return cityLatitude;
    }


    /**
     * Sets the cityLatitude value for this CityInfo.
     * 
     * @param cityLatitude
     */
    public void setCityLatitude(double cityLatitude) {
        this.cityLatitude = cityLatitude;
    }


    /**
     * Gets the cityLongitude value for this CityInfo.
     * 
     * @return cityLongitude
     */
    public double getCityLongitude() {
        return cityLongitude;
    }


    /**
     * Sets the cityLongitude value for this CityInfo.
     * 
     * @param cityLongitude
     */
    public void setCityLongitude(double cityLongitude) {
        this.cityLongitude = cityLongitude;
    }


    /**
     * Gets the cityName value for this CityInfo.
     * 
     * @return cityName
     */
    public java.lang.String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this CityInfo.
     * 
     * @param cityName
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the citySeaLevel value for this CityInfo.
     * 
     * @return citySeaLevel
     */
    public int getCitySeaLevel() {
        return citySeaLevel;
    }


    /**
     * Sets the citySeaLevel value for this CityInfo.
     * 
     * @param citySeaLevel
     */
    public void setCitySeaLevel(int citySeaLevel) {
        this.citySeaLevel = citySeaLevel;
    }


    /**
     * Gets the provinceCode value for this CityInfo.
     * 
     * @return provinceCode
     */
    public int getProvinceCode() {
        return provinceCode;
    }


    /**
     * Sets the provinceCode value for this CityInfo.
     * 
     * @param provinceCode
     */
    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CityInfo)) return false;
        CityInfo other = (CityInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cityCode == other.getCityCode() &&
            ((this.cityContentLists==null && other.getCityContentLists()==null) || 
             (this.cityContentLists!=null &&
              this.cityContentLists.equals(other.getCityContentLists()))) &&
            ((this.cityId==null && other.getCityId()==null) || 
             (this.cityId!=null &&
              this.cityId.equals(other.getCityId()))) &&
            ((this.cityImages==null && other.getCityImages()==null) || 
             (this.cityImages!=null &&
              this.cityImages.equals(other.getCityImages()))) &&
            ((this.cityIntro==null && other.getCityIntro()==null) || 
             (this.cityIntro!=null &&
              this.cityIntro.equals(other.getCityIntro()))) &&
            this.cityLatitude == other.getCityLatitude() &&
            this.cityLongitude == other.getCityLongitude() &&
            ((this.cityName==null && other.getCityName()==null) || 
             (this.cityName!=null &&
              this.cityName.equals(other.getCityName()))) &&
            this.citySeaLevel == other.getCitySeaLevel() &&
            this.provinceCode == other.getProvinceCode();
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
        _hashCode += getCityCode();
        if (getCityContentLists() != null) {
            _hashCode += getCityContentLists().hashCode();
        }
        if (getCityId() != null) {
            _hashCode += getCityId().hashCode();
        }
        if (getCityImages() != null) {
            _hashCode += getCityImages().hashCode();
        }
        if (getCityIntro() != null) {
            _hashCode += getCityIntro().hashCode();
        }
        _hashCode += new Double(getCityLatitude()).hashCode();
        _hashCode += new Double(getCityLongitude()).hashCode();
        if (getCityName() != null) {
            _hashCode += getCityName().hashCode();
        }
        _hashCode += getCitySeaLevel();
        _hashCode += getProvinceCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CityInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://basepojo.pojo.travel.zhinet.net", "CityInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityContentLists");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityContentLists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityImages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityImages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityIntro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityIntro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityLatitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityLatitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityLongitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityLongitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citySeaLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "citySeaLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provinceCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provinceCode"));
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
