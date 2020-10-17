package controller;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Customer;
import dao.AboutDiseasesDao;


public class ServicesControllerCust {
	Scanner sc = new Scanner(System.in);

	public void ServicesList() throws SQLException {
		System.out.println("*****************************************************Health Care Services*********************************************************");
		System.out.println();
		System.out.println("1.About the diseases");
		System.out.println("2.Symptoms of the disease");
		System.out.println("3.Precautions for a disease");
		System.out.println("4.Doctor Appointment");
//		System.out.println("5.Reviews");
		System.out.println("5.Medicine Order");
		System.out.println("6.Your Profile");
		System.out.println("7.All Disease Id's and Disease Name");
		System.out.println("");
		System.out.print("Enter the service serial number that you want to access:");
		int serviceNumber = sc.nextInt();
		Customer customer = new Customer();
		//System.out.println(customer.getEmail());
		AboutDiseases AD = new AboutDiseases();
		if(serviceNumber == 1) {
			AD.DiseasesCust();
		}else if(serviceNumber == 2) {
			SymptomsController SC = new SymptomsController();
			SC.SymptomsCust();
		}else if(serviceNumber == 3) {
			PrecautionsController PC = new PrecautionsController();
			PC.precautionsCust();
		}else if(serviceNumber == 4) {
			DoctorAppointmentController DAC = new DoctorAppointmentController();
			DAC.DoctorAppointmentCust();
		}else if(serviceNumber == 6) {
			ProfileController PC = new ProfileController();
			PC.ProfileCust();
		}else if(serviceNumber == 5) {
			MedicineOrderController MOC = new MedicineOrderController();
			MOC.MedicineOrderCust();
		}else if(serviceNumber == 7) {
			AboutDiseasesDao ADD = new AboutDiseasesDao();
			ADD.ViewDiseasesId();
			ServicesList();
		}
		
	}

}
