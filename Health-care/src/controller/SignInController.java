package controller;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Customer;
import Model.Employee;
import dao.SigninDao;

public class SignInController {
	Scanner sc = new Scanner(System.in);
	SigninDao SD = new SigninDao();
	ServicesControllerCust SCC = new ServicesControllerCust();
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	public void signInCustomer() throws SQLException {
		System.out.println();
		System.out.println("login Credentials");   //taking credentials from user
		System.out.print("Enter your email id: ");
		String email = sc.nextLine();
		System.out.print("Enter the Password: ");
	    String password = sc.nextLine();
	    Customer customer = new Customer();
	    customer.setEmail(email);
	    customer.setPassword(password);
	    boolean cusLogin =  SD.Customerlogin(customer);	  //calling fxn and checking the credentials
	    if(cusLogin) {
	    	SCC.ServicesList();
	    }else {
	    	System.out.println();
	    	System.out.println("Invalid Credentials");
	    	signInCustomer();
	    }
	}
	
	public void signInEmployee() throws SQLException {
		System.out.println();
		System.out.println("login Credentials");
		System.out.print("Enter your email id: ");  //taking credentials from user
		String email = sc.nextLine();
		System.out.print("Enter the Password: ");
	    String password = sc.nextLine();
	    Employee employee = new Employee();
	    employee.setEmail(email);
	    employee.setPassword(password);
	    boolean empLogin = SD.Employeelogin(employee);  //calling fxn and checking the credentials
	    if(empLogin) {
	    	SCE.ServicesList();  
	    }else {
	    	System.out.println();
	    	System.out.println("Invalid Credentials");
	    	signInEmployee();
	    }
	  
	}
	

}
