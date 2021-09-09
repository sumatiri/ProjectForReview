package com.myRetailApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
 

import com.myRetailApp.Bean.Price;


@Repository
public interface PriceRepo extends JpaRepository<Price,String> {

}
