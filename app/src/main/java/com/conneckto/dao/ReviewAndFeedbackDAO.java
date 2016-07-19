package com.conneckto.dao;

import com.conneckto.reviewfeedback.model.Rating;
import com.conneckto.reviewfeedback.model.Review;

/*
 * This is the Data Accessor Interface 
 */
public interface ReviewAndFeedbackDAO 
{
	public abstract Review getReview();
	public abstract void updateRating(Rating rating);
}
