package tw.survival.model.Employee;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import tw.survival.model.User.UserBean;

@Entity
@Table(name = "Employee")
@Component
public class EmployeeBean{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="hired_date")
	private Date hired_date;
	@Column(name="Salary")
	private Integer Salary;
	@Column(name="fk_workplace_id")
	private Integer fk_workplace_id;
	@Column(name="fk_supervisor_id")
	private Integer fk_supervisor_id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_UserBean_id")
	private UserBean user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getHired_date() {
		return hired_date;
	}
	public void setHired_date(Date hired_date) {
		this.hired_date = hired_date;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer salary) {
		Salary = salary;
	}
	public Integer getFk_workplace_id() {
		return fk_workplace_id;
	}
	public void setFk_workplace_id(Integer fk_workplace_id) {
		this.fk_workplace_id = fk_workplace_id;
	}
	public Integer getFk_supervisor_id() {
		return fk_supervisor_id;
	}
	public void setFk_supervisor_id(Integer fk_supervisor_id) {
		this.fk_supervisor_id = fk_supervisor_id;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
}
