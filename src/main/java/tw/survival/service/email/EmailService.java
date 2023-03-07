package tw.survival.service.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendHtmlMail() {
		try {
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			// true表示需要創建一個multipart message
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo("zzz963852789@gmail.com");
			mimeMessageHelper.setSubject("主題");
			mimeMessageHelper.setText("<h1>hello</h1>", true);
			javaMailSender.send(mimeMailMessage);
			System.out.println("html郵件發送成功");
		} catch (MessagingException e) {
			System.out.println("發送html郵件時發生異常！" + e);
		}
	}

}