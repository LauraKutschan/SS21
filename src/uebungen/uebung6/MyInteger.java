package uebungen.uebung6;

public class MyInteger implements Comparable<MyInteger>
{
	
    private int value;

    public MyInteger(int value)
    {
        this.value = value;
    }

    public int intValue()
    {
        return this.value;
    }

    public static MyInteger valueOf(int value)
    {
        return new MyInteger(value);
    }

	@Override
	public int compareTo(MyInteger o) 
	{
		// richtig herum sortiert
		/*
		 * if(this.value > o.value) return 1;
		 * else if(this.value < o.value) return -1;
		 * else return 0;
		 * 
		 * ODER
		 * 
		 * return (this.value - o.value);

		 */
	
		// andersherum sortiert
		/*
		 * if(this.value > o.value) return -1;
		 * else if(this.value < o.value) return 1;
		 * else return 0;
		 * 
		 * ODER:
		 * 
		 */
		
		return -(this.value - o.value);

	}
}
