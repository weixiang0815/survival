package tw.survival.model.Competition;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Competition_Picture")
public class CompetitionPictureBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "file_location")
	private String fileLocation;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	@JsonIgnore
	@Transient
	private byte[] picture;

	@Column(name = "content_type")
	private String contentType;

	public CompetitionPictureBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@SuppressWarnings("null")
	public void setPicture(MultipartFile picture) throws IOException {
		String contentType = picture.getContentType();
		if (contentType.contains("\"")) {
			contentType = contentType.substring(contentType.indexOf("\"") + 1);
		} else if (contentType.contains("/")) {
			contentType = contentType.substring(contentType.indexOf("/") + 1);
		}
		this.contentType = contentType;
		this.picture = picture.getBytes();
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}