import java.util.*;

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
	public MarketHealing(ArrayList<String> data)
	{
		//Meant to be used with setAll methods when loading from save.
		healGen = new ArrayList<Healing>();
		healClass = new ArrayList<Healing>();
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
	private void buyHealing(Healing h)
	{
		player.addHealing(h);
		player.subtractMoney(h.getCost());
	}
	private void initGeneralHealing() //(name,healedHP,usedEP,minLevel,cost) (more expensive than the comparable class spells)
	{
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur")) //10% cheaper
		{
			healGen.add(new Healing("Heal","All",25,10,8,(int)(.9*150))); //Heal (-EP,+HP)
			healGen.add(new Healing("HealUP","All",400,100,30,(int)(.9*2050))); //HealUp (--EP, ++HP)
			healGen.add(new Healing("Machina Heal","All",-1000,-200,36,(int)(.9*2000))); //Machina Heal(-HP, +EP)
		}
		else
		{
			healGen.add(new Healing("Heal","All",25,10,8,150)); //Heal (-EP,+HP)
			healGen.add(new Healing("HealUP","All",400,100,30,2050)); //HealUp (--EP, ++HP)
			healGen.add(new Healing("Machina Heal","All",-1000,-200,36,2000)); //Machina Heal(-HP, +EP)
		}
	}
	//for spells that increase EP instead of HP, have both be negative values
	private void initClassHealing()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			healClass.add(new Healing("First Aid","Commando, Berserker",100,25,20,1000)); //First Aid(-EP,+HP)
			healClass.add(new Healing("Second Aid","Commando, Berserker",4000,1250,45,15000)); //Second Aid(--EP, ++HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			healClass.add(new Healing("First Aid","Commando, Berserker",100,25,20,1000)); //First Aid(-EP,+HP)
			healClass.add(new Healing("Second Aid","Commando, Berserker",4000,1250,45,15000)); //Second Aid(--EP, ++HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			healClass.add(new Healing("Last Stand","Sentinel",550,150,18,1000)); //Last Stand(-EP, +HP)
			healClass.add(new Healing("Ultimate Defense","Sentinel",1800,500,30,2250)); //Ultimate Defense (--EP, ++HP) (consumes 75% of level 30? Sentinel EP)
			healClass.add(new Healing("Sentinel's Sacrifice","Sentinel",15000,2600,44,15500)); //Sentinel's Sacrifice (---EP, +++HP) (consumes 75% of level 50? Sentinel EP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			healClass.add(new Healing("Offense's Defense","Ravager",200,75,20,1100)); //Offense's Defense(++HP, --EP)
			healClass.add(new Healing("Final Stand","Ravager",4000,2000,40,8000)); //Final Stand (+++HP, ---EP)
			healClass.add(new Healing("Ravager's Sacrifice","Ravager",-2000,-4000,42,7000)); //Ravager's Sacrifice (---HP, +++EP) (consumes 75% of level 50? Ravager HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			healClass.add(new Healing("Mend","Reliever",500,100,16,900)); //Mend (++HP, -EP)
			healClass.add(new Healing("Healer's Relief","Reliever",-500,-90,20,1000)); //Healer's Relief (--HP, ++EP)
			healClass.add(new Healing("Inversi","Reliever",-2000,-450,40,6500)); //Inversi (---HP, +++EP)
			healClass.add(new Healing("Pacifistic Defense","Reliever",750,175,24,1250)); //Pacifistic Defense(+++HP, --EP)
			healClass.add(new Healing("Final Stand","Reliever",4500,1500,32,2500)); //Final Stand(+++HP, ---EP)
			healClass.add(new Healing("Ultima Relief","Reliever",12000,2000,46,15000)); //Ultima Relief (+++HP, --EP) (consumes 50% of level 75? Reliever HP)
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			healClass.add(new Healing("Marginal Opportunity Cost","Entreprenuer",150,25,16,700)); //Marginal Opportunity Cost (-EP, +HP)
			healClass.add(new Healing("Total Opportunity Cost","Entreprenuer",5000,1000,40,8000)); //Total Opportunity Cost (--EP, ++HP)
		}
	}
	private int showHealing()
	{
		String topHeader = "+----------------------------------Healing-------------------------------------+";
		String bottomHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		int a;
		
		for(a = 0; a < healGen.size() + healClass.size(); a++)
		{
			String hN, hHP, hEP, hMinLvl, hCost;
			if(a < healGen.size())
			{
				hN = healGen.get(a).getHealName();
				hHP = String.valueOf((int)healGen.get(a).getHealedHP());
				hEP = String.valueOf((int)healGen.get(a).getUsedEP());
				hCost = String.valueOf((int)healGen.get(a).getCost());
				hMinLvl = String.valueOf((int)healGen.get(a).getMinLevel());
			}
			else
			{
				hN = healClass.get(a-healGen.size()).getHealName();
				hHP = String.valueOf((int)healClass.get(a-healGen.size()).getHealedHP());
				hEP = String.valueOf((int)healClass.get(a-healGen.size()).getUsedEP());
				hCost = String.valueOf((int)healClass.get(a-healGen.size()).getCost());
				hMinLvl = String.valueOf((int)healClass.get(a-healGen.size()).getMinLevel());
			}
			String number = String.valueOf(a+1);
			String row1 = "";
			String row2 = "";
			int numSpaces = 0;
			
			if(a+1 < 10)
				row1 += "|  " + number + ": " + hN;
			else
				row1 += "| " + number + ": " + hN;
			
			numSpaces = 6 + 25 - hN.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			
			row1 += "Heals";
			numSpaces = 6 - hHP.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			row1 += hHP + "HP       Uses ";
			numSpaces = 5 - hEP.length();
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			row1 += hEP + "EP          |";
			System.out.println(row1);
			
			row2 += "|                                    Cost: " + hCost;
			numSpaces = 7 + 7 - hCost.length();
			for(int i = 0; i<numSpaces; i++)
				row2 += " ";
			
			if(hMinLvl.length() < 2)
				row2 += "Min Level:  " + hMinLvl + "         |";
			else
				row2 += "Min Level: " + hMinLvl + "         |";
			
			System.out.println(row2);
		}
		System.out.println(midHeader);
		System.out.println(bottomHeader);
		return a;
	}
	public Player healingMarket(Player p)
	{
		player = p;
		int counter = 0;
		boolean bought = false;
		System.out.println("\nWelcome to the Healing Market!");
		System.out.println("You can buy Healing spells here.");
		System.out.println("Healing Spells can only be used during battle.\nThey consume EP to heal HP, or use HP to replenish EP.");
		System.out.println("If the presented HP and EP values are negative,\n\tthe spell uses HP to heal EP.");
		System.out.println("--Beware! Using these spells when your HP is below the threshold \n\twill result in death!");
		Util.pause();
		
		counter = showHealing();
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
			else if(choice < (healGen.size()+healClass.size()) && choice >= healGen.size())
			{
				if(player.getLvl()>= healClass.get(choice - healGen.size()).getMinLevel())
				{
					if(player.getMoney() >= healClass.get(choice - healGen.size()).getCost())
					{
						System.out.println("You bought " + healClass.get(choice - healGen.size()).getHealName() + "!");
						buyHealing(healClass.remove(choice - healGen.size()));
						bought = true;
					}
					else
					{
						System.out.println("You can't afford the " + healClass.get(choice - healGen.size()).getHealName() + "!");
					}
				}
				else
				{
					System.out.println("Your level isn't high enough to buy " + healClass.get(choice - healGen.size()).getHealName() + "!");
				}
			}
			else
			{
				System.out.println("You didn't buy any Healing spells.");
				bought = true;
			}
		}
		while(!bought);
		Util.passTime(1000000000);
		return player;
	}
	public ArrayList<String> getAllString()
	{
		int numGen = healGen.size();
		int numClass = healClass.size();
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(String.valueOf(numGen));
		for(int i = 0; i < numGen; i++)
		{
			data.add(healGen.get(i).getHealName());
			data.add(healGen.get(i).getAvailClass());
			data.add(String.valueOf(healGen.get(i).getHealedHP()));
			data.add(String.valueOf(healGen.get(i).getUsedEP()));
			data.add(String.valueOf(healGen.get(i).getMinLevel()));
			data.add(String.valueOf(healGen.get(i).getCost()));
		}
		
		data.add(String.valueOf(numClass));
		for(int i = 0; i < numClass; i++)
		{
			data.add(healClass.get(i).getHealName());
			data.add(healClass.get(i).getAvailClass());
			data.add(String.valueOf(healClass.get(i).getHealedHP()));
			data.add(String.valueOf(healClass.get(i).getUsedEP()));
			data.add(String.valueOf(healClass.get(i).getMinLevel()));
			data.add(String.valueOf(healClass.get(i).getCost()));
		}
		
		return data;
	}
	public void setAllString(ArrayList<String> data)
	{
		ArrayList<Healing> inDataGen = new ArrayList<Healing>();
		ArrayList<Healing> inDataClass = new ArrayList<Healing>();
		
		int numGen = Integer.parseInt(data.remove(0));
		for(int i = 0; i < numGen; i++)
		{
			String inName = data.remove(0);
			String inClass = data.remove(0);
			double inHeal = Double.parseDouble(data.remove(0));
			double inEP = Double.parseDouble(data.remove(0));
			int inLvl = Integer.parseInt(data.remove(0));
			int inCost = Integer.parseInt(data.remove(0));
			inDataGen.add(new Healing(inName, inClass, inHeal, inEP, inLvl, inCost));
		}
		healGen = inDataGen;
		
		int numClass = Integer.parseInt(data.remove(0));
		for(int i = 0; i < numClass; i++)
		{
			String inName = data.remove(0);
			String inClass = data.remove(0);
			double inHeal = Double.parseDouble(data.remove(0));
			double inEP = Double.parseDouble(data.remove(0));
			int inLvl = Integer.parseInt(data.remove(0));
			int inCost = Integer.parseInt(data.remove(0));
			inDataClass.add(new Healing(inName, inClass, inHeal, inEP, inLvl, inCost));
		}
		healClass = inDataClass;
	}
}