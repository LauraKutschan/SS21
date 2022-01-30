package aufgaben.aufgabe2;

public class MyIntegerProbe {

	static int  MAX_VALUE;
	static int MIN_VALUE;
	private int value;
	
	static int parseInt(String s)
	{
		int zahl = 000000;
		boolean eingabeOK = false;
		while(!eingabeOK)
		{
			try
			{
				zahl = parseInt(s);
				eingabeOK = true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Keine Zahl eingegeben oder keine Zahl.");
				break;
			}
		}
		return zahl;
	}
	
	public MyIntegerProbe(int value)
	{
		this.value = value;
	}
	
	public MyIntegerProbe(String s)
	{
		try
		{
			this.value = this.parseInt(s);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("IllegalArgumentException");
		}
	}
	
	public int intValue()
	{
		return this.value;
	}
	
	public double doubleValue()
	{
		return (double) this.value;
	}
	
	static MyIntegerProbe valueOf(String s) 
	{
		MyIntegerProbe i = new MyIntegerProbe(s);
		return i;
	}
	
	static MyIntegerProbe valueOf(int value)
	{
		MyIntegerProbe i = new MyIntegerProbe(value);
		return i;
	}
	
	@Override 
	public String toString()
	{
		return "String";
	}
	
	public boolean equals()
	{
		return true;
	}
}
