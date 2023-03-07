package tw.survival.controller.global;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/front")
public class FrontControllerAjax {

	@GetMapping("/api/getTerms/{type}")
	public String getTerms(@PathVariable String type) {
		String filepath = "C:/Survival/code-of-conduct/";
		String filename;
		StringBuilder content = new StringBuilder("");
		switch (type) {
		case "company":
			filename = "公司權利.txt";
			break;
		case "disclaimer":
			filename = "免責條款.txt";
			break;
		case "user":
			filename = "使用者條款.txt";
			break;
		case "rent":
			filename = "場地租借.txt";
			break;
		case "privacy":
			filename = "隱私權.txt";
			break;
		case "signup":
			filename = "活動報名條款.txt";
			break;
		default:
			filename = "錯誤存取.txt";
			break;
		}
		filename = filepath + filename;
		try (FileInputStream fis = new FileInputStream(filename);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);) {
			String line;
			while ((line = br.readLine()) != null) {
				content.append("<p>" + line + "</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			content = new StringBuilder("路徑出現錯誤");
		}
		return content.toString();
	}

}