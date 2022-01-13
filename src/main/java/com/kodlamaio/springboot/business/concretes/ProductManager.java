package com.kodlamaio.springboot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodlamaio.springboot.business.abstracts.ProductService;
import com.kodlamaio.springboot.core.utilities.results.DataResult;
import com.kodlamaio.springboot.core.utilities.results.Result;
import com.kodlamaio.springboot.core.utilities.results.SuccessDataResult;
import com.kodlamaio.springboot.core.utilities.results.SuccessResult;
import com.kodlamaio.springboot.dataAccess.abstacts.ProductDao;
import com.kodlamaio.springboot.entities.concretes.Product;
import com.kodlamaio.springboot.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		
		this.setProductDao(productDao);
	}
	
	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi");
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		
		return new SuccessResult("ürün eklendi");
	}
	
	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data listelendi");
	}
	
	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory(productName, categoryId),
				"Data listelendi");
		
	}
	
	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameOrCategoryId(productName, categoryId), "Data listelendi");
		
	}
	
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIdIn(categories), "Data listelendi");
	}
	
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),
				"Data listelendi");
		
	}
	
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),
				"Data listelendi");
		
	}
	
	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),
				"Data listelendi");
		
	}
	
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}
	
	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "productName");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Sırlama işlemi başarılı");
	}
	
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),
				"Data listelendi");
	}
	
}
