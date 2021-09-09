package com.myRetailApp.Services;

import com.myRetailApp.Bean.Price;
import com.myRetailApp.Bean.Product;
import com.myRetailApp.Bean.ProductBean;

public interface IProdBeanService {
  public ProductBean getProdBean(Product prod,Price pr);
}
