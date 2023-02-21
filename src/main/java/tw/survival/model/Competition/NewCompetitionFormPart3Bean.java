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
public class NewCompetitionFormPart3Bean {

	@Id
	@Column(name = "fk_new_competition_form_id")
	private Integer newCompetitionFormId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_new_competition_form_id")
	private NewCompetitionFormBean newCompetitionForm;

	@Column(name = "content")
	private String content;

	public NewCompetitionFormPart3Bean() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}