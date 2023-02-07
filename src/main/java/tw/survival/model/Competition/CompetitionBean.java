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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tw.survival.model.Forum.PostBean;
import tw.survival.model.Place.PlaceBean;
import tw.survival.model.User.UserBean;

@Entity
@Table(name = "Competition")
public class CompetitionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name_mandarin")
	private String mandarinName;

	@Column(name = "name_english")
	private String englishName;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "start_timespan")
	private String startTimespan;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "end_timespan")
	private String endTimespan;

	@Column(name = "announced_datetime")
	private Date announcedDatetime;

	@Column(name = "fk_place_id")
	@Transient
	private Integer placeId;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_place_id")
	private PlaceBean place;

	@Column(name = "content")
	private String content;

	@Column(name = "rules")
	private String rules;

	@Column(name = "budget")
	private Integer budget;

	@Column(name = "fee")
	private Integer fee;

	@Column(name = "single_or_crew")
	private Character singleOrCrew;

	@Column(name = "capacity")
	private Integer capacity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_post_id")
	private PostBean post;

	@OneToOne(mappedBy = "competitionId")
	private CompetitionPrizeBean competitionPrizes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "competition", cascade = CascadeType.ALL)
	private Set<SignUpBean> signUps = new LinkedHashSet<SignUpBean>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Participation", inverseJoinColumns = {
			@JoinColumn(name = "fk_player_id", referencedColumnName = "id") }, joinColumns = {
					@JoinColumn(name = "fk_competition_id", referencedColumnName = "id") })
	private Set<UserBean> participantPlayers = new LinkedHashSet<UserBean>();

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "Participation", inverseJoinColumns = {
//			@JoinColumn(name = "fk_crew_id", referencedColumnName = "id") }, joinColumns = {
//					@JoinColumn(name = "fk_competition_id", referencedColumnName = "id") })
//	private Set<UserBean> participantCrews = new LinkedHashSet<UserBean>();

	public CompetitionBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMandarinName() {
		return mandarinName;
	}

	public void setMandarinName(String mandarinName) {
		this.mandarinName = mandarinName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartTimespan() {
		return startTimespan;
	}

	public void setStartTimespan(String startTimespan) {
		this.startTimespan = startTimespan;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEndTimespan() {
		return endTimespan;
	}

	public void setEndTimespan(String endTimespan) {
		this.endTimespan = endTimespan;
	}

	public Date getAnnouncedDatetime() {
		return announcedDatetime;
	}

	public void setAnnouncedDatetime(Date announcedDatetime) {
		this.announcedDatetime = announcedDatetime;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
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

	public Character getSingleOrCrew() {
		return singleOrCrew;
	}

	public void setSingleOrCrew(Character singleOrCrew) {
		this.singleOrCrew = singleOrCrew;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public PostBean getPost() {
		return post;
	}

	public void setPost(PostBean post) {
		this.post = post;
	}

	public CompetitionPrizeBean getCompetitionPrizes() {
		return competitionPrizes;
	}

	public void setCompetitionPrizes(CompetitionPrizeBean competitionPrizes) {
		this.competitionPrizes = competitionPrizes;
	}

	public Set<SignUpBean> getSignUps() {
		return signUps;
	}

	public void setSignUps(Set<SignUpBean> signUps) {
		this.signUps = signUps;
	}

	public Set<UserBean> getParticipantPlayers() {
		return participantPlayers;
	}

	public void setParticipantPlayers(Set<UserBean> participantPlayers) {
		this.participantPlayers = participantPlayers;
	}

}