package tw.survival.model.Crew;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "Crew")
public class CrewBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crew", cascade = CascadeType.ALL)
	private Set<PlayerBean> bean = new LinkedHashSet<PlayerBean>();

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Participation", inverseJoinColumns = {
			@JoinColumn(name = "fk_competitioncrew_id", referencedColumnName = "id") }, joinColumns = {
					@JoinColumn(name = "fk_crew_id", referencedColumnName = "id") })
	private Set<CrewBean> participantCrews = new LinkedHashSet<CrewBean>();

	public CrewBean() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PlayerBean> getBean() {
		return bean;
	}

	public void setBean(Set<PlayerBean> bean) {
		this.bean = bean;
	}

}