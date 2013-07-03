import java.util.*;

public class BossBattles //change Util.numberSelect to proper parameters! - Done
{
	private int choiceMain;
	private int choiceAttack;
	private int choiceSpeAtt;
	private int choiceHeal;
	private int win;
	private int damage;
	private int winRes;
	private Random rand;
	private Player p, b;

	public BossBattles()
	{
		win = 0;
		rand = new Random();
	}
	private void playerAttack(Player player, Player boss)
	{
		p = player;
		b = boss;
		Util.pause();
		
		doChoice(false);
		
		Util.lineBreak();
		Util.pause();
	}
	private void playerAttackMalus(Player player, Player boss) //no fleeing
	{
		p = player;
		b = boss;
		Util.pause();

		doChoice(true);
		
		Util.pause();
	}
	
	private void doChoice(boolean isMalus)
	{
		if(isMalus)
		{
			p.battleShow();
			if(p.numberHealing() < 1)
				choiceMain = Util.numberSelect("Will you:\t\t1. Attack",1);
			else
				choiceMain = Util.numberSelect("Will you:\t\t1. Attack\t\t2. Heal",2);
		
			switch(choiceMain)
			{
				case 1:
					if(p.numberSpecialAttacks()<1)
						regAttack(p,b);
					else
						doAttack(isMalus);
					break;
				case 2:
					doHealing(isMalus);
					break;
			}
		}
		else
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
						regAttack(p,b);
					else
						doAttack(isMalus);
					break;
				case 2:
					doFlee();
					break;
				case 3:
					doHealing(isMalus);
					break;
			}
		}
	}
	private void doAttack(boolean isMalus)
	{
		choiceAttack = Util.numberSelect("Will you:\n1. Use regular attack\n2. Use Special attack\n3. Go back",3);
		switch(choiceAttack)
		{
			case 1:
				regAttack(p,b);
				break;
			case 2:
				doSpeAttack(isMalus);
				break;
			case 3:
				doChoice(isMalus);
				break;
		}
	}
	private void doSpeAttack(boolean isMalus)
	{
		System.out.println(p.showSpecialAttacks());
		System.out.println(String.valueOf(p.numberSpecialAttacks() + 1) + ". Go back");
		do
		{
			choiceSpeAtt = Util.numberSelect("",p.numberSpecialAttacks() + 1);
			if(choiceSpeAtt == p.numberSpecialAttacks()+1)
			{
				doAttack(isMalus);
				break;
			}
			else if(p.getSpecialAttackEP(choiceSpeAtt-1)> p.getEP())
				System.out.println("Not enough EP! Choose again.");
		}while(p.getSpecialAttackEP(choiceSpeAtt-1)>p.getEP());
		
		if(choiceSpeAtt <= p.numberSpecialAttacks())
			specialAttack(choiceSpeAtt-1,p,b);
	}
	private void doHealing(boolean isMalus)
	{
		System.out.println(p.showHealing());
		System.out.println(String.valueOf(p.numberHealing() + 1) + ". Go back");
		do
		{
			choiceHeal = Util.numberSelect("",p.numberHealing()+1);
			if(choiceHeal == p.numberHealing()+1)
			{
				doChoice(isMalus);
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
		int totalChance = (int)(100 * (double)(p.getLvl()/b.getLvl()));
		if(fleeChance<=totalChance)
			win = 2;
		else
			System.out.println("You failed to run away!");
	}
	private void regAttack(Player player, Player boss)
	{
		damage = player.damage();
		System.out.println("You dealt " + damage + " to " + boss.getPlayerName() + "!");
		Util.lineBreak();
		boss.subtractHP(damage);
		if(boss.getHP() <= 0)
			win = 1;
	}
	private void specialAttack(int index, Player player, Player boss)
	{
		System.out.println("You used " + player.getSpecialAttackName(index) + "!");
		damage = player.specialDamage(index);
		System.out.println(damage + " damage dealt to " + boss.getPlayerName() + "!");
		Util.lineBreak();
		boss.subtractHP(damage);
		if(boss.getHP()<= 0)
			win = 1;
	}
	private void winResult(int w, Player p, Player e)
	{
		winRes = w;
		switch(winRes)
		{
			case 1: //Player Wins
				System.out.println("You have defeated the " + e.getPlayerName() + "!");
				System.out.println("+" + e.getEP() + "EP, +" + e.getEXP() + " EXP, +" + e.getMoney() + " Gold");
				p.addMoney(e.getMoney());
				p.addEXP(e.getEXP());
				p.addEP(e.getEP());
				Util.lineBreak();
				Util.pause();
				break;
			case 2: //Player Flees
				System.out.println("You ran away!");
				Util.pause();
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
				Util.pause();
				break;
		}
	}
	/*Bosses:
	 *
	 *Desert: Sand Stone
	 *Plains: Grass Stone
	 *Forest: Leaf Stone
	 *Mountains: Blizzard Stone
	 *Volcano: Boss-Class Aerial: Wyvern
	 *Caverns: Boss-Class Ground: Cerberus
	 *Base
	 *	Factory: Incomplete Bug Crawler
	 *	Urban: Civil Control Mech
	 *	Laboratory: Prototype Mantis Crawler
	 *	Military: Insecti Crawler
	 *	Final: Malus
	 */

	 /*
	  * 				damage = __.damage();
	 					System.out.println("__ dealt " + damage + " damage.");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;

						damage = (int)(__.damage()*__);
	 					System.out.println("__ attacked you with __ and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	  */
	 public int sandStoneBoss(Player player)
	 {
	 	System.out.println("You have entered battle with Sand Stone!");
	 	Player sandStone = new Player(750,15,125,50,20,6,"Sand Stone"); //Placeholder values
	 	boolean quarter = true;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && sandStone.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,sandStone);
	 		player = p;
	 		sandStone = b;
	 		if(sandStone.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Attack
	 			 *2. Sand Sheer
	 			 *3. Sand Storm
	 			 *
	 			 *"Emergency":
	 			 *4. Desert Storm
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(sandStone.getHP()> (sandStone.getMaxHealth()/2))
	 			{
	 				if(attackChance < 75)
	 				{
	 					damage = sandStone.damage();
	 					System.out.println("Sand Stone dealt " + damage + " damage to you !");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(sandStone.damage()*1.25);
	 					System.out.println("Sand Stone attacked you with Sand Sheer, dealing " + damage + " damage.");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 				}
	 			}
	 			else if (sandStone.getHP()> (sandStone.getMaxHealth()/4))
	 			{
	 				if(quarter)
	 				{
	 					damage = (int)(sandStone.damage()*1.75);
	 					System.out.println("Sand Stone attacked you with Sand Storm! " + damage + " damage dealt to you!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					quarter = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 75)
	 					{
	 						damage = sandStone.damage();
	 						System.out.println("Sand Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
		 				{
		 					damage = (int)(sandStone.damage()*1.25);
	 						System.out.println("Sand Stone attacked you with Sand Sheer, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=5)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else
	 			{
	 				if(!emergency)
	 				{
	 					Story.desertBossEmergency();
	 					System.out.println("Sand Stone attacked you with Desert Storm!");
	 					damage = (int)(sandStone.damage()*3);
	 					System.out.println("The forces of sand and desert come together in one spot, attacking you for " + damage + " damage!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					emergency = true;
	 				}
	 				else
	 				{
	 					if(attackChance < 45)
	 					{
	 						damage = sandStone.damage();
	 						System.out.println("Sand Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance >= 40 && attackChance < 75)
		 				{
		 					damage = (int)(sandStone.damage()*1.25);
	 						System.out.println("Sand Stone attacked you with Sand Sheer, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else if(attackChance >=75 && attackChance < 90)
	 					{
	 						damage = (int)(sandStone.damage()*1.75);
	 						System.out.println("Sand Stone attacked you with Sand Storm! " + damage + " damage dealt to you!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(sandStone.damage()*3);
	 						System.out.println("Sand Stone attacked you with Desert Storm! \nThe forces of sand and desert come together in one spot, attacking you for " + damage + " damage!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,sandStone);
	 	return win;
	 } //replace placeholder values
	 public int grassStoneBoss(Player player)
	 {
	 	System.out.println("You have entered battle with Grass Stone!");
	 	Player grassStone = new Player(1500,26,256,250,40,12,"Grass Stone"); //Placeholder values
	 	boolean quarter = true;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && grassStone.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,grassStone);
	 		player = p;
	 		grassStone = b;
	 		if(grassStone.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Attack
	 			 *2. Terraform
	 			 *3. Dust Storm
	 			 *
	 			 *"Emergency":
	 			 *4. Tornado
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(grassStone.getHP()> (grassStone.getMaxHealth()/2))
	 			{
	 				if(attackChance < 75)
	 				{
	 					damage = grassStone.damage();
	 					System.out.println("Grass Stone dealt " + damage + " damage to you !");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(grassStone.damage()*1.3);
	 					System.out.println("Grass Stone attacked you with Terraform, dealing " + damage + " damage.");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 				}
	 			}
	 			else if (grassStone.getHP()> (grassStone.getMaxHealth()/4))
	 			{
	 				if(quarter)
	 				{
	 					damage = (int)(grassStone.damage()*1.6);
	 					System.out.println("Grass Stone attacked you with Dust Storm! " + damage + " damage dealt to you!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					quarter = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 75)
	 					{
	 						damage = grassStone.damage();
	 						System.out.println("Grass Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
		 				{
		 					damage = (int)(grassStone.damage()*1.3);
	 						System.out.println("Grass Stone attacked you with Terraform, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=5)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else
	 			{
	 				if(!emergency)
	 				{
	 					Story.plainsBossEmergency();
	 					damage = (int)(grassStone.damage()*4);
	 					System.out.println("Grass Stone attacked you with Tornado! \nThe forces of the wind come together in one spot, attacking you for " + damage + " damage!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					emergency = true;
	 				}
	 				else
	 				{
	 					if(attackChance < 45)
	 					{
	 						damage = grassStone.damage();
	 						System.out.println("Grass Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance >= 40 && attackChance < 75)
		 				{
		 					damage = (int)(grassStone.damage()*1.3);
	 						System.out.println("Grass Stone attacked you with Terraform, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else if(attackChance >=75 && attackChance < 90)
	 					{
	 						damage = (int)(grassStone.damage()*1.6);
	 						System.out.println("Grass Stone attacked you with Dust Storm! " + damage + " damage dealt to you!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(grassStone.damage()*4);
	 						System.out.println("Grass Stone attacked you with Tornado! \nThe forces of the wind come together in one spot, attacking you for " + damage + " damage!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,grassStone);
	 	return win;
	 } //replace placeholder values
	 public int leafStoneBoss(Player player)
	 {
	 	System.out.println("You have entered battle with Leaf Stone!");
	 	Player leafStone = new Player(2500,58,485,1000,80,18,"Leaf Stone"); //Placeholder values
	 	boolean quarter = true;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && leafStone.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,leafStone);
	 		player = p;
	 		leafStone = b;
	 		if(leafStone.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Attack
	 			 *2. Leaf Sheer
	 			 *3. Leaf Storm
	 			 *
	 			 *"Emergency":
	 			 *4. Thunderstorm
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(leafStone.getHP()> (leafStone.getMaxHealth()/2))
	 			{
	 				if(attackChance < 75)
	 				{
	 					damage = leafStone.damage();
	 					System.out.println("Leaf Stone dealt " + damage + " damage to you !");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(leafStone.damage()*1.3);
	 					System.out.println("Leaf Stone attacked you with Leaf Sheer, dealing " + damage + " damage.");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 				}
	 			}
	 			else if (leafStone.getHP()> (leafStone.getMaxHealth()/4))
	 			{
	 				if(quarter)
	 				{
	 					damage = (int)(leafStone.damage()*1.7);
	 					System.out.println("Leaf Stone attacked you with Leaf Storm! " + damage + " damage dealt to you!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					quarter = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 75)
	 					{
	 						damage = leafStone.damage();
	 						System.out.println("Leaf Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
		 				{
		 					damage = (int)(leafStone.damage()*1.3);
	 						System.out.println("Leaf Stone attacked you with Leaf Sheer, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=5)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else
	 			{
	 				if(!emergency)
	 				{
	 					Story.forestBossEmergency();
	 					damage = (int)(leafStone.damage()*3.5);
	 					System.out.println("Leaf Stone attacked you with Thunderstorm! \nThe forces of water and lightning come together in one spot, attacking you for " + damage + " damage!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					emergency = true;
	 				}
	 				else
	 				{
	 					if(attackChance < 45)
	 					{
	 						damage = leafStone.damage();
	 						System.out.println("Leaf Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance >= 40 && attackChance < 75)
		 				{
		 					damage = (int)(leafStone.damage()*1.3);
	 						System.out.println("Leaf Stone attacked you with Leaf Sheer, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else if(attackChance >=75 && attackChance < 90)
	 					{
	 						damage = (int)(leafStone.damage()*1.7);
	 						System.out.println("Leaf Stone attacked you with Leaf Storm! " + damage + " damage dealt to you!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(leafStone.damage()*3.5);
	 						System.out.println("Leaf Stone attacked you with Thunderstorm! \nThe forces of water and lightning come together in one spot, attacking you for " + damage + " damage!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,leafStone);
	 	return win;
	 } //replace placeholder values
	 public int blizzardStoneBoss(Player player)
	 {
	 	System.out.println("You have entered battle with Blizzard Stone!");
	 	Player blizzardStone = new Player(4000,120,886,3000,160,24,"Blizzard Stone"); //Placeholder values
	 	boolean quarter = true;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && blizzardStone.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,blizzardStone);
	 		player = p;
	 		blizzardStone = b;
	 		if(blizzardStone.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Attack
	 			 *2. Ice Sheer
	 			 *3. Ice Storm
	 			 *
	 			 *"Emergency":
	 			 *4. Blizzard
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(blizzardStone.getHP()> (blizzardStone.getMaxHealth()/2))
	 			{
	 				if(attackChance < 80)
	 				{
	 					damage = blizzardStone.damage();
	 					System.out.println("Blizzard Stone dealt " + damage + " damage to you !");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(blizzardStone.damage()*1.4);
	 					System.out.println("Blizzard Stone attacked you with Ice Sheer, dealing " + damage + " damage.");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 				}
	 			}
	 			else if (blizzardStone.getHP()> (blizzardStone.getMaxHealth()/4))
	 			{
	 				if(quarter)
	 				{
	 					damage = (int)(blizzardStone.damage()*1.85);
	 					System.out.println("Blizzard Stone attacked you with Ice Storm! " + damage + " damage dealt to you!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					quarter = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 80)
	 					{
	 						damage = blizzardStone.damage();
	 						System.out.println("Blizzard Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
		 				{
		 					damage = (int)(blizzardStone.damage()*1.4);
	 						System.out.println("Blizzard Stone attacked you with Ice Sheer, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=6)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else
	 			{
	 				if(!emergency)
	 				{
	 					Story.mountainsBossEmergency();
	 					damage = (int)(blizzardStone.damage()*5);
	 					System.out.println("Blizzard Stone attacked you with Blizzard! \nThe forces of ice and snow come together in one spot, attacking you for " + damage + " damage!");
	 					Util.lineBreak();
	 					player.subtractHP(damage);
	 					if(player.getHP() <= 0)
	 						win = 3;
	 					emergency = true;
	 				}
	 				else
	 				{
	 					if(attackChance < 50)
	 					{
	 						damage = blizzardStone.damage();
	 						System.out.println("Blizzard Stone dealt " + damage + " damage to you !");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance >= 50 && attackChance < 75)
		 				{
		 					damage = (int)(blizzardStone.damage()*1.4);
	 						System.out.println("Blizzard Stone attacked you with Ice Sheer, dealing " + damage + " damage.");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else if(attackChance >=75 && attackChance < 90)
	 					{
	 						damage = (int)(blizzardStone.damage()*1.85);
	 						System.out.println("Blizzard Stone attacked you with Ice Storm! " + damage + " damage dealt to you!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(blizzardStone.damage()*5);
	 						System.out.println("Blizzard Stone attacked you with Blizzard! \nThe forces of ice and snow come together in one spot, attacking you for " + damage + " damage!");
	 						Util.lineBreak();
	 						player.subtractHP(damage);
	 						if(player.getHP() <= 0)
	 							win = 3;
	 					}
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,blizzardStone);
	 	return win;
	 } //replace placeholder values
	 public int wyvernBoss(Player player)
	 {
	 	System.out.println("You have entered battle with the Boss-Class Aerial: Wyvern!");
	 	Player wyvern = new Player(12500,240,1587,9000,320,30,"BCA Wyvern"); //Placeholder values
	 	boolean third = true;
	 	boolean quarter = true;
	 	int thirdCounter = 0;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && wyvern.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,wyvern);
	 		player = p;
	 		wyvern = b;
	 		if(wyvern.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Tail Swipe
	 			 *2. Flamethrower
	 			 *3. Wind Sheer
	 			 *4. Fly-by
	 			 *
	 			 *"Emergency":
	 			 *5. Tail Spike
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(wyvern.getHP()> (wyvern.getMaxHealth()/2)) //health above 50%
	 			{
	 				if(attackChance < 60)
	 				{
						damage = wyvern.damage();
	 					System.out.println("BCA Wyvern used Tail Swipe and dealt " + damage + " damage.");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(wyvern.damage()*1.25);
	 					System.out.println("BCA Wyvern attacked you with Flamethrower and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 			}
	 			else if (wyvern.getHP()> (wyvern.getMaxHealth()/3)) //health below 50% but above 33%
	 			{
	 				if(third)
	 				{
	 					damage = (int)(wyvern.damage()*1.75);
	 					System.out.println("BCA Wyvern attacked you with Wind Sheer and dealt" + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						third = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 60)
	 					{
							damage = wyvern.damage();
	 						System.out.println("BCA Wyvern used Tail Swipe and dealt " + damage + " damage.");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(wyvern.damage()*1.25);
	 						System.out.println("BCA Wyvern attacked you with Flamethrower and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 				}
	 				thirdCounter++;
	 				if(thirdCounter>=4)
	 				{
	 					thirdCounter = 0;
	 					third = true;
	 				}
	 			}
	 			else if (wyvern.getHP()> (wyvern.getMaxHealth()/5)) //health below 33% but higher than 20%
	 			{
	 				//Normal Attacks + health/third attack + occasional quarter/attack
	 				if(quarter)
	 				{
	 					damage = (int)(wyvern.damage()*2.75);
	 					System.out.println("BCA Wyvern attacked you by Flying by the platform at a high velocity and creating high speed winds!");
	 					System.out.println("It has dealt " + damage + " damage to you!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						quarter = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 50)
	 					{
							damage = wyvern.damage();
	 						System.out.println("BCA Wyvern used Tail Swipe and dealt " + damage + " damage.");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance > 50 && attackChance < 85)
	 					{
	 						damage = (int)(wyvern.damage()*1.25);
	 						System.out.println("BCA Wyvern attacked you with Flamethrower and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(wyvern.damage()*1.75);
	 						System.out.println("BCA Wyvern attacked you with Wind Sheer and dealt" + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=5)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else
	 			{
	 				//Normal Attacks + health/third attack + quarter/attack + occasional emergency attacks
	 				if(!emergency)
	 				{
	 					Story.wyvernBossEmergency();
	 					damage = (int)(wyvern.damage()*4);
	 					System.out.println("BCA Wyvern attacked you with its Tail Spike! The platform is electrocuted and shakes violently, dealing " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						emergency = true;
	 				}
	 				else
	 				{
	 					if(attackChance < 30)
	 					{
							damage = wyvern.damage();
	 						System.out.println("BCA Wyvern used Tail Swipe and dealt " + damage + " damage.");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance > 30 && attackChance < 55)
	 					{
	 						damage = (int)(wyvern.damage()*1.25);
	 						System.out.println("BCA Wyvern attacked you with Flamethrower and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance > 55 && attackChance <75)
	 					{
	 						damage = (int)(wyvern.damage()*1.75);
	 						System.out.println("BCA Wyvern attacked you with Wind Sheer and dealt" + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance >75 && attackChance <90)
	 					{
	 						damage = (int)(wyvern.damage()*2.75);
	 						System.out.println("BCA Wyvern attacked you by Flying by the platform at a high velocity and creating high speed winds!");
	 						System.out.println("It has dealt " + damage + " damage to you!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(wyvern.damage()*4);
	 						System.out.println("BCA Wyvern attacked you with its Tail Spike! The platform is electrocuted and shakes violently, dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,wyvern);
	 	return win;
	 } //replace placeholder values
	 public int cerberusBoss(Player player)
	 {
	 	System.out.println("You have entered battle with the Boss-Class Ground: Cerberus!");
	 	Player cerberus = new Player(25000,550,2813,15000,640,36,"BCG Cerberus"); //Placeholder values
	 	boolean quarter = true;
	 	boolean third = true;
	 	int thirdCounter = 0;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && cerberus.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,cerberus);
	 		player = p;
	 		cerberus = b;
	 		if(cerberus.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Bite
	 			 *2. Roar
	 			 *3. Pounce
	 			 *4. Dash-Slide
	 			 *
	 			 *"Emergency":
	 			 *5. Blitz
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(cerberus.getHP()> (cerberus.getMaxHealth()/2)) //health above 50%
	 			{
	 				if(attackChance < 60)
	 				{
						damage = cerberus.damage();
	 					System.out.println("BCG Cerberus used Bite and dealt " + damage + " damage.");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(cerberus.damage()*1.25);
	 					System.out.println("BCG Cerberus attacked you with Roar and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 			}
	 			else if (cerberus.getHP()> (cerberus.getMaxHealth()/3)) //health below 50% but above 33%
	 			{
	 				if(third)
	 				{
	 					damage = (int)(cerberus.damage()*1.75);
	 					System.out.println("BCG Cerberus attacked you with Pounce and dealt" + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						third = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 60)
	 					{
							damage = cerberus.damage();
	 						System.out.println("BCG Cerberus used Bite and dealt " + damage + " damage.");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(cerberus.damage()*1.25);
	 						System.out.println("BCG Cerberus attacked you with Roar and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 				}
	 				thirdCounter++;
	 				if(thirdCounter>=4)
	 				{
	 					thirdCounter = 0;
	 					third = true;
	 				}
	 			}
	 			else if (cerberus.getHP()> (cerberus.getMaxHealth()/5)) //health below 33% but higher than 20%
	 			{
	 				//Normal Attacks + health/third attack + occasional quarter/attack
	 				if(quarter)
	 				{
	 					damage = (int)(cerberus.damage()*2.75);
	 					System.out.println("BCG Cerberus Dash-Slid into you, dealing " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						quarter = false;
	 				}
	 				else
	 				{
	 					if(attackChance < 50)
	 					{
							damage = cerberus.damage();
	 						System.out.println("BCG Cerberus used Bite and dealt " + damage + " damage.");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance > 50 && attackChance < 85)
	 					{
	 						damage = (int)(cerberus.damage()*1.25);
	 						System.out.println("BCG Cerberus attacked you with Roar and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(cerberus.damage()*1.75);
	 						System.out.println("BCG Cerberus attacked you with Pounce and dealt" + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=5)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else
	 			{
	 				//Normal Attacks + health/third attack + quarter/attack + occasional emergency attacks
	 				if(!emergency)
	 				{
	 					Story.cerberusBossEmergency();
	 					damage = (int)(cerberus.damage()*4);
	 					System.out.println("BCG Cerberus Blitzed you, attacking several times and dealing " + damage + " total damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						emergency = true;
	 				}
	 				else
	 				{
	 					if(attackChance < 30)
	 					{
							damage = cerberus.damage();
	 						System.out.println("BCG Cerberus used Bite and dealt " + damage + " damage.");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance > 30 && attackChance < 55)
	 					{
	 						damage = (int)(cerberus.damage()*1.25);
	 						System.out.println("BCG Cerberus attacked you with Roar and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance > 55 && attackChance <75)
	 					{
	 						damage = (int)(cerberus.damage()*1.75);
	 						System.out.println("BCG Cerberus attacked you with Pounce and dealt" + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else if(attackChance >75 && attackChance <90)
	 					{
	 						damage = (int)(cerberus.damage()*2.75);
	 						System.out.println("BCG Cerberus Dash-Slid into you, dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 					else
	 					{
	 						damage = (int)(cerberus.damage()*4);
	 						System.out.println("BCG Cerberus Blitzed you, attacking several times and dealing " + damage + " total damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 					}
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,cerberus);
	 	return win;
	 } //replace placeholder values
	 public int bugCrawlerBoss(Player player)
	 {
	 	System.out.println("You have entered battle with the Incomplete Bug Crawler!");
	 	Player bugCrawler = new Player(65000,850,2500,16500,1440,42,"Bug Crawler"); //Placeholder values
	 	boolean emergencyOne = true;
	 	boolean transformed = false;
	 	while (player.getHP() > 0 && bugCrawler.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,bugCrawler);
	 		player = p;
	 		bugCrawler = b;
	 		if(bugCrawler.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Machine Gun
	 			 *2. Plasma Cannon
	 			 *3. Fly-by
	 			 *
	 			 *Mode II Attacks:
	 			 *1. Plasma Cannon
	 			 *2. Laser Cannon
	 			 *3. Dash-Slide
	 			 *
	 			 *"Emergency":
	 			 *4. (mode 1): Tail Spike
	 			 *5. (mode 2): Blitz
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(bugCrawler.getHP() > bugCrawler.getMaxHealth()/3) //HP above 33%
	 			 {
	 			 	//Normal Attacks
	 			 	if(bugCrawler.getHP() > bugCrawler.getMaxHealth()*(3/4)) //HP above 75%
	 			 	{
	 			 		if(attackChance < 60)
	 			 		{
	 			 			damage = bugCrawler.damage();
	 						System.out.println("Bug Crawler attacked you with its Machine Gun and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*1.3);
	 						System.out.println("Bug Crawler attacked you with its Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 	else if(bugCrawler.getHP() > bugCrawler.getMaxHealth()/2) //HP between 75% and 50%
	 			 	{
	 			 		if(attackChance < 45)
	 			 		{
	 			 			damage = bugCrawler.damage();
	 						System.out.println("Bug Crawler attacked you with its Machine Gun and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 45 && attackChance <80)
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*1.3);
	 						System.out.println("Bug Crawler attacked you with its Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*1.6);
	 						System.out.println("Bug Crawler flew past the platform at a high velocity, creating high speed winds that dealt " + damage + " damage to you!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 	else //HP between 50% and 33%
	 			 	{
	 			 		if(emergencyOne)
	 			 		{
	 			 			Story.bugCrawlerModeOneEmergency();
	 			 			damage = (int)(bugCrawler.damage()*2.1);
	 						System.out.println("Bug Crawler drove its tail spike into the platform, electrocuting and shaking it violently.");
	 						System.out.println(damage + " damage dealt to you!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
							emergencyOne = false;
	 			 		}
	 			 		else
	 			 		{
	 			 			if(attackChance < 35)
	 				 		{
	 				 			damage = bugCrawler.damage();
	 							System.out.println("Bug Crawler attacked you with its Machine Gun and dealt " + damage + " damage!");
								Util.lineBreak();
								player.subtractHP(damage);
								if(player.getHP() <= 0)
									win = 3;
	 				 		}
	 				 		else if(attackChance > 35 && attackChance <65)
	 				 		{
	 			 				damage = (int)(bugCrawler.damage()*1.3);
	 							System.out.println("Bug Crawler attacked you with its Plasma Cannon and dealt " + damage + " damage!");
								Util.lineBreak();
								player.subtractHP(damage);
								if(player.getHP() <= 0)
									win = 3;
	 			 			}
	 				 		else if(attackChance>65 && attackChance<90)
	 				 		{
	 				 			damage = (int)(bugCrawler.damage()*1.6);
	 							System.out.println("Bug Crawler flew past the platform at a high velocity, creating high speed winds that dealt " + damage + " damage to you!");
								Util.lineBreak();
								player.subtractHP(damage);
								if(player.getHP() <= 0)
									win = 3;
	 			 			}
	 			 			else
	 			 			{
	 			 				damage = (int)(bugCrawler.damage()*2.1);
	 							System.out.println("Bug Crawler drove its tail spike into the platform, electrocuting and shaking it violently.");
	 							System.out.println(damage + " damage dealt to you!");
								Util.lineBreak();
								player.subtractHP(damage);
								if(player.getHP() <= 0)
									win = 3;
	 			 			}
	 			 		}
	 			 	}
	 			 }
	 			 else //HP below 33%
	 			 {
	 			 	if(!transformed)
	 			 	{
	 			 		Story.bugCrawlerTransform();
	 			 		damage = (int)(bugCrawler.damage()*4);
	 			 		System.out.println("Bug Crawler Blitzed you, attacking many times over to deal " + damage + " total damage!");
	 			 		Util.lineBreak();
	 			 		player.subtractHP(damage);
	 			 		if(player.getHP() <= 0)
	 			 			win = 3;
	 			 		transformed = true;
	 			 	}
	 			 	else if(bugCrawler.getHP() > bugCrawler.getMaxHealth()/10) //HP between 33% and 10%
	 			 	{
	 				 	if(attackChance < 40)
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*1.6);
	 						System.out.println("Bug Crawler attacked you with its Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 40 && attackChance <75)
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*2);
	 						System.out.println("Bug Crawler attacked you with its Laser Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*2.5);
	 						System.out.println("Bug Crawler Dash-Slid into you, dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 	else //HP below 10%
	 			 	{
	 			 		if(attackChance < 35)
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*1.6);
	 						System.out.println("Bug Crawler attacked you with its Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 35 && attackChance <65)
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*2);
	 						System.out.println("Bug Crawler attacked you with its Laser Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 65 && attackChance < 85)
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*2.5);
	 						System.out.println("Bug Crawler Dash-Slid into you, dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(bugCrawler.damage()*4);
	 			 			System.out.println("Bug Crawler Blitzed you, attacking many times over to deal " + damage + " total damage!");
	 			 			Util.lineBreak();
	 			 			player.subtractHP(damage);
	 			 			if(player.getHP() <= 0)
	 			 				win = 3;
	 			 		}
	 			 	}
	 			 }
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,bugCrawler);
	 	return win;
	 } //replace placeholder values
	 public int civilMechBoss(Player player) //replace placeholder values
	 {
	 	System.out.println("You have entered battle with the Civil Control Mech!");
	 	Player civilMech = new Player(75000,550,2000,16000,960,40,"Civil Control Mech"); //Placeholder values
	 	boolean quarter = true;
	 	boolean third = true;
	 	int thirdCounter = 0;
	 	int quarterCounter = 0;
	 	while (player.getHP() > 0 && civilMech.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,civilMech);
	 		player = p;
	 		civilMech = b;
	 		if(civilMech.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Pacify
	 			 *2. Stunner
	 			 *3. Shock net
	 			 *4. Prototype Stasis Cannon
	 			 *5. Last-Resort Alpha Cannon
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(civilMech.getHP()> (civilMech.getMaxHealth()/2)) //HP above 50%
	 			{
	 				if(attackChance < 40)
	 				{
	 					damage = (int)civilMech.damage();
	 					System.out.println("Civil Control Mech pacified you!... Though it really only did " + damage + " damage.");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance >40 && attackChance < 75)
	 				{
	 					damage = (int)(civilMech.damage()*1.2);
	 					System.out.println("Civil Control Mech attacked you with its Stunner and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(civilMech.damage()*1.5);
	 					System.out.println("Civil Control Mech attacked you with its Shock Net and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 			}
	 			else if (civilMech.getHP()> (civilMech.getMaxHealth()/3)) //HP between 50% and 33%
	 			{
	 				if(third)
	 				{
	 					damage = (int)(civilMech.damage()*2);
	 					System.out.println("Civil Control Mech attacked you with its Prototype Stasis Cannon! While the Stasis part failed, it dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						third = false;
	 				}
	 				else if(attackChance < 40)
	 				{
	 					damage = (int)civilMech.damage();
	 					System.out.println("Civil Control Mech pacified you!... Though it really only did " + damage + " damage.");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance >40 && attackChance < 75)
	 				{
	 					damage = (int)(civilMech.damage()*1.2);
	 					System.out.println("Civil Control Mech attacked you with its Stunner and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(civilMech.damage()*1.5);
	 					System.out.println("Civil Control Mech attacked you with its Shock Net and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				thirdCounter++;
	 				if(thirdCounter>=4)
	 				{
	 					thirdCounter = 0;
	 					third = true;
	 				}
	 			}
	 			else //HP below 33%
	 			{
	 				//Normal Attacks + health/third attack + occasional quarter/attack
	 				if(quarter)
	 				{
	 					Story.civilMechEmergency();
	 					damage = (int)(civilMech.damage()*5);
	 					System.out.println("Civil Control Mech used its Last-Resort Alpha Cannon and dealt " + damage + " damage to you!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
						quarter = false;
	 				}
	 				else if(attackChance < 35)
	 				{
	 					damage = (int)civilMech.damage();
	 					System.out.println("Civil Control Mech pacified you!... Though it really only did " + damage + " damage.");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 35 && attackChance < 65)
	 				{
	 					damage = (int)(civilMech.damage()*1.2);
	 					System.out.println("Civil Control Mech attacked you with its Stunner and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 65 && attackChance < 85)
	 				{
	 					damage = (int)(civilMech.damage()*1.5);
	 					System.out.println("Civil Control Mech attacked you with its Shock Net and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(civilMech.damage()*2);
	 					System.out.println("Civil Control Mech attacked you with its Prototype Stasis Cannon! While the Stasis part failed, it dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=4)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,civilMech);
	 	return win;
	 }
	 public int mantisCrawlerBoss(Player player) //replace placeholder values
	 {
	 	System.out.println("You have entered battle with the Prototype Mantis Crawler!");
	 	Player mantisCrawler = new Player(85000,1050,3000,17000,2160,44,"Mantis Crawler"); //Placeholder values
	 	boolean quarter = true;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	while (player.getHP() > 0 && mantisCrawler.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,mantisCrawler);
	 		player = p;
	 		mantisCrawler = b;
	 		if(mantisCrawler.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Pincer Slash
	 			 *2. Quad Plasma Cannon
	 			 *
	 			 *Mode II Attacks:
	 			 *1. Preying Lash
	 			 *2. Dash-Slide
	 			 *3. Quad Plasma Cannon
	 			 *4. Preying Grasp
	 			 *
	 			 *"Emergency":
	 			 *5. Predator's Chance
	 			 *6. Berserk
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(mantisCrawler.getHP() > mantisCrawler.getMaxHealth()/3) //HP above 33%
	 			 {
	 			 	if(mantisCrawler.getHP() > mantisCrawler.getMaxHealth()/2) //HP above 50%
	 			 	{
	 			 		if(attackChance <65)
	 			 		{
	 			 			damage = mantisCrawler.damage();
	 						System.out.println("Mantis Crawler attacked you with Pincer Slash and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*2);
		 					System.out.println("Mantis Crawler attacked you with its Quad Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 	else //HP between 50% and 33%
	 			 	{
	 			 		if(attackChance <50)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*.75);
	 						System.out.println("Mantis Crawler attacked you with Pincer Slash and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 50 && attackChance < 80)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*1.5);
		 					System.out.println("Mantis Crawler attacked you with its Quad Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*2.25);
		 					System.out.println("Mantis Crawler ambushed you with Predator's Chance and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 }
	 			 else //HP below 33%
	 			 {
	 			 	if(!emergency)
	 			 	{
	 			 		emergency = true;
	 			 		Story.mantisCrawlerEmergency();
	 			 		damage = (int)(mantisCrawler.damage()*5);
	 					System.out.println("Mantis Crawler went Berserk, attacking you insanely and dealing " + damage + " total damage!!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 			 	}
	 			 	else if(mantisCrawler.getHP() > mantisCrawler.getMaxHealth()/8) //HP between 33% and 12.5%
	 			 	{
	 			 		if(attackChance < 35)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*2);
	 						System.out.println("Mantis Crawler attacked you with Preying Lash and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 35 && attackChance < 65)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*2.5);
	 						System.out.println("Mantis Crawler Dash-Slid across the battlefield, ramming into you and dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 65 && attackChance < 85)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*3);
	 						System.out.println("Mantis Crawler attacked you with its Quad Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*3.8);
	 						System.out.println("Mantis Crawler lunged out at you and caught you within its Preying Grasp! It deals " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 	else //HP below 12.5%
	 			 	{
	 			 		if(quarter)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*5);
	 						System.out.println("Mantis Crawler went Berserk, attacking you insanely and dealing " + damage + " total damage!!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 			quarter = false;
	 			 		}
	 			 		else if(attackChance < 35)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*2);
	 						System.out.println("Mantis Crawler attacked you with Preying Lash and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 35 && attackChance < 65)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*2.5);
	 						System.out.println("Mantis Crawler Dash-Slid across the battlefield, ramming into you and dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if(attackChance > 65 && attackChance < 85)
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*3);
	 						System.out.println("Mantis Crawler attacked you with its Quad Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(mantisCrawler.damage()*3.8);
	 						System.out.println("Mantis Crawler lunged out at you and caught you within its Preying Grasp! It deals " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		quarterCounter++;
	 			 		if(quarterCounter>=6)
	 			 		{
	 			 			quarterCounter = 0;
	 			 			quarter = true;
	 			 		}
	 			 	}
	 			 }
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,mantisCrawler);
	 	return win;
	 }
	 public int insectiCrawlerBoss(Player player) //replace placeholder values
	 {
	 	System.out.println("You have entered battle with the Insecti Crawler!");
	 	Player insectiCrawler = new Player(98000,1250,3500,17500,3240,46,"Insecti Crawler"); //Placeholder values
	 	boolean quarter = true;
	 	int quarterCounter = 0;
	 	boolean emergency = false;
	 	boolean transformed = false;
	 	while (player.getHP() > 0 && insectiCrawler.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,insectiCrawler);
	 		player = p;
	 		insectiCrawler = b;
	 		if(insectiCrawler.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Pincer Lash
	 			 *2. Dash-Slide
	 			 *3. Guass Cannon
	 			 *
	 			 *Mode II Attacks:
	 			 *1. Dash-Slide
	 			 *2. Laceration Swipe
	 			 *3. Machina Guass Cannon
	 			 *4. Alpha-Class Plasma Cannon
	 			 *
	 			 *"Emergency":
	 			 *5. Machina Guass Cannon
	 			 *6. Prototype Black Hole Cannon
	 			 *
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			if(!transformed && insectiCrawler.getHP() > insectiCrawler.getMaxHealth()/3) //HP above 33%
	 			 {
	 			 	if(quarter)
	 			 	{
	 			 		damage = (int)(insectiCrawler.damage()*3.7);
	 					System.out.println("Insecti Crawler attacked you with its Machina Guass Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 			 		quarter = false;
	 			 	}
					else if(attackChance < 47)
					{
						damage = (int)(insectiCrawler.damage()*.9);
	 					System.out.println("Insecti Crawler attacked you with Pincer Lash and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
					}
					else if(attackChance > 47 && attackChance < 78)
					{
						damage = (int)(insectiCrawler.damage()*1.25);
	 					System.out.println("Insecti Crawler Dash-Slid across the battlefield, ramming you and dealing " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
					}
					else
					{
						damage = (int)(insectiCrawler.damage()*1.85);
	 					System.out.println("Insecti Crawler attacked you with its Guass Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
					}
	 			 	quarterCounter++;
	 			 	if(quarterCounter>=8)
	 			 	{
	 			 		quarterCounter = 0;
	 			 		quarter = true;
	 			 	}
	 			 }
	 			 else //HP below 33%
	 			 {
	 			 	if(!transformed)
	 			 	{
	 			 		Story.insectiCrawlerTransform();
	 			 		System.out.println("Insecti Crawler heals itself for " + (int)(insectiCrawler.getMaxHealth()/4) + " HP!");
	 			 		insectiCrawler.addHP(insectiCrawler.getMaxHealth()/4);
	 			 		Util.lineBreak();
	 			 		transformed = true;
	 			 	}
	 			 	else if(insectiCrawler.getHP() > insectiCrawler.getMaxHealth()/8) //HP above 12.5%
	 			 	{
	 			 		if(attackChance < 35)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*2);
	 						System.out.println("Insecti Crawler Dash-Slid across the battlefield, ramming you and dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if (attackChance > 35 && attackChance < 70)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*2.65);
	 						System.out.println("Insecti Crawler attacked you with its Laceration Swipe and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if (attackChance > 70 && attackChance < 90)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*3.7);
	 						System.out.println("Insecti Crawler attacked you with its Machina Guass Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*4.2);
	 						System.out.println("Insecti Crawler attacked you with its Alpha-Class Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 	else //HP below 12.5%
	 			 	{
	 			 		if(!emergency)
	 			 		{
	 			 			Story.insectiCrawlerEmergency();
	 			 			damage = (int)(insectiCrawler.damage()*8);
	 						System.out.println("Insecti Crawler attacks you with its Prototype Black Hole Cannon, dealing " + damage + " damage!!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
							emergency = true;
	 			 		}
	 			 		else if(attackChance < 34)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*2);
	 						System.out.println("Insecti Crawler Dash-Slid across the battlefield, ramming you and dealing " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if (attackChance > 34 && attackChance < 68)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*2.65);
	 						System.out.println("Insecti Crawler attacked you with its Laceration Swipe and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if (attackChance > 68 && attackChance < 86)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*3.7);
	 						System.out.println("Insecti Crawler attacked you with its Machina Guass Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else if (attackChance > 86 && attackChance < 95)
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*4.2);
	 						System.out.println("Insecti Crawler attacked you with its Alpha-Class Plasma Cannon and dealt " + damage + " damage!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 		else
	 			 		{
	 			 			damage = (int)(insectiCrawler.damage()*8);
	 						System.out.println("Insecti Crawler attacks you with its Prototype Black Hole Cannon, dealing " + damage + " damage!!");
							Util.lineBreak();
							player.subtractHP(damage);
							if(player.getHP() <= 0)
								win = 3;
	 			 		}
	 			 	}
	 			 }

	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,insectiCrawler);
	 	return win;
	 }
	 public int malusPhaseOneBoss(Player player) //replace placeholder values
	 {
	 	System.out.println("You have entered battle with Malus!");
	 	Player malusOne = new Player(125000,850,20000,75000,0,48,"Malus"); //Placeholder values
	 	boolean half = false;
	 	boolean third = false;
	 	boolean quarter = false;
	 	boolean last = false;
	 	int halfCounter = 0;
	 	int quarterCounter = 0;
	 	int thirdCounter = 0;
	 	int lastCounter = 0;
	 	boolean emergency = false;
	 	boolean battleStart = true;
	 	boolean above50 = true;
	 	boolean above33 = true;
	 	boolean above20 = true;
	 	while (player.getHP() > 0 && malusOne.getHP() > 0 && win != 2)
	 	{
	 		playerAttack(player,malusOne);
	 		player = p;
	 		malusOne = b;
	 		if(malusOne.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Prototype Laser Sword
	 			 *2. 1000% Rifle
	 			 *3. Machina Rocket Launcher
	 			 *4. Machina Laser Cannon
	 			 *5. Alpha-Class Plasma Cannon
	 			 *
	 			 *"Emergency":
	 			 *6. Ultima Guass Cannon
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			/*if HP > 50%, attacks 1 & 2
	 			 *if HP between 50% and 33%, attacks 1 & 2 with occasional attack 3
	 			 *if HP between 33% and 20%, attacks 1,2, & 3 with occasional attack 4
	 			 *if HP between 20% and 10%, attacks 1,2,3, & 4 with occasional attack 5
	 			 *if HP below 10%, attacks 1-5 with occasional emergency
	 			 */
	 			if(malusOne.getHP()>malusOne.getMaxHealth()/2) //Above 50%
	 			{
	 				if(battleStart)
	 				{
	 					System.out.println("Malus: \"You really think you can beat me? Ha! I'll defeat you with my Sword and Rifle alone!\"");
	 					battleStart = false;
	 				}
	 				if(attackChance<60)
	 				{
	 					damage = malusOne.damage();
	 					System.out.println("Malus attacked you with his Prototype Laser Sword and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(malusOne.damage()*1.5);
	 					System.out.println("Malus attacked you with his 1000% Rifle and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 			}
	 			else if(malusOne.getHP()>malusOne.getMaxHealth()/3) //Between 50% and 33%
	 			{
	 				if(above50)
	 				{
	 					System.out.println("Malus: \"Alright... so you're better than I thought. But we'll see how you do against the Machina Rocket Launcher!\"");
	 					damage = malusOne.damage();
	 					System.out.println("Malus attacked you with his Machina Rocket Launcher and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					above50 = false;
	 				}
	 				else if(half)
	 				{
	 					damage = (int)(malusOne.damage()*2);
	 					System.out.println("Malus attacked you with his Machina Rocket Launcher and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					half = false;
	 				}
	 				else if(attackChance<60)
	 				{
	 					damage = malusOne.damage();
	 					System.out.println("Malus attacked you with his Prototype Laser Sword and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(malusOne.damage()*1.5);
	 					System.out.println("Malus attacked you with his 1000% Rifle and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				halfCounter++;
	 				if(halfCounter>=5)
	 				{
	 					halfCounter = 0;
	 					half = true;
	 				}

	 			}
	 			else if(malusOne.getHP()>malusOne.getMaxHealth()/5) //Between 33% and 20%
	 			{
	 				if(above33)
	 				{
	 					System.out.println("Malus: \"...Hmph! Let's see about the Machina Laser Cannon, eh?\"");
	 					damage = (int)(malusOne.damage()*2.6);
	 					System.out.println("Malus attacked you with his Machina Laser Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					above33 = false;
	 				}
	 				else if (third)
	 				{
	 					damage = (int)(malusOne.damage()*2.55);
	 					System.out.println("Malus attacked you with his Machina Laser Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					third = false;
	 				}
	 				else if(attackChance < 45)
	 				{
	 					damage = (int)(malusOne.damage()*1.05);
	 					System.out.println("Malus attacked you with his Prototype Laser Sword and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 45 && attackChance < 85)
	 				{
	 					damage = (int)(malusOne.damage()*1.55);
	 					System.out.println("Malus attacked you with his 1000% Rifle and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(malusOne.damage()*2.05);
	 					System.out.println("Malus attacked you with his Machina Rocket Launcher and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				thirdCounter++;
	 				if(thirdCounter>=6)
	 				{
	 					thirdCounter = 0;
	 					third = true;
	 				}
	 			}
	 			else if(malusOne.getHP()>malusOne.getMaxHealth()/10) //Between 20% and 10%
	 			{
	 				if(above20)
	 				{
	 					System.out.println("Malus: \"Damn! Time to pull out the big guns! You'll never be able to handle this Plasma Cannon!\"");
	 					damage = (int)(malusOne.damage()*3.15);
	 					System.out.println("Malus attacked you with his Alpha-Class Plasma Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					above20 = false;
	 				}
	 				else if(quarter)
	 				{
	 					damage = (int)(malusOne.damage()*3.1);
	 					System.out.println("Malus attacked you with his Alpha-Class Plasma Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					quarter = false;
	 				}
	 				else if(attackChance < 35)
	 				{
	 					damage = (int)(malusOne.damage()*1.1);
	 					System.out.println("Malus attacked you with his Prototype Laser Sword and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 35 && attackChance < 65)
	 				{
	 					damage = (int)(malusOne.damage()*1.6);
	 					System.out.println("Malus attacked you with his 1000% Rifle and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 65 && attackChance < 85)
	 				{
	 					damage = (int)(malusOne.damage()*2.1);
	 					System.out.println("Malus attacked you with his Machina Rocket Launcher and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(malusOne.damage()*2.6);
	 					System.out.println("Malus attacked you with his Machina Laser Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				quarterCounter++;
	 				if(quarterCounter>=5)
	 				{
	 					quarterCounter = 0;
	 					quarter = true;
	 				}
	 			}
	 			else //less than 10%
	 			{
	 				if(!emergency)
	 				{
	 					System.out.println("Malus: \"Can't keep playing around, can I? Ha! You'll regret going against me once I use this Guass Cannon!!\"");
	 					damage = (int)(malusOne.damage()*5.2);
	 					System.out.println("Malus attacked you with the Ultima Guass Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					emergency = true;
	 				}
	 				else if(last)
	 				{
	 					damage = (int)(malusOne.damage()*5);
	 					System.out.println("Malus attacked you with the Ultima Guass Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 					last = false;
	 				}
	 				else if(attackChance < 30)
	 				{
	 					damage = (int)(malusOne.damage()*1.15);
	 					System.out.println("Malus attacked you with his Prototype Laser Sword and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 30 && attackChance < 55)
	 				{
	 					damage = (int)(malusOne.damage()*1.65);
	 					System.out.println("Malus attacked you with his 1000% Rifle and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 55 && attackChance < 75)
	 				{
	 					damage = (int)(malusOne.damage()*2.15);
	 					System.out.println("Malus attacked you with his Machina Rocket Launcher and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(attackChance > 75 && attackChance < 90)
	 				{
	 					damage = (int)(malusOne.damage()*2.65);
	 					System.out.println("Malus attacked you with his Machina Laser Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else
	 				{
	 					damage = (int)(malusOne.damage()*3.15);
	 					System.out.println("Malus attacked you with his Alpha-Class Plasma Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				lastCounter++;
	 				if(lastCounter>=6)
	 				{
	 					lastCounter = 0;
	 					last = true;
	 				}
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,malusOne);
	 	return win;
	 }
	 public int malusPhaseTwoBoss(Player player) //replace placeholder values
	 {
	 	System.out.println("You have entered battle with Ultima Malus!");
	 	Player ultimaMalus = new Player(1000000,1250,50000,150000,0,50,"Ultima Malus"); //Placeholder values
	 	boolean chaosReign = false;
	 	boolean ultimaRailgun = false;
	 	boolean blackHoleCannon = false;
	 	boolean battlestart = true;
	 	int turnCounter = 0;
	 	int chaosCounter = 0;
	 	int ultimaCounter = 0;
	 	int bhcCounter = 0; //Counter for the black hole cannon
	 	boolean emergency33 = false;
	 	boolean emergency10 = false;
	 	while (player.getHP() > 0 && ultimaMalus.getHP() > 0 && win != 2)
	 	{
	 		if(!battlestart)
	 		{
	 			playerAttackMalus(player,ultimaMalus); //player goes after Malus; in other words, Malus goes first!
	 			player = p;
	 			ultimaMalus = b;
	 		}
	 		if(ultimaMalus.getHP() > 0 && win != 2)
	 		{
	 			/*Attacks:
	 			 *1. Fireblast
	 			 *2. Wind Sheer
	 			 *3. Lightning Shock
	 			 *4. Ultima Plasma Cannon
	 			 *5. Ultima Rocket Launcher
	 			 *6. Ultima Guass Cannon
	 			 *
	 			 *"Emergency":
	 			 *7. Chaos's Reign
	 			 *8. Ultima Railgun
	 			 *
	 			 *Super-Attack:
	 			 *9. Ultima Black Hole Cannon
	 			 */
	 			int attackChance = rand.nextInt(99);
	 			/* Attack 9: Every Ten turns (open with it)
	 			 *Attack 8: below 10%, every 8 turns
	 			 *Attack 7: below 33%, every 6 turns
	 			 *if HP < 25%, will occasionally heal himself 1-5%
	 			 *black hole cannon always drains 5% of Malus' current HP, always hurt player 10% of player's max HP
	 			 *Chaos's Reign always heal Malus 2% of his max HP, always hurt player 5% of player's current HP
	 			 *Every five turns, have Malus say something (call a single Story method that loops through several different taunts, depending on Malus' health)
	 			 *
	 			 */
	 			turnCounter++;
	 			if(turnCounter>=5)
	 			{
	 				if(!(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/3 && emergency33 == false) && !(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/10 && emergency10 == false))
	 				{
	 					Story.ultimaMalusBattleQuotes(ultimaMalus.getMaxHealth(),ultimaMalus.getHP());
	 					//Depends on Malus's HP
	 				}
	 				turnCounter = 0;
	 			}
	 			if(battlestart)
	 			{
	 				System.out.println("Malus: \"You thought you could beat me? Ha! Well think again!\"");
	 				Util.skitPause();
					damage = (int)(player.getMaxHealth()/5);
	 				System.out.println("Malus is charging energy... its gathering in one spot and growing darker, and denser. It looks like...");
	 				Util.skitPause();
	 				System.out.println("A Black Hole?!");
	 				Util.skitPause();
	 				System.out.println("Malus fires his Ultima Black Hole Cannon at you, dealing " + damage + " damage!");
	 				Util.skitPause();
	 				System.out.println("Malus: \"You don't even have a hope of winning this time! Ah hahahaha!!\"");
					Util.skitPause();
	 				Util.lineBreak();
					player.subtractHP(damage);
					if(player.getHP() <= 0)
						win = 3;
	 				battlestart = false;
	 			}
	 			else if(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/3 && !emergency33) //first time Malus's HP dips below 33%
	 			{
	 				damage = (int)(player.getHP()/20);
	 				System.out.println("Malus: \"Hm, you certainly are worthy of my respect... respect enough to witness Chaos's Reign! Ah haha!\"");
	 				System.out.println("Malus starts drawing in boundless amounts of Chaos Energy... and then unleashes it!");
	 				System.out.println("Using Chaos's Reign, Malus healed himself " + (int)(ultimaMalus.getHP()/50) + " and dealt " + damage + " damage to you!!");
	 				ultimaMalus.addHP(ultimaMalus.getHP()/50);
					Util.lineBreak();
					player.subtractHP(damage);
					if(player.getHP() <= 0)
						win = 3;
	 				emergency33 = true;
	 			}
	 			else if(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/10 && !emergency10) //first time Malus's HP dips below 10%
	 			{
	 				damage = (int)(ultimaMalus.damage()*10); //change the modifier?
	 				System.out.println("Malus: \"Hot damn! You just might win this... if I don't step it up a notch, that is!\"");
	 				System.out.println("<The Ultima Railgun has finished charging!>");
	 				System.out.println("Malus: \"Now that the Ultima Railgun has finished its preliminary charge, it will charge MUCH faster from now on!\"");
	 				System.out.println("Malus: \"Now... die!!\"");
	 				System.out.println("Malus uses the Ultima Railgun on you, dealing " + damage + " damage!");
	 				System.out.println("The Ultima Railgun begins charging.");
					Util.lineBreak();
					player.subtractHP(damage);
					if(player.getHP() <= 0)
						win = 3;
	 				emergency10 = true;
	 			}
	 			else if(!chaosReign && !ultimaRailgun && !blackHoleCannon) //non-special attacks
	 			{
	 				if((ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance < 18) || (attackChance < 20)) //Fireblast (20%)
	 				{
	 					damage = (int)(ultimaMalus.damage()*3);
	 					System.out.println("Malus attacked you with Fireblast and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if((ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance > 18 && attackChance < 37) || (attackChance > 20 && attackChance < 40)) //Wind Sheer (20%)
	 				{
	 					damage = (int)(ultimaMalus.damage()*2);
	 					System.out.println("Malus attacked you with Wind Sheer and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if((ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance > 37 && attackChance < 46) || (attackChance > 40 && attackChance < 50)) //Lightning Shock (10%)
	 				{
	 					damage = (int)(ultimaMalus.damage()*4.5);
	 					System.out.println("Malus attacked you with Lightning Shock and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if((ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance > 46 && attackChance < 64) || (attackChance > 50 && attackChance < 70)) //Ultima Plasma Cannon (20%)
	 				{
	 					damage = (int)(ultimaMalus.damage()*3.45);
	 					System.out.println("Malus attacked you with his Ultima Plasma Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if((ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance > 64 && attackChance < 83) || (attackChance > 70&& attackChance < 90)) //Ultima Rocket Launcher (20%)
	 				{
	 					damage = (int)(ultimaMalus.damage()*1.95);
	 					System.out.println("Malus attacked you with his Ultima Rocket Launcher and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if((ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance > 83 && attackChance < 92) || (attackChance > 90)) //Ultima Guass Cannon (10%)
	 				{
	 					damage = (int)(ultimaMalus.damage()*5.6);
	 					System.out.println("Malus attacked you with his Ultima Guass Cannon and dealt " + damage + " damage!");
						Util.lineBreak();
						player.subtractHP(damage);
						if(player.getHP() <= 0)
							win = 3;
	 				}
	 				else if(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/4 && attackChance > 92 ) //Heal (8%)
	 				{
	 					double healNum = rand.nextInt(5)/100;
	 					double healAmount = ultimaMalus.getMaxHealth()*healNum;
	 					System.out.println("Malus heals himself for " + (int)healAmount + "HP!");
	 					ultimaMalus.addHP(healAmount);
	 					Util.lineBreak();
	 				}
	 			}
	 			else if(chaosReign && !ultimaRailgun && !blackHoleCannon) //Chaos's Reign attack (ultima railgun and black hole cannon trump Chaos's Reign; Chaos's Reign will be used the following turn)
	 			{
					damage = (int)(player.getHP()/20);
	 				System.out.println("Malus is drawing in boundless amounts of Chaos Energy... and then unleashes it!");
	 				System.out.println("Using Chaos's Reign, Malus healed himself " + (int)(ultimaMalus.getHP()/50) + " and dealt " + damage + " damage to you!!");
	 				ultimaMalus.addHP(ultimaMalus.getHP()/50);
					Util.lineBreak();
					player.subtractHP(damage);
					if(player.getHP() <= 0)
						win = 3;
	 				chaosReign = false;
	 			}
	 			else if(ultimaRailgun && !blackHoleCannon) //Ultima Railgun (black hole cannon trumps Ultima Railgun; ultima railgun will the used the following turn)
	 			{
					damage = (int)(ultimaMalus.damage()*10); //change the modifier?
	 				System.out.println("The Ultima Railgun has finished charging!");
	 				System.out.println("Malus immeidately uses it on you, dealing " + damage + " damage!");
	 				System.out.println("The Ultima Railgun begins charging once again.");
					Util.lineBreak();
					player.subtractHP(damage);
					if(player.getHP() <= 0)
						win = 3;
	 				ultimaRailgun = false;
	 			}
	 			else if(blackHoleCannon) //Black Hole Cannon
	 			{
					damage = (int)(player.getMaxHealth()/10);
	 				System.out.println("Malus is charging energy... its gathering in one spot and growing darker, and denser.");
	 				System.out.println("Malus fires his Ultima Black Hole Cannon at you, dealing " + damage + " damage!");
	 				System.out.println("However the cannon also injures Malus, dealing " + (int)(ultimaMalus.getHP()/20) + " damage to him.");
	 				ultimaMalus.subtractHP(ultimaMalus.getHP()/20);
					Util.lineBreak();
					player.subtractHP(damage);
					if(player.getHP() <= 0)
						win = 3;
	 				blackHoleCannon = false;
	 			}
	 			if(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/3) //if Malus's HP is less than 33%, the chaosCounter goes up
	 			{
	 				chaosCounter++;
	 				if(chaosCounter>=6) //every six turns, Malus uses the Chaos's Reign
	 				{
	 					chaosCounter = 0;
	 					chaosReign = true;
	 				}
	 			}
	 			if(ultimaMalus.getHP()<ultimaMalus.getMaxHealth()/10) //if Malus's HP is less than 10%, the ultimaCounter goes up
	 			{
	 				ultimaCounter++;
	 				if(ultimaCounter>=8) //every eight turns, Malus uses the Ultima Railgun
	 				{
	 					ultimaCounter = 0;
	 					ultimaRailgun = true;
	 				}
	 			}
	 			bhcCounter++;
	 			if(bhcCounter>=10) //every ten turns, Malus uses the Black Hole Cannon
	 			{
	 				bhcCounter = 0;
	 				blackHoleCannon = true;
	 			}
	 			if(player.getHP()<=0)
	 			{
	 				win = 3;
	 			}
	 		}
	 	}
	 	winResult(win,player,ultimaMalus);
	 	return win;
	 }
}