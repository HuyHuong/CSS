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
import dao.ProjectDao;
import dao.SurveyDao;
import dao.SurveyInformationDao;
import dao.UserInformationDao;
import model.AssignSurvey;
import model.Project;
import model.Survey;
import model.SurveyInformation;
import model.UserInformation;

@WebServlet("/viewInfo")
public class ViewInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViewInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int assignSurveyId = Integer.parseInt(request.getParameter("assignSurveyId"));
		Connection con = DataAccess.getConnection();
		AssignSurvey assignSurvey = AssignSurveyDao.findAssignSurvey(con, assignSurveyId);
		List<SurveyInformation> surveyLInfoList = SurveyInformationDao.getAllSurveyInformation(con);
		
		System.out.println(assignSurvey.getProjectId());
		if (request.getParameter("survey") != null) {
			Survey survey = SurveyDao.findSurveyById(con, assignSurvey.getSurveyId());
			request.setAttribute("survey", survey);
			
		} else if (request.getParameter("project") != null) {
			Project project = ProjectDao.findProjectById(con, assignSurvey.getProjectId());
			System.out.println(project.getId());
			request.setAttribute("project", project);
			
		} else if (request.getParameter("customer") != null) {
			UserInformation userInfo = UserInformationDao.findUserInfo(con, assignSurvey.getUserInfoId());
			request.setAttribute("userInfo", userInfo);
		}
		request.setAttribute("surveyInfoList", surveyLInfoList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/surveyList.jsp");
		dispatcher.forward(request, response);
	}

}
