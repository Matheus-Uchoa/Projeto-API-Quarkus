package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;
import org.acme.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

	@Inject // Fazer injeção de dependências de um objeto
	ProductRepository productRepository;

	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> products = new ArrayList<>();
		productRepository.findAll().stream().forEach(item -> {
			products.add(mapProductEntityToDTO(item));
		});
		return products;
	}
public ProductDTO getProductByID(Long id){
	productRepository.findById(id);
	ProductEntity produto = productRepository.findById(id);
	return mapProductEntityToDTO(produto);

}
	public void createNewProduct(ProductDTO product) {
		productRepository.persist(mapProductDTOToEntity(product));
	}

	public void changeProduct(Long id, ProductDTO product) {
		ProductEntity productEntity = productRepository.findById(id);

		productEntity.setName(product.getName());
		productEntity.setCategory(product.getCategory());
		productEntity.setModel(product.getModel());
		productEntity.setDescription(product.getDescription());
		productEntity.setPrice(product.getPrice());

		productRepository.persist(productEntity);

	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	private ProductDTO mapProductEntityToDTO(ProductEntity productEntity) {
		ProductDTO product = new ProductDTO();
		product.setName(productEntity.getName());
		product.setDescription(productEntity.getDescription());
		product.setCategory(productEntity.getCategory());
		product.setModel(productEntity.getModel());
		product.setPrice(productEntity.getPrice());

		return product;
	}

	private ProductEntity mapProductDTOToEntity(ProductDTO productDTO) {
		ProductEntity product = new ProductEntity();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setCategory(productDTO.getCategory());
		product.setModel(productDTO.getModel());
		product.setPrice(productDTO.getPrice());

		return product;
	}
}
