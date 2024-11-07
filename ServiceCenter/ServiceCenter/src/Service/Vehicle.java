package Service;

public class Vehicle {
	String plate;
	String owner;
	String brand;

	public Vehicle(String plate, String owner, String brand) {
		super();
		this.plate = plate;
		this.owner = owner;
		this.brand = brand;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
