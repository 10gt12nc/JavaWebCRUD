package tw.com.lin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.lin.dao.CustomerDao;
import tw.com.lin.factory.CustomerFactory;

@WebServlet("/getdatalogin")
public class GetDataLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetDataLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");

		int a = 0;

		CustomerDao cdao = CustomerFactory.getCustomerDaoFactory();
		int a2 = cdao.getPassLogin(username, email, a);

		if (a2 > 0) {

			request.getRequestDispatcher("userdata").forward(request, response);
		} else {
			response.sendRedirect("searchdata.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
