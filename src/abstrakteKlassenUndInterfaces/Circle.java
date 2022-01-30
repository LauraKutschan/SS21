package abstrakteKlassenUndInterfaces;

public class Circle extends Shape {

	private double radius;
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	@Override
	public double perimeter() {
		return (2.0 * (Math.PI * this.radius));
	}

	@Override
	public double area() {
		return Math.PI * this.radius * this.radius;
	}
	
	
}
