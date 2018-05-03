package main;

import javax.swing.JButton;
import javax.swing.JPanel;
import static main.Helper.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinePanel extends JPanel implements ActionListener
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
				grid[i][j].setIcon(defaultIcon);
				grid[i][j].setActionCommand("asdf");
				grid[i][j].addActionListener(this);
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
				
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if(command.equals("asdf"))
		{
			System.out.println(e.getSource());
		}
	}
}
