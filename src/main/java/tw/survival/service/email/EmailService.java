package tw.survival.service.email;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tw.survival.model.Player.PlayerBean;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendHtmlMail(PlayerBean player) {
		try {
			
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			// true表示需要創建一個multipart message
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo(player.getEmail());
			mimeMessageHelper.setSubject("這是一封激活郵件");
			mimeMessageHelper.setText("<a target='_Blank' href='${contextRoot}'>+player.name</a>", true);
			javaMailSender.send(mimeMailMessage);
			System.out.println("html郵件發送成功");
		} catch (MessagingException e) {
			System.out.println("發送html郵件時發生異常！" + e);
		}
	}

}