package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Model.Customer;
import Model.Employee;
import dao.ProfileDao;

public class ProfileController {
	Scanner sc = new Scanner(System.in);
	ProfileDao PD = new ProfileDao();
	Employee employee = new Employee();
	Customer customer = new Customer();
	public void ProfileCust() throws SQLException {
	
		System.out.println();
		System.out.println("1.View Profile");
		System.out.println("2.Update Profile");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		
		if(opinion == 1) {   //View the profile
			System.out.println();
			System.out.print("Your Password: ");
			String CusPass = sc.nextLine();
			
			System.out.println();
			customer = PD.FilterCusMyProfile(CusPass);
			System.out.println("Customer Id: "+customer.getCusId());
			System.out.println("Customer Name: "+customer.getName());
			System.out.println("Customer Email: "+customer.getEmail());
			System.out.println("Customer Phone Number: "+customer.getPhoneNumber());
			PD.backCust();
		}else if(opinion == 2) {    //update profile
			System.out.println();
			
			
			System.out.print("Customer Id: ");
			String CusId = sc.nextLine();
			System.out.print("Password: ");
			String pass = sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.println("Phone Number: ");
			Long phno = sc.nextLong();
			
			customer.setCusId(CusId);
			customer.setEmail(email);
			customer.setName(name);
			customer.setPassword(pass);
			customer.setPhoneNumber(phno);
			
			PD.updateProfile(customer);
			PD.backCust();
			
		}
		else {
			System.out.println("Invalid Input");
			PD.backCust();
		}
	}
	
	
	public void ProfileEmp() throws SQLException {   //for employee
		System.out.println();
		System.out.println("1.View all the Employee Profiles");
		System.out.println("2.View all the Customer Profiles");
		System.out.println("3.Search/filter the Employee Profiles");
		System.out.println("4.Search/filter the Customer Profiles");
		System.out.println("5.Update your Profile");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Employee Profiles
			PD.ViewDoctorProfiles();
			PD.back();

		}else if(opinion == 2) { //View all the Customer Profiles
			
			PD.ViewCustomerProfiles();
			PD.back();
		}else if(opinion == 3) {  //Search/filter the Employee Profiles
			
			System.out.println();
			System.out.print("Employee Id: ");
			String EmpId = sc.nextLine();
			
			System.out.println();
			employee = PD.FilterEmpProfile(EmpId);
			System.out.println("Employee Id: "+employee.getEmpId());
			System.out.println("Employee Name: "+employee.getName());
			System.out.println("Employee Email: "+employee.getEmail());
			System.out.println("Employee Phone Number: "+employee.getPhoneNumber());
			PD.back();
		}else if(opinion == 4) {  //Search/filter the Employee Profiles
			
			System.out.println();
			System.out.print("Customer Id: ");
			String CusId = sc.nextLine();
			
			System.out.println();
			customer = PD.FilterCusProfile(CusId);
			System.out.println("Customer Id: "+customer.getCusId());
			System.out.println("Customer Name: "+customer.getName());
			System.out.println("Customer Email: "+customer.getEmail());
			System.out.println("Customer Phone Number: "+customer.getPhoneNumber());
			PD.back();
		}else if(opinion == 5) {    //update profile
			System.out.println();
			
			
			System.out.print("Employee Id: ");
			String empId = sc.nextLine();
			System.out.print("Password: ");
			String pass = sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.println("Phone Number: ");
			Long phno = sc.nextLong();
			
			employee.setEmpId(empId);
			employee.setEmail(email);
			employee.setName(name);
			employee.setPassword(pass);
			employee.setPhoneNumber(phno);
			
			PD.updateProfileemp(employee);;
			PD.back();
		}else{
			System.out.println("Invalid Input");
			PD.back();
		}
	}

}
