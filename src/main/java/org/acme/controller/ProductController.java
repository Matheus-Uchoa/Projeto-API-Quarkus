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

import org.acme.dto.ProductDTO;
import org.acme.service.ProductService;

@Path("/api/products")
public class ProductController {

	@Inject
	ProductService productService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> findAllProducts() {
		return productService.getAllProducts();

	}

	@POST
	@Transactional
	public Response saveProduct(ProductDTO product) {
		try {
			productService.createNewProduct(product);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	@PUT
	@Path("/{id}")
	@Transactional
	public Response changeProduct(@PathParam("id") Long id, ProductDTO product) {
		try {
			productService.changeProduct(id, product);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public Response deleteProduct(@PathParam("id") Long id) {
		try {
			productService.deleteProduct(id);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

}
