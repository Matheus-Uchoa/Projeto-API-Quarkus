package org.acme.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.dto.ProductDTO;
import org.acme.dto.ProductResponseDTO;
import org.acme.service.ProductService;

@Path("/api/products")
public class ProductController {

	@Inject
	ProductService productService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductResponseDTO> findAllProducts() {
		return productService.getAllProducts();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ProductResponseDTO getProductByID(@PathParam("id") Long id) {
		return productService.getProductByID(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{name}")
	public ProductResponseDTO getProductByName(@PathParam("name") String name) {
		return productService.getProductByName(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("searchLike/{name}")
	public List<ProductResponseDTO> getProductsByNameQuery(@PathParam("name") String name) {
		return productService.getProductByNameQuery(name);
	}

	@POST
	@Transactional
	public Response saveProduct(@Valid ProductDTO product) {

		try {
			ProductResponseDTO productdto = productService.createNewProduct(product);
			return Response.status(Status.CREATED).entity(productdto).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	@PUT
	@Path("/{id}")
	@Transactional
	public Response changeProduct(@PathParam("id") Long id, @Valid ProductDTO product) {
		try {
			productService.changeProduct(id, product);
			return Response.status(Status.NO_CONTENT).entity(product).build();
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
