package org.acme.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.acme.entity.ProductEntity;

public class ProductResponseDTO {
	private String name;
	private String description;
	private String category;
	private String model;
	private BigDecimal price;
	private Map<String, Object> brand;

	public ProductResponseDTO(ProductEntity product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.category = product.getCategory();
		this.model = product.getModel();
		this.price = product.getPrice();
		this.brand = new HashMap<String, Object>();
		this.brand.put("name", product.getBrand().getName());
		this.brand.put("industry", product.getBrand().getIndustry());
		this.brand.put("year founded", product.getBrand().getYearFounded());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Map<String, Object> getBrand() {
		return brand;
	}

	public void setBrand(Map<String, Object> brand) {
		this.brand = brand;
	}

}
