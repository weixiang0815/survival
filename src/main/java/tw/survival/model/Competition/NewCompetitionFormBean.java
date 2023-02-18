package tw.survival.model.Competition;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "New_Competition_Form")
public class NewCompetitionFormBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "fk_player_id")
	@Transient
	private Integer playerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_player_id")
	private PlayerBean player;

	@Column(name = "fk_employee_id")
	@Transient
	private Integer employeeId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_employee_id")
	private EmployeeBean employee;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name = "last_edited")
	private Date lastEdited;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "newCompetitionForm")
	private NewCompetitionFormPart1Bean firstPart;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "newCompetitionForm")
	private NewCompetitionFormPart2Bean secondPart;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "newCompetitionForm")
	private NewCompetitionFormPart3Bean thirdPart;

	@PrePersist
	void onCreate() {
		this.lastEdited = new Date();
	}

	public NewCompetitionFormBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public PlayerBean getPlayer() {
		return player;
	}

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public Date getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}

	public NewCompetitionFormPart1Bean getFirstPart() {
		return firstPart;
	}

	public void setFirstPart(NewCompetitionFormPart1Bean firstPart) {
		this.firstPart = firstPart;
	}

	public NewCompetitionFormPart2Bean getSecondPart() {
		return secondPart;
	}

	public void setSecondPart(NewCompetitionFormPart2Bean secondPart) {
		this.secondPart = secondPart;
	}

	public NewCompetitionFormPart3Bean getThirdPart() {
		return thirdPart;
	}

	public void setThirdPart(NewCompetitionFormPart3Bean thirdPart) {
		this.thirdPart = thirdPart;
	}

}