package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Precautions;
import Model.Symptoms;
import Utility.ConnectionManager;
import controller.PrecautionsController;
import controller.ServiceControllerEmployee;
import controller.ServicesControllerCust;
import controller.SymptomsController;

public class PrecautionsDao implements PrecautionsDaoInterface  {
	Scanner sc = new Scanner(System.in);
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	ServicesControllerCust SCC = new ServicesControllerCust();
	
	@Override
	public List<Precautions> ViewDiseasesPrecautions() throws SQLException {   //view all precuations of disease
		List<Precautions> list=new ArrayList<Precautions>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(" SELECT Precautions_Id,DISEASE_NAME,Precautions FROM  DISEASE INNER JOIN Precautions ON Precautions.disease_id = disease.disease_id ORDER BY DISEASE_NAME");
		int d =1;
		System.out.println();
		System.out.println("   Precaution-ID  Disease Name        Precaution ");
		while(rs.next())
		{
			String PreId = rs.getString(1);
			String DisName = rs.getString(2);
			String Precaution = rs.getString(3);
			
			int spaces = 20- (DisName.length());  
			
			for(int i=0; i<spaces; i++) 
				DisName = DisName + " "; 
			
			if(d<10) {
			String diseaseBrief = d+". "+PreId+"     "+DisName+Precaution;
			d++;
			System.out.println(diseaseBrief);
			}else {
				String diseaseBrief = d+"."+PreId+"     "+DisName+Precaution;
				d++;
				System.out.println(diseaseBrief);
			}
			
		}
		return list;
	}

	@Override
	public void updateDiseasePrecautions(Precautions precautions) throws SQLException {    //update the precautions
		String PreId = precautions.getPreCautionId();
		String DisId = precautions.getDisId();
		String precaution = precautions.getPrecaution();
		Connection con = ConnectionManager.getConnection();
		//System.out.println(name);
		//access the string
		PreparedStatement ps = con.prepareStatement("UPDATE Precautions SET DISEASE_ID = ?, Precautions = ? WHERE Precautions_Id = ?");
		
		ps.setString(1, DisId);
		ps.setString(2, precaution);
		ps.setString(3, PreId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
		
	}

	@Override
	public void deleteDiseasePrecautions(String id) throws SQLException {  //delete the the precautions
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Precautions WHERE Precautions_Id = ?");
		ps.setString(1, id);
		int status = ps.executeUpdate();
		if(status >0) {
			System.out.println("deleted Successfully..");
		}
		
	}

	@Override
	public Precautions FilterDiseasePrecautions(String disease) throws SQLException {  //search
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Precautions");
		System.out.println();
		while(rs.next())
		{
			if(rs.getString(2).equals(disease)) {
				System.out.println(rs.getString(3));
			}
		}
		Precautions precautions = null;
		return precautions;
	}

	@Override
	public void insertDiseasePrecautions(Precautions precautions) throws SQLException {   //adding new precautions
		String Insertion = "insert into Precautions (Precautions_Id,DISEASE_ID,Precautions) VALUES (?,?,?)";

		Connection con = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = con.prepareStatement(Insertion);
		ps.setString(1,precautions.getPreCautionId());
		ps.setString(2,precautions.getDisId());
		ps.setString(3,precautions.getPrecaution());
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Successfully inserted..");
		}
		
	}

	@Override
	public void back() throws SQLException {   //go back emp
		PrecautionsController PC =new PrecautionsController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of precautions or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCE.ServicesList();
		}else if(opinion == 2) {
			PC.precautionsEmp();
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
	public void backCust() throws SQLException {   //go back cust
		PrecautionsController PC =new PrecautionsController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of precautions or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		try {
			if(opinion == 1) {
				SCC.ServicesList();
			}else if(opinion == 2) {
				PC.precautionsCust();
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
