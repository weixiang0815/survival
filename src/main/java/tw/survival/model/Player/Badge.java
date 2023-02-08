package tw.survival.model.Player;

import java.util.HashSet;
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
import javax.persistence.Table;

@Entity
@Table(name = "Badge")
public class Badge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private Integer level;

	@Column(name = "condition")
	private String condition;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Badge_Player", 
	joinColumns = { @JoinColumn(name = "fk_user_id", referencedColumnName = "id") },
	inverseJoinColumns = {@JoinColumn(name="fk_badge_id",referencedColumnName = "id")})
	private Set<PlayerBean> playBean = new HashSet<PlayerBean>();

	public Badge() {

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Set<PlayerBean> getPlayBean() {
		return playBean;
	}

	public void setPlayBean(Set<PlayerBean> playBean) {
		this.playBean = playBean;
	}

}
