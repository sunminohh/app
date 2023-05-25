package web.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Employee;

/*
 * http://localhost/app/job/emps?jid=xxx url 요청을 처리하는 서블릿이다.
 *  - 요청파라미터: jid  
 */
@WebServlet(urlPatterns = "/job/emps")
public class JobEmployeeListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
		
		// 요청파라미터값 조회하기
		String jobId = req.getParameter("jid");
		System.out.println("조회요청한 JOB_ID: " +jobId);
		
		// 요청파라미터로 전달받은 직종아이디에 종사하는 직원목록 조회하기
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> empList = employeeDao.getEmployeesByJobId(jobId);
		
		// 조회된 직원목록 정보로 동적 HTML 컨텐츠를 생성해서 응답으로 보내기
		PrintWriter out = reps.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8'>");
		out.println("	<title>직종별 사원목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>직종별 사원목록</h1>");
		out.println("	<table border='1'>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>직원아이디</th>");
		out.println("				<th>이름</th>");
		out.println("				<th>입사일</th>");
		out.println("				<th>직종아이디</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		
		if (empList.isEmpty()) {
			out.println("       <tr>");
			out.println("       	<td colspan='4'>직원이 존재하지 않습니다.</td>");
			out.println("       </tr>");
		} else {
			for (Employee emp : empList) {
				out.println(" 	<tr>");
				out.println(" 		<td>"+emp.getId()+"</td>");
				out.println(" 		<td>"+emp.getFirstName()+" "+emp.getLastName()+"</td>");
				out.println(" 		<td>"+emp.getHireDate()+"</td>");
				out.println(" 		<td>"+emp.getJobId()+"</td>");
				out.println(" 	</tr>");
			}
		}
		
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}

}















