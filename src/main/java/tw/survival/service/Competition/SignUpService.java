package tw.survival.service.Competition;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.SignUpBean;
import tw.survival.model.Competition.SignUpRepository;

@Service
@Transactional
public class SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;

	/**
	 * 新增一筆報名紀錄
	 * 
	 * @param signup 欲新增紀錄的報名紀錄實體
	 * @return 新增成功回傳該報名紀錄實體，失敗回傳 null
	 * @author 王威翔
	 */
	public SignUpBean insert(SignUpBean signup) {
		try {
			return signUpRepository.save(signup);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 透過 id 查詢報名紀錄
	 * 
	 * @param id 欲查詢紀錄的報名紀錄實體 id
	 * @return 查詢成功回傳該報名紀錄實體，查無資料回傳 null
	 * @author 王威翔
	 */
	public SignUpBean findById(Integer id) {
		Optional<SignUpBean> optional = signUpRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 查詢至今所有報名紀錄
	 * 
	 * @return 回傳裝有所有報名紀錄實體的 List 物件
	 * @author 王威翔
	 */
	public List<SignUpBean> findAll() {
		return signUpRepository.findAll();
	}

	/**
	 * 透過 id 刪除一筆報名紀錄
	 * 
	 * @param id 欲刪除紀錄的報名紀錄實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			signUpRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一筆活動報名紀錄
	 * 
	 * @param signup 欲刪除的活動報名紀錄實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteByEntity(SignUpBean signup) {
		try {
			signUpRepository.delete(signup);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新一筆報名紀錄
	 * 
	 * @param signup 欲更新內容的報名紀錄實體
	 * @return 更新成功回傳該報名紀錄實體，失敗回傳 null
	 */
	public SignUpBean updateByEntity(SignUpBean signup) {
		if (signUpRepository.findById(signup.getId()).isPresent()) {
			try {
				signUpRepository.save(signup);
				return signup;
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

}