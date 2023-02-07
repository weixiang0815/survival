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
	private Character join_crew_competition;
	
	@Column(name = "kickout")
	private Character kickout;
	
	@Column(name = "modify_member_permission")
	private Character modify_member_permission ;
	
	@Column(name = "on_behalf_of_crew")
	private Character on_behalf_of_crew;
	
	@Column(name = "disband")
	private Character disband;
	
	public CrewPermission() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getJoin_crew_competition() {
		return join_crew_competition;
	}

	public void setJoin_crew_competition(Character join_crew_competition) {
		this.join_crew_competition = join_crew_competition;
	}

	public Character getKickout() {
		return kickout;
	}

	public void setKickout(Character kickout) {
		this.kickout = kickout;
	}

	public Character getModify_member_permission() {
		return modify_member_permission;
	}

	public void setModify_member_permission(Character modify_member_permission) {
		this.modify_member_permission = modify_member_permission;
	}

	public Character getOn_behalf_of_crew() {
		return on_behalf_of_crew;
	}

	public void setOn_behalf_of_crew(Character on_behalf_of_crew) {
		this.on_behalf_of_crew = on_behalf_of_crew;
	}

	public Character getDisband() {
		return disband;
	}

	public void setDisband(Character disband) {
		this.disband = disband;
	}
	
}
