package com.myRetailApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myRetailApp.Bean.Price;
import com.myRetailApp.Bean.Product;
import com.myRetailApp.Repository.PriceRepo;

@Service

public class PriceServiceImpl implements IPriceInfoService {

	@Autowired
	PriceRepo priceRep;
	
	
	public Price getPriceDetails(String prodID) {
		 Price pr=priceRep.getById(prodID);
		 return pr;
	}

	 
	public Price savePrice(Price prObject) {
		 return priceRep.save(prObject);
	}

	 
	public Price updatePrice(Price prObject) {
		
		Price prodPrice = null;
		Price added = null;
		try {
			prodPrice = priceRep.getById(prObject.getId());
			if (prodPrice.getPrice()!=null) {
				 
				prodPrice.setCurrencyCode(prObject.getCurrencyCode());
				prodPrice.setPrice(prObject.getPrice());
				added=priceRep.save(prodPrice);
			}

		} catch (Exception e) {
			 //incase if Price is not found then exception is thrown, saving product to db then
			added=priceRep.save(prObject);

		} finally {
			return added;
		}
	}

}
