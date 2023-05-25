package dao;

import java.util.List;

import util.DaoHelper;
import vo.Department;
import vo.Employee;

public class DepartmentDao {

	public List<Department> getDepartments() {
		
		return DaoHelper.selectList("depDao.getDepartments", rs -> {
			Department dept = new Department();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			
			return dept;
		});
	}
	
	public List<Department> getDepartmentById(String departmentId) {
		
		return DaoHelper.selectList("depDao.getDepartmentById", rs -> {
			Department dept = new Department();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			
			return dept;
		}, departmentId);
	}
	
	public List<Employee> getEmployeesByDeptId(String departmentId) {
		
		return DaoHelper.selectList("depDao.getEmployeesByDeptId", rs -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			
			return emp;
		}, departmentId);
	}
}















