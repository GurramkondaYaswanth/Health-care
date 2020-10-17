package dao;

import java.sql.SQLException;
import java.util.List;

import Model.Diseases;


interface AboutDiseasesDaoInterface {
	 List<Diseases> ViewDiseases() throws SQLException;
	 void updateDiseaseInfo(Diseases diseases) throws SQLException;
	 void deleteDiseaseInfo(String id) throws SQLException;
	 Diseases FilterDisease(String id) throws SQLException;
	 void insertDiseaseInfo(Diseases diseases) throws SQLException;
	 void back() throws SQLException;
}
