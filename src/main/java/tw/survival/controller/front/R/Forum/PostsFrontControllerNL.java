package tw.survival.controller.front.R.Forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Employee.EmployeeService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

/**
 * @定義 命名為PostsFrontControllerNL <br>
 *     後面添加的 NL(non-login) 為非登入者 的命名方式。<br>
 *     裡面具有非會員也能實作的功能。<br>
 * 
 * @功用 內有有訪客搜索貼文的功能，具有會員方面的特殊性搜尋步還蓋在其範圍內。
 * 
 * @author 鄭力豪
 *
 */
@Controller
@RequestMapping("/front")
public class PostsFrontControllerNL {

	private PostsService postsService;

	private CompetitionService competitionService;

	private PlayerService playerService;

//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public PostsFrontControllerNL(PostsService postsService, CompetitionService competitionService,
			EmployeeService employeeService, PlayerService playerService) {
		this.postsService = postsService;
		this.competitionService = competitionService;
		this.playerService = playerService;
	}

	/**
	 * 
	 * @param model:<br>
	 *                   這裡是下一行
	 * @return
	 */
	@GetMapping("Forum/index")
	public String frontMainControllerNL() {
//		PostsBean postsBean = new PostsBean();
//		model.addAttribute("postsBean", postsBean);
		return "front/Forum/index";
	}

}