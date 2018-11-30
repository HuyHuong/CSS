package model;

public class OfferedAnswer {
	private String offeredAnswerEN, offeredAnswerVN, offeredAnswerJP;
	private int point, id;

	public OfferedAnswer(int id, String offeredAnswerEN, String offeredAnswerVN, String offeredAnswerJP, int point) {
		super();
		this.offeredAnswerEN = offeredAnswerEN;
		this.offeredAnswerVN = offeredAnswerVN;
		this.offeredAnswerJP = offeredAnswerJP;
		this.point = point;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfferedAnswerEN() {
		return offeredAnswerEN;
	}

	public void setOfferedAnswerEN(String offeredAnswerEN) {
		this.offeredAnswerEN = offeredAnswerEN;
	}

	public String getOfferedAnswerVN() {
		return offeredAnswerVN;
	}

	public void setOfferedAnswerVN(String offeredAnswerVN) {
		this.offeredAnswerVN = offeredAnswerVN;
	}

	public String getOfferedAnswerJP() {
		return offeredAnswerJP;
	}

	public void setOfferedAnswerJP(String offeredAnswerJP) {
		this.offeredAnswerJP = offeredAnswerJP;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
