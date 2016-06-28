package com.tomtop.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.fastjson.JSONArray;

/**
 * es配置设置
 * @author lijun
 *
 */
@ConfigurationProperties(value = "es")
public class EsConfigSettings {

	private String productAll;
	private String productEn;
	private String productEs;
	private String productRu;
	private String productDe;
	private String productFr;
	private String productIt;
	private String productJp;
	private String productPt;
	private String numberOfShards;
	private String numberOfReplicas;
	private String clientTransportSniff;
	private String clusterName;
	private String clientTransportPingTimeout;
	private JSONArray clientNodesIp;
	private JSONArray clientNodesPort;
	private String brand;
	private String mutilProType;
	private String proPrice;
	private String proTags;
	private String routes;
	private String baseLanguage;
	private String baseProductType;
	private String baseGetkeysbytypeid;
	private String baseGetallshowkeybykey;
	private String baseAllshowkey;
	private String baseAllshowvalues;

	public String getProductAll() {
		return productAll;
	}

	public void setProductAll(String productAll) {
		this.productAll = productAll;
	}

	public String getProductEn() {
		return productEn;
	}

	public void setProductEn(String productEn) {
		this.productEn = productEn;
	}

	public String getProductEs() {
		return productEs;
	}

	public void setProductEs(String productEs) {
		this.productEs = productEs;
	}

	public String getProductRu() {
		return productRu;
	}

	public void setProductRu(String productRu) {
		this.productRu = productRu;
	}

	public String getProductDe() {
		return productDe;
	}

	public void setProductDe(String productDe) {
		this.productDe = productDe;
	}

	public String getProductFr() {
		return productFr;
	}

	public void setProductFr(String productFr) {
		this.productFr = productFr;
	}

	public String getProductIt() {
		return productIt;
	}

	public void setProductIt(String productIt) {
		this.productIt = productIt;
	}

	public String getProductJp() {
		return productJp;
	}

	public void setProductJp(String productJp) {
		this.productJp = productJp;
	}

	public String getProductPt() {
		return productPt;
	}

	public void setProductPt(String productPt) {
		this.productPt = productPt;
	}

	public String getNumberOfShards() {
		return numberOfShards;
	}

	public void setNumberOfShards(String numberOfShards) {
		this.numberOfShards = numberOfShards;
	}

	public String getNumberOfReplicas() {
		return numberOfReplicas;
	}

	public void setNumberOfReplicas(String numberOfReplicas) {
		this.numberOfReplicas = numberOfReplicas;
	}

	public String getClientTransportSniff() {
		return clientTransportSniff;
	}

	public void setClientTransportSniff(String clientTransportSniff) {
		this.clientTransportSniff = clientTransportSniff;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getClientTransportPingTimeout() {
		return clientTransportPingTimeout;
	}

	public void setClientTransportPingTimeout(String clientTransportPingTimeout) {
		this.clientTransportPingTimeout = clientTransportPingTimeout;
	}

	public JSONArray getClientNodesIp() {
		return clientNodesIp;
	}

	public void setClientNodesIp(String clientNodesIp) {
		this.clientNodesIp = JSONArray.parseArray(clientNodesIp);
	}

	public JSONArray getClientNodesPort() {
		return clientNodesPort;
	}

	public void setClientNodesPort(String clientNodesPort) {
		this.clientNodesPort = JSONArray.parseArray(clientNodesPort);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMutilProType() {
		return mutilProType;
	}

	public void setMutilProType(String mutilProType) {
		this.mutilProType = mutilProType;
	}

	public String getProPrice() {
		return proPrice;
	}

	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}

	public String getProTags() {
		return proTags;
	}

	public void setProTags(String proTags) {
		this.proTags = proTags;
	}

	public String getRoutes() {
		return routes;
	}

	public void setRoutes(String routes) {
		this.routes = routes;
	}

	public String getBaseLanguage() {
		return baseLanguage;
	}

	public void setBaseLanguage(String baseLanguage) {
		this.baseLanguage = baseLanguage;
	}

	public String getBaseProductType() {
		return baseProductType;
	}

	public void setBaseProductType(String baseProductType) {
		this.baseProductType = baseProductType;
	}

	public String getBaseGetkeysbytypeid() {
		return baseGetkeysbytypeid;
	}

	public void setBaseGetkeysbytypeid(String baseGetkeysbytypeid) {
		this.baseGetkeysbytypeid = baseGetkeysbytypeid;
	}

	public String getBaseGetallshowkeybykey() {
		return baseGetallshowkeybykey;
	}

	public void setBaseGetallshowkeybykey(String baseGetallshowkeybykey) {
		this.baseGetallshowkeybykey = baseGetallshowkeybykey;
	}

	public String getBaseAllshowkey() {
		return baseAllshowkey;
	}

	public void setBaseAllshowkey(String baseAllshowkey) {
		this.baseAllshowkey = baseAllshowkey;
	}

	public String getBaseAllshowvalues() {
		return baseAllshowvalues;
	}

	public void setBaseAllshowvalues(String baseAllshowvalues) {
		this.baseAllshowvalues = baseAllshowvalues;
	}

}
