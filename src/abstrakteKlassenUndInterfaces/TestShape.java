package abstrakteKlassenUndInterfaces;

public class TestShape {

	public static void main(String[] args)
	{
		Shape s1 = new Rectangle(10, 20);
		System.out.println(s1.perimeter() + ",  " + s1.area());
		
		Shape c1 = new Circle(1.0);
		System.out.println(c1.perimeter() + ",  " + c1.area());
	}
}
