package tw.survival.model.Player;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="playerPermission")
public class playerPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "join_single_competition")
	private Character join_single_competition;
	
	@Column(name = "shopping")
	private Character shopping;
	
	@Column(name = "rent")
	private Character rent;
	
	@Column(name = "join_crew")
	private Character join_crew;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "playerPermission",cascade = CascadeType.ALL)
	private Set<PlayerBean> players=new LinkedHashSet<PlayerBean>();
	public playerPermission() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getJoin_single_competition() {
		return join_single_competition;
	}

	public void setJoin_single_competition(Character join_single_competition) {
		this.join_single_competition = join_single_competition;
	}

	public Character getShopping() {
		return shopping;
	}

	public void setShopping(Character shopping) {
		this.shopping = shopping;
	}

	public Character getRent() {
		return rent;
	}

	public void setRent(Character rent) {
		this.rent = rent;
	}

	public Character getJoin_crew() {
		return join_crew;
	}

	public void setJoin_crew(Character join_crew) {
		this.join_crew = join_crew;
	}

	public Set<PlayerBean> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerBean> players) {
		this.players = players;
	}
	
	
}
