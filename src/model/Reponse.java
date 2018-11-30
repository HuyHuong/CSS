package model;

import java.sql.Timestamp;

public class Reponse {
	private int surveyId, questionId, userInfoId;
	private String answer;
	private Timestamp updated;
	private int point;

	public Reponse() {
	}

	public Reponse(int surveyId, int questionId, int userInfoId, String answer, int point) {
		super();
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.userInfoId = userInfoId;
		this.answer = answer;
		this.point = point;
	}

	public Reponse(int surveyId, int questionId, int userInfoId, String answer) {
		super();
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.userInfoId = userInfoId;
		this.answer = answer;
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

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
