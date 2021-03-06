package com.myRetailApp.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * Product POJO holds the product name and Id
 */
@Entity
@Table(name = "Product", schema = "dbo")
@JsonIgnoreProperties(value={  "hibernateLazyInitializer" })
public class Product {
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;

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
	
	
}
