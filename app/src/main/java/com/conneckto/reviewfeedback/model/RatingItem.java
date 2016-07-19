package com.conneckto.reviewfeedback.model;

/*
 * This class captures the user's feedback on a review .
 * A rating object has to be created per ReviewItem .
 */

public class RatingItem 
{
	private long ratingObjid	;
	private long classId	;
	private long teacherId;
	private long studentId;
	private long remarkObjid ;
	private int remarkScore	;
	private String remarkComment ;
	
	public long getRatingObjid() {
		return ratingObjid;
	}
	public void setRatingObjid(long ratingObjid) {
		this.ratingObjid = ratingObjid;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getRemarkObjid() {
		return remarkObjid;
	}
	public void setRemarkObjid(long remarkObjid) {
		this.remarkObjid = remarkObjid;
	}
	public int getRemarkScore() {
		return remarkScore;
	}
	public void setRemarkScore(int remarkScore) {
		this.remarkScore = remarkScore;
	}
	public String getRemarkComment() {
		return remarkComment;
	}
	public void setRemarkComment(String remarkComment) {
		this.remarkComment = remarkComment;
	}
}
