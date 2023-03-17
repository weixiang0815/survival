package tw.survival.model.Forum;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MsgDto implements Serializable {
	
//	DTO Data Transfer Object
//
//	傳遞資料的物件
//	request , response 都可以做
//
//	特性: 
//	- 跟資料庫無關，只是傳遞資料
//	- 不只 restful api 可以做，spring form 也可以做

	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("msg-id")
	private Integer id;
	
	@JsonProperty("edit-Text")
    private String content;
	
	@JsonProperty("post-id")
    private Integer postId;
	
	@JsonProperty("player-id")
    private Integer playerId;
	
	public MsgDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

    
}
