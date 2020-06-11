package org.forten.sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.forten.sample.model.User;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String filename = Environment
			.getExternalStorageDirectory() + "/userArray.json";

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
		List<User> list = new ArrayList<User>();
		list.add(new User("Tom", 32, "63829923"));
		list.add(new User("Mike", 22, "64321923"));
		list.add(new User("Jack", 13, "8293223"));

		FileOutputStream out = null;
		JsonWriter jw = null;

		try {
			out = new FileOutputStream(filename);
			jw = new JsonWriter(new OutputStreamWriter(out));

			jw.beginArray();
			for (User u : list) {
				jw.beginObject();
				jw.name("name").value(u.getName());
				jw.name("age").value(u.getAge());
				jw.name("tel").value(u.getTel());
				jw.endObject();
			}
			jw.endArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jw.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void read(View v) {
		FileInputStream in = null;
		JsonReader jr = null;
		List<User> result = new ArrayList<User>();
		try {
			in = new FileInputStream(filename);
			jr = new JsonReader(new InputStreamReader(in));

			jr.beginArray();
			while (jr.hasNext()) {
				User user = new User();
				jr.beginObject();
				while (jr.hasNext()) {
					String attrName = jr.nextName();
					if (attrName.equals("name")) {
						user.setName(jr.nextString());
					}
					if (attrName.equals("age")) {
						user.setAge(jr.nextInt());
					}
					if (attrName.equals("tel")) {
						user.setTel(jr.nextString());
					}
				}
				jr.endObject();
				result.add(user);
			}
			jr.endArray();

			for (User user : result) {
				Toast.makeText(MainActivity.this, user.toString(),
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jr.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
