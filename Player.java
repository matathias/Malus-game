import java.util.*;
import java.text.DecimalFormat;

public class Player
{
	public static final double MAXMONEY = 1000000000000.0;
	Scanner input = new Scanner(System.in);
	DecimalFormat output = new DecimalFormat("0");
	private double maxHealth;
	private double maxHealthWeapon;
	private double healthPoints;
	private double attackDamage;
	private double attackMod;
	private double maxExtra;
	private double maxExtraWeapon;
	private double extraPoints;
	private double EXP;
	private double money;
	private double level;
	private Weapon weapon;
	private ArrayList <SpecialAttack> specialAttack;
	private ArrayList <Healing> healing;
	private String playerName;
	private String playerClass;


	//Constructors----------------------------------------------------------------------------------------------------

	public Player (double hP, double aD, double eP, double exP, double m, String pN, String pC, Weapon w) //This is the human player constructor.
	{
		weapon = w;
		maxHealth = hP;
		maxHealthWeapon = hP + weapon.getHP();
		healthPoints = hP;
		attackDamage = aD;
		maxExtra = eP;
		extraPoints = eP;
		maxExtraWeapon = eP + weapon.getEP();
		EXP = exP;
		money = m;
		playerName = pN;
		playerClass = pC;
		specialAttack = new ArrayList<SpecialAttack>();
		healing = new ArrayList<Healing>();
		level = 1;
		attackMod = 1;
	}

	public Player (double hP, double aD, double exP, double m, double eP, double lvl, String pN) //This is the enemy constructor. The EXP, money, and EP values are actually the EXP, money, and EP that will be rewarded to the human player upon defeat of the enemy.
	{
		weapon = new Weapon();
		maxHealth = hP;
		healthPoints = hP;
		attackDamage = aD;
		EXP = exP;
		money = m;
		extraPoints = eP;
		level = lvl;
		playerName = pN;
	}
	
	public Player (ArrayList<String> data) //to be used with game loading
	{
		setAll(data);
	}

	//HP----------------------------------------------------------------------------------------------------

	public void subtractHP (double hP)
	{
		if ((healthPoints - hP) < 0)
			healthPoints = 0;
		else
			healthPoints -=hP;
	}
	public void addHP (double hP)
	{
		if ((healthPoints + hP)>maxHealthWeapon)
			healthPoints = maxHealthWeapon;
		else
			healthPoints += hP;
	}
	public void setHP (double hP)
	{
		healthPoints = hP;
	}
	public double getHP()
	{
		return healthPoints;
	}
	public void setMaxHealth(double hP)
	{
		maxHealth = hP;
		maxHealthWeapon = maxHealth + weapon.getHP();
		if(healthPoints>maxHealthWeapon)
		{
			healthPoints = maxHealthWeapon;
		}
	}
	public void addMaxHealth(double hP)
	{
		maxHealth += hP;
		maxHealthWeapon = maxHealth + weapon.getHP();
		if(healthPoints>maxHealthWeapon)
		{
			healthPoints = maxHealthWeapon;
		}
	}
	public void recalcMaxHealth()
	{
		maxHealthWeapon = maxHealth + weapon.getHP();
		if(healthPoints>maxHealthWeapon)
		{
			healthPoints = maxHealthWeapon;
		}
	}
	public double getMaxHealth()
	{
		return maxHealthWeapon;
	}

	//Extra Points----------------------------------------------------------------------------------------------------

	public void subtractEP (double eP)
	{
		if ((extraPoints - eP) < 0)
			extraPoints = 0;
		else
			extraPoints -= eP;
	}
	public void addEP (double eP)
	{
		if ((extraPoints + eP)>maxExtraWeapon)
			extraPoints = maxExtraWeapon;
		else
			extraPoints += eP;
	}
	public void setEP (double eP)
	{
		if(eP < maxExtraWeapon)
			extraPoints = eP;
		else
			extraPoints = maxExtraWeapon;
	}
	public double getEP()
	{
		return extraPoints;
	}
	public void setMaxEP(double eP)
	{
		maxExtra = eP;
		maxExtraWeapon = maxExtra + weapon.getEP();
		if(extraPoints>maxExtraWeapon)
		{
			extraPoints = maxExtraWeapon;
		}
	}
	public void addMaxEP(double eP)
	{
		maxExtra += eP;
		maxExtraWeapon = maxExtra + weapon.getEP();
		if(extraPoints>maxExtraWeapon)
		{
			extraPoints = maxExtraWeapon;
		}
	}
	public void recalcMaxEP()
	{
		maxExtraWeapon = maxExtra + weapon.getEP();
		if(extraPoints>maxExtraWeapon)
		{
			extraPoints = maxExtraWeapon;
		}
	}
	public double getMaxEP()
	{
		return maxExtraWeapon;
	}

	//Healing----------------------------------------------------------------------------------------------------

	public void addHealing(Healing h)
	{
		healing.add(h);
	}
	public void useHealing(int index)
	{
		System.out.println("You used " + healing.get(index).getHealName() + " and healed " + healing.get(index).getHealedHP() + "HP!");
		addHP(healing.get(index).getHealedHP());
		subtractEP(healing.get(index).getUsedEP());
	}
	public int numberHealing()
	{
		return healing.size();
	}
//	public void showHealing()
//	{
//		for(int a = 0; a<healing.size(); a++)
//		{
//			System.out.println((a+1) + ". " + healing.get(a) + "\n");
//		}
//	}
	public String showHealing()
	{
		String heal = "";
		int choice = 1;
		for(Healing a: healing)
		{
			heal+= String.valueOf(choice) + " " + a + "\n";
			choice++;
		}
		return heal;
	}
	public ArrayList<Healing> getHealing()
	{
		return healing;
	}
	public void setHealing(ArrayList<Healing> list)
	{
		healing = list;
	}
	public String getHealingName(int index)
	{
		return healing.get(index).getHealName();
	}
	public double getHealingEP(int index)
	{
		return healing.get(index).getUsedEP();
	}

	//Attack Damage----------------------------------------------------------------------------------------------------

	public void setDamage (double d)
	{
		attackDamage = d;
	}
	public void addDamage (double d) //adds the specified number to the *current* attackDamage value
	{
		attackDamage += d;
	}
	public void addSpecialAttack(SpecialAttack sp)
	{
		specialAttack.add(sp);
	}
	public double getRawDamage ()
	{
		return attackDamage;
	}
	public double getTotalRawDamage() //add together the base damage value and the weapon damage value
	{
		return attackDamage + weapon.getWeaponDamage();
	}
	public int numberSpecialAttacks()
	{
		return specialAttack.size();
	}
	/*public void showSpecialAttacks()
	{
		for(int a = 0; a<specialAttack.size(); a++)
		{
			System.out.println((a+1) + ". " + specialAttack.get(a) + "\n");
		}
	}*/
	public String showSpecialAttacks()
	{
		String attacks = "";
		int choice = 1;
		for(SpecialAttack a:specialAttack)
		{
			attacks += String.valueOf(choice) + " " + a + "\n";
			choice++;
		}
		return attacks;
	}
	public ArrayList<SpecialAttack> getSpecialAttacks()
	{
		return specialAttack;
	}
	public void setSpecialAttacks(ArrayList<SpecialAttack> list)
	{
		specialAttack = list;
	}
	public String getSpecialAttackName(int index)
	{
		return specialAttack.get(index).getAttackName();
	}
	public double getSpecialAttackEP(int index)
	{
		return specialAttack.get(index).getExtraPoints();
	}
	public int damage()
	{
		Random rand = new Random();
		double randomnessPercent = (rand.nextInt(21)+90)/100; //determines the "randomness"; basically it ensures that no "perfect number" is dealt as damage
		int critHit = rand.nextInt(99); //checks whether or not a "critial hit" is scored, which raises the total damage done by 50%
		if (critHit < 10) //critical hit has a 10% chance of occuring
		{
			System.out.println("Critical hit!");
			return (int)(getTotalRawDamage()*attackMod*randomnessPercent*1.5);
		}
		else
			return (int)(getTotalRawDamage()*attackMod*randomnessPercent);
	}
	public int specialDamage(int index) //index controls which special attack is used
	{
		subtractEP(specialAttack.get(index).getExtraPoints());
		Random rand = new Random();
		double randomnessPercent = (rand.nextInt(21)+90)/100; //determines the "randomness"; basically it ensures that no "perfect number" is dealt as damage
		int critHit = rand.nextInt(99); //checks whether or not a "critial hit" is scored, which raises the total damage done by the attacks critical bonus percentage
		if (critHit < specialAttack.get(index).getCritChance()) //critical hit has a variable chance of occuring
		{
			System.out.println("Critical hit!");
			return (int)(specialAttack.get(index).getAttackDamage()*attackMod*(getLvl()/10)*randomnessPercent*specialAttack.get(index).getCritBonus());
		}
		else
			return (int)(specialAttack.get(index).getAttackDamage()*attackMod*(getLvl()/10)*randomnessPercent);
	}

	//Attack Modifier----------------------------------------------------------------------------------------------------

	public void addMod(double m) //adds the specfied value to the attack modifier
	{
		attackMod+=m;
	}
	public void setMod(double m) //sets the attackMod value to the specfied value
	{
		attackMod = m;
	}
	public void resetMod() //resets the attackMod value to 1
	{
		attackMod = 1;
	}
	public double getMod()
	{
		return attackMod;
	}

	//Money----------------------------------------------------------------------------------------------------

	public void addMoney (double m)
	{
		if ((money + m)>MAXMONEY)
			money = MAXMONEY;
		else
			money += m;
	}
	public void subtractMoney (double m)
	{
		if((money - m)<0)
			money = 0;
		else
			money -= m;
	}
	public void setMoney (double m)
	{
		money = m;
	}
	public double getMoney()
	{
		return money;
	}

	//EXP and level-ups----------------------------------------------------------------------------------------------------

	public void addEXP (double exP)
	{
		if ((EXP + exP)<0)
			EXP = 0;
		else
			EXP += exP;
		lvlUp();
	}
	public void setEXP (double exP)
	{
		EXP = exP;
	}
	public double getEXP ()
	{
		return EXP;
	}
	public void setLvl(double lvl)
	{
		level = lvl;
	}
	public double getLvl()
	{
		return level;
	}
	private void addLvl()
	{
		level+=1;
	}
	public void lvlUp()
	{
		boolean extraEXP = false;
		if (EXP >= (100*(Math.pow(1.15,getLvl()/1.5))-50)) //if the EXP is greater than or equal to 100*(1.15^(x/1.5))-50
		//(-50 is for the sake of reducing the EXP requirement for the first level up)
		{
			/* General layout for Level Up appearance:
			 *LEVEL UP!!!
			 *Level: x ==> x+1
			 *Max HP: a ==> d
			 *Max EP: b ==> e
			 *Base Damage: c ==> f
			 *(for Entrepreneur) You have won y gold!
			 */
			System.out.println("LEVEL UP!!!");
			System.out.print("Level: " + output.format(getLvl()) + " ==> ");
			addLvl();
			System.out.println(output.format(getLvl()));
			if (playerClass.equalsIgnoreCase("Commando")) //Commando level up (Average HP, EP, Damage)
			{
				System.out.print("Max HP: " + output.format(getMaxHealth()) + " ==> ");
				setMaxHealth(80*(Math.pow(1.75,getLvl()/5))); //HP: 80*1.75^(x/5)
				System.out.println(output.format(getMaxHealth()));
				System.out.print("Max EP: " + output.format(getMaxEP()) + " ==> ");
				setMaxEP(30*(Math.pow(1.75,getLvl()/5))); //EP: 30*(1.75^(x/5))
				System.out.println(output.format(getMaxEP()));
				System.out.print("Base Damage: " + output.format(getRawDamage()) + " ==> ");
				attackDamage = 5*(Math.pow(2,getLvl()/5)) + (getLvl()*10) - 5; //Damage: 5*(2^(x/5)) + (x*10) - 5
				System.out.println(output.format(getRawDamage()));
			}
			else if (playerClass.equalsIgnoreCase("Berserker")) //Berserker level up (Lower HP, Average EP, Higher Damage)
			{
				System.out.print("Max HP: " + output.format(getMaxHealth()) + " ==> ");
				setMaxHealth(40*(Math.pow(1.75,getLvl()/5))); //HP: 40*1.75^(x/5)
				System.out.println(output.format(getMaxHealth()));
				System.out.print("Max EP: " + output.format(getMaxEP()) + " ==> ");
				setMaxEP(20*(Math.pow(1.75,getLvl()/5))); //EP: 20*(1.75^(x/5))
				System.out.println(output.format(getMaxEP()));
				System.out.print("Base Damage: " + output.format(getRawDamage()) + " ==> ");
				attackDamage = 10*(Math.pow(2,getLvl()/5)) + (getLvl()*20) - 10; //Damage: 10*(2^(x/5)) + (x*20) - 10
				System.out.println(output.format(getRawDamage()));
			}
			else if (playerClass.equalsIgnoreCase("Sentinel")) //Sentinel level up (Higher HP, Average EP, Lower Damage)
			{
				System.out.print("Max HP: " + output.format(getMaxHealth()) + " ==> ");
				setMaxHealth(160*(Math.pow(1.75,getLvl()/5))); //HP: 160*1.75^(x/5)
				System.out.println(output.format(getMaxHealth()));
				System.out.print("Max EP: " + output.format(getMaxEP()) + " ==> ");
				setMaxEP(20*(Math.pow(1.75,getLvl()/5))); //EP: 20*(1.75^(x/5))
				System.out.println(output.format(getMaxEP()));
				System.out.print("Base Damage: " + output.format(getRawDamage()) + " ==> ");
				attackDamage = 2.5*(Math.pow(2,getLvl()/5)) + (getLvl()*5) - 2.5; //Damage: 2.5*(2^(x/5)) + (x*5) - 2.5
				System.out.println(output.format(getRawDamage()));
			}
			else if (playerClass.equalsIgnoreCase("Ravager")) //Ravager level up (Lower HP, Higher EP, Average Damage)
			{
				System.out.print("Max HP: " + output.format(getMaxHealth()) + " ==> ");
				setMaxHealth(50*(Math.pow(1.75,getLvl()/5))); //HP: 50*1.75^(x/5)
				System.out.println(output.format(getMaxHealth()));
				System.out.print("Max EP: " + output.format(getMaxEP()) + " ==> ");
				setMaxEP(100*(Math.pow(1.75,getLvl()/5))); //EP: 100*(1.75^(x/5))
				System.out.println(output.format(getMaxEP()));
				System.out.print("Base Damage: " + output.format(getRawDamage()) + " ==> ");
				attackDamage = 8*(Math.pow(2,getLvl()/5)) + (getLvl()*17) - 8; //Damage: 8*(2^(x/5)) + (x*17) - 8
				System.out.println(output.format(getRawDamage()));
			}
			else if (playerClass.equalsIgnoreCase("Reliever")) //Reliever level up (Higher HP, Higher EP, Average Damage)
			{
				System.out.print("Max HP: " + output.format(getMaxHealth()) + " ==> ");
				setMaxHealth(130*(Math.pow(1.75,getLvl()/5))); //HP: 130*1.75^(x/5)
				System.out.println(output.format(getMaxHealth()));
				System.out.print("Max EP: " + output.format(getMaxEP()) + " ==> ");
				setMaxEP(80*(Math.pow(1.75,getLvl()/5))); //EP: 80*(1.75^(x/5))
				System.out.println(output.format(getMaxEP()));
				System.out.print("Base Damage: " + output.format(getRawDamage()) + " ==> ");
				attackDamage = 4*(Math.pow(2,getLvl()/5)) + (getLvl()*6) - 4; //Damage: 4*(2^(x/5)) + (x*6) - 4
				System.out.println(output.format(getRawDamage()));
			}
			else if (playerClass.equalsIgnoreCase("Entrepreneur")) //Entrepreneur level up (Lower HP, Average EP, Lower Damage, Cheaper marker and earns money at level up)
			{
				System.out.print("Max HP: " + output.format(getMaxHealth()) + " ==> ");
				setMaxHealth(60*(Math.pow(1.75,getLvl()/5))); //HP: 60*1.75^(x/5)
				System.out.println(output.format(getMaxHealth()));
				System.out.print("Max EP: " + output.format(getMaxEP()) + " ==> ");
				setMaxEP(20*(Math.pow(1.75,getLvl()/5))); //EP: 20*(1.75^(x/5))
				System.out.println(output.format(getMaxEP()));
				System.out.print("Base Damage: " + output.format(getRawDamage()) + " ==> ");
				attackDamage = 3*(Math.pow(2,getLvl()/5)) + (getLvl()*6) - 3; //Damage: 3*(2^(x/5)) + (x*6) - 3
				System.out.println(output.format(getRawDamage()));
				Random rand = new Random();
				int addM = rand.nextInt((int)getLvl()*500);
				System.out.println("You have won " + addM + " gold!");
				addMoney(addM);
			}
			setHP(getMaxHealth());
			setEP(getMaxEP());
			addEXP(-(100*(Math.pow(1.15,(getLvl()-1)/1.5))-50));
			extraEXP = true;
		}

		if (extraEXP == true)
			lvlUp();
	}

	//Weapon----------------------------------------------------------------------------------------------------

	public Weapon getWeapon()
	{
		return weapon;
	}
	public String getWeaponName()
	{
		return weapon.getWeaponName();
	}
	public double getWeaponDamage()
	{
		return weapon.getWeaponDamage();
	}
	public double getWeaponHP()
	{
		return weapon.getHP();
	}
	public double getWeaponEP()
	{
		return weapon.getEP();
	}
	public void setWeapon(Weapon w)
	{
		weapon = w;
		recalcMaxHealth();
		recalcMaxEP();
	}

	//Player Naming----------------------------------------------------------------------------------------------------

	public void setPlayerName(String pN)
	{
		playerName = pN;
	}
	public String getPlayerName()
	{
		return playerName;
	}

	//Player Type----------------------------------------------------------------------------------------------------

	public void setClass(String pC)
	{
		playerClass = pC;
	}
	public String getPlayerClass()
	{
		return playerClass;
	}

	//Show Info----------------------------------------------------------------------------------------------------

	public void showAll()
	{
		System.out.println(getPlayerName() + " the " + getPlayerClass());
		System.out.println("Weapon: " + weapon);
		System.out.println("HP: " + output.format(getHP()) + "/" + output.format(getMaxHealth()));
		System.out.println("EP: " + output.format(getEP()) + "/" + output.format(getMaxEP()));
		System.out.println("Attack Power: " + output.format(getRawDamage()));
		System.out.println("Level: " + output.format(getLvl()) + "\tEXP: " + output.format(getEXP()) + "/" + output.format(100*(Math.pow(1.15,getLvl()/1.5))-50));
		System.out.println("Money: " + output.format(getMoney()));
	}
	public void battleShow()
	{
		System.out.println(getPlayerName() + " the " + getPlayerClass());
		System.out.println("Weapon: " + weapon);
		System.out.println("HP: " + output.format(getHP()) + "/" + output.format(getMaxHealth()));
		System.out.println("EP: " + output.format(getEP()) + "/" + output.format(getMaxEP()));
		System.out.println("Attack Power: " + output.format(getRawDamage()));
	}
	public void mookShow()
	{
		System.out.println(getPlayerName());
		System.out.println("HP: " + output.format(getHP()) + "/" + output.format(getMaxHealth()));
	}

	//I/O all related data-----------------------------------------------------------------------------------------

	public ArrayList<String> getAll()
	{
		ArrayList<String> data = new ArrayList<String>();
		/*Data indices:
		 * 0 - HP
		 * 1 - MaxHP
		 * 2 - EP
		 * 3 - MaxEP
		 * 4 - Attack Damage
		 * 5 - Attack Mod
		 * 6 - Money
		 * 7 - EXP
		 * 8 - Level
		 * 9 - Player Name
		 *10 - Player Class
		 *11 - Weapon Name
         *12 - Weapon Damage
         *13 - Weapon HP Bonus
         *14 - Weapon EP Bonus
         *15 - Weapon Cost
		 *   - SpecialAttacks
		 *   - Healing Abilities
		*/
		data.add(String.valueOf(getHP()));
		data.add(String.valueOf(getMaxHealth())); //includes the HP added by the weapon
		data.add(String.valueOf(getEP()));
		data.add(String.valueOf(getMaxEP())); //includes the EP added by the weapon
		data.add(String.valueOf(getRawDamage()));
		data.add(String.valueOf(getMod()));
		data.add(String.valueOf(getMoney()));
		data.add(String.valueOf(getEXP()));
		data.add(String.valueOf(getLvl()));
		data.add(getPlayerName());
		data.add(getPlayerClass());
		
		data.add(getWeapon().getWeaponName());
		data.add(String.valueOf(getWeapon().getWeaponDamage()));
		data.add(String.valueOf(getWeapon().getHP()));
		data.add(String.valueOf(getWeapon().getEP()));
		data.add(String.valueOf(getWeapon().getCost()));
		
		ArrayList<SpecialAttack> speAtt = getSpecialAttacks();
		data.add(String.valueOf(speAtt.size()));
		for(int i = 0; i < speAtt.size(); i++)
		{
			data.add(speAtt.get(i).getAttackName());
			data.add(speAtt.get(i).getAvailClass());
			data.add(String.valueOf(speAtt.get(i).getAttackDamage()));
			data.add(String.valueOf(speAtt.get(i).getExtraPoints()));
			data.add(String.valueOf(speAtt.get(i).getMinLevel()));
			data.add(String.valueOf(speAtt.get(i).getCost()));
			data.add(String.valueOf(speAtt.get(i).getCritChance()));
			data.add(String.valueOf(speAtt.get(i).getCritBonus()));
		}
		
		ArrayList<Healing> heal = getHealing();
		data.add(String.valueOf(heal.size()));
		for(int i = 0; i < heal.size(); i+=6)
		{
			data.add(heal.get(i).getHealName());
			data.add(heal.get(i).getAvailClass());
			data.add(String.valueOf(heal.get(i).getHealedHP()));
			data.add(String.valueOf(heal.get(i).getUsedEP()));
			data.add(String.valueOf(heal.get(i).getMinLevel()));
			data.add(String.valueOf(heal.get(i).getCost()));
		}
		
		return data;
	}
	public void setAll(ArrayList<String> list)
	{
		setHP(Double.parseDouble(list.remove(0)));
		setMaxHealth(Double.parseDouble(list.remove(0)));
		setEP(Double.parseDouble(list.remove(0)));
		setMaxEP(Double.parseDouble(list.remove(0)));
		setDamage(Double.parseDouble(list.remove(0)));
		setMod(Double.parseDouble(list.remove(0)));
		setMoney(Double.parseDouble(list.remove(0)));
		setEXP(Double.parseDouble(list.remove(0)));
		setLvl(Double.parseDouble(list.remove(0)));
		setPlayerName(list.remove(0));
		setClass(list.remove(0));
		
		String weaponName = list.remove(0);
		double weaponDam = Double.parseDouble(list.remove(0));
		double weaponHP = Double.parseDouble(list.remove(0));
		double weaponEP = Double.parseDouble(list.remove(0));
		int weaponCost = Integer.parseInt(list.remove(0));
		Weapon loadWeapon = new Weapon(weaponName, weaponDam, weaponHP, weaponEP, weaponCost);
		setWeapon(loadWeapon);
		
		int numSpeAtt = Integer.parseInt(list.remove(0));
		ArrayList<SpecialAttack> speAtt = new ArrayList<SpecialAttack>();
		for(int i = 0; i < numSpeAtt; i++)
		{
			String speName = list.remove(0);
			String speClass = list.remove(0);
			double speDam = Double.parseDouble(list.remove(0));
			double speEP = Double.parseDouble(list.remove(0));
			double speMinLvl = Double.parseDouble(list.remove(0));
			int speCost = Integer.parseInt(list.remove(0));
			int speCritCh = Integer.parseInt(list.remove(0));
			double speCritBon = Double.parseDouble(list.remove(0));
			speAtt.add(new SpecialAttack(speName, speClass, speDam, speEP, speMinLvl, speCost, speCritCh, speCritBon));
		}
		setSpecialAttacks(speAtt);
		
		int numHeal = Integer.parseInt(list.remove(0));
		ArrayList<Healing> heal = new ArrayList<Healing>();
		for(int i = 0; i < numHeal; i++)
		{
			String heaName = list.remove(0);
			String heaClass = list.remove(0);
			double heaHP = Double.parseDouble(list.remove(0));
			double heaEP = Double.parseDouble(list.remove(0));
			int heaMinLvl = Integer.parseInt(list.remove(0));
			int heaCost = Integer.parseInt(list.remove(0));
			heal.add(new Healing(heaName, heaClass, heaHP, heaEP, heaMinLvl, heaCost));
		}
		setHealing(heal);
	}
}