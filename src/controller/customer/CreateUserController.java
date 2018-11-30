package controller.customer;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DataProcess;
import dao.DataAccess;
import dao.RoleDao;
import dao.UserAccountDao;
import dao.UserInformationDao;
import model.UserAccount;
import model.UserInformation;

@WebServlet("/create")
public class CreateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ERROR_MESS = "Username is exist!";

	public CreateUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createUser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataProcess.setFont(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userRolename = request.getParameter("userRole");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String company = request.getParameter("company");
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String address = request.getParameter("address");

		Connection con = DataAccess.getConnection();
		int userRoleId = RoleDao.findUserRole(con, userRolename).getId();
		if (request.getParameter("submit") != null) {
			if (UserAccountDao.checkUsername(con, username)) {
				UserInformation userInfo = new UserInformation(userRoleId, firstName, lastName, phoneNumber, email,
						address, company);
				UserInformationDao.insertUserInfo(con, userInfo);

				int userInfoId = UserInformationDao.findUserInfoByEmail(con, email).getId();
				UserAccount user = new UserAccount(userInfoId, username, password);
				UserAccountDao.insertUserAccount(con, user);
				response.sendRedirect("createUser.jsp");
			} else {
				request.setAttribute("errorMess", ERROR_MESS);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createUser.jsp");
				dispatcher.forward(request, response);
			}
		} else if (request.getParameter("reset") != null) {
			response.sendRedirect("createUser.jsp");
		}
		DataAccess.closeQuietly(con);
	}

}
