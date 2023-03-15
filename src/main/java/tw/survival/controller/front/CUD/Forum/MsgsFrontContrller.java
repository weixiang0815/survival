package tw.survival.controller.front.CUD.Forum;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.MsgDTO;
import tw.survival.model.Forum.MsgsBean;
import tw.survival.model.Player.PlayerBean;
import tw.survival.service.Forum.MsgsService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

@Controller
@SessionAttributes({ "player" })
@RequestMapping("/front")
public class MsgsFrontContrller {
	
	private PostsService postsService;
	
	private PlayerService playerService;
	
	private MsgsService msgsService;
	
//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public MsgsFrontContrller(PostsService postsService,
			PlayerService playerService,
			MsgsService msgsService) {
		this.postsService = postsService;
		this.playerService = playerService;
		this.msgsService = msgsService;
	}
	
	@ResponseBody
	@PostMapping("/msgs/axios/post")
	public List<MsgsBean> addOneAndReturnLateTen(@RequestBody MsgDTO msgDTO){
		//新增Bean
		MsgsBean msgsBean = new MsgsBean();
		msgsBean.setEssay(msgDTO.getContent());
		Set<PlayerBean> player = msgsBean.getPlayer();
		player.add(playerService.findByBean(msgDTO.getPlayerId()));
		msgsBean.setPlayer(player);
		msgsBean.setPost(postsService.findPostById(msgDTO.getPostId()));
		//存Bean
		msgsService.insertMsgs(msgsBean);
		
		Page<MsgsBean> allMsgsOfPost = msgsService.getAllMsgsOfPost(1, msgDTO.getPostId());
		List<MsgsBean> content = allMsgsOfPost.getContent();
		
		return content;
		
	}
	
	
	
	
	
	
	
}
