package com.vti.service;

import java.util.List;

import com.vti.entity.Product;
import com.vti.form.ProductFormForCreating;
import com.vti.form.ProductFormForUpdating;

public interface IProductService {
	public List<Product> getAllProducts();

	public Product getProductById(short id);

	public Product createNewProduct(ProductFormForCreating productNewForm);

	public Product updateProduct(short id, ProductFormForUpdating productUpdateForm);

	public void deleteProductById(short id);

}
