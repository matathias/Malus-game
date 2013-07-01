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
		if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur")) //10% cheaper
		{
			weapon.add(new Weapon()); //Beginner's weapon
			weapon.add(new Weapon()); //Genesis weapon
			weapon.add(new Weapon()); //General weapon
			weapon.add(new Weapon()); //Machina weapon
			weapon.add(new Weapon()); //Penultima weapon
			weapon.add(new Weapon()); //Ultima weapon
		}
		else
		{
			weapon.add(new Weapon()); //Beginner's weapon
			weapon.add(new Weapon()); //Genesis weapon
			weapon.add(new Weapon()); //General weapon
			weapon.add(new Weapon()); //Machina weapon
			weapon.add(new Weapon()); //Penultima weapon
			weapon.add(new Weapon()); //Ultima weapon
		}
	}
	private void initClassWeapons()
	{
		if(player.getPlayerClass().equalsIgnoreCase("Commando"))
		{
			weapon.add(new Weapon()); //Axis Gun
			weapon.add(new Weapon()); //Siphon Gun
			weapon.add(new Weapon()); //Mobius Gun
			weapon.add(new Weapon()); //Commando's Gun
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Berserker"))
		{
			weapon.add(new Weapon()); //Axis Sword
			weapon.add(new Weapon()); //Siphon Sword
			weapon.add(new Weapon()); //Mobius Sword
			weapon.add(new Weapon()); //Berserker's Sword
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Sentinel"))
		{
			weapon.add(new Weapon()); //Axis Shield
			weapon.add(new Weapon()); //Siphon Shield
			weapon.add(new Weapon()); //Mobius Shield
			weapon.add(new Weapon()); //Sentinel's Shield
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Ravager"))
		{
			weapon.add(new Weapon()); //Axis Tome
			weapon.add(new Weapon()); //Siphon Tome
			weapon.add(new Weapon()); //Mobius Tome
			weapon.add(new Weapon()); //Ravager's Tome
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Reliever"))
		{
			weapon.add(new Weapon()); //Axis Staff
			weapon.add(new Weapon()); //Siphon Staff
			weapon.add(new Weapon()); //Mobius Staff
			weapon.add(new Weapon()); //Reliever's Staff
		}
		else if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
		{
			weapon.add(new Weapon()); //Axis Card
			weapon.add(new Weapon()); //Siphon Card
			weapon.add(new Weapon()); //Mobius Card
			weapon.add(new Weapon()); //Entrepreneur's Card
		}
	}
	public Player weaponMarket(Player p)
	{
		player = p;
		System.out.println("Welcome to the Weapon Market!");
		System.out.println("You can buy weapons here.");
		Util.pause();
		System.out.println("-----------------------Weapons-----------------------");
		for(int a = 0; a<6; a++)
		{
			System.out.println((a+1) + ": " + weapon.get(a).marketToString());
		}
		System.out.println("--------------------Class Weapons--------------------");
		for(int a = 6; a<weapon.size(); a++)
		{
			System.out.println((a+1) + ": " + weapon.get(a).marketToString());
		}
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