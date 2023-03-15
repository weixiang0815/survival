package tw.survival.controller.front.R.Forum;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Forum.MsgsBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Forum.MsgsService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

@Controller
@RequestMapping("/front")
public class MsgsFrontControllerNL {

	private PostsService postsService;

	private CompetitionService competitionService;

	private PlayerService playerService;
	
	private MsgsService msgsService; 
	
//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public MsgsFrontControllerNL(MsgsService msgsService,
			CompetitionService competitionService,
			PlayerService playerService,
			PostsService postsService){
		
	}
	
	@ResponseBody
	@GetMapping("/msgs/axios/get")
	public Page<MsgsBean> addOneAndReturnLatesTen(@RequestParam(name = "p",defaultValue = "1") Integer pageNumber, @RequestParam(name = "postId", defaultValue = "1") Integer postId){
		
		Page<MsgsBean> page = msgsService.getAllMsgsOfPost(pageNumber, postId);
		
		return page;
	}
	
	
	
}
