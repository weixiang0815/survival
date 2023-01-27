package tw.suvival.model;

public class Members {

	private String memberName;
	private String gender;
	private int age;

	public Members() {
	}

	public Members(String memberName, String gender, int age) {
		super();
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Members [memberName=");
		builder.append(memberName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}

}
