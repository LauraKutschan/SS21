package uebungen.uebung10;

public class Rechteck {

	private int x, y, width, heigth;
	
	public Rechteck(int x, int y, int width, int length)
	{
		//Koordinaten und Größe des Rechtecks
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = length;
	}
	
	
	//Getter und Setter für X
	public int getX()
	{
		return this.x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	
	
	//Getter und Setter für Y
	public int getY()
	{
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	
	
	//Getter und Setter für width
	public int getWidth()
	{
		return this.width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	
	
	//Getter und Setter für length
	public int getHeight()
	{
		return this.heigth;
	}
	
	public void setHeight(int height)
	{
		this.heigth = height;
	}
	
}
