package Model;

public class DoctorAppointment {
	private String AppId;
	private String CusId;
	private String AppointmentDate;
	private String AppointmentTime;
	private String Problem;
	public String getAppId() {
		return AppId;
	}
	public void setAppId(String appId) {
		AppId = appId;
	}
	public String getCusId() {
		return CusId;
	}
	public void setCusId(String cusId) {
		CusId = cusId;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return AppointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		AppointmentTime = appointmentTime;
	}
	public String getProblem() {
		return Problem;
	}
	public void setProblem(String problem) {
		Problem = problem;
	}
	

}
