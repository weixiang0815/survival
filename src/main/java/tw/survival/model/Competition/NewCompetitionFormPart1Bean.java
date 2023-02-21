package tw.survival.model.Competition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "New_Competition_Form_Part_1")
public class NewCompetitionFormPart1Bean {

	@Id
	@Column(name = "fk_new_competition_form_id")
	private Integer newCompetitionFormId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_new_competition_form_id")
	private NewCompetitionFormBean newCompetitionForm;

	@Column(name = "name_mandarin")
	private String mandarinName;

	@Column(name = "name_english")
	private String englishName;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "start_timespan")
	private Integer startTimespan;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "end_timespan")
	private Integer endTimespan;

	public NewCompetitionFormPart1Bean() {
	}

	public Integer getNewCompetitionFormId() {
		return newCompetitionFormId;
	}

	public void setNewCompetitionFormId(Integer newCompetitionFormId) {
		this.newCompetitionFormId = newCompetitionFormId;
	}

	public NewCompetitionFormBean getNewCompetitionForm() {
		return newCompetitionForm;
	}

	public void setNewCompetitionForm(NewCompetitionFormBean newCompetitionForm) {
		this.newCompetitionForm = newCompetitionForm;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getStartTimespan() {
		return startTimespan;
	}

	public void setStartTimespan(Integer startTimespan) {
		this.startTimespan = startTimespan;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getEndTimespan() {
		return endTimespan;
	}

	public void setEndTimespan(Integer endTimespan) {
		this.endTimespan = endTimespan;
	}

}