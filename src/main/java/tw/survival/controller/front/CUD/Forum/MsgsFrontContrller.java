package tw.survival.controller.front.CUD.Forum;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.MsgDTO;
import tw.survival.model.Forum.MsgsBean;
import tw.survival.model.Forum.PlayerToMsgsBean;
import tw.survival.model.Player.PlayerBean;
import tw.survival.service.Forum.MsgsService;
import tw.survival.service.Forum.PlayerToMsgsService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

@Controller
@SessionAttributes({ "player" })
@RequestMapping("/front")
public class MsgsFrontContrller {
	
	private PostsService postsService;
	
	private PlayerService playerService;
	
	private PlayerToMsgsService playerToMsgsService; 
	
	private MsgsService msgsService;
	
//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public MsgsFrontContrller(PostsService postsService,
			PlayerService playerService,
			MsgsService msgsService,
			PlayerToMsgsService playerToMsgsService) {
		this.postsService = postsService;
		this.playerService = playerService;
		this.msgsService = msgsService;
		this.playerToMsgsService = playerToMsgsService;
	}
	
	@ResponseBody
	@PostMapping("/msgs/axios/post")
	public List<MsgsBean> addOneAndReturnLateTen(@RequestBody MsgDTO msgDTO, Model model){
		
		//新增Bean
		MsgsBean msgsBean = new MsgsBean();
		msgsBean.setEssay(msgDTO.getContent());
		msgsBean.setPost(postsService.findPostById(msgDTO.getPostId()));
		
		//存Bean (msgsBean)
		MsgsBean insertMsgs = msgsService.insertMsgs(msgsBean);
		
		//新增Bean
		PlayerToMsgsBean playerToMsgs = new PlayerToMsgsBean();
		PlayerBean player = (PlayerBean)model.getAttribute("player");
		playerToMsgs.setPlayer(player);
		playerToMsgs.setMsgs(insertMsgs);
		//存Bean (playerToMsgs)
		playerToMsgsService.insertPtmb(playerToMsgs);
		
		Page<MsgsBean> allMsgsOfPost = msgsService.getAllMsgsOfPost(1, msgDTO.getPostId());
		List<MsgsBean> content = allMsgsOfPost.getContent();
		return content;
		
	}
	
	
	
	
	
	
	
}
