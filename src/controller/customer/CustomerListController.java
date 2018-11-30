package controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import dao.UserInformationDao;
import model.UserInformation;

@WebServlet("/customerList")
public class CustomerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static int userRoleId = 1;

	public CustomerListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = DataAccess.getConnection();
		List<UserInformation> userInfoList = UserInformationDao.getAllUserInfo(con);
		DataAccess.closeQuietly(con);
		request.setAttribute("userInfoList", userInfoList);
		request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*String name = request.getParameter("name");
		Connection con = DataAccess.getConnection();
		List<UserInformation> userInfoList = UserInformationDao.searchUserInfo(con, name, userRoleId);
		DataAccess.closeQuietly(con);
		request.setAttribute("userInfoList", userInfoList);

		request.getRequestDispatcher("listCustomer.jsp").forward(request, response);*/
	}

}
