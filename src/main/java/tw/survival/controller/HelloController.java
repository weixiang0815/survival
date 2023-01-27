package tw.survival.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		HashMap<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		if (name == null || name.length() == 0) {
			errors.put("name", "Name is required");
		}
		if (errors != null && !errors.isEmpty()) {
			return new ModelAndView("/form.jsp");
		}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		return new ModelAndView("/success.jsp");
	}

}