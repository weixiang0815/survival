package tw.survival.service.Competition;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionPictureBean;
import tw.survival.model.Competition.CompetitionPictureRepository;

@Service
@Transactional
public class CompetitionPictureService {

	@Autowired
	private CompetitionPictureRepository compPictureDao;

	/**
	 * 新建一張活動照片
	 * 
	 * @param compPicture 欲新增的活動照片實體
	 * @return 新增成功回傳該活動照片實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPictureBean addPicture(CompetitionPictureBean compPicture) {
		try {
			byte[] picture = compPicture.getPicture();
			Integer compId = compPicture.getCompetition().getId();
			String contentType = compPicture.getContentType();
			String filepath = "C:/Survival/Competition/Competition/images/comp_" + compId + "/";
			File file = new File(filepath);
			if (!file.exists()) {
				file.mkdirs();
			}
			compPicture = compPictureDao.save(compPicture);
			Integer id = compPicture.getId();
			filepath += "image_" + id + "." + contentType;
			try (FileOutputStream fos = new FileOutputStream(filepath);
					BufferedOutputStream bos = new BufferedOutputStream(fos);) {
				bos.write(picture);
			}
			compPicture.setFileLocation(filepath);
			return compPicture;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 透過 id 查詢一筆活動照片實體
	 * 
	 * @param id 欲查詢的活動照片實體 id
	 * @return 查詢成功回傳該活動照片實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPictureBean findById(Integer id) {
		Optional<CompetitionPictureBean> optional = compPictureDao.findById(id);
		if (optional.isPresent()) {
			CompetitionPictureBean compPicture = optional.get();
			try (FileInputStream fis = new FileInputStream(compPicture.getFileLocation());
					BufferedInputStream bis = new BufferedInputStream(fis);) {
				compPicture.setPicture(bis.readAllBytes());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return compPicture;
		}
		return null;
	}

	/**
	 * 查詢至今所有活動照片實體
	 * 
	 * @return 回傳裝著所有活動照片實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionPictureBean> findAll() {
		List<CompetitionPictureBean> compPictures = compPictureDao.findAll();
		compPictures.forEach(compPicture -> {
			try (FileInputStream fis = new FileInputStream(compPicture.getFileLocation());
					BufferedInputStream bis = new BufferedInputStream(fis);) {
				compPicture.setPicture(bis.readAllBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return compPictures;
	}

	/**
	 * 透過 id 刪除一張活動照片
	 * 
	 * @param id 欲刪除的活動照片實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deletePictureById(Integer id) {
		try {
			String filepath = compPictureDao.findById(id).get().getFileLocation();
			File file = new File(filepath);
			file.delete();
			compPictureDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一張活動照片
	 * 
	 * @param compPicture 欲刪除的活動照片實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deletePictureByEntity(CompetitionPictureBean compPicture) {
		try {
			String filepath = compPicture.getFileLocation();
			File file = new File(filepath);
			file.delete();
			compPictureDao.delete(compPicture);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新一筆活動照片實體
	 * 
	 * @param compPicture 欲更新的活動照片實體
	 * @return 更新成功回傳該活動照片實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPictureBean updateByEntity(CompetitionPictureBean compPicture) {
		Optional<CompetitionPictureBean> optional = compPictureDao.findById(compPicture.getId());
		if (optional.isPresent()) {
			byte[] newPic = compPicture.getPicture();
			byte[] oldPic;
			CompetitionPictureBean oldCompPicture = optional.get();
			try (
					FileInputStream fis = new FileInputStream(oldCompPicture.getFileLocation());
					BufferedInputStream bis = new BufferedInputStream(fis);
					) {
				oldPic = bis.readAllBytes();
				oldCompPicture.setPicture(oldPic);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			if (!Arrays.equals(newPic, oldPic)) {
				String filepath = compPicture.getFileLocation();
				File file = new File(filepath);
				file.delete();
				filepath = filepath.substring(0, filepath.lastIndexOf("/") + 1);
				filepath += "image_" + compPicture.getId() + "." + compPicture.getContentType();
				try (
						FileOutputStream fos = new FileOutputStream(filepath);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						) {
					bos.write(newPic);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				compPicture.setFileLocation(filepath);
			}
			return compPictureDao.save(compPicture);
		}
		return null;
	}

}