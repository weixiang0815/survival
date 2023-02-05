package tw.survival.controller.Employee;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.service.Employee.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService empService;

	@GetMapping("/employeesmain.controller")
	public String showemp(Model m) {
		return "Employee/Employee";
	}

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestParam("id") Integer id, @RequestParam("title") String title,
			@RequestParam("Salary") Integer Salary, @RequestParam("hired_date") Date hired_date,
			@RequestParam("fk_workplace_id") Integer fk_workplace_id,
			@RequestParam("fk_supervisor_id") Integer fk_supervisor_id, Model model) {
		EmployeeBean bean = new EmployeeBean();
		empService.addEmployee(bean);
		return "Employee/addemployees ";
	}

	@PostMapping("/getEmplouee.controller")
	public String serchEmployee(Model m) {
		List<EmployeeBean> employee = empService.getAllemp();
		m.addAttribute("employee", employee);
		return "Employee/empallResult";
	}

}