package main;

public class Helper 
{
	public static boolean isArray(Object input)
	{
		if(input != null)
		{
			return input.getClass().isArray();
		}
		return false;
	}
}
