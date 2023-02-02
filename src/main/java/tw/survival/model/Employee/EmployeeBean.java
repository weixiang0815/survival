package tw.survival.model.Employee;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Employee")
@Component
public class EmployeeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "hired_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date hired_date;

	@Column(name = "Salary")
	private Integer salary;

	@Column(name = "fk_workplace_id")
	private Integer fk_workplace_id;

	@Column(name = "fk_supervisor_id")
	private Integer fk_supervisor_id;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "")
//	private UserBean user;

	public EmployeeBean() {
	}

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
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
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

}