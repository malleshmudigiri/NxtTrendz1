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
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewjpaRepository;

    @Autowired
    private ProductJpaRepository productjpaService;

    @Override
    public ArrayList<Review> getAllReview() {
        List<Review> list = reviewjpaRepository.findAll();
        ArrayList<Review> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override

    public Review addReview(Review review) {
        try {
            Product product = review.getProduct();
            int productId = product.getProductId();
            Product product123 = productjpaService.findById(productId).get();
            review.setProduct(product123);
            reviewjpaRepository.save(review);
            return reviewjpaRepository.findById(review.getReviewId()).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public Review getReviewById(int reviewId) {
        try {
            Review review = reviewjpaRepository.findById(reviewId).get();
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

    @Override

    public void deleteReview(int reviewId) {

        Optional<Review> reviewOptional = reviewjpaRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            reviewjpaRepository.deleteById(reviewId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override

    public Review updateReview(int reviewId, Review review) {
        try {
            Review review1 = reviewjpaRepository.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                review1.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                review1.setRating(review.getRating());
            }
            if (review.getProduct() != null) {
                Product product22 = review.getProduct();
                int productId1 = product22.getProductId();
                Product product122 = productjpaService.findById(productId1).get();
                review1.setProduct(product122);

            }
            reviewjpaRepository.save(review1);

            return review1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public Product getProductById(int reviewId) {
        try {
            Review review = reviewjpaRepository.findById(reviewId).get();
            Product product = review.getProduct();
            int productId = product.getProductId();
            Product productNew = productjpaService.findById(productId).get();
            return productNew;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
