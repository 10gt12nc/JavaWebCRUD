package tw.com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.lin.bean.Customer;
import tw.com.lin.dao.CustomerDao;
import tw.com.lin.factory.CustomerFactory;

@WebServlet("/userdata")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserData() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");

		CustomerDao cdao = CustomerFactory.getCustomerDaoFactory();
		List<Customer> cus = cdao.getUserPass(username, email);

		request.setAttribute("cus", cus);
		request.getRequestDispatcher("/userdata.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
