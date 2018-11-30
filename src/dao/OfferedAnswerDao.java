package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OfferedAnswer;

public class OfferedAnswerDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static List<OfferedAnswer> getOfferedAnswer(Connection con, int questionId) {
		List<OfferedAnswer> offeredAnswerList = new ArrayList<>();
		OfferedAnswer offeredAnswer = null;
		
		for (Integer offeredAnswerId : getOfferedAnswerId(con, questionId)) {
			offeredAnswer = findOfferedAnswer(con, offeredAnswerId);
			offeredAnswerList.add(offeredAnswer);
		}
		return offeredAnswerList;
	}

	public static List<Integer> getOfferedAnswerId(Connection con, int questionId) {
		List<Integer> offeredAnswerIdList = new ArrayList<>();
		String queryGetOfferedAnswerId = "select offered_answer_id from question_answer where question_id=?";
		try {
			preStmt = con.prepareStatement(queryGetOfferedAnswerId);

			preStmt.setInt(1, questionId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				offeredAnswerIdList.add(rs.getInt("offered_answer_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offeredAnswerIdList;
	}

	public static OfferedAnswer findOfferedAnswer(Connection con, int offeredAnswerId) {
		String queryGetOfferedAnswer = "select * from offered_answer where id=?";
		OfferedAnswer offeredAnswer = null;
		try {
			preStmt = con.prepareStatement(queryGetOfferedAnswer);
			preStmt.setInt(1, offeredAnswerId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				offeredAnswer = new OfferedAnswer(rs.getInt("id"), rs.getString("contentEN"),
						rs.getString("contentVN"), rs.getString("contentJP"),
						rs.getInt("point"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offeredAnswer;
	}
}
