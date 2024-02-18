/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz1.service.*;
import com.example.nxttrendz1.model.*;

@RestController
public class ProductController {
    @Autowired
    public ProductJpaService productjpaService;

    @GetMapping("/products")

    public ArrayList<Product> getAllProducts() {
        return productjpaService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productjpaService.addProduct(product);

    }

    @GetMapping("/products/{productId}")
    public Product getById(@PathVariable("productId") int productId) {
        return productjpaService.getById(productId);

    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return productjpaService.updateProduct(productId, product);

    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productjpaService.deleteProduct(productId);
    }
}
