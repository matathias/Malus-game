import java.util.*;

public class MarketDefense//change Util.numberSelect() to proper parameters
{
	private Player player;
	private ArrayList <Defense> defenseGen; //general special attacks
	private ArrayList <Defense> defenseClass; //class-specific special attacks

	public MarketDefense(Player p)
	{
		player = p;
		defenseGen = new ArrayList<Defense>();
		defenseClass = new ArrayList<Defense>();
		initGeneralDefenses();
		initClassDefenses();
	}
	public MarketDefense(ArrayList<String> data)
	{
		//Meant to be used with setAll when loading from save.
		defenseGen = new ArrayList<Defense>();
		defenseClass = new ArrayList<Defense>();
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
	private void buyDefense(Defense d)
	{
		player.subtractMoney(d.getCost());
		player.addDefense(d);
		//player.addMaxHealth(d.getAddHP());
		//player.addMaxEP(d.getAddEP());
	}
	private void initGeneralDefenses() //(name,addHP,addEP,cost)
	{
		double costMult;
		
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))//10% cheaper
			costMult = .9;
		else
			costMult = 1.0;

		//HP
		defenseGen.add(new Defense("Wooden Shield",20,0,(int)(costMult*90))); //Wooden Shield
		defenseGen.add(new Defense("Iron Shield",50,0,(int)(costMult*130))); //Iron Shield
		defenseGen.add(new Defense("Steel Shield",100,0,(int)(costMult*250))); //Steel Shield
		//EP
		defenseGen.add(new Defense("Channel Shield",0,20,(int)(costMult*115))); //Channel Shield
		defenseGen.add(new Defense("Conduit Shield",0,50,(int)(costMult*225))); //Conduit Shield
		defenseGen.add(new Defense("Chaos Shield",0,100,(int)(costMult*300))); //Chaos Shield
		//Both
		defenseGen.add(new Defense("Machina Shield",200,200,(int)(costMult*750))); //Machina Shield
		defenseGen.add(new Defense("Penultima Shield",500,500,(int)(costMult*1250))); //Penultima Shield
		defenseGen.add(new Defense("Ultima Shield",2000,2000,(int)(costMult*2000))); //Ultima Shield
	}
	private void initClassDefenses()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			defenseClass.add(new Defense("Bullet-Proof Vest",25,0,50)); //Bullet-Proof Vest = +HP
			defenseClass.add(new Defense("Riot Shield",40,0,120)); //Riot Shield = +HP
			defenseClass.add(new Defense("Off-Hand Ammo Pack",0,30,200)); //Off-hand Ammo Pack = +EP
			defenseClass.add(new Defense("Full Chaos Gear",1000,500,1500)); //Full Chaos Gear = +HP, +EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			defenseClass.add(new Defense("Steel Armor",50,0,65)); //Steel Armor = +HP
			defenseClass.add(new Defense("Hand Guards",100,0,130)); //Hand-guards = +HP
			defenseClass.add(new Defense("Chaos Sheath",0,50,250)); //Chaos Sheath = +EP
			defenseClass.add(new Defense("Full Body Armor",400,200,1000)); //Full Body Armor = +HP,+EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			defenseClass.add(new Defense("Iron Armor",50,0,50)); //Iron Armor = +HP
			defenseClass.add(new Defense("Steel Armor",100,0,130)); //Steel Armor = +HP
			defenseClass.add(new Defense("Chaos Armor",0,100,280)); //Chaos Armor = +EP
			defenseClass.add(new Defense("Ultimus Armor",1000,100,1200)); //Ultimus Armor = ++HP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			defenseClass.add(new Defense("Tome Sleeve",50,0,50)); //Tome Sleeve = +HP
			defenseClass.add(new Defense("Conduit Enhancer",0,100,175)); //Conduit Enhancer = +EP
			defenseClass.add(new Defense("Chaos Enhancer",0,300,325)); //Chaos Enhancer = +EP
			defenseClass.add(new Defense("Magi Ultimus Shield",500,1000,1500)); //Magi Ultimus Shield = +HP, +EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			defenseClass.add(new Defense("Staff Guard",30,0,50)); //Staff Guard = +HP
			defenseClass.add(new Defense("Conduit Enhancer",0,100,175)); //Conduit Enhancer = +EP
			defenseClass.add(new Defense("Chaos Enhancer",0,300,325)); //Chaos Enhancer = +EP
			defenseClass.add(new Defense("Magi Ultimus Shield",500,1000,1500)); //Magi Ultimus Shield = +HP, +EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			defenseClass.add(new Defense("Damage Insurance",40,0,65)); //Damage Insurance = +HP
			defenseClass.add(new Defense("Weapon Insurance",0,40,100)); //Weapon Insurance = +EP
			defenseClass.add(new Defense("Chaos Insurance",50,100,280)); //Chaos Insurance = +EP, +HP
			defenseClass.add(new Defense("Platinum Insurance",500,100,1000)); //Platinum Insurance = +HP, +EP
		}
	}
	private int showDefenses()
	{
		String topHeader = "+---------------------------------Defenses-------------------------------------+";
		String bottomHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		int a;
		
		for(a = 0; a < defenseGen.size() + defenseClass.size(); a++)
		{
			String defN, defHP, defEP, defCost;
			if(a < defenseGen.size())
			{
				defN = defenseGen.get(a).getDefenseName();
				defHP = String.valueOf((int)defenseGen.get(a).getAddHP());
				defEP = String.valueOf((int)defenseGen.get(a).getAddEP());
				defCost = String.valueOf((int)defenseGen.get(a).getCost());
			}
			else
			{
				defN = defenseClass.get(a - defenseGen.size()).getDefenseName();
				defHP = String.valueOf((int)defenseClass.get(a - defenseGen.size()).getAddHP());
				defEP = String.valueOf((int)defenseClass.get(a - defenseGen.size()).getAddEP());
				defCost = String.valueOf((int)defenseClass.get(a - defenseGen.size()).getCost());
			}
			String number = String.valueOf(a+1);
			String row1 = "";
			int numSpaces = 0;
			
			if(a+1 < 10)
				row1 += "|  " + number + ": " + defN;
			else
				row1 += "| " + number + ": " + defN;
			
			numSpaces = 4 + 19 - defN.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			
			row1 += "Adds";
			numSpaces = 6 - defHP.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			row1 += defHP + "HP    Adds";
			numSpaces = 6 - defEP.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			row1 += defEP + "EP        Cost: " + defCost;
			
			numSpaces = 8 - defCost.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			row1 += "|";
			System.out.println(row1);
		}
		System.out.println(midHeader);
		System.out.println(bottomHeader);
		return a;
	}
	public Player defenseMarket(Player p)
	{
		player = p;
		int counter = 0;
		System.out.println("\nWelcome to the Defense Market!");
		System.out.println("You can buy HP and EP increasing items here.");
		System.out.println("Once bought, your HP and/or EP is permanently raised.");
		Util.pause();
		
		counter = showDefenses();
		counter++;
		
		System.out.println(counter + ": Don't buy anything");
		System.out.println("Your Money: " + player.getMoney());
		System.out.println("Current level:  " + (int)player.getLvl());
		System.out.println("Current Max HP: " + (int)player.getMaxHealth());
		System.out.println("Current Max EP: " + (int)player.getMaxEP());
		int choice = Util.numberSelect("",counter)-1;
		if(choice <defenseGen.size())
		{
			if(player.getMoney() >= defenseGen.get(choice).getCost())
			{
				System.out.println("You bought the " + defenseGen.get(choice).getDefenseName() + "!");
				buyDefense(defenseGen.remove(choice));
			}
			else
			{
				System.out.println("You can't afford the " + defenseGen.get(choice).getDefenseName() + "!");
			}
		}
		else if(choice < (defenseGen.size()+defenseClass.size()) && choice >= defenseGen.size())
		{
			if(player.getMoney() >= defenseClass.get(choice-defenseGen.size()).getCost())
			{
				System.out.println("You bought the " + defenseClass.get(choice-defenseGen.size()).getDefenseName() + "!");
				buyDefense(defenseClass.remove(choice-defenseGen.size()));
			}
			else
			{
				System.out.println("You can't afford the " + defenseClass.get(choice-defenseGen.size()).getDefenseName() + "!");
			}
		}
		else
			System.out.println("You didn't buy any defenses.");
		Util.pause();
		return player;
	}
	public ArrayList<String> getAllString()
	{
		int numGen = defenseGen.size();
		int numClass = defenseClass.size();
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(String.valueOf(numGen));
		for(int i = 0; i < numGen; i++)
		{
			data.add(defenseGen.get(i).getDefenseName());
			data.add(String.valueOf(defenseGen.get(i).getAddHP()));
			data.add(String.valueOf(defenseGen.get(i).getAddEP()));
			data.add(String.valueOf(defenseGen.get(i).getCost()));
		}
		
		data.add(String.valueOf(numClass));
		for(int i = 0; i < numClass; i++)
		{
			data.add(defenseClass.get(i).getDefenseName());
			data.add(String.valueOf(defenseClass.get(i).getAddHP()));
			data.add(String.valueOf(defenseClass.get(i).getAddEP()));
			data.add(String.valueOf(defenseClass.get(i).getCost()));
		}
		
		return data;
	}
	public void setAllString(ArrayList<String> data)
	{
		ArrayList<Defense> inDataGen = new ArrayList<Defense>();
		ArrayList<Defense> inDataClass = new ArrayList<Defense>();
		
		int numGen = Integer.parseInt(data.remove(0));
		for(int i = 0; i < numGen; i++)
		{
			String inName = data.remove(0);
			double inHP = Double.parseDouble(data.remove(0));
			double inEP = Double.parseDouble(data.remove(0));
			int inCost = Integer.parseInt(data.remove(0));
			inDataGen.add(new Defense(inName, inHP, inEP, inCost));
		}
		defenseGen = inDataGen;
		
		int numClass = Integer.parseInt(data.remove(0));
		for(int i = 0; i < numClass; i++)
		{
			String inName = data.remove(0);
			double inHP = Double.parseDouble(data.remove(0));
			double inEP = Double.parseDouble(data.remove(0));
			int inCost = Integer.parseInt(data.remove(0));
			inDataClass.add(new Defense(inName, inHP, inEP, inCost));
		}
		defenseClass = inDataClass;
	}
}