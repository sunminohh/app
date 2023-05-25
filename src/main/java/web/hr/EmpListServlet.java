package web.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Employee;

@WebServlet(urlPatterns = "/emp/list")
public class EmpListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
		
		//  전체 직원목록 조회하기
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> empList = employeeDao.getEmployees();
		
		PrintWriter out = reps.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8'>");
		out.println("	<title>전체 사원목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>전체 사원목록</h1>");
		out.println("	<table border='1'>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>직원아이디</th>");
		out.println("				<th>이름</th>");
		out.println("				<th>직종아이디</th>");
		out.println("				<th>입사일</th>");
		out.println("				<th>전화번호</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		
		if (empList.isEmpty()) {
			out.println("       <tr>");
			out.println("       	<td colspan='5'>직원이 존재하지 않습니다.</td>");
			out.println("       </tr>");
		} else {
			for (Employee emp : empList) {
				out.println(" 	<tr>");
				out.println(" 		<td><a href='detail?empid="+emp.getId()+"'>"+emp.getId()+"</a></td>");
				out.println(" 		<td>"+emp.getFirstName()+" "+emp.getLastName()+"</td>");
				out.println(" 		<td>"+emp.getJobId()+"</td>");
				out.println(" 		<td>"+emp.getHireDate()+"</td>");
				out.println(" 		<td>"+emp.getPhoneNumber()+"</td>");
				out.println(" 	</tr>");
			}
		}
		
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}
	
}








