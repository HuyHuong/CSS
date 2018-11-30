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

import dao.AssignSurveyDao;
import dao.DataAccess;
import dao.SurveyDao;
import dao.SurveyQuestionDao;
import dao.Utils;
import model.Survey;

@WebServlet("/createSurvey")
public class CreateNewSurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateNewSurveyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createCSS.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String surveyName = request.getParameter("surveyName");
		String description = request.getParameter("description");
		String[] questionIdArray = request.getParameterValues("question");
		String[] projectIdArray = request.getParameterValues("project");

		Connection con = DataAccess.getConnection();
		List<Integer> questionIdList = Utils.convertStringArrayToIntegerList(questionIdArray);
		List<Integer> projectIdList = Utils.convertStringArrayToIntegerList(projectIdArray);

		Survey survey = new Survey(surveyName, questionIdList.size(), description);
		SurveyDao.insertSurvey(con, survey);

		int surveyId = SurveyDao.getSurvey(con, survey).getId();
		SurveyQuestionDao.insertSurveyQuestion(con, surveyId, questionIdList);

		AssignSurveyDao.insertAssignSurveyList(con, surveyId, projectIdList);

		DataAccess.closeQuietly(con);
	}

}
