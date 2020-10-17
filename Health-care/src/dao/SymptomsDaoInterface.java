package dao;

import java.sql.SQLException;
import java.util.List;

import Model.Symptoms;


interface SymptomsDaoInterface {
	 List<Symptoms> ViewDiseasesSymptoms() throws SQLException;
	 void updateDiseaseSymptoms(Symptoms symptoms) throws SQLException;
	 void deleteDiseaseSymptoms(String id) throws SQLException;
	 Symptoms FilterDiseaseSymptoms(String disease) throws SQLException;
	 void insertDiseaseSymptoms(Symptoms symptoms) throws SQLException;
	 void back() throws SQLException;
	 void backCust() throws SQLException;
}