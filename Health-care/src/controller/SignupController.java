package controller;

import java.sql.SQLException;
import java.util.Scanner;

import Businesslogic.RegistrationValidations;
import Model.Customer;
import Model.Employee;
import dao.IdGeneration;
import dao.SignupDao;

public class SignupController {
	Scanner sc = new Scanner(System.in);
	RegistrationValidations  RV = new  RegistrationValidations();
	ServicesControllerCust SCC = new ServicesControllerCust();
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	SignupDao SUD = new SignupDao();
	IdGeneration IG = new IdGeneration();
	public void signUpCustomer() throws SQLException {  //taking the details of the customer
		System.out.println();
		System.out.println("Create Account");
		System.out.println();
		 System.out.print("Your Name: ");
		 String name = sc.nextLine();
		System.out.print("Enter your email id: ");
		String email = sc.nextLine();
		System.out.print("Enter the Password: ");
	    String password = sc.nextLine();
	    System.out.print("Mobile Number: ");
	    long phoneNumber = sc.nextLong();
	   if(RV.checkUserDetails(email, password)) {
	    String CusId = IG.IdGen();
	    System.out.println();
	    System.out.println("Your ID is "+CusId);
	    System.out.println("Please take note of your Customer ID");
	    Customer customer = new Customer();   //encapsulating the data
	    customer.setEmail(email);
	    customer.setPassword(password);
	    customer.setCusId(CusId);
	    customer.setPhoneNumber(phoneNumber);
	    customer.setName(name);
	    int executionNum = SUD.CustomerSignUp(customer);
	    if(executionNum > 0) {
	    	SCC.ServicesList();
	    }
	   }
	}
	
	public void signUpEmployee() throws SQLException {       //taking the details of the Employee for new account
		System.out.println();
		System.out.println("Create Account");
		System.out.println();
		 System.out.print("Your Name: ");
		 String name = sc.nextLine();
		System.out.print("Enter your email id: ");
		String email = sc.nextLine();
		System.out.print("Enter the Password: ");
	    String password = sc.nextLine();
	    System.out.print("Mobile Number: ");
	    long phoneNumber = sc.nextLong();
	    if(RV.checkUserDetails(email, password)) {
	    String EmpId = IG.IdGen();
	    System.out.println();
	    System.out.println("Your Employee ID is "+EmpId);
	    System.out.println("Please take note of your Employee ID");
	    Employee employee = new Employee();   //encapsulating the data
	    employee.setEmail(email);
	    employee.setPassword(password);
	    employee.setEmpId(EmpId);
	    employee.setPhoneNumber(phoneNumber);
	    employee.setName(name);
	    
	    int executionNum = SUD.EmployeeSignUp(employee);
	    if(executionNum > 0) {
	    	SCE.ServicesList();
	    }
	    }
		
	}
}
