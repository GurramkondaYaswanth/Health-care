package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.Customer;
import Model.Employee;
import Utility.ConnectionManager;
import controller.ProfileController;
import controller.ServiceControllerEmployee;
import controller.ServicesControllerCust;


public class ProfileDao {
	Scanner sc = new Scanner(System.in);
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	ServicesControllerCust SCC = new ServicesControllerCust();
	
	public void ViewDoctorProfiles() throws SQLException {    //view all doctors profile
        //List<DoctorAppointment> list=new ArrayList<DoctorAppointment>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT EMP_Id,EMP_name,EMP_PHONENUMBER,EMP_EMAIL FROM HC_EMPLOYEES");
		int d =1;
		System.out.println();
		System.out.println("   Employee-ID  Employee-Name         Phone Number   Email  ");
		while(rs.next())
		{
			String EmpId = rs.getString(1);
			String name = rs.getString(2);
			String PHno = rs.getString(3);
			String email = rs.getString(4);
			
			
			int spaces = 22- (name.length());  
			
			
			for(int i=0; i<spaces; i++) 
				name = name + " "; 
			
			String profile = d+". "+EmpId+"   "+name+PHno+"     "+email;
			d++;
			System.out.println(profile);
			
		}
	}
	
	public void ViewCustomerProfiles() throws SQLException {   //view all customer profiles
        //List<DoctorAppointment> list=new ArrayList<DoctorAppointment>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT cus_Id,CUS_name,PHONENUMBER,EMAIL FROM HC_CUSTOMERS");
		int d =1;
		System.out.println();
		System.out.println("   Customer-ID  Customer-Name       Phone Number   Email  ");
		while(rs.next())
		{
			String CusId = rs.getString(1);
			String name = rs.getString(2);
			String PHno = rs.getString(3);
			String email = rs.getString(4);
			
			
			int spaces = 20- (name.length());  
			
			
			for(int i=0; i<spaces; i++) 
				name = name + " "; 
			
			String profile = d+". "+CusId+"   "+name+PHno+"     "+email;
			d++;
			System.out.println(profile);
			
		}
	}
	
	public Employee FilterEmpProfile(String id) throws SQLException { //search emp profile
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM HC_EMPLOYEES");
		System.out.println();
		
		Employee employee = new Employee();
		while(rs.next())
		{
			if(rs.getString(1).equals(id)) {
				employee.setEmpId(rs.getString(1));
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setPassword(rs.getString(4));
				employee.setPhoneNumber(rs.getLong(5));
				
			}
		}
		
		return employee;
	}
	
	public Customer FilterCusProfile(String id) throws SQLException {   //search cust profile
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM HC_CUSTOMERS");
		System.out.println();
		
		Customer customer = new Customer();
		while(rs.next())
		{
			if(rs.getString(1).equals(id)) {
				customer.setCusId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setPhoneNumber(rs.getLong(5));
				
			}
		}
		
		return customer;
	}
	
	public Customer FilterCusMyProfile(String password) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM HC_CUSTOMERS");
		System.out.println();
		
		Customer customer = new Customer();
		while(rs.next())
		{
			if(rs.getString(4).equals(password)) {
				customer.setCusId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setPhoneNumber(rs.getLong(5));
				
			}
		}
		
		return customer;
	}
	
	public void updateProfile(Customer customer) throws SQLException {  //update profile
		// TODO Auto-generated method stub
		String CusId = customer.getCusId();
		String name = customer.getName();
		String Email = customer.getEmail();
		Long Phno = customer.getPhoneNumber();
		String password = customer.getPassword();
		
		Connection con = ConnectionManager.getConnection();
		//System.out.println(name);
		//access the string
		PreparedStatement ps = con.prepareStatement("UPDATE HC_CUSTOMERS SET  CUS_name= ?, EMAIL=?, PASSWORD =?,PHONENUMBER = ? WHERE cus_Id = ?");
		ps.setString(1, name);
		ps.setString(2, Email);
		ps.setString(3, password);
		ps.setLong(4,Phno );
		ps.setString(5, CusId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
	}
	
	
	public void updateProfileemp(Employee employee) throws SQLException {  //update profile
		// TODO Auto-generated method stub
		String EmpId = employee.getEmpId();
		String name = employee.getName();
		String Email = employee.getEmail();
		Long Phno = employee.getPhoneNumber();
		String password = employee.getPassword();
		
		Connection con = ConnectionManager.getConnection();
		//System.out.println(name);
		//access the string
		PreparedStatement ps = con.prepareStatement("UPDATE HC_EMPLOYEES SET  EMP_name= ?, EMP_EMAIL=?, EMP_PASSWORD =?,EMP_PHONENUMBER = ? WHERE EMP_Id = ?");
		ps.setString(1, name);
		ps.setString(2, Email);
		ps.setString(3, password);
		ps.setLong(4,Phno );
		ps.setString(5, EmpId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
	}
	
	public void back() throws SQLException {   //go back for emp
		// TODO Auto-generated method stub
		ProfileController PC = new ProfileController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of profile or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCE.ServicesList();
		}else if(opinion == 2) {
			PC.ProfileEmp();
		}else if(opinion == 3) {
			System.out.println();
			System.out.println("**********************************************************************Have a great Day*****************************************************************");
		}else {
			System.out.println();
			System.out.println("Invalid Input");
			back();
		}
		
	}
	
	public void backCust() throws SQLException {   //go back for cust
		// TODO Auto-generated method stub
		ProfileController PC = new ProfileController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of profile or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		try {
			if(opinion == 1) {
				SCC.ServicesList();
			}else if(opinion == 2) {
				PC.ProfileCust();
			}else if(opinion == 3) {
				System.out.println();
				System.out.println("**********************************************************************Have a great Day*****************************************************************");
			}else {
				System.out.println();
				System.out.println("Invalid Input");
				backCust();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
