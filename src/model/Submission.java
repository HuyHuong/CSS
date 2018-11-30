package model;

public class Submission {

	private String questionEN, questionVN, questionJP, answer, questionType;
	private int questionId, point;

	public Submission(int questionId, String questionEN, String questionVN, String questionJP, String answer, int point,
			String questionType) {
		super();
		this.questionId = questionId;
		this.questionEN = questionEN;
		this.questionVN = questionVN;
		this.questionJP = questionJP;
		this.answer = answer;
		this.questionType = questionType;
		this.point = point;
	}

	public Submission(int questionId, String questionEN, String questionVN, String questionJP, String answer,
			String questionType) {
		super();
		this.questionId = questionId;
		this.questionEN = questionEN;
		this.questionVN = questionVN;
		this.questionJP = questionJP;
		this.answer = answer;
		this.questionType = questionType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionEN() {
		return questionEN;
	}

	public void setQuestionEN(String questionEN) {
		this.questionEN = questionEN;
	}

	public String getQuestionVN() {
		return questionVN;
	}

	public void setQuestionVN(String questionVN) {
		this.questionVN = questionVN;
	}

	public String getQuestionJP() {
		return questionJP;
	}

	public void setQuestionJP(String questionJP) {
		this.questionJP = questionJP;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}
