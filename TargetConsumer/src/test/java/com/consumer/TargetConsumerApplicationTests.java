package com.consumer;

/*
 * Issues seen work in progress
 */
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.consumer.Bean.ConfProperties;
import com.consumer.Bean.Current_Price;
import com.consumer.Bean.ProductData;
import com.consumer.controller.TargetController;
import com.consumer.helper.Helper;

//@SpringBootTest
//class TargetConsumerApplicationTests {
//	@InjectMocks
//    TargetController targetController;
//     
//    @Mock
//     Helper helper;
//    @Mock
//    ConfProperties properties;
//    
//	@Test
//
//	public void testCreate() {
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//		ProductData prod=new ProductData();
//		prod.setId("13860444");
//		prod.setName("Nexa NEXT");
//		Current_Price cp=new Current_Price();
//		cp.setCurrencyCode("USD");
//		cp.setValue("11.22");
//		prod.setCurrent_price(cp);
//		ResponseEntity respEntity=new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//        try {
//			when(helper.setPutPostConn(prod, "POST")).thenReturn(respEntity);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 
//
//		 
//		ResponseEntity<Object> responseEntity = targetController.create(prod);
//        assertEquals(responseEntity.getStatusCode(), respEntity.getStatusCode());
//		
//	}
	
//	@Test
//
//	public void testGetProductName() throws IOException, ParseException {
//		 
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//		ProductData prod=new ProductData();
//		String id="13860444";
//		prod.setId("13860444");
//		prod.setName("Nexa NEXT");
//		Current_Price cp=new Current_Price();
//		cp.setCurrencyCode("USD");
//		cp.setValue("11.22");
//		prod.setCurrent_price(cp);
//		
//		URL url=new URL("http://localhost:8080/product/"+id);
//		System.out.println("URL is "+url);
//		String[] arr=new String[1];
//		arr[0]=new String("name");
//		url=new URL("http://localhost:8080/price/"+id);
//		 
//		
//		HashMap<String,String> prodMap=new HashMap<String, String>();
//		
//		prodMap.put("name", "Nexa NEXT");
//		when(helper.setGetConn(url, arr, "GET")).thenReturn(prodMap);
//		
//		//for price
//		
//		String[] arrPrice=new String[2];
//		
//		arrPrice[0]="price";
//		arrPrice[1]="currencyCode";
//		HashMap<String,String> priceMap=new HashMap<String, String>();
//		priceMap.put("price", "11.22");
//		
//		priceMap.put("currencyCode", "USD");
//		when(helper.setGetConn(url, arr, "GET")).thenReturn(priceMap);
//		
//		 
//	 
//
//		 
//	  ProductData prodData = targetController.getProductName(id);
//        assertEquals(prodMap.get("name"), prodData.getName());
//        assertEquals(prodMap.get("price"),prodData.getCurrent_price().getValue());
//		
//	}
//	
	
//}
