public class Healing
{
	private String healName;
	private String availClass;
	private double healedHP;
	private double usedEP;
	private int minLevel;
	private int cost;

	public Healing()
	{
		healName = "null";
		availClass = "null";
		healedHP = 0.0;
		usedEP = 0.0;
		minLevel = 0;
		cost = 0;
	}
	public Healing(String hN, String aC, double hHP, double uEP, int mL, int c)
	{
		healName = hN;
		availClass = aC;
		healedHP = hHP;
		usedEP = uEP;
		minLevel = mL;
		cost = c;
	}
	public void setHealName(String hN)
	{
		healName = hN;
	}
	public void setAvailClass(String aC)
	{
		availClass = aC;
	}
	public void setHealedHP(double hHP)
	{
		healedHP = hHP;
	}
	public void setUsedEP(double uEP)
	{
		usedEP = uEP;
	}
	public void setMinLevel(int mL)
	{
		minLevel = mL;
	}
	public void setCost(int c)
	{
		cost = c;
	}

	public String getHealName()
	{
		return healName;
	}
	public String getAvailClass()
	{
		return availClass;
	}
	public double getHealedHP()
	{
		return healedHP;
	}
	public double getUsedEP()
	{
		return usedEP;
	}
	public int getMinLevel()
	{
		return minLevel;
	}
	public int getCost()
	{
		return cost;
	}

	public String toString()
	{
		return healName + "\t\t\tHeals " + healedHP + "HP\t\tEP Cost: " + usedEP;
	}
	public String marketToString()
	{
		return healName + "\t\tHeals " + healedHP + "HP\t\tEP Cost: " + usedEP + "\n\tCost: " + cost + "\t\tMinimum Level: " + minLevel;
	}
}