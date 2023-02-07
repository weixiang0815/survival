package tw.survival.model.Competition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tw.survival.model.Market.ProductBean;

@Entity
@Table(name = "Competition_Prize")
public class CompetitionPrizeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne(mappedBy = "competitionPrizes")
	private CompetitionBean competition;

	@Column(name = "fk_1ts_prize_id")
	@Transient
	private Integer firstPrizeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_1ts_prize_id")
	private ProductBean firstPrize;

	@Column(name = "fk_2nd_prize_id")
	@Transient
	private Integer secondPrizeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_2nd_prize_id")
	private ProductBean secondPrize;

	@Column(name = "fk_3rd_prize_id")
	@Transient
	private Integer thirdPrizeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_3rd_prize_id")
	private ProductBean thirdPrize;

	@Column(name = "fk_single_prize_id")
	@Transient
	private Integer singlePrizeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_single_prize_id")
	private ProductBean singlePrize;

	@Column(name = "fk_crew_prize_id")
	@Transient
	private Integer crewPrizeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_crew_prize_id")
	private ProductBean crewPrize;

	@Column(name = "fk_comfort_prize_id")
	@Transient
	private Integer comfortPrizeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_comfort_prize_id")
	private ProductBean comfortPrize;

	public CompetitionPrizeBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

	public Integer getFirstPrizeId() {
		return firstPrizeId;
	}

	public void setFirstPrizeId(Integer firstPrizeId) {
		this.firstPrizeId = firstPrizeId;
	}

	public ProductBean getFirstPrize() {
		return firstPrize;
	}

	public void setFirstPrize(ProductBean firstPrize) {
		this.firstPrize = firstPrize;
	}

	public Integer getSecondPrizeId() {
		return secondPrizeId;
	}

	public void setSecondPrizeId(Integer secondPrizeId) {
		this.secondPrizeId = secondPrizeId;
	}

	public ProductBean getSecondPrize() {
		return secondPrize;
	}

	public void setSecondPrize(ProductBean secondPrize) {
		this.secondPrize = secondPrize;
	}

	public Integer getThirdPrizeId() {
		return thirdPrizeId;
	}

	public void setThirdPrizeId(Integer thirdPrizeId) {
		this.thirdPrizeId = thirdPrizeId;
	}

	public ProductBean getThirdPrize() {
		return thirdPrize;
	}

	public void setThirdPrize(ProductBean thirdPrize) {
		this.thirdPrize = thirdPrize;
	}

	public Integer getSinglePrizeId() {
		return singlePrizeId;
	}

	public void setSinglePrizeId(Integer singlePrizeId) {
		this.singlePrizeId = singlePrizeId;
	}

	public ProductBean getSinglePrize() {
		return singlePrize;
	}

	public void setSinglePrize(ProductBean singlePrize) {
		this.singlePrize = singlePrize;
	}

	public Integer getCrewPrizeId() {
		return crewPrizeId;
	}

	public void setCrewPrizeId(Integer crewPrizeId) {
		this.crewPrizeId = crewPrizeId;
	}

	public ProductBean getCrewPrize() {
		return crewPrize;
	}

	public void setCrewPrize(ProductBean crewPrize) {
		this.crewPrize = crewPrize;
	}

	public Integer getComfortPrizeId() {
		return comfortPrizeId;
	}

	public void setComfortPrizeId(Integer comfortPrizeId) {
		this.comfortPrizeId = comfortPrizeId;
	}

	public ProductBean getComfortPrize() {
		return comfortPrize;
	}

	public void setComfortPrize(ProductBean comfortPrize) {
		this.comfortPrize = comfortPrize;
	}

}