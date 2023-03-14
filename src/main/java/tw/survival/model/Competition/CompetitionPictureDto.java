package tw.survival.model.Competition;

import java.io.Serializable;
import java.util.Set;

public class CompetitionPictureDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer compId;
	
	private String compName;

	private Set<CompetitionPictureBean> picSet;

	public CompetitionPictureDto() {
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Set<CompetitionPictureBean> getPicSet() {
		return picSet;
	}

	public void setPicSet(Set<CompetitionPictureBean> picSet) {
		this.picSet = picSet;
	}

}