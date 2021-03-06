package com.consumer.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.consumer.Bean.ConfProperties;
import com.consumer.Bean.Current_Price;
import com.consumer.Bean.ProductData;
import com.consumer.exception.ProductGenericException;
import com.consumer.exception.ProductNotFoundException;
import com.consumer.helper.Helper;

@RestController
public class TargetController {
	
	@Autowired
	Helper helper;
	
	@Autowired
	ConfProperties properties;
	
	@PostMapping(path="/products/{id}")
	
	public ResponseEntity<Object> create(@RequestBody ProductData prod)  {
		 
		try {
			return helper.setPutPostConn(prod, properties.getPostreq());
		} catch ( Exception e) {
			throw new ProductGenericException();
		} 
	}
	
	@PutMapping(path="products/{id}")
	
	public ResponseEntity<Object> update(@RequestBody ProductData prod)   {
		
		try {
			return helper.setPutPostConn(prod, properties.getPutreq());
		} catch ( Exception e) {
			throw new ProductGenericException();
		} 
	}

	@GetMapping(path="products/{id}")
	
	public ProductData getProductName(@PathVariable String id)  {
		
		String inline="";
		ProductData pd=new ProductData();
		
		
		URL url=null;
		
		try {
			url=new URL(properties.getProdurl()+id);
			String[] arr=new String[1];
			arr[0]=new String(properties.getName());
			HashMap<String, String> result=helper.setGetConn(url, arr, properties.getGetreq());
			
			String name=result.get(properties.getName());
			pd.setName(name);
			pd.setId(id);
			
			url=new URL(properties.getPriceurl()+id);
			String[] arrPrice=new String[2];
			
			arrPrice[0]=properties.getPrice();
			arrPrice[1]=properties.getCode();
			
			HashMap<String,String> prResult=helper.setGetConn(url, arrPrice, properties.getGetreq());
			
			Current_Price pr=new Current_Price();
			String price=prResult.get(properties.getPrice());
			 
			pr.setValue(price);
			
			String currency=prResult.get(properties.getCode());
			pr.setCurrencyCode(currency);
			pd.setCurrent_price(pr);
			return pd;
		} 	catch (RuntimeException e) {
			System.out.println("Throwing product not found exception");
			throw new ProductNotFoundException();
 		} catch (Exception e) {
 			System.out.println("Throwing a generic exception");
			throw new ProductGenericException();
		}

	 
		
	}

}
