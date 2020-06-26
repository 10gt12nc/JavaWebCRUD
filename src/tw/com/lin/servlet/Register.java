package tw.com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.lin.bean.Customer;
import tw.com.lin.dao.CustomerDao;
import tw.com.lin.factory.CustomerFactory;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");

		CustomerDao cdao = CustomerFactory.getCustomerDaoFactory();
		Customer cus = new Customer();
		cus.setUsername(username);
		cus.setPassword(password);
		cus.setPassword2(password2);
		cus.setEmail(email);

		cdao.addUser(cus);

		System.out.println(cus.toString());

		cus.setUsername("");
		cus.setUsername("");
		cus.setPassword("");
		cus.setPassword2("");
		cus.setEmail("");

		request.getRequestDispatcher("registerOK.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
