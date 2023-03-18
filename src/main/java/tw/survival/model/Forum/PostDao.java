package tw.survival.model.Forum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PostDao {

	@PersistenceContext
	private EntityManager em;

	public Page<PostsBean> getPostByPage(int pageNumber, int pageSize, PostDto postDto) {
		List<PostsBean> list = search(postDto);
		// 取得msgBlockList總筆數
		int totalElements = list.size();
		// 接收資料頁 以及 回傳第 pageNumber 頁的資料
		int fromIndex = (pageNumber - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, totalElements);
		// 建立分頁結果 判斷拿到的頁數有沒有滿足10個資料，沒有的話已拿到的資料數為準
		List<PostsBean> pageContent = list.subList(fromIndex, toIndex);

		Page<PostsBean> page = new PageImpl<>(pageContent, PageRequest.of(pageNumber - 1, pageSize), totalElements);
		return page;
	}

	@SuppressWarnings("unchecked")
	private List<PostsBean> search(PostDto postDto) {
		TypedQuery<PostsBean> query = (TypedQuery<PostsBean>) em.createNativeQuery(SQLtext(postDto), PostsBean.class);
		return query.getResultList();
	}

	private String SQLtext(PostDto postDto) {

		List<String> classify = postDto.getClassify();
		String name = postDto.getName();
		List<Integer> date = postDto.getDate();
		Integer playerId = postDto.getPlayerId();

		boolean flag1 = classify != null && classify.size() != 0;
		boolean flag2 = name != null && name.length() != 0;
		boolean flag3 = date != null && date.size() != 0;
		boolean flag4 = playerId != null && playerId > 0;

		StringBuilder SQL = new StringBuilder("select * from posts where ");
		if (flag1) {
			SQL.append("( classify in ( ");
			for (int i = 0; i < classify.size(); i++) {
				SQL.append("'" + classify.get(i) + "'");
				SQL.append(i == classify.size() - 1 ? " ) ) " : ", ");
			}
		}
		if (flag2) {
			if (flag1) {
				SQL.append("and ");
			}
			SQL.append("( name like '%" + name + "%' ) ");
		}
		if (flag3) {
			if (flag1 || flag2) {
				SQL.append(" and ");
			}
			SQL.append(" ( ");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String today = formatter.format(new Date());
			for (int i = 0; i < date.size(); i++) {
				switch (date.get(i)) {
				case 0:
					SQL.append("( added < '" + today + "' ) ");
					break;
				case 1:
					SQL.append("( added > '" + today + "' ) ");
					break;
				}
				SQL.append(i == date.size() - 1 ? ") " : "or ");
			}
		}
		if (flag4) {
			if (flag1 || flag2 || flag3) {
				SQL.append(" and ");
			}
			SQL.append("( fk_player_id = " + playerId + " ) ");
		}
		if (!flag1 && !flag2 && !flag3 && !flag4) {
			SQL.append(" 1 = 1 ");
		}

		return SQL.toString();
	}

}
