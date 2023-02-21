package tw.survival.model.Forum;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tw.survival.model.Player.PlayerBean;


@Entity
@Table(name="bookmarklet")
public class BookmarkletBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_posts_id")
	private PostsBean posts;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_player_id")
	private PlayerBean player;	
	
	public BookmarkletBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PostsBean getPosts() {
		return posts;
	}

	public void setPosts(PostsBean posts) {
		this.posts = posts;
	}

	public PlayerBean getPlayer() {
		return player;
	}

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	
	
	
	
}
