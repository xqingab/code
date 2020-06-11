package org.forten.sample;

import java.io.File;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String filename = Environment
			.getExternalStorageDirectory() + "/test.db";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String createTableSql = "CREATE TABLE [test_user] (" +
				"[id] int(10)," +
				"[name] varchar2(30)," +
				"[age] int(3)," +
				"[tel] varchar2(15)," +
				"CONSTRAINT [TEST_USER_PK] PRIMARY KEY ([id]) ON CONFLICT ROLLBACK)";
		
		File file = new File(filename);
		if(file.exists()){
			file.delete();
		}
		// 创建数据文件
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(file, null);
		// 执行建表语句
		db.execSQL(createTableSql);
		
		// 使用ContentValues对象插入数据
		ContentValues cv = new ContentValues();
		cv.put("id", 1);
		cv.put("name", "王小飞");
		cv.put("age", 30);
		cv.put("tel", "13682893293");
		db.insert("test_user", null, cv);
		
		// 使用SQL执行数据
		String insertSql = "INSERT INTO test_user (id,name,age,tel) VALUES (?,?,?,?)";
		db.execSQL(insertSql,new Object[]{2,"王菲",48,"163829392"});
		
		// 查询数据
		String selectSql = "SELECT name,age FROM test_user WHERE age BETWEEN ? AND ?";
		Cursor cursor = db.rawQuery(selectSql, new String[]{"20","55"});
		while(cursor.moveToNext()){
			String name = cursor.getString(0);
			int age = cursor.getInt(1);
			Toast.makeText(MainActivity.this, name+":"+age, Toast.LENGTH_SHORT).show();
		}
		
		db.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
