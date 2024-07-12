package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Category;
import com.vti.entity.Manufacturer;
import com.vti.entity.Product;
import com.vti.form.ProductFormForCreating;
import com.vti.form.ProductFormForUpdating;
import com.vti.repository.ICategoryRepository;
import com.vti.repository.IManufacturerRepository;
import com.vti.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private IManufacturerRepository manufacturerRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(short id) {
		return productRepository.getById(id);
	}

	@Override
	public void deleteProductById(short id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product createNewProduct(ProductFormForCreating productNewForm) {
		// Tìm manufacturer theo id
		Manufacturer manufacturer = manufacturerRepository.getById(productNewForm.getManufacturerId());

		// Tìm manufacturer theo id
		Category category = categoryRepository.getById(productNewForm.getCategoryId());

		Product product = new Product();
		product.setName(productNewForm.getName());
		product.setPrice(productNewForm.getPrice());
		product.setInfo(productNewForm.getInfo());
		product.setDetail(productNewForm.getDetail());
		product.setRatingStar(productNewForm.getRatingStar());
		product.setImageName(productNewForm.getImageName());
		product.setManufacturer(manufacturer);
		product.setCategory(category);

		Product productNew = productRepository.save(product);
		return productNew;
	}

	@Override
	public Product updateProduct(short id, ProductFormForUpdating productUpdateForm) {
		Product product = productRepository.getById(id);
		// Tìm manufacturer theo id
		Manufacturer manufacturer = manufacturerRepository.getById(productUpdateForm.getManufacturerId());

		// Tìm manufacturer theo id
		Category category = categoryRepository.getById(productUpdateForm.getCategoryId());

		product.setName(productUpdateForm.getName());
		product.setPrice(productUpdateForm.getPrice());
		product.setInfo(productUpdateForm.getInfo());
		product.setDetail(productUpdateForm.getDetail());
		product.setRatingStar(productUpdateForm.getRatingStar());
		product.setImageName(productUpdateForm.getImageName());
		product.setManufacturer(manufacturer);
		product.setCategory(category);

		Product productUpdate = productRepository.save(product);
		return productUpdate;
	}

}
