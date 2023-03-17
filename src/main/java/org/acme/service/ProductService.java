package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.acme.dto.ProductDTO;
import org.acme.dto.ProductResponseDTO;
import org.acme.entity.ProductEntity;
import org.acme.repository.BrandRepository;
import org.acme.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

	@Inject // Fazer injeção de dependências de um objeto
	ProductRepository productRepository;

	@Inject
	BrandRepository brandRepository;

	@Inject
	Validator validator;

	public List<ProductResponseDTO> getAllProducts() {
		return productRepository.findAll().stream().map(product -> new ProductResponseDTO(product))
				.collect(Collectors.toList());
	}

	public ProductResponseDTO getProductByID(Long id) {

		ProductEntity product = productRepository.findById(id);
		ProductResponseDTO response = new ProductResponseDTO(product);

		return response;

	}

	public ProductResponseDTO getProductByName(String name) {
		ProductEntity product = productRepository.findByName(name);

		ProductResponseDTO response = new ProductResponseDTO(product);
		return response;

	}

	public List<ProductResponseDTO> getProductByNameQuery(String name) {

		List<ProductResponseDTO> responses = new ArrayList<>();
		productRepository.findByNameQuery(name).stream().forEach(item -> {
			responses.add(new ProductResponseDTO(item));
		});
		return responses;
	}

	public ProductResponseDTO createNewProduct(ProductDTO product) {
		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(product);
		if (!violations.isEmpty())
			throw new ConstraintViolationException(violations);

		ProductEntity productEntity = new ProductEntity();

		productEntity = mapProductDTOToEntity(product);

		productRepository.persist(productEntity);

		return new ProductResponseDTO(productEntity);
	}

	public void changeProduct(Long id, ProductDTO product) {
		ProductEntity productEntity = productRepository.findById(id);

		productEntity.setName(product.getName());
		productEntity.setCategory(product.getCategory());
		productEntity.setModel(product.getModel());
		productEntity.setDescription(product.getDescription());
		productEntity.setPrice(product.getPrice());
		productEntity.setBrand(brandRepository.findById(product.getIdBrand()));

		productRepository.persist(productEntity);

	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	private ProductEntity mapProductDTOToEntity(ProductDTO productDTO) {
		ProductEntity product = new ProductEntity();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setCategory(productDTO.getCategory());
		product.setModel(productDTO.getModel());
		product.setPrice(productDTO.getPrice());
		product.setBrand(brandRepository.findById(productDTO.getIdBrand()));

		return product;
	}
}
