package com.compasso.catalog.product.productms.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;

    public StandardError(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @JsonProperty("status_code")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

