package org.forten.sample.test;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailTest01 {

	public static void main(String[] args) throws EmailException {
		// 实例化一个简单的电子邮件对象
		Email email = new SimpleEmail();
		// 设置SMTP服务器的地址（邮件发送服务器）
		email.setHostName("smtp.126.com");
		// SMTP服务器使用的端口号
		email.setSmtpPort(465);
		// 邮箱的认证（用户名和密码）
		email.setAuthenticator(new DefaultAuthenticator("thcic_test", "a123456"));
		// 设置是否使用安全套接字连接
		email.setSSLOnConnect(true);
		// 设置发信人的邮件地址
		email.setFrom("thcic_test@126.com","齐天大朕");
		// 设置邮件标题
		email.setSubject("测试邮件");
		// 邮件内容
		email.setMsg("这是一封电子邮件，退下吧~");
		// 收信人Email地址
		email.addTo("thcic_test@163.com");
		// 执行发送
		email.send();
	}

}
