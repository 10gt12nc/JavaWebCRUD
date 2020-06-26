package tw.com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.lin.dao.CustomerDao;
import tw.com.lin.factory.CustomerFactory;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		CustomerDao cdao = CustomerFactory.getCustomerDaoFactory();

		if (password == null || password.isEmpty() || password2 == null || password2.isEmpty() || id == null
				|| id.isEmpty() || !password.equals(password2)) {
			System.out.println("--沒");
			response.sendRedirect("searchdata.jsp");

		} else {
			cdao.updateUser(password, password2, id);
			System.out.println("--有");
			request.getRequestDispatcher("updateOK.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
