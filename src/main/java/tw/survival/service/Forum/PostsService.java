package tw.survival.service.Forum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tw.survival.model.Forum.PostDao;
import tw.survival.model.Forum.PostDto;
import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Forum.PostsRepository;

@Service
public class PostsService {

	@Autowired
	private PostsRepository pRepo;

	@Autowired
	private PostDao pDao;

	/**
	 * @apiNote 新建一筆貼文資料
	 * 
	 * @param post 欲新建資訊的貼文實體，尚未連結活動內容
	 * @return 新建成功回傳貼文實體，失敗回傳 null
	 * @author 鄭力豪
	 */
	public PostsBean insertPost(PostsBean post) {
		try {
			String content = post.getContent();
			PostsBean postSave = pRepo.save(post);
			String location = "C:/Survival/Posts/content/";
			File folder = new File(location);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			location += postSave.getId() + ".txt";
			File file = new File(location);
			if (!file.exists()) {
				file.createNewFile();
			}
			try (FileOutputStream fos = new FileOutputStream(location);
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					PrintWriter pw = new PrintWriter(osw);) {
				pw.println(content);
			}
			postSave.setEssayLocation(location);

			return pRepo.save(postSave);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @apiNote 找到一筆該id紀錄的那筆貼文資料
	 * 
	 * @param id 欲查詢的貼文id
	 * @return 成功回傳PostsBean，失敗回傳Null
	 * @author 鄭力豪
	 */
	public PostsBean findPostById(Integer id) {
		if (pRepo.existsById(id)) {
			PostsBean post = pRepo.findById(id).get();
			String location = post.getEssayLocation();

			StringBuilder content = new StringBuilder("");
			String line = null;
			try (FileInputStream fis = new FileInputStream(location);
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);) {
				while ((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			post.setContent(content.toString());
			return post;

		} else {
			return null;
		}
	}

	/**
	 * @apiNote 刪除一筆該id紀錄的那筆貼文資料
	 * 
	 * @param id 欲刪除的貼文id
	 * @return 成功回傳True，失敗回傳False
	 * @author 鄭力豪
	 */
	public boolean deletePost(Integer id) {
		if (pRepo.existsById(id)) {
			try {
				String filepath = pRepo.findById(id).get().getEssayLocation();
				File file = new File(filepath);
				file.delete();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

			pRepo.deleteById(id);
			System.out.println("刪除成功。");
			return true;
		}
		System.out.println("未找到該ID:" + id);
		return false;
	}

	/**
	 * @apiNote 修改一筆貼文
	 * 
	 * @param post 欲新建資訊的貼文實體
	 * @return 修改成功回傳貼文實體，失敗回傳 null
	 * @author 鄭力豪
	 */
	public PostsBean updatePost(PostsBean post) {
		Optional<PostsBean> optional = pRepo.findById(post.getId());
		if (optional.isPresent()) {
			PostsBean oldPost = optional.get();
			post.setAdded(oldPost.getAdded());
			try (FileOutputStream fos = new FileOutputStream(oldPost.getEssayLocation());
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					PrintWriter pw = new PrintWriter(osw);) {
				pw.println(post.getContent());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return pRepo.save(post);
		}
		return null;
	}

	/**
	 * @apiNote 得到所有貼文資料，依照貼文新增的初始時間排序
	 * 
	 * 
	 * @return 一個PostsBean型別的List集合物件，或者null
	 * @author 鄭力豪
	 */
	public List<PostsBean> getAllPosts1() {
		return pRepo.findPostsBeanByOrderByAddedDesc();
	}

	/**
	 * @apiNote 得到所有貼文資料，依照貼文最近一次的更新時間排序
	 * 
	 * 
	 * @return 一個PostsBean型別的List集合物件，或者null
	 * @author 鄭力豪
	 */
	public List<PostsBean> getAllPosts2() {
		return pRepo.findPostsBeanByOrderByFinalAddedDesc();
	}

	/**
	 * @apiNote 得到所有該活動相關的貼文資料，依照貼文最近一次的更新時間排序
	 * 
	 * 
	 * @return 一個PostsBean型別的List集合物件，或者null
	 * @author 鄭力豪
	 */
	public List<PostsBean> getPostsByCpttId(Integer id) {
		return pRepo.findPostsByCompetitionId(id);
	}

	/**
	 * @apiNote 刪除所有該活動相關的貼文資料
	 * 
	 * 
	 * @return
	 * @author 鄭力豪
	 */
	public void deletePostsByCpttId(Integer id) {
		try {
			pRepo.deletePostsByCompetitionId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @apiNote 模糊搜尋字串參數
	 * 
	 * 
	 * @param str 欲查詢的字串。
	 * @return 回傳PostsBean的List物件
	 * @author 鄭力豪
	 */
	public List<PostsBean> findPostsListByStringLike(String str) {
		return pRepo.findPostsBeanLike(str);
	}

	/**
	 * @param pageNumber 分頁頁數。
	 * @return 回傳Page物件，Page內容為多個PostsBean物件
	 * @author 鄭力豪
	 * @apiNote 將全部文章分頁
	 */
	public Page<PostsBean> getAllPostsByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.DESC, "added");

		Page<PostsBean> page = pRepo.findAll(pgb);

		return page;
	}

	/**
	 * @param pageNumber 分頁頁數。
	 * @param name       模糊搜尋的名稱。
	 * @return 回傳Page物件，Page內容為多個PostsBean物件
	 * @author 鄭力豪
	 * @apiNote 將模糊搜尋的文章分頁
	 */
	public Page<PostsBean> getPostsWithNameContainingByPage(Integer pageNumber, String name) {
		// 定義分頁規則
		Pageable pgb = PageRequest.of(pageNumber - 1, 10);
		// 將HQL排序完成的物件依照分頁規則實作
		Page<PostsBean> page = pRepo.findByNameContainingOrderByAddedDesc(name, pgb);

		return page;
	}

	/**
	 * 
	 * @param pageNumber 頁碼
	 * @param pageSize   頁容量
	 * @param postDto    傳送自訂物件
	 * @apiNote 搜尋玩家多條件搜尋的貼文
	 * @return 回傳Page物件，Page內容為多個PostsBean物件
	 * @author 鄭力豪
	 */
	public Page<PostsBean> getPostByPlayerIdByPage(Integer pageNumber, Integer pageSize, PostDto postDto) {
		Page<PostsBean> msgBlockByPage = pDao.getPostByPage(pageNumber, pageSize, postDto);
		return msgBlockByPage;
	}

}