package org.acme.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.ProductEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {
	public ProductEntity findByName(String name) {
		return find("name", name).firstResult();
	}

	/* Parameters.with associa o valor do parâmetro com o nome :name, permitindo que
	   a consulta SQL substitua o parâmetro pelo valor correspondente
	 */
	public List<ProductEntity> findByNameQuery(String name) {
		return find("name Like :name", Parameters.with("name", "%" + name + "%")).list();
	}

}
