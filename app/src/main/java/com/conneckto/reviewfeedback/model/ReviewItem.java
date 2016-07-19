package com.conneckto.reviewfeedback.model;

public class ReviewItem 
{
	/*
	 * This is the primary key of the ReviewItem Table . 
	 */
	private long remarkObjid ;
	
	/*
	 * A single review can have multiple remarks 
	 */
	private long reviewId;
	
	/*
	 * This is a unique remark's ID . 
	 */
	private long remarkId;
	
	/*
	 * The actual review question to be posted to the user . 
	 * For e.g. -- Has the teacher been responsive to your queries ? 
	 */
	private String remark ;
	
	/* 
	 * The total score on the remark . For instance total score of 5 
	 * shall present 5 Radio buttons or a Rating Bar of 5 stars on the GUI . 
	 */
	private int remarkTotalScore ;
	
	/*
	 * This flag decides whether the particular review item is eligible for capturing 
	 * additional free text comments from the user on top of the score 
	 */
	private boolean remarkCommentsFlag;
	
	/*
	 * This is a relation to the ReviewAssignment table . 
	 * Whether this Feedback is being captured for only the class teacher 
	 * or all subject teachers is decided based on the allSubjectsFlag in the ReviewAssignment Table. 
	 */
	private long reviewASsignmentId ;
	
	public long getRemarkObjid() {
		return remarkObjid;
	}
	public void setRemarkObjid(long remarkObjid) {
		this.remarkObjid = remarkObjid;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getRemarkId() {
		return remarkId;
	}
	public void setRemarkId(long remarkId) {
		this.remarkId = remarkId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRemarkTotalScore() {
		return remarkTotalScore;
	}
	public void setRemarkTotalScore(int remarkTotalScore) {
		this.remarkTotalScore = remarkTotalScore;
	}
	public boolean isRemarkCommentsFlag() {
		return remarkCommentsFlag;
	}
	public void setRemarkCommentsFlag(boolean remarkCommentsFlag) {
		this.remarkCommentsFlag = remarkCommentsFlag;
	}
	public long getReviewASsignmentId() {
		return reviewASsignmentId;
	}
	public void setReviewASsignmentId(long reviewASsignmentId) {
		this.reviewASsignmentId = reviewASsignmentId;
	}
}
