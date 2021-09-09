package com.myRetailApp.Services;

import com.myRetailApp.Bean.Price;

public interface IPriceInfoService {
	public Price getPriceDetails(String prodID);
	public Price savePrice(Price prObject);
	public Price updatePrice(Price prObject);

}
