package uebungen.uebung5;

import java.util.*;

public class Stadt {

	String name;
	List<Integer> bevoelkerung;
	float flaeche;
	
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
	
	public void print()
	{
		System.out.println(this.name + " >>> " + this.flaeche + " km2  " + this.bevoelkerung);
	
	}
}
