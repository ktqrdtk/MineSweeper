package main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Helper 
{
	public static ImageIcon mineIcon, flagIcon, defaultIcon;
	public static Image mineImage, flagImage, defaultImage;
	
	public static void loadImages()
	{
		try 
		{
			mineImage = ImageIO.read(new File("images/mine.jpg"));
		} 
		catch (IOException e) {}
		mineIcon = new ImageIcon(mineImage);
		//flagIcon = new ImageIcon();
		//defaultIcon = new ImageIcon();
	}
	
	public static boolean isArray(Object input)
	{
		if(input != null)
		{
			return input.getClass().isArray();
		}
		return false;
	}
	
	public static int sizeCorrect(int input)
	{
		switch(input)
		{
		case 0:
			return 8;
		case 1:
			return 16;
		case 2:
			return 24;
		}
		
		return -1;
	}
	
	public static int sizeToBombs(int input)
	{
		switch(input)
		{
		case 8:
			return 10;
		case 16:
			return 40;
		case 24:
			return 99;
		}
		
		return -1;
	}
}
