package org.forten.sample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

	public void sayHello(View v) {
		EditText et = (EditText) findViewById(R.id.usernameET);

		String name = et.getText().toString();
		String msg = null;
		if (name == null || name.equals("")) {
			msg = "请输入用户名！";
		} else {
			msg = "你好" + name + "!";
		}
		
		TextView tv = (TextView) findViewById(R.id.showLabel);
		tv.setText(msg);
		
		Toast t = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
		t.show();
	}

}
