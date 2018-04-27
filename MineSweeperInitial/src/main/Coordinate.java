package main;

public class Coordinate 
{
	public int x;
	public int y;
	
	public Coordinate()
	{
		this(0, 0);
	}
	
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString()
	{
		return "X: " + x + " Y; " + y;
	}
	
	public void setCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}