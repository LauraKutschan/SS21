package abstrakteKlassenUndInterfaces;

public class Rectangle extends Shape implements Comparable<Rectangle> {

	private int width;
	private int height;
	
	public Rectangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double perimeter() 
	{
		return (2.0 * (this.width + this.height));
	}

	@Override
	public double area() 
	{
		return this.width * this.height;
	}

	@Override
	public int compareTo(Rectangle o) 
	{
		/*
		 * this > o --> positiver int-Wert
		 * this < o --> negativer int-Wert
		 * this == o --> 0
		 */
		return 0;
	}

}
