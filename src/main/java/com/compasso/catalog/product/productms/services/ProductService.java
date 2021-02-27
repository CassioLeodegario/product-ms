package com.compasso.catalog.product.productms.services;

import com.compasso.catalog.product.productms.dto.ProductDTO;
import com.compasso.catalog.product.productms.entities.Product;
import com.compasso.catalog.product.productms.repositories.ProductRepository;
import com.compasso.catalog.product.productms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product find(UUID id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id));
    }

    public Product insert(ProductDTO objDto) {
        Product obj = fromDTO(objDto);
        obj.setId(null);
        obj = productRepository.save(obj);
        return obj;
    }

    public Product update(ProductDTO productDto, UUID productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = optionalProduct.orElseThrow(() -> new ObjectNotFoundException(
                "Product not found! Id: " + productId));
        updateData(productDto, product);
        return productRepository.save(product);
    }

    private void updateData(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
    }

    public Product fromDTO(ProductDTO objDto) {
        return new Product(objDto.getId(), objDto.getName(), objDto.getDescription(), objDto.getPrice());
    }


}
