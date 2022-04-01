package com.ty.food_app_boot.food_app_boot.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.food_app_boot.food_app_boot.dto.Product;
import com.ty.food_app_boot.food_app_boot.repostary.ProductRepositary;

@Repository
public class ProductDao {

	@Autowired
	ProductRepositary repositary;

	public Product saveProduct(Product product) {
		return repositary.save(product);
	}

	public Product getProductById(int id) {
		Optional<Product> opt = repositary.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	public Product updateProductById(@RequestParam int id,@RequestBody Product product) {
		Product p = getProductById(id);
		if(p!= null) {
			p.setId(id);
			p.setCost(product.getCost());
			p.setDescription(product.getDescription());
			p.setName(product.getName());
			p.setOffer(product.getOffer());
			p.setUrl(product.getUrl());
			return repositary.save(p);
		}
		return null;
	}

	public boolean deleteProductById(int id) {
		Product product = getProductById(id);
		if(product!=null) {
			repositary.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Product> getallproducts(){
		return repositary.findAll();
	}
}
