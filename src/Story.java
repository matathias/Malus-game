public class Story
{
	/*
	 * Contains methods used to display the story text.
	 */
	private static int malusQuoteCounter = 0;
	private static int placeQuoteCounter = 0;
	private static boolean desBoss = false;
	private static boolean plaBoss = false;
	private static boolean forBoss = false;
	private static boolean mounBoss = false;
	private static boolean volBoss = false;
	private static boolean cavBoss = false;
	private static boolean facBoss = false;
	private static boolean urbBoss = false;
	private static boolean labBoss = false;
	private static boolean milBoss = false;
	private static boolean malBoss = false;

	public static void town() //pre-menu choice COMPLETE
	{
		if(placeQuoteCounter == 0)
		{
			Util.bigLineBreak();
			System.out.print("\n\"Hmm... is this it? ...why yes... yes it is!...\"");
			Util.skitPause();
			System.out.print("\"Finally, my search is complete!\"\n\"Now I need only to find a way to properly utilize this power...\"");
			Util.skitPause();
			System.out.println("\"Yes... after a mere weeks' time, I, Malus,\nwill control the power of Ultima Chaos...!\"");

			Util.skitPause();
			Util.bigLineBreak();
			Util.skitPause();
			Util.bigLineBreak();

			System.out.print("\nSomething doesn't feel right... \nYour sixth sense is telling you that some danger,\nsome sort of evil, looms in the air.");
			Util.skitPause();
			System.out.print("But, you don't quite know what.");
			Util.skitPause();
			System.out.print("Such a trivial fact doesn't deter your heroic responsibilities, however.\nQuickly you prepare for a new adventure.");
			Util.skitPause();
			System.out.print("You then step outside, and try to feel for where the evil is...");
			Util.skitPause();
			System.out.println("...and fail utterly. So instead, you head to the nearest town,\nhoping to find your way from there.");

			Util.skitPause();
			Util.bigLineBreak();
			Util.skitPause();

			System.out.println("Once at the town, you see an Inn, several markets, and the desert beyond that.");
			System.out.println("With a slight smirk, you set off,\nhoping to stop whatever evil lurks over the land.");
			Util.skitPause();
			
			placeQuoteCounter++;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You arrive at the town, hoping for some R&R.");
		}
	}
	/*
	 *	Desert ---------- COMPLETE
	 */
	public static void desert(boolean d) //pre-menu choice COMPLETE
	{
		if(placeQuoteCounter == 1)
		{
			Util.lineBreak();
			System.out.print("You arrive at the desert past the town with a level of dread;\ndeserts are far from comfortable environments, after all.");
			Util.skitPause();
			System.out.print("But this is the beginning of the adventure;\nsurely other locales will be more welcoming?");
			Util.skitPause();
			System.out.print("Either way, you set your jaw and look forward,\nready to defeat anything that comes your way!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(d)
		{
			Util.lineBreak();
			System.out.println("The desert's a quieter place with the Sand Stone eradicated.\n...at least, the second path is open to the plains.");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You have arrived at the desert,\nready to once again search for the evil that lurks within.");
		}
	}
	public static void desertPathOne() //end of path one, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nDisappointed, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void desertPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nAnoyed, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void desertBoss() //intro to desert boss COMPLETE
	{
		if(!desBoss)
		{
			Util.lineBreak();
			System.out.print("Ah! There, off in the distance - it's plains!");
			Util.skitPause();
			System.out.print("Excited to finally be past the horrid desert heat, you speed up your pace,\nhoping that you at least won't get dirt in your eyes on the plains.");
			Util.skitPause();
			System.out.print("However, before you can get very far a sudden sandstorm whips up,\nnearly blinding you and concealing the plains behind a curtain of sand.");
			Util.skitPause();
			System.out.print("You quickly adjust to the sand, though the first thing you spot\nis a floating, sand-colored stone.");
			Util.skitPause();
			System.out.print("Even though it has no eyes, it seems as if it's glaring down\nat you contemptuously, laughing at your plight.");
			Util.skitPause();
			System.out.print("Obviously, it must be the source of the sandstorm!\n...though even if it isn't, destroying it could offer some solace.");
			Util.skitPause();
			System.out.println("But nevermind the details; it's time for battle!");
			Util.skitPause();
			desBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to face off with the Sand Stone,\nprepared to offer it the beat down that it prevented you from giving last time!");
			Util.skitPause();
		}
	}
	public static void desertBossEmergency() //desert boss goes into emergency mode COMPLETE
	{
		System.out.print("Before the Sand Stone attacks again, it seems to almost rear up into the air.");
		Util.skitPause();
		System.out.print("Immediately after doing so the sand storm around you intensifies.\nIt would appear that you've succeeded in making it angry!");
		Util.skitPause();
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void desertBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("With a final blow you shatter the Sand Stone to millions of tiny pieces,\neach disappearing into the very sandstorm the stone conjured.");
		Util.skitPause();
		System.out.print("Now that the Sand Stone is no more, the sandstorm begins to subside -\nsoon, the plains become visible once again.");
		Util.skitPause();
		System.out.print("And with a closer look, you see a forest beyond the plains,\nand a distant mountain range beyond that.");
		Util.skitPause();
		System.out.print("It looks like it could be bothersome to trek through all that terrain,\nbut you can't shake off this feeling of lurking evil.");
		Util.skitPause();
		System.out.println("So with an intrepid step you continue your journey onward,\nhoping that you'll have more of an idea as to what this evil is before long.");
		Util.skitPause();
	}
	public static void desertBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("Realizing that you aren't strong enough to defeat the Sand Stone,\nyou turn and high-tail it out of there.");
		Util.skitPause();
		System.out.println("You won't be able to get to the Plains this way... you'll have to get stronger!");
		Util.skitPause();
	}
	public static void desertBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("Your ability to correctly estimate your own, well, abilities, is severely lacking.");
		Util.skitPause();
		System.out.print("With this defeat you trudge back to the town, battered and nearly in pieces;");
		Util.skitPause();
		System.out.println("Be sure to heal up before you head out recklessly again!");
		Util.skitPause();
	}
	/*
	 *	Plains ---------- COMPLETE
	 */
	public static void plains(boolean p) //pre-menu stuff COMPLETE
	{
		if(placeQuoteCounter == 2)
		{
			Util.lineBreak();
			System.out.print("Finally, you step onto ground that isn't unstable, uncomfortable sand.\nYou breath a sigh of relief; even the air is more comfortable.");
			Util.skitPause();
			System.out.print("But the sun is still an issue - there's no cover or shade in the Plains.\nAnd the enemies are bound to be more difficult as well.");
			Util.skitPause();
			System.out.println("Either way, you prepare to continue your adventure.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(p)
		{
			Util.lineBreak();
			System.out.println("The plains are a safer place,\nnow that you're eradicated the Grass Stone in the hills.");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to the plains, prepared to face the enemies ahead once again.");
		}
	}
	public static void plainsPlainsPath() //end of plains path, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nExhausted, you turn back toward the way from which you came.");
		Util.skitPause();
	}
	public static void plainsGrasslandsPath() //end of grasslands path, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nIrritated, you turn back toward the way from which you came.");
		Util.skitPause();
	}
	public static void plainsBoss() //intro to plains boss COMPLETE
	{
		if(!plaBoss)
		{
			Util.lineBreak();
			System.out.print("As you progress through the hills you note that you're almost upon the forest;");
			Util.skitPause();
			System.out.print("While not exactly overjoyed,\nyou're certainly happy that the next stage of your adventure is near complete.");
			Util.skitPause();
			System.out.print("However, before you're able to reach the treeline\nthe grass beneath you suddenly becomes very stiff and sharp;");
			Util.skitPause();
			System.out.print("With a yelp of pain, you leap back, glaring at the offending plants.\nSoon, though, the real culprit reveals itself: a levitating green stone.");
			Util.skitPause();
			System.out.print("It bears a remarkable resemblance to the Sand Stone...\nmaybe by destroying it, you'll be able to access the forest!");
			Util.skitPause();
			System.out.println("You quickly prepare for battle, ready to destroy the mysterious green stone!");
			Util.skitPause();
			plaBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to face off with the Grass Stone,\nprepared to defeat it like it defeated you last time!");
			Util.skitPause();
		}
	}
	public static void plainsBossEmergency() //plans boss goes into emergency mode COMPLETE
	{
		System.out.print("Before the Grass Stone attacks again,\nit seems to almost rear up into the air.");
		Util.skitPause();
		System.out.print("Immediately after doing so the grass around you is uprooted\nand rises into the air, surrounding the Grass Stone.");
		Util.skitPause();
		System.out.print("It would appear that you've succeeded in making it angry!");
		Util.skitPause();
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void plainsBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("With a final blow you shatter the Grass Stone to a million tiny pieces,\neach disappearing into the grass it once controlled.");
		Util.skitPause();
		System.out.print("Finally the grass settles, allowing you passage over the remaining hills\nwithout your feet being impaled.");
		Util.skitPause();
		System.out.print("You cautiously cross the remaining distance (in case there are any more enemies)\nbut reach the forest unharmed.");
		Util.skitPause();
		System.out.print("This close to the forest, it's impossible to see anything past it -\nbut you know that the mountains are there, and beyond them, a great evil.");
		Util.skitPause();
		System.out.println("With the same determination as before you head into the forest,\nprepared to face anything that's thrown your way.");
		Util.skitPause();
	}
	public static void plainsBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("Realizing that you aren't strong enough to defeat the Grass Stone,\nyou quickly turn tail and leave.");
		Util.skitPause();
		System.out.println("You'll have to be stronger before you can hope to defeat it!");
		Util.skitPause();
	}
	public static void plainsBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After recieving a critical hit you finally realize\nthat you aren't strong enough to fight the Grass Stone.");
		Util.skitPause();
		System.out.println("You quickly limp away, returning to town to recuperate.");
		Util.skitPause();
	}
	/*
	 *	Forest ---------- COMPLETE
	 */
	public static void forest(boolean f) //pre-menu stuff COMPLETE
	{
		if(placeQuoteCounter == 3)
		{
			Util.lineBreak();
			System.out.print("So you've finally made it to the shade of the forest.\nThe sun's no longer an issue; no more sunburns for you!");
			Util.skitPause();
			System.out.print("However, this forest looks a tad spookier on the inside than the out -\nthere's bound to be tons of enemies here.");
			Util.skitPause();
			System.out.println("You quickly gear up - there's still a lot to fight through in front of you!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(f)
		{
			Util.lineBreak();
			System.out.println("The forest seems a more peaceful place now that the Leaf Stone is destroyed.\nOn top of that, the third path is open to the mountains!");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You walk into the forest, prepared to face the enemies lurking there.");
		}
	}
	public static void forestPathOne() //end of path one, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nTired, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void forestPathTwo() //end of path two, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nCross, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void forestBoss() //intro to forest boss COMPLETE
	{
		if(!forBoss)
		{
			Util.lineBreak();
			System.out.print("After dodging past the next tree, you spot a sliver of light,\nbrighter than any location within the forest.");
			Util.skitPause();
			System.out.print("You conclude that it must be the treeline - you're at a higher altitude\nthan when you first entered the forest, anyway.");
			Util.skitPause();
			System.out.print("However, before you can get much closer to the light all of the leaves\naround you suddenly come to life.");
			Util.skitPause();
			System.out.print("Swirling around you, they begin to lacerate your skin one by one;\nnot wanting to die by 1000 papercuts, you quickly jump out of the vortex.");
			Util.skitPause();
			System.out.print("Now outside of the leaves, you see a floating, dark green stone behind it.\nIt looks rather similar to the Sand and Grass Stones.");
			Util.skitPause();
			System.out.println("Realizing this, you prepare to take it down,\nhoping to clear the way to the end of the forest!");
			Util.skitPause();
			forBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Leaf Stone,\nthis time prepared to destroy it like the two Stones before it!");
			Util.skitPause();
		}
	}
	public static void forestBossEmergency() //COMPLETE
	{
		System.out.print("Before the Leaf Stone attacks again, it seems to almost rear up into the air.");
		Util.skitPause();
		System.out.print("Immediately after doing so the leaf storm in front of you intensifies.\nIt would appear that you've succeeded in making it angry!");
		Util.skitPause();
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void forestBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("You land a final, critical hit on the Leaf Stone,\nshattering it into a million pieces,\neach landing amongst the leaves they once controlled.");
		Util.skitPause();
		System.out.print("With nothing more in your way, you make your way to the edge of the forest.");
		Util.skitPause();
		System.out.print("Once you emerge at the treeline you find that you're now in the mountains,\nwith a Volcano barely visible in the distance.");
		Util.skitPause();
		System.out.print("Before you set off to continue adventuring, though,\nyou think back to the three Stones you've beaten: the Sand, Grass,\nand now, Leaf Stone.");
		Util.skitPause();
		System.out.print("They can't be coincidences... Stones like those just aren't natural.\nAnd neither are several of the enemies you've encountered.");
		Util.skitPause();
		System.out.print("Not to mention all those robots and drones you've defeated!\nSomeone, or something, must be behind this.\n...likely the very evil you're chasing.");
		Util.skitPause();
		System.out.println("With that thought you continue onward, resolving to find and defeat this evil!");
		Util.skitPause();
	}
	public static void forestBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("Recognizing the gap in capability between you and the Leaf Stone,\nyou quickly pull out, staging a tactical retreat.");
		Util.skitPause();
		System.out.println("You'll need to be stronger if you hope to defeat the Leaf Stone!");
		Util.skitPause();
	}
	public static void forestBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After receiving a critical hit you realize that you\nsimply aren'tstrong enough to take on the Leaf Stone.");
		Util.skitPause();
		System.out.println("You disengage and manage to crawl back to town,\nhoping to recuperate before heading out once more.");
		Util.skitPause();
	}
	/*
	 *	Mountains ---------- COMPLETE
	 */
	public static void mountains(boolean m) //pre-menu stuff COMPLETE
	{
		if(placeQuoteCounter == 4)
		{
			Util.lineBreak();
			System.out.print("Now in the mountains, you notice a certain biting coolness\nthat wasn't present before (and certainly not in the desert).");
			Util.skitPause();
			System.out.print("You may not have the shade that the forest offered,\nbut the lack of heat makes up for it.");
			Util.skitPause();
			System.out.println("After taking a second to gaze upon the beauty of the mountains you gear up,\nprepared to continue your adventure.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(m)
		{
			Util.lineBreak();
			System.out.println("With the Blizzard Stone defeated,\nthe biting sensation that came with the coolness is now gone.\nPlus, path one is open to the Village.");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You arrive in the mountains, prepared to take on anything in your path.");
		}
	}
	public static void mountainsPathTwo() //end of path two, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nBitter, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void mountainsPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nExasperated, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void mountainsBoss() // intro to mountains boss COMPLETE
	{
		if(!mounBoss)
		{
			Util.lineBreak();
			System.out.print("You've been constantly approaching the Volcano through the mountain range,\nand now you need only to clear one more peak.");
			Util.skitPause();
			System.out.print("You can see a village at the peak;\nit would be an excellent place to rest-up before\nventuring toward the Volcano itself.");
			Util.skitPause();
			System.out.print("However, before you can even reach it the snow all\naround you suddenly kicks up into a blinding Blizzard!");
			Util.skitPause();
			System.out.print("This isn't the first time the environment has risen against you, though.");
			Util.skitPause();
			System.out.print("Expecting a Stone to be behind these shinanigans,\nyou slowly scan the area until you spot a hovering silhouette in the distance.");
			Util.skitPause();
			System.out.println("It must be the offending Stone - pulling out your weapon,\nyou approach even quicker, prepared to take it down!");
			Util.skitPause();
			mounBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Blizzard Stone,\nthis time prepared to obliterate it like no other!");
			Util.skitPause();
		}
	}
	public static void mountainsBossEmergency() //COMPLETE
	{
		System.out.print("Before the Blizzard Stone attacks again,\nit seems to almost rear up into the air.");
		Util.skitPause();
		System.out.print("Immediately after doing so the snow storm around you intensifies.\nIt would appear that you've succeeded in making it angry!");
		Util.skitPause();
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void mountainsBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("You land a final critical hit on the Blizzard Stone,\nshattering it into a million pieces,\neach disappearing into the Blizzard it created.");
		Util.skitPause();
		System.out.print("Slowly, the weather calms down, until you can once again see the sky -\nand also the village.");
		Util.skitPause();
		System.out.print("As you approach the village, you think back to the four Stones you've defeated:\nSand, Grass, Leaf, and Blizzard.");
		Util.skitPause();
		System.out.print("Is there a connection? You believe that there must be one,\nbut what it is, you aren't quite sure.");
		Util.skitPause();
		System.out.println("Maybe you'll find some answers near the Volcano...\nafter stopping at the village, of course.");
		Util.skitPause();
	}
	public static void mountainsBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("The gap in ability between you and the Blizzard Stone is simply too large.\nYou quickly initiate a retrograde advance.");
		Util.skitPause();
		System.out.println("You'll need to be stronger if you hope to defeat the Blizzard Stone!");
		Util.skitPause();
	}
	public static void mountainsBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After nearly getting frostbitten for the nth time,\nyou recognize that there's an incomprehensible gap in ability\nbetween you and the Blizzard Stone.");
		Util.skitPause();
		System.out.println("Managing to escape the Stone's influence, you limp back to town,\nwishing for a nice cup of hot cocoa and maybe life insurance.");
		Util.skitPause();
	}
	/*
	 *	Village ---------- COMPLETE
	 */
	public static void village() //pre-menu stuff COMPLETE
	{
		if(placeQuoteCounter == 5)
		{
			Util.lineBreak();
			System.out.print("You finally reach the village, a safe-haven for adventurers such as yourself.");
			Util.skitPause();
			System.out.print("Looking around, you realize that it isn't as nicely equipped as the town -\nthere's no healing or special attack market - but at least there's an inn.");
			Util.skitPause();
			System.out.println("You then step into the village, hoping to better prepare\nyourself for further adventuring.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You step into the village, hoping to rest, recuperate, and better equip yourself.");
		}
	}
	/*
	 *	Volcano ---------- COMPLETE
	 */
	public static void volcano(boolean v) //pre-menu stuff COMPLETE
	{
		if(placeQuoteCounter == 6)
		{
			Util.lineBreak();
			System.out.print("You near the base of the volcano and can already feel the heat;\nit's far more uncomfortable than the desert.");
			Util.skitPause();
			System.out.print("You aren't sure what you'll find here - or even what you're doing here -\nbut you can sense the evil even stronger than before.");
			Util.skitPause();
			System.out.print("So, obviously, you must be going in the correct direction... right?");
			Util.skitPause();
			System.out.println("Well, you hope to find an answer at the volcano anyways, and thus prepare\nto withstand the heat and defeat any enemies that present themselves.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(v)
		{
			Util.lineBreak();
			System.out.println("You arrive at the volcano, which is still pretty damn hot,\nbut at least the Wyvern is defeated and path one is open to the caverns.");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to the volcano, trying your best to withstand the heat\nwhile seeking out answers to your quest(ions).");
		}
	}
	public static void volcanoPathTwo() //end of path two, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here, besides far too much magma...\nVexed, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void volcanoPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\nIrked, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void volcanoBoss() // intro to volcano boss COMPLETE
	{
		if(!volBoss)
		{
			Util.lineBreak();
			System.out.print("As you walk around the base of the Volcano you spot a cave\nthat isn't flooded with lava. Curious, you begin to approach.");
			Util.skitPause();
			System.out.print("\"Halt right there!\"");
			Util.skitPause();
			System.out.print("Startled, you pause and look about. Your eyes soon land on an armored\nindividual to your side, holding a gun in your direction!");
			Util.skitPause();
			System.out.print("The sense of danger and evil you felt at the beginning of your adventure\nsuddenly overwhelms you. Certainly, this person is the source!");
			Util.skitPause();
			System.out.print("But at your current ability level there's no way you could defeat him.\nThough any further thought is cut off as the individual begins to speak.");
			Util.skitPause();
			System.out.print("\"Ah, another one of those hardy adventure types, hoping to defeat me,\nis that it?\" he smirks, \"Pft. As if I could lose to the likes of you!\"");
			Util.skitPause();
			System.out.print("You take a step back; if this man intends to attack you,\nthen you intend to retreat. As fast as humanly possible.");
			Util.skitPause();
			System.out.print("\"Hmm... you're scared of me. I can see that you're intelligent enough\nto recognize my power,\" the man comments, \"...perhaps I won't kill you now.\"");
			Util.skitPause();
			System.out.print("He then takes a step back and taps his wrist -\nit looks as if he's typing something - and then looks back to you.");
			Util.skitPause();
			System.out.print("\"Instead...\" he sneers, as a giant, flying robot swoops down behind him,\n\"I'll pit you against this Boss Class Aerial 'Bot.\"");
			Util.skitPause();
			System.out.print("Suddenly, the ground below you shudders and begins rising into the air,\nrevealing itself to be a large, levitating metal platform!");
			Util.skitPause();
			System.out.print("With apprehension you turn to look down at the man, only to see the robot\nflying up at you and the man shouting after it:");
			Util.skitPause();
			System.out.println("\"Wyvern... destroy this pest!\"");
			Util.skitPause();
			volBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print("\"So you actually returned, eh?\"\nMalus sneered, gesturing for the BCA Wyvern to approach you.\n\"I simply thought you had taken the coward's way out!\"");
			Util.skitPause();
			System.out.println("You back into a battle stance, unfazed by Malus' taunts.\nTime time... you'll defeat his Wyvern!");
			Util.skitPause();
		}
	}
	public static void wyvernBossEmergency() //COMPLETE
	{
		System.out.print("With a mechanical screech the Wyvern launches into the air,\ncoming to a stop and hovering a fair distance over the platform.");
		Util.skitPause();
		System.out.print("It then pulls its tail down between its legs, as if its pointing at you,\nand then - a spike suddenly appears on the tip!");
		Util.skitPause();
		System.out.print("For it to pull a trick out of its sleeve...\nyou must be fairly close to defeating it.");
		Util.skitPause();
		System.out.println("With that thought, your expression hardens -\nyou're ready for anything its about to throw at you!");
		Util.skitPause();
	}
	public static void volcanoBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("You land a final critical blow on the Wyvern,\nand then step back and watch as it explodes and falls to pieces,\nthoroughly destroyed and unsalvageable.");
		Util.skitPause();
		System.out.print("\"Hmm... not bad, not bad,\" the man nods, as the platform you are on\nstarts lowering to the ground, \"though still not strong enough to beat me.\"");
		Util.skitPause();
		System.out.print("\"You could actually be entertaining to me...\" he comments as he engages\na jetpack attached to his back, \"Yes... I like the sound of that.\"");
		Util.skitPause();
		System.out.print("\"I have nothing else to do currently, anyway.\"\nYou simply stand back and watch as he lifts off the ground,\nnot sure what to think of the comment.");
		Util.skitPause();
		System.out.print("\"Ah, but before I go,\" the man adds,\n\"I think I'll go ahead and allow you to know my name...\nthe name of your superior, in all ways!\"");
		Util.skitPause();
		System.out.println("\"I am Malus... future overlord of the world!!\"");
		Util.skitPause();
		Util.bigLineBreak();
		System.out.print("So... Malus. He's the evil you first sensed. With his aura...\nhis claims to future overlord-hood may be justified.");
		Util.skitPause();
		System.out.print("You quickly deduce that you have to defeat him... \n...Though you aren't ready to face him yet.\nYou need to find his lair first anyway.");
		Util.skitPause();
		System.out.print("There's no readily available pathway around the volcano...\nthe only path you can see is the cavern, no longer blocked by Malus or a robot.");
		Util.skitPause();
		System.out.println("For now, it'll have to do.\nHopefully, it will lead you one step closer to Malus' location!");
		Util.skitPause();
	}
	public static void volcanoBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("\"Ha ha ha, that's what I thought!\" Malus shouts after your retreating form,\n\"You aren't strong enough to face me! At all!\"");
		Util.skitPause();
		System.out.println("Well, as annoying as he might be, Malus is right about one thing:\nyou need to get stronger. Heading back, you intend to do just that.");
		Util.skitPause();
	}
	public static void volcanoBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("\"AH ha ha ha ha!!\" Malus laughs loud and long as you fall to the ground,\nalmost every bone in your body broken.");
		Util.skitPause();
		System.out.print("\"You aren't strong enough to face me, and you never will be.\"\nHe sneers, and then turns away with the Wyvern.");
		Util.skitPause();
		System.out.print("\"I'll let you live, for now.\nMaybe you'll serve as a lesson for others who ignorantly wish to face me!\"");
		Util.skitPause();
		System.out.print("As he leaves the scene you slowly begin to crawl back to the village...");
		Util.skitPause();
		System.out.println("You'll definitely need to get stronger before you can even hope to defeat Malus!");
		Util.skitPause();
	}
	/*
	 *	Caverns ---------- COMPLETE
	 */
	public static void caverns(boolean c) //pre-menu stuff COMPLETE
	{
		if(placeQuoteCounter == 7)
		{
			Util.lineBreak();
			System.out.print("As you walk through the cavern under the volcano,\nyou note that it isn't becoming hot. In fact, it's actually getting colder.");
			Util.skitPause();
			System.out.print("That defeats all logic...\ntechnically, you should have reached a lava flow by now!");
			Util.skitPause();
			System.out.print("You continue down the caves... and a thought pops into your head:\nWhat if this geographic phenomonon was created by Malus?");
			Util.skitPause();
			System.out.print("If so, then he must have a great deal of resources and time on his side...\nbut it also means that you're likely close to his base!");
			Util.skitPause();
			System.out.print("It's time to up the ante. You resolutely decide to blast through\nthe caves and find Malus' base, and then stop him!");
			Util.skitPause();
			System.out.println("...easier said than done. ...well, time to find your way through the caves!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(c)
		{
			Util.lineBreak();
			System.out.println("You've already defeated the BCG Cerberus...\ntime to head through path two to Malus' base!");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to the caverns,\nprepared to continue your search for the path to Malus' base.");
		}
	}
	public static void cavernsPathOne() //end of path one, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("Even after all those damn rocks, there's nothing here...\nFatigued, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void cavernsPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here...\n Enervated, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void cavernsBoss() // intro to caverns boss COMPLETE
	{
		if(!cavBoss)
		{
			Util.lineBreak();
			System.out.print("You round another corner, finding yourself in a rather large cavern.\nWary of locales of such size, you cautiously make your way to the other side.");
			Util.skitPause();
			System.out.print("But your caution is to no avail. Previously unknown to you,\none of the walls is actually a door - and through it bursts a large robot!");
			Util.skitPause();
			System.out.print("It looks like a huge dog... surely, this is one of Malus' creations.\nAnd if it is... then you must be getting closer to his base!");
			Util.skitPause();
			System.out.println("You back into a battle stance, prepared to take on the robot!");
			Util.skitPause();
			cavBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the BCG Cerberus, prepared to send it to its oblivion!");
			Util.skitPause();
		}
	}
	public static void cerberusBossEmergency() //COMPLETE
	{
		System.out.print("The Cerberus rears up and lets loose an electronic roar;\nupon doing so you can see various small internal fires.");
		Util.skitPause();
		System.out.println("It's almost destroyed... and it seems to know that.\nYou harden your stance, prepared for whatever the Cerberus is about to do!");
		Util.skitPause();
	}
	public static void cavernsBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("After suffering a final critical blow the Cerberus shuts down\ncatastrophically... that is, it explodes.");
		Util.skitPause();
		System.out.println("With that obstacle out of your way, you're now ready to move on,\none step close to Malus' base!");
		Util.skitPause();
	}
	public static void cavernsBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("The way this battle is going, you'll never win.\nRecognizing this, you quickly pull out.");
		Util.skitPause();
		System.out.println("You'll need to get stronger before you can pass the Cerberus!");
		Util.skitPause();
	}
	public static void cavernsBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("You suffer a critical blow at the hands of the Cerberus...");
		Util.skitPause();
		System.out.print("Your body broken, you somehow manage to disengage from the Cerberus\nand begin your long, painful trek back to the village.");
		Util.skitPause();
		System.out.println("With battles ending like that you'll *have* to get stronger\nbefore you can even think about reaching Malus' base!");
		Util.skitPause();
	}
	/*
	 *	Base   -----------------   COMPLETE
	 *		Factory  --- COMPLETE
	 *		Urban    --- COMPLETE
	 *		Lab      --- COMPLETE
	 *		Military --- COMPLETE
	 *		Malus    --- COMPLETE
	 */
	public static void base(boolean f, boolean u, boolean l, boolean m, boolean b) //pre-menu stuff (baseFac,baseUrb,baseLab,baseMil,baseFin) COMPLETE
	{
		if(placeQuoteCounter == 8)
		{
			Util.lineBreak();
			System.out.print("You emerge from the caverns to find yourself in a completely unknown locale.\nEverything around you looks industrial...");
			Util.skitPause();
			System.out.print("\"Ah, so you finally arrived!\"");
			Util.skitPause();
			System.out.print("You look up, though you have no need -\nyou already know the identity of the speaker.");
			Util.skitPause();
			System.out.print("\"I must say, well done!\" Malus smirks from his position atop a nearby building,\n\"Defeating both the Wyvern and the Cerberus... impressive!\"");
			Util.skitPause();
			System.out.print("\"But you still aren't at my level! And if you don't defeat me\nwithin the next 24 hours... then you never will be!!\"");
			Util.skitPause();
			System.out.print("He then jumps into the air and engages his jet pack,\nflying backward into the industrial complex.\n\"Good luck reaching me before then!\"");
			Util.skitPause();
			System.out.print("You watch him leave, and then what he says hits you.\n24 hours? What could possibly happen after that...?");
			Util.skitPause();
			System.out.print("Well, you at least know you don't want to find out.\nAll you know is that you're standing at the entrance to Malus' domain...");
			Util.skitPause();
			System.out.println("...and it's time to kick some ass!!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if((f || u  || l  || m) && !(f && u && l && m))
		{
			Util.lineBreak();
			System.out.println("You've destroyed some of Malus' mechanical minions...\nbut you've yet to destroy them all. It's time to remedy that situation.");
			System.out.println("Beaten bosses:");
			if(f)
			{
				System.out.println("\tIncomplete Bug Crawler(Factory)");
			}
			if(u)
			{
				System.out.println("\tCivil Control Mech(Urban)");
			}
			if(l)
			{
				System.out.println("\tPrototype Mantis Crawler(Lab)");
			}
			if(m)
			{
				System.out.println("\tInsecti Crawler(Military)");
			}
			System.out.print("\n");
			Util.skitPause();
		}
		else if(b)
		{
			Util.lineBreak();
			System.out.println("With Malus dead, his base has fallen into a state of disrepair.\nNo more evil lurks here... though his minions still do.");
			Util.skitPause();
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to Malus' base, ready and willing to kick some ass!");
			Util.skitPause();
		}
	}
	public static void baseFactoryBoss() //intro to factory boss COMPLETE
	{
		if(!facBoss)
		{
			Util.lineBreak();
			System.out.print("After fighting through Malus' construction and production\nfacilities you find yourself in a large hanger.");
			Util.skitPause();
			System.out.print("You suspect that something is amiss... and sure enough,\na large door in the back opens to reveal a large mech!");
			Util.skitPause();
			System.out.print("It appears to almost be a cross between a spider and a dog...\nbut its appearance doesn't matter. You plan to defeat it no matter what!");
			Util.skitPause();
			System.out.println("And once you do... you'll be just one step closer to Malus!");
			Util.skitPause();
			facBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Bug Crawler, determined to utterly destroy it this time!");
			Util.skitPause();
		}
	}
	public static void bugCrawlerModeOneEmergency() //COMPLETE
	{
		System.out.print("The Bug Crawler lets loose a metallic roar and then flaps its wings strongly,\napparently attempting to put out the many fires on its wings.");
		Util.skitPause();
		System.out.print("It then zooms in close, evidentally prepared to unleash some ferocious attack.");
		Util.skitPause();
		System.out.println("But it doesn't intimidate you... you stand back and plant your feet,\nready to face the robot's mad charge!");
		Util.skitPause();
	}
	public static void bugCrawlerTransform() //COMPLETE
	{
		System.out.print("Suddenly the Bug Crawler dives down toward the ground,\ncoming to a stop just before it hits.");
		Util.skitPause();
		System.out.print("It lands with a metallic crash and then discards its wings;\nsurprised, you back off a bit, not sure how to react.");
		Util.skitPause();
		System.out.println("But the Crawler evidentally isn't destroyed yet, so you set yourself\nback into a battle stance, prepared to utterly obliterate it!");
		Util.skitPause();
	}
	public static void baseFactoryBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("The Bug Crawler collapses to the ground, overloading and shutting down\nafter the beat-down you offered it.");
		Util.skitPause();
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseFactoryBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You soon realize that you can't defeat the Bug Crawler in your current state.\nYou quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseFactoryBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After receiving another critical blow you finally realize\nthat you simply can't beat the Bug Crawler.");
		Util.skitPause();
		System.out.println("In massive pain, you retreat as quickly as broken bones allow,\nhoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseFactoryBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Bug Crawler!\nYou turn back, confident that nothing else lurks in the factory.");
		Util.skitPause();
	}
	public static void baseUrbanBoss() //intro to urban boss COMPLETE
	{
		if(!urbBoss)
		{
			Util.lineBreak();
			System.out.print("After walking through what may be the most un-populated city you've ever seen,\nyou find yourself in a large parking lot surrounding by buildings.");
			Util.skitPause();
			System.out.print("You suspect that something is amiss... and sure enough, a large,\nnearby garage door opens to reveal a large mech!");
			Util.skitPause();
			System.out.print("It doesn't appear too impresive, but it certainly has guns equipped...\nthough that doesn't matter. You plan to defeat it no matter what!");
			Util.skitPause();
			System.out.println("And once you do... you'll be just one step closer to Malus!");
			Util.skitPause();
			urbBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Civil Control Mech,\nconfident in your ability to smash it this time!");
			Util.skitPause();
		}
	}
	public static void civilMechEmergency() //COMPLETE
	{
		System.out.print("Seemingly fed up with its attacks failing, the Civil Control Mech\ntakes a step back and then opens a hidden hatch on its front side.");
		Util.skitPause();
		System.out.print("And out of it... emerges an Alpha Cannon!");
		Util.skitPause();
		System.out.println("Seeing that the mech seems to have finally resorted to actual force,\nyou decide to do the same - otherwise known as smashing it into smithereens!");
		Util.skitPause();
	}
	public static void baseUrbanBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("The Civil Control Mech crumbles to the ground,\noverloading and shutting down permanently.");
		Util.skitPause();
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseUrbanBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You quickly realize that you are unable to defeate the Civil Control Mech\nin your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseUrbanBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After receiving another painful shock you finally realize that\nyou simply can't beat the Civil Control Mech.");
		Util.skitPause();
		System.out.println("In unbearable pain, you retreat as quickly as stunned limbs allow,\nhoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseUrbanBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Civil Control Mech!\nYou turn back, confident that nothing else lurks in the Urban area.");
		Util.skitPause();
	}
	public static void baseLabBoss() //intro to Lab boss COMPLETE
	{
		if(!labBoss)
		{
			Util.lineBreak();
			System.out.print("After destroying a fair lot of Malus' experiments and protection units\nyou find yourself in a large, circular room.");
			Util.skitPause();
			System.out.print("You suspect that something is amiss...\nand sure enough, a large door in the far wall opens to reveal a large mech!");
			Util.skitPause();
			System.out.print("It looks something like a Mantis...\nthough real Mantises surely don't have tons of weaponry equipped!");
			Util.skitPause();
			System.out.print("Its appearance doesn't matter though - you'll defeat it easily enough anyway!");
			Util.skitPause();
			System.out.println("And once you do... you'll be just one step closer to Malus!");
			Util.skitPause();
			labBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Prototype Mantis Crawler,\npositive that you'll absolutely demolish it this time!");
			Util.skitPause();
		}
	}
	public static void mantisCrawlerEmergency() //COMPLETE
	{
		System.out.print("After receiving sufficient damage much of the Mantis Crawler's\nbulkier armor suddenly falls off.");
		Util.skitPause();
		System.out.print("On first thought, this seems like a Godsend,\nbut in actuallity it allows the Mantis to move at much higher speeds!");
		Util.skitPause();
		System.out.println("That won't keep you from obliterating it, though!");
		Util.skitPause();
	}
	public static void baseLabBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("The Prototype Mantis Crawler crashes to the ground,\nits systems failing and causing a catastrophic overload.");
		Util.skitPause();
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseLabBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You rapidly realize that you can't defeat the Prototype Mantis Crawler\nin your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseLabBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After receiving another painful slash you finally realize that\nyou simply can't beat the Prototype Mantis Crawler.");
		Util.skitPause();
		System.out.println("In unprecedented pain, you retreat as quickly as sliced limbs allow,\nhoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseLabBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Prototype Mantis Crawler!\nYou turn back, confident that nothing else lurks in the Lab.");
		Util.skitPause();
	}
	public static void baseMilitaryBoss() //into to Military boss COMPLETE
	{
		if(!milBoss)
		{
			Util.lineBreak();
			System.out.print("After obliterating a great deal of Malus' mainstay force\nyou find yourself in a large barracks.");
			Util.skitPause();
			System.out.print("You suspect that something is amiss... and sure enough,\na large door in the far wall opens to reveal a large mech!");
			Util.skitPause();
			System.out.print("This one looks something like an insect...\nand appears to be by far more powerful than any of Malus' other mechs.");
			Util.skitPause();
			System.out.print("But its appearance doesn't matter - you'll defeat it easily enough!");
			Util.skitPause();
			System.out.println("And once you do... you'll be just one step closer to Malus!");
			Util.skitPause();
			milBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Insecti Crawler, sure that you'll defeat it this time!");
			Util.skitPause();
		}
	}
	public static void insectiCrawlerTransform() //COMPLETE
	{
		System.out.print("The Insecti Crawler takes a step back and then\nlets loose a metallic roar as some of its armor falls off.");
		Util.skitPause();
		System.out.print("It then reveals a new, more powerful set of weapons,\nand turns to face you, all of them actively targetting you!");
		Util.skitPause();
		System.out.println("But such a sight doesn't intimidate you...\nyou're prepared to defeat it, no matter its form!");
		Util.skitPause();
	}
	public static void insectiCrawlerEmergency() //also reveal its black hole cannon COMPLETE
	{
		System.out.print("Suddenly the Insecti Crawler seems to flare up -\nif it could properly display emotion then 'enraged' would be the most applicable.");
		Util.skitPause();
		System.out.print("It then pulls out a weapon that you haven't seen before...\nit appears to be a cannon, but unlike any other you've seen.");
		Util.skitPause();
		System.out.print("But wait... you remember reading something about a new-fangeld\n'black hole cannon' that scientists were working on... could this really be it?");
		Util.skitPause();
		System.out.print("It looks like what you imagined a Black Hole Cannon to look like...\nbut surely such a thing is impossible-!");
		Util.skitPause();
		System.out.println("Though as the cannon begins charging you decide you don't want to find out\nfirst-hand. You quickly back away, hoping to dodge whatever is thrown your way!");
		Util.skitPause();
	}
	public static void baseMilitaryBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.print("The Insecti Crawler fails and its Prototype Black Hole Cannon overloads,\ncausing the entire mech to implode on itself.");
		Util.skitPause();
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseMilitaryBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You speedily realize that you're unable to defeat the Insecti Crawler\nin your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseMilitaryBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.print("After receiving another critical blow you finally realize that\nyou simply can't beat the Insecti Crawler.");
		Util.skitPause();
		System.out.println("In uncomprehensible pain, you retreat as quickly as near-imploded\nbones allow, hoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseMilitaryBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Insecti Crawler!\nYou turn back, confident that nothing else lurks in the Military area.");
		Util.skitPause();
	}
	public static void malusBoss() //intro to Malus as a boss COMPLETE
	{
		if(!malBoss)
		{
			Util.lineBreak();
			System.out.print("You've fought through scorching desert... rolling plains...\nleafy forest... freezing mountains...\na burning volcano... dank caverns...");
			Util.skitPause();
			System.out.print("You reached Malus' base... you cleared out most of his forces...\nYou destroyed his four main guardian mechs...");
			Util.skitPause();
			System.out.println("And now... it's time to face Malus himself!");
			Util.skitPause();
			Util.bigLineBreak();
			System.out.println("You slowly walk down the pathways of Malus' base,\nattempting to discern his whereabouts.");
			Util.skitPause();
			System.out.println("Eventually you find yourself standing in what appears\nto be a courtyard nearly the size of two football fields.");
			Util.skitPause();
			System.out.println("Automatically weary of large, open spaces, you thoroughly\ninspect the area with your eyes before even considering crossing the courtyard.");
			Util.skitPause();
			System.out.println("And in doing so, your eyes alight on none other than Malus,\nstanding on the far battlements!");
			Util.skitPause();
			System.out.println("\"Well!\" he exclaims, jumping down to the courtyard,\n\"I'm surprised you actually made it this far!\nYou actually got to me before 24 hours were up!\"");
			Util.skitPause();
			System.out.println("\"Just another few hours and my plan would've been complete...\nI suppose I should've killed you back at the volcano, hm?\"");
			Util.skitPause();
			System.out.println("\"Ah... but that wouldn't have been any fun.\"\nMalus sneers, beginning to approach you slowly.\nAs he does so you can see the many armaments he's carrying.");
			Util.skitPause();
			System.out.println("\"I need only to destroy you right here...\nbarring that, at least hold you off for some time.\"");
			Util.skitPause();
			System.out.println("\"After the power of Ultima Chaos is mine...\" he clenches his fist dramatically,\n\"...no one will be able to stop me!\"");
			Util.skitPause();
			System.out.println("He then backs into a fighting stance, gesturing for you to come forward.\n\"For now, I'll just have to keep you busy! Come at me!!\"");
			Util.skitPause();
			System.out.println("Your brow furrowed, you quickly accept Malus' challenge.\nIt's time to defeat him once and for all!");
			Util.skitPause();
			Util.bigLineBreak();
			malBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print("\"Decided that you actually have the guts to try and fight me?\"\nMalus sneers, \"You've only got so much time!\"");
			Util.skitPause();
			System.out.println("\"Now... come at me!!\"");
			Util.skitPause();
		}
	}
	public static void malusFlee() //player fled from Malus COMPLETE
	{
		Util.lineBreak();
		System.out.print("\"You're giving up? Ha! I expected better!\"\nMalus shouts after your retreating form,\n\"Do you actually wish to defeat me? Or are you just screwing around?\"");
		Util.skitPause();
		System.out.println("\"Either way, you're on the clock!\nHurry back so I can have more fun destroying you!!\"");
		Util.skitPause();
	}
	public static void malusLose() //player loses to Malus COMPLETE
	{
		Util.lineBreak();
		System.out.print("\"Well, that was fun!\" Malus exclaims, strutting over to stand\nover your broken form, \"But... not enough!\"");
		Util.skitPause();
		System.out.print("\"I'll go ahead and let you live, since I'm bored...\nbut when you come back you had better be sure to be stronger!\"");
		Util.skitPause();
		System.out.println("With that you slowly and painfully pick yourself up, turning back the way\nyou came. You'll need to rest up and get stronger before fighting Malus again!");
		Util.skitPause();
	}
	public static void malusPhaseTwo() //intro to Malus' second phase COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"Huaargh!...\" Malus stumbles backward, holding a hand to his stomach in pain.\n\"Ooooh... you... you...!\"");
		Util.skitPause();
		System.out.println("You smirk, enjoying the sight of Malus having to face the fact that he lost.\nHis angrish is most amusing.");
		Util.skitPause();
		System.out.println("\"Damn it...\" he mutters,\n\"I'll... I'll just have to activate my plan earlier than planned...\"");
		Util.skitPause();
		System.out.println("Your expression quickly darkens; what's this about activating his plan early?\nIt doesn't sound good... raising your weapon, you intend to cut him down now.");
		Util.skitPause();
		System.out.println("But right as you go for the final blow the four towers at the corners of the\ncourtyard spontaneously begin to glow. The sudden distraction\ncauses you to miss, as well.");
		Util.skitPause();
		System.out.println("\"Yes... yes...!\" Malus slowly begins to grin as he regains his former,\narrogant stature, \"...the power of Ultima Chaos... I... can feel it!...\"");
		Util.skitPause();
		System.out.println("That's an alarming phrase. 'Ultima Chaos'? You have no idea what that is,\nbut it doesn't sound good - at least, not in Malus' hands.");
		Util.skitPause();
		System.out.println("Quickly, you again attempt to attack Malus - but when your attack connects,\ninstead of injuring him, a sudden sparkstorm kicks up\nand blows the two of you apart.");
		Util.skitPause();
		System.out.println("After recovering from the blow, you start to feel... oddly enough, rejuvenated!");
		Util.skitPause();
		System.out.println("\"...wha... what?!\" Malus exclaims as he realizes what just happened,\n\"...no! You just stole some of the Ultima Chaos!!\"");
		Util.skitPause();
		System.out.println("You still aren't sure what that means - and you doubt that you'll ever care -\nbut the fact that you seem to have foiled Malus's plans somewhat\nputs a smirk on your face.");
		Util.skitPause();
		System.out.println("\"Well... I'm still more powerful than you are,\" Malus muses,\n\"...if I kill you... then the power you stole should trasfer to me.\nAnd then... I'd have it all!\"");
		Util.skitPause();
		System.out.println("Now, you certainly don't like that logic. But as Malus begins to advance,\nyou realize that even if he doesn't have all the Ultima Chaos,\nhe still has plenty.");
		Util.skitPause();
		System.out.println("And plenty... is way too much. Malus is dangerous, very dangerous -\nand you may be the only one who can stop him!");
		Util.skitPause();
		System.out.println("You back into a battle stance, prepared to do battle once more.");
		Util.skitPause();
		System.out.println("\"Oh? So you actually plan to fight?\" Malus sneers,\n\"That'd almost be commendable if it weren't so stupid!\nI won't go easy this time... I'll destroy you!\"");
		Util.skitPause();
		System.out.println("His words certainly sound like the truth,\nbut that won't intimidate you! You aren't running!");
		Util.skitPause();
		System.out.println("\"...so you really wish to stay and fight?\"\nMalus shakes his head as if scolding a small child,\n\"Well, at least that makes my job easier... Anyway, it's time...\"");
		Util.skitPause();
		System.out.println("\"Time... to destroy you!!\"");
		Util.skitPause();
		Util.bigLineBreak();
	}
	public static void malusPhaseTwoLose() //player loses to Malus' second phase, also loses game outright COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving a critical blow you stumble backward and then\ncollapse to the ground, unable to summon the energy to move further.");
		Util.skitPause();
		System.out.println("\"Heh,\" Malus chuckles, slowly approaching you while letting\nhis hands sparkle with electricity, \"You finally lost.\"");
		Util.skitPause();
		System.out.println("\"You had a chance to start over every time you lost in the past, but...\"\nMalus moves his arm to direct his palm at your face.");
		Util.skitPause();
		System.out.println("\"This time, you won't. Good-bye... I'll be seeing you in the afterlife!\"");
		Util.skitPause();
		System.out.println("The next thing you see is a lightning strike, and then... nothing.");
		Util.skitPause();
		System.out.println("You died...");
		Util.skitPause();
		System.out.println("You lost!!");
		Util.skitPause();
		Util.bigLineBreak();
		System.out.println("Do wish to start the game over?");
		String yesNo = Util.yesNoLoop();
		if(yesNo.equalsIgnoreCase("Yes"))
		{
			Util.lineBreak();
			Setup.Introduction();
		}
		else
		{
			System.out.println("Hope you had a fun time playing the game... better luck next time!");
			Util.lineBreak();
		}
	}
	public static void malusBeaten(String pN) //player defeated Malus COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"Ungh...!\" Malus collapses to the ground, taking in shallow, ragged breaths.\n\"I... I... ...lost?!\"");
		Util.skitPause();
		System.out.println("\"How... can that... be?!...\" he splutters,\nand then attempts to stand back up, only to fail.");
		Util.skitPause();
		System.out.println("You simply watch on, feeling no sympathy for the villain.");
		Util.skitPause();
		System.out.println("\"Urgh... agh... no... my power... it's... leaving...!\"\nMalus groans; almost immediately afterward he begins glowing a dark red.");
		Util.skitPause();
		System.out.println("Before you can react it almost appears that a huge, spectacular\nenergy explosion ignites from Malus. The second afterward he's no longer glowing.");
		Util.skitPause();
		System.out.println("On top of that... he seems to have aged a great deal... and is still alive!");
		Util.skitPause();
		System.out.println("\"Come...\" he barely mutteres, managing to manipulate one\nof his fingers to gesture for you. Cautiously, you approach.");
		Util.skitPause();
		System.out.println("\"You...\" he starts, \"I... I never... got... your name...\"");
		Util.skitPause();
		System.out.println("You smirk. He's clearly dying; you may as well allow\nhim to know the name of his superior before he does.");
		Util.skitPause();
		System.out.println("\"My name... is " + pN + ",\" you quietly state.");
		Util.skitPause();
		System.out.println("\"" + pN + "... not bad...\" Malus mutters, and then closes\nhis eyes, \"" + pN + "... it... was nice knowing you... ...\"");
		Util.skitPause();
		System.out.println("...he's dead. You slowly crouch down and close his eyelids\nbefore turning to leave. Malus is now defeated... your adventure is over!");
		Util.skitPause();
		Util.bigLineBreak();
	}
	public static void gameWon(Player p) //game has been beaten; player can still play though COMPLETE
	{
		Util.lineBreak();
		System.out.println("Congratulations! You have beaten the game!");
		System.out.println("Your final stats are as follows:");
		p.showAll();
		Util.skitPause();
		Util.lineBreak();
		System.out.println("However, you can continue to play the game if you wish. Have fun!");
		Util.skitPause();
	}
	public static void gameBeat() //if game has been beaten and player goes to the base COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated Malus... what else do you want?\nSheesh! There's nothing here, turn around!");
		Util.skitPause();
	}
	public static void ultimaMalusBattleQuotes(double maxHP, double curHP) //parameters: maxHealth,currentHP (in that order) COMPLETE
	{
		//Add "Malus: " before each phrase (so player knows it's Malus speaking... though I don't know who else would be)
		//quote cycle for 100% - 33% health
		if(curHP>(maxHP/3))
		{
			malusQuoteCounter++;
			switch(malusQuoteCounter)
			{
				case 1:
					System.out.println("Malus: \"Do you really think you can beat me? Ha! Don't make me laugh!\"");
					break;
				case 2:
					System.out.println("Malus: \"Your attacks mean nothing!\"");
					break;
				case 3:
					System.out.println("Malus: \"If you think you can win...\n\tthen you aren't nearly as intelligent as I thought!\"");
					break;
				case 4:
					System.out.println("Malus: \"Haha! That's right, squirm!!\"");
					break;
				case 5:
					System.out.println("Malus: \"Ultima Chaos is on my side... the puny amount you hold means nothing!\"");
					malusQuoteCounter = 0;
					break;
			}
			Util.skitPause();
		}
		//quote cycle for 33% - 10% health
		else if(curHP<(maxHP/3) && curHP>(maxHP/10))
		{
			malusQuoteCounter++;
			switch(malusQuoteCounter)
			{
				case 1:
					System.out.println("Malus: \"Hmm, not bad, not bad... but not good enough!\"");
					break;
				case 2:
					System.out.println("Malus: \"You've got my respect...\n\ttoo bad you won't live long enough to tell the tale!\"");
					break;
				case 3:
					System.out.println("Malus: \"As if I could lose to you...!\"");
					break;
				case 4:
					System.out.println("Malus: \"Your Ultima Chaos... it can't hold a candle to mine...!\"");
					malusQuoteCounter = 0;
					break;
			}
			Util.skitPause();
		}
		//quote cycle for 10% - 0% health
		else
		{
			malusQuoteCounter++;
			switch(malusQuoteCounter)
			{
				case 1:
					System.out.println("Malus: \"Time to step it up! Take this!\"");
					break;
				case 2:
					System.out.println("Malus: \"No... I can't be losing! I'm Malus, future overlord of the world!\n\tI WILL win!!\"");
					break;
				case 3:
					System.out.println("Malus: \"Why. Won't. You. Just. DIE?!\"");
					malusQuoteCounter = 0;
					break;
			}
			Util.skitPause();
		}
	}
	public static String getAll()
	{
		/*
		 * Returns a String with each character corresponding to a variable.
		 */
		String data = "";
		
		data = data + String.valueOf(malusQuoteCounter);
		data = data + String.valueOf(placeQuoteCounter);
		
		data = desBoss ? data + "1" : data + "0";
		data = plaBoss ? data + "1" : data + "0";
		data = forBoss ? data + "1" : data + "0";
		data = mounBoss ? data + "1" : data + "0";
		data = volBoss ? data + "1" : data + "0";
		data = cavBoss ? data + "1" : data + "0";
		data = facBoss ? data + "1" : data + "0";
		data = urbBoss ? data + "1" : data + "0";
		data = labBoss ? data + "1" : data + "0";
		data = milBoss ? data + "1" : data + "0";
		data = malBoss ? data + "1" : data + "0";
		
		return data;
	}
	public static void setAll(String data)
	{
		/*
		 * Ternary operators FTW
		 */
		malusQuoteCounter = Integer.parseInt(data.substring(0,1));
		placeQuoteCounter = Integer.parseInt(data.substring(1,2));
		
		desBoss = data.charAt(2) == '1' ? true : false;
		plaBoss = data.charAt(3) == '1' ? true : false;
		forBoss = data.charAt(4) == '1' ? true : false;
		mounBoss = data.charAt(5) == '1' ? true : false;
		volBoss = data.charAt(6) == '1' ? true : false;
		cavBoss = data.charAt(7) == '1' ? true : false;
		facBoss = data.charAt(8) == '1' ? true : false;
		urbBoss = data.charAt(9) == '1' ? true : false;
		labBoss = data.charAt(10) == '1' ? true : false;
		milBoss = data.charAt(11) == '1' ? true : false;
		malBoss = data.charAt(12) == '1' ? true : false;
	}
}