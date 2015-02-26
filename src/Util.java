import java.util.*;
import java.io.*;

/**
 * @author		David Warrick
 */
public class Util
{
	/**
	 * Input mechanism.
	 */
	private static Scanner input = new Scanner(System.in);

	/**
	 * Keeps track of the save number so a later save will not overwrite a previous one.
	 */
	private static int saveCounter = 1;

	/**
	 * Handles yes/no prompts for the player.
	 * <p>
	 * This method will prompt the player for a yes or a no response, and will not continue until the player has typed
	 * a case-insensitive "yes" or "no". The method will not throw an exception or an error for string input that is not
	 * "yes" or "no", it will merely prompt the player to answer again.
	 * <p>
	 * @return yesNo - the player's choice
	 */
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

	/**
	 * Displays a list of choices for the player to choose from.
	 * <p>
	 * Similar to {@link #yesNoLoop}, this method will continually ask the player for an answer until they give a proper
	 * answer, which in this case is a number between 1 and numChoices. Non-numerical or otherwise "incorrect" inputs
	 * will not crash the program or throw an exception, they will simply prompt the player to answer again.
	 * <p>
	 * @param displayText the list of choices for the player to chose from, in String form.
	 * @param numChoices the number of choices.
	 * @return int choice - the number that the player picked.
	 */
	public static int numberSelect(String displayText, int numChoices)
	{
		/*
		 * Loops until the user has properly entered a choice in the range [1, numChoices]
		 * 
		 * Returns the choice.
		 * 
		 * This version of numberSelect accepts a String and displays it before executing the loop.
		 */
		int choice;
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

	/**
	 * Displays a list of choices for the player to choose from.
	 * <p>
	 * Similar to {@link #yesNoLoop}, this method will continually ask the player for an answer until they give a proper
	 * answer, which in this case is a number between 1 and numChoices. Non-numerical or otherwise "incorrect" inputs
	 * will not crash the program or throw an exception, they will simply prompt the player to answer again.
	 * <p>
	 * @param list the list of choices for the player to chose from, in ArrayList<String> form.
	 * @param numChoices the number of choices.
	 * @return int choice - the number that the player picked.
	 */
	public static int numberSelect(ArrayList<String> list, int numChoices)
	{
		/*
		 * Loops until the user has properly entered a choice in the range [1, numChoices]
		 * 
		 * Returns the choice.
		 * 
		 * This version of numberSelect accepts an ArrayList and displays it before executing the loop.
		 */
		int choice;
		numChoices = Math.abs(numChoices);
		for(int a = 0; a<list.size(); a++)
		{
			int b = a+1;
			System.out.println(b + ". " + list.get(a));
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

	/**
	 * Used to divide a single long line into several smaller lines based on the given line length.
	 *<p>
	 * This method assumes that the string does not already contain line breaks, and that no single "word" within the
	 * string is longer than length.
	 *<p>
	 * @param line the String to be divided up.
	 * @param length the maximum line length
	 * @return Returns a String that is line with newline characters inserted such that when printed, no single line of
	 * text is longer than length.
	 */
	public static String lineWrap(String line, int length)
	{
		// Base case
		if(line.length() <= length)
			return line;

		int index = length;
		char endChar;
		do
		{
			index--;
			endChar = line.charAt(index);
		}while (endChar != ' ' && index > 1);

		// Recursion woo
		return line.substring(0,index) + "\n" + lineWrap(line.substring(index+1), length);
	}

	/**
	 * Used to "pause" output, allowing the player to read previous text before moving on.
	 */
	public static void pause()
	{
		System.out.print("\nPress Enter to Continue");
		input.nextLine();
		System.out.println();
	}

	/**
	 * Used to "pause" output in the same manner as {@link #pause}, except without the "Press Enter to Continue" prompt.
	 */
	public static void skitPause()
	{
		System.out.print("");
		input.nextLine();
	}

	/**
	 * Used to separate blocks of text.
	 */
	public static void lineBreak()
	{
		System.out.println("________________________________________________________________________________\n");
	}

	/**
	 * Used to separate significant blocks of text.
	 */
	public static void bigLineBreak()
	{
		System.out.println("\n________________________________________________________________________________\n");
	}

	/**
	 * Used to pass some amount of time.
	 * <p>
	 * This function simply uses a loop to count from 0 up to the given long value.
	 * <p>
	 * @param time a long value for the program to count up to.
	 */
	public static void passTime(long time)
	{
		for(long a = 0; a < time; a++);
	}

	/**
	 * Creates a save file and writes all relevant data to it for later loading.
	 *
	 * @param playerData an ArrayList<String> containing all of the player's data.
	 * @param gameData an ArrayList<String> containing all other data related to gameplay.
	 * @param storyData a String storing data on the player's progression through the story.
	 * @param Loc an int representing the player's current location.
	 */
	public static void gameSave(ArrayList<String> playerData, ArrayList<String> gameData, String storyData, int Loc)
	{
		
		//Assemble the file name from character name, class, and the save counter.
		String fileName;
		String charName = playerData.get(11);
		String charClass = playerData.get(12);
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
			for(String item : playerData)
			{
				out.write(item);
				out.newLine();
			}
			
			out.write("#");
			out.newLine();
			
			/*
			 * Write gameData
			 */
			for(String item : gameData)
			{
				out.write(item);
				out.newLine();
			}
			
			out.write("#");
			out.newLine();
			
			/*
			 * Write storyData
			 */
			out.write(storyData);
			out.newLine();
			
			out.write("#");
			out.newLine();
			
			out.write(String.valueOf(Loc));
			out.newLine();
			
			out.write("#");
			out.newLine();
			
			out.write(counter);
			out.newLine();
			
			//Close the output stream
			out.close();
			System.out.println("Saving of file " + fileName + " successful!");
			Util.pause();
		}
		catch (Exception e){
			System.out.println("Error: " + e.getMessage());
			System.out.println("Unable to save.");
			Util.pause();
		}
	}

	/**
	 * Reads data from a save file and resumes the game.
	 *
	 * @param fileName the name of the file from which to load data.
	 * @return Returns a boolean value stating whether or not the load was successful.
	 */
	public static boolean gameLoad(String fileName)
	{
		ArrayList<String> inPlayer = new ArrayList<String>();
		ArrayList<String> inGame = new ArrayList<String>();
		String inStory;
		
		try{
			FileReader inFile = new FileReader(fileName);
			BufferedReader in = new BufferedReader(inFile);
			int itNum;
			
			in.readLine();
			//Read in the first 18 lines to the inPlayer arrayList
			for(int i = 0; i < 18; i++)
			{
				inPlayer.add(in.readLine());
			}
			//Find the number of defenses the player should have
			String numDefs = in.readLine();
			itNum = Integer.parseInt(numDefs);
			inPlayer.add(numDefs);
			//Read in all of the defenses to the inPlayer arraylist
			for(int i = 0; i < itNum*4; i++)
			{
				inPlayer.add(in.readLine());
			}
			
			//Find the amount of special attacks the player should have
			String numSpeAtt = in.readLine();
			itNum = Integer.parseInt(numSpeAtt);
			inPlayer.add(numSpeAtt);
			//Read in all of the special attack strings to the inPlayer arraylist
			for(int i = 0; i < itNum*8; i++)
			{
				inPlayer.add(in.readLine());
			}
			
			//Find the amount of healing abilities the player should have
			String numHeal = in.readLine();
			itNum = Integer.parseInt(numHeal);
			inPlayer.add(numHeal);
			//Read in all of the healing strings to the inPlayer arraylist
			for(int i = 0; i < itNum*6; i++)
			{
				inPlayer.add(in.readLine());
			}
			
			in.readLine(); //Pass the "#" character
			
			//Begin reading all of the game data
			String gameBools = in.readLine();
			inGame.add(gameBools);
			int numItems = 0;
			for(int i = 0; i < 3; i++)
			{
				switch(i)
				{
					case 0: numItems = 4;
							break;
					case 1: numItems = 6;
							break;
					case 2: numItems = 8;
							break;
				}
				//Begin reading the Market data
				//   Start by reading in numGen
				String numGen = in.readLine();
				itNum = Integer.parseInt(numGen);
				inGame.add(numGen);
				//   Read in all of the general Market strings
				for(int j = 0; j < itNum*numItems; j++)
				{
					inGame.add(in.readLine());
				}
				//   Now read in numClass
				String numClass = in.readLine();
				itNum = Integer.parseInt(numClass);
				inGame.add(numClass);
				//   Read in all of the class Market strings
				for(int j = 0; j < itNum*numItems; j++)
				{
					inGame.add(in.readLine());
				}
			}
			
			//Read in the Weapon Market data
			String numWeap = in.readLine();
			itNum = Integer.parseInt(numWeap);
			inGame.add(numWeap);
			for(int j = 0; j < itNum*5; j++)
			{
				inGame.add(in.readLine());
			}
			
			// Pass the next "#" line
			in.readLine();
			
			// Read in the story data string
			inStory = in.readLine();
			
			// Pass the next "#" line
			in.readLine();
			
			// Read in the location int
			String loc = in.readLine();
			inGame.add(loc);
			
			// Pass the next "#" line
			in.readLine();
			
			// Read in the counter
			String count = in.readLine();
			saveCounter = Integer.parseInt(count) + 1;
			
			//close the file
			in.close();
			
			//initialize PlaceActions and Story and continue the game
			Story.setAll(inStory);
			PlaceActions game = new PlaceActions(inPlayer, inGame);
			game.end();
			return true;
		}
		catch (Exception e){
			System.out.println("Error: " + e.getMessage());
			System.out.println("Unable to load.");
			return false;
		}
	}
}