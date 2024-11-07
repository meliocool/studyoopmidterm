public class Account {
    protected int transaction; // im not sure if using protected here is the right call or not
    public void addNewTransaction(int spend){
        transaction += spend; 
    }
    public int returningTotal(){
        return transaction;
    }
}
