package com.myRetailApp.controller;

import java.net.URI;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myRetailApp.Bean.ConfProperties;
import com.myRetailApp.Bean.Price;
import com.myRetailApp.Bean.Product;
import com.myRetailApp.Bean.ProductBean;
import com.myRetailApp.Exceptions.ProductNotFoundException;
import com.myRetailApp.Services.PriceServiceImpl;
import com.myRetailApp.Services.ProductBeanServiceImpl;
import com.myRetailApp.Services.ProductServiceImpl;
 

@RestController
public class RetailAppController {
	
	@Autowired
	ProductServiceImpl svcImpl;
	
	@Autowired
	PriceServiceImpl prsvcImpl;
	
	@Autowired
	ProductBeanServiceImpl pdBeanImpl;
	
	@Autowired
	ConfProperties configProperties;
	
	@GetMapping(path="/product/{id}")
	public Product getProductName(@PathVariable String id)   {
		try {
			Product pd = svcImpl.getProductName(id);

			return pd;

		} catch (Exception e) {
			throw new ProductNotFoundException();
		}

	}
	
	@GetMapping(path="/price/{id}")
	public Price getCurrencyCode(@PathVariable String id) {
		try {
			Price pr = prsvcImpl.getPriceDetails(id);

			return pr;
		} catch (Exception e) {
			throw new ProductNotFoundException();
		}
	}
	
	@PostMapping(path="/product/{id}")
	
	public ResponseEntity<Object> createProduct(@RequestBody Object prod) {
		try {
			HashMap<String, Object> productInfoMap = getProdPrice(prod);

			Product status = svcImpl
					.insertProductDetails((Product) productInfoMap.get(configProperties.getProductobj()));
			Price pr = prsvcImpl.savePrice((Price) productInfoMap.get(configProperties.getPriceobj()));
			ProductBean pdBean = pdBeanImpl.getProdBean(status, pr);

			return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ProductNotFoundException();
		}

	}
	
	
	@PutMapping(path="/product/{id}")
	
	public ResponseEntity<Object> updateProduct(@RequestBody Object prod)   {
		try {
			HashMap<String, Object> productInfoMap = getProdPrice(prod);
			Product status = svcImpl.updateProduct((Product) productInfoMap.get(configProperties.getProductobj()));
			Price pr = prsvcImpl.updatePrice((Price) productInfoMap.get(configProperties.getPriceobj()));
			ProductBean pdBean = pdBeanImpl.getProdBean(status, pr);
			 

			return new ResponseEntity<>("Product is updated successfully", HttpStatus.CREATED);
		}  catch (Exception e) {
			throw new ProductNotFoundException();
		}

	}
	
	private HashMap<String,Object> getProdPrice(Object prodInfo) {
		HashMap<String,String> productDetails=null;
		if(prodInfo instanceof HashMap) {
			productDetails=(HashMap<String,String>)prodInfo;
		}
		
		Product prodToAdd=new Product();
		 
		prodToAdd.setId( productDetails.get(configProperties.getId()));
		prodToAdd.setName(productDetails.get(configProperties.getName()));
		
		Price priceToAdd=new Price();
		
		priceToAdd.setCurrencyCode( productDetails.get(configProperties.getCurrency()));
		priceToAdd.setId( productDetails.get(configProperties.getId()));
		priceToAdd.setPrice( productDetails.get(configProperties.getPrice()));
		
		HashMap<String,Object> prodPriceMap=new HashMap<String,Object>();
		prodPriceMap.put(configProperties.getPriceobj(), priceToAdd);
		prodPriceMap.put(configProperties.getProductobj(), prodToAdd);
		return prodPriceMap;
		
	}
 

}
