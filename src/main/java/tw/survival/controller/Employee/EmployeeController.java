package tw.survival.controller.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.model.Employee.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	public EmployeeService empService; 
	
	@PostMapping("/getEmplouee")
	public String serchEmployee(Model m) {
		List<EmployeeBean> employee=empService.getAllemp();
		m.addAttribute("employee",employee);
		return "Employee/empallResult";
	}
}
