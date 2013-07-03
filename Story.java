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
			System.out.println("\"Hmm... is this it? ...why yes... yes it is!...\"");
			System.out.println("\"Finally, my search is complete! Now I need only to find a way to properly utilize this power...\"");
			System.out.println("\"Yes... after a mere weeks' time, I, Malus, will control the power of Ultima Chaos...!\"");

			Util.bigLineBreak();
			Util.skitPause();

			System.out.println("Something doesn't feel right... your sixth sense is telling you that some danger, some sort of evil, looms in the air.");
			System.out.println("But, you don't quite know what.");
			System.out.println("Such a trivial fact doesn't deter your heroic responsibilities, however. Quickly you prepare for a new adventure.");
			System.out.println("You then step outside, and try to feel for where the evil is...");
			System.out.println("...and fail utterly. So instead, you head to the nearest town, hoping to find your way from there.");

			Util.lineBreak();
			Util.skitPause();

			System.out.println("Once at the town, you see an Inn, several markets, and the desert beyond that.");
			System.out.println("With a slight smirk, you set off, hoping to stop whatever evil lurks over the land.");

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
			System.out.println("You arrive at the desert past the town with a level of dread; deserts are far from comfortable environments, after all.");
			System.out.println("But this is the beginning of the adventure; surely other locales will be more welcoming?");
			System.out.println("Either way, you set your jaw and look forward, ready to defeat anything that comes your way!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(d)
		{
			Util.lineBreak();
			System.out.println("The desert's a quieter place with the Sand Stone eradicated. ...at least, the second path is open to the plains.");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You have arrived at the desert, ready to once again search for the evil that lurks within.");
		}
	}
	public static void desertPathOne() //end of path one, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... disappointed, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void desertPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... annoyed, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void desertBoss() //intro to desert boss COMPLETE
	{
		if(!desBoss)
		{
			Util.lineBreak();
			System.out.println("Ah! There, off in the distance - it's plains!");
			System.out.println("Excited to finally be past the horrid desert heat, you speed up your pace, hoping that you at least won't get dirt in your eyes on the plains.");
			System.out.println("However, before you can get very far a sudden sandstorm whips up, nearly blinding you and concealing the plains behind a curtain of sand.");
			System.out.println("You quickly adjust to the sand, though the first thing you spot is a floating, sand-colored stone.");
			System.out.println("Even though it has no eyes, it seems as if it's glaring down at you contemptuously, laughing at your plight.");
			System.out.println("Obviously, it must be the source of the sandstorm! ...though even if it isn't, destroying it could offer some solace.");
			System.out.println("But nevermind the details; it's time for battle!");
			Util.skitPause();
			desBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to face off with the Sand Stone, prepared to offer it the beat down that it prevented you from giving last time!");
			Util.skitPause();
		}
	}
	public static void desertBossEmergency() //desert boss goes into emergency mode COMPLETE
	{
		System.out.println("Before the Sand Stone attacks again, it seems to almost rear up into the air.");
		System.out.println("Immediately after doing so the sand storm around you intensifies. It would appear that you've succeeded in making it angry!");
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void desertBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("With a final blow you shatter the Sand Stone to millions of tiny pieces, each disappearing into the very sandstorm the stone conjured.");
		System.out.println("Now that the Sand Stone is no more, the sandstorm begins to subside - soon, the plains become visible once again.");
		System.out.println("And with a closer look, you see a forest beyond the plains, and a distant mountain range beyond that.");
		System.out.println("It looks like it could be bothersome to trek through all that terrain, but you can't shake off this feeling of lurking evil.");
		System.out.println("So with an intrepid step you continue your journey onward, hoping that you'll have more of an idea as to what this evil is before long.");
		Util.skitPause();
	}
	public static void desertBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("Realizing that you aren't strong enough to defeat the Sand Stone, you turn and high-tail it out of there.");
		System.out.println("You won't be able to get to the Plains this way... you'll have to get stronger!");
		Util.skitPause();
	}
	public static void desertBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("Your ability to correctly estimate your own, well, abilities, is severely lacking.");
		System.out.println("With this defeat you trudge back to the town, battered and nearly in pieces;");
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
			System.out.println("Finally, you step onto ground that isn't unstable, uncomfortable sand. You breath a sigh of relief; even the air is more comfortable.");
			System.out.println("But the sun is still an issue - there's no cover or shade in the Plains. And the enemies are bound to be more difficult as well.");
			System.out.println("Either way, you prepare to continue your adventure.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(p)
		{
			Util.lineBreak();
			System.out.println("The plains are a safer place, now that you're eradicated the Grass Stone in the hills.");
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
		System.out.println("There's nothing here... exhausted, you turn back toward the way from which you came.");
		Util.skitPause();
	}
	public static void plainsGrasslandsPath() //end of grasslands path, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... irritated, you turn back toward the way from which you came.");
		Util.skitPause();
	}
	public static void plainsBoss() //intro to plains boss COMPLETE
	{
		if(!plaBoss)
		{
			Util.lineBreak();
			System.out.println("As you progress through the hills you note that you're almost upon the forest;");
			System.out.println("While not exactly overjoyed, you're certainly happy that the next stage of your adventure is near complete.");
			System.out.println("However, before you're able to reach the treeline the grass beneath you suddenly becomes very stiff and sharp;");
			System.out.println("With a yelp of pain, you leap back, glaring at the offending plants. Soon, though, the real culprit reveals itself: a levitating green stone.");
			System.out.println("It bears a remarkable resemblance to the Sand Stone... maybe by destroying it, you'll be able to access the forest!");
			System.out.println("You quickly prepare for battle, ready to destroy the mysterious green stone!");
			Util.skitPause();
			plaBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to face off with the Grass Stone, prepared to defeat it like it defeated you last time!");
			Util.skitPause();
		}
	}
	public static void plainsBossEmergency() //plans boss goes into emergency mode COMPLETE
	{
		System.out.println("Before the Grass Stone attacks again, it seems to almost rear up into the air.");
		System.out.println("Immediately after doing so the grass around you is uprooted and rises into the air, surrounding the Grass Stone.");
		System.out.println("It would appear that you've succeeded in making it angry!");
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void plainsBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("With a final blow you shatter the Grass Stone to a million tiny pieces, each disappearing into the grass it once controlled.");
		System.out.println("Finally the grass settles, allowing you passage over the remaining hills without your feet being impaled.");
		System.out.println("You cautiously cross the remaining distance (in case there are any more enemies) but reach the forest unharmed.");
		System.out.println("This close to the forest, it's impossible to see anything past it - but you know that the mountains are there, and beyond them, a great evil.");
		System.out.println("With the same determination as before you head into the forest, prepared to face anything that's thrown your way.");
		Util.skitPause();
	}
	public static void plainsBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("Realizing that you aren't strong enough to defeat the Grass Stone, you quickly turn tail and leave.");
		System.out.println("You'll have to be stronger before you can hope to defeat it!");
		Util.skitPause();
	}
	public static void plainsBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After recieving a critical hit you finally realize that you aren't strong enough to fight the Grass Stone.");
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
			System.out.println("So you've finally made it to the shade of the forest. The sun's no longer an issue; no more sunburns for you!");
			System.out.println("However, this forest looks a tad spookier on the inside than the out - there's bound to be tons of enemies here.");
			System.out.println("You quickly gear up - there's still a lot to fight through in front of you!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(f)
		{
			Util.lineBreak();
			System.out.println("The forest seems a more peaceful place now that the Leaf Stone is destroyed. On top of that, the third path is open to the mountains!");
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
		System.out.println("There's nothing here... tired, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void forestPathTwo() //end of path two, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... cross, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void forestBoss() //intro to forest boss COMPLETE
	{
		if(!forBoss)
		{
			Util.lineBreak();
			System.out.println("After dodging past the next tree, you spot a sliver of light, brighter than any location within the forest.");
			System.out.println("You conclude that it must be the treeline - you're at a higher altitude than when you first entered the forest, anyway.");
			System.out.println("However, before you can get much closer to the light all of the leaves around you suddenly come to life.");
			System.out.println("Swirling around you, they begin to lacerate your skin one by one; not wanting to die by 1000 papercuts, you quickly jump out of the vortex.");
			System.out.println("Now outside of the leaves, you see a floating, dark green stone behind it. It looks rather similar to the Sand and Grass Stones.");
			System.out.println("Realizing this, you prepare to take it down, hoping to clear the way to the end of the forest!");
			Util.skitPause();
			forBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Leaf Stone, this time prepared to destroy it like the two Stones before it!");
			Util.skitPause();
		}
	}
	public static void forestBossEmergency() //COMPLETE
	{
		System.out.println("Before the Leaf Stone attacks again, it seems to almost rear up into the air.");
		System.out.println("Immediately after doing so the leaf storm in front of you intensifies. It would appear that you've succeeded in making it angry!");
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void forestBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("You land a final, critical hit on the Leaf Stone, shattering it into a million pieces, each landing amongst the leaves they once controlled.");
		System.out.println("With nothing more in your way, you make your way to the edge of the forest.");
		System.out.println("Once you emerge at the treeline you find that you're now in the mountains, with a Volcano barely visible among the mountains in the distance.");
		System.out.println("Before you set off to continue adventuring, though, you think back to the three Stones you've beaten: the Sand, Grass, and now, Leaf Stone.");
		System.out.println("They can't be coincidences... Stones like those just aren't natural. And neither are several of the enemies you've encountered.");
		System.out.println("Not to mention all those robots and drones you've defeated! Someone, or something, must be behind this. ...likely the very evil you're chasing.");
		System.out.println("With that thought you continue onward, resolving to find and defeat this evil!");
		Util.skitPause();
	}
	public static void forestBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("Recognizing the gap in capability between you and the Leaf Stone, you quickly pull out, turning your back to it and running.");
		System.out.println("You'll need to be stronger if you hope to defeat the Leaf Stone!");
		Util.skitPause();
	}
	public static void forestBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving a critical hit you realize that you simply aren't strong enough to take on the Leaf Stone.");
		System.out.println("You disengage and manage to crawl back to town, hoping to recuperate before heading out once more.");
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
			System.out.println("Now in the mountains, you notice a certain biting coolness that wasn't present before (and certainly not in the desert).");
			System.out.println("You may not have the shade that the forest offered, but the lack of heat makes up for it.");
			System.out.println("After taking a second to gaze upon the beauty of the mountains you gear up, prepared to continue your adventure.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(m)
		{
			Util.lineBreak();
			System.out.println("With the Blizzard Stone defeated, the biting sensation that came with the coolness is now gone. Plus, path 1 is open to the Village.");
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
		System.out.println("There's nothing here... bitter, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void mountainsPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... exasperated, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void mountainsBoss() // intro to mountains boss COMPLETE
	{
		if(!mounBoss)
		{
			Util.lineBreak();
			System.out.println("You've been constantly approaching the Volcano through the mountain range, and now you need only to clear one more peak.");
			System.out.println("You can see a village at the peak; it would be an excellent place to rest-up before venturing toward the Volcano itself.");
			System.out.println("However, before you can even reach it the snow all around you suddenly kicks up into a blinding Blizzard!");
			System.out.println("This isn't the first time the environment has risen against you, though.");
			System.out.println("Expecting a Stone to be behind these shinanigans, you slowly comb the area until you spot a hovering silhouette in the distance.");
			System.out.println("It must be the offending Stone - pulling out your weapon, you approach even quicker, prepared to take it down!");
			Util.skitPause();
			mounBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Blizzard Stone, this time prepared to obliterate it like no other!");
			Util.skitPause();
		}
	}
	public static void mountainsBossEmergency() //COMPLETE
	{
		System.out.println("Before the Sand Stone attacks again, it seems to almost rear up into the air.");
		System.out.println("Immediately after doing so the snow storm around you intensifies. It would appear that you've succeeded in making it angry!");
		System.out.println("But you can't lose now; you've almost won!");
		Util.skitPause();
	}
	public static void mountainsBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("You land a final critical hit on the Blizzard Stone, shattering it into a million pieces, each disappearing into the Blizzard it created.");
		System.out.println("Slowly, the weather calms down, until you can once again see the sky - and also the village.");
		System.out.println("As you approach the village, you think back to the four Stones you've defeated: Sand, Grass, Leaf, and Blizzard.");
		System.out.println("Is there a connection? You believe that there must be one, but what it is, you aren't quite sure.");
		System.out.println("Maybe you'll find some answers in or near the Volcano... after stopping at the village, of course.");
		Util.skitPause();
	}
	public static void mountainsBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("The gap in ability between you and the Blizzard Stone is simply too large. You quickly stage a tactical retreat.");
		System.out.println("You'll need to be stronger if you hope to defeat the Blizzard Stone!");
		Util.skitPause();
	}
	public static void mountainsBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After nearly getting frostbitten for the nth time, you recognize that there's an incomprehensible gap in ability between you and the Blizzard Stone.");
		System.out.println("Managing to escape the Stone's influence, you limp back to town, wishing for a nice cup of hot cocoa and maybe life insurance.");
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
			System.out.println("You finally reach the village, a safe-haven for you during your adventures.");
			System.out.println("Looking around, you realize that it isn't as nicely equipped as the town - there's no healing or special attack market - but at least there's an inn.");
			System.out.println("You then step into the village, hoping to better prepare yourself for further adventuring.");
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
			System.out.println("You near the base of the volcano and can already feel the heat; it's even more uncomfortable than the desert.");
			System.out.println("You aren't sure what you'll find here - or even what you're doing here - but you can sense the evil even stronger than before.");
			System.out.println("So, obviously, you must be going in the correct direction... right?");
			System.out.println("Well, you hope to find an answer at the volcano anyways, and thus prepare to withstand the heat and defeat any enemies that present themselves.");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(v)
		{
			Util.lineBreak();
			System.out.println("You arrive at the volcano, which is still pretty damn hot, but at least the Wyvern is defeated and path 1 is open to the caverns.");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to the volcano, trying your best to withstand the heat while seeking out answers to your quest(ions).");
		}
	}
	public static void volcanoPathTwo() //end of path two, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here, besides far too much magma... vexed, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void volcanoPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... irked, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void volcanoBoss() // intro to volcano boss COMPLETE
	{
		if(!volBoss)
		{
			Util.lineBreak();
			System.out.println("As you walk around the base of the Volcano you spot a cave that isn't flooded with lava. Curious, you begin to approach.");
			System.out.println("\"Halt right there!\"");
			System.out.println("Startled, you pause and look about. Your eyes soon land on an armored individual to your side, holding a gun in your direction!");
			System.out.println("The sense of danger and evil you felt at the beginning of your adventure suddenly overwhelms you. Certainly, this person is the source!");
			System.out.println("But at your current ability level there's no way you could defeat him. However any further thought is cut off as the individual begins to speak.");
			System.out.println("\"Ah, another one of those hardy adventure types, hoping to defeat me, is that it?\" he smirks, \"Pft. As if I could lose to the likes of you!\"");
			System.out.println("You take a step back; if this man intends to attack you, then you intend to retreat. As fast as humanly possible.");
			System.out.println("\"Hmm... you're scared of me. I can see that you're intelligent enough to recognize my power,\" the man comments, \"...perhaps I won't kill you now.\"");
			System.out.println("He then takes a step back and taps his wrist - it looks as if he's typing something - and then looks back to you.");
			System.out.println("\"Instead...\" he sneers, as a giant, flying robot swoops down behind him, \"I'll pit you against this Boss Class Aerial 'Bot.\"");
			System.out.println("Suddenly, the ground below you shudders and begins rising into the air, revealing itself to be a large, levitating metal platform!");
			System.out.println("With apprehension you turn to look down at the man, only to see the robot flying up at you and the man shouting after it:");
			System.out.println("\"Wyvern... destroy this pest!\"");
			Util.skitPause();
			volBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("\"So you actually returned, eh?\" Malus sneered, gesturing for the BCA Wyvern to approach you. \"I simply thought you had taken the coward's way out!\"");
			System.out.println("You back into a battle stance, unfazed by Malus' taunts. Time time... you'll defeat his Wyvern!");
			Util.skitPause();
		}
	}
	public static void wyvernBossEmergency() //COMPLETE
	{
		System.out.println("With a mechanical screech the Wyvern launches into the air, coming to a stop and hovering a fair distance over the platform.");
		System.out.println("It then pulls its tail down between its legs, as if its pointing at you, and then - a spike suddenly appears on the tip!");
		System.out.println("For it to pull a trick out of its sleeve... you must be fairly close to defeating it.");
		System.out.println("With that thought, your expression hardens - you're ready for anything its about to throw at you!");
		Util.skitPause();
	}
	public static void volcanoBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("You land a final critical blow on the Wyvern, and then step back and watch as it explodes and falls to pieces, thoroughly destroyed and unsalvageable.");
		System.out.println("\"Hmm... not bad, not bad,\" the man nods, as the platform you are on starts lowering to the ground, \"though still not strong enough to beat me.\"");
		System.out.println("\"You could actually be entertaining to me...\" he comments as he engages a jetpack attached to his back, \"Yes... I like the sound of that.\"");
		System.out.println("\"I have nothing else to do currently, anyway.\" You simply stand back and watch as he lifts off the ground, not sure what to think of the moment.");
		System.out.println("\"Ah, but before I go,\" the man adds, \"I think I'll go ahead and allow you to know my name... the name of your superior, in all ways!\"");
		System.out.println("\"I am Malus... future overlord of the world!!\"");
		Util.skitPause();
		Util.lineBreak();
		System.out.println("So... Malus. He's the evil you first sensed. With his aura... his claims to future overlord-hood may be justified.");
		System.out.println("You quickly deduce that you have to defeat him... though you aren't ready to face him yet. You need to find his lair first anyway.");
		System.out.println("There's no readily available pathway around the volcano... the only path you can see is the cavern, no longer blocked by Malus or a robot.");
		System.out.println("For now, it'll have to do. Hopefully, it will lead you one step closer to Malus' location!");
		Util.skitPause();
	}
	public static void volcanoBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"Ha ha ha, that's what I thought!\" Malus shouts after your retreating form, \"You aren't strong enough to face me! At all!\"");
		System.out.println("Well, as annoying as he might be, Malus is right about one thing: you need to be stronger. Heading back, you intend to do just that.");
		Util.skitPause();
	}
	public static void volcanoBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"AH ha ha ha ha!!\" Malus laughs loud and long as you fall to the ground, almost every bone in your body broken.");
		System.out.println("\"You aren't strong enough to face me, and you never will be,\" he sneers, and then turns away with the Wyvern.");
		System.out.println("\"I'll let you live, for now. Maybe you'll serve as a lesson for others who ignorantly wish to face me!\"");
		System.out.println("As he leaves the scene you slowly begin to crawl back to the village...");
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
			System.out.println("As you walk through the cavern under the volcano, you note that it isn't becoming hot. In fact, it's actually getting colder.");
			System.out.println("That defeats all logic... technically, you should have reached a lava flow by now!");
			System.out.println("You continue down the caves... and a thought pops into your head: What if this geographic phenomonon was created by Malus?");
			System.out.println("If so, then he must have a great deal of resources and time on his side... but it also means that you're likely close to his base!");
			System.out.println("It's time to up the ante. You resolutely decide to blast through the caves and find Malus' base, and then stop him!");
			System.out.println("...easier said than done. ...well, time to find your way through the caves!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(c)
		{
			Util.lineBreak();
			System.out.println("You've already defeated the BCG Cerberus... time to head through path 2 to Malus' base!");
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to the caverns, prepared to continue your search for the path to Malus' base.");
		}
	}
	public static void cavernsPathOne() //end of path one, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("Even after all those damn rocks, there's nothing here... fatigued, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void cavernsPathThree() //end of path three, nothing there COMPLETE
	{
		Util.lineBreak();
		System.out.println("There's nothing here... enervated, you turn back toward the way you came.");
		Util.skitPause();
	}
	public static void cavernsBoss() // intro to caverns boss COMPLETE
	{
		if(!cavBoss)
		{
			Util.lineBreak();
			System.out.println("You round another corner, finding yourself in a rather large cavern. Weary of locales of such size, you cautiously make your way to the other side.");
			System.out.println("But your caution is to no avail. Previously unknown to you, one of the walls is actually a door - and through it bursts a large robot!");
			System.out.println("It looks like a huge dog... surely, this is one of Malus' creations. And if it is... then you must be getting closer to his base!");
			System.out.println("You back into a battle stance, prepared to take on robot!");
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
		System.out.println("The Cerberus rears up and lets loose an electronic roar; upon doing so you can see various small internal fires.");
		System.out.println("It's almost destroyed... and it seems to know that. You harden your stance, prepared for whatever the Cerberus is about to do!");
		Util.skitPause();
	}
	public static void cavernsBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("After suffering a final critical blow the Cerberus shuts down catastrophically... that is, it explodes.");
		System.out.println("With that obstacle out of your way, you're now ready to move on, one step close to Malus' base!");
		Util.skitPause();
	}
	public static void cavernsBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("The way this battle is going, you'll never win. Recognizing this, you quickly pull out.");
		System.out.println("You'll need to get stronger before you can pass the Cerberus!");
		Util.skitPause();
	}
	public static void cavernsBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You suffer a critical blow at the hands of the Cerberus...");
		System.out.println("Your body broken, you somehow manage to disengage from the Cerberus and begin your long, painful trek back to the village.");
		System.out.println("With battles ending like that you'll *have* to get stronger before you can even think about reaching Malus' base!");
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
			System.out.println("You emerge from the caverns to find yourself in a completely unknown locale. Everything around you looks industrial...");
			System.out.println("\"Ah, so you finally arrived!\"");
			System.out.println("You look up, though you have no need - you already know the identity of the speaker.");
			System.out.println("\"I must say, well done!\" Malus smirks from his position atop a nearby building, \"Defeating both the Wyvern and the Cerberus... impressive!\"");
			System.out.println("\"But you still aren't at my level! And if you don't defeat me within the next 24 hours... then you never will be!!\"");
			System.out.println("He then jumps into the air and engages his jet pack, flying backward into the industrial complex. \"Good luck reaching me before then!\"");
			System.out.println("You watch him leave, and then what he says hits you. 24 hours? What could possibly happen after that...?");
			System.out.println("Well, you at least know you don't want to find out. All you know is that you're standing at the entrance to Malus' domain...");
			System.out.println("...and it's time to kick some ass!!");
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(f || u  || l  || m)
		{
			Util.lineBreak();
			System.out.println("You've destroyed some of Malus' mechanical minions... but you've yet to destroy them all. It's time to remedy that situation.");
			System.out.print("Beaten bosses: ");
			if(f)
			{
				System.out.print("Incomplete Bug Crawler(Factory)");
				if(u || l || m)
					System.out.print(", ");
			}
			if(u)
			{
				System.out.print("Civil Control Mech(Urban)");
				if(l || m)
					System.out.print(", ");
			}
			if(l)
			{
				System.out.print("Prototype Mantis Crawler(Lab)");
				if(m)
					System.out.print(", ");
			}
			if(m)
			{
				System.out.print("Insecti Crawler(Military)");
			}
			System.out.print("\n");
			Util.skitPause();
		}
		else if(b)
		{
			Util.lineBreak();
			System.out.println("With Malus dead, his base has fallen into a state of disrepair. No more evil lurks here... though his minions still do.");
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
			System.out.println("After fighting through Malus' construction and production facilities you find yourself in a large hanger.");
			System.out.println("You suspect that something is amiss... and sure enough, a large door in the back opens to reveal a large mech!");
			System.out.println("It appears to almost be a cross between a spider and a dog... but its appearance doesn't matter. You plan to defeat it no matter what!");
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
		System.out.println("The Bug Crawler lets loose a metallic roar and then flaps its wings strongly, apparently attempting to put out the many fires on its wings.");
		System.out.println("It then zooms in close, evidentally prepared to unleash some ferocious attack.");
		System.out.println("But it doesn't intimidate you... you stand back and plant your feet, ready to face the robot's mad charge!");
		Util.skitPause();
	}
	public static void bugCrawlerTransform() //COMPLETE
	{
		System.out.println("Suddenly the Bug Crawler dives down toward the ground, coming to a stop just before it hits.");
		System.out.println("It lands with a metallic crash and then discards its wings; surprised, you back off a bit, not sure how to react.");
		System.out.println("But the Crawler evidentally isn't destroyed yet, so you set yourself back into a battle stance, prepared to utterly obliterate it!");
		Util.skitPause();
	}
	public static void baseFactoryBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("The Bug Crawler collapses to the ground, overloading and shutting down after the beat down you offered it.");
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseFactoryBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You soon realize that you can't defeat the Bug Crawler in your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseFactoryBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving another critical blow you finally realize that you simply can't beat the Bug Crawler.");
		System.out.println("In massive pain, you retreat as quickly as broken bones allow, hoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseFactoryBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Bug Crawler! You turn back, confident that nothing else lurks in the factory.");
		Util.skitPause();
	}
	public static void baseUrbanBoss() //intro to urban boss COMPLETE
	{
		if(!urbBoss)
		{
			Util.lineBreak();
			System.out.println("After walking through what may be the most un-populated city you've ever seen, you find yourself in a large parking lot surrounding by buildings.");
			System.out.println("You suspect that something is amiss... and sure enough, a large, nearby garage door opens to reveal a large mech!");
			System.out.println("It doesn't appear too impresive, but it certainly has guns equipped... though that doesn't matter. You plan to defeat it no matter way!");
			System.out.println("And once you do... you'll be just one step closer to Malus!");
			Util.skitPause();
			urbBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Civil Control Mech, confident in your ability to smash it this time!");
			Util.skitPause();
		}
	}
	public static void civilMechEmergency() //COMPLETE
	{
		System.out.println("Seemingly fed up with its attacks failing, the Civil Control Mech takes a step back and then opens a hidden hatch on its front side.");
		System.out.println("And out of it... emerges an Alpha Cannon!");
		System.out.println("Seeing that the mech seems to have finally resorted to actual force, you decide to do the same - otherwise known as smashing it into smithereens!");
		Util.skitPause();
	}
	public static void baseUrbanBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("The Civil Control Mech crumbles to the ground, overloading and shutting down permanently.");
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseUrbanBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You quickly realize that you are unable to defeate the Civil Control Mech in your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseUrbanBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving another painful shock you finally realize that you simply can't beat the Civil Control Mech.");
		System.out.println("In unbearable pain, you retreat as quickly as stunned limbs allow, hoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseUrbanBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Civil Control Mech! You turn back, confident that nothing else lurks in the Urban area.");
		Util.skitPause();
	}
	public static void baseLabBoss() //intro to Lab boss COMPLETE
	{
		if(!labBoss)
		{
			Util.lineBreak();
			System.out.println("After destroying a fair lot of Malus' experiments and protection units you find yourself in a large, circular room.");
			System.out.println("You suspect that something is amiss... and sure enough, a large door in the far wall opens to reveal a large mech!");
			System.out.println("It looks something like a Mantis... though real Mantis' surely don't have tons of weaponry equipped!");
			System.out.println("Its appearance doesn't matter though - you'll defeat it easily enough anyway!");
			System.out.println("And once you do... you'll be just one step closer to Malus!");
			Util.skitPause();
			labBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("You return to battle the Prototype Mantis Crawler, positive that you'll absolutely demolish it this time!");
			Util.skitPause();
		}
	}
	public static void mantisCrawlerEmergency() //COMPLETE
	{
		System.out.println("After receiving sufficient damage much of the Mantis Crawler's bulkier armor suddenly falls off.");
		System.out.println("On first thought, this seems like a Godsend, but in actuallity it allows the Mantis to move at much higher speeds!");
		System.out.println("That won't keep you from obliterating it, though!");
		Util.skitPause();
	}
	public static void baseLabBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("The Prototype Mantis Crawler crashes to the ground, its systems failing and causing a catastrophic overload.");
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseLabBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You rapidly realize that you can't defeat the Prototype Mantis Crawler in your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseLabBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving another painful slash you finally realize that you simply can't beat the Prototype Mantis Crawler.");
		System.out.println("In unprecedented pain, you retreat as quickly as sliced limbs allow, hoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseLabBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Prototype Mantis Crawler! You turn back, confident that nothing else lurks in the Lab.");
		Util.skitPause();
	}
	public static void baseMilitaryBoss() //into to Military boss COMPLETE
	{
		if(!milBoss)
		{
			Util.lineBreak();
			System.out.println("After obliterating a great deal of Malus' mainstay force you find yourself in a large barracks.");
			System.out.println("You suspect that something is amiss... and sure enough, a large door in the far wall opens to reveal a large mech!");
			System.out.println("This one looks something like an insect... and appears to be by far more powerful than any of Malus' other mechs.");
			System.out.println("But its appearance doesn't matter - you'll defeat it easily enough!");
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
		System.out.println("The Insecti Crawler takes a step back and then lets loose a metallic roar as some of its armor falls off.");
		System.out.println("It then reveals a new, more powerful set of weapons, and turns to face you, all of them actively targetting you!");
		System.out.println("But such a sight doesn't intimidate you... you're prepared to defeat it, no matter its form!");
		Util.skitPause();
	}
	public static void insectiCrawlerEmergency() //also reveal its black hole cannon COMPLETE
	{
		System.out.println("Suddenly the Insecti Crawler seems to flare up - if it could properly display emotion then 'enraged' would be the most applicable.");
		System.out.println("It then pulls out a weapon that you haven't seen before... it appears to be a cannon, but unlike any other you've seen.");
		System.out.println("But wait... you remember reading something about a new type of 'black hole cannon' that scientists were working on... could this really be it?");
		System.out.println("It looks like what you imagined a Black Hole Cannon to look like... but surely such a thing is impossible-!");
		System.out.println("Though as the cannon begins charging you decide you don't want to find out first-hand. You quickly back away, hoping to dodge whatever is thrown your way!");
		Util.skitPause();
	}
	public static void baseMilitaryBossBeaten() //after the boss is defeated COMPLETE
	{
		Util.lineBreak();
		System.out.println("The Insecti Crawler fails and its Prototype Black Hole Cannon overloads, causing the entire mech to implode on itself.");
		System.out.println("That's one of Malus' mechs defeated... time to move onward!");
		Util.skitPause();
	}
	public static void baseMilitaryBossFlee() //player fled from the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You speedily realize that you're unable to defeat the Insecti Crawler in your current state. You quickly disengage, turning back the way you came.");
		Util.skitPause();
	}
	public static void baseMilitaryBossLose() //player loses to the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving another critical blow you finally realize that you simply can't beat the Insecti Crawler.");
		System.out.println("In uncomprehensible pain, you retreat as quickly as near-imploded bones allow, hoping to reach the village and get some rest.");
		Util.skitPause();
	}
	public static void baseMilitaryBossBeat() //if player chooses the path again after beating the boss COMPLETE
	{
		Util.lineBreak();
		System.out.println("You already defeated the Insecti Crawler! You turn back, confident that nothing else lurks in the Military area.");
		Util.skitPause();
	}
	public static void malusBoss() //intro to Malus as a boss COMPLETE
	{
		if(!malBoss)
		{
			Util.lineBreak();
			System.out.println("You've fought through scorching desert... rolling plains... leafy forest... freezing mountains... a burning volcano... dank caverns...");
			System.out.println("You reached Malus' base... you cleared out most of his forces... you destroyed his four main guardian mechs...");
			System.out.println("And now... it's time to face Malus himself!");
			Util.skitPause();
			Util.bigLineBreak();
			System.out.println("You slowly walk down the pathways of Malus' base, attempting to find his whereabouts.");
			System.out.println("Eventually you find yourself standing in what appears to be a courtyard nearly the size of two football fields.");
			System.out.println("Automatically weary of large, open spaces, you thoroughly inspect the area with your eyes before even considering crossing the courtyard.");
			System.out.println("And in doing so, your eyes alight on none other than Malus, standing on the far battlements!");
			System.out.println("\"Well!\" he exclaims, jumping down to the courtyard, \"I'm surprised you actually made it this far! You actually got to me before 24 hours were up!\"");
			System.out.println("\"Just another few hours and my plan would've been complete... I suppose I should've killed you back at the volcano, hm?\"");
			System.out.println("\"Ah... but that wouldn't have been any fun,\" Malus sneers, beginning to approach you slowly. As he does so you can see the many armaments he's carrying.");
			System.out.println("\"I need only to destroy you right here... barring that, at least hold you off for some time.\"");
			System.out.println("\"After the power of Ultima Chaos is mine...\" he clenches his fist dramatically, \"...no one will be able to stop me!\"");
			System.out.println("He then backs into a fighting stance, gesturing for you to come forward. \"For now, I'll just have to keep you busy! Come at me!!\"");
			System.out.println("Your brow furrowed, you quickly accept Malus' challenge. It's time to defeat him once and for all!");
			Util.skitPause();
			malBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.println("\"Decided that you actually have the guts to try and fight me?\" Malus sneers, \"You've only got so much time!\"");
			System.out.println("\"Now... come at me!!\"");
			Util.skitPause();
		}
	}
	public static void malusFlee() //player fled from Malus COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"You're giving up? Ha! I expected better!\" Malus shouts after your retreating form, \"Do you actually wish to defeat me? Or are you just screwing around?\"");
		System.out.println("\"Either way, you're on the clock! Hurry back so I can have more fun destroying you!!\"");
		Util.skitPause();
	}
	public static void malusLose() //player loses to Malus COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"Well, that was fun!\" Malus exclaims, strutting over to stand over your broken form, \"But... not enough!\"");
		System.out.println("\"I'll go ahead and let you live, for now... but when you come back you had better be sure to be stronger!\"");
		System.out.println("With that you slowly and painfully pick yourself up, turning back the way you came. You'll need to rest up and get stronger before fighting Malus again!");
		Util.skitPause();
	}
	public static void malusPhaseTwo() //intro to Malus' second phase COMPLETE
	{
		Util.lineBreak();
		System.out.println("\"Huaargh!...\" Malus stumbles backward, holding a hand to his stomach in pain. \"Ooooh... you... you...!\"");
		System.out.println("You smirk, enjoying the sight of Malus having to face the fact that he lost. His angrish is most amusing.");
		System.out.println("\"Damn it...\" he mutters, \"I'll... I'll just have to activate my plan earlier than planned...\"");
		System.out.println("Your expression quickly darkens; what's this about activating his plan early? It doesn't sound good... raising your weapon, you intend to cut him down now.");
		System.out.println("But right as you go for the final blow the four towers at the corners of the courtyard spontaneously begin to glow. The sudden distraction cause you to miss, as well.");
		System.out.println("\"Yes... yes...!\" Malus slowly begins to grin as he regains his former, arrogant stature, \"...the power of Ultima Chaos... I... can feel it!...\"");
		System.out.println("That's an alarming phrase. 'Ultima Chaos'? You have no idea what that is, but it doesn't sound good - at least, not in Malus' hands.");
		System.out.println("Quickly, you again attempt to attack Malus - but when your attack connects, instead of injuring him, a sudden sparkstorm kicks up and blows the two of you apart.");
		System.out.println("After recovering from the blow, you start to feel... oddly enough, rejuvenated!");
		System.out.println("\"...what... what?!\" Malus exclaims as he realizes what just happened, \"...no! You just stole some of the Ultima Chaos!!\"");
		System.out.println("You still aren't sure what that means - and you doubt that you'll ever care - but the fact that you seem to have foiled Malus's plans somewhat puts a smirk on your face.");
		System.out.println("\"Well... I'm still more powerful than you are,\" Malus muses, \"...if I kill you... then the power you stole should trasfer to me. And then... I'd have it all!\"");
		System.out.println("Now, you certainly don't like that logic. But as Malus begins to advance, you realize that even if he doesn't have all the Ultima Chaos, he still has plenty.");
		System.out.println("And plenty... is way too much. Malus is dangerous, very dangerous - and you may be the only one who can stop him!");
		System.out.println("You back into a battle stance, prepared to do battle once more.");
		System.out.println("\"Oh? So you actually plan to fight?\" Malus sneers, \"That'd almost be commendable if it weren't so stupid! I won't go easy this time... I'll destroy you!\"");
		System.out.println("His words certainly sound like the truth, but that won't intimidate you! You aren't running!");
		System.out.println("\"...so you really wish to stay and fight?\" Malus shakes his head as if scolding a small child, \"Well, at least that makes my job easier... Anyway, it's time...\"");
		System.out.println("\"Time... to destroy you!!\"");
		Util.skitPause();
	}
	public static void malusPhaseTwoLose() //player loses to Malus' second phase, also loses game outright COMPLETE
	{
		Util.lineBreak();
		System.out.println("After receiving a critical blow you stumble backward and then collapse to the ground, unable to summon the energy to move further.");
		System.out.println("\"Heh,\" Malus chuckles, slowly approaching you while letting his hands sparkle with electricity, \"You finally lost.\"");
		System.out.println("\"You had a chance to start over every time you lost in the past, but...\" Malus moves his arm to direct his palm at your face.");
		System.out.println("\"This time, you won't. Good-bye... I'll be seeing you in the afterlife!\"");
		System.out.println("The next thing you see is a lightning strike, and then... nothing.");
		System.out.println("You died... You lost!");
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
		System.out.println("\"Ungh...!\" Malus collapses to the ground, taking in shallow, ragged breaths. \"I... I... ...lost?!\"");
		System.out.println("\"How... can that... be?!...\" he splutters, and then attempts to stand back up, only to fail.");
		System.out.println("You simply watch on, feeling no sympathy for the villain.");
		System.out.println("\"Urgh... agh... no... my power... it's... leaving...!\" Malus groans; almost immediately afterward he begins glowing a dark red.");
		System.out.println("Before you can react it almost appears that a huge, spectacular energy explosion ignites from Malus. The second afterward he's no longer glowing.");
		System.out.println("On top of that... he seems to have aged a great deal... and is still alive!");
		System.out.println("\"Come...\" he barely mutteres, managing to manipulate one of his fingers to gesture for you. Cautiously, you approach.");
		System.out.println("\"You...\" he starts, \"I... I never... got... your name...\"");
		System.out.println("You smirk. He's clearly dying; you may as well allow him to know the name of his superior before he does.");
		System.out.println("\"My name... is " + pN + ",\" you quietly state.");
		System.out.println("\"" + pN + "... not bad...\" Malus mutters, and then closes his eyes, \"" + pN + "... it... was nice knowing you... ...\"");
		System.out.println("...he's dead. You slowly crouch down and close his eyelids before turning to leave. Malus is now defeated... your adventure is over!");
		Util.skitPause();
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
		System.out.println("You already defeated Malus... what else do you want? Sheesh! There's nothing here, turn around!");
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
					System.out.println("Malus: \"If you think you can win... then you aren't nearly as intelligent as I thought!\"");
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
					System.out.println("Malus: \"You've got my respect... too bad you won't live long enough to tell the tale!\"");
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
					System.out.println("Malus: \"No... I can't be losing! I'm Malus, future overlord of the world! I WILL win!!\"");
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