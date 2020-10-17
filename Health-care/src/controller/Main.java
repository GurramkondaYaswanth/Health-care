package controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("                                         Welcome to Health care Services     ");
		System.out.println();
		
		//taking input to know if the user is hr or employee
		System.out.print("If your Customer enter 1, Health care employee enter 2 : ");
		int CustomerEmployee = sc.nextInt(); 
		if(CustomerEmployee >2 && CustomerEmployee<1) {
			System.out.println("Invalid Input");
		}else {
		//taking input to know new user or existing user
		System.out.print("Enter 1 if your existing User or else enter 2 if your new User: ");
		int newOld = sc.nextInt();
		sc.nextLine();
		SignInController SC = new SignInController();
		SignupController SUC = new SignupController();
			if(CustomerEmployee == 1) {  
				if(newOld == 1) {      //customer signin
					SC.signInCustomer();
				}else if(newOld == 2) {  //customer sign up credentials
					SUC.signUpCustomer();
				}else {
					System.out.println();
					System.out.println("Invalid Input");
				}
			}else if(CustomerEmployee == 2){
				if(newOld == 1) {   //emp signin
					SC.signInEmployee();
				}else if(newOld == 2) { //emp signup
					SUC.signUpEmployee();
				}else {
				System.out.println();
				System.out.println("Invalid Input");
				}
			}
		}

	}

}
