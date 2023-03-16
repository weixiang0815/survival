package tw.survival.model.Forum;

import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class MsgBlockDao {

	public Page<MsgBlockDto> getMsgBlockByPage(int pageNumber, int pageSize, List<MsgBlockDto> msgBlockList) {
        // 取得msgBlockList總筆數
        int totalElements = msgBlockList.size();
        // 接收資料頁 以及 回傳第 pageNumber 頁的資料
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalElements);
        // 建立分頁結果  判斷拿到的頁數有沒有滿足10個資料，沒有的話已拿到的資料數為準
        List<MsgBlockDto> pageContent = msgBlockList.subList(fromIndex, toIndex);
        
    	Page<MsgBlockDto> page = new PageImpl<>(pageContent, PageRequest.of(pageNumber-1, pageSize), totalElements);
    	return page;
    }
	
}
