package dao;

import java.sql.SQLException;

import Model.Customer;
import Model.Employee;

interface SigninDaoInterface {
	 boolean Customerlogin(Customer customer) throws SQLException;
	 boolean Employeelogin(Employee employee) throws SQLException;
	 
}
