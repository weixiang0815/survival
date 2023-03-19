package tw.survival.controller.Employee;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.sql.Blob;

import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.service.Employee.EmployeeService;

@Controller
@SessionAttributes({ "employee" })
public class EmployeeController {

	@Autowired
	public EmployeeService empService;

//C
	@GetMapping("/Employee/add")
	public String addemployee(Model m) {
		m.addAttribute("Employee", new EmployeeBean());
		return "back/Employee/addemployees";
	}

	@ResponseBody
	@GetMapping("/Employee/get/{id}")
	public EmployeeBean getEmployeeById(@PathVariable Integer id) {
		return empService.employeeFindById(id);
	}

	// R
	@GetMapping("/Employee/list")
	public String list(Model model) {
		List<EmployeeBean> list = empService.getAllemp();
		model.addAttribute("Employee", list);
		return "back/Employee/empallResult";
	}

	// U
	@GetMapping("/Employee/update")
	public String updateEmployee(@RequestParam("id") Integer id, Model model) {
		EmployeeBean bean = empService.employeeFindById(id);
		model.addAttribute("Employee", bean);
		return "back/Employee/UpdateEmployee";

	}

	@PutMapping("/Employee/update1")
	public String updateById(@ModelAttribute EmployeeBean employee) {
		MultipartFile employeeImage = employee.getEmployeeImage();
		if (employeeImage != null && !employeeImage.isEmpty()) {
			try {
				byte[] img = employeeImage.getBytes();
				Blob blob = new SerialBlob(img);
				employee.setThumbnail(blob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		empService.update(employee);
		return "redirect:/Employee/list";
	}

	@PostMapping("/Employee/addEmployee")
	public String postEmployee(@ModelAttribute EmployeeBean employee, Model model) {
		MultipartFile employeeImage = employee.getEmployeeImage();
		if (employeeImage != null && !employeeImage.isEmpty()) {
			System.out.println(employeeImage.getOriginalFilename());
			try {
				byte[] img = employeeImage.getBytes();
				Blob blob = new SerialBlob(img);
				employee.setThumbnail(blob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		empService.addEmployee(employee);
		return "redirect:/Employee/list ";
	}

	@DeleteMapping("Employee/delete")
	public String deleteEmployeeById(@RequestParam("id") Integer id) {
		empService.delete(id);
		return "redirect:/Employee/list";

	}

	// GetPhoto
	@ResponseBody
	@GetMapping("/Employee/photo/{id}")
	public ResponseEntity<byte[]> getPhotobyId(@PathVariable Integer id) {
		EmployeeBean employee = empService.employeeFindById(id);
		byte[] photofile = null;
		ResponseEntity<byte[]> re = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		Blob blob = employee.getThumbnail();
		if (blob != null) {
			photofile = blobToByteArray(blob);
		}
		re = new ResponseEntity<byte[]>(photofile, headers, HttpStatus.OK);
		return re;
	}

	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}