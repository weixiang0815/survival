package tw.survival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

	@GetMapping("/")
	public String getHomePage() {
		return "front/index";
	}

	@GetMapping("/about")
	public String getAboutPage() {
		return "front/about";
	}

	@GetMapping("/service")
	public String getServicePage() {
		return "front/service";
	}

	@GetMapping("/price")
	public String getPricePage() {
		return "front/price";
	}

	@GetMapping("/team")
	public String getTeamPage() {
		return "front/team";
	}

	@GetMapping("/open")
	public String getOpenPage() {
		return "front/open";
	}

	@GetMapping("/testimonial")
	public String getTestimonialPage() {
		return "front/testimonial";
	}

	@GetMapping("/404page")
	public String get404Page() {
		return "front/404";
	}

	@GetMapping("/contact")
	public String getContactPage() {
		return "front/contact";
	}

}