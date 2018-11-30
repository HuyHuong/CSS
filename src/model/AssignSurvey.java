package model;

import java.sql.Timestamp;

public class AssignSurvey {
	private int id, surveyId, userInfoId, projectId, status;
	private Timestamp updated;

	public AssignSurvey(int surveyId, int userInfoId, int projectId, int status) {
		super();
		this.surveyId = surveyId;
		this.userInfoId = userInfoId;
		this.projectId = projectId;
		this.status = status;
	}

	public AssignSurvey(int id, int surveyId, int projectId, int userInfoId, int status, Timestamp updated) {
		super();
		this.id = id;
		this.surveyId = surveyId;
		this.userInfoId = userInfoId;
		this.projectId = projectId;
		this.updated = updated;
		this.status = status;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
