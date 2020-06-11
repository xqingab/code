package org.forten.sample;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.forten.sample.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.StrictMode;
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
		// 启动一条子线程来进行http请求
		new Thread() {
			public void run() {
				// 获取用户输入的数据
				String idStr = ((EditText) findViewById(R.id.idEt)).getText()
						.toString();
				String name = ((EditText) findViewById(R.id.nameEt)).getText()
						.toString();
				String ageStr = ((EditText) findViewById(R.id.ageEt)).getText()
						.toString();
				String tel = ((EditText) findViewById(R.id.telEt)).getText()
						.toString();

				int id = Integer.parseInt(idStr);
				int age = Integer.parseInt(ageStr);
				// 封装Java的User类型对象
				User user = new User(id, name, age, tel);

				// 指定要请求的服务器资源地址
				String url = "http://166.111.202.234:8080/user/save.do";
				// 定义请求方式是POST，并把url与http的post请求对象关联
				HttpPost post = new HttpPost(url);

				// 对对象进行JSON化处理
				JSONObject userJson = new JSONObject();
				try {
					userJson.put("id", user.getId());
					userJson.put("name", user.getName());
					userJson.put("age", user.getAge());
					userJson.put("tel", user.getTel());

					// 设置HTTP请求的数据内容类型为JSON格式
					post.setHeader("content-type", "application/json");
					// 把JSON格式的对象进行字符串化，然后放置到一个StringEntity中（请求报文中的数据内容）
					StringEntity se = new StringEntity(userJson.toString(),
							"UTF-8");
					// 把带有JSON数据的StringEntity对象与POST请求进行关联
					post.setEntity(se);
					// 发送请求并得到服务器响应
					HttpResponse response = new DefaultHttpClient()
							.execute(post);
					// 获取响应报文中的内容
					String result = EntityUtils.toString(response.getEntity());

					// 保证线程安全，使用Toast显示响应消息
					Looper.prepare();
					Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG)
							.show();
					Looper.loop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void read(View v) {
		// 设置要访问的URL资源
		String url = "http://166.111.202.234:8080/user/list.do";
		// 使用Get方式对URL进行请求
		HttpGet get = new HttpGet(url);

		// 设置HTTP的线程
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		try{
			// 调用get方式中定义的URL，并得到HTTP响应对象
			HttpResponse response = new DefaultHttpClient().execute(get);
			
			// 判断如果响应对象的状态行中的状态码是200，则表示请求成功，进行后续的操作
			if(response.getStatusLine().getStatusCode()==200){
				// 通过响应对象的getEntity()方法得到响应报文中的正文，并通过EntityUtils类的toString方法转换成为字符串
				String content = EntityUtils.toString(response.getEntity());
				JSONArray ja = new JSONArray(content);
				for(int i = 0;i<ja.length();i++){
					JSONObject userJson = ja.getJSONObject(i);
					User u = new User();
					u.setId(userJson.getInt("id"));
					u.setName(userJson.getString("name"));
					u.setAge(userJson.getInt("age"));
					u.setTel(userJson.getString("tel"));
					Toast.makeText(MainActivity.this, u.toString(), Toast.LENGTH_SHORT).show();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
