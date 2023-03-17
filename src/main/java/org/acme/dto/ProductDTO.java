package org.acme.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
@Schema(description = "Product data transfer Object")
public class ProductDTO {

	@NotBlank(message = "O nome deve ser informado.")
	private String name;

	@NotBlank(message = "O produto deve conter uma descrição")
	@Size(min = 10, max = 100)
	private String description;
	private String category;
	private String model;
	
	@Positive(message = "O preço deve ser um valor positivo")
	private BigDecimal price;
	
	@NotNull(message = "O campo idBrand deve ser informado.")
	private long idBrand;

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

	public long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(long idBrand) {
		this.idBrand = idBrand;
	}

}
