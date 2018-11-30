package model;

public class SurveyQuestion {
	private int surveyId, questionId;

	public SurveyQuestion(int surveyId, int questionId) {
		super();
		this.surveyId = surveyId;
		this.questionId = questionId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
}
