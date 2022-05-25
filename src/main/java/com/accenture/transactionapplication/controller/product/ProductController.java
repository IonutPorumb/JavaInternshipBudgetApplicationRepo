package com.accenture.transactionapplication.controller.product;

import com.accenture.transactionapplication.model.Product;
import com.accenture.transactionapplication.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Find a Product by id
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return productService.findProductById(id);
    }

    // Delete a Product by id
    @DeleteMapping("/{id}")
    public Integer deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }

    // Update a Product by id
    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProductById(product, id);
    }

    // POST /products - adds a new products
    @PostMapping
    public Product insertNewProduct(@RequestBody Product product) {
        return productService.insertNewProduct(product);
    }

    // Filter Products by id, created date, description, modified date and name
    @GetMapping
    public List<Product> findAllByCreatedAtAndDescriptionAndModifiedAtAndName
    (@RequestParam(required = false) Integer id,
     @RequestParam(required = false) String name,
     @RequestParam(required = false) String description,
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdAt,
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime modifiedAt,
     @RequestParam(required = false) Integer page,
     @RequestParam(required = false) Integer size) {
        return productService.findAllByCreatedAtAndDescriptionAndModifiedAtAndName
                (id, name, description, createdAt, modifiedAt, page, size);
    }
}
