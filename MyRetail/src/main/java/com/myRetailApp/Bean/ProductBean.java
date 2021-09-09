package com.myRetailApp.Bean;

/*
 * ProductBean is combination of Product data and Price. This is returned
 * to the API which is consuming myRetail API. This gives back the data in
 * expected Json format
 */
public class ProductBean {
	private String id;
	private String name;

	private Price current_price;

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

	public Price getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(Price current_price) {
		this.current_price = current_price;
	}

}
