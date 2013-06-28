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
			
			userChoice.close();
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
			
			userChoice.close();
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
	public static void gameSave(ArrayList<String> playerData, ArrayList<String> gameData, ArrayList<String> storyData)
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
		saveCounter++;
		
		fileName = charName + charClass + counter + ".txt";
		
		try{
			// Create file 
			FileWriter outfile = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(outfile);
			/*
			 * Delimiter character: #
			 */
			
			out.write("#");
			out.newLine();
			
			/*
			 * Write playerData
			 */
			for(int i = 0; i < playerData.size(); i++)
			{
				out.write(playerData.get(i));
				out.newLine();
			}
			
			out.write("#");
			out.newLine();
			
			/*
			 * Write gameData
			 */
			for(int i = 0; i < gameData.size(); i++)
			{
				out.write(gameData.get(i));
				out.newLine();
			}
			
			out.write("#");
			out.newLine();
			
			/*
			 * Write storyData
			 */
			for(int i = 0; i < storyData.size(); i++)
			{
				out.write(storyData.get(i));
				out.newLine();
			}
			
			out.write("#");
			out.newLine();
			
			
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
		try{
			FileReader inFile = new FileReader(fileName);
			BufferedReader in = new BufferedReader(inFile);
		}
		catch (Exception e){
			System.out.println("Error: " + e.getMessage());
			System.out.println("Unable to load.");
		}
	}
}