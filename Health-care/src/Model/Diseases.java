package Model;

public class Diseases {
	private String diseaseId;
	private String OriginDate;
	private String OriginPlace;
	private String duration;
	private String DiseaseName;
	
	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getOriginDate() {
		return OriginDate;
	}
	public void setOriginDate(String originDate) {
		this.OriginDate = originDate;
	}
	public String getOriginPlace() {
		return OriginPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.OriginPlace = originPlace;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDiseaseName() {
		return DiseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.DiseaseName = diseaseName;
	}
	
	
}
