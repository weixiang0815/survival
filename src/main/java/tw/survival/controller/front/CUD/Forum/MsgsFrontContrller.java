package tw.survival.controller.front.CUD.Forum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Forum.MsgBlockDao;
import tw.survival.model.Forum.MsgBlockDto;
import tw.survival.model.Forum.MsgDto;
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
	
	private MsgBlockDao msgBlockDao;
	
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
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	//C
	@ResponseBody
	@PostMapping("/msgs/axios/post")
	public Page<MsgsBean> addOneAndReturnLateTen(@RequestBody MsgDto msgDTO, Model model){
		
		//新增Bean
		MsgsBean msgsBean = new MsgsBean();
		msgsBean.setEssay(msgDTO.getContent());
		msgsBean.setPost(postsService.findPostById(msgDTO.getPostId()));
		
		//存Bean (msgsBean)
		MsgsBean insertMsgs = msgsService.insertMsgs(msgsBean);
		Integer msgid = insertMsgs.getId();
		
		//新增Bean
		PlayerToMsgsBean playerToMsgs = new PlayerToMsgsBean();
		PlayerBean player = (PlayerBean)model.getAttribute("player");
		playerToMsgs.setPlayer(player);
		playerToMsgs.setMsgs(insertMsgs);
		//存Bean (playerToMsgs)
		PlayerToMsgsBean ptmb = playerToMsgsService.insertPtmb(playerToMsgs);
		//補值
		Set<PlayerToMsgsBean> forMsgs = insertMsgs.getForMsgs();
		forMsgs.add(ptmb);
		insertMsgs.setForMsgs(forMsgs);
		
		
		Page<MsgsBean> allMsgsOfPost = msgsService.getAllMsgsOfPost(1, msgDTO.getPostId());
		
		return allMsgsOfPost;
		
	}
	
	
	

	
	
	/**
	 * 
	 * @param msgDTO 傳入物件
	 * @param model 有考慮到是否會加入Session物件，但這裡似乎不需要
	 * @return Page物件 MsgBlockDto 是一個自訂義物件，是一個留言板內需要的內容(會員加留言)。
	 * @author 鄭力豪
	 * @apiNote 回傳一個依照留言建置時間降序排列的留言板，有分頁效果。
	 */
	@ResponseBody
	@PostMapping("/msgBlock/axios/post")
	public Page<MsgBlockDto> addMsgAndReturnLateTen(@RequestBody MsgDto msgDto, Model model){
		
		//新增Bean
		MsgsBean msgsBean = new MsgsBean();
		msgsBean.setEssay(msgDto.getContent());
		msgsBean.setPost(postsService.findPostById(msgDto.getPostId()));
		
		//存Bean (msgsBean)
		MsgsBean insertMsgs = msgsService.insertMsgs(msgsBean);
		Integer msgid = insertMsgs.getId();
		
		//新增Bean
		PlayerToMsgsBean playerToMsgs = new PlayerToMsgsBean();
		PlayerBean player = (PlayerBean)model.getAttribute("player");
		playerToMsgs.setPlayer(player);
		playerToMsgs.setMsgs(insertMsgs);
		//存Bean (playerToMsgs)
		PlayerToMsgsBean ptmb = playerToMsgsService.insertPtmb(playerToMsgs);
		//補值
		Set<PlayerToMsgsBean> forMsgs = insertMsgs.getForMsgs();
		forMsgs.add(ptmb);
		insertMsgs.setForMsgs(forMsgs);
		
		//依照SQL語法輸出的List物件
		List<MsgsBean> msgsList = msgsService.getMsgListOfPost(msgDto.getPostId());
		
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
