package org.forten.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.forten.sample.util.PropertiesFileReader;

public class MailUtil {
	private static final PropertiesFileReader reader = new PropertiesFileReader("email");
	private static final String HOST_NAME = reader.getString("HOST_NAME");
	private static final int PORT = reader.getInt("PORT");
	private static final String USER = reader.getString("USER");
	private static final String PASSWORD = reader.getString("PASSWORD");
	private static final boolean SSL_CONNECT = reader.getBoolean("SSL_CONNECT");
	private static final String FROM_ADDRESS = reader.getString("FROM_ADDRESS");
	private static final String NICKNAME = reader.getString("NICKNAME");

	public static void sendMail(String subject, String msg, String to) {
		try {
			// 实例化一个简单的电子邮件对象
			Email email = new SimpleEmail();
			// 设置SMTP服务器的地址（邮件发送服务器）
			email.setHostName(HOST_NAME);
			// SMTP服务器使用的端口号
			email.setSmtpPort(PORT);
			// 邮箱的认证（用户名和密码）
			email.setAuthenticator(new DefaultAuthenticator(USER, PASSWORD));
			// 设置是否使用安全套接字连接
			email.setSSLOnConnect(SSL_CONNECT);
			// 设置发信人的邮件地址
			email.setFrom(FROM_ADDRESS, NICKNAME);
			// 设置邮件标题
			email.setSubject(subject);
			// 邮件内容
			email.setMsg(msg);
			// 收信人Email地址
			email.addTo(to);
			// 执行发送
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
