package org.acme.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.dto.BrandDTO;
import org.acme.service.BrandService;

@Path("/api/Brands")
public class BrandController {

	@Inject
	BrandService brandService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandDTO> findAllBrands() {
		return brandService.getAllBrands();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public BrandDTO findBrandById(@PathParam("id") Long id) {
		return brandService.getBrandById(id);
	}

	@POST
	@Transactional
	public Response saveBrand(BrandDTO brand) {

		try {
			brandService.createNewBrand(brand);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@PUT
	@Path("/{id}")
	@Transactional
	public Response changeBrand(@PathParam("id") Long id, BrandDTO brand) {
		try {
			brandService.changeBrand(id, brand);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
