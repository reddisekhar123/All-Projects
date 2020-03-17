package sekhar_Jdbc;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeImpl implements EmployeeDao {

	private DataSource dataSource;
	
	public void setDataSource(DataSource  dataSource) {
		this.dataSource= dataSource;
	}
	@Override
	public Employee1 findEmployeeById(int empId) {
		Employee1 emp=null;
		String query="select * from CompanyS where empId=?";
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet resultSet=null;
		
		try {
			con=dataSource.getConnection();
			prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1,empId);
			resultSet=prepStmt.executeQuery();
			emp=new Employee1();
			while(resultSet.next()) {
				emp.setEmpId(empId);
			emp.setName(resultSet.getString("empname"));
			emp.setSalary(resultSet.getInt("salary"));
			emp.setDept(resultSet.getString("dept"));
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet !=null)resultSet.close();
				if(prepStmt !=null)prepStmt.close();
			}catch(Exception ex) {}
		}
		return emp;
	}
	
}
