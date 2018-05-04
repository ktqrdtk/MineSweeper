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
	Timer timer;
	
	public MinePanel(Game game)
	{
		super();
		this.game = game;
		this.size = game.size;
		grid = new MyJButton[sizeCorrect(size)][sizeCorrect(size)];
		this.setLayout(new GridLayout(sizeCorrect(size), sizeCorrect(size)));
		rightClick = false;
		this.timer = new Timer();
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
				grid[i][j].setActionCommand("B" + grid[i][j].toString());
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
		if(command.charAt(0) == 'B')
		{
			TimerTask tsk = new TimerTask()
					{
						public void run()
						{
							int x = Integer.parseInt(String.valueOf(command.charAt(1)));
							int y = Integer.parseInt(String.valueOf(command.charAt(2)));
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
								leftClick(curLocation);
							}
						}
					};
			timer.schedule(tsk, 100);
		}
	}
	
	public void leftClick(Location input)
	{
		if(input.hasBomb())
		{
			game.lose();
		}
		else
		{
			
		}
	}

	public void mouseClicked(MouseEvent evnt) 
	{
		if(SwingUtilities.isRightMouseButton(evnt))
		{
			rightClick = true;
		}
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
