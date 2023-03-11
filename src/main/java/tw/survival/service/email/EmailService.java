package tw.survival.service.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.SignUpBean;
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

	/**
	 * 寄送活動報名成功通知
	 * 
	 * @param signup 報名成功的活動報名實體
	 * @param player 報名成功的會員實體
	 * @param text   電子郵件內文
	 * @return 寄送成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean sendSignupResult(SignUpBean signup, PlayerBean player, String text) {
		try {
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo(player.getEmail());
			mimeMessageHelper.setSubject("【" + signup.getCompetition().getMandarinName() + "】報名成功");
			mimeMessageHelper.setText(text, true);
			javaMailSender.send(mimeMailMessage);
			System.out.println("活動報名電子發票發送成功");
			return true;
		} catch (MessagingException e) {
			System.out.println("發送郵件時發生異常！" + e);
			return false;
		}
	}

	/**
	 * 寄送活動報名繳費成功通知，並附加 PDF 電子發票
	 * 
	 * @param signup      繳費成功的活動報名實體
	 * @param player      繳費成功的會員實體
	 * @param invoicePath PDF 電子發票檔案路徑
	 * @param text        電子郵件內文
	 * @return 寄送成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean sendSignupInvoice(SignUpBean signup, PlayerBean player, String text, String invoicePath) {
		try {
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo(player.getEmail());
			mimeMessageHelper.setSubject("【" + signup.getCompetition().getMandarinName() + "】繳費成功");
			mimeMessageHelper.setText(text, true);
			FileSystemResource file = new FileSystemResource(new File(invoicePath));
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMailMessage);
			System.out.println("活動報名電子發票發送成功");
			return true;
		} catch (MessagingException e) {
			System.out.println("發送郵件時發生異常！" + e);
			return false;
		}
	}

}