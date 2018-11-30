package controller.user;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DataProcess;
import dao.AssignSurveyDao;
import dao.DataAccess;
import dao.QuestionDao;
import dao.ReponseDao;
import model.AssignSurvey;
import model.Question;
import model.Reponse;
import model.Submission;

@WebServlet("/edit")
public class EditSubmissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditSubmissionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String language = (String) request.getSession().getAttribute("language");
		request.setAttribute("language", language);
		request.getRequestDispatcher("CSSform.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataProcess.setFont(request, response);
		
		String language = request.getParameter("language");
		int assignSurveyId = Integer.parseInt(request.getParameter("assignSurveyId"));

		Connection con = DataAccess.getConnection();
		AssignSurvey assignSurvey = AssignSurveyDao.findAssignSurvey(con, assignSurveyId);
		List<Submission> submissionList = DataProcess.setSubmissionListConfirm(con, request,
				assignSurvey.getSurveyId());

		if (request.getParameter("edit") != null) {

			request.setAttribute("language", language);
			request.setAttribute("assignSurveyId", assignSurveyId);
			request.setAttribute("submissionList", submissionList);
			RequestDispatcher rd = request.getRequestDispatcher("back_CSSform.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("confirm") != null) {
			List<Question> questionsList = QuestionDao.getSurveyQuestion(con, assignSurvey.getSurveyId());

			for (Question question : questionsList) {
				Reponse reponse = null;
				String answer = request.getParameter(String.valueOf(question.getId()));
				if (question.getType().equalsIgnoreCase("close_question")) {
					reponse = new Reponse(assignSurvey.getSurveyId(), question.getId(), assignSurvey.getUserInfoId(),
							answer, Integer.parseInt(request.getParameter(answer)));
					ReponseDao.insertReponse(con, reponse);
				} else {
					reponse = new Reponse(assignSurvey.getSurveyId(), question.getId(), assignSurvey.getUserInfoId(),
							answer);
					ReponseDao.insertReponseNon(con, reponse);
				}
			}
			AssignSurveyDao.updateAssignSurvey(con, assignSurveyId);
			request.setAttribute("language", language);
			request.setAttribute("assignSurveyId", assignSurveyId);
			request.setAttribute("submissionList", submissionList);
			request.getRequestDispatcher("thank.jsp").forward(request, response);
		}
		DataAccess.closeQuietly(con);
	}

}
