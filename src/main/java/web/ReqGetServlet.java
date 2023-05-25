package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reqGet")
public class ReqGetServlet extends HelloServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청파라미터값 조회하기
		// String getParameter(String name) : 지정된 이름의 요청파라미터값을 조회해서 반환한다. 
		
		String paramValue1 = req.getParameter("id");
		String paramValue2 = req.getParameter("page");
		String paramValue3 = req.getParameter("sort");
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>getParameter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>요청파라미터값 조회하기</h1>");
		out.println("<p>아이디 : " +paramValue1+ "</p>");
		out.println("<p>페이지번호 : "+paramValue2+" </p>");
		out.println("<p>정렬방식 : "+paramValue3+" </p>");
		out.println("</body>");
		out.println("</html>"); 
		
	}
}



















