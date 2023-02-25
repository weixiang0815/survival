package tw.survival.model.Competition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.survival.model.Market.ProductBean;

@Entity
@Table(name = "Competition_Prize")
public class CompetitionPrizeBean {

	@Id
	@Column(name = "fk_competition_id")
	private Integer competitionId;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_1ts_prize_id")
	private ProductBean firstPrize;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_2nd_prize_id")
	private ProductBean secondPrize;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_3rd_prize_id")
	private ProductBean thirdPrize;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_single_prize_id")
	private ProductBean singlePrize;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_crew_prize_id")
	private ProductBean crewPrize;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_comfort_prize_id")
	private ProductBean comfortPrize;

	public CompetitionPrizeBean() {
	}

	public Integer getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(Integer competitionId) {
		this.competitionId = competitionId;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

	public ProductBean getFirstPrize() {
		return firstPrize;
	}

	public void setFirstPrize(ProductBean firstPrize) {
		this.firstPrize = firstPrize;
	}

	public ProductBean getSecondPrize() {
		return secondPrize;
	}

	public void setSecondPrize(ProductBean secondPrize) {
		this.secondPrize = secondPrize;
	}

	public ProductBean getThirdPrize() {
		return thirdPrize;
	}

	public void setThirdPrize(ProductBean thirdPrize) {
		this.thirdPrize = thirdPrize;
	}

	public ProductBean getSinglePrize() {
		return singlePrize;
	}

	public void setSinglePrize(ProductBean singlePrize) {
		this.singlePrize = singlePrize;
	}

	public ProductBean getCrewPrize() {
		return crewPrize;
	}

	public void setCrewPrize(ProductBean crewPrize) {
		this.crewPrize = crewPrize;
	}

	public ProductBean getComfortPrize() {
		return comfortPrize;
	}

	public void setComfortPrize(ProductBean comfortPrize) {
		this.comfortPrize = comfortPrize;
	}

}