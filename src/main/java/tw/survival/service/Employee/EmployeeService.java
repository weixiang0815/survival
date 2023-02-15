package tw.survival.service.Employee;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.model.Employee.EmployeeDao;
import tw.survival.model.Employee.EmployeeReposity;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	public EmployeeReposity empDAO;
	/**
	 * 查詢所有使用者資料
	 * 
	 * @return 回傳裝著所有 EmployeeBean 的列表
	 */
	public List<EmployeeBean> getAllemp() {
		return empDAO.findAll();
	}
	public void addEmployee(EmployeeBean employee) {
		
		 empDAO.save(employee);
	}
	
}
