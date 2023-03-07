package tw.survival.controller.Forum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.PostsBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Employee.EmployeeService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

@Controller
@SessionAttributes({"player"})
@RequestMapping("/front")
public class PostsFrontController {

	private PostsService postsService;
	
	private CompetitionService competitionService;
	
	private PlayerService playerService;
	
//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public PostsFrontController(PostsService postsService, 
			CompetitionService competitionService, 
			EmployeeService employeeService,
			PlayerService playerService) {
		this.postsService = postsService;
		this.competitionService = competitionService;
		this.playerService = playerService; 
	}
	
	@GetMapping("Forum/index")
	public String frontMainController(Model model) {
		PostsBean postsBean = new PostsBean();
		model.addAttribute("postsBean", postsBean);
		return "front/Forum/index";
	}
	
	
}
