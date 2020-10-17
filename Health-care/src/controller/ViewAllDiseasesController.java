package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Diseases;
import dao.AboutDiseasesDao;


public class ViewAllDiseasesController {
	Diseases diseases= new Diseases();
	AboutDiseasesDao ADD = new AboutDiseasesDao();
	
	public void viewAllDiseases() throws SQLException {
		//List<Diseases> listDiseases=new ArrayList<Diseases>();
	    List<Diseases> listDiseases = null;
		listDiseases = ADD.ViewDiseases();
		//System.out.println("size: "+listDiseases.size());
		System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		int d =0;
		System.out.println();
		//System.out.println(listDiseases.get(1).getDiseaseName());
//		for(int l=0; l<listDiseases.size(); l++) {
//			String name = listDiseases.get(l).getDiseaseName();
//			String date = listDiseases.get(l).getOriginDate();
//			String place = listDiseases.get(l).getOriginPlace();
//			System.out.println(name);
//		}
		for(Diseases diseaseslist:listDiseases) {
			//for(int l =0; l<list)
			String name = diseaseslist.getDiseaseName();
			String date = diseaseslist.getOriginDate();
			String place = diseaseslist.getOriginPlace();
			System.out.println(listDiseases.get(0).getDiseaseName());
			d++;
			int spaces = 20- (name.length());  
			int spaces1 = 23 - (date.length());
			int spaces2 = 20- (place.length());

			if(spaces<0) {
				spaces = 0;
			}
			if(spaces1<0)
				spaces1=0;
			if(spaces2<0)
				spaces2=0;
			
			for(int i=0; i<spaces; i++) {
				name = name + " "; 
			}
			for(int j=0; j<spaces1; j++) {
				date = date + " "; 
			}
			for(int k=0; k<spaces2; k++) {
				place = place + " "; 
			}
			
			String diseaseBrief = d+". "+diseaseslist.getDiseaseId()+"    "+name+date+place+diseaseslist.getDuration();
			System.out.println(diseaseBrief);
		}
	}

}
