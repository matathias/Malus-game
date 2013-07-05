import java.util.*;

public class Battle
{
	private int choiceMain;
	private int choiceAttack;
	private int choiceSpeAtt;
	private int choiceHeal;
	private int win;
	private int damage;
	private int winRes;
	private Player p, e;
	private Random rand;

	public Battle(Player pl, Player en)
	{
		p = pl;
		e = en;
		win = 0;
		rand = new Random();
	}

	public int mookBattle()
	{
		System.out.println("You have entered battle with the " + e.getPlayerName() + "!");
		Util.pause();
		while (p.getHP() > 0 && e.getHP() > 0 && win != 2)
		{
			doChoice();
			
			Util.pause();
			if (e.getHP() > 0 && win != 2)
			{
				mookAttack(e,p);
			}
		}
		winResult(win,p,e);
		return win; //returns the "win" number so that when this method (mookBattle) is called, the caller can determine what to do with the player afterward
	}

	private void doChoice()
	{
		battShow(p,e);
		if(p.numberHealing() < 1)
			choiceMain = Util.numberSelect("Will you:\t\t1. Attack\t\t2. Flee",2);
		else
			choiceMain = Util.numberSelect("Will you:\t\t1. Attack\t\t2. Flee\t\t3. Heal",3);
		
		switch(choiceMain)
		{
			case 1:
				if(p.numberSpecialAttacks()<1)
					regAttack(p,e);
				else
					doAttack();
				break;
			case 2:
				doFlee();
				break;
			case 3:
				doHealing();
				break;
		}
	}
	private void doAttack()
	{
		choiceAttack = Util.numberSelect("Will you:\n1. Use regular attack\n2. Use Special attack\n3. Go back",3);
		switch(choiceAttack)
		{
			case 1:
				regAttack(p,e);
				break;
			case 2:
				doSpeAttack();
				break;
			case 3:
				doChoice();
				break;
		}
	}
	private void doSpeAttack()
	{
		p.showSpecialAttacks();
		System.out.println(String.valueOf(p.numberSpecialAttacks() + 1) + ". Go back");
		boolean goBack = false;
		do
		{
			choiceSpeAtt = Util.numberSelect("",p.numberSpecialAttacks() + 1);
			if(choiceSpeAtt == p.numberSpecialAttacks()+1)
			{
				goBack = true;
				break;
			}
			else if(p.getSpecialAttackEP(choiceSpeAtt-1)> p.getEP())
				System.out.println("You don't have enough EP! Choose again.");
		}while(p.getSpecialAttackEP(choiceSpeAtt-1)>p.getEP());
		
		if(goBack)
			doAttack();
		else
			specialAttack(choiceSpeAtt-1,p,e);
	}
	private void doHealing()
	{
		p.showHealing();
		System.out.println(String.valueOf(p.numberHealing() + 1) + ". Go back");
		do
		{
			choiceHeal = Util.numberSelect("",p.numberHealing()+1);
			if(choiceHeal == p.numberHealing()+1)
			{
				doChoice();
				break;
			}
			else if(p.getHealingEP(choiceHeal-1)>p.getEP())
				System.out.println("Not enough EP! Choose again.");
		}while(p.getHealingEP(choiceHeal-1)>p.getEP());
		
		if(choiceHeal <= p.numberHealing())
			p.useHealing(choiceHeal-1);
	}
	private void doFlee()
	{
		int fleeChance = rand.nextInt(99);
		int totalChance = (int)(100 * (double)(p.getLvl()/e.getLvl()));
		if(fleeChance<=totalChance)
			win = 2;
		else
			System.out.println("You failed to run away!");
	}
	private void regAttack(Player p, Player e)
	{
		damage = p.damage();
		System.out.println("You dealt " + damage + " damage to the " + e.getPlayerName() + "!");
		Util.lineBreak();
		e.subtractHP(damage);
		if(e.getHP() <= 0)
			win = 1;
	}
	private void specialAttack(int index,Player p,Player e)
	{
		System.out.println("You used " + p.getSpecialAttackName(index) + "!");
		damage = p.specialDamage(index);
		System.out.println(damage + " damage dealt to the " + e.getPlayerName() + "!");
		Util.lineBreak();
		e.subtractHP(damage);
		if(e.getHP()<= 0)
			win = 1;
	}
	private void mookAttack(Player e, Player p)
	{
		damage = e.damage();
		System.out.println("The " + e.getPlayerName() + " dealt " + damage + " damage to you!");
		Util.lineBreak();
		p.subtractHP(damage);
		if(p.getHP()<=0)
			win = 3;
		Util.pause();
	}

	private void winResult(int w, Player p, Player e)
	{
		winRes = w;
		switch(winRes)
		{
			case 1: //Player Wins
				Util.lineBreak();
				System.out.println("You have defeated the " + e.getPlayerName() + ".");
				System.out.println("+" + (int)e.getEP() + " EP, +" + (int)e.getEXP() + " EXP, +" + (int)e.getMoney() + " Gold");
				p.addMoney(e.getMoney());
				p.addEXP(e.getEXP());
				p.addEP(e.getEP());
				Util.lineBreak();
				break;
			case 2: //Player Flees
				Util.lineBreak();
				System.out.println("You ran away!");
				Util.lineBreak();
				break;
			case 3: //Enemy wins
				Util.lineBreak();
				System.out.println("You lost!");
				System.out.println("You lost 50% of your money! Yoeu lost 50% of your experience!");
				p.setMoney(p.getMoney()/2); //divides money by two
				p.setEXP(p.getEXP()/2); //divides Experience by two
				p.setHP(p.getMaxHealth()/20);
				System.out.println("Money: " + (int)p.getMoney() + "\tExp: " + (int)p.getEXP());
				System.out.println("You will be returned to town.");
				Util.lineBreak();
				//Return player to town
				break;
		}
		Util.pause();
	}
	private void battShow(Player pl, Player en)
	{
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|                                                                              |");
		
		String nameRow = "| ";
		int numSpace = (25 - pl.getPlayerName().length()) + (12 - pl.getPlayerClass().length()) + 4;
		numSpace += (30 - en.getPlayerName().length());
		String spaces = "";
		for(int i = 1; i <=numSpace; i++)
			spaces += " ";
		nameRow += pl.getPlayerName() + " the " + pl.getPlayerClass() + spaces + en.getPlayerName() + " |";
		System.out.println(nameRow);
		
		String plHP = String.valueOf((int)pl.getHP());
		String plMaxHP = String.valueOf((int)pl.getMaxHealth());
		String enHP = String.valueOf((int)en.getHP());
		String enMaxHP = String.valueOf((int)en.getMaxHealth());
		numSpace = 66 - plHP.length() - plMaxHP.length() - enHP.length() - enMaxHP.length();
		spaces = "";
		for(int i = 1; i <= numSpace; i++)
			spaces += " ";
		String hpRow = "| HP: " + plHP + "/" + plMaxHP + spaces + "HP: " + enHP + "/" + enMaxHP + " |";
		System.out.println(hpRow);
		
		String plEP = String.valueOf((int)pl.getEP());
		String plMaxEP = String.valueOf((int)pl.getMaxEP());
		numSpace = 72 - plEP.length() - plMaxEP.length();
		spaces = "";
		for(int i = 1; i <= numSpace; i++)
			spaces += " ";
		String epRow = "| EP: " + plEP + "/" + plMaxEP + spaces + "|";
		System.out.println(epRow);
		
		numSpace = 69 - pl.getWeaponName().length();
		spaces = "";
		for(int i = 1; i <= numSpace; i++)
			spaces += " ";
		String weapRow = "| Weapon: " + pl.getWeaponName() + spaces + "|";
		System.out.println(weapRow);
		
		String plDam = String.valueOf((int)pl.getTotalRawDamage());
		numSpace = 62 - plDam.length();
		spaces = "";
		for(int i = 1; i <= numSpace; i++)
			spaces += " ";
		String damRow = "| Attack Damage: " + plDam + spaces + "|";
		System.out.println(damRow);
		
		System.out.println("|                                                                              |");
		System.out.println("+------------------------------------------------------------------------------+");
	}
}