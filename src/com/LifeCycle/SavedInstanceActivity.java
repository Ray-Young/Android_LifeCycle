package com.LifeCycle;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import com.ex2.R;

public class SavedInstanceActivity extends ActionBarActivity {
	private EditText editText;
	private String stringEditText;
	private static final String TAG = "ActivityDemo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saved_instance);
		editText = (EditText) findViewById(R.id.SavedEditText);
		if (savedInstanceState != null) {
			String text = savedInstanceState.getString("str1");
		
			editText.setText(text);
			Log.e(TAG, "Restore Successfully");

		}	
		
		Log.e(TAG, "onCreate");
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString("str1", "Andy");
		super.onSaveInstanceState(savedInstanceState);
		Log.e(TAG, "saveInstanceState");

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.d(TAG, savedInstanceState.getString("str1"));
		Log.e(TAG, "RestoreInstance");

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		//editText.setText("Andy");
		Log.e(TAG, "onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		// stringEditText = editText.getText().toString();
		Log.e(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "onDestroy");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
