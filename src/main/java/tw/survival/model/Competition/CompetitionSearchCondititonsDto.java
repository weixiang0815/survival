package tw.survival.model.Competition;

import java.io.Serializable;
import java.util.List;

public class CompetitionSearchCondititonsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mandarinName;

	private String englishName;

	private List<Integer> place;

	private List<String> singleOrCrew;

	private List<String> status;

	private List<Integer> capacity;

	private List<Integer> budget;

	private List<Integer> fee;

	private List<Integer> publicOrPrivate;

	private String date;

	public CompetitionSearchCondititonsDto() {
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

	public List<Integer> getPlace() {
		return place;
	}

	public void setPlace(List<Integer> place) {
		this.place = place;
	}

	public List<String> getSingleOrCrew() {
		return singleOrCrew;
	}

	public void setSingleOrCrew(List<String> singleOrCrew) {
		this.singleOrCrew = singleOrCrew;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public List<Integer> getCapacity() {
		return capacity;
	}

	public void setCapacity(List<Integer> capacity) {
		this.capacity = capacity;
	}

	public List<Integer> getBudget() {
		return budget;
	}

	public void setBudget(List<Integer> budget) {
		this.budget = budget;
	}

	public List<Integer> getFee() {
		return fee;
	}

	public void setFee(List<Integer> fee) {
		this.fee = fee;
	}

	public List<Integer> getPublicOrPrivate() {
		return publicOrPrivate;
	}

	public void setPublicOrPrivate(List<Integer> publicOrPrivate) {
		this.publicOrPrivate = publicOrPrivate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}