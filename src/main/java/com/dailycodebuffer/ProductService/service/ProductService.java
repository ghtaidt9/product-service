package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.model.ProductDTO;

public interface ProductService {
    public long addProduct(ProductDTO productDTO);

    Product getProductById(long productId);
}
