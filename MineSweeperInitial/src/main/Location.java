package main;

public class Location
{
	private static final long serialVersionUID = 1L;
	private boolean bomb;
	private Location[] surroundings;
	private Coordinate absolutePos;
	private Game game;
	
	public Location(boolean bomb, Coordinate absolutePos, Game game)
	{
		this.bomb = bomb;
		surroundings = new Location[8];
		this.absolutePos = absolutePos;
		this.game = game;
	}
	
	public void update()
	{
		if(!bomb)
		{
			for(int i = 0; i < surroundings.length; i++)
			{
				surroundings[i] = this.getLocationAt(i);
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
			coords.setCoordinate(0, -1);
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
		return game.grid[coord.y][coord.x];
	}
	
	public void setBomb(boolean input)
	{
		this.bomb = input;
	}
}
