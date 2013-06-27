import java.util.*;
import java.text.DecimalFormat;

public class MarketHealing
{
	private Player player;
	private ArrayList <Healing> healGen;
	private ArrayList <Healing> healClass;

	public MarketHealing(Player p)
	{
		player = p;
		healGen = new ArrayList<Healing>();
		healClass = new ArrayList<Healing>();
		initGeneralHealing();
		initClassHealing();
	}
	public MarketHealing(ArrayList<ArrayList> data)
	{
		healGen = data.get(0);
		healClass = data.get(1);
	}
	public Player getPlayer()
	{
		return player;
	}
	public void setPlayer(Player p)
	{
		player = p;
	}
	private void buyHealing(Healing h)
	{
		player.addHealing(h);
		player.subtractMoney(h.getCost());
	}
	private void initGeneralHealing() //(name,healedHP,usedEP,minLevel,cost) (more expensive than the comparable class spells)
	{
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur")) //10% cheaper
		{
			healGen.add(new Healing()); //Heal (-EP,+HP)
			healGen.add(new Healing()); //HealUp (--EP, ++HP)
			healGen.add(new Healing()); //Machina Heal(-HP, +EP)
		}
		else
		{
			healGen.add(new Healing()); //Heal (-EP,+HP)
			healGen.add(new Healing()); //HealUp (--EP, ++HP)
			healGen.add(new Healing()); //Machina Heal(-HP, +EP)
		}
	}
	//for spells that increase EP instead of HP, have both be negative values
	private void initClassHealing()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			healClass.add(new Healing()); //First Aid(-EP,+HP)
			healClass.add(new Healing()); //Second Aid(--EP, ++HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			healClass.add(new Healing()); //First Aid(-EP,+HP)
			healClass.add(new Healing()); //Second Aid(--EP, ++HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			healClass.add(new Healing()); //Last Stand(-EP, +HP)
			healClass.add(new Healing()); //Ultimate Defense (--EP, ++HP) (consumes 75% of level 30? Sentinel EP)
			healClass.add(new Healing()); //Sentinel's Sacrifice (---EP, +++HP) (consumes 75% of level 50? Sentinel EP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			healClass.add(new Healing()); //Offense's Defense(++HP, --EP)
			healClass.add(new Healing()); //Final Stand (+++HP, ---EP)
			healClass.add(new Healing()); //Ravager's Sacrifice (---HP, +++EP) (consumes 75% of level 50? Ravager HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			healClass.add(new Healing()); //Mend (++HP, -EP)
			healClass.add(new Healing()); //Healer's Relief (--HP, ++EP)
			healClass.add(new Healing()); //Inversi (---HP, +++EP)
			healClass.add(new Healing()); //Pacifistic Defense(+++HP, --EP)
			healClass.add(new Healing()); //Final Stand(+++HP, ---EP)
			healClass.add(new Healing()); //Ultima Relief (+++HP, --EP) (consumes 50% of level 75? Reliever HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			healClass.add(new Healing()); //Marginal Opportunity Cost (-EP, +HP)
			healClass.add(new Healing()); //Total Opportunity Cost (--EP, ++HP)
		}
	}
	public Player healingMarket(Player p)
	{
		player = p;
		int counter = 0;
		boolean bought = false;
		System.out.println("Welcome to the Healing Market!");
		System.out.println("You can buy Healing spells here.");
		System.out.println("Healing Spells can only be used during battle; they consume EP to heal HP, or HP to heal EP.");
		System.out.println("If the presented HP and EP values are negative, then the spell uses HP to heal EP.");
		System.out.println("--Beware! Using these spells when your HP is below the threshold will result in death!");
		Util.pause();
		System.out.println("-----------------------Healing-----------------------");
		for(int a = 0; a<healGen.size(); a++)
		{
			counter++;
			System.out.println(counter + ": " + healGen.get(a).marketToString());
		}
		System.out.println("--------------------Class Healing--------------------");
		for(int a = 0; a<healClass.size(); a++)
		{
			counter++;
			System.out.println(counter + ": " + healClass.get(a).marketToString());
		}
		counter++;
		System.out.println(counter + ": Don't buy anything");
		System.out.println("Your Money: " + player.getMoney());
		do
		{
			int choice = Util.numberSelect("",counter)-1;
			if(choice <healGen.size())
			{
				if(player.getLvl()>= healGen.get(choice).getMinLevel())
				{
					if(player.getMoney() >= healGen.get(choice).getCost())
					{
						System.out.println("You bought " + healGen.get(choice).getHealName() + "!");
						buyHealing(healGen.remove(choice));
						bought = true;
					}
					else
					{
						System.out.println("You can't afford the " + healGen.get(choice).getHealName() + "!");
					}
				}
				else
				{
					System.out.println("Your level isn't high enough to buy " + healGen.get(choice).getHealName() + "!");
				}
			}
			else if(choice < (healGen.size()+healClass.size()) && choice > healGen.size())
			{
				if(player.getLvl()>= healClass.get(choice).getMinLevel())
				{
					if(player.getMoney() >= healClass.get(choice).getCost())
					{
						choice -= healGen.size();
						System.out.println("You bought " + healClass.get(choice).getHealName() + "!");
						buyHealing(healClass.remove(choice));
						bought = true;
					}
					else
					{
						System.out.println("You can't afford the " + healClass.get(choice).getHealName() + "!");
					}
				}
				else
				{
					System.out.println("Your level isn't high enough to buy " + healClass.get(choice).getHealName() + "!");
				}
			}
			else
			{
				System.out.println("You didn't buy any Healing spells.");
				bought = true;
			}
		}
		while(!bought);
		return player;
	}
	public ArrayList<ArrayList> getAll()
	{
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		data.add(healGen);
		data.add(healClass);
		return data;
	}
	public void setAll(ArrayList<ArrayList> data)
	{
		healGen = data.get(0);
		healClass = data.get(1);
	}
}