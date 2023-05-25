package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reqPost")
public class ReqPostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email= req.getParameter("email");
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>getParameter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>요청파라미터값 조회하기</h1>");
		out.println("<p>이름 : " +name+ "</p>");
		out.println("<p>연락처 : "+tel+" </p>");
		out.println("<p>이메일 : "+email+" </p>");
		out.println("</body>");
		out.println("</html>"); 
		
	}
}
