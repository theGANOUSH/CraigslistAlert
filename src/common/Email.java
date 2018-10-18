/**
 * 
 */
package common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

/**
 * @author alowe01
 *
 */
public class Email {
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	
	public static void sendEmail(List<Item> data) {
		mailServerProperties = new Properties();
		mailServerProperties.put("mail.smtp.host", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		
		Session getMailSession = Session.getInstance(mailServerProperties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("babaganoush45@gmail.com", "jledlkjilrhzugmb");
            }
        });
		try {
			//Creating a Message object to set the email content
			MimeMessage msg = new MimeMessage(getMailSession);
			//Storing the comma seperated values to email addresses
			String to = "babaganoush45@outlook.com";
			
			/*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
			 * addresses in an array of InternetAddress objects*/
			InternetAddress[] address = InternetAddress.parse(to, true);
			
			//Setting the recepients from the address variable
			msg.setRecipients(Message.RecipientType.TO, address);
			String timeStamp = new SimpleDateFormat("mm/dd/yy").format(new Date());
			msg.setSubject("CraigslistAlert! : " + timeStamp);
			msg.setSentDate(new Date());
			msg.setHeader("XPriority", "1");
			msg.setContent(getMessage(data), "text/html");
			
			Transport.send(msg);
			System.out.println("Mail has been sent successfully");
		} catch (MessagingException mex) {
			System.out.println("Unable to send an email" + mex);
		}
		
	}
	
	public static String getMessage(List<Item> data)
	{
		StringBuilder message = new StringBuilder();
		
		
		message.append("<table>");
		
		for(Item item : data)
		{
			message.append("<tr><td>");
			message.append(item.getTitle() + "</td><td>");
			message.append("$" + item.getPrice() + "</td><td>");
			message.append("<a href=" + item.getUrl() + ">Check Now!</a></td>");
			
		}
		
		message.append("</table>");
		
		return message.toString();
	}

}
