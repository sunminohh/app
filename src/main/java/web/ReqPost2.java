package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reqPost2")
public class ReqPost2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String companyName = req.getParameter("companyName");
		int price = Integer.parseInt(req.getParameter("price"));
		int discountPrice = Integer.parseInt(req.getParameter("discountPrice")); 
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		int expectedTotalSellPrice = price*amount;
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>getParameter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>요청파라미터값 조회하기</h1>");
		out.println("<p>상품명 : " +name+ "</p>");
		out.println("<p>제조사 : "+companyName+" </p>");
		out.println("<p>가격 : "+price+" </p>");
		out.println("<p>할인가격 : "+discountPrice+" </p>");
		out.println("<p>입고수량 : "+amount+" </p>");
		out.println("<p>총판매액 : "+expectedTotalSellPrice+" </p>");
		out.println("</body>");
		out.println("</html>"); 
	}
}






