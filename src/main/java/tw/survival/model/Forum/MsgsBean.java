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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "msgs")
public class MsgsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//建立內容
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "essay")
	private String essay;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name = "added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date added;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name = "final_added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date finalAdded;
	
	//建立關聯

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_posts_id")
	private PostsBean post;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "msgs", cascade = CascadeType.ALL)
	private Set<PlayerToMsgsBean> forMsgs = new LinkedHashSet<PlayerToMsgsBean>();
	
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

	public Set<PlayerToMsgsBean> getForMsgs() {
		return forMsgs;
	}

	public void setForMsgs(Set<PlayerToMsgsBean> forMsgs) {
		this.forMsgs = forMsgs;
	}

	public PostsBean getPost() {
		return post;
	}

	public void setPost(PostsBean post) {
		this.post = post;
	}

}