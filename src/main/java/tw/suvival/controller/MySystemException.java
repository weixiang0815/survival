package tw.suvival.controller;

public class MySystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String msg;

	public MySystemException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}