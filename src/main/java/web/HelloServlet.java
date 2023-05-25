package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init()이 실행됨...");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 실행됨...");
	}
	
	@Override  // main의 역할
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(request, response) 실행됨..."); 
		
		// 응답 컨텐츠 제공하기
		PrintWriter out = resp.getWriter(); 
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("</body>");
		out.println("<html>"); 
		
	}
	
	
}











