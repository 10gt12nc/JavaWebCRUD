package tw.com.lin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/bbs.jsp")
public class BadLanguage implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		chain.doFilter(request, response);

		String context = request.getParameter("context");

		Wrapper wrapper = new Wrapper(request);

		String str = wrapper.getParameter(context);

		request.setAttribute("str", str);

		System.out.println(str);

	}

}
