/**
 *
 */
package com.conneckto.dao;

import com.conneckto.reviewfeedback.model.Rating;
import com.conneckto.reviewfeedback.model.Review;
import com.conneckto.reviewfeedback.model.ReviewAssignment;
import com.conneckto.reviewfeedback.model.ReviewItem;

import java.util.ArrayList;
import java.util.Date;

public class ReviewAndFeedbackDAOImpl implements ReviewAndFeedbackDAO {
    /*
     * For testing purpose , create a static Review Object with few rows of data populated
     * And return it from this method .
     */
    @Override
    public Review getReview() {
        // TODO Auto-generated method stub
        ReviewItem reviewItem1 = new ReviewItem();
        reviewItem1.setRemark("Was the teacher always responsive?");
        reviewItem1.setRemarkId(1);
        reviewItem1.setRemarkObjid(1);
        reviewItem1.setRemarkTotalScore(5);
        reviewItem1.setReviewId(1);
        reviewItem1.setReviewASsignmentId(1);

        ReviewItem reviewItem2 = new ReviewItem();
        reviewItem2.setRemark("Does the teacher have know how of the subject?");
        reviewItem2.setRemarkId(2);
        reviewItem2.setRemarkObjid(2);
        reviewItem2.setRemarkTotalScore(5);
        reviewItem2.setReviewId(2);
        reviewItem1.setReviewASsignmentId(1);

        ReviewItem reviewItem3 = new ReviewItem();
        reviewItem3.setRemark("Was the teacher pro-active in reaching you?");
        reviewItem3.setRemarkId(2);
        reviewItem3.setRemarkObjid(2);
        reviewItem3.setRemarkTotalScore(5);
        reviewItem3.setReviewId(2);
        reviewItem1.setReviewASsignmentId(1);


        ArrayList<ReviewItem> reviewItemArrayList = new ArrayList<>();
        reviewItemArrayList.add(reviewItem1);
        reviewItemArrayList.add(reviewItem2);
        reviewItemArrayList.add(reviewItem3);

        ReviewAssignment reviewAssignment = new ReviewAssignment();
        reviewAssignment.setAllSubjectsFlag(true);
        reviewAssignment.setClassId(1);
        reviewAssignment.setReviewAssignmentId(1);
        Review review = new Review();
        review.setReviewCreationDate(new Date());
        review.setReviewItemList(reviewItemArrayList);
        review.setReviewAssignment(reviewAssignment);
        return review;
    }

    /*
     * For testing purpose , Simply Log/Print the Incoming Rating object In here .
     */
    @Override
    public void updateRating(Rating rating) {
        // TODO Auto-generated method stub

        System.out.println("Submitted");
    }

}
