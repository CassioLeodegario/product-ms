package com.compasso.catalog.product.productms.repositories;

import com.compasso.catalog.product.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
