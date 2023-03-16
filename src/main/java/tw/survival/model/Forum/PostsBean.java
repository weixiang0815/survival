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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "posts")
public class PostsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "classify")
	private String classify;

	@Column(name = "essay_file_location")
	private String essayLocation;

	@Transient
	private String content;

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

//定義table之間的關連，並附上JSON主從關係。
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
	@OrderBy("added desc")
	private Set<MsgsBean> messages = new LinkedHashSet<MsgsBean>();

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
	@OrderBy("added desc")
	private Set<ThumbUpBean> thumbUpOfPost = new LinkedHashSet<ThumbUpBean>();

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
	@OrderBy("added desc")
	private Set<ScoreBean> scoreOfPost = new LinkedHashSet<ScoreBean>();

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
	@OrderBy("added desc")
	private Set<BookmarkletBean> bookmarkletOfPost = new LinkedHashSet<BookmarkletBean>();

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_player_id")
	private PlayerBean player;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	@PrePersist // 當物件轉換成 Persistent 狀態，先做這件事
	public void onCreate() {
		if (added == null) {
			added = new Date();
		}
		if (finalAdded == null) {
			finalAdded = new Date();
		}
	}

	public PostsBean() {
	}

	public PostsBean(String name, String classify, String essayLocation) {
		this.name = name;
		this.classify = classify;
		this.essayLocation = essayLocation;
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

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getEssayLocation() {
		return essayLocation;
	}

	public void setEssayLocation(String essayLocation) {
		this.essayLocation = essayLocation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Set<MsgsBean> getMessages() {
		return messages;
	}

	public void setMessages(Set<MsgsBean> messages) {
		this.messages = messages;
	}

	public Set<ThumbUpBean> getThumbUpOfPost() {
		return thumbUpOfPost;
	}

	public void setThumbUpOfPost(Set<ThumbUpBean> thumbUpOfPost) {
		this.thumbUpOfPost = thumbUpOfPost;
	}

	public Set<ScoreBean> getScoreOfPost() {
		return scoreOfPost;
	}

	public void setScoreOfPost(Set<ScoreBean> scoreOfPost) {
		this.scoreOfPost = scoreOfPost;
	}

	public Set<BookmarkletBean> getBookmarkletOfPost() {
		return bookmarkletOfPost;
	}

	public void setBookmarkletOfPost(Set<BookmarkletBean> bookmarkletOfPost) {
		this.bookmarkletOfPost = bookmarkletOfPost;
	}

	public PlayerBean getPlayer() {
		return player;
	}

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

}