import java.util.Scanner;
import java.util.TreeMap;

/*
 * WRITTEN ORIGINALLY IN VISUAL STUDIO CODE 
 * PASTED TO ECLIPSE IDE
 * Learned from this Tutorial Video: https://youtu.be/BB0gZFpukJU?si=srfmev6-BLNBYSup
 */

/*
 * MUHAMMAD DHITAN IMAM SAKTI 2702367183 LR01
 * References: Past Projects, Treemap usage, and this cool helpful video :D
 * https://youtu.be/Zs342ePFvRI?si=CuRXarfBGpVEVY8j
 */

public class App {
    // not using any private protected or something like that
    // cause i still don't quite understand their usage
    static Account notMember = new Account();
    static int beras = 50000;
    static int minyak = 30000;
    static int bumbuDapur = 20000;
    static TreeMap<String, Member> registered_members = new TreeMap<>();
    public static void main(String[] args) {
        System.out.println("WELCOME TO TONE STORE");
        System.out.println("=====================");
        while(true){
            System.out.println("Pick one of these options!");
            menu();
            System.out.print("Choose from 1 to 4: ");
            Scanner choice = new Scanner(System.in);
            int pick = choice.nextInt();
            if(pick == 4){
                System.out.println("Thank you for visiting!");
                break;
            }
            switch(pick){
                case 1:
                    registerMem();
                    break;
                case 2:
                    // idk why im not wrapping this in a method/function but it still works
                    // (hopefully as intended)
                    System.out.println("NEW TRANSACTION");
                    System.out.println("===============");
                    System.out.print("Quick question, are you a member? (Y/N): ");
                    Scanner isMember = new Scanner(System.in);
                    char isMem = isMember.next().charAt(0);
                    Member member = new Member(null,  null);
                    if(isMem == 'Y'){
                        System.out.print("Enter your phone number: ");
                        Scanner pNum = new Scanner(System.in);
                        String pNumber = pNum.next();
                        member = registered_members.get(pNumber);
                        if(member == null){
                            // adds an extremely persuative approach so the user will be a member :D
                            System.out.println("You are NOT a member yet, would you like to be one or proceed as NonMember? [1/2]");
                            System.out.println("1. Become a member");
                            System.out.println("2. Proceed as NonMember (loser mode [no points])");
                            System.out.print("Your Choice: ");
                            Scanner memNullInput = new Scanner(System.in);
                            int memNull = memNullInput.nextInt();
                            if(memNull == 1){
                                registerMem();
                            } else {
                                int totalNonMem = purchasing();
                                notMember.addNewTransaction(totalNonMem);
                            }
                        }
                        System.out.println("Hello! " + member.name + " Happy shopping!");
                        int total = purchasing();
                        member.memberTransaction(total);
                        member.pointCounter(total);
                    } else if (isMem == 'N'){
                        System.out.println("Would you like to be a member or proceed as NonMember? [1/2]");
                        System.out.println("1. Become a member");
                        System.out.println("2. Proceed as NonMember (loser mode [no points])");
                        System.out.print("Your Choice: ");
                        Scanner memNullInput = new Scanner(System.in);
                        int memNull = memNullInput.nextInt();
                        if(memNull == 1){
                            registerMem();
                        } else {
                            System.out.println("Proceeding as Non-Member (loser mode [no points])");
                            int totalNonMem = purchasing();
                            notMember.addNewTransaction(totalNonMem);
                        }
                    }
                    break;
                case 3:
                    System.out.println("TRANSACTION TOTAL");
                    System.out.println("=================");
                    System.out.println("Please pick one of these options");
                    System.out.println("1. Certain member total transaction");
                    System.out.println("2. Non-members total transaction");
                    System.out.println("3. Total Money Received");
                    System.out.print("Your choice: ");
                    Scanner optionIn = new Scanner(System.in);
                    int option = optionIn.nextInt();
                    switch(option){
                        case 1:
                                // idk how to make the total have decimal points on each cases
                                // For example:
                                // Rp. 200000 is supposed to be written liek RP. 200,000
                                // and im too stressed to look it up online
                            System.out.print("Enter the member's Phone Number: ");
                            Scanner phoneIn = new Scanner(System.in);
                            String phone = phoneIn.next();
                            Member mem = registered_members.get(phone);
                            if(mem != null){
                                System.out.println(mem.name + "'s Total Spent: Rp. " + mem.returningTotal() + " -> Points Collected: " + mem.points);
                                System.out.println("Transaction History: " + mem.getTransactionHistory());
                            } else {
                                System.out.println("Member does not exist");
                            }
                            break;
                        case 2:
                            int notMemTotal = notMember.returningTotal();
                            System.out.println("Total: Rp. " + notMemTotal);
                            break;
                        case 3:
                            int totalAll = notMember.returningTotal();
                            for(Member memAll : registered_members.values()) {
                                totalAll += memAll.returningTotal();
                            }
                            System.out.println("Total Money Received: Rp. " + totalAll);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
    // menu function
    public static void menu(){
        System.out.println("1. Become a member");
		System.out.println("2. New transaction");
		System.out.println("3. Total transaction");
		System.out.println("4. Exit");
    }
    // register function
    public static void registerMem(){
        System.out.println("Thanks for wanting to be a member");
        System.out.println("Please fill in these fields!");
        System.out.println("============================");
        System.out.print("Name: ");
        Scanner userName = new Scanner(System.in);
        String memberName = userName.next();
        System.out.print("Phone Number: ");
        Scanner phoneNumber = new Scanner(System.in);
        String memberPhone = phoneNumber.next();
        Member newMem = new Member(memberName, memberPhone);
        registered_members.put(memberPhone, newMem);
        System.out.println("Hi! " + memberName + " you are now a member!"); // a nice welcome message
    }
    // purchasing stuff method
    public static int purchasing(){
        int transactionTotal = 0;
        while(true){
            System.out.println("Select one of these items");
            System.out.println("1. Beras - 2. Minyak - 3. Bumbu Dapur");
            System.out.println("=====================================");
            System.out.print("Your choice [Type 4 if you want to stop purchasing]: ");
            Scanner itemIn = new Scanner(System.in);
            int items = itemIn.nextInt();
            if(items == 4){
                System.out.println("Transaction finished, Thank you");
                break;
            }
            switch(items){
                // i should probably use a function and then pass the product
                // as an argument to for example a "Buy(int product)" function
                // just to make it look a lot cleaner, but this works too
                case 1:
                    System.out.print("Quantity: ");
                    Scanner qtyBIn = new Scanner(System.in);
                    int qtyB = qtyBIn.nextInt();
                    transactionTotal += (beras * qtyB);
                    break;
                case 2:
                    System.out.print("Quantity: ");
                    Scanner qtyMIn = new Scanner(System.in);
                    int qtyM = qtyMIn.nextInt();
                    transactionTotal += (minyak * qtyM);
                    break;
                case 3:
                    System.out.print("Quantity: ");
                    Scanner qtyBDIn = new Scanner(System.in);
                    int qtyBD = qtyBDIn.nextInt();
                    transactionTotal += (bumbuDapur * qtyBD);
                    break;
                default:
                    System.out.println("Invalid product!");
            }
        }
        return transactionTotal; // returns the total
    }
}
