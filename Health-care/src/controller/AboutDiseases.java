package controller;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Diseases;
import dao.AboutDiseasesDao;
import dao.IdGeneration;


public class AboutDiseases {
	Scanner sc = new Scanner(System.in);
	AboutDiseasesDao ADD = new AboutDiseasesDao();
	IdGeneration IG = new IdGeneration(); 
	Diseases diseases= new Diseases();
	ViewAllDiseasesController VADC = new ViewAllDiseasesController();
	
	public void DiseasesCust() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Diseases Information");
		System.out.println("2.Search/filter the Disease Information using Disease Id");
		System.out.println("3.Search/filter the Disease Information using Disease name");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Information
			ADD.ViewDiseases();
			ADD.backCust();
		}else if(opinion == 2) {    //Search/filter the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String disId = sc.nextLine();
			//int id = Integer.parseInt(disId);
			diseases = ADD.FilterDisease(disId);
			System.out.println();
			System.out.println("Your Desired Disease Information is: ");
			System.out.println("");
			System.out.println("Disease Id: "+ diseases.getDiseaseId());
			System.out.println("Disease Name: " + diseases.getDiseaseName());
			System.out.println("Origin Date: " + diseases.getOriginDate());
			System.out.println("Origin Place: " + diseases.getOriginPlace());
			System.out.println("Duration of the disease: "+ diseases.getDuration());
			ADD.backCust();
		}else if(opinion == 3) {    //Search/filter using dis name the Disease Information
			System.out.println();
			System.out.print("Disease Name: ");
			String disName = sc.nextLine();
			//int id = Integer.parseInt(disId);
			diseases = ADD.FilterDiseaseUsingName(disName);
			System.out.println();
			System.out.println("Your Desired Disease Information is: ");
			System.out.println("");
			System.out.println("Disease Id: "+ diseases.getDiseaseId());
			System.out.println("Disease Name: " + diseases.getDiseaseName());
			System.out.println("Origin Date: " + diseases.getOriginDate());
			System.out.println("Origin Place: " + diseases.getOriginPlace());
			System.out.println("Duration of the disease: "+ diseases.getDuration());
			ADD.backCust();
		}else {
			System.out.println("Invalid Input");
			ADD.backCust();
		}
		
	}
	
	public void DiseasesEmp() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Diseases Information");
		System.out.println("2.Add New Disease Information");
		System.out.println("3.Update the Disease Information");
		System.out.println("4.Delete the Disease Information");
		System.out.println("5.Search/filter the Disease Information using Disease Id");
		System.out.println("6.Search/filter the Disease Information using Disease name");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Information
			ADD.ViewDiseases();
			ADD.back();
			//VADC.viewAllDiseases();
			//ADD.insertDiseaseInfo(diseases);
		}else if(opinion == 2) {   //add new diseases
			System.out.println();
			String disId = IG.IdGen();
			System.out.print("Disease Name: ");
			String DisName = sc.nextLine();
			System.out.print("Origin Date: ");
			String Date = sc.nextLine();
			System.out.print("Origin Place: ");
			String place = sc.nextLine();
			System.out.print("Duration of the disease: ");
			String Duration = sc.nextLine();
			diseases.setDiseaseId(disId);
			diseases.setDiseaseName(DisName);
			diseases.setDuration(Duration);
			diseases.setOriginDate(Date);
			diseases.setOriginPlace(place);
			ADD.insertDiseaseInfo(diseases);
			ADD.back();
		}else if(opinion == 3) {      //Update the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String disId = sc.nextLine();
			System.out.print("Disease Name: ");
			String DisName = sc.nextLine();
			System.out.print("Origin Date: ");
			String Date = sc.nextLine();
			System.out.print("Origin Place: ");
			String place = sc.nextLine();
			System.out.print("Duration of the disease: ");
			String Duration = sc.nextLine();
			diseases.setDiseaseId(disId);
			diseases.setDiseaseName(DisName);
			diseases.setDuration(Duration);
			diseases.setOriginDate(Date);
			diseases.setOriginPlace(place);
			ADD.updateDiseaseInfo(diseases);
			ADD.back();
		}else if(opinion == 4) {  //Delete the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String disId = sc.nextLine();
			ADD.deleteDiseaseInfo(disId);
			ADD.back();
		}else if(opinion == 5) {    //Search/filter the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String disId = sc.nextLine();
			//int id = Integer.parseInt(disId);
			diseases = ADD.FilterDisease(disId);
			System.out.println();
			System.out.println("Your Desired Disease Information is: ");
			System.out.println("");
			System.out.println("Disease Id: "+ diseases.getDiseaseId());
			System.out.println("Disease Name: " + diseases.getDiseaseName());
			System.out.println("Origin Date: " + diseases.getOriginDate());
			System.out.println("Origin Place: " + diseases.getOriginPlace());
			System.out.println("Duration of the disease: "+ diseases.getDuration());
			ADD.back();
		}else if(opinion == 6) {    //Search/filter using dis name the Disease Information
			System.out.println();
			System.out.print("Disease Name: ");
			String disName = sc.nextLine();
			//int id = Integer.parseInt(disId);
			diseases = ADD.FilterDiseaseUsingName(disName);
			System.out.println();
			System.out.println("Your Desired Disease Information is: ");
			System.out.println("");
			System.out.println("Disease Id: "+ diseases.getDiseaseId());
			System.out.println("Disease Name: " + diseases.getDiseaseName());
			System.out.println("Origin Date: " + diseases.getOriginDate());
			System.out.println("Origin Place: " + diseases.getOriginPlace());
			System.out.println("Duration of the disease: "+ diseases.getDuration());
			ADD.back();
		}else {
			System.out.println("Invalid Input");
			ADD.back();
		}
		
	}

}
