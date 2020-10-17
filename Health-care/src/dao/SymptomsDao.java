package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Model.Symptoms;
import Utility.ConnectionManager;
import controller.ServiceControllerEmployee;
import controller.ServicesControllerCust;
import controller.SymptomsController;

public class SymptomsDao implements SymptomsDaoInterface{
	Scanner sc = new Scanner(System.in);
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	ServicesControllerCust SCC = new ServicesControllerCust();
	@Override
	public List<Symptoms> ViewDiseasesSymptoms() throws SQLException {    //view all symptomps 
		List<Symptoms> list=new ArrayList<Symptoms>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(" SELECT SYMPTOM_ID,DISEASE_NAME,SYMPTOM_NAME FROM  DISEASE INNER JOIN   SYMPTOMS ON symptoms.disease_id = disease.disease_id ORDER BY DISEASE_NAME");
		int d =1;
		System.out.println();
		System.out.println("   SYMPTOM ID    Disease Name        Symptom Nmae ");
		while(rs.next())
		{
			String SymId = rs.getString(1);
			String DisName = rs.getString(2);
			String Symptom = rs.getString(3);
			
			int spaces = 20- (DisName.length());  
			
			for(int i=0; i<spaces; i++) 
				DisName = DisName + " "; 
			if(d<10) {
			String diseaseBrief = d+". "+SymId+"    "+DisName+Symptom;
			d++;
			System.out.println(diseaseBrief);
			}else {
				String diseaseBrief = d+"."+SymId+"    "+DisName+Symptom;
				d++;
				System.out.println(diseaseBrief);
			}
			
		}
		return list;
	}

	@Override
	public void updateDiseaseSymptoms(Symptoms symptoms) throws SQLException {   //update symptoms
		// TODO Auto-generated method stub
		String SymId = symptoms.getSymId();
		String DisId = symptoms.getDisId();
		String Symptom = symptoms.getSymptom();
		Connection con = ConnectionManager.getConnection();
		//System.out.println(name);
		//access the string
		PreparedStatement ps = con.prepareStatement("UPDATE SYMPTOMS SET DISEASE_ID = ?, SYMPTOM_NAME = ? WHERE SYMPTOM_ID = ?");
		
		ps.setString(1, DisId);
		ps.setString(2, Symptom);
		ps.setString(3, SymId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
		
	}

	@Override
	public void deleteDiseaseSymptoms(String id) throws SQLException {    //delete Symptoms
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM SYMPTOMS WHERE SYMPTOM_ID = ?");
		ps.setString(1, id);
	
		int status = ps.executeUpdate();
		if(status >0) {
			System.out.println("deleted Successfully..");
		}
		
	}

	@Override
	public Symptoms FilterDiseaseSymptoms(String disId) throws SQLException {   //filter symptom
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM SYMPTOMS");
		System.out.println();
		while(rs.next())
		{
			if(rs.getString(2).equals(disId)) {
				System.out.println(rs.getString(3));
			}
		}
		Symptoms symptoms = null;
		return symptoms;
	}

	@Override
	public void insertDiseaseSymptoms(Symptoms symptoms) throws SQLException {   //add symptoms
		String Insertion = "insert into SYMPTOMS (SYMPTOM_ID,DISEASE_ID,SYMPTOM_NAME) VALUES (?,?,?)";

		Connection con = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = con.prepareStatement(Insertion);
		ps.setString(1,symptoms.getSymId());
		ps.setString(2,symptoms.getDisId());
		ps.setString(3,symptoms.getSymptom());
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Successfully inserted..");
		}
		
	}

	@Override
	public void back() throws SQLException {
		// TODO Auto-generated method stub
		SymptomsController SC =new SymptomsController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of Symptoms or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCE.ServicesList();
		}else if(opinion == 2) {
			SC.SymptomsEmp();
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
	public void backCust() throws SQLException {
		// TODO Auto-generated method stub
		SymptomsController SC =new SymptomsController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of Symptoms or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		try {
			if(opinion == 1) {
				SCC.ServicesList();
			}else if(opinion == 2) {
				SC.SymptomsCust();
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
