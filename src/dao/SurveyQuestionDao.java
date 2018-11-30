package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurveyQuestionDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static List<Integer> getQuestionId(Connection con, int surveyId) {
		List<Integer> questionIdList = new ArrayList<>();
		String queryGetQuestionId = "select question_id from survey_question where survey_id=?";
		try {
			preStmt = con.prepareStatement(queryGetQuestionId);
			preStmt.setInt(1, surveyId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				questionIdList.add(rs.getInt("question_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionIdList;
	}

	public static void insertSurveyQuestion(Connection con, int surveyId, List<Integer> questionIdList) {
		String insertSurveyQuestion = "insert into survey_question (survey_id, question_id) values(?, ?)";
		try {
			preStmt = con.prepareStatement(insertSurveyQuestion);
			for (Integer questionId : questionIdList) {
				preStmt.setInt(1, surveyId);
				preStmt.setInt(2, questionId);
				preStmt.addBatch();
			}
			preStmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
