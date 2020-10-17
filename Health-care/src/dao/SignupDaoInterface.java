package dao;

import java.sql.SQLException;

import Model.Customer;
import Model.Employee;

interface SignupDaoInterface {
	int CustomerSignUp(Customer customer) throws SQLException;
	int EmployeeSignUp(Employee employee) throws SQLException;
}
