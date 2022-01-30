package klausurwdhlg;

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
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getLength()
	{
		return this.length;
	}
}
