package com.kodlamaio.springboot.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.springboot.business.abstracts.ProductService;
import com.kodlamaio.springboot.core.utilities.results.DataResult;
import com.kodlamaio.springboot.core.utilities.results.Result;
import com.kodlamaio.springboot.entities.concretes.Product;
import com.kodlamaio.springboot.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		
		this.productService = productService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		
		return this.productService.getAll();
		
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetailsl() {
		
		return this.productService.getProductWithCategoryDetails();
		
	}
	
	@GetMapping("/getallByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		return this.productService.getAll(pageNo, pageSize);
		
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Product>> getAllSorted() {
		
		return this.productService.getAllSorted();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		
		return this.productService.getByProductName(productName);
		
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,
			@RequestParam int categoryId) {
		
		return this.productService.getByProductName(productName);
		
	}
	
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
		
		return this.productService.getByCategoryIdIn(categories);
		
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		
		return this.productService.getByProductNameContains(productName);
		
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
		
		return this.productService.getByProductNameStartsWith(productName);
		
	}
	
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,
			@RequestParam int categoryId) {
		
		return this.productService.getByNameAndCategory(productName, categoryId);
		
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName,
			@RequestParam int categoryId) {
		
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
		
	}
	
}
