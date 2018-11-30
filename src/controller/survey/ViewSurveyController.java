package controller.survey;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import dao.SurveyDao;
import model.Survey;

@WebServlet("/viewSurvey")
public class ViewSurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int SURVEY_ID = 1;

	public ViewSurveyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = DataAccess.getConnection();
		List<Survey> surveyList = SurveyDao.getAllSurvey(con);
		DataAccess.closeQuietly(con);
		request.setAttribute("surveyId", SURVEY_ID);
		request.setAttribute("surveyList", surveyList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/viewCSS.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int surveyId = Integer.parseInt(request.getParameter("survey"));
		Connection con = DataAccess.getConnection();
		List<Survey> surveyList = SurveyDao.getAllSurvey(con);
		DataAccess.closeQuietly(con);
		request.setAttribute("surveyList", surveyList);
		request.setAttribute("surveyId", surveyId);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/viewCSS.jsp");
		dispatcher.forward(request, response);

	}

}
