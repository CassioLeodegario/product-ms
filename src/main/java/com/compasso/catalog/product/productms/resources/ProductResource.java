package com.compasso.catalog.product.productms.resources;

import com.compasso.catalog.product.productms.dto.ProductDTO;
import com.compasso.catalog.product.productms.entities.Product;
import com.compasso.catalog.product.productms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @RequestMapping(path = "{id}",method= RequestMethod.PUT)
    public ResponseEntity<Product> insert(@Valid @RequestBody ProductDTO objDto, @PathVariable UUID id) {
        Product product = productService.update(objDto, id);
        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(path = "{id}",method= RequestMethod.GET)
    public ResponseEntity<ProductDTO> insert(@PathVariable UUID id) {
        Product product = productService.find(id);
        return ResponseEntity.ok().body(new ProductDTO(product));
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> products = productService.findAll();
        List<ProductDTO> productDTOS = products.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(productDTOS);
    }

    @RequestMapping(path = "/search", method=RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> search(
            @RequestParam(value="q", required = false) String query,
            @RequestParam(value="min_price", required = false) Double minPrice,
            @RequestParam(value="max_price", required = false) Double maxPrice) {
        List<Product> products = productService.search(query, minPrice, maxPrice);
        List<ProductDTO> productDTOS = products.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(productDTOS);

    }


}
