import java.util.*;

public class MarketSpeAttack//change Util.numberSelect() to proper parameters
{
	private Player player;
	private ArrayList <SpecialAttack> speAttGen; //general special attacks
	private ArrayList <SpecialAttack> speAttClass; //class-specific special attacks

	public MarketSpeAttack(Player p)
	{
		player = p;
		speAttGen = new ArrayList<SpecialAttack>();
		speAttClass = new ArrayList<SpecialAttack>();
		initGeneralSpeAtt();
		initClassSpeAtt();
	}
	public MarketSpeAttack(ArrayList<String> data)
	{
		//Meant to be used with setAll methods when loading from save.
		speAttGen = new ArrayList<SpecialAttack>();
		speAttClass = new ArrayList<SpecialAttack>();
		setAllString(data);
	}
	public Player getPlayer()
	{
		return player;
	}
	public void setPlayer(Player p)
	{
		player = p;
	}
	private void buySpeAtt(SpecialAttack sA)
	{
		player.addSpecialAttack(sA);
		player.subtractMoney(sA.getCost());
	}
	private void initGeneralSpeAtt() //(name,attackDamage,extraPoints,minLevel,cost,criticalChance,critBonus)
	{
		double costMult;
		
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))//10% cheaper
			costMult = .9;
		else
			costMult = 1.0;
		
		speAttGen.add(new SpecialAttack("Destruction","All",150,40,9,(int)(200*costMult),5,1.5)); //Destruction
		speAttGen.add(new SpecialAttack("Foe Crash","All",350,100,16,(int)(500*costMult),10,1.5)); //Foe Crash
		speAttGen.add(new SpecialAttack("Chaos Drive","All",500,175,22,(int)(2000*costMult),15,1.5)); //Chaos Drive
		speAttGen.add(new SpecialAttack("Machina Chaos","All",1000,450,30,(int)(6000*costMult),25,2)); //Machina Chaos
		speAttGen.add(new SpecialAttack("Penultima Chaos","All",2500,600,37,(int)(10000*costMult),32,3.5)); //Penultima Chaos
		speAttGen.add(new SpecialAttack("Ultima Chaos","All",50000,4300,48,(int)(100000*costMult),50,5)); //Ultima Chaos (high level)
	}
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
				saCHC = String.valueOf((int)speAttGen.get(a).getCritChance());
				saCost = String.valueOf((int)speAttGen.get(a).getCost());
				saMinLvl = String.valueOf((int)speAttGen.get(a).getMinLevel());
				saEP = String.valueOf((int)speAttGen.get(a).getExtraPoints());
				saCB = String.valueOf(speAttGen.get(a).getCritBonus());
			}
			else
			{
				saN = speAttClass.get(a-speAttGen.size()).getAttackName();
				saDam = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getAttackDamage());
				saCHC = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getCritChance());
				saCost = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getCost());
				saMinLvl = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getMinLevel());
				saEP = String.valueOf((int)speAttClass.get(a-speAttGen.size()).getExtraPoints());
				saCB = String.valueOf(speAttClass.get(a-speAttGen.size()).getCritBonus());
			}
			String number = String.valueOf(a+1);
			String row1 = "";
			String row2 = "";
			int numSpaces = 0;
			
			if(a+1 < 10)
				row1 += "|  " + number + ": " + saN;
			else
				row1 += "| " + number + ": " + saN;
			
			numSpaces = 10 + 18 - saN.length();
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
	public Player speAttMarket(Player p)
	{
		player = p;
		int counter = 0;
		boolean bought = false;
		System.out.println("\nWelcome to the Special Attack Market!");
		System.out.println("You can buy Special Attacks here.");
		System.out.println("Special Attacks are more powerful than regular attacks,\n but they require EP to use.");
		Util.pause();
		counter = showSpeAttacks();
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
	public ArrayList<String> getAllString()
	{
		int numGen = speAttGen.size();
		int numClass = speAttClass.size();
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(String.valueOf(numGen));
		for(int i = 0; i < numGen; i++)
		{
			data.add(speAttGen.get(i).getAttackName());
			data.add(speAttGen.get(i).getAvailClass());
			data.add(String.valueOf(speAttGen.get(i).getAttackDamage()));
			data.add(String.valueOf(speAttGen.get(i).getExtraPoints()));
			data.add(String.valueOf(speAttGen.get(i).getMinLevel()));
			data.add(String.valueOf(speAttGen.get(i).getCost()));
			data.add(String.valueOf(speAttGen.get(i).getCritChance()));
			data.add(String.valueOf(speAttGen.get(i).getCritBonus()));
		}
		
		data.add(String.valueOf(numClass));
		for(int i = 0; i < numClass; i++)
		{
			data.add(speAttClass.get(i).getAttackName());
			data.add(speAttClass.get(i).getAvailClass());
			data.add(String.valueOf(speAttClass.get(i).getAttackDamage()));
			data.add(String.valueOf(speAttClass.get(i).getExtraPoints()));
			data.add(String.valueOf(speAttClass.get(i).getMinLevel()));
			data.add(String.valueOf(speAttClass.get(i).getCost()));
			data.add(String.valueOf(speAttClass.get(i).getCritChance()));
			data.add(String.valueOf(speAttClass.get(i).getCritBonus()));
		}
		
		return data;
	}
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