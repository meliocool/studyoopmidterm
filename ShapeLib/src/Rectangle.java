public class Rectangle extends Shapes{
	protected double height, width;
	public Rectangle(String name, double height, double width) {
		super(name, height, width);
		this.height = height;
		this.width = width;
	}
	public double recArea() {
		return height * width;
	}
}
