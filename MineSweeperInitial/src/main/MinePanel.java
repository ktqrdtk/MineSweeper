package main;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static main.Helper.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MinePanel extends JPanel implements ActionListener, MouseListener
{	
	private MyJButton[][] grid;
	private Location[][] locations;
	private int size;
	private Game game;
	private Coordinate hooveredCoords;
	private boolean winnable;
	private int flags;
	
	public MinePanel(Game game)
	{
		super();
		this.game = game;
		this.size = game.size;
		grid = new MyJButton[sizeCorrect(size)][sizeCorrect(size)];
		this.setLayout(new GridLayout(sizeCorrect(size), sizeCorrect(size)));
		hooveredCoords = new Coordinate();
		winnable = true;
		flags = 0;
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
				grid[i][j].setActionCommand("B " + grid[i][j].toString());
				grid[i][j].addActionListener(this);
				grid[i][j].addMouseListener(this);
				this.add(grid[i][j]);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if(command.charAt(0) == 'B')
		{
			Coordinate coord = Coordinate.decompString(command);
			int x = coord.x;
			int y = coord.y;
			Location curLocation = locations[y][x];
			leftClick(curLocation, x, y);
		}
	}
	
	public void leftClick(Location input, int x, int y)
	{
		input.getSurroundings();
		input.beenClicked = true;
		if(input.hasBomb())
		{
			winnable = false;
			game.lose(input, x, y);
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
		int x = hooveredCoords.x;
		int y = hooveredCoords.y;
		if(SwingUtilities.isRightMouseButton(evnt))
		{
			if(locations[y][x].hasFlag())
			{
				locations[y][x].setFlag(false);
				grid[y][x].setIcon(defaultIcon);
				flags--;
			}
			else
			{
				if(!locations[y][x].beenClicked)
				{
					locations[y][x].setFlag(true);
					grid[y][x].setIcon(flagIcon);
					flags++;
				}
			}
			
			if(flags >= sizeToBombs(sizeCorrect(size)))
			{
				checkWin();
			}
		}
	}

	public void mouseEntered(MouseEvent evnt)
	{
		if(evnt.getSource() instanceof MyJButton)
		{
			MyJButton curButton = (MyJButton) evnt.getSource();
			hooveredCoords.setCoordinate(curButton.getCoord().x, curButton.getCoord().y);
		}
	}
	
	public void mouseExited(MouseEvent evnt)
	{
		hooveredCoords.setCoordinate(0, 0);
	}
	
	public void mousePressed(MouseEvent evnt){}public void mouseReleased(MouseEvent evnt){}
	
	public void showBombs()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				if(locations[i][j].hasBomb())
				{
					grid[i][j].setIcon(mineIcon);
				}
			}
		}
	}
	
	public void turnOff()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				grid[i][j].setEnabled(false);
				grid[i][j].removeMouseListener(this);
			}
		}
	}
	
	public void checkWin()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				Location curLocation = locations[i][j];
				if(!curLocation.hasFlag())
				{
					leftClick(curLocation, j, i);
				}
			}
		}
		if(winnable)
		{
			game.win();
		}
	}
}
