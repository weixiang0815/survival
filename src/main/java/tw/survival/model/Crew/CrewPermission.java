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
}
