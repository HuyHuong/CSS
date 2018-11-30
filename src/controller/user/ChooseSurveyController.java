package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chooseSurvey")
public class ChooseSurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChooseSurveyController() {
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
		int assignSurveyId = Integer.parseInt(request.getParameter("assignSurveyId"));
		String language = request.getParameter("language");

		request.setAttribute("assignSurveyId", assignSurveyId);
		request.setAttribute("language", language);
		request.getRequestDispatcher("CSSform.jsp").forward(request, response);
	}

}
