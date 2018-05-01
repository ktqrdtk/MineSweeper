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
	
	public static int sizeCorrect(int input)
	{
		switch(input)
		{
		case 0:
			return 8;
		case 1:
			return 16;
		case 2:
			return 24;
		}
		
		return -1;
	}
	
	public static int sizeToBombs(int input)
	{
		switch(input)
		{
		case 8:
			return 10;
		case 16:
			return 40;
		case 24:
			return 99;
		}
		
		return -1;
	}
}
