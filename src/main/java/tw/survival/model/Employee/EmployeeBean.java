package tw.survival.model.Employee;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

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
}
