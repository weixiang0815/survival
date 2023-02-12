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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import tw.survival.model.Crew.CrewBean;
import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Place.PlaceBean;
import tw.survival.model.Player.PlayerBean;

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

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "start_timespan")
	private String startTimespan;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "end_timespan")
	private String endTimespan;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name = "announced_datetime")
	private Date announcedDatetime;

	@ManyToOne(fetch = FetchType.EAGER)
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

	@Column(name = "status")
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_post_id")
	private PostsBean post;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "competitionId")
	private CompetitionPrizeBean competitionPrizes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "competition", cascade = CascadeType.ALL)
	private Set<SignUpBean> signUps = new LinkedHashSet<SignUpBean>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "competition", cascade = CascadeType.ALL)
	private Set<CompetitionPictureBean> pictures = new LinkedHashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Participation", inverseJoinColumns = {
			@JoinColumn(name = "fk_player_id", referencedColumnName = "id") }, joinColumns = {
					@JoinColumn(name = "fk_competition_id", referencedColumnName = "id") })
	private Set<PlayerBean> participantPlayers = new LinkedHashSet<PlayerBean>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Participation", inverseJoinColumns = {
			@JoinColumn(name = "fk_crew_id", referencedColumnName = "id") }, joinColumns = {
					@JoinColumn(name = "fk_competition_id", referencedColumnName = "id") })
	private Set<CrewBean> participantCrews = new LinkedHashSet<CrewBean>();

	@PrePersist
	public void onCreate() {
		if (announcedDatetime == null) {
			announcedDatetime = new Date();
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

	public PostsBean getPost() {
		return post;
	}

	public void setPost(PostsBean post) {
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

	public Set<PlayerBean> getParticipantPlayers() {
		return participantPlayers;
	}

	public Set<CompetitionPictureBean> getPictures() {
		return pictures;
	}

	public void setPictures(Set<CompetitionPictureBean> pictures) {
		this.pictures = pictures;
	}

	public void setParticipantPlayers(Set<PlayerBean> participantPlayers) {
		this.participantPlayers = participantPlayers;
	}

	public Set<CrewBean> getParticipantCrews() {
		return participantCrews;
	}

	public void setParticipantCrews(Set<CrewBean> participantCrews) {
		this.participantCrews = participantCrews;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}