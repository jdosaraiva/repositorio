package br.com.saraiva.utils;

import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.Message;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
public class Gmail {  
  
    public static void main(String args[])  
        throws Exception {  
		
		if (args.length < 5) {
			System.out.println("Uso: gmail <usuario> <senha> <servidor smtp> <porta> <to>");
			System.exit(1);
		}
		
		final String usuario = args[0];
		final String senha = args[1];
		final String server = args[2];
		final String port = args[3];
		final String to = args[4];
		
        Properties prop = new Properties();  
        prop.put("mail.smtp.host", server);  
        prop.put("mail.smtp.auth", "true");  
        prop.put("mail.smtp.port", port);  
        prop.put("mail.smtp.starttls.enable", "true");  
        prop.put("mail.smtp.socketFactory.port", port);  
        prop.put("mail.smtp.socketFactory.fallback", "true");  
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
  
        Authenticator auth = new Authenticator() {  
            @Override  
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  
                return new javax.mail.PasswordAuthentication(usuario, senha);  
            }  
        };  
  
        Session session = Session.getInstance(prop, auth);  
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(usuario));  
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
        message.setSubject("Teste");  
        message.setContent("the body message", "text/plain");  
        Transport.send(message);  

		System.exit(0);
 }  
}  