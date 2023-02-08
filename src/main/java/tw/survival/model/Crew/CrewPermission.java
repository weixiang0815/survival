package tw.survival.model.Crew;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crewPermission")
public class CrewPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private Integer id;
	
	@Column(name = "join_crew_competition")	
	private String join_crew_competition;
	
	@Column(name = "kickout")
	private String kickout;
	
	@Column(name = "modify_member_permission")
	private String modify_member_permission ;
	
	@Column(name = "on_behalf_of_crew")
	private String on_behalf_of_crew;
	
	@Column(name = "disband")
	private String disband;
	
	public CrewPermission() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJoin_crew_competition() {
		return join_crew_competition;
	}

	public void setJoin_crew_competition(String join_crew_competition) {
		this.join_crew_competition = join_crew_competition;
	}

	public String getKickout() {
		return kickout;
	}

	public void setKickout(String kickout) {
		this.kickout = kickout;
	}

	public String getModify_member_permission() {
		return modify_member_permission;
	}

	public void setModify_member_permission(String modify_member_permission) {
		this.modify_member_permission = modify_member_permission;
	}

	public String getOn_behalf_of_crew() {
		return on_behalf_of_crew;
	}

	public void setOn_behalf_of_crew(String on_behalf_of_crew) {
		this.on_behalf_of_crew = on_behalf_of_crew;
	}

	public String getDisband() {
		return disband;
	}

	public void setDisband(String disband) {
		this.disband = disband;
	}
	
	
}
