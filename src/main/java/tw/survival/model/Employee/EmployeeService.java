package tw.survival.model.Employee;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	public EmployeeDao empdao;
	/**
	 * 查詢所有使用者資料
	 * 
	 * @return 回傳裝著所有 EmployeeBean 的列表
	 */
	public List<EmployeeBean> getAllemp() {
		return empdao.findAllemp();
	}
	public EmployeeBean addEmployee(EmployeeBean employee) {
		
		return empdao.addemp(employee);
	}
}
