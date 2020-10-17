package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Model.DoctorAppointment;
import Model.DoctorAppointmentStatus;
import dao.DoctorAppointmentDao;
import dao.IdGeneration;

public class DoctorAppointmentController {
	Scanner sc = new Scanner(System.in);
	DoctorAppointmentDao DAD = new DoctorAppointmentDao();
	DoctorAppointment doctorappointment =new DoctorAppointment();
	DoctorAppointmentStatus doctorappointmentstatus = new DoctorAppointmentStatus();
	IdGeneration IG = new IdGeneration(); 
	int i =0;
	//String CusId = "0";
	public void DoctorAppointmentCust() throws SQLException {
//		i++;

		
		System.out.println();
		System.out.println("1.View the Doctor Appointment");
		System.out.println("2.Apply new Doctor Appointment");
		System.out.println("3.Delete Doctor Appointment");
		System.out.println("4.Update Doctor Appointment");
		System.out.println("5.Doctor Appointment Status");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		System.out.print("enter the Cus Id: ");
		String CusId = sc.nextLine();
		
		if(opinion == 1) {   //View the Doctor Appointment
			List<String> list=DAD.ViewDoctorAppointmentsCust(CusId);
			DAD.backCust();
		}else if(opinion == 2) {    //Apply new Doctor Appointment
			//System.out.println();
			String DocAppId = IG.IdGen();
			
//			System.out.print("Customer Id: ");
//			String CusId = sc.nextLine();
			System.out.print("Appointment Date: ");
			String AppDate = sc.nextLine();
			System.out.print("Appointment Time (mention two hrs of interval): ");
			String AppTime = sc.nextLine();
			System.out.print("Problem: ");
			String Problem = sc.nextLine();
			System.out.println("Your appointment Id is: "+DocAppId);
			doctorappointment.setAppId(DocAppId);
			doctorappointment.setCusId(CusId);
			doctorappointment.setAppointmentDate(AppDate);
			doctorappointment.setAppointmentTime(AppTime);
			doctorappointment.setProblem(Problem);
			
			DAD.insertDoctorAppointment(doctorappointment);
			DAD.backCust();
		}else if(opinion == 3) {  //delete
			System.out.println();
			System.out.print("Appointment Id: ");
			String DocAppId = sc.nextLine();
			List<String> list=DAD.ViewDoctorAppointmentsCustId(CusId);
			int p = 0;
			for(int i =0; i<list.size();i++) {
				String appId = list.get(i);
				if(appId.equals(DocAppId)) {
					p++;
					DAD.deleteDoctorAppointment(DocAppId);
					DAD.backCust();
				}
			}
			if(p==0) {
			System.out.println("You can delete only Your appointments");
			DAD.backCust();
			}
		}else if (opinion == 4) {   //update
			System.out.println();
			System.out.print("Appointment Id: ");
			String DocAppId = sc.nextLine();
//			System.out.print("Customer Id: ");
//			String CusId = sc.nextLine();
			System.out.print("Appointment Date: ");
			String AppDate = sc.nextLine();
			System.out.print("Appointment Time: ");
			String AppTime = sc.nextLine();
			System.out.print("Problem: ");
			String Problem = sc.nextLine();
			
			doctorappointment.setAppId(DocAppId);
			doctorappointment.setCusId(CusId);
			doctorappointment.setAppointmentDate(AppDate);
			doctorappointment.setAppointmentTime(AppTime);
			doctorappointment.setProblem(Problem);
			
			DAD.updateDoctorAppointment(doctorappointment);
			DAD.backCust();
		}else if (opinion == 5) {  //appointment status
			DAD.ViewDoctorAppointmentsStatusCust(CusId);
			DAD.backCust();
		}
		else {
			System.out.println("Invalid Input");
			DAD.backCust();
		}
	}
	public void DoctorAppointmentEmp() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Doctor Appointment");
		System.out.println("2.Search the Doctor Appointment");
		System.out.println("3.Doctor Appointment Status updating");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Symptoms
			DAD.ViewDoctorAppointments();
			DAD.back();

		}else if(opinion == 2) { 
			
			System.out.println();
			System.out.print("Enter the Appointment Id: ");
			String AppId = sc.nextLine();
			doctorappointment = DAD.FilterDoctorAppointment(AppId);
			System.out.println();
			System.out.println("Doctor Appointment Id: "+doctorappointment.getAppId());
			System.out.println("Customer Id: "+doctorappointment.getCusId());
			System.out.println("Appointment date: "+doctorappointment.getAppointmentDate());
			System.out.println("Appointment time: "+doctorappointment.getAppointmentTime());
			System.out.println("Problem: "+doctorappointment.getProblem());
			DAD.back();
		}else if(opinion == 3) {  //insert status-
			
			System.out.println();
			
			
			System.out.print("Customer Id: ");
			String CusId = sc.nextLine();
			System.out.print("Appointment Id: ");
			String AppId = sc.nextLine();
			System.out.print("Appointment Time: ");
			String AppTime = sc.nextLine();
			
			doctorappointmentstatus.setAppId(AppId);
			doctorappointmentstatus.setCusId(CusId);
			doctorappointmentstatus.setAppointmenttime(AppTime);
			
			DAD.insertDoctorAppointmentStatus(doctorappointmentstatus);
			DAD.back();
		}else{
			System.out.println("Invalid Input");
			DAD.back();
		}
	}
	 
}
