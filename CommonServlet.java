
import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class CommonServlet extends HttpServlet {

	public CommonServlet() {
		super();
	}

	public String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
	
	public PrintWriter header(HttpServletRequest req, HttpServletResponse res, PrintWriter pw) {
		res.setContentType("text/html");// setting the content type
		pw.println("<html><body>");
		pw.println("<h1><a href=\""+this.getBaseUrl(req)+"\">WEB Application</a></h1>");
		return pw;
	}
	
	public PrintWriter nav(HttpServletRequest req, HttpServletResponse res, PrintWriter pw) {
		File folder = new File("data");
		String[] files = folder.list();
		pw.println("<ul>");
		for (String file : files)
        {
			pw.println("<li><a href=\""+this.getBaseUrl(req)+"?id="+file+"\">"+file+"</a></li>");
        }
		pw.println("</ul>");
		pw.println("<a href="
				+ "\""+this.getBaseUrl(req)+"/create\">create</a>");
		String id = req.getParameter("id");
		if(id != null) {
			pw.println("<a href="
					+ "\""+this.getBaseUrl(req)+"/update?id="+id+"\">update</a>");
			pw.println("<form action=\""+this.getBaseUrl(req)+"/delete?id="+id+"\" method=\"POST\"><input type=\"submit\" value=\"delete\"></form>");
		}
		return pw;
	}
	
	public PrintWriter footer(HttpServletRequest req, HttpServletResponse res, PrintWriter pw) {
		pw.println("</body></html>");
		pw.close();
		return pw;
	}
}