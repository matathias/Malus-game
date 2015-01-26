public class Defense
{
	private String name;
	private double addHP;
	private double addEP;
	private int cost;

	public Defense()
	{
		name = "null";
		addHP = 0.0;
		addEP = 0.0;
		cost = 0;
	}
	public Defense(String n, double hP, double eP, int c)
	{
		name = n;
		addHP = hP;
		addEP = eP;
		cost = c;
	}

	public void setDefenseName(String n)
	{
		name = n;
	}
	public void setAddHP(double hP)
	{
		addHP = hP;
	}
	public void setAddEP(double eP)
	{
		addEP = eP;
	}
	public void setCost(int c)
	{
		cost = c;
	}

	public String getDefenseName()
	{
		return name;
	}
	public double getAddHP()
	{
		return addHP;
	}
	public double getAddEP()
	{
		return addEP;
	}
	public int getCost()
	{
		return cost;
	}

	public String toString()
	{
		return name + "\tAdds " + addHP + "HP and " + addEP + "EP\tCost: " + cost;
	}
}