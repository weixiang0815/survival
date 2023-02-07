package tw.survival.model.Employee;


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Employee")
public class EmployeeBean {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="account")
	private String account;
	@Column(name="password")
	private String password;
	@Column(name="age")
	private Integer age;
	@Column(name="region")
	private String region;
	@Column(name="address")
	private String address;
	@Column(name="salary")
	private Integer salary;
	@Column(name="thumbnail")
	@Lob
	private byte[] thumbnail;
	@Column(name="sex")
	private String sex;
	@Column(name="birthday")
	private Date birthday;
	@Column(name="title")
	private String title;
	@Column(name="hire_date")
	private Date hire_date;
	@Column(name="status")
	private String status;
	@JoinColumn(name="fk_boss_id")
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "Employee",cascade = CascadeType.ALL)
	private Set<EmployeeBean> employee=new LinkedHashSet<EmployeeBean>();
}
