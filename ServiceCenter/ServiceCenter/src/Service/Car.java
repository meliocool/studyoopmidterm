package Service;

public class Car extends Vehicle{
	String status;

	public Car(String plate, String owner, String brand, String status) {
		super(plate, owner, brand);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
