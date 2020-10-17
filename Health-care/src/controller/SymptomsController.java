package controller;

import java.sql.SQLException;
import java.util.Scanner;


import Model.Symptoms;
import dao.IdGeneration;
import dao.SymptomsDao;

public class SymptomsController {
	Scanner sc = new Scanner(System.in);
	IdGeneration IG = new IdGeneration(); 
	SymptomsDao SD = new SymptomsDao();
	Symptoms symptom= new Symptoms();
	public void SymptomsCust() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Diseases Symptoms");
		System.out.println("2.Search/filter the Disease Symptoms");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Symptoms
			SD.ViewDiseasesSymptoms();
			SD.backCust();
		}else if(opinion == 2) {    //Search/filter the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			
			System.out.println();
			System.out.println("Symptoms of the disease with diease Id "+DisId+" : ");
			symptom = SD.FilterDiseaseSymptoms(DisId);
			SD.backCust();
		}else {
			System.out.println("Invalid Input");
			SD.backCust();
		}
		
	}
	
	public void SymptomsEmp() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Diseases Symptoms");
		System.out.println("2.Add New Disease Symptoms");
		System.out.println("3.Update the Disease Symptoms");
		System.out.println("4.Delete the Disease Symptoms");
		System.out.println("5.Search/filter the Disease Symptoms");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Symptoms
			SD.ViewDiseasesSymptoms();
			SD.back();
		}else if(opinion == 2) {   //add new diseases Symptoms
			System.out.println();
			String SymId = IG.IdGen();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			System.out.print("Symptom : ");
			String Symptom = sc.nextLine();
			
			symptom.setSymId(SymId);
			symptom.setDisId(DisId);
			symptom.setSymptom(Symptom);
			SD.insertDiseaseSymptoms(symptom);
			SD.back();
			
		}else if(opinion == 3) {      //Update the Disease Information
			System.out.println();
			System.out.print("Symptom Id: ");
			String SymId = sc.nextLine();
			System.out.print("Disease Id: ");
			String disId = sc.nextLine();
			System.out.print("Symptom : ");
			String Symptom = sc.nextLine();
			
			symptom.setSymId(SymId);
			symptom.setDisId(disId);
			symptom.setSymptom(Symptom);
			SD.updateDiseaseSymptoms(symptom);
			SD.back();
		}else if(opinion == 4) {  //Delete the Disease Information
			System.out.println();
			System.out.print("Symptom Id: ");
			String SymId = sc.nextLine();
			SD.deleteDiseaseSymptoms(SymId);
			SD.back();
		}else if(opinion == 5) {    //Search/filter the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			
			System.out.println();
			System.out.println("Symptoms of the disease with diease Id "+DisId+" : ");
			symptom = SD.FilterDiseaseSymptoms(DisId);

//			System.out.println("");
//			System.out.println("Disease Id: "+ diseases.getDiseaseId());
//			System.out.println("Symptom Name: " + diseases.getDiseaseName());
			
			SD.back();
		}else {
			System.out.println("Invalid Input");
			SD.back();
		}
		
	}

}
