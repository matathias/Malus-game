import java.util.*;

public class MarketWeapon //change Util.numberSelect() to proper parameters
{
	private Player player;
	private ArrayList <Weapon> weapon;
	private Random rand;

	public MarketWeapon(Player p)
	{
		player = p;
		weapon = new ArrayList<Weapon>();
		rand = new Random();
		initGeneralWeapons();
		initClassWeapons();
	}
	public MarketWeapon(ArrayList<String> data)
	{
		//Meant to be used with the setAll methods when loading from save.
		rand = new Random();
		weapon = new ArrayList<Weapon>();
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
	private void buyWeapon(Weapon w)
	{
		player.setWeapon(w);
		player.subtractMoney(w.getCost());
	}

	/*Weapons:
	 *(name,damage,hp,ep,cost)
	 *General:
	 *1. Beginner's Weapon (mediocre at everything)
	 *2. Genesis Weapon
	 *3. General Weapon
	 *4. Machina Weapon (good at two things, bad at one)
	 *5. Penultima Weapon (good at two things)
	 *6. Ultima Weapon (good at everything)
	 *
	 *Class Weapons:
	 *1. Axis __
	 *2. Siphon __ (Exagerates the class's role at expense of other abilities)
	 *3. Moebius __ (Inverses the class's role)
	 *4. Class's __
	 */
	private void initGeneralWeapons()
	{
		//For determining the random elements of Machina and Penultima weapons
		double[] multipliers = {0, 0, 0};
		double[] penMult = {0, 0, 0};
		int chance = rand.nextInt(3);
		if (chance == 0)
		{
			multipliers[0] = .1;
			multipliers[1] = 1.5;
			multipliers[2] = 1.5;
			penMult[0] = 1;
			penMult[1] = 1.5;
			penMult[2] = 1.5;
		}
		else if (chance == 1)
		{
			multipliers[0] = 1.5;
			multipliers[1] = .1;
			multipliers[2] = 1.5;
			penMult[0] = 1.5;
			penMult[1] = 1;
			penMult[2] = 1.5;
		}
		else
		{
			multipliers[0] = 1.5;
			multipliers[1] = 1.5;
			multipliers[2] = .1;
			penMult[0] = 1.5;
			penMult[1] = 1.5;
			penMult[2] = 1;
		}
		
		int mac1 = (int)(multipliers[0] * 100);
		int mac2 = (int)(multipliers[1] * 100);
		int mac3 = (int)(multipliers[2] * 100);
		int pen1 = (int)(penMult[0] * 500);
		int pen2 = (int)(penMult[1] * 500);
		int pen3 = (int)(penMult[2] * 500);
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur")) //10% cheaper
		{
			weapon.add(new Weapon("Beginner's Weapon",10,0,0,(int)(.9*75))); //Beginner's weapon
			weapon.add(new Weapon("Genesis Weapon",30,5,5,(int)(.9*400))); //Genesis weapon
			weapon.add(new Weapon("General Weapon",75,50,25,(int)(.9*2500))); //General weapon
			weapon.add(new Weapon("Machina Weapon",mac1,mac2,mac3,(int)(.9*7500))); //Machina weapon
			weapon.add(new Weapon("Penultima Weapon",pen1,pen2,pen3,(int)(.9*13500))); //Penultima weapon
			weapon.add(new Weapon("Ultima Weapon",4000,2000,1500,(int)(.9*1500000))); //Ultima weapon
		}
		else
		{
			weapon.add(new Weapon("Beginner's Weapon",10,0,0,75)); //Beginner's weapon
			weapon.add(new Weapon("Genesis Weapon",30,5,5,400)); //Genesis weapon
			weapon.add(new Weapon("General Weapon",75,50,25,2500)); //General weapon
			weapon.add(new Weapon("Machina Weapon",mac1,mac2,mac3,7500)); //Machina weapon
			weapon.add(new Weapon("Penultima Weapon",pen1,pen2,pen3,13500)); //Penultima weapon
			weapon.add(new Weapon("Ultima Weapon",4000,2000,1500,1500000)); //Ultima weapon
		}
	}
	private void initClassWeapons()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			weapon.add(new Weapon("Axis Gun",50,5,5,1500)); //Axis Gun
			weapon.add(new Weapon("Siphon Gun",300,-100,-150,10000)); //Siphon Gun
			weapon.add(new Weapon("Mobius Gun",50,50,350,10000)); //Mobius Gun
			weapon.add(new Weapon("Commando's Gun",1000,500,500,800000)); //Commando's Gun
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			weapon.add(new Weapon("Axis Sword",75,0,0,1500)); //Axis Sword
			weapon.add(new Weapon("Siphon Sword",500,-200,-150,10000)); //Siphon Sword
			weapon.add(new Weapon("Mobius Sword",25,100,250,10000)); //Mobius Sword
			weapon.add(new Weapon("Berserker's Sword",2000,250,0,800000)); //Berserker's Sword
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			weapon.add(new Weapon("Axis Shield",40,10,10,1500)); //Axis Shield
			weapon.add(new Weapon("Siphon Shield",-100,1000,-100,10000)); //Siphon Shield
			weapon.add(new Weapon("Mobius Shield",400,-1000,250,10000)); //Mobius Shield
			weapon.add(new Weapon("Sentinel's Shield",750,1000,500,800000)); //Sentinel's Shield
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			weapon.add(new Weapon("Axis Tome",30,0,50,1500)); //Axis Tome
			weapon.add(new Weapon("Siphon Tome",-100,-250,500,10000)); //Siphon Tome
			weapon.add(new Weapon("Mobius Tome",200,100,-100,10000)); //Mobius Tome
			weapon.add(new Weapon("Ravager's Tome",0,500,1500,800000)); //Ravager's Tome
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			weapon.add(new Weapon("Axis Staff",20,30,30,1500)); //Axis Staff
			weapon.add(new Weapon("Siphon Staff",-200,100,400,10000)); //Siphon Staff
			weapon.add(new Weapon("Mobius Staff",400,-500,-100,10000)); //Mobius Staff
			weapon.add(new Weapon("Reliever's Staff",250,750,1000,800000)); //Reliever's Staff
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			weapon.add(new Weapon("Axis Card",45,5,5,1350)); //Axis Card
			weapon.add(new Weapon("Siphon Card",75,75,75,8000)); //Siphon Card
			weapon.add(new Weapon("Mobius Card",200,200,200,12000)); //Mobius Card
			weapon.add(new Weapon("Entreprenuer's Card",750,750,750,700000)); //Entrepreneur's Card
		}
	}
	private void showWeapons()
	{
		String topHeader = "+----------------------------------Weapons-------------------------------------+";
		String bottomHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		
		for(int a = 0; a<weapon.size(); a++)
		{
			String wN = weapon.get(a).getWeaponName();
			String wDam = String.valueOf((int)weapon.get(a).getWeaponDamage());
			String wHP = String.valueOf((int)weapon.get(a).getHP());
			String wEP = String.valueOf((int)weapon.get(a).getEP());
			String wC = String.valueOf((int)weapon.get(a).getCost());
			String number = String.valueOf(a+1);
			String row1 = "";
			String row2 = "";
			int numSpaces = 0;
			
			int[] length = {wN.length(), wDam.length(), wHP.length(), wEP.length(), wC.length()};
			if(a+1 < 10)
				row1 += "|  " + number + ": " + wN;
			else
				row1 += "| " + number + ": " + wN;
			
			numSpaces = 4 + 19 - length[0];
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			
			row1 += "Damage: " + wDam;
			numSpaces = 16 + 4 - length[1];
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			
			row1 += "Adds ";
			numSpaces = 5 - length[2];
			for(int i = 0; i<numSpaces; i++)
				row1 += " ";
			row1 += wHP + "HP          |";
			System.out.println(row1);
			
			row2 += "|                            Cost: " + wC;
			numSpaces = 22 - length[4];
			for(int i = 0; i<numSpaces; i++)
				row2 += " ";
			
			row2 += "Adds ";
			numSpaces = 5 - length[3];
			for(int i = 0; i<numSpaces; i++)
				row2 += " ";
			row2 += wEP + "EP          |";
			System.out.println(row2);
		}
		System.out.println(midHeader);
		System.out.println(bottomHeader);
	}
	public Player weaponMarket(Player p)
	{
		player = p;
		System.out.println("\nWelcome to the Weapon Market!");
		System.out.println("You can buy weapons here.");
		Util.pause();
		
		showWeapons();
		System.out.println("11. Don't buy anything");
		System.out.println("Your Money: " + player.getMoney());
		
		int choice = Util.numberSelect("",11)-1;
		if(choice <10)
		{
			if(player.getMoney() >= weapon.get(choice).getCost())
			{
				System.out.println("You bought the " + weapon.get(choice).getWeaponName() + "!");
				buyWeapon(weapon.get(choice));
			}
			else
			{
				System.out.println("You can't afford to buy the " + weapon.get(choice).getWeaponName() + "!");
			}
		}
		else
			System.out.println("You didn't buy a weapon.");
		Util.pause();
		return player;
	}
	public ArrayList<Weapon> getAll()
	{
		return weapon;
	}
	public void setAll(ArrayList<Weapon> data)
	{
		weapon = data;
	}
	public ArrayList<String> getAllString()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add(String.valueOf(weapon.size()));
		for(int i = 0; i < weapon.size(); i++)
		{
			data.add(weapon.get(i).getWeaponName());
			data.add(String.valueOf(weapon.get(i).getWeaponDamage()));
			data.add(String.valueOf(weapon.get(i).getHP()));
			data.add(String.valueOf(weapon.get(i).getEP()));
			data.add(String.valueOf(weapon.get(i).getCost()));
		}
		return data;
	}
	public void setAllString(ArrayList<String> data)
	{
		ArrayList<Weapon> inData = new ArrayList<Weapon>();
		data.remove(0);
		for(int i = 0; i < data.size(); i+=5)
		{
			String inName = data.get(i);
			double inDam = Double.parseDouble(data.get(i+1));
			double inHP = Double.parseDouble(data.get(i+2));
			double inEP = Double.parseDouble(data.get(i+3));
			int inCost = Integer.parseInt(data.get(i+4));
			
			inData.add(new Weapon(inName, inDam, inHP, inEP, inCost));
		}
		
		weapon = inData;
	}
}