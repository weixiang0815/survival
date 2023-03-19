package tw.survival.controller.front.CUD.Forum;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.PostDto;
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
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private CompetitionService competitionService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private EmployeeService employeeService;


	
	
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
	 * @param model     為了拿到player物件
	 * @return 重導至newOnePost()方法，該方法為使用者新增貼文預備功能。
	 * @apiNote 存取貼文並刷新新增貼文清單。
	 * @author 鄭力豪
	 */
	@PostMapping("/posts/create")
	public String create(@ModelAttribute("postsBean") PostsBean postsBean, Model model) {
		PlayerBean player = (PlayerBean) model.getAttribute("player");
		// 連結
		postsBean.setPlayer(player);
		// 存Bean
		postsService.insertPost(postsBean);
		return "redirect:/front/posts/new";

	}

	/**
	 * 
	 * @param model
	 * @return
	 * @apiNote 跳到個人貼文專頁
	 */
	@GetMapping("/posts/myPosts")
	public String toMyPosts(Model model) {
		return "front/Forum/Posts/myPosts";
	}
	
	/**
	 * @author 鄭力豪
	 * @apiNote 傳至更改貼文頁面。
	 */
	@GetMapping("/posts/editPage")
	public String toEditPage(@RequestParam(name="id")Integer postId,Model model) {
		PostsBean post = postsService.findPostById(postId);
		model.addAttribute("postEdit", post);
		return "front/Forum/Posts/editPost";
	}
	
	@PostMapping("/posts/edit")
	public String editPost(@ModelAttribute(name="postEdit")PostsBean post) {
		
//		PostsBean postEdit = postsService.findPostById(post.getId());
		post.setFinalAdded(new Date());
//		postEdit.setClassify(post.getClassify());
//		postEdit.setName(post.getName());
		post = postsService.updatePost(post);
		System.out.println(post);
		return "redirect:/front/posts/myPosts";
	}
	
	
	@GetMapping("/posts/delete")
	public String deletePost(@RequestParam(name="id")Integer postId) {
		postsService.deletePost(postId);
		return "redirect:/front/posts/myPosts";
	}

	/**
	 * 
	 * @param postDto    多條件參數
	 * @param pageNumber 頁碼
	 * @param model      為了回傳之必要
	 * @return postsPage
	 * @apiNote 多條件查詢 回傳 PostsBean的Page 物件
	 */
	@ResponseBody
	@PostMapping("/posts/myPosts/getTenPosts")
	public Page<PostsBean> getPostByPlayerId(@RequestBody PostDto postDto) {
		Page<PostsBean> postsPage = postsService.getPostByPlayerIdByPage(1, 10, postDto);
		return postsPage;
	}
}