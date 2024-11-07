public class Car extends Vehicles{
    protected String AC;
    public Car (String plateNum, String owner, String brand, String AC){
        super(plateNum, owner, brand);
        this.AC = AC;
    }
}
