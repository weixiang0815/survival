package tw.survival.model.Forum;

import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class MsgBlockDao {

	public Page<MsgBlockDto> getMsgBlockByPage(int pageNumber, int pageSize, List<MsgBlockDto> msgBlockList) {
        // 假設總筆數是 msgsList.size()
        int totalElements = msgBlockList.size();
        // 假設要回傳第 pageNumber 頁的資料
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalElements);
        // 建立分頁結果
        List<MsgBlockDto> pageContent = msgBlockList.subList(fromIndex, toIndex);
        Page<MsgBlockDto> page = new PageImpl<>(pageContent, PageRequest.of(pageNumber, pageSize), totalElements);
        return page;
    }
	
}
