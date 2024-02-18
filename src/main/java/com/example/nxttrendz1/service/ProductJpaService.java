/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository productjpaService;

    @Override
    public ArrayList<Product> getAllProducts() {
        List<Product> list = productjpaService.findAll();
        ArrayList<Product> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override

    public Product addProduct(Product product) {
        productjpaService.save(product);
        return product;

    }

    @Override

    public Product getById(int productId) {
        try {
            Product product1 = productjpaService.findById(productId).get();
            return product1;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public void deleteProduct(int productId) {
        Optional<Product> productOptional = productjpaService.findById(productId);

        if (productOptional.isPresent()) {
            productjpaService.deleteById(productId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public Product updateProduct(int productId, Product product) {
        try {
            Product newProduct = productjpaService.findById(productId).get();
            if (product.getProductName() != null) {
                newProduct.setProductName(product.getProductName());
            }
            if (product.getPrice() != 0) {
                newProduct.setPrice(product.getPrice());
            }
            productjpaService.save(newProduct);
            return newProduct;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

}