package web.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.JobDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Job;

/*
 * http://localhost/app/job/list 요청을 처리하는 서블릿 클래스이다.
 *  요청 URL - /app/job/list
 *  요청 파라미터 = 없음
 */
@WebServlet(urlPatterns = "/job/list")
public class JobListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JobDao jobDao = new JobDao();
		List<Job> jobList = jobDao.getJobs();
		
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>직종 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>전체 직종 목록</h1>");
		out.println("	<table border='1'>");
		out.println("		<thead>");
		out.println("			<tr>");
		out.println("				<th>아이디</th>");
		out.println("				<th>직종</th>");
		out.println("				<th>최소급여</th>");
		out.println("				<th>최대급여</th>");
		out.println("			</tr>");
		out.println("		</thead>");
		out.println("		<tbody>");
		for (Job job : jobList) {
			
			out.println("			<tr>");
			out.println("				<td><a href='emps?jid="+job.getId()+"'>"+job.getId()+"</a></td>");
			out.println("				<td>"+job.getTitle()+"</td>");
			out.println("				<td>"+job.getMinSalary()+"</td>");
			out.println("				<td>"+job.getMaxSalary()+"</td>");
			out.println("			</tr>");
			
		}
		out.println("		</tbody>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");


	}
}











