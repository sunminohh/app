package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reqGet2")
public class ReqGet2Servlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchOption = req.getParameter("opt");
		String searchKeyword = req.getParameter("keyword");
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>getParameter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>요청파라미터값 조회하기</h1>");
		out.println("<p>검색옵션 : " +searchOption+ "</p>");
		out.println("<p>키워드 : "+searchKeyword+" </p>");
		out.println("</body>");
		out.println("</html>"); 
	}
}
