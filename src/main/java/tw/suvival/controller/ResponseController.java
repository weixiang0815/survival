package tw.suvival.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

	@GetMapping(path = "/response1.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody // application/json
	public String processResponseAction1() {
		return "你好, how are you?";
	}

	@GetMapping("/responseentity.controller")
	public ResponseEntity<String> processResponseEntityAction() {
		return new ResponseEntity<String>("Custom status code(403 Forbidden)", HttpStatus.FORBIDDEN);
	}

	@GetMapping(path = "/imageResponse.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] responseImageAsByteArray(HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/深愛的大海.jfif");
		return IOUtils.toByteArray(in);
	}

}