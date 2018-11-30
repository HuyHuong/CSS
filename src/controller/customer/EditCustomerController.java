package controller.customer;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import dao.UserAccountDao;
import dao.UserInformationDao;
import model.UserAccount;
import model.UserInformation;

@WebServlet("/editCus")
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCustomerController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userInfoId = Integer.parseInt(request.getParameter("userInfoId"));
		Connection con = DataAccess.getConnection();
		if (request.getParameter("edit") != null) {
			UserInformation userInfo = UserInformationDao.findUserInfo(con, userInfoId);
			request.setAttribute("userInfoId", userInfoId);
			request.setAttribute("userInfo", userInfo);
			RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("setPass") != null) {
			UserAccount user = UserAccountDao.findUserAccountByUserInfoId(con, userInfoId);
			System.out.println(user.getPassword());
			String password = user.getPassword();

			request.setAttribute("userInfoId", userInfoId);
			request.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("setPassword.jsp");
			rd.forward(request, response);
		}
		DataAccess.closeQuietly(con);
	}

}
