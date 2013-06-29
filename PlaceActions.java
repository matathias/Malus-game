import java.util.*;

public class PlaceActions //change all Util.numberselect to proper parameters
{
	private Random rand;
	private Player player;
	private MarketDefense markDef;
	private MarketHealing markHeal;
	private MarketSpeAttack markSA;
	private MarketWeapon markWeap;
	private String path;
	private Battle battleMook;
	private BossBattles bosses;
	private int win,random,randomEnChan,travelResult, bossResult;
	private boolean justBattled, desert, plains, forest, mountains, volcano, caverns, baseFac, baseUrb, baseLab, baseMil, baseFin;
	private ArrayList<Player> desertEnemies, plainEnemies, forestEnemies, mountainEnemies, volcanoEnemies, cavernEnemies, baseEnemies;

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
		setUpEnemies();
		town();
	}
	public PlaceActions(ArrayList<String> pData, ArrayList<String> pAData)
	{
		//Meant to be used with setAll() when loading from save.
		rand = new Random();
		player = new Player(pData);
		
		setAll(pAData);

		bosses = new BossBattles();
		setUpEnemies();
		town();
	}
	private void setUpEnemies()
	{
		desertEnemies = new ArrayList<Player>();
		plainEnemies = new ArrayList<Player>();
		forestEnemies = new ArrayList<Player>();
		mountainEnemies = new ArrayList<Player>();
		volcanoEnemies = new ArrayList<Player>();
		cavernEnemies = new ArrayList<Player>();
		baseEnemies = new ArrayList<Player>();
		
		/*
		 * Desert Enemies
		 */
		desertEnemies.add(new Player(10,10,10,10,10,10,"Sand Drone"));
		desertEnemies.add(new Player(10,10,10,10,10,10,"Manipulated Cactus"));
		desertEnemies.add(new Player(10,10,10,10,10,10,"Sand Demon"));
		
		/*
		 * Plains Enemies
		 */
		plainEnemies.add(new Player(10,10,10,10,10,10,"Dry Spell"));
		plainEnemies.add(new Player(10,10,10,10,10,10,"Grass Drone"));
		plainEnemies.add(new Player(10,10,10,10,10,10,"Manipulated Dandelion"));
		plainEnemies.add(new Player(10,10,10,10,10,10,"Delta-Class Ground: Beetle"));
		
		/*
		 * Forest Enemies
		 */
		forestEnemies.add(new Player(10,10,10,10,10,10,"Manipulated Tree"));
		forestEnemies.add(new Player(10,10,10,10,10,10,"Nature Drone"));
		forestEnemies.add(new Player(10,10,10,10,10,10,"Delta-Class Aerial: Bee"));
		
		/*
		 * Mountain Enemies
		 */
		mountainEnemies.add(new Player(10,10,10,10,10,10,"Sentrock Drone"));
		mountainEnemies.add(new Player(10,10,10,10,10,10,"Manipulated Yeti"));
		mountainEnemies.add(new Player(10,10,10,10,10,10,"Avalanche Catalyst"));
		mountainEnemies.add(new Player(10,10,10,10,10,10,"Sentrice Drone"));
		
		/*
		 * Volcano Enemies
		 */
		volcanoEnemies.add(new Player(10,10,10,10,10,10,"Magma Drone"));
		volcanoEnemies.add(new Player(10,10,10,10,10,10,"Gamma-Class Ground: Cockroach"));
		volcanoEnemies.add(new Player(10,10,10,10,10,10,"Unstoppable Magma"));
		
		/*
		 * Cavern Enemies
		 */
		cavernEnemies.add(new Player(10,10,10,10,10,10,"Gamma-Class Aerial: Mosquito"));
		cavernEnemies.add(new Player(10,10,10,10,10,10,"Autoturret"));
		cavernEnemies.add(new Player(10,10,10,10,10,10,"Immovable Rock"));
		
		/*
		 * Base Enemies
		 */
		baseEnemies.add(new Player(10,10,10,10,10,10,"Prototype Autoturret"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Magnatus Drone"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Beta-Class Ground: Black Widow"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Civil Autoturret"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Beta-Class Aerial: Wasp"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Defense Autoturret"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Manipulated Antimatter"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Mutant Something"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Alpha-Class Ground: Tarantula"));
		baseEnemies.add(new Player(10,10,10,10,10,10,"Alpha-Class Aerial: Hornet"));
	}
	//private int placeTravel()//prevents compile error messages
	//{return 0;}
	private int placeTravel(int len, int chan, Player en1, int chanEn1, Player en2, int chanEn2, Player en3, int chanEn3, Player en4, int chanEn4)
	{
		int counter = 0;
		path = "";
		win = 0;
		justBattled = false;
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
				if(randomEnChan <= chanEn1)
				{
					System.out.println("\nYou've encountered a " + en1.getPlayerName() + "!");
					battleMook = new Battle(player, en1);
					win = battleMook.mookBattle();
				}
				else if(randomEnChan > chanEn1 && randomEnChan <= (chanEn1 + chanEn2))
				{
					System.out.println("\nYou've encountered a " + en2.getPlayerName() + "!");
					battleMook = new Battle(player, en2);
					win = battleMook.mookBattle();
				}
				else if(randomEnChan > (chanEn1 + chanEn2) && randomEnChan <= (chanEn1 + chanEn2 + chanEn3))
				{
					System.out.println("\nYou've encountered a " + en3.getPlayerName() + "!");
					battleMook = new Battle(player, en3);
					win = battleMook.mookBattle();
				}
				else if(randomEnChan > (chanEn1 + chanEn2 + chanEn3) && randomEnChan <= (chanEn1 + chanEn2 + chanEn3 + chanEn4))
				{
					System.out.println("\nYou've encountered a " + en4.getPlayerName() + "!");
					battleMook = new Battle(player, en4);
					win = battleMook.mookBattle();
				}
				else
				{
					System.out.println("Hey! Dumbass programmer! Something went wrong with the placeTravel method!");
					System.out.println("randomEnChan: " + randomEnChan);
					System.out.println("Other chances: " + chanEn1 + "\t" + chanEn2 + "\t" + chanEn3 + "\t" + chanEn4);
					Util.pause();
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
		int choice = Util.numberSelect("Where will you go:\n1. Inn\n2. Weapon Market\n3. Defense Market\n4. Healing Market\n5. Special Attack Market\n6. Save\n7. Desert",6);
		int cost = 0;
		switch(choice)
		{
			case 1: //inn; cost goes up with every level up
				if(player.getPlayerClass().equalsIgnoreCase("Entrepreneur"))
				{
					cost = (int)((10*Math.pow(2,player.getLvl()/6)+5)*.9);
				}
				else
				{
					cost = (int)((10*Math.pow(2,player.getLvl()/6)+5));
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
				System.out.println("Do you wish to save your game?");
				String ans = Util.yesNoLoop();
				if(ans.equalsIgnoreCase("Yes"))
				{
					Util.gameSave(player.getAll(), getAll(), Story.getAll());
				}
				town();
				break;
			case 7:
				desert();
				break;
			default:
				town();
				break;
		}
	}
	private void desert()    //placeTravel method arguments: modified
	{
		Story.desert(desert);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to Town",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel(10,30,desertEnemies.get(0),75,desertEnemies.get(1),25,desertEnemies.get(2),0,desertEnemies.get(2),0);
				if(travelResult == 3)
					town();
				else
				{
					Story.desertPathOne();
					travelResult = placeTravel(10,30,desertEnemies.get(0),75,desertEnemies.get(1),25,desertEnemies.get(2),0,desertEnemies.get(2),0);
					if(travelResult == 3)
						town();
					else
						desert();
				}
				break;
			case 2: //boss route
				travelResult = placeTravel(20,40,desertEnemies.get(0),40,desertEnemies.get(1),35,desertEnemies.get(2),25,desertEnemies.get(2),0);
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
							travelResult = placeTravel(20,40,desertEnemies.get(0),40,desertEnemies.get(1),35,desertEnemies.get(2),25,desertEnemies.get(2),0);
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
				travelResult = placeTravel(15,35,desertEnemies.get(0),50,desertEnemies.get(1),35,desertEnemies.get(2),15,desertEnemies.get(2),0);
				if(travelResult == 3)
					town();
				else
				{
					Story.desertPathThree();
					travelResult = placeTravel(15,35,desertEnemies.get(0),50,desertEnemies.get(1),35,desertEnemies.get(2),15,desertEnemies.get(2),0);
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
	private void plains()    //placeTravel method arguments: default
	{
		Story.plains(plains);
		int choice = Util.numberSelect("Where will you go:\n1. Plains Path\n2. Grasslands Path\n3. Hills Path\n4. Back to the Desert",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel(10,10,plainEnemies.get(0),33,plainEnemies.get(1),33,plainEnemies.get(2),33,plainEnemies.get(3),1);
				if(travelResult == 3)
					town();
				else
				{
					Story.plainsPlainsPath();
					travelResult = placeTravel(10,10,plainEnemies.get(0),33,plainEnemies.get(1),33,plainEnemies.get(2),33,plainEnemies.get(3),1);
					if(travelResult == 3)
						town();
					else
						plains();
				}
				break;
			case 2:
				travelResult = placeTravel(10,10,plainEnemies.get(0),33,plainEnemies.get(1),33,plainEnemies.get(2),33,plainEnemies.get(3),1);
				if(travelResult == 3)
					town();
				else
				{
					Story.plainsGrasslandsPath();
					travelResult = placeTravel(10,10,plainEnemies.get(0),33,plainEnemies.get(1),33,plainEnemies.get(2),33,plainEnemies.get(3),1);
					if(travelResult == 3)
						town();
					else
						plains();
				}
				break;
			case 3: //Hill path, boss
				travelResult = placeTravel(10,10,plainEnemies.get(0),33,plainEnemies.get(1),33,plainEnemies.get(2),33,plainEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,plainEnemies.get(0),33,plainEnemies.get(1),33,plainEnemies.get(2),33,plainEnemies.get(3),1);
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
	private void forest()    //placeTravel method arguments: default
	{
		Story.forest(forest);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the plains",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel(10,10,forestEnemies.get(0),33,forestEnemies.get(1),33,forestEnemies.get(2),33,forestEnemies.get(2),1);
				if(travelResult == 3)
					town();
				else
				{
					Story.forestPathOne();
					travelResult = placeTravel(10,10,forestEnemies.get(0),33,forestEnemies.get(1),33,forestEnemies.get(2),33,forestEnemies.get(2),1);
					if(travelResult == 3)
						town();
					else
						forest();
				}
				break;
			case 2:
				travelResult = placeTravel(10,10,forestEnemies.get(0),33,forestEnemies.get(1),33,forestEnemies.get(2),33,forestEnemies.get(2),1);
				if(travelResult == 3)
					town();
				else
				{
					Story.forestPathTwo();
					travelResult = placeTravel(10,10,forestEnemies.get(0),33,forestEnemies.get(1),33,forestEnemies.get(2),33,forestEnemies.get(2),1);
					if(travelResult == 3)
						town();
					else
						forest();
				}
				break;
			case 3: //boss route
				travelResult = placeTravel(10,10,forestEnemies.get(0),33,forestEnemies.get(1),33,forestEnemies.get(2),33,forestEnemies.get(2),1);
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
							travelResult = placeTravel(10,10,forestEnemies.get(0),33,forestEnemies.get(1),33,forestEnemies.get(2),33,forestEnemies.get(2),1);
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
	private void mountains() //placeTravel method arguments: default
	{
		Story.mountains(mountains);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the forest",4);
		switch(choice)
		{
			case 1: //boss route
				travelResult = placeTravel(10,10,mountainEnemies.get(0),33,mountainEnemies.get(1),33,mountainEnemies.get(2),33,mountainEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,mountainEnemies.get(0),33,mountainEnemies.get(1),33,mountainEnemies.get(2),33,mountainEnemies.get(3),1);
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
				travelResult = placeTravel(10,10,mountainEnemies.get(0),33,mountainEnemies.get(1),33,mountainEnemies.get(2),33,mountainEnemies.get(3),1);
				if(travelResult == 3)
					town();
				else
				{
					Story.mountainsPathTwo();
					travelResult = placeTravel(10,10,mountainEnemies.get(0),33,mountainEnemies.get(1),33,mountainEnemies.get(2),33,mountainEnemies.get(3),1);
					if(travelResult == 3)
						town();
					else
						mountains();
				}
				break;
			case 3:
				travelResult = placeTravel(10,10,mountainEnemies.get(0),33,mountainEnemies.get(1),33,mountainEnemies.get(2),33,mountainEnemies.get(3),1);
				if(travelResult == 3)
					town();
				else
				{
					Story.mountainsPathThree();
					travelResult = placeTravel(10,10,mountainEnemies.get(0),33,mountainEnemies.get(1),33,mountainEnemies.get(2),33,mountainEnemies.get(3),1);
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
	private void village()   //placeTravel method arguments: default
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
	private void volcano()   //placeTravel method arguments: default
	{
		Story.volcano(volcano);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the village",4);
		switch(choice)
		{
			case 1: //boss route
				travelResult = placeTravel(10,10,volcanoEnemies.get(0),33,volcanoEnemies.get(1),33,volcanoEnemies.get(2),33,volcanoEnemies.get(2),1);
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
							travelResult = placeTravel(10,10,volcanoEnemies.get(0),33,volcanoEnemies.get(1),33,volcanoEnemies.get(2),33,volcanoEnemies.get(2),1);
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
				travelResult = placeTravel(10,10,volcanoEnemies.get(0),33,volcanoEnemies.get(1),33,volcanoEnemies.get(2),33,volcanoEnemies.get(2),1);
				if(travelResult == 3)
					village();
				else
				{
					Story.volcanoPathTwo();
					travelResult = placeTravel(10,10,volcanoEnemies.get(0),33,volcanoEnemies.get(1),33,volcanoEnemies.get(2),33,volcanoEnemies.get(2),1);
					if(travelResult == 3)
						village();
					else
						volcano();
				}
				break;
			case 3:
				travelResult = placeTravel(10,10,volcanoEnemies.get(0),33,volcanoEnemies.get(1),33,volcanoEnemies.get(2),33,volcanoEnemies.get(2),1);
				if(travelResult == 3)
					village();
				else
				{
					Story.volcanoPathThree();
					travelResult = placeTravel(10,10,volcanoEnemies.get(0),33,volcanoEnemies.get(1),33,volcanoEnemies.get(2),33,volcanoEnemies.get(2),1);
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
	private void caverns()   //placeTravel method arguments: default
	{
		Story.caverns(caverns);
		int choice = Util.numberSelect("Where will you go:\n1. Path 1\n2. Path 2\n3. Path 3\n4. Back to the Volcano",4);
		switch(choice)
		{
			case 1:
				travelResult = placeTravel(10,10,cavernEnemies.get(0),33,cavernEnemies.get(1),33,cavernEnemies.get(2),33,cavernEnemies.get(2),1);
				if(travelResult == 3)
					village();
				else
				{
					Story.cavernsPathOne();
					travelResult = placeTravel(10,10,cavernEnemies.get(0),33,cavernEnemies.get(1),33,cavernEnemies.get(2),33,cavernEnemies.get(2),1);
					if(travelResult == 3)
						village();
					else
						caverns();
				}
				break;
			case 2: //boss route
				travelResult = placeTravel(10,10,cavernEnemies.get(0),33,cavernEnemies.get(1),33,cavernEnemies.get(2),33,cavernEnemies.get(2),1);
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
							travelResult = placeTravel(10,10,cavernEnemies.get(0),33,cavernEnemies.get(1),33,cavernEnemies.get(2),33,cavernEnemies.get(2),1);
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
				travelResult = placeTravel(10,10,cavernEnemies.get(0),33,cavernEnemies.get(1),33,cavernEnemies.get(2),33,cavernEnemies.get(2),1);
				if(travelResult == 3)
					village();
				else
				{
					Story.cavernsPathThree();
					travelResult = placeTravel(10,10,cavernEnemies.get(0),33,cavernEnemies.get(1),33,cavernEnemies.get(2),33,cavernEnemies.get(2),1);
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
	private void base()      //placeTravel method arguments: default
	{
		Story.base(baseFac,baseUrb,baseLab,baseMil,baseFin);
		int choice;
		if(baseFac && baseUrb && baseLab && baseMil)
		{
			choice = Util.numberSelect("Where will you go:\n1. Back to the Caverns\n2. Factory Path\n3. Urban Path\n4. Laboratory Path\n5. Military Path\n6. Defeat Malus!\n\tNote: Once you leave to defeat Malus there will be no return, except through victory... or death.\n\tIn other words, you can't flee - and if you lose, then you lose the whole game!",6);
		}
		else
			choice = Util.numberSelect("Where will you go:\n1. Back to the Caverns\n2. Factory Path\n3. Urban Path\n4. Laboratory Path\n5. Military Path",5);
		switch(choice)
		{
			case 1:
				caverns();
				break;
			case 2: //Factory path
				travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
						travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 3: //Urban path
				travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
						travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 4: //lab path
				travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
						travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 5: //military path
				travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
						travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
						if(travelResult == 3)
							village();
						else
							base();
					}
				}
				break;
			case 6: //Malus boss (tell player that there is no going back once they start fighting malus - they either beat him, or lose)
				travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
							travelResult = placeTravel(10,10,baseEnemies.get(0),33,baseEnemies.get(1),33,baseEnemies.get(2),33,baseEnemies.get(3),1);
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
	public ArrayList<String> getAll()
	{
		ArrayList<String> data = new ArrayList<String>();
		
		String bools = "";
		bools = desert ? bools + "1" : bools + "0";
		bools = plains ? bools + "1" : bools + "0";
		bools = forest ? bools + "1" : bools + "0";
		bools = mountains ? bools + "1" : bools + "0";
		bools = volcano ? bools + "1" : bools + "0";
		bools = caverns ? bools + "1" : bools + "0";
		bools = baseFac ? bools + "1" : bools + "0";
		bools = baseUrb ? bools + "1" : bools + "0";
		bools = baseLab ? bools + "1" : bools + "0";
		bools = baseMil ? bools + "1" : bools + "0";
		bools = baseFin ? bools + "1" : bools + "0";
		
		data.add(bools);
		
		ArrayList<String> defOut = markDef.getAllString();
		ArrayList<String> healOut = markHeal.getAllString();
		ArrayList<String> SAOut = markSA.getAllString();
		ArrayList<String> weapOut = markWeap.getAllString();
		
		int[] sizes = {defOut.size(), healOut.size(), SAOut.size(), weapOut.size()};
		for(int i = 0; i < sizes[0]; i++)
		{
			data.add(defOut.get(i));
		}
		for(int i = 0; i < sizes[1]; i++)
		{
			data.add(healOut.get(i));
		}
		for(int i = 0; i < sizes[2]; i++)
		{
			data.add(SAOut.get(i));
		}
		for(int i = 0; i < sizes[3]; i++)
		{
			data.add(weapOut.get(i));
		}
		
		return data;
	}
	public void setAll(ArrayList<String> data)
	{
		ArrayList<String> defIn = new ArrayList<String>();
		ArrayList<String> healIn = new ArrayList<String>();
		ArrayList<String> SAIn = new ArrayList<String>();
		ArrayList<String> weapIn = new ArrayList<String>();
		
		String bools = data.remove(0);
		
		desert = bools.charAt(0) == '1' ? true : false;
		plains = bools.charAt(1) == '1' ? true : false;
		forest = bools.charAt(2) == '1' ? true : false;
		mountains = bools.charAt(3) == '1' ? true : false;
		volcano = bools.charAt(4) == '1' ? true : false;
		caverns = bools.charAt(5) == '1' ? true : false;
		baseFac = bools.charAt(6) == '1' ? true : false;
		baseUrb = bools.charAt(7) == '1' ? true : false;
		baseLab = bools.charAt(8) == '1' ? true : false;
		baseMil = bools.charAt(9) == '1' ? true : false;
		baseFin = bools.charAt(10) == '1' ? true : false;
		
		for(int i = 1; i <= 8; i++)
		{
			int numIters = Integer.parseInt(data.get(0));
			for(int j = 0; j <= numIters; j++)
			{
				if(i == 1 || i == 2) defIn.add(data.remove(0));
				else if(i == 3 || i == 4) healIn.add(data.remove(0));
				else if(i == 5 || i == 6) SAIn.add(data.remove(0));
				else weapIn.add(data.remove(0));
			}
		}
		
		markDef = new MarketDefense(defIn, true);
		markHeal = new MarketHealing(healIn, true);
		markSA = new MarketSpeAttack(SAIn, true);
		markWeap = new MarketWeapon(weapIn, true);
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