//Beginner (8x8, 10 mines), Intermediate (16x16, 40 mines) and Expert (24x24, 99 mines)
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static main.Helper.*;

public class Game implements ActionListener
{
	public static final String TITLE = "Minesweeper";
	
	public static void main(String[] args)
	{
		new Game();
	}
	
	public Location[][] grid;
	public int size;
	public JFrame frame;
	public MinePanel mainPanel;
	private Thread afterChosenSize;
	private boolean hasntRunSize = true;
	private JPanel buttonPanel;
	public int numOfBombs;
	
	public Game()
	{
		frame = new JFrame(TITLE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseSize();
	}
	
	public void setUpScreen()
	{
		this.numOfBombs = sizeToBombs(this.size);
		frame.remove(buttonPanel);
		mainPanel = new MinePanel();
		grid = new Location[sizeCorrect(size)][sizeCorrect(size)];
		double percentOfBomb = (sizeToBombs(this.size) / (Math.pow(sizeCorrect(this.size), 2))) * 100;
		Random random = new Random();
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				grid[i][j] = new Location(false, new Coordinate(j, i), this);
				if(this.numOfBombs > 0)
				{
					int randomNum = random.nextInt(100);
					if(randomNum < percentOfBomb)
					{
						grid[i][j].setBomb(true);
					}
				}
			}
		}
		
		mainPanel.addMineArray(grid);
		frame.add(mainPanel);
	}
	
	public void chooseSize()
	{
		afterChosenSize = new Thread()
		{
			@Override
			public void run()
			{
				setUpScreen();
			}
		};
		buttonPanel = new JPanel();
		String[] arg = {"Beginner", "Intermediate", "Exepert"};
		for(int i = 0; i < 3; i++)
		{
			JButton curButton = new JButton();
			curButton.setEnabled(true);
			curButton.setActionCommand("choosesize" + Integer.toString(i));
			curButton.setText(arg[i]);
			curButton.setVisible(true);
			buttonPanel.add(curButton);
		}
		frame.add(buttonPanel);
		frame.pack();
		frame.repaint();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		case "choosesize0":
			this.size = 0;
			break;
		case "choosesize1":
			this.size = 1;
			break;
		case "choosesize2":
			this.size = 2;
			break;
		}
		
		if(this.size != -1 && hasntRunSize)
		{
			afterChosenSize.start();
			hasntRunSize = false;
		}
		
	}
}
