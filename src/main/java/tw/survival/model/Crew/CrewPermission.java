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
	
	@Column(name = "id")	
	private String join_crew_competition;
	
	@Column(name = "id")
	private String kickout;
	
	@Column(name = "id")
	private String modify_member_permission ;
	
	@Column(name = "id")
	private String on_behalf_of_crew;
	
	@Column(name = "id")
	private String disband;
}
