package com.kodlamaio.springboot.dataAccess.abstacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaio.springboot.entities.concretes.Product;
import com.kodlamaio.springboot.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	Product getById(int productId);
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	// JPQL query sorgusuna örnek
	@Query("from Product where productName=:productName and category.id=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	@Query("Select new  com.kodlamaio.springboot.entities.dtos.ProductWithCategoryDto"
			+ "(p.id, p.productName, c.categoryName) " + "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
}
