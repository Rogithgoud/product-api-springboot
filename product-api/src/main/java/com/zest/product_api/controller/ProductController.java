package com.zest.product_api.controller;

import com.zest.product_api.dto.ProductDTO;
import com.zest.product_api.payload.ApiResponse;
import com.zest.product_api.payload.PagedResponse;
import com.zest.product_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create Products")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(
            @Valid @RequestBody ProductDTO productDTO) {

        ProductDTO saved = productService.createProduct(productDTO);

        ApiResponse<ProductDTO> response =
                new ApiResponse<>(true, "Product created successfully", saved);

        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Get all products with pagination and sorting")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponse<PagedResponse<ProductDTO>>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        PagedResponse<ProductDTO> products =
                productService.getAllProducts(page, size, sortBy, sortDir);

        ApiResponse<PagedResponse<ProductDTO>> response =
                new ApiResponse<>(true, "Products fetched successfully", products);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get Products by ID")

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {

        ProductDTO product = productService.getProductById(id);

        ApiResponse<ProductDTO> response =
                new ApiResponse<>(true, "Product fetched successfully", product);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Edit Products By ID")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductDTO productDTO) {

        ProductDTO updated = productService.updateProduct(id, productDTO);

        ApiResponse<ProductDTO> response =
                new ApiResponse<>(true, "Product updated successfully", updated);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete Products By ID")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        ApiResponse<String> response =
                new ApiResponse<>(true, "Product deleted successfully", null);

        return ResponseEntity.ok(response);
    }
}