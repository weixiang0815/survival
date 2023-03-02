package tw.survival.model.Competition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Competition_History")
public class CompetitionHistoryBean {

	@Id
	@Column(name = "fk_competition_id")
	private Integer competitionId;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	@Column(name = "single_or_Crew", length = 1)
	private String singleOrCrew;

	@Column(name = "top_1")
	private Integer top1;

	@Column(name = "top_2")
	private Integer top2;

	@Column(name = "top_3")
	private Integer top3;

	@Column(name = "top_4")
	private Integer top4;

	@Column(name = "top_5")
	private Integer top5;

	@Column(name = "top_6")
	private Integer top6;

	@Column(name = "top_7")
	private Integer top7;

	@Column(name = "top_8")
	private Integer top8;

	@Column(name = "top_9")
	private Integer top9;

	@Column(name = "top_10")
	private Integer top10;

	@Column(name = "top_11")
	private Integer top11;

	@Column(name = "top_12")
	private Integer top12;

	@Column(name = "top_13")
	private Integer top13;

	@Column(name = "top_14")
	private Integer top14;

	@Column(name = "top_15")
	private Integer top15;

	@Column(name = "top_16")
	private Integer top16;

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

	public String getSingleOrCrew() {
		return singleOrCrew;
	}

	public void setSingleOrCrew(String singleOrCrew) {
		this.singleOrCrew = singleOrCrew;
	}

	public Integer getTop1() {
		return top1;
	}

	public void setTop1(Integer top1) {
		this.top1 = top1;
	}

	public Integer getTop2() {
		return top2;
	}

	public void setTop2(Integer top2) {
		this.top2 = top2;
	}

	public Integer getTop3() {
		return top3;
	}

	public void setTop3(Integer top3) {
		this.top3 = top3;
	}

	public Integer getTop4() {
		return top4;
	}

	public void setTop4(Integer top4) {
		this.top4 = top4;
	}

	public Integer getTop5() {
		return top5;
	}

	public void setTop5(Integer top5) {
		this.top5 = top5;
	}

	public Integer getTop6() {
		return top6;
	}

	public void setTop6(Integer top6) {
		this.top6 = top6;
	}

	public Integer getTop7() {
		return top7;
	}

	public void setTop7(Integer top7) {
		this.top7 = top7;
	}

	public Integer getTop8() {
		return top8;
	}

	public void setTop8(Integer top8) {
		this.top8 = top8;
	}

	public Integer getTop9() {
		return top9;
	}

	public void setTop9(Integer top9) {
		this.top9 = top9;
	}

	public Integer getTop10() {
		return top10;
	}

	public void setTop10(Integer top10) {
		this.top10 = top10;
	}

	public Integer getTop11() {
		return top11;
	}

	public void setTop11(Integer top11) {
		this.top11 = top11;
	}

	public Integer getTop12() {
		return top12;
	}

	public void setTop12(Integer top12) {
		this.top12 = top12;
	}

	public Integer getTop13() {
		return top13;
	}

	public void setTop13(Integer top13) {
		this.top13 = top13;
	}

	public Integer getTop14() {
		return top14;
	}

	public void setTop14(Integer top14) {
		this.top14 = top14;
	}

	public Integer getTop15() {
		return top15;
	}

	public void setTop15(Integer top15) {
		this.top15 = top15;
	}

	public Integer getTop16() {
		return top16;
	}

	public void setTop16(Integer top16) {
		this.top16 = top16;
	}

}