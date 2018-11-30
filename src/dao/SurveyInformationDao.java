package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SurveyInformation;

public class SurveyInformationDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;
	// private static int STATUS = 1; // Unfinish

	public static List<SurveyInformation> getAllSurveyInformation(Connection con) {
		List<SurveyInformation> surveyInfoList = new ArrayList<>();
		SurveyInformation surveyInfo = null;
		String getAllSurveyInformation = "select * from survey_information";
		try {
			preStmt = con.prepareStatement(getAllSurveyInformation);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				surveyInfo = new SurveyInformation(rs.getInt("id"), rs.getString("survey_name"),
						rs.getString("project_name"), rs.getString("first_name") + " " + rs.getString("last_name"),
						rs.getTimestamp("updated"), rs.getInt("status"));
				surveyInfoList.add(surveyInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return surveyInfoList;
	}

	public static List<SurveyInformation> selectSurveyInfo(Connection con, String name) {
		List<SurveyInformation> surveyInfoList = new ArrayList<>();
		SurveyInformation surveyInfo = null;
		String selectSurveyInfo = "select * from survey_information where survey_name like'%" + name
				+ "%' or project_name like '%" + name + "%' or first_name like '%" + name + "%' or last_name like '%"
				+ name + "%' or updated like '%" + name + "%'";
		try {
			preStmt = con.prepareStatement(selectSurveyInfo);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				surveyInfo = new SurveyInformation(rs.getInt("id"), rs.getString("survey_name"),
						rs.getString("project_name"), rs.getString("first_name") + " " + rs.getString("last_name"),
						rs.getTimestamp("updated"), rs.getInt("status"));
				surveyInfoList.add(surveyInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return surveyInfoList;
	}
	
	public static List<SurveyInformation> fitlerStatus(Connection con, int status) {
		List<SurveyInformation> surveyInfoList = new ArrayList<>();
		SurveyInformation surveyInfo = null;
		String fitlerStatus = "select * from survey_information where status=?";
		
		try {
			preStmt = con.prepareStatement(fitlerStatus);
			preStmt.setInt(1, status);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				surveyInfo = new SurveyInformation(rs.getInt("id"), rs.getString("survey_name"),
						rs.getString("project_name"), rs.getString("first_name") + " " + rs.getString("last_name"),
						rs.getTimestamp("updated"), rs.getInt("status"));
				surveyInfoList.add(surveyInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return surveyInfoList;
	}
}
