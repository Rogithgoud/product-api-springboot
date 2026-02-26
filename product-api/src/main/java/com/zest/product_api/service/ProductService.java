package com.zest.product_api.service;

import com.zest.product_api.dto.ProductDTO;

import com.zest.product_api.payload.PagedResponse;


public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);


    ProductDTO getProductById(Long id);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    PagedResponse<ProductDTO> getAllProducts(int page, int size, String sortBy, String sortDir);

    void deleteProduct(Long id);
}