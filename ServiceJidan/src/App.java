import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<Vehicles> vehicle = new ArrayList();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        boolean loop = true;
        while(loop){
            displayCar();
            displayMC();
            mainmenu();
            int menuIn = scanner.nextInt();
            if(menuIn == 4){
                loop = false;
            }
            switch(menuIn){
                case 1:
                    newVehicle();
                    break;
                case 2:
                    // serviceVehicle();
                    break;
                case 3:
                    // serviceHistory();
                    break;
            }
        }
    }
    public static void mainmenu(){
        System.out.println("1. Enter a new Vehicle to Service");
        System.out.println("2. Service a vehicle");
        System.out.println("3. View service history");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
    }
    public static void newVMenu(){
        System.out.println("Which do you want to Enter?");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Exit");
        System.out.print("Choose: ");
    }
    public static void serviceMenu(){
        System.out.println("Which do you want to Service?");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.print("Choose: ");
    }
    public static void newVehicle(){
        while(true){
            newVMenu();
            int vIn = scanner.nextInt();
            if(vIn == 3){
                break;
            }
            switch(vIn){
                case 1:
                    insertCar();
                    break;
                case 2:
                    insertMC();
                    break;
            }
        }
    }
    public static void insertCar(){
        boolean insertLoop = true;
        while(insertLoop){
            String plateNum, owner, brand, AC;
            while(true){
                System.out.print("Enter car plate number [min length: 5 | max length: 10]: ");
                plateNum = scanner.next();
                if(plateNum.length() < 5 || plateNum.length() > 10){
                    continue;
                } else {
                    break;
                }
            }
            while(true){
                System.out.print("Enter owner name [max length: 20]: ");
                owner = scanner.next();
                if(owner.length() > 20){
                    continue;
                } else {
                    break;
                }
            }
            while(true){
                System.out.print("Enter car brand name [Rhein | Mitsu | Toho | Ost]: ");
                brand = scanner.next();
                if(!brand.equals("Rhein") && !brand.equals("Mitsu") && !brand.equals("Toho") &&
                !brand.equals("Ost")){
                    continue;
                } else {
                    break;
                }
            }
            while(true){
                System.out.print("Enter AC status [normal | broken]: ");
                AC = scanner.next();
                if(AC.equalsIgnoreCase("Normal") || AC.equalsIgnoreCase("Broken")){
                    break;
                } else {
                    continue;
                }
            }
            Car car = new Car(plateNum, owner, brand, AC);
            System.out.println("Car of " + owner + " is successfully inserted!");
            vehicle.add(car);

            System.out.print("Do you want to keep adding? [Yes/No]: ");
            String choice = scanner.next();
            if(choice.equals("No")){
                break;
            }
        }
    }
    public static void displayCar(){
        boolean carExist = false;
        int carIndex = 1;
        for(int i = 0; i < vehicle.size(); i++){
            if(vehicle.get(i) instanceof Car){
                carExist = true;
                break;
            }
        }
        if(carExist){
            System.out.println("=".repeat(80));
            System.out.println("| " + "No." + " |" + String.format("%-15s", "Vehicle") +
                                "| " + String.format("%-15s", "Plate No.") + 
                                "| " + String.format("%-15s", "Owner") + 
                                "| " + String.format("%-15s", "Brand") + 
                                "| " + String.format("%-15s", "AC") + " |");
            System.out.println("=".repeat(80));
            for(int i = 0; i < vehicle.size(); i++){
                if(vehicle.get(i) instanceof Car){
                    Car c = (Car) vehicle.get(i);
                    System.out.println("| " + (carIndex++) + " |" + String.format("%-15s", "Car") +
                                "| " + String.format("%-15s", c.plateNum) + 
                                "| " + String.format("%-15s", c.owner) + 
                                "| " + String.format("%-15s", c.brand) + 
                                "| " + String.format("%-15s", c.AC) + " |");
                }
            }
        } else {
            System.out.println("No Cars Yet");
        }
    }
    public static void insertMC(){
        boolean insertLoop = true;
        while(insertLoop){
            String plateNum, owner, brand;
            while(true){
                System.out.print("Enter Motorcycle plate number [min length: 5 | max length: 10]: ");
                plateNum = scanner.next();
                if(plateNum.length() < 5 || plateNum.length() > 10){
                    continue;
                } else {
                    break;
                }
            }
            while(true){
                System.out.print("Enter owner name [max length: 20]: ");
                owner = scanner.next();
                if(owner.length() > 20){
                    continue;
                } else {
                    break;
                }
            }
            while(true){
                System.out.print("Enter Motorcycle brand name [Rhein | Mitsu | Toho | Ost]: ");
                brand = scanner.next();
                if(!brand.equals("Rhein") && !brand.equals("Mitsu") && !brand.equals("Toho") &&
                !brand.equals("Ost")){
                    continue;
                } else {
                    break;
                }
            }
            Motorcycle mc = new Motorcycle(plateNum, owner, brand);
            System.out.println("Motorcycle of " + owner + " is successfully inserted!");
            vehicle.add(mc);

            System.out.print("Do you want to keep adding? [Yes/No]: ");
            String choice = scanner.next();
            if(choice.equals("No")){
                break;
            }
        }
    }
    public static void displayMC(){
        boolean mcExist = false;
        int mcIndex = 1;
        for(int i = 0; i < vehicle.size(); i++){
            if(vehicle.get(i) instanceof Motorcycle){
                mcExist = true;
                break;
            }
        }
        if(mcExist){
            System.out.println("=".repeat(80));
            System.out.println("| " + "No." + " |" + String.format("%-15s", "Vehicle") +
                                "| " + String.format("%-15s", "Plate No.") + 
                                "| " + String.format("%-15s", "Owner") + 
                                "| " + String.format("%-15s", "Brand") + " |");
            System.out.println("=".repeat(80));
            for(int i = 0; i < vehicle.size(); i++){
                if(vehicle.get(i) instanceof Motorcycle){
                    Motorcycle mc = (Motorcycle) vehicle.get(i);
                    System.out.println("| " + (mcIndex++) + " |" + String.format("%-15s", "Motorcycle") +
                                "| " + String.format("%-15s", mc.plateNum) + 
                                "| " + String.format("%-15s", mc.owner) + 
                                "| " + String.format("%-15s", mc.brand) + " |");
                }
            }
        } else {
            System.out.println("No Motorcycles Yet");
        }
    }
}
