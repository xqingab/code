package org.forten.sample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void toSecond(View v) {
		EditText et = (EditText) findViewById(R.id.editText1);
		String name = et.getText().toString();
		if (name == null || name.equals("")) {
			TextView tv = (TextView) findViewById(R.id.first_label);
			tv.setText("请输入姓名");
		} else {
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);

			intent.putExtra("name", name);

			startActivity(intent);
		}
	}
}
