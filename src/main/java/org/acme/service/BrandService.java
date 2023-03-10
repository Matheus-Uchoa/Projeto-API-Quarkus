package org.acme.service;

import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.dto.BrandDTO;
import org.acme.entity.BrandEntity;
import org.acme.repository.BrandRepository;

@ApplicationScoped
public class BrandService {
	@Inject
	BrandRepository brandRepository;

	public List<BrandDTO> getAllBrands() {
		List<BrandDTO> brands = new ArrayList<>();
		brandRepository.findAll().stream().forEach(item -> {
			brands.add(mapBrandEntityToDto(item));
		});
		return brands;
	}

	public BrandDTO getBrandById(Long id) {
		BrandEntity brandEntity = brandRepository.findById(id);

		return mapBrandEntityToDto(brandEntity);

	}

	public void createNewBrand(BrandDTO brand) {
		brandRepository.persist(mapBrandDTOToEntity(brand));
	}

	public void changeBrand(Long id, BrandDTO brand) {
		BrandEntity brandEntity = brandRepository.findById(id);

		brandEntity.setName(brand.getName());
		brandEntity.setIndustry(brand.getIndustry());
		brandEntity.setYearFounded(brand.getYearFounded());

		brandRepository.persist(brandEntity);
	}

	public BrandDTO mapBrandEntityToDto(BrandEntity brandEntity) {
		BrandDTO brand = new BrandDTO();
		brand.setName(brandEntity.getName());
		brand.setYearFounded(brandEntity.getYearFounded());
		brand.setIndustry(brandEntity.getIndustry());

		return brand;

	}

	public BrandEntity mapBrandDTOToEntity(BrandDTO brandDTO) {
		BrandEntity brand = new BrandEntity();

		brand.setName(brandDTO.getName());
		brand.setIndustry(brandDTO.getIndustry());
		brand.setYearFounded(brandDTO.getYearFounded());

		return brand;
	}

}
