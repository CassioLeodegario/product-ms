package com.compasso.catalog.product.productms.dto;

import com.compasso.catalog.product.productms.entities.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.UUID;

public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;

    @NotEmpty(message="Name is required")
    private String name;

    @NotEmpty(message="Description is required")
    private String description;

    @NotNull(message="Price is required")
    @Positive(message = "Price should be positive")
    private Double price;

    public ProductDTO() {
    }

    public ProductDTO(Product obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
        this.price = obj.getPrice();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
