package tw.survival.model.Forum;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "msgs")
public class MsgsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "essay")
	private String essay;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name = "added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date added;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name = "final_added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date finalAdded;

	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_posts_id")
	private PostsBean post;
	
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PlayerToMsgs", inverseJoinColumns = {
            @JoinColumn(name = "fk_player_id", referencedColumnName = "id") }, joinColumns = {
                    @JoinColumn(name = "fk_msgs_id", referencedColumnName = "id") })
	private Set<PlayerBean> player = new LinkedHashSet<>();
	

	public MsgsBean() {
	}

	@PrePersist // 當物件轉換成 Persistent 狀態，先做這件事
	public void onCreate() {
		if (added == null) {
			added = new Date();
		}
		if (finalAdded == null) {
			finalAdded = new Date();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEssay() {
		return essay;
	}

	public void setEssay(String essay) {
		this.essay = essay;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public Date getFinalAdded() {
		return finalAdded;
	}

	public void setFinalAdded(Date finalAdded) {
		this.finalAdded = finalAdded;
	}

	public Set<PlayerBean> getPlayer() {
		return player;
	}

	public void setPlayer(Set<PlayerBean> player) {
		this.player = player;
	}

	public PostsBean getPost() {
		return post;
	}

	public void setPost(PostsBean post) {
		this.post = post;
	}

}