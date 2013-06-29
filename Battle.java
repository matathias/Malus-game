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
		while (p.getHP() > 0 && e.getHP() > 0 && win != 2)
		{
			p.battleShow();
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
					{
						choiceAttack = Util.numberSelect("Will you:\t\t1. Use regular attack\t\t2. Use Special attack",2);
						switch(choiceAttack)
						{
							case 1:
								regAttack(p,e);
								break;
							case 2:
								System.out.println(p.showSpecialAttacks());
								do
								{
									choiceSpeAtt = Util.numberSelect("",p.numberSpecialAttacks());
									if(p.getSpecialAttackEP(choiceSpeAtt-1)> p.getEP())
										System.out.println("Not enough EP! Choose again.");
								}while(!(choiceSpeAtt>0 && choiceSpeAtt<p.numberSpecialAttacks()) || p.getSpecialAttackEP(choiceSpeAtt-1)>p.getEP());
								specialAttack(choiceSpeAtt-1,p,e);
								break;
						}
					}
					break;
				case 2:
					int fleeChance = rand.nextInt(99);
					int totalChance = (int)(100 * (double)(p.getLvl()/e.getLvl()));
					if(fleeChance<=totalChance)
					{
						win = 2;
					}
					else
					{
						System.out.println("You failed to run away!");
					}
					break;
				case 3:
					System.out.println(p.showHealing());
					do
					{
						choiceHeal = Util.numberSelect("",p.numberHealing());
						if(p.getHealingEP(choiceHeal-1)>p.getEP())
							System.out.println("Not enough EP! Choose again.");
					}while(!(choiceHeal>0 && choiceHeal<p.numberHealing()) || p.getHealingEP(choiceHeal-1)>p.getEP());
					p.useHealing(choiceHeal-1);
					break;
			}
			Util.pause();
			if (e.getHP() > 0 && win != 2)
			{
				mookAttack(e,p);
			}
		}
		winResult(win,p,e);
		return win; //returns the "win" number so that when this method (mookBattle) is called, the caller can determine what to do with the player afterward
	}

	private void regAttack(Player p, Player e)
	{
		damage = p.damage();
		System.out.println("You dealt " + damage + " to the " + e.getPlayerName() + "!");
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
				System.out.println("You have defeated the " + e.getPlayerName());
				System.out.println("+" + e.getEP() + "EP, +" + e.getEXP() + " EXP, +" + e.getMoney() + " Gold");
				p.addMoney(e.getMoney());
				p.addEXP(e.getEXP());
				p.addEP(e.getEP());
				Util.lineBreak();
				break;
			case 2: //Player Flees
				System.out.println("You ran away!");
				break;
			case 3: //Enemy wins
				System.out.println("You lost!");
				System.out.println("You lost 90% of your money! You lost 50% of your experience!");
				p.setMoney(p.getMoney()/10); //divides money by ten
				p.setEXP(p.getEXP()/2); //divides Experience by two
				p.setHP(p.getMaxHealth()/20);
				System.out.println("Money: " + p.getMoney() + "\tExp: " + p.getEXP());
				System.out.println("You will be returned to town.");
				Util.lineBreak();
				//Return player to town
				break;
		}
		Util.pause();
	}
}