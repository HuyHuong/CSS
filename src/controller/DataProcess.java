package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OfferedAnswerDao;
import dao.QuestionDao;
import model.OfferedAnswer;
import model.Question;
import model.Submission;

public class DataProcess {

	public static List<Submission> setSubmissionList(Connection con, HttpServletRequest request, int surveyId) {
		String language = request.getParameter("language");

		List<Submission> submissionList = new ArrayList<>();

		List<Question> questionsList = QuestionDao.getSurveyQuestion(con, surveyId);

		for (Question question : questionsList) {
			String answer = request.getParameter(String.valueOf(question.getId()));

			Submission submission = null;
			if (question.getType().equalsIgnoreCase("close_question")) {
				OfferedAnswer offeredAns = OfferedAnswerDao.findOfferedAnswer(con, Integer.parseInt(answer));

				if (language.equalsIgnoreCase("en_US")) {
					submission = new Submission(question.getId(), question.getContentEN(), question.getContentVN(),
							question.getContentJP(), offeredAns.getOfferedAnswerEN(), offeredAns.getPoint(),
							question.getType());
					submissionList.add(submission);
				} else if (language.equalsIgnoreCase("vi_VN")) {
					submission = new Submission(question.getId(), question.getContentEN(), question.getContentVN(),
							question.getContentJP(), offeredAns.getOfferedAnswerVN(), offeredAns.getPoint(),
							question.getType());
					submissionList.add(submission);
				} else if (language.equalsIgnoreCase("ja_JP")) {
					submission = new Submission(question.getId(), question.getContentEN(), question.getContentVN(),
							question.getContentJP(), offeredAns.getOfferedAnswerJP(), offeredAns.getPoint(),
							question.getType());
					submissionList.add(submission);
				}
			} else {
				submission = new Submission(question.getId(), question.getContentEN(), question.getContentVN(),
						question.getContentJP(), answer, question.getType());
				submissionList.add(submission);
			}
		}
		return submissionList;
	}

	public static List<Submission> setSubmissionListConfirm(Connection con, HttpServletRequest request, int surveyId) {
		List<Submission> submissionList = new ArrayList<>();

		List<Question> questionsList = QuestionDao.getSurveyQuestion(con, surveyId);

		for (Question question : questionsList) {
			String answer = request.getParameter(String.valueOf(question.getId()));
			Submission submission = null;

			if (question.getType().equalsIgnoreCase("close_question")) {
				int point = Integer.parseInt(request.getParameter("answer "+String.valueOf(question.getId())));

				submission = new Submission(question.getId(), question.getContentEN(), question.getContentVN(),
						question.getContentJP(), answer, point, question.getType());
				submissionList.add(submission);

			} else {
				submission = new Submission(question.getId(), question.getContentEN(), question.getContentVN(),
						question.getContentJP(), answer, question.getType());
				submissionList.add(submission);
			}
		}
		return submissionList;
	}

	public static void setFont(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	}
}
