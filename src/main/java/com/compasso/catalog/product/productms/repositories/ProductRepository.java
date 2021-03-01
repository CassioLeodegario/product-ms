package com.compasso.catalog.product.productms.repositories;

import com.compasso.catalog.product.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT DISTINCT obj FROM Product obj WHERE 1=1 and ((:query is  null or UPPER(obj.name) like UPPER(:query) ) " +
            "or (:query is  null or UPPER(obj.description) like UPPER(:query) )) " +
            "and ((:minPrice is  null or obj.price >= :minPrice) and (:maxPrice is  null or obj.price <= :maxPrice)) ")
    List<Product> search(@Param("query") String query, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);


}
