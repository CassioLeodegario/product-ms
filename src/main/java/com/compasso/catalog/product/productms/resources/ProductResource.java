package com.compasso.catalog.product.productms.resources;

import com.compasso.catalog.product.productms.dto.ProductDTO;
import com.compasso.catalog.product.productms.entities.Product;
import com.compasso.catalog.product.productms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Product> insert(@Valid @RequestBody ProductDTO objDto) {
        Product product = productService.insert(objDto);
        return ResponseEntity.ok().body(product);
    }

}
