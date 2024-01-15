package com.dailycodebuffer.ProductService.model;

import lombok.Data;

@Data
public class ProductDTO {
    private String productName;
    private long price;
    private long quantity;
}
