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

@WebServlet(urlPatterns = "/dept/list")
public class DeptListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
		
		// 전체 부서목록 조회하기
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> deptList = departmentDao.getDepartments();
		
		PrintWriter out = reps.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8'>");
		out.println("	<title>전체 부서목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>전체 부서목록</h1>");
		out.println("	<table border='1'>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>부서아이디</th>");
		out.println("				<th>부서이름</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		
		if (deptList.isEmpty()) {
			out.println("       <tr>");
			out.println("       	<td colspan='2'>부서가 존재하지 않습니다.</td>");
			out.println("       </tr>");
		} else {
			for (Department dept : deptList) {
				out.println(" 	<tr>");
				out.println("		<td><a href='emps?deptid="+dept.getId()+"'>"+dept.getId()+"</a></td>");
				out.println("		<td>"+dept.getName()+"</td>");
				out.println(" 	<tr>");
			}
		}
		
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}
}


















