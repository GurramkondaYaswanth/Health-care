package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


import Model.MedicineOrder;
import dao.IdGeneration;
import dao.MedicineOrderDao;

public class MedicineOrderController {
	
	Scanner sc = new Scanner(System.in);
	MedicineOrder medicineorder = new MedicineOrder();
	IdGeneration IG = new IdGeneration(); 
	MedicineOrderDao MOD = new MedicineOrderDao();
	int i =0;
	//String CusId = "0";
	public void MedicineOrderCust() throws SQLException {
//		i++;

		
		System.out.println();
		System.out.println("1.View the Order");
		System.out.println("2.Order new Medicines");
		System.out.println("3.Delete the Order");
		System.out.println("4.Update the Order");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		System.out.print("enter the Cus Id: ");
		String CusId = sc.nextLine();
		
		if(opinion == 1) {   //View the Order
			List<String> list= MOD.ViewMedicineOrdersCust(CusId);
			MOD.backCust();
		}else if(opinion == 2) {    //Order new Medicines
			System.out.println();
			String OrdId = IG.IdGen();
			
//			System.out.print("Customer Id: ");
//			String CusId = sc.nextLine();
			System.out.print("Medicine Name: ");
			String medicine = sc.nextLine();
			System.out.print("Quantity: ");
			String quantity = sc.nextLine();
			
			medicineorder.setCustomerId(CusId);
			medicineorder.setMedicineOrderId(OrdId);
			medicineorder.setMedicine(medicine);
			medicineorder.setQuantity(quantity);
			
			MOD.insertMedicineOrder(medicineorder);
			MOD.backCust();
		}else if(opinion == 3) {  //delete
			System.out.println();
			System.out.print("Order Id: ");
			String OrdId = sc.nextLine();
			List<String> list=MOD.ViewMedicineOrdersCustId(CusId);
			int p = 0;
			for(int i =0; i<list.size();i++) {
				String OrdId1 = list.get(i);
				if(OrdId1.equals(OrdId)) {
					p++;
					MOD.deleteMedicineOrder(OrdId);
					MOD.backCust();
				}
			}
			if(p==0) {
			System.out.println("You can delete only Your Ordered order");
			MOD.backCust();
			}
		}else if (opinion == 4) {   //update
			System.out.println();
			System.out.print("Order Id: ");
			String OrdId = sc.nextLine();
//			System.out.print("Customer Id: ");
//			String CusId = sc.nextLine();
			System.out.print("Medicine Name: ");
			String medicine = sc.nextLine();
			System.out.print("Quantity: ");
			String quantity = sc.nextLine();
			
			medicineorder.setCustomerId(CusId);
			medicineorder.setMedicineOrderId(OrdId);
			medicineorder.setMedicine(medicine);
			medicineorder.setQuantity(quantity);
			
			MOD.updateMedicineOrder(medicineorder);
			MOD.backCust();
		}
		else {
			System.out.println("Invalid Input");
			MOD.backCust();
		}

	}
	
	public void MedicineOrderEmp() throws SQLException {
		System.out.println();
		System.out.println("1.View all the MedicineOrder");
		System.out.println("2.Search the Medicine Order");
		System.out.println();
		System.out.print("Enter The desired serial number from above: ");
		int opinion = sc.nextInt();
		sc.nextLine();
		
		if(opinion == 1) {   //View all the Diseases Symptoms
			MOD.ViewMedicineOrders();
			MOD.back();

		}else if(opinion == 2) { 
			
			System.out.println();
			System.out.print("Enter the Order Id: ");
			String OrdId = sc.nextLine();
			medicineorder = MOD.FilterMedicineOrder(OrdId);
			System.out.println();
			System.out.println("Medicine Order Id: "+medicineorder.getMedicineOrderId());
			System.out.println("Customer Id: "+ medicineorder.getCustomerId());
			System.out.println("medicine: "+medicineorder.getMedicine());
			System.out.println("quantity: "+medicineorder.getQuantity());
			MOD.back();
		}else{
			System.out.println("Invalid Input");
			MOD.back();
		}
	}

}
