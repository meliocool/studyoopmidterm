package Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Car> carList = new ArrayList<>();
	public static ArrayList<MotorCycle> motorList = new ArrayList<>();
	public static ArrayList<Vehicle> historyList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		makeDummy(carList, motorList);

		boolean running = true;
		while (running) {
			showMenu(carList, motorList);
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				newVehicle(scan, carList, motorList);
				break;
			case 2:
				serviceVehicle(scan, carList, motorList, historyList);
				break;
			case 3:
				viewHistory(scan, historyList);
				break;
			case 4:
				running = false;
				break;
			default:
				break;
			}
		}
	}

	public static void makeDummy(ArrayList<Car> carList, ArrayList<MotorCycle> motorList) {
		carList.add(new Car("BSDJKD", "Aldy", "Rhein", "Normal"));
		carList.add(new Car("BSVJKE", "Revi", "Toho", "Broken"));

		motorList.add(new MotorCycle("SJDKLS", "Maman", "Ost"));
		motorList.add(new MotorCycle("LOPKLD", "Rialdi", "Mitsu"));

	}

	public static void showMenu(ArrayList<Car> carList, ArrayList<MotorCycle> motorList) {
		showCar(carList);
		System.out.println();
		showMotor(motorList);
		System.out.println();
		System.out.println("1. Enter new vehicle to service");
		System.out.println("2. Service a vehicle");
		System.out.println("3. View service history");
		System.out.println("4. Exit");
		System.out.print("Choose : ");
	}

	public static void showCar(ArrayList<Car> carList) {
		int idx = 1;
		printEqual(64);
		System.out.printf("|%-2s|%-10s|%-10s|%-14s|%-10s|%-10s|\n", "No.", "Vehicle", "Plate No.", "Owner", "Brand",
				"Ac");
		printEqual(64);
		for (Car car : carList) {
			System.out.printf("|%2d.|%-10s|%-10s|%-14s|%-10s|%-10s|\n", idx, "Car", car.getPlate(), car.getOwner(),
					car.getBrand(), car.getStatus());
			idx++;
		}
		printEqual(64);

	}

	public static void showMotor(ArrayList<MotorCycle> motoList) {
		int idx = 1;
		printEqual(53);
		System.out.printf("|%-2s|%-10s|%-10s|%-14s|%-10s|\n", "No.", "Vehicle", "Plate No.", "Owner", "Brand");
		printEqual(53);
		for (MotorCycle motor : motoList) {
			System.out.printf("|%2d.|%-10s|%-10s|%-14s|%-10s|\n", idx, "Motorcycle", motor.getPlate(), motor.getOwner(),
					motor.getBrand());
			idx++;
		}
		printEqual(53);

	}

	public static void printEqual(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public static void newVehicle(Scanner scan, ArrayList<Car> carList, ArrayList<MotorCycle> motorList) {
		System.out.println("Do you want to enter a car or motorcycle?");
		System.out.println("1. Car");
		System.out.println("2. Motorcycle");
		System.out.print("Choose: ");

		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			scan.nextLine();
			String plate;
			String owner;
			String brand;
			String status;

			while (true) {
				System.out.print("Enter car plate number[min length: 5|max length: 10]: ");
				plate = scan.nextLine();
				if (plate.length() >= 5 && plate.length() <= 10) {
					break;
				}
			}

			while (true) {
				System.out.printf("Enter car owner name[max length: 20]: ");
				owner = scan.nextLine();
				if (owner.length() <= 20) {
					break;
				}
			}

			while (true) {
				System.out.print("Enter car brand name[Rhein|Mitsu|Toho|Ost]: ");
				brand = scan.nextLine();
				if (brand.equals("Rhein") || brand.equals("Mitsu") || brand.equals("Toho") || brand.equals("Ost")) {
					break;
				}
			}

			while (true) {
				System.out.print("Enter car AC status[Normal|Broken]: ");
				status = scan.nextLine();
				if (status.equals("Normal") || status.equals("Broken")) {
					break;
				}
			}

			carList.add(new Car(plate, owner, brand, status));
			break;
		case 2:
			scan.nextLine();
			String plate2;
			String owner2;
			String brand2;

			while (true) {
				System.out.print("Enter motorcycle plate number[min length: 5|max length: 10]: ");
				plate2 = scan.nextLine();
				if (plate2.length() >= 5 && plate2.length() <= 10) {
					break;
				}
			}

			while (true) {
				System.out.print("Enter motorcycle owner name[max length: 20]: ");
				owner2 = scan.nextLine();
				if (owner2.length() <= 20) {
					break;
				}
			}

			while (true) {
				System.out.print("Enter motorcycle brand name[Rhein|Mitsu|Toho|Ost]: ");
				brand2 = scan.nextLine();
				if (brand2.equals("Rhein") || brand2.equals("Mitsu") || brand2.equals("Toho") || brand2.equals("Ost")) {
					break;
				}
			}

			motorList.add(new MotorCycle(plate2, owner2, brand2));
			break;
		default:
			break;
		}
	}

	public static void serviceVehicle(Scanner scan, ArrayList<Car> carList, ArrayList<MotorCycle> motorList, ArrayList<Vehicle> historyList) {
		System.out.println("Do you want to service a car or motorcycle?");
		System.out.println("1. Car");
		System.out.println("2. Motorcycle");
		System.out.print("Choose: ");

		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			scan.nextLine();
			if (!carList.isEmpty()) {
				historyList.add(carList.get(0));
				carList.remove(0);
				System.out.println("Succesfully service a vehicle!");
				System.out.println("Press enter to continue...");
			} else {
				System.out.println("Vehicle not found!");
				System.out.println("Press enter to continue...");
			}

			scan.nextLine();
			break;
		case 2:
			scan.nextLine();
			if (!motorList.isEmpty()) {
				historyList.add(motorList.get(0));
				motorList.remove(0);
				System.out.println("Succesfully service a vehicle!");
				System.out.println("Press enter to continue...");
			} else {
				System.out.println("Vehicle not found!");
				System.out.println("Press enter to continue...");
			}

			scan.nextLine();
			break;

		default:
			break;
		}
	}
	
	public static void viewHistory(Scanner scan, ArrayList<Vehicle> historyList) {
		int idx = 1;
		scan.nextLine();
		printEqual(64);
		System.out.printf("|%-2s|%-10s|%-10s|%-14s|%-10s|%-10s|\n", "No.", "Vehicle", "Plat No.", "Owner", "Brand", "Ac");
		printEqual(64);
		for (Vehicle vehicle : historyList) {
			if(vehicle instanceof Car) {
				System.out.printf("|%2d.|%-10s|%-10s|%-14s|%-10s|%-10s|\n", idx, "Car", vehicle.getPlate(), vehicle.getOwner(),
						vehicle.getBrand(), ((Car) vehicle).getStatus());
			}else if(vehicle instanceof MotorCycle){
				System.out.printf("|%2d.|%-10s|%-10s|%-14s|%-10s|\n", idx, "Motorcycle", vehicle.getPlate(), vehicle.getOwner(),
						vehicle.getBrand());
			}
			idx++;
		}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
	}
}
