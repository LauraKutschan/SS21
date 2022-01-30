package klausur;

public class Figure {
 
	private int x;
	private int y;
	private int length;
	
	public Figure(int x, int y, int length)
	{
		this.x = x;
		this.y = y;
		this.length = length;
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
		
		
		
	//Getter und Setter für length
	public int getLength()
	{
		return this.length;
	}
		
	public void setLength(int length)
	{
		this.length = length;
	}
		
}
