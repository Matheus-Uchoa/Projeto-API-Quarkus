package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.BrandEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BrandRepository implements PanacheRepository<BrandEntity> {

}
