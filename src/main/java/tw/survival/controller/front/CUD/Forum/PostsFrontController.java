package tw.survival.controller.front.CUD.Forum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Player.PlayerBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Employee.EmployeeService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

@Controller
@SessionAttributes({ "player" })
@RequestMapping("/front")
public class PostsFrontController {

	private PostsService postsService;

	private CompetitionService competitionService;

	private PlayerService playerService;

//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public PostsFrontController(PostsService postsService, CompetitionService competitionService,
			EmployeeService employeeService, PlayerService playerService) {
		this.postsService = postsService;
		this.competitionService = competitionService;
		this.playerService = playerService;
	}
	/**
	 * @param model 為了新增postsBean,player兩物件
	 * @return 將定義的model轉到newOne.jsp
	 * @apiNote 新增貼文服務表單按鈕，只由會員新增，貼文的活動外來鍵欄位則為null。
	 * @author 鄭力豪
	 */
	@GetMapping("/posts/new")
	public String newOnePost(Model model) {
		PostsBean postsBean = new PostsBean();
		model.addAttribute("postsBean", postsBean);
		model.addAttribute("player");
		return "front/Forum/Posts/newOne";
	}
	/**
	 * @param postsBean 即將新增的postsBean物件
	 * @param model 為了拿到player物件
	 * @return 重導至newOnePost()方法，該方法為使用者新增貼文預備功能。
	 * @apiNote 存取貼文並刷新新增貼文清單。
	 * @author 鄭力豪
	 */
	@PostMapping("/posts/create")
	public String create(@ModelAttribute("postsBean") PostsBean postsBean, Model model) {
		PlayerBean player =(PlayerBean) model.getAttribute("player");
		//連結
		postsBean.setPlayer(player);
		//存Bean
		postsService.insertPost(postsBean);
		return "redirect:/front/posts/new";

	}
	
	
	
	
	

}