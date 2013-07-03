public class Weapon
{
/*
 * Weapons
 * 
 * weaponName =   Name of the weapon.
 * weaponDamage = Weapon's attack damage.
 * addHP =        Amount of HP the weapon adds to the player's max HP.
 * addEP =        Amount of EP the weapon adds to the player's max EP.
 * cost =         How much money is required to buy the weapon.
 */
	
	private String weaponName;
	private double weaponDamage;
	private double addHP;
	private double addEP;
	private int cost;

	public Weapon()
	{
		weaponName = "";
		weaponDamage = 0;
		addHP = 0;
		addEP = 0;
		cost = 0;
	}
	public Weapon(String wN, double wD, double hP, double eP, int c)
	{
		weaponName = wN;
		weaponDamage = wD;
		addHP = hP;
		addEP = eP;
		cost = c;
	}
	public Weapon (Weapon w)
	{
		weaponName = w.getWeaponName();
		weaponDamage = w.getWeaponDamage();
		addHP = w.getHP();
		addEP = w.getEP();
		cost = w.getCost();
	}

	public void setWeaponName(String wN)
	{
		weaponName = wN;
	}
	public void setWeaponDamage(double wD)
	{
		weaponDamage = wD;
	}
	public void setHP(double hP)
	{
		addHP = hP;
	}
	public void setEP(double eP)
	{
		addEP = eP;
	}
	public void setCost(int c)
	{
		cost = c;
	}

	public String getWeaponName()
	{
		return weaponName;
	}
	public double getWeaponDamage()
	{
		return weaponDamage;
	}
	public double getHP()
	{
		return addHP;
	}
	public double getEP()
	{
		return addEP;
	}
	public int getCost()
	{
		return cost;
	}

	public String toString()
	{
		return weaponName + "\tDamage: " + weaponDamage + "\tAdds " + addHP + " HP\tAdds " + addEP + " EP";
	}
	public String marketToString()
	{
		return weaponName + "\tDamage: " + weaponDamage + "\tAdds " + addHP + "HP\tAdds " + addEP + "EP" + "\n\tCost: " + cost;
	}
}