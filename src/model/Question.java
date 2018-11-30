package model;

public class Question {
	private int id;
	private String contentEN, contentVN, contentJP, type;

	public Question(int id, String contentEN, String contentVN, String contentJP, String type) {
		super();
		this.id = id;
		this.contentEN = contentEN;
		this.contentVN = contentVN;
		this.contentJP = contentJP;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentEN() {
		return contentEN;
	}

	public void setContentEN(String contentEN) {
		this.contentEN = contentEN;
	}

	public String getContentVN() {
		return contentVN;
	}

	public void setContentVN(String contentVN) {
		this.contentVN = contentVN;
	}

	public String getContentJP() {
		return contentJP;
	}

	public void setContentJP(String contentJP) {
		this.contentJP = contentJP;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
