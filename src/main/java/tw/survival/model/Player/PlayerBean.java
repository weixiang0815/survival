package tw.survival.model.Player;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import tw.survival.model.Crew.CrewBean;
import tw.survival.model.Crew.CrewPermission;

@Entity
@Table(name = "Player")
public class PlayerBean {
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

	@Column(name = "join_date")
	private Date join_date;

	@Column(name = "cellphone")
	private String phone;

	@Column(name = "banned")
	private String banned;

	@Column(name = "banned_reason")
	private String banned_reason;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_crew_id")
	private CrewBean crew;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "fk_player_permission")
	// private List<CrewPermission> cPmission = new ArrayList<>();

	public PlayerBean() {

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

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBanned() {
		return banned;
	}

	public void setBanned(String banned) {
		this.banned = banned;
	}

	public String getBanned_reason() {
		return banned_reason;
	}

	public void setBanned_reason(String banned_reason) {
		this.banned_reason = banned_reason;
	}

	public CrewBean getCrew() {
		return crew;
	}

	public void setCrew(CrewBean crew) {
		this.crew = crew;
	}

	// public List<CrewPermission> getcPmission() {
	// 	return cPmission;
	// }

	// public void setcPmission(List<CrewPermission> cPmission) {
	// 	this.cPmission = cPmission;
	// }

}
