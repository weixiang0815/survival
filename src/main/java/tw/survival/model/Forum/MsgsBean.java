package tw.survival.model.Forum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="msgs")
public class MsgsBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="essay")
	private String essay;
	
	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name="added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date added;
	
	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name="final_added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date finalAdded;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_posts_id")
	private PostsBean posts;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="fk_player_id")
//	private Player player;
	
	
	public MsgsBean() {
	}
	
	@PrePersist // 當物件轉換成 Persistent 狀態，先做這件事
	public void onCreate() {
		if(added == null) {
			added = new Date();
		}
		if(finalAdded == null) {
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

	public Date getFinal_added() {
		return finalAdded;
	}

	public void setFinal_added(Date final_added) {
		this.finalAdded = final_added;
	}

	public Date getFinalAdded() {
		return finalAdded;
	}

	public void setFinalAdded(Date finalAdded) {
		this.finalAdded = finalAdded;
	}

	public PostsBean getPosts() {
		return posts;
	}

	public void setPosts(PostsBean posts) {
		this.posts = posts;
	}

}