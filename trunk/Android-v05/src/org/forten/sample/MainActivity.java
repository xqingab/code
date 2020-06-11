package org.forten.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
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

		OutputStream os = null;
		try {
			os = openFileOutput("nameFile.txt", Activity.MODE_PRIVATE);
			os.write(name.getBytes("UTF-8"));
			Toast.makeText(MainActivity.this, "数据写入成功", Toast.LENGTH_LONG)
					.show();
		} catch (IOException e) {
			Toast.makeText(MainActivity.this, "数据写入失败", Toast.LENGTH_LONG)
					.show();
		}
	}

	public void read(View v) {
		InputStream is = null;
		try {
			is = openFileInput("nameFile.txt");
			int size = is.available();
			byte[] buffer = new byte[size];
			int byteCount = is.read(buffer);
			String str = new String(buffer, 0, byteCount, "UTF-8");

			Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			Toast.makeText(MainActivity.this, "数据读取失败", Toast.LENGTH_LONG)
					.show();
		}
	}
}
