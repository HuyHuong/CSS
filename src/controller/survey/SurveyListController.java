package controller.survey;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import dao.SurveyInformationDao;
import model.SurveyInformation;

@WebServlet("/surveyList")
public class SurveyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int COMPLETED = 0;
	private static int UNCOMPLETED = 1;

	public SurveyListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = DataAccess.getConnection();
		List<SurveyInformation> surveyLInfoList = SurveyInformationDao.getAllSurveyInformation(con);
		DataAccess.closeQuietly(con);
		request.setAttribute("surveyInfoList", surveyLInfoList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/surveyList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String fitler = request.getParameter("fitler");
		List<SurveyInformation> surveyInfoList = new ArrayList<>();
		Connection con = DataAccess.getConnection();
		if (name != null) {
			surveyInfoList = SurveyInformationDao.selectSurveyInfo(con, name);
		} else if (fitler != null) {
			if (fitler.equalsIgnoreCase("completed")) {
				surveyInfoList = SurveyInformationDao.fitlerStatus(con, COMPLETED);
			} else if (fitler.equalsIgnoreCase("uncompleted")) {
				surveyInfoList = SurveyInformationDao.fitlerStatus(con, UNCOMPLETED);
			}
		}
		DataAccess.closeQuietly(con);
		request.setAttribute("surveyInfoList", surveyInfoList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/surveyList.jsp");
		dispatcher.forward(request, response);
	}

}
