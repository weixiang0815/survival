package tw.survival.service.email;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionBean;
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
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true, "UTF-8");
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo(player.getEmail());
			mimeMessageHelper.setSubject("這是一封激活郵件");
			mimeMessageHelper.setText("<h1><a target='_Blank' href='http://localhost:8080/Survival/active/"+player.getId()+"' >"+player.getName()+"這是一個激活連結"+"</a></h1>", true);
			javaMailSender.send(mimeMailMessage);
			System.out.println("<a target='_Blank' href='http://localhost:8080/Survival/active/"+player.getId()+"' >"+player.getName()+"</a>");
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
	public boolean sendSignupResult(SignUpBean signup) {
		CompetitionBean comp = signup.getCompetition();
		PlayerBean player = signup.getPlayer();
		try {
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo(player.getEmail());
			mimeMessageHelper.setSubject("【" + comp.getMandarinName() + "】報名成功");
			mimeMessageHelper.setText(signupResultWriter(signup), true);
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
	public boolean sendSignupInvoice(SignUpBean signup) {
		CompetitionBean comp = signup.getCompetition();
		PlayerBean player = signup.getPlayer();
		try {
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
			mimeMessageHelper.setFrom("travelmateeeit157@gmail.com");
			mimeMessageHelper.setTo(player.getEmail());
			mimeMessageHelper.setSubject("【" + comp.getMandarinName() + "】繳費成功");
			mimeMessageHelper.setText(signupInvoiceWriter(signup), true);
			FileSystemResource file = new FileSystemResource(new File(generateInvoice(signup)));
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMailMessage);
			System.out.println("活動報名電子發票發送成功");
			return true;
		} catch (MessagingException e) {
			System.out.println("發送郵件時發生異常！" + e);
			return false;
		}
	}

	/**
	 * 撰寫活動報名成功通知內文
	 * 
	 * @param signup 報名成功的活動實體
	 * @param player 報名成功的會員實體
	 * @return 寫好的內文
	 * @author 王威翔
	 */
	private String signupResultWriter(SignUpBean signup) {
		CompetitionBean comp = signup.getCompetition();
		PlayerBean player = signup.getPlayer();
		StringBuilder text = new StringBuilder("");
		return text.toString();
	}

	/**
	 * 撰寫活動報名繳費成功通知內文
	 * 
	 * @param signup 繳費成功的活動實體
	 * @param player 繳費成功的會員實體
	 * @return 寫好的內文
	 * @author 王威翔
	 */
	private String signupInvoiceWriter(SignUpBean signup) {
		CompetitionBean comp = signup.getCompetition();
		PlayerBean player = signup.getPlayer();
		StringBuilder text = new StringBuilder("");
		return text.toString();
	}

	/**
	 * 生成活動報名繳費電子發票 PDF 檔
	 * 
	 * @param signup 繳費成功的活動報名實體
	 * @return 生成 PDF 檔的檔案路徑
	 * @author 王威翔
	 */
	private String generateInvoice(SignUpBean signup) {
		String playerName = "王威翔";
		String competitionName = "反共最前線";
		Double amountPaid = 99999999d;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
		Date currentDate = new Date();

		String filepath = "C:/";
		String filename = "invoice.pdf";

		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);

			String fontPath = "C:/Windows/Fonts/kaiu.ttf";
			PDType0Font font = PDType0Font.load(document, new File(fontPath));

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			contentStream.beginText();
			contentStream.setFont(font, 18);
			contentStream.newLineAtOffset(250, 700);
			contentStream.showText("發票");
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(100, 650);
			contentStream.showText("選手名稱：" + playerName);
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(100, 630);
			contentStream.showText("比賽名稱：" + competitionName);
			contentStream.endText();

			DecimalFormat df = new DecimalFormat("#,##0.00");
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(100, 610);
			contentStream.showText("金額：" + df.format(amountPaid));
			contentStream.endText();

			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(100, 590);
			contentStream.showText("日期：" + formatter.format(currentDate));
			contentStream.endText();

			contentStream.close();
			document.save(filepath + filename);
			document.close();

			System.out.println("電子發票生成成功");
			return filepath + filename;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}