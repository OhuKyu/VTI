package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Short> {

}
