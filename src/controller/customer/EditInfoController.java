package controller.customer;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DataProcess;
import dao.DataAccess;
import dao.RoleDao;
import dao.UserInformationDao;
import model.UserInformation;

@WebServlet("/editInfo")
public class EditInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditInfoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataProcess.setFont(request, response);
		int userId = Integer.parseInt(request.getParameter("userInfoId"));
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
			UserInformation user = new UserInformation(userRoleId, firstName, lastName, phoneNumber, email, address,
					company);
			UserInformationDao.updateUserInfo(con, userId, user);
		} else if (request.getParameter("reset") != null) {
			//response.sendRedirect("/production/admin_create.jsp");
		}
		DataAccess.closeQuietly(con);

	}

}
