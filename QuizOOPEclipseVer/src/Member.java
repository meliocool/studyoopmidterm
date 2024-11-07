import java.util.ArrayList;

public class Member extends Account {
    private ArrayList<Integer> transHis = new ArrayList<>(); // ArrayList for transaction history
    public String name, phoneNum;
    public double points;
    // Constructing a member
    public Member(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }
    // store the transaction of members into this arraylist
    public ArrayList<Integer> memberTransaction(int spend){
        super.addNewTransaction(spend);
        transHis.add(spend);
        return transHis;
    }
    // counting the points by multiplying spend with 0.2 (20%)
    public double pointCounter(int spend){
        double pointsObtained = 0.2 * spend;
        points += pointsObtained;
        return points;
    }
    // just a getter
    public ArrayList<Integer> getTransactionHistory() {
        return transHis;
    }
}
