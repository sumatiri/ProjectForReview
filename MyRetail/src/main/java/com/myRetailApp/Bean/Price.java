package com.myRetailApp.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * Price POJO for the holding price information
 */

@Entity
@Table(name = "Price", schema = "dbo")
@JsonIgnoreProperties(value={  "hibernateLazyInitializer" })
public class Price {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "currency")
	private String currency;
	
	@Column(name = "price")
	private String price;


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrencyCode() {
		return currency;
	}

	public void setCurrencyCode(String currency) {
		this.currency = currency;
	}

}
