package wrapperklassen;

public class MYInteger {

	private int value;
	
	public MYInteger(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public static MYInteger valueOf(int value)
	{
		return new MYInteger(value);
	}
}
