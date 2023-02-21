package tw.survival.model.Player;

import java.io.IOException;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import tw.survival.model.Crew.CrewBean;
import tw.survival.model.Crew.CrewPermission;
import tw.survival.model.Forum.BookmarkletBean;
import tw.survival.model.Forum.PostsBean;

@Entity
@Table(name = "Player")
public class PlayerBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "account")
	private String account;

	@Column(name = "password")
	private String password;

	@Column(name = "identity_number")
	private String identity_number;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private Integer age;

	@Column(name = "region")
	private String region;

	@Column(name = "address")
	private String address;

	@Column(name = "info")
	private String info;

	@Column(name = "thumbnail")
	@Lob
	private byte[] thumbnail;

	@Column(name = "sex")
	private String sex;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "birthday")
	private Date birthday;

	@CreatedDate
	@Column(name = "join_date")
	private Date join_date;

	@Column(name = "cellphone")
	private String phone;

	@Column(name = "banned")
	private String banned;

	@Column(name = "banned_reason")
	private String banned_reason;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_crew_id")
	private CrewBean crew;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_crew_permission")
	private CrewPermission crewPermission;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_player_permission")
	private playerPermission playerPermission;

//	@JsonManagedReference
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
//	private Set<OrderItemBean> OrderItem = new LinkedHashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
	@OrderBy("added desc")
	private Set<PostsBean> postsOfPlayer = new LinkedHashSet<PostsBean>();//RZ 2023/2/21
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
//	@OrderBy("added desc")
//	private Set<MsgsBean> msgsOfPlayer = new LinkedHashSet<MsgsBean>();
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
//	@OrderBy("added desc")
//	private Set<ThumbUpBean> thumbUpOfPost = new LinkedHashSet<ThumbUpBean>();
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
//	@OrderBy("added desc")
//	private Set<ScoreBean> scoreOfPost = new LinkedHashSet<ScoreBean>();
//
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
	@OrderBy("added desc")
	private Set<BookmarkletBean> bookmarkletOfPost = new LinkedHashSet<BookmarkletBean>();//RZ 2023/2/21

	@PrePersist
	public void autoCreate() {
		if (join_date == null) {
			join_date = new Date();
		}
	}

	public PlayerBean() {
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setThumbnail(MultipartFile file) throws IOException {
		this.thumbnail = file.getBytes();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBanned() {
		return banned;
	}

	public void setBanned(String banned) {
		this.banned = banned;
	}

	public String getBanned_reason() {
		return banned_reason;
	}

	public void setBanned_reason(String banned_reason) {
		this.banned_reason = banned_reason;
	}

	public CrewBean getCrew() {
		return crew;
	}

	public void setCrew(CrewBean crew) {
		this.crew = crew;
	}

	public Set<PostsBean> getPostsOfPlayer() {
		return postsOfPlayer;
	}

	public void setPostsOfPlayer(Set<PostsBean> postsOfPlayer) {
		this.postsOfPlayer = postsOfPlayer;
	}
//
//	public Set<MsgsBean> getMsgsOfPlayer() {
//		return msgsOfPlayer;
//	}
//
//	public void setMsgsOfPlayer(Set<MsgsBean> msgsOfPlayer) {
//		this.msgsOfPlayer = msgsOfPlayer;
//	}
//
//	public Set<ThumbUpBean> getThumbUpOfPost() {
//		return thumbUpOfPost;
//	}
//
//	public void setThumbUpOfPost(Set<ThumbUpBean> thumbUpOfPost) {
//		this.thumbUpOfPost = thumbUpOfPost;
//	}
//
//	public Set<ScoreBean> getScoreOfPost() {
//		return scoreOfPost;
//	}
//
//	public void setScoreOfPost(Set<ScoreBean> scoreOfPost) {
//		this.scoreOfPost = scoreOfPost;
//	}
//
	public Set<BookmarkletBean> getBookmarkletOfPost() {
		return bookmarkletOfPost;
	}

	public void setBookmarkletOfPost(Set<BookmarkletBean> bookmarkletOfPost) {
		this.bookmarkletOfPost = bookmarkletOfPost;
	}

	public CrewPermission getCrewPermission() {
		return crewPermission;
	}

	public void setCrewPermission(CrewPermission crewPermission) {
		this.crewPermission = crewPermission;
	}

	public playerPermission getPlayerPermission() {
		return playerPermission;
	}

	public void setPlayerPermission(playerPermission playerPermission) {
		this.playerPermission = playerPermission;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}