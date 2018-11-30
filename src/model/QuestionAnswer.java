package model;

public class QuestionAnswer {
	private int id, questionId, offeredAnswerId;

	public QuestionAnswer(int id, int questionId, int offeredAnswerId) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.offeredAnswerId = offeredAnswerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getOfferedAnswerId() {
		return offeredAnswerId;
	}

	public void setOfferedAnswerId(int offeredAnswerId) {
		this.offeredAnswerId = offeredAnswerId;
	}
}
