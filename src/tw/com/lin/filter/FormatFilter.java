package tw.com.lin.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/registercheck.jsp")

public class FormatFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");

		List<String> errors = new ArrayList<>();

		FormatMethod fm = new FormatMethod();
		boolean boonlame = fm.validateUsername(username);
		boolean boonlpass = fm.validatePassword(password, password2);
		boolean boonlemail = fm.validateEmail(email);

		if (!boonlame || !boonlpass || !boonlemail) {
			request.setAttribute("message", "未填寫或格式錯誤");
			request.getRequestDispatcher("/register.jsp").forward(request, response);

			errors.add("未填寫或格式錯誤");
			System.out.println(errors);

		} else {
			chain.doFilter(request, response);
			request.getRequestDispatcher("/registercheck.jsp").forward(request, response);

			errors.add("OK");
			System.out.println(errors);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public FormatFilter() {
	}

	public void destroy() {
	}

}
