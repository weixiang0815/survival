package tw.survival.controller.front.CUD.Competition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/front")
@SessionAttributes({ "player", "employee" })
public class CompetitionControllerFrontCUD {

}