package uebungen.uebung6;

import java.util.*;

public class Stadt implements Comparable<Stadt> {

	private String name;
	private List<Integer> bevoelkerung;
	private float flaeche;
	
	public Stadt(String name, List<Integer> bevoelkerung, float flaeche)
	{
		this.name = name;
		this.bevoelkerung = bevoelkerung;
		this.flaeche = flaeche;
	}
	
	public int hashCode()
	{
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(o == this) return true;
		if(o.getClass() != this.getClass()) return false;
		
		Stadt other = (Stadt) o;
		return (this.name.equals(other.name));
	}
	
	
	@Override
	public int compareTo(Stadt o) 
	{
		// nach Name
		// 	return this.name.compareTo(o.name);  normal sortieren
		//return o.name.compareTo(this.name); umgekehrt sortieren
		
		// nach Fläche
		if(this.flaeche > o.flaeche) return 1;
		else if(this.flaeche < o.flaeche) return -1;
		else return 0;

	}
	
	
	public void print()
	{
		System.out.println(this.name + " >>> " + this.flaeche + " km2  " + this.bevoelkerung);
	
	}
}
