package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import Model.Customer;
import Model.Employee;
import Utility.ConnectionManager;

public class SignupDao implements SignupDaoInterface{

	@Override
	public int CustomerSignUp(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		String CusSignup = "insert into HC_CUSTOMERS(cus_Id,CUS_name,EMAIL,PASSWORD,PHONENUMBER) VALUES (?,?,?,?,?)";

		Connection c = null;
		c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(CusSignup);
		ps.setString(1, customer.getCusId());
		ps.setString(2, customer.getName());
		ps.setString(3,customer.getEmail());
		ps.setString(4,customer.getPassword());
		ps.setLong(5, customer.getPhoneNumber());
		
		int execution = ps.executeUpdate();
		//System.out.println(execution);
		return execution;
		
	}

	@Override
	public int EmployeeSignUp(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		String EmpSignup = "insert into HC_EMPLOYEES(EMP_Id,EMP_name,EMP_EMAIL,EMP_PASSWORD,EMP_PHONENUMBER) VALUES (?,?,?,?,?)";

		Connection c = null;
		c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(EmpSignup);
		ps.setString(1, employee.getEmpId());
		ps.setString(2, employee.getName());
		ps.setString(3, employee.getEmail());
		ps.setString(4, employee.getPassword());
		ps.setLong(5, employee.getPhoneNumber());
		
		int execution = ps.executeUpdate();
		//System.out.println(execution);
		
		return execution;
	}
	


}
