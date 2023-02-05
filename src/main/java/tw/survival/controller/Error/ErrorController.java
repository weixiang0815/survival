package tw.survival.controller.Error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@RequestMapping("/error")
	public String error(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == HttpStatus.BAD_REQUEST.value()) {
			return "Error/400";
		}
		if (statusCode == HttpStatus.NOT_FOUND.value()) {
			return "Error/404";
		}
		if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return "Error/500";
		}
		return "Error/error";
	}

}