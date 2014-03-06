package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	int mCreate = 0;
	int mStart = 0;
	int mResume = 0;
	int mRestart = 0;

	// TODO: Create variables for each of the TextViews, called
	// mTvCreate, etc.
	TextView mTvCreate;
	TextView mTvStart;
	TextView mTvResume;
	TextView mTvRestart;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate=(TextView) findViewById(R.id.create);
		mTvStart=(TextView) findViewById(R.id.start);
		mTvResume=(TextView) findViewById(R.id.resume);
		mTvRestart=(TextView) findViewById(R.id.restart);




		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
					// This function closes Activity Two
				// Hint: use Context's finish() method
				ActivityTwo.this.finish();


			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			this.mStart=savedInstanceState.getInt(START_KEY, mStart);
			this.mRestart=savedInstanceState.getInt(RESTART_KEY, mRestart);
			this.mCreate=savedInstanceState.getInt(CREATE_KEY,mCreate);
			this.mResume=savedInstanceState.getInt(RESUME_KEY, mResume);
		}

		// TODO: Emit LogCat message

		mCreate += 1;
		Log.i(TAG,"Entered the onCreate() method");
		displayCounts();

		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method




	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		mStart+=1;
		Log.i(TAG,"Entered the onStart() method");
		displayCounts();

		// TODO:
		// Update the appropriate count variable
		// Update the user interface



	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		mResume+=1;
		Log.i(TAG,"Entered the onResume() method");
		displayCounts();

		// TODO:
		// Update the appropriate count variable
		// Update the user interface




	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG,"Entered the onPause() method");
		// TODO: Emit LogCat message



	}

	@Override
	public void onStop() {
		Log.i(TAG,"Entered the onStop() method");
		super.onStop();

		// TODO: Emit LogCat message



	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		mRestart+=1;
		Log.i(TAG,"Entered the onRestart() method");
		displayCounts();

		// TODO:
		// Update the appropriate count variable
		// Update the user interface



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable

		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(RESUME_KEY, mResume);




	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	}
}