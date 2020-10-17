package dao;

import java.time.LocalDate;
import java.time.LocalTime;

public class IdGeneration {
	public String IdGen() {  //generating the ID
		//getting present date
		 LocalDate date = LocalDate.now(); // Create a date object
		 LocalTime time = LocalTime.now();
		 String dateStr = date.toString();
		 String timeStr = time.toString();
//		 System.out.println(dateStr);
//		 System.out.println(timeStr); 
		 // Id is of form year+date+month+hr+min;
		 String id = dateStr.substring(2, 4) +  dateStr.substring(8, 10)+dateStr.substring(5, 7)+timeStr.substring(0, 2)+timeStr.substring(3, 5);
		 //System.out.println(id);
		 return id;
	}

}
