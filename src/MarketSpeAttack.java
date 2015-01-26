import java.util.*;

/**
 * @author 		David Warrick
 */
public class MarketSpeAttack
{
	/**
	 * Variable to store the player character. This is necessary for determining what Special Attacks the player can
	 * purchase, and at what cost.
	 */
	private Player player;

	/**
	 * ArrayList of Special Attacks to store the generic Special Attacks - that is, the Special Attacks that are
	 * available for purchase to any character, regardless of class.
	 */
	private ArrayList <SpecialAttack> speAttGen;

	/**
	 * ArrayList of Special Attacks to store the class-specific Special Attacks. The Special Attacks that are loaded
	 * into this ArrayList are dependent on the class of the player character; for instance, a Special Attack that is
	 * specific to a Ravager would not be loaded if the player is a Commando.
	 */
	private ArrayList <SpecialAttack> speAttClass;

	/**
	 * Used at the first game start-up.
	 * <p>
	 * This Constructor takes in the player character as an argument and uses it to initialize the {@link #speAttGen}
	 * and {@link #speAttClass} ArrayLists. This Constructor is used when the game is being started up on a brand new
	 * character and everything is being initialized as new.
	 * <p>
	 * @param p The player character.
	 */
	public MarketSpeAttack(Player p)
	{
		player = p;
		speAttGen = new ArrayList<SpecialAttack>();
		speAttClass = new ArrayList<SpecialAttack>();
		initGeneralSpeAtt();
		initClassSpeAtt();
	}

	/**
	 * Used when loading data from a save file.
	 * <p>
	 * This Constructor is meant to be used when loading data from a save file. It initializes the {@link #speAttGen}
	 * and {@link #speAttClass} ArrayLists and then calls {@link #setAllString(ArrayList data)} to set the
	 * values of the ArrayLists.
	 * <p>
	 * In this case the player is not needed as the Special Attacks are simply being loaded from a file.
	 * <p>
	 * @param data The String ArrayList of Special Attacks that will be passed to {@link #setAllString(ArrayList data)}.
	 */
	public MarketSpeAttack(ArrayList<String> data)
	{
		speAttGen = new ArrayList<SpecialAttack>();
		speAttClass = new ArrayList<SpecialAttack>();
		setAllString(data);
	}

	/**
	 * Returns the player character.
	 *
	 * @return Returns {@link #player}.
	 */
	public Player getPlayer()
	{
		return player;
	}

	/**
	 * Sets the player character to the given player.
	 * <p>
	 * This method is actually functionally useless; the player is only needed when the game *first* runs so that the
	 * Special Attack ArrayLists are initialized properly. Once they've been initialized the player is no longer
	 * necessary, especially since the {@link #speAttMarket(Player p)} method does not (and can not) work on the player
	 * previously stored within the MarketSpeAttack object.
	 * <p>
	 * I just don't want to get rid of it in case I break anything.
	 * <p>
	 * @param p - a player, used to determine what Special Attacks to show.
	 */
	public void setPlayer(Player p)
	{
		player = p;
	}

	/**
	 * Adds the selected Special Attack to the player's repertoire and removes the proper amount of money.
	 *
	 * @param sA - the Special Attack that the player has chosen to buy.
	 */
	private void buySpeAtt(SpecialAttack sA)
	{
		player.addSpecialAttack(sA);
		player.subtractMoney(sA.getCost());
	}

	/**
	 * Initializes {@link #speAttGen}, the general Special Attack ArrayList.
	 * <p>
	 * Initializes the six general Special Attacks, Destruction, Foe Crash, Chaos Drive, Machina Chaos, Penultima Chaos,
	 * and Ultima Chaos. These Special Attacks are class-independent; the only thing class-dependent about them is their
	 * cost, thanks to the Entrepreneur's "10% off all prices" trait.
	 * <p>
	 */
	//Special attack format: (name,attackDamage,extraPoints,minLevel,cost,criticalChance,critBonus)
	private void initGeneralSpeAtt()
	{
		double costMult;
		
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))//10% cheaper
			costMult = .9;
		else
			costMult = 1.0;
		
		speAttGen.add(new SpecialAttack("Destruction","All",150,40,9,(int)(200*costMult),5,1.5));
		speAttGen.add(new SpecialAttack("Foe Crash","All",350,100,16,(int)(500*costMult),10,1.5));
		speAttGen.add(new SpecialAttack("Chaos Drive","All",500,175,22,(int)(2000*costMult),15,1.5));
		speAttGen.add(new SpecialAttack("Machina Chaos","All",1000,450,30,(int)(6000*costMult),25,2));
		speAttGen.add(new SpecialAttack("Penultima Chaos","All",2500,600,37,(int)(10000*costMult),32,3.5));
		speAttGen.add(new SpecialAttack("Ultima Chaos","All",50000,4300,48,(int)(100000*costMult),50,5));
	}

	/**
	 * Initializes {@link #speAttClass}, the class-dependent Special Attack ArrayList.
	 * <p>
	 * Initializes the class-dependent Special Attacks. Depending on the player's class, {@link #speAttClass} could have
	 * as few as three entries or as many as eight.
	 * <p>
	 */
	private void initClassSpeAtt()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			speAttClass.add(new SpecialAttack("Bullet Blitz","Commando",200,80,15,600,40,4)); //Bullet Blitz (all three: low dam, high(ish) ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Bullet Storm","Commando",410,200,25,3500,55,5)); //Bullet Storm
			speAttClass.add(new SpecialAttack("Bullet Hell","Commando",1000,700,35,9050,75,8)); //Bullet Hell
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			speAttClass.add(new SpecialAttack("Flamestrike","Berserker",550,75,14,500,10,1.75)); //Flamestrike
			speAttClass.add(new SpecialAttack("Cleave","Berserker",800,200,22,3050,25,4)); //Cleave
			speAttClass.add(new SpecialAttack("Berserk","Berserker",4000,1200,38,10500,80,1.5)); //Berserk (high dam, high ep, high crit chance, low crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			speAttClass.add(new SpecialAttack("Forced Response","Sentinel",100,20,12,350,5,1.5)); //Forced Response (low dam, low ep, low crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack("Defense's Offence","Sentinel",200,60,24,3000,35,3)); //Defense's Offense (low dam, high ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Guard's Strength","Sentinel",400,350,28,5000,50,5)); //Guard's Strength (high dam, high ep, low crit chance, low crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			speAttClass.add(new SpecialAttack("Flame","Ravager",375,50,10,250,5,1.25)); //Flame			(high dam, low ep, low crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack("Crush","Ravager",450,100,15,500,5,4)); //Crush 			(high dam, high ep, low crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Freeze","Ravager",525,175,20,1250,15,2.5)); //Freeze 			(mid dam, mid ep, mid crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Thunder","Ravager",775,225,25,3250,35,3)); //Thunder			(low dam, high ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Chaos Claw","Ravager",1350,400,30,5075,5,4)); //Chaos Claw		(mid dam, high ep, low crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Chaos Strike","Ravager",2500,875,35,8500,50,1.25)); //Chaos Strike	(high dam, high ep, high crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack("Chaos Blast","Ravager",3500,2000,40,14000,55,6)); //Chaos Blast 	(high dam, high ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Ultimate Sacrifice","Ravager",5000,5000,45,18000,3,25)); //Ultimate Sacrifice (high level, high damage, high EP cost, very low crit chance, high crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			speAttClass.add(new SpecialAttack("Forced Response","Reliever",150,50,12,250,5,1.25)); //Forced Response(low dam, low ep, low crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack("Lightning","Reliever",275,125,20,1100,35,3)); //Lightning
			speAttClass.add(new SpecialAttack("Shining Blow","Reliever",600,230,28,3200,10,2.1)); //Shining Blow
			speAttClass.add(new SpecialAttack("Chaos' Light","Reliever",1200,775,36,5250,35,2)); //Chaos' Light
			speAttClass.add(new SpecialAttack("Ultimate Light","Reliever",3500,1250,45,15250,20,1.75)); //Ultimate Light (high level, high dam, high ep, mid crit chance, low crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			speAttClass.add(new SpecialAttack("Demand's Supply","Entreprenuer",150,30,14,400,25,2.5)); //Demand's Supply
			speAttClass.add(new SpecialAttack("Hostile Takeover","Entreprenuer",250,100,25,3000,50,5)); //Hostile Takeover (low dam, mid ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack("Monopoly","Entreprenuer",1175,975,38,5000,75,4)); //Monopoly (high dam, high ep, high crit chance, high crit bonus)
		}
	}

	/**
	 * Displays the Special Attacks in a visually pleasing and easily navigable manner.
	 *
	 * @return a - the number of Special Attacks in the market
	 */
	private int showSpeAttacks()
	{
		String topHeader = "+------------------------------Special Attacks---------------------------------+";
		String bottomHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		int a;
		
		for(a = 0; a < speAttGen.size() + speAttClass.size(); a++)
		{
			String saN, saDam, saCHC, saCost, saMinLvl, saEP, saCB;
			if(a < speAttGen.size())
			{
				saN = speAttGen.get(a).getAttackName();
				saDam = String.valueOf((int)speAttGen.get(a).getAttackDamage());
				saCHC = String.valueOf(speAttGen.get(a).getCritChance());
				saCost = String.valueOf(speAttGen.get(a).getCost());
				saMinLvl = String.valueOf((int)speAttGen.get(a).getMinLevel());
				saEP = String.valueOf((int)speAttGen.get(a).getExtraPoints());
				saCB = String.valueOf(speAttGen.get(a).getCritBonus());
			}
			else
			{
				saN = speAttClass.get(a-speAttGen.size()).getAttackName();
				saDam = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getAttackDamage());
				saCHC = String.valueOf(speAttClass.get(a-speAttGen.size()).getCritChance());
				saCost = String.valueOf(speAttClass.get(a-speAttGen.size()).getCost());
				saMinLvl = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getMinLevel());
				saEP = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getExtraPoints());
				saCB = String.valueOf(speAttClass.get(a-speAttGen.size()).getCritBonus());
			}
			String number = String.valueOf(a+1);
			String row1 = "";
			String row2 = "";
			
			if(a+1 < 10)
				row1 += "|  " + number + ": " + saN;
			else
				row1 += "| " + number + ": " + saN;
			
			int numSpaces = 10 + 18 - saN.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			
			row1 += "Base Damage: " + saDam;
			numSpaces = 8 - saDam.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			
			if (saCHC.length() < 2)
				row1 += "Critical Hit Chance:  " + saCHC + " |";
			else
				row1 += "Critical Hit Chance: " + saCHC + " |";
			System.out.println(row1);
			
			row2 += "|         Cost: " + saCost;
			numSpaces = 8 - saCost.length();
			for(int i = 0; i<numSpaces; i++)
				row2 += " ";
			
			if(saMinLvl.length() < 2)
				row2 += "Min Level:  " + saMinLvl + " EP Cost: " + saEP;
			else
				row2 += "Min Level: " + saMinLvl + " EP Cost: " + saEP;
			
			numSpaces = 8 - saEP.length();
			for(int i = 0; i<numSpaces; i++)
				row2 += " ";
			
			row2 += "Crit Multiplier: ";
			numSpaces = 6 - saCB.length();
			for(int i = 0; i<numSpaces; i++)
				row2 += " ";
			row2 += saCB + " |";
			System.out.println(row2);
		}
		System.out.println(midHeader);
		System.out.println(bottomHeader);
		return a;
	}

	/**
	 * Manages the player choosing a Special Attack to buy (or none at all).
	 * <p>
	 * The actual "Market", as far as the player is concerned. This method handles interfacing with the player and
	 * calling the correct methods to buy a Special Attack and move it into the player's repertoire.
	 * <p>
	 * This method takes in the player character as an argument so that the player that is modified (i.e. that has the
	 * Special Attack added to them) is the most current player, instead of the outdated player that was previously
	 * stored in the MarketSpeAtt object. The method then returns the player again, this time updated with the purchased
	 * Special Attack (assuming the player actually bought one).
	 * <p>
	 * @param p - the player character.
	 * @return p - the player character.
	 */
	public Player speAttMarket(Player p)
	{
		player = p;
		boolean bought = false;
		System.out.println("\nWelcome to the Special Attack Market!");
		System.out.println("You can buy Special Attacks here.");
		System.out.println("Special Attacks are more powerful than regular attacks,\n but they require EP to use.");
		Util.pause();
		int counter = showSpeAttacks();
		counter++;
		System.out.println(counter + ": Don't buy anything");
		System.out.println("Your Money: " + player.getMoney());
		System.out.println("Current level:  " + (int)player.getLvl());
		System.out.println("Current Max HP: " + (int)player.getMaxHealth());
		System.out.println("Current Max EP: " + (int)player.getMaxEP());
		do
		{
			int choice = Util.numberSelect("",counter)-1;
			if(choice <speAttGen.size())
			{
				if(player.getLvl()>= speAttGen.get(choice).getMinLevel())
				{
					if(player.getMoney() >= speAttGen.get(choice).getCost())
					{
						System.out.println("You bought " + speAttGen.get(choice).getAttackName() + "!");
						buySpeAtt(speAttGen.remove(choice));
						bought = true;
					}
					else
					{
						System.out.println("You can't afford the " + speAttGen.get(choice).getAttackName() + "!");
					}
				}
				else
				{
					System.out.println("Your level isn't high enough to buy " + speAttGen.get(choice).getAttackName() + "!");
				}
			}
			else if(choice < (speAttGen.size()+speAttClass.size()) && choice >= speAttGen.size())
			{
				if(player.getLvl()>= speAttClass.get(choice-speAttGen.size()).getMinLevel())
				{
					if(player.getMoney() >= speAttClass.get(choice-speAttGen.size()).getCost())
					{
						System.out.println("You bought " + speAttClass.get(choice-speAttGen.size()).getAttackName() + "!");
						buySpeAtt(speAttClass.remove(choice-speAttGen.size()));
						bought = true;
					}
					else
					{
						System.out.println("You can't afford the " + speAttClass.get(choice-speAttGen.size()).getAttackName() + "!");
					}
				}
				else
				{
					System.out.println("Your level isn't high enough to buy " + speAttClass.get(choice-speAttGen.size()).getAttackName() + "!");
				}
			}
			else
			{
				System.out.println("You didn't buy any Special Attacks.");
				bought = true;
			}
		}
		while(!bought);
		Util.pause();
		return player;
	}

	/**
	 * Retrieves all Special Attacks in the market in string form.
	 * <p>
	 * For every Special Attack left in the market (meaning that it is unpurchased by the player), this method
	 * transforms the value of each attribute into a string and adds the value to a String ArrayList. The ArrayList
	 * is then returned.
	 * <p>
	 * This method's entire purpose is for saving data. The returned ArrayList will be printed to a save file, which
	 * can then be read in order to load the save.
	 * <p>
	 * The Special Attack attributes are loaded into the ArrayList in the following order:
	 * <p>		- Special Attack Name
	 * <p>		- Special Attack Class
	 * <p>		- Attack Damage
	 * <p>		- EP Cost
	 * <p>		- Minimum Level
	 * <p>		- Money Cost
	 * <p>		- Critical Hit Chance
	 * <p>		- Critical Hit Damage Bonus
	 * <p>
	 * @return data, an ArrayList of Strings such that every eight lines holds the attribute data for a single
	 * Special Attack.
	 */
	public ArrayList<String> getAllString()
	{
		int numGen = speAttGen.size();
		int numClass = speAttClass.size();
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(String.valueOf(numGen));
		for(SpecialAttack item : speAttGen)
		{
			data.add(item.getAttackName());
			data.add(item.getAvailClass());
			data.add(String.valueOf(item.getAttackDamage()));
			data.add(String.valueOf(item.getExtraPoints()));
			data.add(String.valueOf(item.getMinLevel()));
			data.add(String.valueOf(item.getCost()));
			data.add(String.valueOf(item.getCritChance()));
			data.add(String.valueOf(item.getCritBonus()));
		}
		
		data.add(String.valueOf(numClass));
		for(SpecialAttack item : speAttClass)
		{
			data.add(item.getAttackName());
			data.add(item.getAvailClass());
			data.add(String.valueOf(item.getAttackDamage()));
			data.add(String.valueOf(item.getExtraPoints()));
			data.add(String.valueOf(item.getMinLevel()));
			data.add(String.valueOf(item.getCost()));
			data.add(String.valueOf(item.getCritChance()));
			data.add(String.valueOf(item.getCritBonus()));
		}
		
		return data;
	}

	/**
	 * Initializes the Market of Special Attacks with preset data.
	 * <p>
	 * This method is meant to be used in conjunction with saving and loading. Whereas {@link #getAllString} will
	 * create a String ArrayList from a currently existing Market to save to a file, this method will take in a String
	 * ArrayList read in from a file and use the data to re-initialize the Market as it was when it was saved.
	 * <p>
	 * The ArrayList must be in the same format as the ArrayList produced by {@link #getAllString}.
	 * <p>
	 * @param data The String ArrayList containing the Special Attack attributes.
	 */
	public void setAllString(ArrayList<String> data)
	{
		ArrayList<SpecialAttack> inDataGen = new ArrayList<SpecialAttack>();
		ArrayList<SpecialAttack> inDataClass = new ArrayList<SpecialAttack>();
		
		int numGen = Integer.parseInt(data.remove(0));
		for(int i = 0; i < numGen; i++)
		{
			String inName = data.remove(0);
			String inClass = data.remove(0);
			double inDam = Double.parseDouble(data.remove(0));
			double inEP = Double.parseDouble(data.remove(0));
			double inLvl = Double.parseDouble(data.remove(0));
			int inCost = Integer.parseInt(data.remove(0));
			int inCritChan = Integer.parseInt(data.remove(0));
			double inCritBon = Double.parseDouble(data.remove(0));
			inDataGen.add(new SpecialAttack(inName, inClass, inDam, inEP, inLvl, inCost, inCritChan, inCritBon));
		}
		speAttGen = inDataGen;
		
		int numClass = Integer.parseInt(data.remove(0));
		for(int i = 0; i < numClass; i++)
		{
			String inName = data.remove(0);
			String inClass = data.remove(0);
			double inDam = Double.parseDouble(data.remove(0));
			double inEP = Double.parseDouble(data.remove(0));
			double inLvl = Double.parseDouble(data.remove(0));
			int inCost = Integer.parseInt(data.remove(0));
			int inCritChan = Integer.parseInt(data.remove(0));
			double inCritBon = Double.parseDouble(data.remove(0));
			inDataClass.add(new SpecialAttack(inName, inClass, inDam, inEP, inLvl, inCost, inCritChan, inCritBon));
		}
		speAttClass = inDataClass;
	}
}