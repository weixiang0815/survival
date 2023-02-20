package tw.survival.model.Competition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "New_Competition_Form_Part_3")
public class NewCompetitionFormPart3Bean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "thirdPart")
//	private NewCompetitionFormBean newCompetitionForm;

	@Column(name = "content")
	private String content;

	public NewCompetitionFormPart3Bean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public NewCompetitionFormPart3Bean(NewCompetitionFormBean newCompetitionForm) {
//		this.newCompetitionForm = newCompetitionForm;
//	}
//
//	public NewCompetitionFormBean getNewCompetitionForm() {
//		return newCompetitionForm;
//	}
//
//	public void setNewCompetitionForm(NewCompetitionFormBean newCompetitionForm) {
//		this.newCompetitionForm = newCompetitionForm;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}