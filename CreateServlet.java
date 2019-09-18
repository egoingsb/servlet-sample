import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateServlet extends CommonServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();// get the stream to write the dataå
		header(req, res, pw);
		nav(req, res, pw);
		pw.println("<form action=\"create\" method=\"post\">"
				+ "<p><input type=\"text\" name=\"title\" placeholder=\"title\"></p>"
				+ "<p><textarea name=\"description\" placeholder=\"description\"></textarea></p>"
				+ "<p><input type=\"submit\" value=\"create\"></p>"
				+ "</form>");
		footer(req, res, pw);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
	    String description = req.getParameter("description");
	    System.out.println(title);
	    System.out.println(description);
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/"+title));
	    writer.write(description);
	    writer.close();
		resp.sendRedirect(this.getBaseUrl(req));
	}
}