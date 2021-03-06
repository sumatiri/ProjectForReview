package com.consumer.Bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="spring.demo")
@Configuration
public class ConfProperties {
	private String produrl;
	private String priceurl;
	private String getreq;
	private String postreq;
	private String putreq;
	private String code;
	
	private String name;
	private String price;
	private String  curr;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public String getProdurl() {
		return produrl;
	}

	public void setProdurl(String produrl) {
		this.produrl = produrl;
	}

	public String getPriceurl() {
		return priceurl;
	}

	public void setPriceurl(String priceurl) {
		this.priceurl = priceurl;
	}

	public String getGetreq() {
		return getreq;
	}

	public void setGetreq(String getreq) {
		this.getreq = getreq;
	}

	public String getPostreq() {
		return postreq;
	}

	public void setPostreq(String postreq) {
		this.postreq = postreq;
	}

	public String getPutreq() {
		return putreq;
	}

	public void setPutreq(String putreq) {
		this.putreq = putreq;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
