package tw.survival.controller;

import java.io.BufferedInputStream;
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

	@GetMapping("/bg/video/{id}")
	public byte[] getBackgroundVideo(@PathVariable Integer id) {
		String filepath = "C:/Survival/videos/";
		String filename;
		switch (id) {
		case 1:
			filename = "kalashnikov-99910.mp4";
			break;
		case 2:
			filename = "war-16391.mp4";
			break;
		default:
			return null;
		}
		filename = filepath + filename;
		byte[] video;
		try (FileInputStream fis = new FileInputStream(filename);
				BufferedInputStream bis = new BufferedInputStream(fis);) {
			video = bis.readAllBytes();
		} catch (Exception e) {
			e.printStackTrace();
			video = null;
		}
		return video;
	}

}