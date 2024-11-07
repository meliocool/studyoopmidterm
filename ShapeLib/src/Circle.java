public class Circle extends Shapes{
	protected double radius;
	protected double PI = Math.PI;
	public Circle(String name, double radius) {
		super(name, radius, radius);
		this.radius = radius;
	}
	public double circleArea() {
		return PI * radius * radius;
	}
}
