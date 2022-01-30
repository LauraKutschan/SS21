package mausereignisse;

import java.awt.Point;

public class Linie {

	private Point start;
	private Point ende;
	
	public Linie(Point start, Point ende)
	{
		this.start = start;
		this.ende = ende;
	}
	
	public void setEnde(Point newEnde) {
        this.ende = newEnde;
    }

    public int getXstart() {
        return this.start.x;
    }

    public int getYstart() {
        return this.start.y;
    }

    public int getXende() {
        return this.ende.x;
    }

    public int getYende() {
        return this.ende.y;
    }
}
