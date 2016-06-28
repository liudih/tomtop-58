package com.tomtop.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置设置
 * 
 * @author liulj
 *
 */
@ConfigurationProperties(value = "redis")
public class RedisConfigSettings extends AbstractSettings {
	private String password;
	private String ip;
	private Integer port;
	private Integer timeout;
	private Integer db = 1;
	/**
	 * 默认缓存管理器失效时间
	 */
	private Integer expireTime = 0;
	
	private Integer expireExchangeTime=1800;
	
	private Integer productExchangeTime=1800;
	
	private Integer templateExchangeTime=1800;
	
	
	/**
	 * 每天失效时间
	 */
	private Integer baseExpireTime;

	
	
	public Integer getProductExchangeTime() {
		return productExchangeTime;
	}

	public void setProductExchangeTime(Integer productExchangeTime) {
		this.productExchangeTime = productExchangeTime;
	}

	public Integer getTemplateExchangeTime() {
		return templateExchangeTime;
	}

	public void setTemplateExchangeTime(Integer templateExchangeTime) {
		this.templateExchangeTime = templateExchangeTime;
	}

	public Integer getExpireExchangeTime() {
		return expireExchangeTime;
	}

	public void setExpireExchangeTime(Integer expireExchangeTime) {
		this.expireExchangeTime = expireExchangeTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	

	public Integer getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}


	public Integer getDb() {
		return db;
	}

	public void setDb(Integer db) {
		this.db = db;
	}

	public Integer getBaseExpireTime() {
		return baseExpireTime;
	}

	public void setBaseExpireTime(Integer baseExpireTime) {
		this.baseExpireTime = baseExpireTime;
	}

}
