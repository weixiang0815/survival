package tw.survival.controller.Market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApi {

	@GetMapping("/test2")
	public String test2() {
		return "66666";
	}

}
