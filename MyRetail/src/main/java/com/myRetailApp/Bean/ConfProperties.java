package com.myRetailApp.Bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="spring.demo")
@Configuration
public class ConfProperties {
	
	private String id;
	private String name;
	private String currency;
	private String price;
	
	private String priceobj;
	public String getPriceobj() {
		return priceobj;
	}
	public void setPriceobj(String priceobj) {
		this.priceobj = priceobj;
	}
	public String getProductobj() {
		return productobj;
	}
	public void setProductobj(String productobj) {
		this.productobj = productobj;
	}
	private String productobj;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
