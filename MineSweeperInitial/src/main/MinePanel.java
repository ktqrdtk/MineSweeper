package main;

import javax.swing.JButton;
import javax.swing.JPanel;
import static main.Helper.*;

import java.awt.GridLayout;

public class MinePanel extends JPanel
{	
	
	public JButton[][] grid;
	private int size;
	
	public MinePanel(int size)
	{
		super();
		this.size = size;
		grid = new JButton[sizeCorrect(size)][sizeCorrect(size)];
		this.setLayout(new GridLayout(sizeCorrect(size), sizeCorrect(size)));
	}
	
	public void addMineArray(Location[][] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				grid[i][j] = new JButton();
				if(array[i][j].hasBomb())
				{
					grid[i][j].setIcon(mineIcon);
				}
				this.add(grid[i][j]);
			}
		}
	}
	
	public void updateMineArray(Location[][] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				if(array[i][j].hasBomb())
				{
					grid[i][j].setIcon(mineIcon);
				}
			}
		}
	}
	
	public void setAllVisible(boolean input)
	{
		
	}
}
