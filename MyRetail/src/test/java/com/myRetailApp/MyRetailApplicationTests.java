package com.myRetailApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.myRetailApp.Bean.Price;
import com.myRetailApp.Bean.Product;
import com.myRetailApp.Repository.PriceRepo;
import com.myRetailApp.Repository.ProductRepo;
import com.myRetailApp.Services.PriceServiceImpl;
import com.myRetailApp.Services.ProductServiceImpl;
@RunWith(MockitoJUnitRunner.class)
class MyRetailApplicationTests {

	@Mock
	ProductRepo prodRepo;
	
	@Mock
	PriceRepo priceRepo;
	
	@InjectMocks
	ProductServiceImpl prodSvcImpl;
	
	@InjectMocks
	PriceServiceImpl prSvcImpl;
	
	@BeforeEach
	void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetProd() {
		Product prod=new Product();
		prod.setId("11223344");
		prod.setName("MidScreen Size");
		
		when(prodRepo.getById("11223344")).thenReturn(prod);
		
		
		Product prod2=prodSvcImpl.getProductName("11223344");
		assertNotNull(prod2);
		assertEquals("11223344",prod2.getId());
	}
	
	 
    @Test
    public void testGetPrice() {
    	
    	Price pr=new Price();
    	pr.setId("11223344");
    	pr.setCurrencyCode("USD");
    	pr.setPrice("11.53");
    	when(priceRepo.getById("11223344")).thenReturn(pr);
    	Price pr2=prSvcImpl.getPriceDetails("11223344");
    	assertNotNull(pr2);
    	
    	assertEquals("11223344",pr2.getId());
    	assertEquals("USD", pr2.getCurrencyCode());
    	assertEquals("11.53",pr2.getPrice());
    }
    
    @Test
    
    public void testSave() {
    	Product prod=new Product();
		prod.setId("11223344");
		prod.setName("MidScreen Size");
		when(prodRepo.save(prod)).thenReturn(prod);
		
		Product product1=prodSvcImpl.insertProductDetails(prod);
		assertEquals(prod.getId(), product1.getId());
		assertEquals(prod.getName(),product1.getName());
    	
    }
    
    @Test
    public void testSavePrice() {
    	Price pr=new Price();
    	pr.setId("11223344");
    	pr.setCurrencyCode("USD");
    	pr.setPrice("11.53");
    	
    	when(priceRepo.save(pr)).thenReturn(pr);
    	
    	Price productPrice=prSvcImpl.savePrice(pr);
    	assertEquals(pr.getId(), productPrice.getId());
    	assertEquals(pr.getCurrencyCode(), productPrice.getCurrencyCode());
    	assertEquals(pr.getPrice(), productPrice.getPrice());
    	
    }
    
    @Test
    public void testPut() {
    	Product prod = new Product();
    	prod.setId("11223344");
    	prod.setName("MidScreen Size");
    	when(prodRepo.getById("11223344")).thenReturn(prod);
    	when(prodRepo.save(prod)).thenReturn(prod);
    	
    	Product prod2 = new Product();
    	prod2.setId("11223344");
    	prod2.setName("WideScreen Size");
    	
    	Product product = prodSvcImpl.updateProduct(prod2);
    	assertEquals(product.getId(), prod.getId());
    	assertEquals(product.getName(),prod.getName());
    	
    }
    
    @Test
    public void testPutPrice() {
    	Price price = new Price();
    	price.setId("11223344");
    	price.setCurrencyCode("USD");
    	price.setPrice("11.45");
    	when(priceRepo.getById("11223344")).thenReturn(price);
    	when(priceRepo.save(price)).thenReturn(price);
    	
    	Price price2 = new Price();
    	price2.setId("11223344");
    	price2.setCurrencyCode("EURO");
    	price2.setPrice("23.45");
    	
    	Price productPrice = prSvcImpl.updatePrice(price2);
    	
    	assertEquals(price.getId(), productPrice.getId());
    	assertEquals(price.getCurrencyCode(), productPrice.getCurrencyCode());
    	assertEquals(price.getPrice(), productPrice.getPrice());
    }
}
   
