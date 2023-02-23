package tw.survival.model.Competition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "New_Competition_Form_Part_3")
public class NewCompetitionFormPart3Bean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "content_file_location")
	private String contentFileLocation;

	@Transient
	private String content;

	public NewCompetitionFormPart3Bean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContentFileLocation() {
		return contentFileLocation;
	}

	public void setContentFileLocation(String contentFileLocation) {
		this.contentFileLocation = contentFileLocation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}