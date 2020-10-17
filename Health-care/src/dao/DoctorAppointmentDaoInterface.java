package dao;

import java.sql.SQLException;
import java.util.List;

import Model.DoctorAppointment;


public interface DoctorAppointmentDaoInterface {
	 List<DoctorAppointment> ViewDoctorAppointments() throws SQLException;
	 void updateDoctorAppointment(DoctorAppointment doctorappointment) throws SQLException;
	 void deleteDoctorAppointment(String id) throws SQLException;
	 DoctorAppointment FilterDoctorAppointment(String id) throws SQLException;
	 void insertDoctorAppointment(DoctorAppointment doctorappointment) throws SQLException;
	 void back() throws SQLException;
	 void backCust() throws SQLException;

}
