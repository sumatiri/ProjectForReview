package com.consumer.helper;

/*
 * Class containing helper methods for controller 
 */
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.consumer.Bean.ConfProperties;
import com.consumer.Bean.ProductData;
import com.consumer.exception.ProductGenericException;
import com.consumer.exception.ProductNotFoundException;
@Component
public class Helper {
	@Autowired
	ConfProperties properties;
	/*
	 * Method for Get connection, setting up connection and returning response from client
	 */
	public HashMap<String,String> setGetConn(URL url,String[] key,String reqType) throws IOException, ParseException {
		
		HashMap<String,String> retMap=new HashMap<String,String>();
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod(reqType);
		
		conn.connect();
	 
		int responseCode=conn.getResponseCode();
		
		if(responseCode!=HttpURLConnection.HTTP_OK) {
			 throw new ProductNotFoundException();
		}else {
			if(reqType.equalsIgnoreCase(properties.getGetreq())) {
				retMap=readRes(url,key);
			}
		}
		
		return retMap;
		 
	}
	
	private HashMap<String,String> readRes(URL url,String[] key) throws IOException, ParseException {
		String inline="";
		HashMap<String,String> retMap=new HashMap<String,String>();
		Scanner sc=null;
		try {
		sc=new Scanner(url.openStream());
		while (sc.hasNext()) {
			 
			inline+=sc.nextLine();
		}
		
		}finally {
			sc.close();
		}
		
	 JSONParser parser=new JSONParser();
		JSONObject obj=(JSONObject)parser.parse(inline);
		for(int i=0;i<key.length;i++) {
			Object name=(Object)obj.get(key[i]);
			retMap.put(key[i], (String)name);
		}
		return retMap;
		
	}

	/*
	 * Common method for PUT and POST. Setting connection and generating response entity
	 */
	public ResponseEntity<Object> setPutPostConn(ProductData prod, String reqType) throws IOException {
		 
		URL url = new URL(properties.getProdurl() + prod.getId());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(reqType);
		con.setRequestProperty("Content-Type", "application/json;utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		StringBuffer response = null;
		String price = prod.getCurrent_price().getValue();
		String currency = prod.getCurrent_price().getCurrencyCode();
		JSONObject  product = new JSONObject();
		product.put(properties.getName(), prod.getName());
		product.put(properties.getId(), prod.getId());
		product.put(properties.getPrice(), price);
		product.put(properties.getCurr(), currency);

		String jsonInputString = product.toJSONString();
		URI location = null;
		OutputStream out = null;

		try {
			out = con.getOutputStream();
			out.write(jsonInputString.getBytes());
			out.flush();

		 	int responseCode = con.getResponseCode();
			 
           
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getId())
					.toUri();

			if (responseCode != HttpURLConnection.HTTP_CREATED) {

				throw new ProductGenericException();
			} else {
				 return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
			}

		} finally {
			out.close();

			
		}

	}
  
}
