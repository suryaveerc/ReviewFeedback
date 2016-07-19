package com.conneckto.reviewfeedback.model;

import java.util.ArrayList;

/*
 * A Rating Object is per review Object . 
 * For Reviews having allSubjectsFlag True there shall be multiple Rating Objects 
 * One per Subject . 
 */

public class Rating 
{
	private ArrayList<RatingItem> ratingItems ;

	public ArrayList<RatingItem> getRatingItems() {
		return ratingItems;
	}

	public void setRatingItems(ArrayList<RatingItem> ratingItems) {
		this.ratingItems = ratingItems;
	}

}
