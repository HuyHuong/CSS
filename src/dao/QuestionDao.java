package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;

public class QuestionDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static Question findQuestion(Connection con, int questionId) {
		String queryFindQuestion = "select * from question where id=?";
		Question question = null;
		try {
			preStmt = con.prepareStatement(queryFindQuestion);
			preStmt.setInt(1, questionId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				question = new Question(questionId, rs.getString("contentEN"), rs.getString("contentVN"),
						rs.getString("contentJP"), rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return question;
	}

	public static List<Question> getSurveyQuestion(Connection con, int surveyId) {
		List<Question> surveyQuestionList = new ArrayList<>();
		Question question = null;

		for (int questionId : SurveyQuestionDao.getQuestionId(con, surveyId)) {
			question = findQuestion(con, questionId);
			surveyQuestionList.add(question);
		}

		return surveyQuestionList;
	}
	
	public static List<Question> getAllQuestion(Connection con) {
		List<Question> questionList = new ArrayList<>();
		Question question = null;
		String getAllQuestion = "select * from question";
		try {
			preStmt = con.prepareStatement(getAllQuestion);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				question = new Question(rs.getInt("id"), rs.getString("contentEN"), rs.getString("contentVN"),
						rs.getString("contentJP"), rs.getString("type"));
				questionList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionList;
	}
}
