package controller;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Customer;
import dao.AboutDiseasesDao;

public class ServiceControllerEmployee {
	Scanner sc = new Scanner(System.in);
	public void ServicesList() throws SQLException {
		System.out.println("*****************************************************Health Care Services*********************************************************");
		System.out.println();
		System.out.println("1.About the diseases");
		System.out.println("2.Symptoms of the disease");
		System.out.println("3.Precautions for a disease");
		System.out.println("4.Doctor Appointments");
		//System.out.println("5.Reviews");
		System.out.println("5.Medicine Order");
		System.out.println("6.Profile");
		System.out.println("7.All Disease Id's and Disease Name");
		System.out.println("");
		System.out.print("Enter the service serial number that you want to access:");
		int serviceNumber = sc.nextInt();  //input
		
		if(serviceNumber == 1) {
			AboutDiseases AD= new AboutDiseases();
			AD.DiseasesEmp();
		}else if(serviceNumber == 2) {
			SymptomsController SC = new SymptomsController();
			SC.SymptomsEmp();
		}else if(serviceNumber == 3) {
			PrecautionsController PC = new PrecautionsController();
			PC.precautionsEmp();
		}else if(serviceNumber == 4) {
			DoctorAppointmentController DAC = new DoctorAppointmentController();
			DAC.DoctorAppointmentEmp();
		}else if(serviceNumber == 6) {
			ProfileController PC = new ProfileController();
			PC.ProfileEmp();
		}else if(serviceNumber == 5) {
			MedicineOrderController MOC = new MedicineOrderController();
			MOC.MedicineOrderEmp();
		}else if(serviceNumber == 7) {
			AboutDiseasesDao ADD = new AboutDiseasesDao();
			ADD.ViewDiseasesId();
			ServicesList();
		}
		
	}

}
