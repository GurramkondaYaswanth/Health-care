package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.DoctorAppointment;
import Model.DoctorAppointmentStatus;
import Utility.ConnectionManager;
import controller.DoctorAppointmentController;
import controller.ServiceControllerEmployee;
import controller.ServicesControllerCust;

public class DoctorAppointmentDao implements DoctorAppointmentDaoInterface{
	Scanner sc = new Scanner(System.in);
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	ServicesControllerCust SCC = new ServicesControllerCust();
	
	@Override
	public List<DoctorAppointment> ViewDoctorAppointments() throws SQLException {  // View Doctor Appointments
         List<DoctorAppointment> list=new ArrayList<DoctorAppointment>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(" SELECT * from Doctor_appointment");
		int d =1;
		System.out.println();
		System.out.println("   Appointment-ID  Customer-ID  Appointment date   Appointment time   Problem ");
		while(rs.next())
		{
			String AppId = rs.getString(1);
			String CusId = rs.getString(2);
			String date = rs.getString(3);
			String time = rs.getString(4);
			String problem = rs.getString(5);
			
			int spaces = 19- (date.length());  
			int spaces1 = 19- (time.length()); 
			
			for(int i=0; i<spaces; i++) 
				date = date + " "; 
			
			for(int i=0; i<spaces1; i++) 
				time = time + " "; 
			
			String App = d+". "+AppId+"      "+CusId+"   "+date+time+problem;
			d++;
			System.out.println(App);
			
		}
		return list;
	}
	
	public List<String> ViewDoctorAppointmentsCust(String CusId) throws SQLException {
        List<String> list=new ArrayList<String>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * from Doctor_appointment");
		
		int d =1;
		System.out.println();
		System.out.println("   Appointment-ID  Customer-ID  Appointment date   Appointment time   Problem ");
		while(rs.next())
		{
			if(rs.getString(2).equals(CusId)) {
			String AppId = rs.getString(1);
			
			String date = rs.getString(3);
			String time = rs.getString(4);
			String problem = rs.getString(5);
			
			int spaces = 19- (date.length());  
			int spaces1 = 19- (time.length()); 
			
			for(int i=0; i<spaces; i++) 
				date = date + " "; 
			
			for(int i=0; i<spaces1; i++) 
				time = time + " "; 
			
			String App = d+". "+AppId+"      "+CusId+"   "+date+time+problem;
			d++;
			System.out.println(App);
			list.add(AppId);
			}
			
		}
		return list;
	}
	
	public List<String> ViewDoctorAppointmentsStatusCust(String CusId) throws SQLException {  //View Doctor Appointments Status
        List<String> list=new ArrayList<String>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * from Doctor_appointment_status");
		
		int d =1;
		System.out.println();
		System.out.println("   Appointment-ID  Customer-ID  Appointment-timing ");
		while(rs.next())
		{
			if(rs.getString(2).equals(CusId)) {
			String AppId = rs.getString(1);
			
			String time = rs.getString(3);
			
			
			String App = d+". "+AppId+"      "+CusId+"   "+time;
			d++;
			System.out.println(App);
			list.add(AppId);
			}
			
		}
		return list;
	}
	
	public List<String> ViewDoctorAppointmentsCustId(String CusId) throws SQLException {  //view appointments of particular customer
        List<String> list=new ArrayList<String>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * from Doctor_appointment");
		
		int d =1;
//		System.out.println();
//		System.out.println("   Appointment-ID  Customer-ID  Appointment date   Appointment time   Problem ");
		while(rs.next())
		{
			if(rs.getString(2).equals(CusId)) {
			String AppId = rs.getString(1);
			
			String date = rs.getString(3);
			String time = rs.getString(4);
			String problem = rs.getString(5);
			
			int spaces = 19- (date.length());  
			int spaces1 = 19- (time.length()); 
			
			for(int i=0; i<spaces; i++) 
				date = date + " "; 
			
			for(int i=0; i<spaces1; i++) 
				time = time + " "; 
			
			String App = d+". "+AppId+"      "+CusId+"   "+date+time+problem;
			d++;
			//System.out.println(App);
			list.add(AppId);
			}
			
		}
		return list;
	}

	@Override
	public void updateDoctorAppointment(DoctorAppointment doctorappointment) throws SQLException {    //update appointment
		String AppId = doctorappointment.getAppId();
		String CusId = doctorappointment.getCusId();
		String date = doctorappointment.getAppointmentDate();
		String time = doctorappointment.getAppointmentTime();
		String problem = doctorappointment.getProblem();
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement ps = con.prepareStatement("UPDATE Doctor_appointment SET cus_Id = ? ,appointment_date =? ,appointment_time =?, problem=? WHERE appointment_Id = ?");
		
		ps.setString(1, CusId);
		ps.setString(2, date);
		ps.setString(3, time);
		ps.setString(4, problem);
		ps.setString(5, AppId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
		
	}

	@Override
	public void deleteDoctorAppointment(String id) throws SQLException {    //delete appointment
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Doctor_appointment WHERE appointment_Id = ?");
		ps.setString(1, id);
		int status = ps.executeUpdate();
		if(status >0) {
			System.out.println("deleted Successfully..");
		}
		
	}

	@Override
	public DoctorAppointment FilterDoctorAppointment(String id) throws SQLException {   //search appointment
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Doctor_appointment");
		int d =1;
		System.out.println();
		//System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		DoctorAppointment doctorappointment = new DoctorAppointment();
		while(rs.next())
		{
			if(rs.getString(1).equals(id)) {
				doctorappointment.setAppId(rs.getString(1));
				doctorappointment.setCusId(rs.getString(2));
				doctorappointment.setAppointmentDate(rs.getString(3));
				doctorappointment.setAppointmentTime(rs.getString(4));
				doctorappointment.setProblem(rs.getString(5));
			}
		}
		
		return doctorappointment;
	}

	@Override
	public void insertDoctorAppointment(DoctorAppointment doctorappointment) throws SQLException {   //add new appointment
		String Insertion = "Insert Into Doctor_appointment (appointment_Id,cus_Id,appointment_date,appointment_time,problem) values (?,?,?,?,?)";

		Connection con = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = con.prepareStatement(Insertion);
		ps.setString(1,doctorappointment.getAppId());
		ps.setString(2,doctorappointment.getCusId());
		ps.setString(3,doctorappointment.getAppointmentDate());
		ps.setString(4,doctorappointment.getAppointmentTime());
		ps.setString(5,doctorappointment.getProblem());
		
		int execution = ps.executeUpdate();
		System.out.println(execution);
		
	}
	
	public void insertDoctorAppointmentStatus(DoctorAppointmentStatus doctorappointmentstatus) throws SQLException {  //add new appointment status
		String Insertion = "Insert Into Doctor_appointment_status (appointment_Id,cus_Id, appointment_timing) values (?,?,?)";

		Connection con = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = con.prepareStatement(Insertion);
		ps.setString(1,doctorappointmentstatus.getAppId());
		ps.setString(2,doctorappointmentstatus.getCusId());
		ps.setString(3,doctorappointmentstatus.getAppointmenttime());

		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Successfully inserted..");
		}
		
	}

	@Override
	public void back() throws SQLException {   //go back
		// TODO Auto-generated method stub
		DoctorAppointmentController DAC = new DoctorAppointmentController();
		
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other Services of Doctor Appointment or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCE.ServicesList();
		}else if(opinion == 2) {
			
		}else if(opinion == 3) {
			System.out.println();
			System.out.println("**********************************************************************Have a great Day*****************************************************************");
		}else {
			System.out.println();
			System.out.println("Invalid Input");
			back();
		}
		
	}

	@Override
	public void backCust() throws SQLException {   //go back
		DoctorAppointmentController DAC = new DoctorAppointmentController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other Services of Doctor Appointment or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCC.ServicesList();
		}else if(opinion == 2) {
			DAC.DoctorAppointmentCust();
		}else if(opinion == 3) {
			System.out.println();
			System.out.println("**********************************************************************Have a great Day*****************************************************************");
		}else {
			System.out.println();
			System.out.println("Invalid Input");
			backCust();
		}
		
	}

}
