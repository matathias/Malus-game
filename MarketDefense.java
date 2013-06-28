import java.util.*;
import java.text.DecimalFormat;

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
	public MarketDefense(ArrayList<ArrayList> data)
	{
		defenseGen = data.get(0);
		defenseClass = data.get(1);
	}
	public MarketDefense(ArrayList<String> data, boolean str)
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
		player.addMaxHealth(d.getAddHP());
		player.addMaxEP(d.getAddEP());
	}
	private void initGeneralDefenses() //(name,addHP,addEP,cost)
	{
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))//10% cheaper
		{
			//HP
			defenseGen.add(new Defense()); //Wooden Shield
			defenseGen.add(new Defense()); //Iron Shield
			defenseGen.add(new Defense()); //Steel Shield
			//EP
			defenseGen.add(new Defense()); //Channel Shield
			defenseGen.add(new Defense()); //Conduit Shield
			defenseGen.add(new Defense()); //Chaos Shield
			//Both
			defenseGen.add(new Defense()); //Machina Shield
			defenseGen.add(new Defense()); //Penultima Shield
			defenseGen.add(new Defense()); //Ultima Shield
		}
		else
		{
			//HP
			defenseGen.add(new Defense()); //Wooden Shield
			defenseGen.add(new Defense()); //Iron Shield
			defenseGen.add(new Defense()); //Steel Shield
			//EP
			defenseGen.add(new Defense()); //Channel Shield
			defenseGen.add(new Defense()); //Conduit Shield
			defenseGen.add(new Defense()); //Chaos Shield
			//Both
			defenseGen.add(new Defense()); //Machina Shield
			defenseGen.add(new Defense()); //Penultima Shield
			defenseGen.add(new Defense()); //Ultima Shield
		}
	}
	private void initClassDefenses()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			defenseClass.add(new Defense()); //Bullet-Proof Vest = +HP
			defenseClass.add(new Defense()); //Riot Shield = +HP
			defenseClass.add(new Defense()); //Off-hand Ammo Pack = +EP
			defenseClass.add(new Defense()); //Full Chaos Gear = +HP, +EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			defenseClass.add(new Defense()); //Steel Armor = +HP
			defenseClass.add(new Defense()); //Hand-guards = +HP
			defenseClass.add(new Defense()); //Chaos Sheath = +EP
			defenseClass.add(new Defense()); //Full Body Armor = +HP,+EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			defenseClass.add(new Defense()); //Iron Armor = +HP
			defenseClass.add(new Defense()); //Steel Armor = +HP
			defenseClass.add(new Defense()); //Chaos Armor = +EP
			defenseClass.add(new Defense()); //Ultimus Armor = ++HP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			defenseClass.add(new Defense()); //Tome Sleeve = +HP
			defenseClass.add(new Defense()); //Conduit Enhancer = +EP
			defenseClass.add(new Defense()); //Chaos Enhancer = +EP
			defenseClass.add(new Defense()); //Magi Ultimus Shield = +HP, +EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			defenseClass.add(new Defense()); //Staff Guard = +HP
			defenseClass.add(new Defense()); //Conduit Enhancer = +EP
			defenseClass.add(new Defense()); //Chaos Enhancer = +EP
			defenseClass.add(new Defense()); //Magi Ultimus Shield = +HP, +EP
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			defenseClass.add(new Defense()); //Damage Insurance = +HP
			defenseClass.add(new Defense()); //Weapon Insurance = +EP
			defenseClass.add(new Defense()); //Chaos Insurance = +EP, +HP
			defenseClass.add(new Defense()); //Platinum Insurance = +HP, +EP
		}
	}
	public Player defenseMarket(Player p)
	{
		player = p;
		int counter = 0;
		System.out.println("Welcome to the Defense Market!");
		System.out.println("You can buy HP and EP increasing items here.");
		System.out.println("Once bought, your HP and/or EP is permanently raised.");
		Util.pause();
		System.out.println("-----------------------Defenses-----------------------");
		for(int a = 0; a<defenseGen.size(); a++)
		{
			counter++;
			System.out.println(counter + ": " + defenseGen.get(a).toString());
		}
		System.out.println("--------------------Class Defenses--------------------");
		for(int a = 0; a<defenseClass.size(); a++)
		{
			counter++;
			System.out.println(counter + ": " + defenseClass.get(a).toString());
		}
		counter++;
		System.out.println(counter + ": Don't buy anything");
		System.out.println("Your Money: " + player.getMoney());
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
		else if(choice < (defenseGen.size()+defenseClass.size()) && choice > defenseGen.size())
		{
			if(player.getMoney() >= defenseGen.get(choice).getCost())
			{
				choice -= defenseGen.size();
				System.out.println("You bought the " + defenseClass.get(choice).getDefenseName() + "!");
				buyDefense(defenseClass.remove(choice));
			}
			else
			{
				System.out.println("You can't afford the " + defenseClass.get(choice).getDefenseName() + "!");
			}
		}
		else
			System.out.println("You didn't buy any defenses.");
		return player;
	}
	public ArrayList<ArrayList> getAll()
	{
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		data.add(defenseGen);
		data.add(defenseClass);
		return data;
	}
	public void setAll(ArrayList<ArrayList> data)
	{
		defenseGen = data.get(0);
		defenseClass = data.get(1);
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
		for(int i = 0; i < numGen; i++)
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