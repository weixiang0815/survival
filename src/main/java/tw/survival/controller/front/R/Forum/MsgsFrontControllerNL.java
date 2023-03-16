package tw.survival.controller.front.R.Forum;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Forum.MsgBlockDao;
import tw.survival.model.Forum.MsgBlockDto;
import tw.survival.model.Forum.MsgsBean;
import tw.survival.model.Player.PlayerBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Forum.MsgsService;
import tw.survival.service.Forum.PlayerToMsgsService;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Player.PlayerService;

@Controller
@RequestMapping("/front")
public class MsgsFrontControllerNL {

	private PostsService postsService;

	private CompetitionService competitionService;

	private PlayerService playerService;
	
	private MsgsService msgsService; 
	
	private PlayerToMsgsService playerToMsgsService;
	
//	@Autowired //若是只有一個建構子，SpringBoot會自動加入Autowired功能。
	public MsgsFrontControllerNL(MsgsService msgsService,
			CompetitionService competitionService,
			PlayerService playerService,
			PostsService postsService,
			PlayerToMsgsService playerToMsgsService){
		this.msgsService = msgsService;
		this.competitionService= competitionService;
		this.playerService = playerService;
		this.playerToMsgsService = playerToMsgsService;
		this.postsService = postsService;
	}
	
	@ResponseBody
	@GetMapping("/msgs/axios/get")
	public Page<MsgsBean> addOneAndReturnLatesTen(
			@RequestParam(name = "p",defaultValue = "1") Integer pageNumber, 
			@RequestParam(name = "postId", defaultValue = "1") Integer postId){
		
		Page<MsgsBean> page = msgsService.getAllMsgsOfPost(pageNumber, postId);
		
		return page;
	}
	
	@ResponseBody
	@GetMapping("/msgBlockNL/axios/get")
	public Page<MsgBlockDto> addMsgAndReturnLateTen(
			@RequestParam(name = "p",defaultValue = "1") Integer pageNumber,  
			@RequestParam(name="post_id", defaultValue = "1") Integer postId,  
			Model model){
		
		//依照SQL語法輸出的List物件
		List<MsgsBean> msgsList = msgsService.getMsgListOfPost(postId);
		
		//新增容器
		List<MsgBlockDto> msgBlockList = new ArrayList<MsgBlockDto>();
		
		//依照留言表每個留言來找到使用者並把他們的資料包到MsgBlockDto物件裡(順序依照留言表)。
		for(MsgsBean msgs : msgsList) {
			
			MsgBlockDto msgBlockDto = new MsgBlockDto();
			PlayerBean playerBean = playerToMsgsService.findPtmbByMsgsId(msgs.getId()).getPlayer();
			
			msgBlockDto.setPlayerId(playerBean.getId());
			msgBlockDto.setPlayerCounty(playerBean.getCounty());
			msgBlockDto.setPlayerName(playerBean.getName());
			msgBlockDto.setPlayerNickname(playerBean.getNickname());
			msgBlockDto.setMsgId(msgs.getId());
			msgBlockDto.setMsgEssay(msgs.getEssay());
			msgBlockDto.setMsgAdded(msgs.getAdded());
			
			
			msgBlockList.add(msgBlockDto);
		}
		//引用自訂義Dao,有設定分頁機制沒有排序功能
		MsgBlockDao msgBlockDao = new MsgBlockDao();
		Page<MsgBlockDto> msgBlockByPage = msgBlockDao.getMsgBlockByPage(pageNumber, 10, msgBlockList);
		
		
		return msgBlockByPage;
		
	}
	
	@ResponseBody
	@GetMapping("/msgBlockNL/axios/firstPage")
	public Page<MsgBlockDto> getFirstPage(
			@RequestParam(name="post_id", defaultValue = "1") Integer postId, 
			Model model){
		
		//依照SQL語法輸出的List物件
		List<MsgsBean> msgsList = msgsService.getMsgListOfPost(postId);
		
		//新增容器
		List<MsgBlockDto> msgBlockList = new ArrayList<MsgBlockDto>();
		
		//依照留言表每個留言來找到使用者並把他們的資料包到MsgBlockDto物件裡(順序依照留言表)。
		for(MsgsBean msgs : msgsList) {
			
			MsgBlockDto msgBlockDto = new MsgBlockDto();
			PlayerBean playerBean = playerToMsgsService.findPtmbByMsgsId(msgs.getId()).getPlayer();
			
			msgBlockDto.setPlayerId(playerBean.getId());
			msgBlockDto.setPlayerCounty(playerBean.getCounty());
			msgBlockDto.setPlayerName(playerBean.getName());
			msgBlockDto.setPlayerNickname(playerBean.getNickname());
			msgBlockDto.setMsgId(msgs.getId());
			msgBlockDto.setMsgEssay(msgs.getEssay());
			msgBlockDto.setMsgAdded(msgs.getAdded());
			
			
			msgBlockList.add(msgBlockDto);
		}
		//引用自訂義Dao,有設定分頁機制沒有排序功能
		MsgBlockDao msgBlockDao = new MsgBlockDao();
		Page<MsgBlockDto> msgBlockByPage = msgBlockDao.getMsgBlockByPage(1, 10, msgBlockList);
		
		
		return msgBlockByPage;
		
	}
}
