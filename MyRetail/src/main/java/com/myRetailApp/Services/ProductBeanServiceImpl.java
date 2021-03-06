package com.myRetailApp.Services;

import org.springframework.stereotype.Service;

import com.myRetailApp.Bean.Price;
import com.myRetailApp.Bean.Product;
import com.myRetailApp.Bean.ProductBean;

@Service
public class ProductBeanServiceImpl implements IProdBeanService{

	 
	public ProductBean getProdBean(Product prod, Price pr) {
		 ProductBean bean=new ProductBean();
		 bean.setCurrent_price(pr);
		 bean.setId(prod.getId());
		 bean.setName(prod.getName());
		 
		 return bean;
	}

}
