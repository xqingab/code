package org.forten.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String filename = Environment.getExternalStorageDirectory()
			+ "/image.png";

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
		FileOutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(filename);
			in = getResources().getAssets().open("accept.png");

			byte[] buffer = new byte[in.available()];
			int count = 0;
			if ((count = in.read(buffer)) >= 0) {
				out.write(buffer, 0, count);
			}

			Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG)
					.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void read(View v) {
		File file = new File(filename);
		if (!file.exists()) {
			Toast.makeText(MainActivity.this, "请保存图片后再显示", Toast.LENGTH_LONG)
					.show();
		} else {
			ImageView iv = (ImageView) findViewById(R.id.imageView1);
			Bitmap image = BitmapFactory.decodeFile(filename);
			iv.setImageBitmap(image);
		}

	}

}
