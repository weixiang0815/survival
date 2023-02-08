package tw.survival.model.Employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import tw.survival.model.Place.PlaceBean;

@Entity
@Table(name = "Employee")
public class EmployeeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "salary")
	private Integer salary;
	
	@Column(name = "thumbnail")
	@Lob
	private byte[] thumbnail;
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "hire_date")
	private Date hire_date;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "identity_number")
	private String identity_number;

	@Column(name = "email")
	private String email;

	@JoinColumn(name = "fk_workplace_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private PlaceBean place;

	@JoinColumn(name = "fk_permission")
	@ManyToOne(fetch = FetchType.EAGER)
	private EmployeePermission employeePermission;

	public EmployeeBean() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
	}

	public EmployeePermission getEmployeePermission() {
		return employeePermission;
	}

	public void setEmployeePermission(EmployeePermission employeePermission) {
		this.employeePermission = employeePermission;
	}

	public String getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
