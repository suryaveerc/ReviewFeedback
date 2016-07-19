package com.conneckto.reviewfeedback.model;

public class ReviewAssignment 
{
	private long reviewAssignmentId;
	private long classId ;
	private boolean allSubjectsFlag ;
	
	public long getReviewAssignmentId() {
		return reviewAssignmentId;
	}
	public void setReviewAssignmentId(long reviewAssignmentId) {
		this.reviewAssignmentId = reviewAssignmentId;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public boolean isAllSubjectsFlag() {
		return allSubjectsFlag;
	}
	public void setAllSubjectsFlag(boolean allSubjectsFlag) {
		this.allSubjectsFlag = allSubjectsFlag;
	}

}
