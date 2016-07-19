package com.conneckto.reviewfeedback.model;

import java.util.ArrayList;
import java.util.Date;

public class Review 
{
	private ArrayList<ReviewItem> reviewItemList ; 
	private ReviewAssignment reviewAssignment ;
	private Date reviewCreationDate ;
	
	public ReviewAssignment getReviewAssignment() {
		return reviewAssignment;
	}
	public void setReviewAssignment(ReviewAssignment reviewAssignment) {
		this.reviewAssignment = reviewAssignment;
	}
	public ArrayList<ReviewItem> getReviewItemList() {
		return reviewItemList;
	}
	public void setReviewItemList(ArrayList<ReviewItem> reviewItemList) {
		this.reviewItemList = reviewItemList;
	}
	public Date getReviewCreationDate() {
		return reviewCreationDate;
	}
	public void setReviewCreationDate(Date reviewCreationDate) {
		this.reviewCreationDate = reviewCreationDate;
	} 
	
}
