package main;

import javax.swing.JPanel;
import static main.Helper.*;

import java.awt.Component;

public class MinePanel extends JPanel
{
	
	public MinePanel()
	{
		
	}
	
	public void add(Object obj)
	{
		if(isArray(obj))
		{
			addMineArray((Location[][]) obj);
		}
		else
		{
			super.add((Component) obj);
		}
	}
	
	public void addMineArray(Location[][] array)
	{
		
	}
	
}
