package tw.survival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestExceptionController {

	@RequestMapping(value = "/testException.controller")
	public void processExceptionAction() throws Exception {
//		throw new Exception();
		throw new MySystemException("Server Alert");
	}

}