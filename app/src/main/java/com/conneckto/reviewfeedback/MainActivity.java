package com.conneckto.reviewfeedback;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.conneckto.dao.ReviewAndFeedbackDAOImpl;
import com.conneckto.reviewfeedback.model.Review;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button btnLoad = (Button) findViewById(R.id.start_review);

		View.OnClickListener listener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//ApplicationContextProvider applicationContextProvider = new ApplicationContextProvider();
				btnLoad.setVisibility(View.GONE);
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				ReviewAndFeedBackFragment feedBackFragment = new ReviewAndFeedBackFragment();
				fragmentTransaction.add(R.id.fragment_container,feedBackFragment);
				ReviewAndFeedbackDAOImpl reviewAndFeedbackDAO = new ReviewAndFeedbackDAOImpl();
				Review review = reviewAndFeedbackDAO.getReview();

				feedBackFragment.setReview(review);
				fragmentTransaction.commit();
			}
		};

		btnLoad.setOnClickListener(listener);

		// The MainActivity has A Button and a FrameLayout .
		// The Button on clicked does the following -- 
		// 1. Creates a ReviewAndFeedbackDAOImpl Object and Fetches/gets a Review Object

		// 2. Constructs a ReviewAndFeedBackFragment Object and sets the Review Object in it . 
		// 3. Populates the FrameLayout with a ReviewAndFeedBackFragment  
		
	}

}
