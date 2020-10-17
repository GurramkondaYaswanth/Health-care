package Model;

public class MedicineOrder {
	
	private String MedicineOrderId;
	private String CustomerId;
	private String medicine;
	private String quantity;
	public String getMedicineOrderId() {
		return MedicineOrderId;
	}
	public void setMedicineOrderId(String medicineOrderId) {
		MedicineOrderId = medicineOrderId;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	

}
