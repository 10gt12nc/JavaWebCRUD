package tw.com.lin.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Wrapper extends HttpServletRequestWrapper {

	public Wrapper(HttpServletRequest request) {
		super(request);
	}

	private String strs[] = { "幹" };
	
	@Override
	public String getParameter(String context) {

		String val = context;

		for (String s : strs) {

			if (context.contains(s)) {

				val = context.replace(s, "*");
			}
		}
		return val;
	}

}
