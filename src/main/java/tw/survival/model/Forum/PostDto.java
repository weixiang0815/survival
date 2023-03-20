package tw.survival.model.Forum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostDto implements Serializable {

//	DTO Data Transfer Object
//
//	傳遞資料的物件
//	request , response 都可以做
//
//	特性: 
//	- 跟資料庫無關，只是傳遞資料
//	- 不只 restful api 可以做，spring form 也可以做

	private static final long serialVersionUID = 1L;

	private List<String> classify = new ArrayList<String>();

	private String name;

	private List<Integer> date = new ArrayList<Integer>();

	private Integer playerId;

	public PostDto() {
	}

	public PostDto(List<String> classify, String name, List<Integer> date, Integer playerId) {
		super();
		this.classify = classify;
		this.name = name;
		this.date = date;
		this.playerId = playerId;
	}

	public List<String> getClassify() {
		return classify;
	}

	public void setClassify(List<String> classify) {
		this.classify = classify;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getDate() {
		return date;
	}

	public void setDate(List<Integer> date) {
		this.date = date;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	// String Builder 確認Dto本身有沒有建置
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostDto [classify=");
		builder.append(classify);
		builder.append(", name=");
		builder.append(name);
		builder.append(", date=");
		builder.append(date);
		builder.append(", playerId=");
		builder.append(playerId);
		builder.append("]");
		return builder.toString();
	}

}