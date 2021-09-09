package com.myRetailApp.Repository;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
 

import com.myRetailApp.Bean.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,String> {

}

