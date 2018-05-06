package main;

import javax.swing.JButton;

public class MyJButton extends JButton 
{
	private Coordinate coord;
	
	public MyJButton(Coordinate input)
	{
		super();
		coord = input;
	}
	
	public Coordinate getCoord()
	{
		return this.coord;
	}
	
	public void setCoord(Coordinate input)
	{
		coord = input;
	}
	
	public String toString()
	{
		return "x" + coord.x + " y" + coord.y + " ";
	}
}
