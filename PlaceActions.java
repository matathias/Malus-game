import java.util.*;
import java.text.DecimalFormat;

public class PlaceActions //change all Util.numberselect to proper parameters
{
	private Random rand;
	private Player player;
	private MarketDefense markDef;
	private MarketHealing markHeal;
	private MarketSpeAttack markSA;
	private MarketWeapon markWeap;
	private ArrayList <Player> enemies;
	private ArrayList <Integer> enemyChances;
	private String path;
	private Battle battleMook;
	private BossBattles bosses;
	private int win,random,randomEnChan,travelResult, bossResult;
	private boolean justBattled, desert, plains, forest, mountains, volcano, caverns, baseFac, baseUrb, baseLab, baseMil, baseFin;

	public PlaceActions(Player p)
	{
		rand = new Random();
		player = p;
		markDef = new MarketDefense(player);
		markHeal = new MarketHealing(player);
		markSA = new MarketSpeAttack(player);
		markWeap = new MarketWeapon(player);
		desert = false;
		plains = false;
		forest = false;
		mountains = false;
		volcano = false;
		caverns = false;
		baseFac = false;
		baseUrb = false;
		baseLab = false;
		baseMil = false;
		baseFin = false;
		bosses = new BossBattles();
		town();
	}
	public PlaceActions(Player p, ArrayList data)
	{
		rand = new Random();
		player = p;
		desert = (Boolean)data.get(0);
		plains = (Boolean)data.get(1);
		forest = (Boolean)data.get(2);
		mountains = (Boolean)data.get(3);
		volcano = (Boolean)data.get(4);
		caverns = (Boolean)data.get(5);
		baseFac = (Boolean)data.get(6);
		baseUrb = (Boolean)data.get(7);
		baseLab = (Boolean)data.get(8);
		baseMil = (Boolean)data.get(9);
		baseFin = (Boolean)data.get(10);
		markDef = new MarketDefense((ArrayList<ArrayList>)data.get(11));
		markHeal = new MarketHealing((ArrayList<ArrayList>)data.get(12));
		markSA = new MarketSpeAttack((ArrayList<ArrayList>)data.get(13));
		markWeap = new MarketWeapon((ArrayList<Weapon>)data.get(14));
		bosses = new BossBattles();
		town();
	}
	private int placeTravel()//prevents compile error messages
	{return 0;}
	private int placeTravel(int len, int chan, Player en1, int chanEn1, Player en2, int chanEn2, Player en3, int chanEn3, Player en4, int chanEn4)
	{
		int counter = 0;
		enemies = new ArrayList<Player>();
		enemyChances = new ArrayList<Integer>();
		path = "";
		win = 0;
		justBattled = false;
		enemies.add(en1);
		enemies.add(en2);
		enemies.add(en3);
		enemies.add(en4);
		enemyChances.add(chanEn1);
		enemyChances.add(chanEn2);
		enemyChances.add(chanEn3);
		enemyChances.add(chanEn4);
		do
		{
			if(!justBattled)
			{
				System.out.print("-");
				path += "-";
			}
			else
			{
				System.out.println(path +  "X");
				path += "X";
			}
			random = rand.nextInt(99);
			if(random <= chan)
			{
				randomEnChan = rand.nextInt(99);
				if(randomEnChan <= enemyChances.get(0))
				{
					System.out.println("\nYou've encountered a " + enemies.get(0).getPlayerName() + "!");
					battleMook = new Battle(player, enemies.get(0));
					win = battleMook.mookBattle();
				}
				else if(randomEnChan > enemyChances.get(0) && randomEnChan <= (enemyChances.get(0) + enemyChances.get(1)))
				{
					System.out.println("\nYou've encountered a " + enemies.get(1).getPlayerName() + "!");
					battleMook = new Battle(player, enemies.get(1));
					win = battleMook.mookBattle();
				}
				else if(randomEnChan > (enemyChances.get(0) + enemyChances.get(1)) && randomEnChan <= (enemyChances.get(0) + enemyChances.get(1) + enemyChances.get(2)))
				{
					System.out.println("\nYou've encountered a " + enemies.get(2).getPlayerName() + "!");
					battleMook = new Battle(player, enemies.get(2));
					win = battleMook.mookBattle();
				}
				else if(randomEnChan > (enemyChances.get(0) + enemyChances.get(1) + enemyChances.get(2)) && randomEnChan <= (enemyChances.get(0) + enemyChances.get(1) + enemyChances.get(2) + enemyChances.get(3)))
				{
					System.out.println("\nYou've encountered a " + enemies.get(3).getPlayerName() + "!");
					battleMook = new Battle(player, enemies.get(3));
					win = battleMook.mookBattle();
				}
				justBattled = true;
			}
			else
			{
				justBattled = false;
			}
			counter++;
		}
		while (win != 3 && counter<=len);
		return win;
	}
	private void town()
	{
		Story.town();
		int choice = Util.numberSelect("Where will you go:\n1. Inn\n2. Weapon Market\n3. Defense Market\n4. Healing Market\n5. Special Attack Market\n6. Desert",6);
		int cost = 0;
		switch(choice)
		{
			case 1: //inn; cost goes up with every level up
				if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
				{
					cost = (int)((10*Math.pow(2,player.getLvl()/4)+5)*.9);
				}
				else
				{
					cost = (int)((10*Math.pow(2,player.getLvl()/4)+5));
				}
				System.out.println("The Inn will replenish all your HP and EP but costs money.");
				System.out.println("Current cost: " + cost + "\t\tYour Money: " + player.getMoney());
				if(player.getMoney() >= cost)
				{
					System.out.println("Do you wish to stay at the Inn?");
					String yesNo = Util.yesNoLoop();
					if(yesNo.equalsIgnoreCase("Yes"))
					{
						System.out.println("You have spent the night at the Inn.");
						player.setHP(player.getMaxHealth());
						player.setEP(player.getMaxEP());
						player.subtractMoney(cost);
						Util.pause();
					}
					else
					{
						System.out.println("You have chosen not to stay at the Inn.");
						Util.pause();
					}
				}
				else
				{
					System.out.println("You can't afford to stay at the Inn!");
					Util.pause();
				}
				Util.lineBreak();
				town();
				break;
			case 2:
				player = markWeap.weaponMarket(player);
				town();
				break;
			case 3:
				player = markDef.defenseMarket(player);
				town();
				break;
			case 4:
				player = markHeal.healingMarket(player);
				town();
				break;
			case 5:
				player = markSA.speAttMarket(player);
				town();
				break;
			case 6:
				desert();
				break;
			default:
				town();
				break;
		}
	}
	private void desert()
	{
		Story.desert(desert);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to Town",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.desertPathOne();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						desert();
				}
				break;
			case 2: //boss route
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					if(!desert)
					{
						Story.desertBoss();
						bossResult = bosses.sandStoneBoss(player);
						if(bossResult == 1)
						{
							Story.desertBossBeaten();
							desert = true;
							plains();
						}
						else if(bossResult == 2)
						{
							Story.desertBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								town();
							else
								desert();
						}
						else
						{
							Story.desertBossLose();
							town();
						}
					}
					else
					{
						System.out.println("You've made it to the plains.");
						plains();
					}
				}
				break;
			case 3:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.desertPathThree();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						desert();
				}
				break;
			case 4:
				town();
				break;
			default:
				desert();
				break;
		}
	}
	private void plains()
	{
		Story.plains(plains);
		int choice = Util.numberSelect("Where will you go:\n1. Plains Path\n2. Grasslands Path\n3. Hills Path\n4. Back to the Desert",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.plainsPlainsPath();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						plains();
				}
				break;
			case 2:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.plainsGrasslandsPath();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						plains();
				}
				break;
			case 3: //Hill path, boss
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					if(!plains)
					{
						Story.plainsBoss();
						bossResult = bosses.grassStoneBoss(player);
						if(bossResult == 1)
						{
							Story.plainsBossBeaten();
							plains = true;
							forest();
						}
						else if(bossResult == 2)
						{
							Story.plainsBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								town();
							else
								plains();
						}
						else
						{
							Story.plainsBossLose();
							town();
						}
					}
					else
					{
						System.out.println("You've made it to the forest.");
						forest();
					}
				}
				break;
			case 4:
				desert();
				break;
			default:
				plains();
				break;
		}
	}
	private void forest()
	{
		Story.forest(forest);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the plains",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.forestPathOne();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						forest();
				}
				break;
			case 2:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.forestPathTwo();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						forest();
				}
				break;
			case 3: //boss route
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					if(!forest)
					{
						Story.forestBoss();
						bossResult = bosses.leafStoneBoss(player);
						if(bossResult == 1)
						{
							Story.forestBossBeaten();
							forest = true;
							mountains();
						}
						else if(bossResult == 2)
						{
							Story.forestBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								town();
							else
								forest();
						}
						else
						{
							Story.forestBossLose();
							town();
						}
					}
					else
					{
						System.out.println("You've made it to the mountains.");
						mountains();
					}
				}
			case 4:
				plains();
				break;
			default:
				forest();
				break;
		}
	}
	private void mountains()
	{
		Story.mountains(mountains);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the forest",4);
		switch(choice)
		{
			case 1: //boss route
			travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					if(!mountains)
					{
						Story.mountainsBoss();
						bossResult = bosses.blizzardStoneBoss(player);
						if(bossResult == 1)
						{
							Story.mountainsBossBeaten();
							mountains = true;
							village();
						}
						else if(bossResult == 2)
						{
							Story.mountainsBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								town();
							else
								mountains();
						}
						else
						{
							Story.mountainsBossLose();
							town();
						}
					}
					else
					{
						System.out.println("You've made it to the village.");
						village();
					}
				}
			case 2:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.mountainsPathTwo();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						mountains();
				}
				break;
			case 3:
				travelResult = placeTravel();
				if(travelResult == 3)
					town();
				else
				{
					Story.mountainsPathThree();
					travelResult = placeTravel();
					if(travelResult == 3)
						town();
					else
						mountains();
				}
				break;
			case 4:
				forest();
				break;
			default:
				mountains();
				break;
		}
	}
	private void village()
	{
		Story.village();
		int choice = Util.numberSelect("Where will you go:\n1. Inn\n2. Weapon Market\n3. Defense Market\n4. Volcano\n5. Back to the mountains",5);
		int cost = 0;
		switch(choice)
		{
			case 1: //inn; cost goes up with every level up; is more expensive than the town inn
				if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
				{
					cost = (int)((11*Math.pow(2,player.getLvl()/4)+5)*.9);
				}
				else
				{
					cost = (int)((11*Math.pow(2,player.getLvl()/4)+5));
				}
				System.out.println("The Inn will replenish all your HP and EP but costs money.");
				System.out.println("Current cost: " + cost + "\t\tYour Money: " + player.getMoney());
				if(player.getMoney() >= cost)
				{
					System.out.println("Do you wish to stay at the Inn?");
					String yesNo = Util.yesNoLoop();
					if(yesNo.equalsIgnoreCase("Yes"))
					{
						System.out.println("You have spent the night at the Inn.");
						player.setHP(player.getMaxHealth());
						player.setEP(player.getMaxEP());
						player.subtractMoney(cost);
						Util.pause();
					}
					else
					{
						System.out.println("You have chosen not to stay at the Inn.");
						Util.pause();
					}
				}
				else
				{
					System.out.println("You can't afford to stay at the Inn!");
					Util.pause();
				}
				Util.lineBreak();
				village();
				break;
			case 2:
				player = markWeap.weaponMarket(player);
				village();
				break;
			case 3:
				player = markDef.defenseMarket(player);
				village();
				break;
			case 4:
				volcano();
				break;
			case 5:
				mountains();
				break;
			default:
				village();
				break;
		}
	}
	private void volcano()
	{
		Story.volcano(volcano);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the village",4);
		switch(choice)
		{
			case 1: //boss route
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!volcano)
					{
						Story.volcanoBoss();
						bossResult = bosses.wyvernBoss(player);
						if(bossResult == 1)
						{
							Story.volcanoBossBeaten();
							volcano = true;
							caverns();
						}
						else if(bossResult == 2)
						{
							Story.volcanoBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								volcano();
						}
						else
						{
							Story.volcanoBossLose();
							village();
						}
					}
					else
					{
						System.out.println("You've made it to the caverns.");
						caverns();
					}
				}
				break;
			case 2:
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					Story.volcanoPathTwo();
					travelResult = placeTravel();
					if(travelResult == 3)
						village();
					else
						volcano();
				}
				break;
			case 3:
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					Story.volcanoPathThree();
					travelResult = placeTravel();
					if(travelResult == 3)
						village();
					else
						volcano();
				}
				break;
			case 4:
				village();
				break;
			default:
				volcano();
				break;
		}
	}
	private void caverns()
	{
		Story.caverns(caverns);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the Volcano",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					Story.cavernsPathOne();
					travelResult = placeTravel();
					if(travelResult == 3)
						village();
					else
						caverns();
				}
				break;
			case 2: //boss route
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!caverns)
					{
						Story.cavernsBoss();
						bossResult = bosses.cerberusBoss(player);
						if(bossResult == 1)
						{
							Story.cavernsBossBeaten();
							caverns = true;
							base();
						}
						else if(bossResult == 2)
						{
							Story.cavernsBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								caverns();
						}
						else
						{
							Story.cavernsBossLose();
							village();
						}
					}
					else
					{
						System.out.println("You've made it to Malus' Base.");
						base();
					}
				}
				break;
			case 3:
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					Story.cavernsPathThree();
					travelResult = placeTravel();
					if(travelResult == 3)
						village();
					else
						caverns();
				}
				break;
			case 4:
				volcano();
				break;
			default:
				caverns();
				break;
		}
	}
	private void base()
	{
		Story.base(baseFac,baseUrb,baseLab,baseMil,baseFin);
		int choice;
		if(baseFac && baseUrb && baseLab && baseMil)
		{
			choice = Util.numberSelect("Where will you go:\n1. Back to the Caverns\n2. Factory Path\n3. Urban Path\n4. Laboratory Path\n5. Military Path\n6. Defeat Malus!\n\tNote: Once you leave to defeat Malus there will be no return, except through victory... or death.\n\tIn other words, if you lose against Malus, then you lose the game!",6);
		}
		else
			choice = Util.numberSelect("Where will you go:\n1. Back to the Caverns\n2. Factory Path\n3. Urban Path\n4. Laboratory Path\n5. Military Path",5);
		switch(choice)
		{
			case 1:
				caverns();
				break;
			case 2: //Factory path
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!baseFac)
					{
						Story.baseFactoryBoss();
						bossResult = bosses.bugCrawlerBoss(player);
						if(bossResult == 1)
						{
							Story.baseFactoryBossBeaten();
							baseFac = true;
							base();
						}
						else if(bossResult == 2)
						{
							Story.baseFactoryBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								base();
						}
						else
						{
							Story.baseFactoryBossLose();
							village();
						}
					}
					else
					{
						Story.baseFactoryBossBeat();
						travelResult = placeTravel();
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 3: //Urban path
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!baseUrb)
					{
						Story.baseUrbanBoss();
						bossResult = bosses.civilMechBoss(player);
						if(bossResult == 1)
						{
							Story.baseUrbanBossBeaten();
							baseUrb = true;
							base();
						}
						else if(bossResult == 2)
						{
							Story.baseUrbanBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								base();
						}
						else
						{
							Story.baseUrbanBossLose();
							village();
						}
					}
					else
					{
						Story.baseUrbanBossBeat();
						travelResult = placeTravel();
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 4: //lab path
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!baseLab)
					{
						Story.baseLabBoss();
						bossResult = bosses.mantisCrawlerBoss(player);
						if(bossResult == 1)
						{
							Story.baseLabBossBeaten();
							baseLab = true;
							base();
						}
						else if(bossResult == 2)
						{
							Story.baseLabBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								base();
						}
						else
						{
							Story.baseLabBossLose();
							village();
						}
					}
					else
					{
						Story.baseLabBossBeat();
						travelResult = placeTravel();
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 5: //military path
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!baseMil)
					{
						Story.baseMilitaryBoss();
						bossResult = bosses.insectiCrawlerBoss(player);
						if(bossResult == 1)
						{
							Story.baseMilitaryBossBeaten();
							baseMil = true;
							base();
						}
						else if(bossResult == 2)
						{
							Story.baseMilitaryBossFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								base();
						}
						else
						{
							Story.baseMilitaryBossLose();
							village();
						}
					}
					else
					{
						Story.baseMilitaryBossBeat();
						travelResult = placeTravel();
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 6: //Malus boss (tell player that there is no going back once they start fighting malus - they either beat him, or lose)
				travelResult = placeTravel();
				if(travelResult == 3)
					village();
				else
				{
					if(!baseFin)
					{
						Story.malusBoss();
						bossResult = bosses.malusPhaseOneBoss(player);
						if(bossResult == 1)
						{
							Story.malusPhaseTwo();
							player.setHP(player.getMaxHealth());
							player.setEP(player.getMaxEP());
							bossResult = bosses.malusPhaseTwoBoss(player);
							if(bossResult == 1)
							{
								Story.malusBeaten(player.getPlayerName());
								Story.gameWon(player);
								baseFin = true;
								base();
							}
							else
							{
								Story.malusPhaseTwoLose();
							}
						}
						else if(bossResult == 2)
						{
							Story.malusFlee();
							travelResult = placeTravel();
							if(travelResult == 3)
								village();
							else
								base();
						}
						else
						{
							Story.malusLose();
							village();
						}
					}
					else
					{
						Story.gameBeat();
						base();
					}
				}
				break;
			default:
				base();
		}
	}
	public ArrayList getAll()
	{
		ArrayList data = new ArrayList();
		data.add(new Boolean(desert));
		data.add(new Boolean(plains));
		data.add(new Boolean(forest));
		data.add(new Boolean(mountains));
		data.add(new Boolean(volcano));
		data.add(new Boolean(caverns));
		data.add(new Boolean(baseFac));
		data.add(new Boolean(baseUrb));
		data.add(new Boolean(baseLab));
		data.add(new Boolean(baseMil));
		data.add(new Boolean(baseFin));
		data.add(new ArrayList<ArrayList>(markDef.getAll()));
		data.add(new ArrayList<ArrayList>(markHeal.getAll()));
		data.add(new ArrayList<ArrayList>(markSA.getAll()));
		data.add(new ArrayList<Weapon>(markWeap.getAll()));
		return data;
	}
	 /*Places (in order):
	  *1 - Town
	  *2 - Desert
	  *3 - Plains/Grassland/Hills
	  *4 - Forest
	  *5 - Mountains/Ice
	  *5.5 - Village (rest area)
	  *6 - Volcano
	  *7 - Caverns
	  *8 - Base
	  */

	 /*-Uses random encounters
	  *-When going from place to place, have ticker (-, then --, then ---, etc), each tick represents a chance to enter a battle
	  *-In each environment have 2 - 5 paths, boss be at end of one path, other paths be dead-ends or weapons
	  */

	 /*Town
	  *	-Weapon Market
	  *	-Defense Market (only adds HP; no actual Defense value)
	  *	-Healing Market
	  *	-Speical Attack Market
	  *	-Inn
	  *	-Goes to Desert
	  *
	  *Desert
	  *	-Back to Town
	  *	-Sand Drone
	  *	-Manipulated Cactus
	  *	-Sand Demon
	  *	-Boss: Sand Stone
	  *	-Goes to Plains (after defeating boss)
	  *
	  *Plains/Grassland/Hills
	  *	-Back to Desert
	  *	-Plains Path:
	  *		-Dry Spell
	  *		-Grass Drone
	  * -Grassland Path:
	  *		-Dry Spell
	  *		-Grass Drone
	  *		-Manipulated Dandelion
	  *	-Hills Path:
	  *		-Grass Drone
	  *		-Manipulated Dandelion
	  *		-Delta-Class Ground: Beetle
	  *	-Boss (Hills Path): Grass Stone
	  *	-Goes to Forest
	  *
	  *Forest
	  *	-Back to Plains/Grassland/Hills
	  *	-Manipulated Tree
	  *	-Nature Drone
	  *	-Delta-Class Aerial: Bee
	  *	-Boss: Leaf Stone
	  *	-Goes to Mountains/Ice
	  *
	  *Mountains/Ice
	  *	-Back to Forest
	  *	-The higher up the mountain (the farther along) the player goes, the more likely ice enemeis appear instead of rock enemies
	  *	-Sentrock Drone
	  *	-Manipulated Yeti
	  *	-Avalanche Catalyst
	  *	-Sentrice Drone
	  *	-Boss: Blizzard Stone
	  *	-Goes to Village
	  *
	  *Village
	  *	-Back to Mountains/Ice
	  *	-Inn
	  *	-Weapon Market
	  *	-Defense Market
	  *	-Goes to Volcano
	  *
	  *Volcano
	  *	-Back to Village
	  *	-Magma Drone
	  *	-Gamma-Class Ground: Cockroach
	  *	-Unstoppable Magma
	  *	-Boss: Boss-Class Aerial: Wyvern
	  *	-Goes to Cavern
	  *
	  *Cavern
	  * -Back to Volcano
	  *	-Gamma-Class Aerial: Mosquito
	  *	-Autoturret
	  *	-Immovable Rock
	  *	-Boss: Boss-Class Ground: Cerberus
	  *	-Goes to Base
	  *
	  *Base
	  *	-Back to Cavern
	  *	-Factory Path
	  *		-Prototype Autoturret
	  *		-Magnatus Drone
	  *		-Beta-Class Ground: Black Widow
	  *		-Boss: Incomplete Bug Crawler
	  *	-Urban Path
	  *		-Civil Autoturret
	  *		-Magnatus Drone
	  *		-Beta-Class Aerial: Wasp
	  *		-Boss: Civil Control Mech
	  *	-Labratory Path
	  *		-Defense Autoturret
	  *		-Manipulated Antimatter
	  *		-Mutant Something
	  *		-Boss: Prototype Mantis Crawler
	  *	-Military Base Path
	  *		-Magnatus Drone
	  *		-Defense Autoturret
	  *		-Alpha-Class Aerial: Hornet
	  *		-Alpha-Class Ground: Tarantula
	  *		-Boss: Insecti Crawler
	  *	-Boss(Final): Malus
	  */
}