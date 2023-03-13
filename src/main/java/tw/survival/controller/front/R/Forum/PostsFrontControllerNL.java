package tw.survival.controller.front.R.Forum;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.MsgsBean;
import tw.survival.model.Forum.PostsBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Employee.EmployeeService;
import tw.survival.service.Forum.MsgsService;
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
@SessionAttributes("player")
@RequestMapping("/front")
public class PostsFrontControllerNL {

	private PostsService postsService;

	private CompetitionService competitionService;

	private PlayerService playerService;
	
	private MsgsService msgsService;

//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public PostsFrontControllerNL(PostsService postsService, CompetitionService competitionService,
			MsgsService msgsService, PlayerService playerService) {
		this.postsService = postsService;
		this.competitionService = competitionService;
		this.playerService = playerService;
		this.msgsService = msgsService;
	}

	/**
	 * @author 鄭力豪
	 * @apiNote 論壇主頁。
	 */
	@GetMapping("/Forum/index")
	public String frontMainNLController() {
		return "front/Forum/index";
	}
	
	@GetMapping("/posts/content")
	public String getOnePost(@RequestParam("id")Integer id, Model model){
		PostsBean post = postsService.findPostById(id);
		Page<MsgsBean> allMsgsOfPost = msgsService.getAllMsgsOfPost(1,id);
		model.addAttribute("post", post);
		model.addAttribute("messages", allMsgsOfPost);
		model.getAttribute("player");
		return "front/Forum/Posts/ShowOne";
	}
	
	
	/**
	 * @param model 設定model 目的為設置輸入物件
	 * @return String 設定View
	 * @author 鄭力豪
	 * @apiNote 成列所有前十筆文章(作用為預設第一頁)
	 */
	@GetMapping("/posts/getAll")
	public String searchMain(Model model) {
		Page<PostsBean> page = postsService.getPostsWithNameContainingByPage(1, "");
		List<PostsBean> postsList = page.getContent();
		model.addAttribute("page",page);
		model.addAttribute("postsList",postsList);
		return"front/Forum/Posts/getAllPosts";
	}
	
	
	/**
	 * @param name 欲輸入的模糊搜尋名稱
	 * @return page物件
	 * @author 鄭力豪
	 * @apiNote 把模糊搜尋的前十筆資料丟出來
	 */
	@ResponseBody
	@GetMapping("/posts/ajax/postpage")
	public Page<PostsBean> addOneAndReturnLatesTen(@RequestParam(name = "SearchStr", defaultValue = "") String name){
		
		Page<PostsBean> page = postsService.getPostsWithNameContainingByPage(1, name);
		
		return page;
	}
	
	/**
	 * @param pageNumber 欲輸入的頁碼
	 * @param name 欲輸入的模糊搜尋名稱
	 * @return page物件
	 * @author 鄭力豪
	 * @apiNote 把模糊搜尋的資料依照十筆為一頁丟出某頁
	 */
	@ResponseBody
	@GetMapping("/posts/ajax/page")
	public Page<PostsBean> showPostsByPageAjax(@RequestParam(name = "p",defaultValue = "1") Integer pageNumber, @RequestParam(name = "SearchStr") String name) {
		
		Page<PostsBean> page = postsService.getPostsWithNameContainingByPage(pageNumber, name);
		
		return page;
	}
	
//	/**
//	 * @return page物件
//	 * @author 鄭力豪
//	 * @apiNote 測試資料。
//	 */
//	@ResponseBody
//	@PostMapping("/posts/ajax/text")
//	public Page<PostsBean> text(){
//		Page<PostsBean> page = postsService.getAllPostsByPage(1);
//		return page;
//	}
	
	
}

