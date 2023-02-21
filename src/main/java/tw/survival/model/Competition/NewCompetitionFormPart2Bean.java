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
@Table(name = "New_Competition_Form_Part_2")
public class NewCompetitionFormPart2Bean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "secondPart")
//	private NewCompetitionFormBean newCompetitionForm;

	@Column(name = "fk_place_id")
	private Integer placeId;

	@Column(name = "status")
	private String status;

	@Column(name = "single_or_crew", length = 1)
	private String singleOrCrew;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "budget")
	private Integer budget;

	@Column(name = "fee")
	private Integer fee;

	public NewCompetitionFormPart2Bean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public NewCompetitionFormPart2Bean(NewCompetitionFormBean newCompetitionForm) {
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

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSingleOrCrew() {
		return singleOrCrew;
	}

	public void setSingleOrCrew(String singleOrCrew) {
		this.singleOrCrew = singleOrCrew;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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

}