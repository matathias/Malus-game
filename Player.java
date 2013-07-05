import java.util.*;
import java.text.DecimalFormat;

public class Player
{
	public static final double MAXMONEY = 1000000000000.0;
	public static final double HPMULT = 1.5;
	public static final double EPMULT = 1.5;
	public static final double DAMMULT = 1.5;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat output = new DecimalFormat("0");
	private double maxHealth;
	private double maxHealthWeapon;
	private double extraHealth;
	private double extraExtra;
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
		extraHealth = 0;
		extraExtra = 0;
	}

	public Player (double hP, double aD, double exP, double m, double eP, double lvl, String pN) //This is the enemy constructor. The EXP, money, and EP values are actually the EXP, money, and EP that will be rewarded to the human player upon defeat of the enemy.
	{
		weapon = new Weapon();
		maxHealth = hP;
		maxHealthWeapon=hP;
		healthPoints = hP;
		attackDamage = aD;
		EXP = exP;
		money = m;
		extraPoints = eP;
		level = lvl;
		playerName = pN;
		attackMod = 1;
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
		if ((healthPoints + hP)>getMaxHealth())
			healthPoints = getMaxHealth();
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
		recalcMaxHealth();
	}
	public void addMaxHealth(double hP)
	{
		extraHealth += hP;
		recalcMaxHealth();
	}
	public void recalcMaxHealth()
	{
		maxHealthWeapon = maxHealth + weapon.getHP() + extraHealth;
		if(healthPoints>getMaxHealth())
		{
			healthPoints = getMaxHealth();
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
		if ((extraPoints + eP)>getMaxEP())
			extraPoints = getMaxEP();
		else
			extraPoints += eP;
	}
	public void setEP (double eP)
	{
		if(eP < getMaxEP())
			extraPoints = eP;
		else
			extraPoints = getMaxEP();
	}
	public double getEP()
	{
		return extraPoints;
	}
	public void setMaxEP(double eP)
	{
		maxExtra = eP;
		recalcMaxEP();
	}
	public void addMaxEP(double eP)
	{
		extraExtra += eP;
		recalcMaxEP();
	}
	public void recalcMaxEP()
	{
		maxExtraWeapon = maxExtra + weapon.getEP() + extraExtra;
		if(extraPoints>getMaxEP())
		{
			extraPoints = getMaxEP();
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
		addHP(getHealingHP(index));
		subtractEP(getHealingEP(index));
	}
	public int numberHealing()
	{
		return healing.size();
	}
	public void showHealing()
	{
		String topHeader = "+----------------------------------Healing-------------------------------------+";
		String bottomHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		int a;
		
		for(a = 0; a < healing.size(); a++)
		{
			String hN, hHP, hEP;
			hN = getHealingName(a);
			hHP = String.valueOf((int)getHealingHP(a));
			hEP = String.valueOf((int)getHealingEP(a));
			String number = String.valueOf(a+1);
			String row1 = "";
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
		}
		System.out.println(midHeader);
		System.out.println(bottomHeader);
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
	public double getHealingHP(int index)
	{
		return healing.get(index).getHealedHP();
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
	public void showSpecialAttacks()
	{
		String topHeader = "+------------------------------Special Attacks---------------------------------+";
		String bottomHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		int a;
		
		for(a = 0; a < specialAttack.size(); a++)
		{
			String saN, saDam, saCHC, saMinLvl, saEP, saCB;
			saN = getSpecialAttackName(a);
			saDam = String.valueOf((int)specialAttack.get(a).getAttackDamage());
			saCHC = String.valueOf((int)specialAttack.get(a).getCritChance());
			saMinLvl = String.valueOf((int)specialAttack.get(a).getMinLevel());
			saEP = String.valueOf((int)getSpecialAttackEP(a));
			saCB = String.valueOf(specialAttack.get(a).getCritBonus());
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
			
			if(saMinLvl.length() < 2)
				row2 += "|                       Min Level:  " + saMinLvl + " EP Cost: " + saEP;
			else
				row2 += "|                       Min Level: " + saMinLvl + " EP Cost: " + saEP;
			
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
	public double getSpecialAttackDam(int index)
	{
		return specialAttack.get(index).getAttackDamage();
	}
	public double getSpecialAttackCritChance(int index)
	{
		return specialAttack.get(index).getCritChance();
	}
	public double getSpecialAttackCritBonus(int index)
	{
		return specialAttack.get(index).getCritBonus();
	}
	public double getSpecialAttackLvl(int index)
	{
		return specialAttack.get(index).getMinLevel();
	}
	public int damage()
	{
		Random rand = new Random();
		double randomnessPercent = (rand.nextInt(21)+90)/100.0; //determines the "randomness"; basically it ensures that no "perfect number" is dealt as damage
		int critHit = rand.nextInt(99); //checks whether or not a "critical hit" is scored, which raises the total damage done by 50%
		if (critHit < 10) //critical hit has a 10% chance of occurring
		{
			//Critical hit!
			return (int)Math.round(getTotalRawDamage()*attackMod*randomnessPercent*1.5);
		}
		else
			return (int)Math.round(getTotalRawDamage()*attackMod*randomnessPercent);
	}
	public int specialDamage(int index) //index controls which special attack is used
	{
		subtractEP(getSpecialAttackEP(index));
		Random rand = new Random();
		double randomnessPercent = (rand.nextInt(21)+90)/100.0; //determines the "randomness"; basically it ensures that no "perfect number" is dealt as damage
		int critHit = rand.nextInt(99); //checks whether or not a "critical hit" is scored, which raises the total damage done by the attacks critical bonus percentage
		if (critHit < getSpecialAttackCritChance(index)) //critical hit has a variable chance of occuring
		{
			System.out.println("Critical hit!");
			return (int)Math.round(getSpecialAttackDam(index)*attackMod*(getLvl()/(getSpecialAttackLvl(index)+5))*randomnessPercent*getSpecialAttackCritBonus(index));
		}
		else
			return (int)Math.round(getSpecialAttackDam(index)*attackMod*(getLvl()/(getSpecialAttackLvl(index)+5))*randomnessPercent);
	}

	//Attack Modifier----------------------------------------------------------------------------------------------------

	public void addMod(double m) //adds the specified value to the attack modifier
	{
		attackMod+=m;
	}
	public void setMod(double m) //sets the attackMod value to the specified value
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
		lvlUp();
	}
	public double getEXP ()
	{
		return EXP;
	}
	public double getEXPToNextLvl(boolean prevLevel)
	{
		//100*(1.15^(x/1.5))-45
		if (prevLevel)
		{
			return 100*(Math.pow(1.15,(getLvl()-1)/1.5))-45;
		}
		else
		{
			return 100*(Math.pow(1.15,getLvl()/1.5))-45;
		}
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
		if (EXP >= getEXPToNextLvl(false)) 
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
			double curLvl = getLvl();
			double curMaxHP = getMaxHealth();
			double curMaxEP = getMaxEP();
			double curDam = getRawDamage();
			
			double newLvl = 0;
			double newMaxHP = 0;
			double newMaxEP = 0;
			double newDam = 0;
			
			addLvl();
			newLvl = getLvl();
			
			if (playerClass.equalsIgnoreCase("Commando")) //Commando level up (Average HP, EP, Damage)
			{
				newMaxHP = HPMULT*80*(Math.pow(1.75,getLvl()/5)); //HP: 80*1.75^(x/5)
				newMaxEP = EPMULT*30*(Math.pow(1.75,getLvl()/5)); //EP: 30*(1.75^(x/5))
				newDam = DAMMULT*5*(Math.pow(2,getLvl()/5)) + (getLvl()*10) - 5; //Damage: 5*(2^(x/5)) + (x*10) - 5
			}
			else if (playerClass.equalsIgnoreCase("Berserker")) //Berserker level up (Lower HP, Average EP, Higher Damage)
			{
				newMaxHP = HPMULT*40*(Math.pow(1.75,getLvl()/5)); //HP: 40*1.75^(x/5)
				newMaxEP = EPMULT*20*(Math.pow(1.75,getLvl()/5)); //EP: 20*(1.75^(x/5))
				newDam = DAMMULT*10*(Math.pow(2,getLvl()/5)) + (getLvl()*20) - 10; //Damage: 10*(2^(x/5)) + (x*20) - 10
			}
			else if (playerClass.equalsIgnoreCase("Sentinel")) //Sentinel level up (Higher HP, Average EP, Lower Damage)
			{
				newMaxHP = HPMULT*160*(Math.pow(1.75,getLvl()/5)); //HP: 160*1.75^(x/5)
				newMaxEP = EPMULT*20*(Math.pow(1.75,getLvl()/5)); //EP: 20*(1.75^(x/5))
				newDam = DAMMULT*3.5*(Math.pow(2,getLvl()/5)) + (getLvl()*5) - 2.5; //Damage: 3.5*(2^(x/5)) + (x*5) - 2.5
			}
			else if (playerClass.equalsIgnoreCase("Ravager")) //Ravager level up (Lower HP, Higher EP, Average Damage)
			{
				newMaxHP = HPMULT*50*(Math.pow(1.75,getLvl()/5)); //HP: 50*1.75^(x/5)
				newMaxEP = EPMULT*90*(Math.pow(1.75,getLvl()/5)); //EP: 90*(1.75^(x/5))
				newDam = DAMMULT*8*(Math.pow(1.5,getLvl()/5)) + (getLvl()*13) - 8; //Damage: 8*(1.5^(x/5)) + (x*13) - 8
			}
			else if (playerClass.equalsIgnoreCase("Reliever")) //Reliever level up (Higher HP, Higher EP, Average Damage)
			{
				newMaxHP = HPMULT*130*(Math.pow(1.75,getLvl()/5)); //HP: 130*1.75^(x/5)
				newMaxEP = EPMULT*75*(Math.pow(1.75,getLvl()/5)); //EP: 75*(1.75^(x/5))
				newDam = DAMMULT*5*(Math.pow(1.5,getLvl()/5)) + (getLvl()*4) - 4; //Damage: 5*(1.5^(x/5)) + (x*4) - 4
			}
			else if (playerClass.equalsIgnoreCase("Entrepreneur")) //Entrepreneur level up (Lower HP, Average EP, Lower Damage, Cheaper marker and earns money at level up)
			{
				newMaxHP = HPMULT*60*(Math.pow(1.75,getLvl()/5)); //HP: 60*1.75^(x/5)
				newMaxEP = EPMULT*20*(Math.pow(1.75,getLvl()/5)); //EP: 20*(1.75^(x/5))
				newDam = DAMMULT*3.5*(Math.pow(2,getLvl()/5)) + (getLvl()*6) - 3; //Damage: 3.5*(2^(x/5)) + (x*6) - 3
			}
			
			System.out.println("LEVEL UP!!!");
			System.out.println("Level: " + output.format(curLvl) + " ==> " + output.format(newLvl));
			System.out.println("Max HP: " + output.format(curMaxHP) + " ==> " + output.format(newMaxHP));
			System.out.println("Max EP: " + output.format(curMaxEP) + " ==> " + output.format(newMaxEP));
			System.out.println("Base Damage: " + output.format(curDam) + " ==> " + output.format(curDam));
			if (playerClass.equalsIgnoreCase("Entrepreneur"))
			{
				Random rand = new Random();
				int addM = rand.nextInt((int)getLvl()*500);
				System.out.println("You have won " + addM + " gold!");
				addMoney(addM);
			}
			
			setMaxHealth(newMaxHP);
			setMaxEP(newMaxEP);
			attackDamage = newDam;
			
			setHP(getMaxHealth());
			setEP(getMaxEP());
			addEXP(-getEXPToNextLvl(true));
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
		String topHeader = "+------------------------------------------------------------------------------+";
		String midHeader = "|                                                                              |";
		System.out.println(topHeader);
		System.out.println(midHeader);
		
		
		String nameRow = "| ";
		int numSpace = 63 - getPlayerName().length() - getPlayerClass().length() - getWeaponName().length();
		String spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		nameRow += getPlayerName() + " the " + getPlayerClass() + spaces + "Weapon: " + getWeaponName() + " |";
		System.out.println(nameRow);
		
		String pHP = String.valueOf((int)getHP());
		String pMaxHP = String.valueOf((int)getMaxHealth());
		String wHP = String.valueOf((int)getWeaponHP());
		numSpace = 52 - pHP.length() - pMaxHP.length() - wHP.length();
		spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		String hpRow = "| HP: " + pHP + "/" + pMaxHP + spaces + "(Weapon HP Bonus: " + wHP + ") |";
		System.out.println(hpRow);
		
		String pEP = String.valueOf((int)getEP());
		String pMaxEP = String.valueOf((int)getMaxEP());
		String wEP = String.valueOf((int)getWeaponEP());
		numSpace = 52 - pEP.length() - pMaxEP.length() - wEP.length();
		spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		String epRow = "| EP: " + pEP + "/" + pMaxEP + spaces + "(Weapon EP Bonus: " + wEP + ") |";
		System.out.println(epRow);
		
		String pDam = String.valueOf((int)getTotalRawDamage());
		String wDam = String.valueOf((int)getWeaponDamage());
		numSpace = 39 - pDam.length() - wDam.length();
		spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		String damRow = "| Attack Power: " + pDam + spaces + "(Weapon Damage Bonus: " + wDam + ") |";
		System.out.println(damRow);
		
		String pLvl = String.valueOf((int)getLvl());
		String pXP = String.valueOf((int)getEXP());
		String pXPtoLvl = String.valueOf((int)getEXPToNextLvl(false));
		numSpace = 59 - pLvl.length() - pXP.length() - pXPtoLvl.length();
		spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		String lvlRow = "| Level: " + pLvl + "     EXP: " + pXP + "/" + pXPtoLvl + spaces + "|";
		System.out.println(lvlRow);
		
		String pMoney = String.valueOf((int)getMoney());
		numSpace = 70 - pMoney.length();
		spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		String moneyRow = "| Money: " + pMoney + spaces + "|";
		System.out.println(moneyRow);
		
		System.out.println(midHeader);
		System.out.println(topHeader);
	}
	public void battleShow()
	{
		System.out.println(getPlayerName() + " the " + getPlayerClass());
		System.out.println("Weapon: " + weapon);
		System.out.println("HP: " + output.format(getHP()) + "/" + output.format(getMaxHealth()));
		System.out.println("EP: " + output.format(getEP()) + "/" + output.format(getMaxEP()));
		System.out.println("Attack Power: " + output.format(getTotalRawDamage()));
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