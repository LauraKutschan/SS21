package klausurvorbereitung4;

import java.awt.Color;

public class Figur {

	private int x;
	private int y;
	private int hoehe;
	private int breite;
	private Color c;
	
	public Figur(int x, int y, int hoehe, int breite, Color c) 
	{
		this.x = x;
		this.y = y;
		this.hoehe = hoehe;
		this.breite = breite;
		this.c = c;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getH()
	{
		return this.hoehe;
	}
	
	public int getB()
	{
		return this.breite;
	}
	
	public Color getC()
	{
		return this.c;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	public void setH(int h) 
	{
		this.hoehe = h;
	}
	
	public void setB(int b) 
	{
		this.breite = b;
	}
}
