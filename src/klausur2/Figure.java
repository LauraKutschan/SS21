package klausur2;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Figure {

	enum Shape {OVAL, RECTANGLE};
	Shape shape;
	Color color;
	Point start;
	int width;
	int height;
	
	
	public Figure(Shape shape, Point start)
	{
		this.shape = shape;
		this.start = start;
		this.width = 0;
		this.height = 0;
		Random r = new Random();
		this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public void changeColor()
	{
		Random r = new Random();
		this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public void setStartPoint(Point point)
	{
		this.start = point;
	}
	
	public void changeShape()
	{
		if(this.shape == Shape.OVAL)
		{
			this.shape = Shape.RECTANGLE;
		}
		else if(this.shape == Shape.RECTANGLE)
		{
			this.shape = Shape.OVAL;
		}
	}
	
	public void addSideLength(int xDiff, int yDiff)
	{
		if(xDiff < 0 || yDiff < 0 || xDiff < 0 && yDiff < 0)
		{
			this.width = this.width + xDiff;
			this.height = this.height + yDiff;
			this.start.x = this.start.x + xDiff;
			this.start.y = this.start.y + yDiff;
		}
		else
		{
			this.width = this.width + xDiff;
			this.height = this.height + yDiff;
		}
		
		
		
	}
	
	public void bigger()
	{
		this.width = (int) (this.width * 1.2);
		this.height = (int) (this.height * 1.2);
		this.start.x = this.start.x - 20;
		this.start.y = this.start.y - 20;
	}
	
	public void smaller()
	{
		this.width = (int) (this.width * 0.8);
		this.height = (int) (this.height * 0.8);
		this.start.x = this.start.x + 20;
		this.start.y = this.start.y + 20;
	}
}

