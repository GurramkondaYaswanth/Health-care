package controller;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Precautions;
import Model.Symptoms;
import dao.IdGeneration;
import dao.PrecautionsDao;
import dao.SymptomsDao;

public class PrecautionsController {
	Scanner sc = new Scanner(System.in);
	IdGeneration IG = new IdGeneration(); 
	Precautions precautions = new Precautions();
	PrecautionsDao PD = new PrecautionsDao();
	
	public void precautionsCust() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Diseases Precautions");
		System.out.println("2.Search/filter the Disease Precautions");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Precautions
			PD.ViewDiseasesPrecautions();
			PD.backCust();
		}else if(opinion == 2) {    //Search/filter the Disease Precautions
			System.out.println();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			
			System.out.println();
			System.out.println("Precautions of the disease with diease Id "+DisId+" : ");
			precautions = PD.FilterDiseasePrecautions(DisId);
			PD.backCust();
		}else {
			System.out.println("Invalid Input");
			PD.backCust();
		}
		
	}
	
	public void precautionsEmp() throws SQLException {
		System.out.println();
		System.out.println("1.View all the Diseases precautions");
		System.out.println("2.Add New Disease precautions");
		System.out.println("3.Update the Disease precautions");
		System.out.println("4.Delete the Disease precautions");
		System.out.println("5.Search/filter the Disease precautions");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Symptoms
			PD.ViewDiseasesPrecautions();
			PD.back();
		}else if(opinion == 2) {   //add new diseases Symptoms
			System.out.println();
			String PreId = IG.IdGen();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			System.out.print("precaution : ");
			String precaution = sc.nextLine();
			
			precautions.setPreCautionId(PreId);
			precautions.setDisId(DisId);
			precautions.setPrecaution(precaution);
			
			PD.insertDiseasePrecautions(precautions);
			PD.back();
			
		}else if(opinion == 3) {      //Update the Disease Precaution Information
			System.out.println();
			System.out.print("Precaution Id: ");
			String PreId = sc.nextLine();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			System.out.print("precaution : ");
			String precaution = sc.nextLine();
			
			precautions.setPreCautionId(PreId);
			precautions.setDisId(DisId);
			precautions.setPrecaution(precaution);
			
			PD.updateDiseasePrecautions(precautions);
			PD.back();
		}else if(opinion == 4) {  //Delete the Disease Precaution Information
			System.out.println();
			System.out.print("Precaution Id: ");
			String PreId = sc.nextLine();
			PD.deleteDiseasePrecautions(PreId);
			PD.back();
		}else if(opinion == 5) {    //Search/filter the Disease Information
			System.out.println();
			System.out.print("Disease Id: ");
			String DisId = sc.nextLine();
			
			System.out.println();
			System.out.println("Precautions of the disease with diease Id "+DisId+" : ");
			precautions = PD.FilterDiseasePrecautions(DisId);
			
			PD.back();
		}else {
			System.out.println("Invalid Input");
			PD.back();
		}
		
	}

}
