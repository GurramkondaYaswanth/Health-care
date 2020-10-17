package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Model.MedicineOrder;
import Utility.ConnectionManager;
import controller.MedicineOrderController;
import controller.ServiceControllerEmployee;
import controller.ServicesControllerCust;

public class MedicineOrderDao {
	Scanner sc = new Scanner(System.in);
	ServiceControllerEmployee SCE = new ServiceControllerEmployee();
	ServicesControllerCust SCC = new ServicesControllerCust();
	
	
	public List<MedicineOrder> ViewMedicineOrders() throws SQLException {   //view all med orders
         List<MedicineOrder> list=new ArrayList<MedicineOrder>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(" Select * from Medicine_order");
		int d =1;
		System.out.println();
		System.out.println("   Order-ID     Customer-ID  Medicine               Quantity ");
		while(rs.next())
		{
			String OrdId = rs.getString(1);
			String CusId = rs.getString(2);
			String medicine = rs.getString(3);
			String quantity = rs.getString(4);
			
			
			int spaces = 23- (medicine.length());  
		 
			
			for(int i=0; i<spaces; i++) 
				medicine = medicine + " "; 
			
			
			
			String Meds = d+". "+OrdId+"   "+CusId+"   "+medicine+quantity;
			d++;
			System.out.println(Meds);
			
		}
		return list;
	}
	
	public List<String> ViewMedicineOrdersCust(String CusId) throws SQLException {  //view all med orders of par customer
        List<String> list=new ArrayList<String>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from Medicine_order");
		
		int d =1;
		System.out.println();
		System.out.println("   Order-ID     Customer-ID  Medicine               Quantity ");
		while(rs.next())
		{
			if(rs.getString(2).equals(CusId)) {
				String OrdId = rs.getString(1);
				//String CusId = rs.getString(2);
				String medicine = rs.getString(3);
				String quantity = rs.getString(4);
				
				
				int spaces = 23- (medicine.length());  
			 
				
				for(int i=0; i<spaces; i++) 
					medicine = medicine + " "; 
				
				
				
				String Meds = d+". "+OrdId+"   "+CusId+"   "+medicine+quantity;
				d++;
				System.out.println(Meds);
			}
			
		}
		return list;
	}
	
	public List<String> ViewMedicineOrdersCustId(String CusId) throws SQLException {  //cust Ids
        List<String> list=new ArrayList<String>();
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from Medicine_order");
		
		int d =1;
//		System.out.println();
//		System.out.println("   Appointment-ID  Customer-ID  Appointment date   Appointment time   Problem ");
		while(rs.next())
		{
			if(rs.getString(2).equals(CusId)) {
			String OrdId = rs.getString(1);
			
			String date = rs.getString(3);
			String time = rs.getString(4);
			String problem = rs.getString(5);
			
			list.add(OrdId);
			}
			
		}
		return list;
	}

	
	public void updateMedicineOrder(MedicineOrder medicineorders) throws SQLException {  //update order
		String OrdId = medicineorders.getMedicineOrderId();
		String CusId = medicineorders.getCustomerId();
		String medicine = medicineorders.getMedicine();
		String quantity = medicineorders.getQuantity();
		
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement ps = con.prepareStatement("UPDATE Medicine_order SET cus_Id = ? ,Medicine =? ,Quantity =? WHERE Order_Id = ?");
		
		ps.setString(1, OrdId);
		ps.setString(2, CusId);
		ps.setString(3, medicine);
		ps.setString(4, quantity);
		
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
		
	}


	public void deleteMedicineOrder(String id) throws SQLException {    //delete order
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Medicine_order WHERE Order_Id = ?");
		ps.setString(1, id);
		int status = ps.executeUpdate();
		if(status >0) {
			System.out.println("deleted Successfully..");
		}
		
	}

	
	public MedicineOrder FilterMedicineOrder(String id) throws SQLException {    //search order
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Medicine_order");
		int d =1;
		System.out.println();
		//System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		MedicineOrder medicineorder = new MedicineOrder();
		while(rs.next())
		{
			if(rs.getString(1).equals(id)) {
				medicineorder.setMedicineOrderId(rs.getString(1));
				medicineorder.setCustomerId(rs.getString(2));
				medicineorder.setMedicine(rs.getString(3));
				medicineorder.setQuantity(rs.getString(4));
			}
		}
		
		return medicineorder;
	}


	public void insertMedicineOrder(MedicineOrder medicineorder) throws SQLException {    //adding new order
		String Insertion = "Insert Into Medicine_order (Order_Id,cus_Id,Medicine,Quantity) values values (?,?,?,?)";

		Connection con = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = con.prepareStatement(Insertion);
		ps.setString(1,medicineorder.getMedicineOrderId());
		ps.setString(2,medicineorder.getCustomerId());
		ps.setString(3,medicineorder.getMedicine());
		ps.setString(4,medicineorder.getQuantity());
		
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Successfully inserted..");
		}
		
	}


	public void back() throws SQLException {   //go back for emp
		// TODO Auto-generated method stub
		MedicineOrderController MOC = new MedicineOrderController();
		
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of Medicine Order or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCE.ServicesList();
		}else if(opinion == 2) {
			MOC.MedicineOrderEmp();
		}else if(opinion == 3) {
			System.out.println();
			System.out.println("**********************************************************************Have a great Day*****************************************************************");
		}else {
			System.out.println();
			System.out.println("Invalid Input");
			back();
		}
		
	}

	
	public void backCust() throws SQLException {    //go back for cust
		MedicineOrderController MOC = new MedicineOrderController();
		System.out.println();
		System.out.print("Enter 1 to go back to Services or 2 to for other functions of Medicine Order or 3 to Exit: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		if(opinion == 1) {
			SCC.ServicesList();
		}else if(opinion == 2) {
			//DAC.DoctorAppointmentCust();
			MOC.MedicineOrderCust();
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
