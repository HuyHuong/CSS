package model;

import java.sql.Timestamp;

public class SurveyInformation {
	private String surveyName, projectName, customerName;
	private Timestamp time;
	private int status, id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public SurveyInformation(int id, String surveyName, String projectName, String customerName, Timestamp time,
			int status) {
		super();
		this.id = id;
		this.surveyName = surveyName;
		this.projectName = projectName;
		this.customerName = customerName;
		this.time = time;
		this.status = status;
	}
}
