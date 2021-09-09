package com.myRetailApp.Services;

import com.myRetailApp.Bean.Product;

public interface IProductService {
	
	public Product getProductName(String prodID);
	public Product insertProductDetails(Product pd);
	public Product updateProduct(Product pd);

}
