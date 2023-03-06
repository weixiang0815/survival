package tw.survival.model.Employee;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="empPermission")
public class EmployeePermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "schedule")
	private Character schedule;
	
	@Column(name = "player_management")
	private Character player_management;
	
	@Column(name = "arrange_competition")
	private Character arrange_competition;
	
	@Column(name = "human_resource")
	private Character human_resource;
	
	@Column(name = "inventory")
	private Character inventory;
 
	@JsonBackReference
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "employeePermission",cascade = CascadeType.ALL)
	private Set<EmployeeBean> employees=new LinkedHashSet<EmployeeBean>();;
	private EmployeePermission() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getSchedule() {
		return schedule;
	}

	public void setSchedule(Character schedule) {
		this.schedule = schedule;
	}

	public Character getPlayer_management() {
		return player_management;
	}

	public void setPlayer_management(Character player_management) {
		this.player_management = player_management;
	}

	public Character getArrange_competition() {
		return arrange_competition;
	}

	public void setArrange_competition(Character arrange_competition) {
		this.arrange_competition = arrange_competition;
	}

	public Character getHuman_resource() {
		return human_resource;
	}

	public void setHuman_resource(Character human_resource) {
		this.human_resource = human_resource;
	}

	public Character getInventory() {
		return inventory;
	}

	public void setInventory(Character inventory) {
		this.inventory = inventory;
	}

	public Set<EmployeeBean> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeBean> employees) {
		this.employees = employees;
	}
	
}
