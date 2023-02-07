package tw.survival.model.Competition;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import tw.survival.model.Market.ProductBean;

@Entity
@Table(name = "Competition_Prize")
public class CompetitionPrizeBean {

	@Id
	private Integer competitionId;

	private CompetitionBean competition;

	private Integer firstPrizeId;

	private ProductBean firstPrize;

	private Integer secondPrizeId;

	private ProductBean secondPrize;

	private Integer thirdPrizeId;

	private ProductBean thirdPrize;

	private Integer crewPrizeId;

	private ProductBean crewPrize;

	private Integer comfortPrizeId;

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