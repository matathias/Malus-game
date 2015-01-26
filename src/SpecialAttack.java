public class SpecialAttack
{
/*
 * Special Attacks
 *
 * attackName =     Name of the attack.
 * availClass =     The class that can use the attack.
 * attackDamage =   The amount of damage the attack delivers.
 * extraPoints =    The amount of EP the attack requires to activate.
 * minLevel =       The minimum level the player has to be to use the attack.
 * cost =           The money cost to buy the attack.
 * criticalChance = The chance the attack has of landing a critical hit
 * critBonus =      The percent increase in damage if the attack lands a critical hit
 */
	private String attackName;
	private String availClass;
	private double attackDamage;
	private double extraPoints;
	private double minLevel;
	private int cost;
	private int criticalChance;
	private double critBonus;

	public SpecialAttack()
	{
		attackName = "null";
		availClass = "null";
		attackDamage = 0.0;
		extraPoints = 0.0;
		minLevel = 0.0;
		cost = 0;
		criticalChance = 0;
		critBonus = 0.0;
	}
	public SpecialAttack(String aN, String aC, double aD, double eP, double mL, int c, int cC, double cB)
	{
		attackName = aN;
		availClass = aC;
		attackDamage = aD;
		extraPoints = eP;
		minLevel = mL;
		cost = c;
		criticalChance = cC;
		critBonus = cB;
	}

	public void setAttackName(String aN)
	{
		attackName = aN;
	}
	public void setAvailClass(String aC)
	{
		availClass = aC;
	}
	public void setAttackDamage(double aD)
	{
		attackDamage = aD;
	}
	public void setExtraPoints(double eP)
	{
		extraPoints = eP;
	}
	public void setMinLevel(double mL)
	{
		minLevel = mL;
	}
	public void setCost(int c)
	{
		cost = c;
	}
	public void setCritChance(int c)
	{
		criticalChance = c;
	}
	public void setCritBonus(double c)
	{
		critBonus = c;
	}

	public String getAttackName()
	{
		return attackName;
	}
	public String getAvailClass()
	{
		return availClass;
	}
	public double getAttackDamage()
	{
		return attackDamage;
	}
	public double getExtraPoints()
	{
		return extraPoints;
	}
	public double getMinLevel()
	{
		return minLevel;
	}
	public int getCost()
	{
		return cost;
	}
	public int getCritChance()
	{
		return criticalChance;
	}
	public double getCritBonus()
	{
		return critBonus;
	}

	public String toString()
	{
		return attackName + "\tDamage: " + attackDamage + "\tEP Cost: " + extraPoints + "\tCritical Hit Chance: " + criticalChance + "\tCritical Bonus: x" + critBonus;
	}
}
