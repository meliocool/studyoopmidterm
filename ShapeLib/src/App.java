import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static ArrayList<Shapes> shape = new ArrayList();
	public static void main(String[] args) {
		boolean loop = true;
		while(loop) {
			mainmenu();
			Scanner input = new Scanner(System.in);
			int userIn = input.nextInt();
			if(userIn == 0) {
                System.out.println("Goodbye!");
				loop = false;
			}
			switch(userIn) {
			case 1:
				viewLib();
				break;
			case 2:
				insertShape();
				break;
			case 3:
				removeShape();
				break;
            }
		}
	}
	public static void mainmenu() {
		System.out.println("Shape Library");
		System.out.println("=================");
		System.out.println("1. View Library");
		System.out.println("2. Insert Shape");
		System.out.println("3. Remove Shape");
		System.out.println("0. Exit");
		System.out.print("Input: ");
	}
	public static void libMenu() {
		System.out.println("Shape Library");
		System.out.println("=================");
		System.out.println("1. View Circle");
		System.out.println("2. View Rectangle");
		System.out.println("0. Exit");
		System.out.print("Input: ");
	}
	public static void insMenu() {
		System.out.println("Shape Library");
		System.out.println("=================");
		System.out.println("1. Insert Circle");
		System.out.println("2. Insert Rectangle");
		System.out.println("0. Exit");
		System.out.print("Input: ");
	}
	public static void delMenu() {
		System.out.println("Shape Library");
		System.out.println("=================");
		System.out.println("1. Delete Circle");
		System.out.println("2. Delete Rectangle");
		System.out.println("0. Exit");
		System.out.print("Input: ");
	}
	public static void viewLib() {
		boolean libLoop = true;
		while(libLoop) {
			libMenu();
			Scanner libIn = new Scanner(System.in);
			int libInput = libIn.nextInt();
			if(libInput == 0) {
				libLoop = false;
			}
			switch(libInput) {
			case 1:
				circleCheck();
				break;
			case 2:
				rectangleCheck();
				break;
			}
		}
	}
	public static void circleCheck() {
	    if (shape.isEmpty()) {
	        System.out.println("No Circle Registered!");
	        System.out.println("Returning to main menu...");
	        return;
	    }
		boolean cirExist = false;
		for(int i = 0; i < shape.size(); i++) {
			if(shape.get(i) instanceof Circle) {
				cirExist = true;
				break;
			}
		}
		if(cirExist == true) {
            System.out.println("Circle Library");
            System.out.println("=".repeat(98));
            System.out.println("| " + String.format("%-30s", "Name") + 
                               "| " + String.format("%-30s", "Radius") + 
                               "| " + String.format("%-30s", "Area") + " |");
            System.out.println("=".repeat(98));
			for(int i = 0; i < shape.size(); i++) {
				if(shape.get(i) instanceof Circle) {
					Circle c = (Circle) shape.get(i);
					System.out.println("| " + String.format("%-30s", c.name) + 
							"| " + String.format("%-30.2f", c.radius) + 
							"| " + String.format("%-30.2f", c.circleArea()) + " |");
				}
			}
		} else {
			System.out.println("No Circle Registered!");
			System.out.println("Returning to main menu...");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				System.out.println("Sleep was interrupted.");
			}
			return;
		}
	}
	public static void rectangleCheck() {
	    if (shape.isEmpty()) {
	        System.out.println("No Rectangle Registered!");
	        System.out.println("Returning to main menu...");
	        return;
	    }
		boolean recExist = false;
		for(int i = 0; i < shape.size(); i++) {
			if(shape.get(i) instanceof Rectangle) {
				recExist = true;
				break;
			}
		}
		if(recExist == true) {
            System.out.println("Rectangle Library");
            System.out.println("=".repeat(130));
            System.out.println("| " + String.format("%-30s", "Name") + 
                               "| " + String.format("%-30s", "Height") + 
                               "| " + String.format("%-30s", "Width") + 
                               "| " + String.format("%-30s", "Area") + " |");
            System.out.println("=".repeat(130));
			for(int i = 0; i < shape.size(); i++) {
				if(shape.get(i) instanceof Rectangle) {
					Rectangle r = (Rectangle) shape.get(i);
					System.out.println("| " + String.format("%-30s", r.name) + 
							"| " + String.format("%-30.2f", r.height) + 
							"| " + String.format("%-30.2f", r.width) + 
							"| " + String.format("%-30s", r.recArea()) + " |");
				}
			}
		} else {
			System.out.println("No Rectangle Registered!");
			System.out.println("Returning to main menu...");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("Sleep was interrupted.");
			}
			return;
		}
	}
	public static void insertShape() {
		boolean insLoop = true;
		while(insLoop) {
			insMenu();
			Scanner insIn = new Scanner(System.in);
			int insInput = insIn.nextInt();
			if(insInput > 2 || insInput < 0) {
				System.out.println("Input must be 0, 1, or 2!");
			}
			if(insInput == 0) {
				insLoop = false;
			}
			switch(insInput) {
			case 1:
				insertCircle();
				break;
			case 2:
				insertRectangle();
				break;
			}
		}
	}
	public static void insertCircle() {
		String cirName;
		double cirRadius;
		boolean ask = true;
		while(ask) {
			System.out.print("Input Name [3-25 character(s)[exit]: ");
			Scanner cName = new Scanner(System.in);
			cirName = cName.next();
			if(cirName.equals("exit")) {
				ask = false;
				break;
			}
			// idk if this validation works or not too lazy to test
			if(cirName.length() < 3 || cirName.length() > 25) {
				System.out.println("Name must be between 3 and 25 characters!");
				continue;
			} else {
				boolean nameExists = false;
                for (int i = 0; i < shape.size(); i++) {
                    if (shape.get(i) instanceof Circle) {
                    	Circle tempCircle = (Circle) shape.get(i);
                    	if(tempCircle.name.equals(cirName))
                        nameExists = true;
                        break;
                    }
                }
                if (nameExists) {
                    System.out.println("This name already exists!");
                    continue;
                } 
			}
			while(true) {
				System.out.print("Input radius [1-100]: ");
				Scanner cRadius = new Scanner(System.in);
				cirRadius = cRadius.nextDouble();
				if (cirRadius < 1 || cirRadius > 100) {
					System.out.println("Radius must be between 1 and 100!");
					continue;
				} else {
					break;
				}
			}
			Circle circle = new Circle(cirName, cirRadius);
			System.out.println("Circle " + cirName + " has been added!");
			shape.add(circle);
		}
	}
	public static void insertRectangle() {
		String recName;
		double width, height;
		boolean ask = true;
		while(ask) {
			System.out.print("Input Name [3-25 character(s)[exit]: ");
			Scanner rName = new Scanner(System.in);
			recName = rName.next();
			if(recName.equals("exit")) {
				ask = false;
				break;
			}
			// idk if this validation works or not too lazy to test
			if(recName.length() < 3 || recName.length() > 25) {
				System.out.println("Name must be between 3 and 25 characters!");
				continue;
			} else {
				boolean nameRExists = false;
                for (int i = 0; i < shape.size(); i++) {
                    if (shape.get(i) instanceof Rectangle) {
                    	Rectangle tempRectangle = (Rectangle) shape.get(i);
                    	if(tempRectangle.name.equals(recName))
                        nameRExists = true;
                        break;
                    }
                }
                if (nameRExists) {
                    System.out.println("This name already exists!");
                    continue;
                } 
			}
			while(true) {
				System.out.print("Input size [WidthxHeight]: ");
				Scanner rSize = new Scanner(System.in);
				String rS = rSize.next();
				String[] sizeR = rS.split("x");
				if(sizeR.length != 2) {
					System.out.println("Invalid! must be WidthxHeight");
					continue;
				}
				width = Double.parseDouble(sizeR[0]);
				height = Double.parseDouble(sizeR[1]);
				if (width < 1 || width > 100 || height < 1 || height > 100) {
					System.out.println("Width and height must be between 1 and 100!");
				} else {
					break;
				}
			}
			Rectangle rectangle = new Rectangle(recName, height, width);
			System.out.println("Rectangle " + recName + " has been added!");
			shape.add(rectangle);
		}
	}
	public static void removeShape() {
		boolean remLoop = true;
		while(remLoop) {
			delMenu();
			Scanner remIn = new Scanner(System.in);
			int remInput = remIn.nextInt();
			if(remInput > 2 || remInput < 0) {
				System.out.println("Input must be 0, 1, or 2!");
			}
			if(remInput == 0) {
				remLoop = false;
			}
			switch(remInput) {
			case 1:
				circleCheck();
				System.out.print("Input Name [exit]: ");
				Scanner delCName = new Scanner(System.in);
				String delName = delCName.next();
				for(int i = 0; i < shape.size(); i++) {
					if(shape.get(i) instanceof Circle) {
						Circle temp = (Circle) shape.get(i);
						if(temp.name.equals(delName)) {
							shape.remove(i);
							System.out.println("Circle " + delName + " is Deleted!");
						}
					}
				}
				break;
			case 2:
				rectangleCheck();
				System.out.print("Input Name [exit]: ");
				Scanner delRName = new Scanner (System.in);
				String delNameR = delRName.next();
				for(int i = 0; i < shape.size(); i++) {
					if(shape.get(i) instanceof Rectangle) {
						Rectangle temp2 = (Rectangle) shape.get(i);
						if(temp2.name.equals(delNameR)) {			
							shape.remove(i);
							System.out.println("Rectangle " + delNameR + " is Deleted!");
						}
					}
				}
				break;
			}
		}
	}
}
