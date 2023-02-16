package tw.survival.controller.Employee;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.service.Employee.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService empService;
//C
	@GetMapping("/Employee/add")
	public String addemployee() {
		return "Employee/addemployees";
	}
	//R
	@GetMapping("/Employee/list")
	public String list(Model model) {
		List<EmployeeBean> list=empService.getAllemp();
		model.addAttribute("Employee",list);
		return "Employee/empallResult";
	}
	//U
	@GetMapping("/Employee/update")
	public String updateEmployee(@RequestParam("id")Integer id,Model model) {
		EmployeeBean bean=empService.employeeFindById(id);
		model.addAttribute("Employee",bean);
		return"Employee/UpdateEmployee";
		
	}
	@PutMapping("/Employee/update1")
	public String updateById(@ModelAttribute("Employee")EmployeeBean employee) {
		empService.update(employee);
		return"redirect:/Employee/list";
	}

	
	@PostMapping("/Employee/addEmployee")
	public String postEmployee( @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("age") Integer age,
			@RequestParam("region") String region, @RequestParam("title") String title,
			@RequestParam("address") String address, @RequestParam("salary") Integer salary,
			@RequestParam("hired_date") Date hired_date, @RequestParam("thumbnail") MultipartFile thumbnail,
			@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("birthday") Date birthday,
			@RequestParam("identity") String identity_number,
			@RequestParam("email") String email, Model model) {
		try {
			EmployeeBean employee = new EmployeeBean();
			employee.setName(name);
			employee.setAccount(account);
			employee.setPassword(password);	
			employee.setIdentity_number(identity_number);
			employee.setEmail(email);
			employee.setAge(age);
			employee.setRegion(region);
			employee.setAddress(address);
			employee.setSalary(salary);
			employee.setHired_date(hired_date);
			employee.setStatus("在職中");
			employee.setTitle(title);
			employee.setThumbnail(thumbnail.getBytes());
			employee.setSex(sex);
			employee.setBirthday(birthday);
			empService.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/Employee/list ";
	}
	@DeleteMapping("Employee/delete")
	public String deleteEmployeeById(@RequestParam("id") Integer id) {
		empService.delete(id);
		return"redirect:/Employee/list";
		
	}
	//GetPhoto
			@GetMapping("/Employee/photo")
			public ResponseEntity<byte[]> getPhotobyId(@RequestParam Integer id){
				EmployeeBean employee=empService.employeeFindById(id);
				byte[] photofile = employee.getThumbnail();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.IMAGE_JPEG);
				return new ResponseEntity<byte[]>(photofile, headers, HttpStatus.OK);
			}

}