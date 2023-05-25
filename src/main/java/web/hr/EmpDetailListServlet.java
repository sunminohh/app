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

@WebServlet(urlPatterns = "/emp/detail")
public class EmpDetailListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
		
		// 요청파라미터값 조회하기
		String empId = req.getParameter("empid");
		System.out.println("조회요청한 EMPLOYEE_ID" +empId);
		
		// 요청파라미터로 전달받은 직종아이디의 상세목록 조회하기
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> empList = employeeDao.getEmployeeById(empId);
		
		// 조회된 직원목록 정보로 동적 HTML 컨텐츠를 생성해서 응답으로 보내기
				PrintWriter out = reps.getWriter();
				out.println("<!doctype html>");
				out.println("<html>");
				out.println("<head>");
				out.println("	<meta charset='utf-8'>");
				out.println("	<title>사원 상세정보</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("	<h1>사원 상세정보</h1>");
				out.println("	<table border='1'>");
				out.println("		<tbody>");
				
				if (empList.isEmpty()) {
					out.println("       <tr>");
					out.println("       	<td colspan='10'>직원이 존재하지 않습니다.</td>");
					out.println("       </tr>");
				} else {
					for (Employee emp : empList) {
						out.println(" 	<tr>");
						out.println("		<th>직원아이디</th>");
						out.println(" 		<td>"+emp.getId()+"</td>");
						out.println("		<th>이름</th>");
						out.println(" 		<td>"+emp.getFirstName()+" "+emp.getLastName()+"</td>");
						out.println("	</tr>");
						out.println("	<tr>");
						out.println("		<th>이메일</th>");
						out.println(" 		<td>"+emp.getEmail()+"</td>");
						out.println("		<th>전화번호</th>");
						out.println(" 		<td>"+emp.getPhoneNumber()+"</td>");
						out.println("	</tr>");
						out.println("	<tr>");
						out.println("		<th>입사일</th>");
						out.println(" 		<td>"+emp.getHireDate()+"</td>");
						out.println("		<th>직종아이디</th>");
						out.println(" 		<td>"+emp.getJobId()+"</td>");
						out.println("	</tr>");
						out.println("	<tr>");
						out.println("		<th>월급</th>");
						out.println(" 		<td>"+emp.getSalary()+"</td>");
						out.println("		<th>커미션비율</th>");
						out.println(" 		<td>"+emp.getCommissionPct()+"</td>");
						out.println(" 	</tr>");
						out.println("	<tr>");
						out.println("		<th>매니저아이디</th>");
						out.println(" 		<td>"+emp.getManagerId()+"</td>");
						out.println("		<th>부서아이디</th>");
						out.println(" 		<td>"+emp.getDepartmentId()+"</td>");
						out.println(" 	</tr>");
					}
				}
				
				out.println("		</tbody>");
				out.println("	</table>");
				out.println("</body>");
				out.println("</html>");
	}
}
