package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import dao.RoleDao;
import dao.UserAccountDao;
import model.Role;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String errorMessage = "";

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String language = (String) request.getSession().getAttribute("language");

		request.setAttribute("language", language);
		RequestDispatcher rd = request.getRequestDispatcher("chooseSurvey.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataProcess.setFont(request, response);

		String language = request.getParameter("language");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Connection con = DataAccess.getConnection();
		Role role = RoleDao.checkUserRole(con, username, password);
		int userInfoId = UserAccountDao.checkUserAccount(con, username, password).getUserInfoId();

		if (role == null) {
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else if (role.getName().equalsIgnoreCase("admin")) {
			request.setAttribute("language", language);
			request.setAttribute("username", username);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (role.getName().equalsIgnoreCase("user")) {
			request.setAttribute("userInfoId", userInfoId);
			request.setAttribute("language", language);
			request.getRequestDispatcher("chooseSurvey.jsp").forward(request, response);
		}

		DataAccess.closeQuietly(con);
	}

}
