//Beginner (8x8, 10 mines), Intermediate (16x16, 40 mines) and Expert (24x24, 99 mines)
package main;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game 
{
	public static void main(String[] args)
	{
		new Game();
	}
	
	private Location[][] grid;
	private int size;
	private JFrame frame;
	private JPanel mainPane;
	
	public Game()
	{
		setUpScreen();
		this.size = chooseSize();
		this.grid = new Location[this.size][this.size];
		mainPane.addGrid(this.grid);
		frame.add(mainPane);
	}
	
	public void setUpScreen()
	{
		frame = new JFrame();
		mainPane = new JPanel()
				{
					private static final long serialVersionUID = 1L;
					public void addGrid(Location[][] input)
					{
						System.out.println("Hello");
					}
				};
	}
	
	public int chooseSize()
	{
		return 0;
	}
}
