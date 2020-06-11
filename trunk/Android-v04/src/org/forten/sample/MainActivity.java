package org.forten.sample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

	public void save(View v) {
		EditText et = (EditText) findViewById(R.id.editText1);
		String name = et.getText().toString();

		SharedPreferences sp = getSharedPreferences("test",
				Activity.MODE_PRIVATE);

		Editor editor = sp.edit();
		editor.putString("value", name);
		editor.commit();

		Toast.makeText(MainActivity.this, "数据保存成功", Toast.LENGTH_LONG).show();
	}

	public void read(View v) {
		SharedPreferences sp = getSharedPreferences("test",
				Activity.MODE_PRIVATE);

		String value = sp.getString("value", "佚名");

		Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
	}
}
