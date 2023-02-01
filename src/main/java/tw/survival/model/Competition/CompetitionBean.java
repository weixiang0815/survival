package tw.survival.model.Competition;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "competition")
@Component
public class CompetitionBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name_mandarin")
	private String name_mandarin;

	@Column(name = "name_english")
	private String name_english;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date，這行不用寫
	@Column(name = "held_datetime")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date held_datetime;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date，這行不用寫
	@Column(name = "announced_datetime")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date announced_datetime;

//	private Integer fk_site_id;

	@Column(name = "content")
	private String content;

	@Column(name = "rules")
	private String rules;

	@Column(name = "budget")
	private Integer budget;

	@Column(name = "fee")
	private Integer fee;

//	private Integer fk_prize_id;

	@Column(name = "single_or_crew")
	private Character single_or_crew;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "participation")
	private Integer participation;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "competition", cascade = CascadeType.ALL)
	private Set<SignUpBean> signUps = new LinkedHashSet<>();

	@PrePersist
	public void onCreate() {
		if (announced_datetime == null) {
			announced_datetime = new Date();
		}
	}

	public CompetitionBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_mandarin() {
		return name_mandarin;
	}

	public void setName_mandarin(String name_mandarin) {
		this.name_mandarin = name_mandarin;
	}

	public String getName_english() {
		return name_english;
	}

	public void setName_english(String name_english) {
		this.name_english = name_english;
	}

	public Date getHeld_datetime() {
		return held_datetime;
	}

	public void setHeld_datetime(Date held_datetime) {
		this.held_datetime = held_datetime;
	}

	public Date getAnnounced_datetime() {
		return announced_datetime;
	}

	public void setAnnounced_datetime(Date announced_datetime) {
		this.announced_datetime = announced_datetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Character getSingle_or_crew() {
		return single_or_crew;
	}

	public void setSingle_or_crew(Character single_or_crew) {
		this.single_or_crew = single_or_crew;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getParticipation() {
		return participation;
	}

	public void setParticipation(Integer participation) {
		this.participation = participation;
	}

	public Set<SignUpBean> getSignUps() {
		return signUps;
	}

	public void setSignUps(Set<SignUpBean> signUps) {
		this.signUps = signUps;
	}

}