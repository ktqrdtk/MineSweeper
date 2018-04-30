//Beginner (8x8, 10 mines), Intermediate (16x16, 40 mines) and Expert (24x24, 99 mines)
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	public MinePanel mainPane;
	
	public Game()
	{
		frame = new JFrame(TITLE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread afterChosenSize = new Thread()
		{
			@Override
			public void run()
			{
				setUpScreen();
				grid = new Location[size][size];
				mainPane.add(grid);
				frame.add(mainPane);
			}
		};
		chooseSize(afterChosenSize);
	}
	
	public void setUpScreen()
	{
		mainPane = new MinePanel();
		frame.pack();
		frame.repaint();
		frame.setVisible(true);
	}
	
	public void chooseSize(Thread afterChosen)
	{
		JPanel panel = new JPanel();
		JButton b1 = new JButton("Beginner");
		b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
	}
}
