import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteServlet extends CommonServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File file = new File("data/"+req.getParameter("id"));
	    file.delete();
		resp.sendRedirect(this.getBaseUrl(req));
	}
}