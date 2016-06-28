/**
 * GetCampaignClicksResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tomtop.member.services.webservice.rspread;

public class GetCampaignClicksResponse  implements java.io.Serializable {
    private GetCampaignClicksResponseGetCampaignClicksResult getCampaignClicksResult;

    public GetCampaignClicksResponse() {
    }

    public GetCampaignClicksResponse(
           GetCampaignClicksResponseGetCampaignClicksResult getCampaignClicksResult) {
           this.getCampaignClicksResult = getCampaignClicksResult;
    }


    /**
     * Gets the getCampaignClicksResult value for this GetCampaignClicksResponse.
     * 
     * @return getCampaignClicksResult
     */
    public GetCampaignClicksResponseGetCampaignClicksResult getGetCampaignClicksResult() {
        return getCampaignClicksResult;
    }


    /**
     * Sets the getCampaignClicksResult value for this GetCampaignClicksResponse.
     * 
     * @param getCampaignClicksResult
     */
    public void setGetCampaignClicksResult(GetCampaignClicksResponseGetCampaignClicksResult getCampaignClicksResult) {
        this.getCampaignClicksResult = getCampaignClicksResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCampaignClicksResponse)) return false;
        GetCampaignClicksResponse other = (GetCampaignClicksResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCampaignClicksResult==null && other.getGetCampaignClicksResult()==null) || 
             (this.getCampaignClicksResult!=null &&
              this.getCampaignClicksResult.equals(other.getGetCampaignClicksResult())));
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
        if (getGetCampaignClicksResult() != null) {
            _hashCode += getGetCampaignClicksResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCampaignClicksResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.reasonablespread.com/", ">GetCampaignClicksResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCampaignClicksResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.reasonablespread.com/", "GetCampaignClicksResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.reasonablespread.com/", ">>GetCampaignClicksResponse>GetCampaignClicksResult"));
        elemField.setMinOccurs(0);
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
