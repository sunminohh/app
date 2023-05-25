package web.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.DepartmentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Department;
import vo.Employee;

@WebServlet(urlPatterns = "/dept/emps")
public class DeptEmpListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
		
		// 요청파라미터값 조회하기
		String deptId = req.getParameter("deptid");
		System.out.println("조회요청한 DEPARTMENT_ID " +deptId);
		
		// 요청파라미터로 전달받은 직종아이디의 상세목록 조회하기
		DepartmentDao departmentDao = new DepartmentDao();
		List<Employee> empList = departmentDao.getEmployeesByDeptId(deptId);
		
		// 조회된 직원목록 정보로 동적 HTML 컨텐츠를 생성해서 응답으로 보내기
				PrintWriter out = reps.getWriter();
				out.println("<!doctype html>");
				out.println("<html>");
				out.println("<head>");
				out.println("	<meta charset='utf-8'>");
				out.println("	<title>부서별 사원목록</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("	<h1>부서별 사원목록</h1>");
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
						out.println(" 		<td><a href='emp_detail?empid="+emp.getId()+"'>"+emp.getId()+"</a></td>");
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















