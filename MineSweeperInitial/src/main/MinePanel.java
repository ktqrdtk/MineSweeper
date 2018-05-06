package main;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static main.Helper.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class MinePanel extends JPanel implements ActionListener, MouseListener
{	
	
	private MyJButton[][] grid;
	private Location[][] locations;
	private int size;
	private Game game;
	private boolean rightClick;
	
	public MinePanel(Game game)
	{
		super();
		this.game = game;
		this.size = game.size;
		grid = new MyJButton[sizeCorrect(size)][sizeCorrect(size)];
		this.setLayout(new GridLayout(sizeCorrect(size), sizeCorrect(size)));
		rightClick = false;
	}
	
	public void addMineArray(Location[][] array)
	{
		this.locations = array;
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				grid[i][j] = new MyJButton(new Coordinate(j, i));
				grid[i][j].setIcon(defaultIcon);
				if(array[i][j].hasBomb())
				{
					grid[i][j].setIcon(mineIcon);
				}
				grid[i][j].setActionCommand("B " + grid[i][j].toString());
				grid[i][j].addActionListener(this);
				this.add(grid[i][j]);
			}
		}
	}
	
	public void updateMineArray()
	{
		for(int i = 0; i < locations.length; i++)
		{
			for(int j = 0; j < locations[i].length; j++)
			{
				
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		Timer timer = new Timer();
		if(command.charAt(0) == 'B')
		{
			TimerTask tsk = new TimerTask()
					{
						public void run()
						{
							Coordinate coord = Coordinate.decompString(command);
							int x = coord.x;
							int y = coord.y;
							Location curLocation = locations[y][x];
							if(rightClick)
							{
								if(curLocation.hasFlag())
								{
									curLocation.setFlag(false);
								}
								else
								{
									curLocation.setFlag(true);
								}
							}
							else
							{
								leftClick(curLocation, x, y);
							}
						}
					};
			timer.schedule(tsk, 100);
		}
	}
	
	public void leftClick(Location input, int x, int y)
	{
		input.getSurroundings();
		input.beenClicked = true;
		if(input.hasBomb())
		{
			game.lose();
		}
		else
		{
			grid[y][x].setIcon(intToIcon(input.getNearbyBombs()));
			if(input.getNearbyBombs() == 0)
			{
				noBombsClick(input, x, y);
			}
		}
	}
	
	public void noBombsClick(Location input, int x, int y)
	{
		for(int i = 0; i < 8; i++)
		{
			Location curLocation = input.getLocationAt(i);
			try
			{
				if(!curLocation.beenClicked)
				{
					curLocation.getSurroundings();
					leftClick(curLocation, curLocation.getAbsolutePos().x, curLocation.getAbsolutePos().y);
				}
			}
			catch(IndexOutOfBoundsException ex)
			{
				
			}
		}
	}

	public void mouseClicked(MouseEvent evnt) 
	{
		if(SwingUtilities.isRightMouseButton(evnt))
		{
			rightClick = true;
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
				{
					public void run()
					{
						rightClick = false;
					}
				}, 200);
	}

	//unused methods
	public void mouseEntered(MouseEvent arg0){}public void mouseExited(MouseEvent arg0){}public void mousePressed(MouseEvent arg0){}public void mouseReleased(MouseEvent arg0){}
}
