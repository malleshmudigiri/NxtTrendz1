/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code her
package com.example.nxttrendz1.repository;

import java.util.ArrayList;
import com.example.nxttrendz1.model.*;

public interface ReviewRepository {
    ArrayList<Review> getAllReview();

    Review addReview(Review review);

    Review getReviewById(int reviewId);

    Review updateReview(int reviewId, Review review);

    void deleteReview(int reviewId);

    Product getProductById(int reviewId);

}
