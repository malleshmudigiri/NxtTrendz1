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

import com.example.nxttrendz1.service.*;
import com.example.nxttrendz1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ReviewController {
    @Autowired
    public ReviewJpaService reviewjpaService;

    @GetMapping("/products/reviews")
    public ArrayList<Review> getAllReview() {
        return reviewjpaService.getAllReview();
    }

    @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewjpaService.addReview(review);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getReviewById(@PathVariable("reviewId") int reviewId) {
        return reviewjpaService.getReviewById(reviewId);

    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        return reviewjpaService.updateReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId) {
        reviewjpaService.deleteReview(reviewId);

    }

    @GetMapping("/reviews/{reviewId}/product")
    public Product getProductById(@PathVariable("reviewId") int reviewId) {
        return reviewjpaService.getProductById(reviewId);

    }

}