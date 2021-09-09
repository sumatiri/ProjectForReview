package com.myRetailApp.Services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.myRetailApp.Bean.Product;
import com.myRetailApp.Exceptions.ProductNotFoundException;
import com.myRetailApp.Repository.ProductRepo;

@Service

public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepo prodRepo;

	@Override
	public Product getProductName(String prodID) {
		 
	 
		Product  pd=prodRepo.getById(prodID);
		 
		return  pd;
	}

	@Override
	public Product insertProductDetails(Product pd) {
		Product added=prodRepo.save(pd);
		return added;
	}

	@Override
	public Product updateProduct(Product pd) {
		Product prod = null;
		Product added = null;
		try {
			prod = prodRepo.getById(pd.getId());

			prod.setName(pd.getName());
			added = prodRepo.save(prod);
			return added;

		} catch (Exception e) {
			throw new ProductNotFoundException();

		}

	}

}
