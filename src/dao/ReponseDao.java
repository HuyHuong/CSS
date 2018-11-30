package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reponse;

public class ReponseDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static void insertReponse(Connection con, Reponse reponse) {
		String queryInsertReponse = "insert into reponse (survey_id, question_id, user_info_id, answer, point, updated) values(?, ?, ?, ?, ?, NOW())";
		try {
			preStmt = con.prepareStatement(queryInsertReponse);
			preStmt.setInt(1, reponse.getSurveyId());
			preStmt.setInt(2, reponse.getQuestionId());
			preStmt.setInt(3, reponse.getUserInfoId());
			preStmt.setString(4, reponse.getAnswer());
			preStmt.setInt(5, reponse.getPoint());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertReponseNon(Connection con, Reponse reponse) {
		String queryInsertReponse = "insert into reponse (survey_id, question_id, user_info_id, answer, updated) values(?, ?, ?, ?, NOW())";
		try {
			preStmt = con.prepareStatement(queryInsertReponse);
			preStmt.setInt(1, reponse.getSurveyId());
			preStmt.setInt(2, reponse.getQuestionId());
			preStmt.setInt(3, reponse.getUserInfoId());
			preStmt.setString(4, reponse.getAnswer());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
