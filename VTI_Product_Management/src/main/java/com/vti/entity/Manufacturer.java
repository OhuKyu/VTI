package com.vti.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Manufacturer", catalog = "ProductManagement") // Removed extra '@' symbol
public class Manufacturer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ManufacturerId")
	private short id;

	@Column(name = "ManufacturerName", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private ManufacturerName name;
	@OneToMany(mappedBy = "manufacturer")
	private List<Product> products;

	public Manufacturer() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public ManufacturerName getName() {
		return name;
	}

	public void setName(ManufacturerName name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
