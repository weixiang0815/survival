package tw.survival.service.Competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionDao;
import tw.survival.model.Competition.CompetitionRepository;
import tw.survival.model.Competition.CompetitionSearchCondititonsDto;
import tw.survival.model.Competition.CompetitionToScheduleBean;
import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Place.PlaceBean;
import tw.survival.model.Place.ScheduleBean;
import tw.survival.service.Forum.PostsService;
import tw.survival.service.Place.PlaceService;

@Service
@Transactional
public class CompetitionService {

	@Autowired
	private CompetitionRepository compRepo;

	@Autowired
	private CompetitionDao compDao;

	@Autowired
	private PostsService postsService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private CompetitionToScheduleService compToScheduleService;

	/**
	 * 新建一筆活動資訊，但尚未公布與發新貼文
	 * 
	 * @param comp 欲新建資訊的活動實體
	 * @return 新建成功回傳活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean create(CompetitionBean comp) {
		try {
			String content = comp.getContent();
			String startDate = comp.getStartDate();
			Integer startTimespan = comp.getStartTimespan();
			String endDate = comp.getEndDate();
			Integer endTimespan = comp.getEndTimespan();
			comp = compRepo.save(comp);
			competitionToSchedule(startDate, startTimespan, endDate, endTimespan, comp.getId(), comp.getPlaceId());
			File file = new File("C:/Survival/Competition/Competition/content");
			if (!file.exists()) {
				file.mkdirs();
			}
			String filepath = "C:/Survival/Competition/Competition/content/content_" + comp.getId() + ".txt";
			comp.setContentFileLocation(filepath);
			comp.setContent(content);
			try (FileOutputStream fos = new FileOutputStream(filepath);
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					PrintWriter pw = new PrintWriter(osw);) {
				pw.println(content);
			}
			return comp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 正式發布一筆活動資訊，並發新貼文
	 * 
	 * @param id 欲發布資訊的活動 id
	 * @return 發布成功回傳活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean publishById(Integer id) {
		Optional<CompetitionBean> optional = compRepo.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = findById(id);
			comp.setStatus("已發布");
			PostsBean newPost = new PostsBean();
			newPost.setName(comp.getMandarinName());
			newPost.setClassify("活動競賽😎");
			newPost.setEssay(comp.getContent());
			postsService.insertPost(newPost);
			compRepo.save(comp);
			return comp;
		}
		return null;
	}

	/**
	 * 透過 id 查詢一筆活動實體
	 * 
	 * @param id 欲查詢資訊的活動 id
	 * @return 查詢成功回傳該活動實體，查無資料回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean findById(Integer id) {
		Optional<CompetitionBean> optional = compRepo.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = optional.get();
			StringBuffer content = new StringBuffer("");
			try (FileInputStream fis = new FileInputStream(comp.getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);) {
				String line = "";
				while ((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				comp.setContent(content.toString());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return comp;
		}
		return null;
	}

	/**
	 * 查詢最新活動實體
	 * 
	 * @return 查詢成功回傳該活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean findLatestCompetition() {
		try {
			CompetitionBean comp = compRepo.findFirstByOrderByIdDesc();
			StringBuffer content = new StringBuffer("");
			try (FileInputStream fis = new FileInputStream(comp.getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);) {
				String line = "";
				while ((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				comp.setContent(content.toString());
			}
			return comp;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查詢至今所有創建過的活動實體
	 * 
	 * @return 裝有所有活動實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionBean> findAll() {
		List<CompetitionBean> comps = compRepo.findAll();
		comps.forEach(comp -> {
			StringBuffer content = new StringBuffer("");
			try (FileInputStream fis = new FileInputStream(comp.getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);) {
				String line = "";
				while ((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				comp.setContent(content.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return comps;
	}

	/**
	 * 多條件查詢活動結果
	 * 
	 * @param conditions 查詢依據的各種條件
	 * @return 裝著活動實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionBean> multiconditionSearch(CompetitionSearchCondititonsDto conditions) {
		List<CompetitionBean> comps = compDao.multiconditionSearch(conditions);
		comps.forEach(comp -> {
			StringBuffer content = new StringBuffer("");
			try (FileInputStream fis = new FileInputStream(comp.getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);) {
				String line = "";
				while ((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				comp.setContent(content.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return comps;
	}

	/**
	 * 透過 id 刪除一筆活動紀錄
	 * 
	 * @param id 欲刪除紀錄的活動實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			// 需先刪除對應活動獎品實體與論壇系統貼文
			String filepath = compRepo.findById(id).get().getContentFileLocation();
			File file = new File(filepath);
			file.delete();
			compToScheduleService.deleteByCompetitionId(id);
			compRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一筆活動紀錄
	 * 
	 * @param comp 欲刪除紀錄的活動實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 */
	public boolean deleteByEntity(CompetitionBean comp) {
		try {
			String filepath = comp.getContentFileLocation();
			File file = new File(filepath);
			file.delete();
			compToScheduleService.deleteByCompetitionId(comp.getId());
			compRepo.delete(comp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過 id 下架一筆活動資訊並刪除貼文，但尚未從資料庫中刪除整個紀錄
	 * 
	 * @param id 欲下架的活動實體 id
	 * @return 下架成功回傳該活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean takedownById(Integer id) {
		Optional<CompetitionBean> optional = compRepo.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = optional.get();
			comp.setStatus("未發布");
			// 需刪除論壇系統的對應貼文
			compRepo.save(comp);
			return comp;
		}
		return null;
	}

	/**
	 * 更新一筆活動實體
	 * 
	 * @param comp 欲更新內容的活動實體
	 * @return 更新成功回傳該活動實體，拋出錯誤回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean updateByEntity(CompetitionBean comp) {
		Optional<CompetitionBean> optional = compRepo.findById(comp.getId());
		if (optional.isPresent()) {
			CompetitionBean oldComp = optional.get();
			if (scheduleIsChanged(comp, oldComp)) {
				String startDate = comp.getStartDate();
				Integer startTimespan = comp.getStartTimespan();
				String endDate = comp.getEndDate();
				Integer endTimespan = comp.getEndTimespan();
				compToScheduleService.deleteByCompetitionId(comp.getId());
				competitionToSchedule(startDate, startTimespan, endDate, endTimespan, comp.getId(), comp.getPlaceId());
			}
			try (FileOutputStream fos = new FileOutputStream(comp.getContentFileLocation());
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					PrintWriter pw = new PrintWriter(osw);) {
				pw.print(comp.getContent());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return compRepo.save(comp);
		}
		return null;
	}

	/**
	 * 重新發布一筆既有的活動實體
	 * 
	 * @param id 欲重新發布的活動實體 id
	 * @return 重新發布成功回傳該活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean republishById(Integer id) {
		Optional<CompetitionBean> optional = compRepo.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = optional.get();
			comp.setStatus("已發布");
			// 重新發布貼文
			compRepo.save(comp);
			return comp;
		}
		return null;
	}

	/**
	 * 檢查活動時程有無更動
	 * 
	 * @param newComp 新活動實體
	 * @param oldComp 救活動實體
	 * @return 有更動回傳 true，否則回傳 false
	 * @author 王威翔
	 */
	public boolean scheduleIsChanged(CompetitionBean newComp, CompetitionBean oldComp) {
		String newStartDate = newComp.getStartDate();
		String oldStartDate = oldComp.getStartDate();

		Integer newStartTimespan = newComp.getStartTimespan();
		Integer oldStartTimespan = oldComp.getStartTimespan();

		String newEndDate = newComp.getEndDate();
		String oldEndDate = oldComp.getEndDate();

		Integer newEndTimespan = newComp.getEndTimespan();
		Integer oldEndTimespan = oldComp.getEndTimespan();

		boolean test = newStartDate.contentEquals(oldStartDate) && newStartTimespan == oldStartTimespan
				&& newEndDate.contentEquals(oldEndDate) && newEndTimespan == oldEndTimespan;

		return test ? false : true;
	}

	/**
	 * 將活動舉辦日期與時段轉化為對應時程表，並同步更新到活動時程中介表
	 * 
	 * @param startDate     活動開始日期
	 * @param startTimespan 活動開始時段
	 * @param endDate       活動結束日期
	 * @param endTimespan   活動結束時段
	 * @param competitionId 活動實體 id
	 * @param placeId       場地實體 id
	 * @author 王威翔
	 */
	public void competitionToSchedule(String startDate, Integer startTimespan, String endDate, Integer endTimespan,
			Integer competitionId, Integer placeId) {
		// 將時間轉化為時程表，並同步更新到 CompetitionToScheduleBean
		try {
			CompetitionBean comp = findById(competitionId);
			PlaceBean place = placeService.getOnePlaceById(placeId);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date start = formatter.parse(startDate);
			Date end = formatter.parse(endDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(start);
			while (true) {
				Date currentDate = calendar.getTime();
				if (currentDate.compareTo(end) > 0) {
					break;
				}
				if (start.compareTo(end) == 0) {
					for (int timespan = startTimespan; timespan <= endTimespan; timespan++) {
						ScheduleBean schedule = new ScheduleBean(timespan, currentDate, place);
						CompetitionToScheduleBean ctsb = new CompetitionToScheduleBean(schedule, comp);
						compToScheduleService.insert(ctsb);
					}
				} else {
					if (currentDate.compareTo(start) == 0) {
						for (int timespan = startTimespan; timespan <= 4; timespan++) {
							ScheduleBean schedule = new ScheduleBean(timespan, currentDate, place);
							CompetitionToScheduleBean ctsb = new CompetitionToScheduleBean(schedule, comp);
							compToScheduleService.insert(ctsb);
						}
					} else if (currentDate.compareTo(end) == 0) {
						for (int timespan = 1; timespan <= endTimespan; timespan++) {
							ScheduleBean schedule = new ScheduleBean(timespan, currentDate, place);
							CompetitionToScheduleBean ctsb = new CompetitionToScheduleBean(schedule, comp);
							compToScheduleService.insert(ctsb);
						}
					} else {
						for (int timespan = 1; timespan <= 4; timespan++) {
							ScheduleBean schedule = new ScheduleBean(timespan, currentDate, place);
							CompetitionToScheduleBean ctsb = new CompetitionToScheduleBean(schedule, comp);
							compToScheduleService.insert(ctsb);
						}
					}
				}
				calendar.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}