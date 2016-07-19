package com.conneckto.reviewfeedback;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.conneckto.dao.ReviewAndFeedbackDAOImpl;
import com.conneckto.reviewfeedback.model.Rating;
import com.conneckto.reviewfeedback.model.RatingItem;
import com.conneckto.reviewfeedback.model.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This is the actual Fragment that contains all the functionality of the Review&Feedback Process .
 * This fragment class shall be provided as inputs the review and reviewAssignment object.
 * Based on the review object the view shall be populated .
 * Based on user actions on the view , the Rating object shall be populated and passed to the DAO
 * service layer to be updated in the DB .
 * <p/>
 * Additional Details --
 * Review has a List of ReviewItems . A ReviewItem is a single question to be presented on the screen
 * for the user .
 * ReviewAssignment class has the boolean allSubjectsFlag , which if true , the feedback has to be collected
 * for all Subjects in a sequential flow .
 * The list of Subjects and corresponding teachers can be fetched from the ApplicationContextProvider .
 */

public class ReviewAndFeedBackFragment extends Fragment {
    private int teacherId = 0;
    private static Review review;

    View v;
    private HashMap<Integer, String> subjectTeacherhashMap;
    private Iterator<Map.Entry<Integer, String>> iterator;
    private Map.Entry<Integer, String> teacherEntry;
    private ArrayList<RatingItem> ratingItemsList;
    private ReviewAndFeedBackFragment reviewAndFeedBackFragment;
    private int[] ratingIds;
    private int[] ratingQuestionIds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        //return super.onCreateView(inflater, container, savedInstanceState);

        v = inflater.inflate(R.layout.review_fragment, null);
        reviewAndFeedBackFragment = new ReviewAndFeedBackFragment();
        subjectTeacherhashMap = ApplicationContextProvider.getSubjectTeacherMap();
        iterator = subjectTeacherhashMap.entrySet().iterator();
        System.out.println(review.getReviewItemList().size());
        System.out.println("in fragment");
        ratingItemsList = new ArrayList<>();
        setFragment();
        updateFragment();
        return v;

    }

    private void setFragment() {
        int reviewsCount = review.getReviewItemList().size();
        ratingIds = new int[reviewsCount];
        ratingQuestionIds = new int[reviewsCount];
        RelativeLayout fragmentView = (RelativeLayout) v.findViewById(R.id.reviewView);

        fragmentView.setOnTouchListener(new OnSwipeTouchListener(this.getActivity()) {

            public void onSwipeLeft() {

                if (review.getReviewAssignment().isAllSubjectsFlag())
                    updateFragment();
                else
                    completeReview();
            }
        });

        TextView teacherView = (TextView) v.findViewById(R.id.teacherView);

        int id = teacherView.getId();

        for (int i = 0; i < reviewsCount; i++) {
            id = setupRatingBarText(fragmentView, id, i);
            id = setupRatingBar(fragmentView, id, i);
        }
        RelativeLayout.LayoutParams rp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        TextView commentsTitleView = (TextView) v.findViewById(R.id.commentsTitleView);
        rp.addRule(RelativeLayout.BELOW, id);
        commentsTitleView.setLayoutParams(rp);

        Button submitButton = (Button) v.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRatingHandler(v);
            }
        });

    }

    public void updateFragment() {

        if (iterator.hasNext()) {

            teacherEntry = iterator.next();
            String teacher = teacherEntry.getValue();
            System.out.println("In update" + teacher);
            int reviewsCount = review.getReviewItemList().size();
            TextView teacherView = (TextView) v.findViewById(R.id.teacherView);
            teacherView.setText("Feedback for " + teacher);

            for (int i = 0; i < reviewsCount; i++) {
                //	System.out.println(review.getReviewAssignment().getClassId());
                //	System.out.println(review.getReviewItemList().get(i).getRemark());
                TextView textView = (TextView) v.findViewById(ratingQuestionIds[i]);
                textView.setText(review.getReviewItemList().get(i).getRemark());
                RatingBar ratingBar = (RatingBar) v.findViewById(ratingIds[i]);
                ratingBar.setRating(0.0f);
                ((EditText) v.findViewById(R.id.commentsBoxView)).setText("");
            }
        } else {
            completeReview();
        }

    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    /*
     * The onClickListener method of the Submit Button on a Review Screen
     * Invoke the ReviewAndFeedbackDAO.updateRating() with a Rating Object from this method.
     */
    public void submitRatingHandler(View view) {

        int reviewsCount = review.getReviewItemList().size();
        TextView teacherView = (TextView) v.findViewById(R.id.teacherView);
        Rating rating = new Rating();

        for (int i = 0; i < reviewsCount; i++) {
            RatingBar ratingBar = (RatingBar) v.findViewById(ratingIds[i]);
            RatingItem ratingItem = new RatingItem();
            ratingItem.setClassId(1);
            ratingItem.setRemarkObjid(review.getReviewItemList().get(i).getRemarkObjid());
            ratingItem.setRemarkScore((int) ratingBar.getRating());
            ratingItem.setTeacherId(teacherEntry.getKey());
            String comment = ((EditText) v.findViewById(R.id.commentsBoxView)).getText().toString();
            ratingItem.setRemarkComment(comment);
            review.getReviewItemList().get(i).setRemarkTotalScore((int) ratingBar.getRating());
            ratingItemsList.add(ratingItem);
        }
        ReviewAndFeedbackDAOImpl reviewAndFeedbackDAO = new ReviewAndFeedbackDAOImpl();
        rating.setRatingItems(ratingItemsList);
        reviewAndFeedbackDAO.updateRating(rating);
        updateFragment();
    }

    private void completeReview() {
        Intent myIntent = new Intent(this.getActivity(), ReviewFinishActivity.class);
        startActivity(myIntent);
        getActivity().finish();
    }

    private int setupRatingBar(View view, int relativeViewId, int ratingBarIndex) {
        RelativeLayout.LayoutParams rp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RatingBar ratingBar = new RatingBar(view.getContext());
        ratingBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ratingBar.setStepSize(1.0f);
        ratingBar.setNumStars(5);
        ratingIds[ratingBarIndex] = View.generateViewId();
        ratingBar.setId(ratingIds[ratingBarIndex]);
        System.out.println("Adding ratingbar with id " + ratingBar.getId() + " below " + " , " + relativeViewId);
        rp.addRule(RelativeLayout.BELOW, relativeViewId);
        rp.setMargins(5, 5, 5, 5);
        ((RelativeLayout) view).addView(ratingBar, rp);
        return ratingIds[ratingBarIndex];
    }

    private int setupRatingBarText(View view, int relativeViewId, int ratingBarIndex) {
        RelativeLayout.LayoutParams tp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(view.getContext());
        ratingQuestionIds[ratingBarIndex] = View.generateViewId();
        textView.setId(ratingQuestionIds[ratingBarIndex]);
        System.out.println("Adding question with id " + textView.getId() + " below " + " , " + relativeViewId);
        tp.addRule(RelativeLayout.BELOW, relativeViewId);
        tp.setMargins(5, 5, 5, 5);
        ((RelativeLayout) view).addView(textView, tp);


        return ratingQuestionIds[ratingBarIndex];
    }
}
