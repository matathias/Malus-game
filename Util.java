import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Util
{
	private static Scanner input = new Scanner(System.in);
	private static int saveCounter = 1;

	public static String yesNoLoop()
	{
		/*
		 * Loops until the user has properly entered "yes" or "no", case insensitive.
		 * 
		 * Returns the answer.
		 */
		String yesNo;
		do
		{
			System.out.print("[Yes/No]   ===>   ");
			yesNo = input.nextLine().trim();
			if (!(yesNo.equalsIgnoreCase("Yes")||yesNo.equalsIgnoreCase("No")))
			{
				System.out.println("Incorrect Input! Type \"Yes\" or \"No\".");
			}
		}
		while (!(yesNo.equalsIgnoreCase("Yes")||yesNo.equalsIgnoreCase("No")));

		return yesNo;
	}
	public static int numberSelect(String displayText, int numChoices)
	{
		/*
		 * Loops until the user has properly entered a choice in the range [1, numChoices]
		 * 
		 * Returns the choice.
		 * 
		 * This version of numberSelect accepts a String and displays it before executing the loop.
		 */
		int choice = 0;
		numChoices = Math.abs(numChoices);
		System.out.println(displayText);
		do
		{
			System.out.print("Choose: ");
			Scanner userChoice = new Scanner(input.nextLine().trim());
			if(!userChoice.hasNextInt())
				choice = -1;
			else
				choice = userChoice.nextInt();
			if(choice >numChoices || choice<1)
				System.out.println("Incorrect Input! Choose a number from the list.");
		}
		while(choice > numChoices || choice<1);
		return choice;
	}
	public static int numberSelect(ArrayList list, int numChoices)
	{
		/*
		 * Loops until the user has properly entered a choice in the range [1, numChoices]
		 * 
		 * Returns the choice.
		 * 
		 * This version of numberSelect accepts an ArrayList and displays it before executing the loop.
		 */
		int choice = 0;
		numChoices = Math.abs(numChoices);
		for(int a = 0; a<list.size(); a++)
		{
			System.out.println(list.get(a));
		}
		do
		{
			System.out.print("Choose: ");
			Scanner userChoice = new Scanner(input.nextLine().trim());
			if(!userChoice.hasNextInt())
				choice = -1;
			else
				choice = userChoice.nextInt();
			if(choice >numChoices || choice<1)
				System.out.println("Incorrect Input! Choose a number from the list.");
		}
		while(choice > numChoices || choice<1);
		return choice;
	}
	public static void pause()
	{
		/*
		 * Used to "pause" output, allowing the player to read everything before moving on.
		 */
		System.out.print("\nPress Enter to Continue");
		String dummy = input.nextLine();
		System.out.println();
	}
	public static void skitPause()
	{
		/*
		 * Used to pause output in a non-obtrusive manner.
		 */
		System.out.print("");
		String dummy = input.nextLine();
	}
	public static void lineBreak()
	{
		/*
		 * Used to separate blocks of text.
		 */
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	}
	public static void bigLineBreak()
	{
		/*
		 * Used to separate significant blocks of text.
		 */
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------\n");
	}
	public static void gameSave(ArrayList playerData, ArrayList gameData, ArrayList storyData)
	{
		/*
		 * Creates a save file and writes all relevant date to it for later loading.
		 */
		/*
		 * NOTE: Modifiy this and other methods such that gameSave only has to write String ArrayLists to file.
		 *That is, have the other methods return ArrayLists of strings with their getAll() method, where every
		 *object has been split into strings that display the value of the object's fields.
		 */
		
		//Assemble the file name from character name, class, and the save counter.
		String fileName;
		String charName = (String)playerData.get(9);
		String charClass = (String)playerData.get(10);
		String counter = Integer.toString(saveCounter);
		
		fileName = charName + charClass + counter + ".txt";
		
		try{
			// Create file 
			FileWriter outfile = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(outfile);
			/*
			 * Delimiter character: #
			 */
			
			//Example of writing to file with BufferedWriter:
			//out.write("Hello Java");
			
			/*
			 * Write playerData
			 */
			out.write(String.valueOf((Double)playerData.get(0))); //current HP
			out.write(String.valueOf((Double)playerData.get(1))); //max HP
			out.write(String.valueOf((Double)playerData.get(2))); //current EP
			out.write(String.valueOf((Double)playerData.get(3))); //max EP
			out.write(String.valueOf((Double)playerData.get(4))); //damage
			out.write(String.valueOf((Double)playerData.get(5))); //attack mod
			out.write(String.valueOf((Double)playerData.get(6))); //money
			out.write(String.valueOf((Double)playerData.get(7))); //exp
			out.write(String.valueOf((Double)playerData.get(8))); //level
			out.write((String)playerData.get(9));                //player name
			out.write((String)playerData.get(10));               //player class
			//Player Weapon
			String weaponName = playerData.get(11).getWeaponName();
			double weaponDam = (Weapon)playerData.get(11).getWeaponDamage();
			double weaponHP = (Weapon)playerData.get(11).getHP();
			double weaponEP = (Weapon)playerData.get(11).getEP();
			int weaponCost = (Weapon)playerData.get(11).getCost();
			out.write(weaponName);
			out.write(String.valueOf(weaponDam));
			out.write(String.valueOf(weaponHP));
			out.write(String.valueOf(weaponEP));
			out.write(String.valueOf(weaponCost));
			
			/*
			 * Write gameData
			 */
			
			/*
			 * Write storyData
			 */
			
			
			//Close the output stream
			out.close();
		}
		catch (Exception e){
			System.out.println("Error: " + e.getMessage());
			System.out.println("Unable to save.");
		}
	}
	public static void gameLoad(String fileName)
	{
		/*
		 * Reads data from a file named fileName and assigns it to all relevant classes 
		 * in order to resume the game from a previous save.
		 */
	}
}