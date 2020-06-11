package org.forten.sample.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailTest02 {

	public static void main(String[] args) throws EmailException, MalformedURLException {
		  HtmlEmail email = new HtmlEmail();
		  email.setHostName("smtp.126.com");
		  email.addTo("thcic_test@163.com", "Tom");
		  email.setFrom("thcic_test@126.com", "Mike");
		  email.setSubject("HTML Email");
		  
		  email.setSmtpPort(465);
		  email.setSSLOnConnect(true);
		  email.setAuthenticator(new DefaultAuthenticator("thcic_test", "a123456"));
		  URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
		  String cid = email.embed(url, "Apache logo");
		  
		  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

		  email.setTextMsg("Your email client does not support HTML messages");

		  email.send();
	}

}
