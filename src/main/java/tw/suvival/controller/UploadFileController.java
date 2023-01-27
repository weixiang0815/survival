package tw.suvival.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.suvival.model.Picture;
import tw.suvival.model.PictureService;

@Controller
public class UploadFileController {

	@GetMapping("/uploadmain.controller")
	public String processMainAction() {
		return "uploadFile";
	}

	@PostMapping(path = "/upload.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processAction(@RequestParam("myFiles") MultipartFile mf) throws IOException {
		String fileName = mf.getOriginalFilename();
		System.out.println("檔名：" + fileName);

		String saveFileDir = "C:/temp/upload/";
		File saveFilePath = new File(saveFileDir, fileName);

		byte[] b = mf.getBytes();
		mf.transferTo(saveFilePath);

		if (fileName != null && fileName.length() != 0) {
			saveImage(fileName, b);
		}

		return "儲存檔案位置：" + saveFilePath;
	}

	@Autowired
	private PictureService pService;

	private void saveImage(String fileName, byte[] b) {
		Picture p = new Picture(fileName, b);
		pService.insert(p);
	}

}