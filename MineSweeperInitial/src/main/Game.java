//Beginner (8x8, 10 mines), Intermediate (16x16, 40 mines) and Expert (24x24, 99 mines)
package main;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game 
{
	public static final String TITLE = "Minesweeper";
	
	public static void main(String[] args)
	{
		new Game();
	}
	
	public Location[][] grid;
	public int size;
	public JFrame frame;
	public MinePanel mainPane;
	
	public Game()
	{
		setUpScreen();
		this.size = chooseSize();
		this.grid = new Location[this.size][this.size];
		mainPane.add(this.grid);
		frame.add(mainPane);
	}
	
	public void setUpScreen()
	{
		frame = new JFrame(TITLE);
		mainPane = new MinePanel();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.repaint();
		frame.setVisible(true);
	}
	
	public int chooseSize()
	{
		return 0;
	}
}
