/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;

 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import java.util.ArrayList;
import com.example.nxttrendz1.model.*;

public interface ProductRepository {
    ArrayList<Product> getAllProducts();

    Product addProduct(Product product);

    Product getById(int productId);

    Product updateProduct(int productId, Product product);

    void deleteProduct(int productId);

}
