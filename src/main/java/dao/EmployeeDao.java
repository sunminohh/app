package dao;

import java.security.interfaces.RSAKey;
import java.util.List;

import util.DaoHelper;
import vo.Employee;

public class EmployeeDao {

	public List<Employee> getEmployeesByJobId(String jobId) {
		
		return DaoHelper.selectList("empDao.getEmployeesByJobId", rs -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setHireDate(rs.getDate("hire_date"));
			
			return emp;
		}, jobId);
		
	}
	
	public List<Employee> getEmployees() {
		
		return DaoHelper.selectList("empDao.getEmployees", rs -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			
			return emp;
		});
		
	}
	
	public List<Employee> getEmployeeById(String employeeId) {
		
		return DaoHelper.selectList("empDao.getEmployeeById", rs -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			return emp;
		}, employeeId);
		
	}
}









