package main;

public class Location
{
	private static final long serialVersionUID = 1L;
	private boolean bomb;
	private Location[] surroundings;
	private Coordinate absolutePos;
	private Game game;
	public boolean beenClicked;
	private boolean flag;
	private int nearbyBombs;
	
	public Location(boolean bomb, Coordinate absolutePos, Game game)
	{
		this.bomb = bomb;
		surroundings = new Location[8];
		this.absolutePos = absolutePos;
		this.game = game;
		this.beenClicked = false;
		this.flag = false;
	}
	
	public void getSurroundings()
	{
		nearbyBombs = 0;
		if(!bomb)
		{
			for(int i = 0; i < surroundings.length; i++)
			{
				surroundings[i] = this.getLocationAt(i);
				if(surroundings[i].hasBomb())
				{
					nearbyBombs++;
				}
			}
		}
	}
	
	/*
	 * 012
	 * 3X4
	 * 567
	 */
	
	public Coordinate getLocationCoordinate(int input)
	{
		Coordinate coords = new Coordinate();
		switch(input)
		{
		case 0:
			coords.setCoordinate(-1, -1);
			break;
		case 1:
			coords.setCoordinate(0, -1);
			break;
		case 2:
			coords.setCoordinate(1, -1);
			break;
		case 3:
			coords.setCoordinate(-1, 0);
			break;
		case 4:
			coords.setCoordinate(1, 0);
			break;
		case 5:
			coords.setCoordinate(-1, 1);
			break;
		case 6:
			coords.setCoordinate(0, 1);
			break;
		case 7:
			coords.setCoordinate(1, 1);
			break;
		}
		return coords;
	}
	
	public Location getLocationAt(int input)
	{
		Coordinate coord = getLocationCoordinate(input);
		coord.setCoordinate(coord.x + this.absolutePos.x, coord.y + this.absolutePos.y);
		try
		{
			return game.grid[coord.y][coord.x];
		}
		catch(IndexOutOfBoundsException ex)
		{
			return Game.emptyLocation;
		}
	}
	
	public void setBomb(boolean input)
	{
		this.bomb = input;
	}
	
	public boolean hasBomb()
	{
		return this.bomb;
	}
	
	public void setFlag(boolean input)
	{
		this.flag = input;
	}
	
	public boolean hasFlag()
	{
		return this.flag;
	}
	
	public int getNearbyBombs()
	{
		return this.nearbyBombs;
	}
	
	public Coordinate getAbsolutePos()
	{
		return this.absolutePos;
	}
}
