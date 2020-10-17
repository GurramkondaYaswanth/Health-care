package dao;

import java.sql.SQLException;
import java.util.List;

import Model.Precautions;


interface PrecautionsDaoInterface {
	 List<Precautions> ViewDiseasesPrecautions() throws SQLException;
	 void updateDiseasePrecautions(Precautions precautions) throws SQLException;
	 void deleteDiseasePrecautions(String id) throws SQLException;
	 Precautions FilterDiseasePrecautions(String disease) throws SQLException;
	 void insertDiseasePrecautions(Precautions precautions) throws SQLException;
	 void back() throws SQLException;
	 void backCust() throws SQLException;
}
