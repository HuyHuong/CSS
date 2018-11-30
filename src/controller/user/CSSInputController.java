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
import model.AssignSurvey;
import model.Submission;

@WebServlet("/answer")
public class CSSInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CSSInputController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String language = (String) request.getSession().getAttribute("language");

		request.setAttribute("language", language);
		request.getRequestDispatcher("confirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataProcess.setFont(request, response);

		String language = request.getParameter("language");
		int assignSurveyId = Integer.parseInt(request.getParameter("assignSurveyId"));
		// List<Submission> submissionList = new ArrayList<>();

		Connection con = DataAccess.getConnection();
		AssignSurvey assignSurvey = AssignSurveyDao.findAssignSurvey(con, assignSurveyId);
		List<Submission> submissionList = DataProcess.setSubmissionList(con, request, assignSurvey.getSurveyId());
		
		DataAccess.closeQuietly(con);
		request.setAttribute("language", language);
		request.setAttribute("assignSurveyId", assignSurveyId);
		request.setAttribute("submissionList", submissionList);
		RequestDispatcher rd = request.getRequestDispatcher("confirm.jsp");
		rd.forward(request, response);
	}

}
