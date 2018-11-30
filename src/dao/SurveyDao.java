package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Survey;

public class SurveyDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static void insertSurvey(Connection con, Survey survey) {
		String insertSurvey = "insert into survey (name, number_of_question, description) values(?, ?, ?)";
		try {
			preStmt = con.prepareStatement(insertSurvey);
			preStmt.setString(1, survey.getName());
			preStmt.setInt(2, survey.getNumberOfQuestion());
			preStmt.setString(3, survey.getDescription());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Survey getSurvey(Connection con, Survey surveyNon) {
		Survey survey = null;
		String getSurvey = "select * from survey where name=? and number_of_question=? and description=?";
		try {
			preStmt = con.prepareStatement(getSurvey);
			preStmt.setString(1, surveyNon.getName());
			preStmt.setInt(2, surveyNon.getNumberOfQuestion());
			preStmt.setString(3, surveyNon.getDescription());
			rs = preStmt.executeQuery();
			while (rs.next()) {
				survey = new Survey(rs.getInt("id"), rs.getString("name"), rs.getInt("number_of_question"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return survey;
	}

	public static Survey findSurveyById(Connection con, int surveyId) {
		Survey survey = null;
		String findSurveyById = "select * from survey where id=?";
		try {
			preStmt = con.prepareStatement(findSurveyById);
			preStmt.setInt(1, surveyId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				survey = new Survey(rs.getInt("id"), rs.getString("name"), rs.getInt("number_of_question"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return survey;
	}

	public static List<Survey> getAllSurvey(Connection con) {
		List<Survey> surveyList = new ArrayList<>();
		Survey survey = null;
		String getAllSurvey = "select * from survey";
		try {
			preStmt = con.prepareStatement(getAllSurvey);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				survey = new Survey(rs.getInt("id"), rs.getString("name"), rs.getInt("number_of_question"),
						rs.getString("description"));
				surveyList.add(survey);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return surveyList;
	}
}
