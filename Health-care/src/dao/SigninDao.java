package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Customer;
import Model.Employee;
import Utility.ConnectionManager;

public class SigninDao implements SigninDaoInterface{
	public boolean Customerlogin(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("login verification boolean");
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM HC_CUSTOMERS");
		//System.out.println("sql table select ....");
		while(rs.next())
		{
			String email = rs.getString(3);
			String password = rs.getString(4);
//			System.out.println("sql table ....");
//			System.out.println(email);
//			System.out.println(password);
//			System.out.println(customer.getEmail());
//			System.out.println(customer.getPassword());
			if(email.equalsIgnoreCase(customer.getEmail()) && password.equals(customer.getPassword())) {
				System.out.println("Credenentials Matching");
				return true;
			}
		}
		
		return false;
	}
	
	public boolean Employeelogin(Employee employee) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM HC_EMPLOYEES");
		//System.out.println("sql table select ....");
		while(rs.next())
		{
			String email = rs.getString(3);
			String password = rs.getString(4);
			//System.out.println("sql table ....");
			//System.out.println(email);
			if(email.equalsIgnoreCase(employee.getEmail()) && password.equals(employee.getPassword())) {
				System.out.println("Credenentials Matching");
				return true;
			}
		}
		
		return false;
		
	}
	

}
