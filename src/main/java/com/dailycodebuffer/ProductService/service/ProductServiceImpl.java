package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.exception.ProductServiceException;
import com.dailycodebuffer.ProductService.model.ProductDTO;
import com.dailycodebuffer.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public  long addProduct(ProductDTO productDTO) {
        log.info("Product requested: {}", productDTO);
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
        product = productRepository.save(product);
        log.info("Saved successfully with Product: {}", product);
        return product.getProductId();
    }

    @Override
    public Product getProductById(long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceException("Product with given id not found!", "PRODUCT_NOT_FOUND"));
    }
}
