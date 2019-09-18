import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateServlet extends CommonServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();// get the stream to write the data
		header(req, res, pw);
		nav(req, res, pw);
		
		String id = req.getParameter("id");
		File file = new File("data/"+id); 		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		String content = "";
		while ((st = br.readLine()) != null) {
			System.out.println(st); 
			content = content + st;	
		}
		pw.println("<form action=\"update\" method=\"post\">"
				+ "<input type=\"hidden\" name=\"id\" value=\""+id+"\">"
				+ "<p><input type=\"text\" name=\"title\" placeholder=\"title\" value=\""+id+"\"></p>"
				+ "<p><textarea name=\"description\" placeholder=\"description\">"+content+"</textarea></p>"
				+ "<p><input type=\"submit\" value=\"create\"></p>"
				+ "</form>");
		footer(req, res, pw);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
	    String title = req.getParameter("title");
	    String description = req.getParameter("description");
	    System.out.println(title);
	    System.out.println(description);
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/"+title));
	    writer.write(description);
	    writer.close();
	    File file = new File("data"+id);
	    file.delete();
		resp.sendRedirect(this.getBaseUrl(req)+"?id="+title);
	}
}