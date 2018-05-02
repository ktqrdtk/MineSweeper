package main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Helper 
{
	public static ImageIcon mineIcon, flagIcon, defaultIcon, icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8;
	public static ImageIcon[] iconArray;
	public static Image mineImage, flagImage, defaultImage, image1, image2, image3, image4, image5, image6, image7, image8;
	public static int imageWidth;
	public static int imageHeight;
	public static final int defaultImageWidth = 500;
	public static final int defaultImageHeight = 500;
	
	public static void loadImages()
	{
		try 
		{
			mineImage = ImageIO.read(new File("Images/bomb.png"));
			flagImage = ImageIO.read(new File("Images/flagged.png"));
			defaultImage = ImageIO.read(new File("Images/0.png"));
			image1 = ImageIO.read(new File("Images/1.png"));
			image2 = ImageIO.read(new File("Images/2.png"));
			image3 = ImageIO.read(new File("Images/3.png"));
			image4 = ImageIO.read(new File("Images/4.png"));
			image5 = ImageIO.read(new File("Images/5.png"));
			image6 = ImageIO.read(new File("Images/6.png"));
			image7 = ImageIO.read(new File("Images/7.png"));
			image8 = ImageIO.read(new File("Images/8.png"));
			
		} 
		catch (IOException e) 
		{
			System.out.println("Can't read images");
		}
		mineIcon = new ImageIcon(mineImage);
		flagIcon = new ImageIcon(flagImage);
		defaultIcon = new ImageIcon(defaultImage);
		icon1 = new ImageIcon(image1);
		icon2 = new ImageIcon(image2);
		icon3 = new ImageIcon(image3);
		icon4 = new ImageIcon(image4);
		icon5 = new ImageIcon(image5);
		icon6 = new ImageIcon(image6);
		icon7 = new ImageIcon(image7);
		icon8 = new ImageIcon(image8);
		ImageIcon[] tempArray = {mineIcon, flagIcon, defaultIcon, icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8};
		iconArray = tempArray;
		updateImages(defaultImageWidth, defaultImageHeight);
	}
	
	public static void updateImages(double _1, double _2)
	{
		int new_1 = smartCast(_1);
		int new_2 = smartCast(_2);
		for(int i = 0; i < iconArray.length; i++)
		{
			iconArray[i].setImage(scaleImageIcon(iconArray[i], new_1, new_2));
		}
	}
	
	private static int smartCast(double input) 
	{
		return (int)(input + .5);
	}

	public static Image scaleImageIcon(ImageIcon input, int _1, int _2)
	{
		Image returnValue = input.getImage().getScaledInstance(_1, _2, java.awt.Image.SCALE_SMOOTH);
		return returnValue;
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
