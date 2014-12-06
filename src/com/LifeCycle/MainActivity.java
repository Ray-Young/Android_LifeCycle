package com.LifeCycle;

import java.util.ArrayList;

import com.ex2.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
//建议使用
public class MainActivity extends ActionBarActivity {
	private ArrayList<ResultObj> list = new ArrayList<ResultObj>();
	private ListView listView;
	private MyAdapter myAdapter;
	private EditText editText;
	private String stringEditText;
	private static final String TAG = "ActivityDemo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list1);
		editText = (EditText) findViewById(R.id.edittext);
		myAdapter = new MyAdapter(getApplicationContext());
		listView.setAdapter(myAdapter);
		Log.e(TAG, "onCreate");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		editText.setText(stringEditText);
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
		stringEditText = "Hello World";
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

	public class ResultObj {
		public String nameString;
	}

	public class MyAdapter extends BaseAdapter {
		private LayoutInflater inflater;

		public MyAdapter(Context context) {
			inflater = LayoutInflater.from(context);
			ResultObj obj = new ResultObj();
			obj.nameString = "Andy";
			list.add(obj);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {

				convertView = inflater.inflate(R.layout.list_item, null);
			}
			ResultObj objResult = (ResultObj) getItem(position);
			TextView txt1 = (TextView) convertView.findViewById(R.id.text1);
			txt1.setText(objResult.nameString);

			return convertView;
		}

	}
}
