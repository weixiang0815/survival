package tw.survival.controller.Employee;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.model.Employee.EmployeeReposity;
import tw.survival.service.Employee.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService empService;
	@Autowired
	public EmployeeReposity empReposity;

	@GetMapping("/Employee/add")
	public String addemployee() {
		return "Employee/addemployees";
	}
	@GetMapping("/Employee/list")
	public String list(Model model) {
		List<EmployeeBean> list=empReposity.findAll();
		model.addAttribute("Employee",list);
		return "Employee/empallResult";
	}

	@ResponseBody
	@PostMapping("/Employee/addEmployee")
	public String postEmployee(@RequestParam("id") Integer id, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("age") Integer age,
			@RequestParam("region") String region, @RequestParam("title") String title,
			@RequestParam("address") String address, @RequestParam("salary") Integer salary,
			@RequestParam("hired_date") Date hired_date, @RequestParam("thumbnail") MultipartFile thumbnail,
			@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("birthday") Date birthday,
			@RequestParam("status") String status, @RequestParam("identity") String identity_number,
			@RequestParam("email") String email, Model model) {
		try {
			EmployeeBean employee = new EmployeeBean();
			employee.setId(id);
			employee.setName(name);
			employee.setAccount(account);
			employee.setPassword(password);	
			employee.setIdentity_number(identity_number);
			employee.setEmail(email);
			employee.setAge(age);
			employee.setRegion(region);
			employee.setAddress(address);
			employee.setSalary(salary);
			employee.setHire_date(hired_date);
			employee.setStatus("在職中");
			employee.setTitle(title);
//			 employee.setThumbnail();
			employee.setSex(sex);
			employee.setBirthday(birthday);
			empService.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Employee/addemployees ";
	}

}