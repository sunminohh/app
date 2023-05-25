package dao;

import java.util.List;

import util.DaoHelper;
import vo.Job;

public class JobDao {

	public List<Job> getJobs() {
		return DaoHelper.selectList("jobDao.getJobs", rs -> {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			
			return job;
		});
	}
}
