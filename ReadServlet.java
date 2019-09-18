import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadServlet extends CommonServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();// get the stream to write the data
		header(req, res, pw);
		nav(req, res, pw);
		String id = req.getParameter("id");
		if (id == null) {
			pw.println("<h2>Welcome</h2>" + "Welcome!");
		} else {

			BufferedReader br = new BufferedReader(new FileReader("data/" + id));

			// 파일을 한 문장씩 읽어온다.
			String str = br.readLine();
			String content = "";
			// EOF는 null문자를 포함하고 있다.
			while (str != null) {
				content = content + str;
				str = br.readLine();
			}
			pw.println("<h2>" + id + "</h2>" + content);
		}
		footer(req, res, pw);
	}
}