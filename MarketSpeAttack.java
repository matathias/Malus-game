import java.util.*;
import java.text.DecimalFormat;

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
	public MarketSpeAttack (ArrayList<ArrayList> data)
	{
		speAttGen = data.get(0);
		speAttClass = data.get(1);
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
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur")) //10% cheaper
		{
			speAttGen.add(new SpecialAttack()); //Throw
			speAttGen.add(new SpecialAttack()); //Slam
			speAttGen.add(new SpecialAttack()); //Overload
			speAttGen.add(new SpecialAttack()); //Machina Chaos
			speAttGen.add(new SpecialAttack()); //Penultima Chaos
			speAttGen.add(new SpecialAttack()); //Ultima Chaos (high level)
		}
		else
		{
			speAttGen.add(new SpecialAttack()); //Throw
			speAttGen.add(new SpecialAttack()); //Slam
			speAttGen.add(new SpecialAttack()); //Overload
			speAttGen.add(new SpecialAttack()); //Machina Chaos
			speAttGen.add(new SpecialAttack()); //Penultima Chaos
			speAttGen.add(new SpecialAttack()); //Ultima Chaos (high level)
		}
	}
	private void initClassSpeAtt()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			speAttClass.add(new SpecialAttack()); //Bullet Blitz (all three: low dam, high(ish) ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Bullet Storm
			speAttClass.add(new SpecialAttack()); //Bullet Hell
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			speAttClass.add(new SpecialAttack()); //Flamestrike
			speAttClass.add(new SpecialAttack()); //Cleave
			speAttClass.add(new SpecialAttack()); //Berserk (high dam, high ep, high crit chance, low crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			speAttClass.add(new SpecialAttack()); //Forced Response (low dam, low ep, low crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack()); //Defense's Offense (low dam, high ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Guard's Strength (high dam, high ep, low crit chance, low crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			speAttClass.add(new SpecialAttack()); //Fire 			(high dam, low ep, low crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack()); //Flux 			(high dam, high ep, low crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Thunder 		(mid dam, mid ep, mid crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Luna			(low dam, high ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Chaos Claw		(mid dam, high ep, low crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Chaos Strike	(high dam, high ep, high crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack()); //Chaos Blast 	(high dam, high ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Ultimate Sacrifice (high level, high damage, high EP cost, very low crit chance, high crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			speAttClass.add(new SpecialAttack()); //Forced Response(low dam, low ep, low crit chance, low crit bonus)
			speAttClass.add(new SpecialAttack()); //Lightning
			speAttClass.add(new SpecialAttack()); //Shining Blow
			speAttClass.add(new SpecialAttack()); //Chaos' Light
			speAttClass.add(new SpecialAttack()); //Ultimate Light (high level, high dam, high ep, mid crit chance, low crit bonus)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			speAttClass.add(new SpecialAttack()); //Demand's Supply
			speAttClass.add(new SpecialAttack()); //Hostile Takeover (low dam, mid ep, high crit chance, high crit bonus)
			speAttClass.add(new SpecialAttack()); //Monopoly (high dam, high ep, high crit chance, high crit bonus)
		}
	}
	public Player speAttMarket(Player p)
	{
		player = p;
		int counter = 0;
		boolean bought = false;
		System.out.println("Welcome to the Special Attack Market!");
		System.out.println("You can buy Special Attacks here.");
		System.out.println("Special Attacks are more powerful than regular attacks but they require EP to use.");
		Util.pause();
		System.out.println("-----------------------Special Attacks-----------------------");
		for(int a = 0; a<speAttGen.size(); a++)
		{
			counter++;
			System.out.println(counter + ": " + speAttGen.get(a).marketToString());
		}
		System.out.println("--------------------Class Special Attacks--------------------");
		for(int a = 0; a<speAttClass.size(); a++)
		{
			counter++;
			System.out.println(counter + ": " + speAttClass.get(a).marketToString());
		}
		counter++;
		System.out.println(counter + ": Don't buy anything");
		System.out.println("Your Money: " + player.getMoney());
		do
		{
			int choice = Util.numberSelect("",counter)-1;
			if(choice <speAttGen.size())
			{
				if(player.getLvl()>= speAttGen.get(choice).getMinLevel())
				{
					if(player.getMoney() >= speAttGen.get(choice).getCost())
					{
						System.out.println("You bought " + speAttGen.get(choice).getAttackName());
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
			else if(choice < (speAttGen.size()+speAttClass.size()) && choice > speAttGen.size())
			{
				if(player.getLvl()>= speAttClass.get(choice).getMinLevel())
				{
					if(player.getMoney() >= speAttClass.get(choice).getCost())
					{
						choice -= speAttGen.size();
						System.out.println("You bought " + speAttClass.get(choice).getAttackName() + "!");
						buySpeAtt(speAttClass.remove(choice));
						bought = true;
					}
					else
					{
						System.out.println("You can't afford the " + speAttGen.get(choice).getAttackName() + "!");
					}
				}
				else
				{
					System.out.println("Your level isn't high enough to buy " + speAttClass.get(choice).getAttackName() + "!");
				}
			}
			else
			{
				System.out.println("You didn't buy any Special Attacks.");
				bought = true;
			}
		}
		while(!bought);
		return player;
	}
	public ArrayList<ArrayList> getAll()
	{
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		data.add(speAttGen);
		data.add(speAttClass);
		return data;
	}
	public void setAll(ArrayList<ArrayList> data)
	{
		speAttGen = data.get(0);
		speAttClass = data.get(1);
	}
}