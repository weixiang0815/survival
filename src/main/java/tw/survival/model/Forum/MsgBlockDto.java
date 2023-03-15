package tw.survival.model.Forum;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MsgBlockDto implements Serializable {
	
//	DTO Data Transfer Object
//
//	傳遞資料的物件
//	request , response 都可以做
//
//	特性: 
//	- 跟資料庫無關，只是傳遞資料
//	- 不只 restful api 可以做，spring form 也可以做

	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("player_name")
	private String playerName;
	
	@JsonProperty("player_nickname")
	private String playerNickname;
	
	@JsonProperty("player_county")
	private String playerCounty;
	
	@JsonProperty("player_id")
	private Integer playerId;
	
	@JsonProperty("msg_id")
	private Integer msgId;
	
	@JsonProperty("msg_essay")
    private String essay;
	
	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@JsonProperty("msg_added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	private Date added;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerNickname() {
		return playerNickname;
	}

	public void setPlayerNickname(String playerNickname) {
		this.playerNickname = playerNickname;
	}

	public String getPlayerCounty() {
		return playerCounty;
	}

	public void setPlayerCounty(String playerCounty) {
		this.playerCounty = playerCounty;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
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
	
	
	
}
