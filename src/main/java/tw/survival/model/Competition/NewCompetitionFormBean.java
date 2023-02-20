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

@Entity
@Table(name = "New_Competition_Form")
public class NewCompetitionFormBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "creator_id")
	private Integer creatorId;

	@Column(name = "creator_type")
	private Integer creatorType;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name = "last_edited")
	private Date lastEdited;

	@Column(name = "fk_part1_id")
	@Transient
	private Integer fkPart1Id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_part1_id")
	private NewCompetitionFormPart1Bean firstPart;

	@Column(name = "fk_part2_id")
	@Transient
	private Integer fkPart2Id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_part2_id")
	private NewCompetitionFormPart2Bean secondPart;

	@Column(name = "fk_part3_id")
	@Transient
	private Integer fkPart3Id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_part3_id")
	private NewCompetitionFormPart3Bean thirdPart;

	@PrePersist
	void onCreate() {
		if (lastEdited == null) {
			lastEdited = new Date();
		}
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

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getCreatorType() {
		return creatorType;
	}

	public void setCreatorType(Integer creatorType) {
		this.creatorType = creatorType;
	}

	public Date getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}

	public Integer getFkPart1Id() {
		return fkPart1Id;
	}

	public void setFkPart1Id(Integer fkPart1Id) {
		this.fkPart1Id = fkPart1Id;
	}

	public NewCompetitionFormPart1Bean getFirstPart() {
		return firstPart;
	}

	public void setFirstPart(NewCompetitionFormPart1Bean firstPart) {
		this.firstPart = firstPart;
		this.fkPart1Id = firstPart.getId();
	}

	public Integer getFkPart2Id() {
		return fkPart2Id;
	}

	public void setFkPart2Id(Integer fkPart2Id) {
		this.fkPart2Id = fkPart2Id;
	}

	public NewCompetitionFormPart2Bean getSecondPart() {
		return secondPart;
	}

	public void setSecondPart(NewCompetitionFormPart2Bean secondPart) {
		this.secondPart = secondPart;
		this.fkPart2Id = secondPart.getId();
	}

	public Integer getFkPart3Id() {
		return fkPart3Id;
	}

	public void setFkPart3Id(Integer fkPart3Id) {
		this.fkPart3Id = fkPart3Id;
	}

	public NewCompetitionFormPart3Bean getThirdPart() {
		return thirdPart;
	}

	public void setThirdPart(NewCompetitionFormPart3Bean thirdPart) {
		this.thirdPart = thirdPart;
		this.fkPart3Id = thirdPart.getId();
	}

}