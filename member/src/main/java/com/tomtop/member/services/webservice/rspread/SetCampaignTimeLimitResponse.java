/**
 * SetCampaignTimeLimitResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tomtop.member.services.webservice.rspread;

public class SetCampaignTimeLimitResponse  implements java.io.Serializable {
    private boolean setCampaignTimeLimitResult;

    public SetCampaignTimeLimitResponse() {
    }

    public SetCampaignTimeLimitResponse(
           boolean setCampaignTimeLimitResult) {
           this.setCampaignTimeLimitResult = setCampaignTimeLimitResult;
    }


    /**
     * Gets the setCampaignTimeLimitResult value for this SetCampaignTimeLimitResponse.
     * 
     * @return setCampaignTimeLimitResult
     */
    public boolean isSetCampaignTimeLimitResult() {
        return setCampaignTimeLimitResult;
    }


    /**
     * Sets the setCampaignTimeLimitResult value for this SetCampaignTimeLimitResponse.
     * 
     * @param setCampaignTimeLimitResult
     */
    public void setSetCampaignTimeLimitResult(boolean setCampaignTimeLimitResult) {
        this.setCampaignTimeLimitResult = setCampaignTimeLimitResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetCampaignTimeLimitResponse)) return false;
        SetCampaignTimeLimitResponse other = (SetCampaignTimeLimitResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.setCampaignTimeLimitResult == other.isSetCampaignTimeLimitResult();
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
        _hashCode += (isSetCampaignTimeLimitResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetCampaignTimeLimitResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.reasonablespread.com/", ">SetCampaignTimeLimitResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setCampaignTimeLimitResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.reasonablespread.com/", "SetCampaignTimeLimitResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
