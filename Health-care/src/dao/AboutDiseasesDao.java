package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Diseases;
import Utility.ConnectionManager;
import controller.AboutDiseases;
import controller.ServiceControllerEmployee;
import controller.ServicesControllerCust;


public class AboutDiseasesDao implements AboutDiseasesDaoInterface{
	Diseases diseases = new Diseases();
	Scanner sc = new Scanner(System.in);
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	ServicesControllerCust SCC = new ServicesControllerCust();
	//AboutDiseases AD = new AboutDiseases();
	@Override
	public List<Diseases> ViewDiseases() throws SQLException {   //for viewing all diseases
		List<Diseases> list=new ArrayList<Diseases>();
		
		Connection con = ConnectionManager.getConnection();  //connection establishment
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM DISEASE");  //Sql query
		int d =1;
		System.out.println();
		System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		while(rs.next())
		{
			String disId = rs.getString(1);
			String name = rs.getString(2);
			String date = rs.getString(3);
			String place = rs.getString(4);
			String Duration = rs.getString(5);
			diseases.setDiseaseId(disId);
			diseases.setDiseaseName(name);
			diseases.setDuration(Duration);
			diseases.setOriginDate(date);
			diseases.setOriginPlace(place);
			list.add(diseases);
			
			int spaces = 20- (name.length());  
			int spaces1 = 23 - (date.length());
			int spaces2 = 20- (place.length());
			
			for(int i=0; i<spaces; i++) {
				name = name + " "; 
			}
			for(int j=0; j<spaces1; j++) {
				date = date + " "; 
			}
			for(int k=0; k<spaces2; k++) {
				place = place + " "; 
			}
			
			String diseaseBrief = d+". "+disId+"    "+name+date+place+Duration;
			d++;
			System.out.println(diseaseBrief);
			
		}
		return list;
	}
	
	public List<Diseases> ViewDiseasesId() throws SQLException {
		List<Diseases> list=new ArrayList<Diseases>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT DISEASE_ID,DISEASE_NAME FROM DISEASE ORDER BY DISEASE_NAME");
		int d =1;
		System.out.println();
		System.out.println("   Disease Id    Disease Name");
		while(rs.next())
		{
			String disId = rs.getString(1);
			String name = rs.getString(2);
			diseases.setDiseaseId(disId);
			diseases.setDiseaseName(name);
			
			list.add(diseases);
			
			String diseaseBrief = d+". "+disId+"    "+name;
			d++;
			System.out.println(diseaseBrief);
			
		}
		return list;
	}

	@Override
	public void updateDiseaseInfo(Diseases diseases) throws SQLException {  //updating
		// TODO Auto-generated method stub
		String disId = diseases.getDiseaseId();
		String name = diseases.getDiseaseName();
		String date = diseases.getOriginDate();
		String place = diseases.getOriginPlace();
		String Duration = diseases.getDuration();
		Connection con = ConnectionManager.getConnection();
		//System.out.println(name);
		//access the string
		PreparedStatement ps = con.prepareStatement("UPDATE DISEASE SET DISEASE_NAME = ?, duration= ?, origin_date=?, origin_place =? WHERE disease_id = ?");
		ps.setString(1, name);
		ps.setString(2, Duration);
		ps.setString(3, date);
		ps.setString(4, place);
		ps.setString(5, disId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
	}


	public Diseases FilterDisease(String Id) throws SQLException {  //search
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM DISEASE");
		int d =1;
		System.out.println();
		//System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		while(rs.next())
		{
			if(rs.getString(1).equals(Id)) {
				diseases.setDiseaseId(rs.getString(1));
				diseases.setDiseaseName(rs.getString(2));
				
				diseases.setOriginDate(rs.getString(3));
				diseases.setOriginPlace(rs.getString(4));
				diseases.setDuration(rs.getString(5));
			}
		}
		
		return diseases;
	}
	
	
	public Diseases FilterDiseaseUsingName(String DisName) throws SQLException {  //search based on name
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM DISEASE");
		int d =1;
		System.out.println();
		//System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		while(rs.next())
		{
			if(rs.getString(2).equals(DisName)) {
				diseases.setDiseaseId(rs.getString(1));
				diseases.setDiseaseName(rs.getString(2));
				
				diseases.setOriginDate(rs.getString(3));
				diseases.setOriginPlace(rs.getString(4));
				diseases.setDuration(rs.getString(5));
			}
		}
		
		return diseases;
	}

	@Override
	public void insertDiseaseInfo(Diseases diseases) throws SQLException {   //inserting
		String Insertion = "insert into DISEASE (DISEASE_ID,DISEASE_NAME,ORIGIN_DATE,ORIGIN_PLACE,DURATION) VALUES (?,?,?,?,?)";

		Connection con = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = con.prepareStatement(Insertion);
		ps.setString(1,diseases.getDiseaseId());
		ps.setString(2,diseases.getDiseaseName());
		ps.setString(3,diseases.getOriginDate());
		ps.setString(4,diseases.getOriginPlace());
		ps.setString(5,diseases.getDuration());
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Successfully inserted..");
		}
		
	}

	@Override
	public void deleteDiseaseInfo(String id) throws SQLException {  //deletion
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		//access the string
//		String delete = ;
		PreparedStatement ps = con.prepareStatement("DELETE FROM DISEASE WHERE DISEASE_ID = ?");
		ps.setString(1, id);
	
		int status = ps.executeUpdate();
		if(status >0) {
			System.out.println("deleted Successfully..");
		}
	}
	
	public void back() throws SQLException {    //go back
		AboutDiseases AD = new AboutDiseases();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of Disesase or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCE.ServicesList();
		}else if(opinion == 2) {
			AD.DiseasesEmp();
		}else if(opinion == 3) {
			System.out.println();
			System.out.println("**********************************************************************Have a great Day*****************************************************************");
		}else {
			System.out.println();
			System.out.println("Invalid Input");
			back();
		}
	}
	
	public void backCust() throws SQLException {  //go back
		AboutDiseases AD = new AboutDiseases();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of Disesase or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCC.ServicesList();
		}else if(opinion == 2) {
			AD.DiseasesCust();
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
