package tw.survival.controller.back;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@SessionAttributes({ "player", "employee" })
public class TemplateControllerAjax {

}