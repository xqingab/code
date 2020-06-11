package org.forten.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		TextView tv = (TextView) findViewById(R.id.second_label);
		tv.setText(name);
		Toast.makeText(SecondActivity.this, name, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	public void toFirst(View v) {
		Intent intent = new Intent(SecondActivity.this, MainActivity.class);
		startActivity(intent);
	}
}
