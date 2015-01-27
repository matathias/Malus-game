/**
 * @author 		David Warrick
 *
 */
// Contains methods used to display the story text.
public class Story
{
	/**
	 * Counter for the final boss's quotes. Used to cycle through his battle quotes.
	 */
	private static int malusQuoteCounter = 0;

	/**
	 * Used to keep track of the player's progress through the story and display the correct text upon arrival at a
	 * location.
	 */
	private static int placeQuoteCounter = 0;

	/**
	 * Signals whether or not the desert boss has been defeated.
	 */
	private static boolean desBoss = false;

	/**
	 * Signals whether or not the plains boss has been defeated.
	 */
	private static boolean plaBoss = false;

	/**
	 * Signals whether or not the forest boss has been defeated.
	 */
	private static boolean forBoss = false;

	/**
	 * Signals whether or not the mountain boss has been defeated.
	 */
	private static boolean mounBoss = false;

	/**
	 * Signals whether or not the volcano boss has been defeated.
	 */
	private static boolean volBoss = false;

	/**
	 * Signals whether or not the caverns boss has been defeated.
	 */
	private static boolean cavBoss = false;

	/**
	 * Signals whether or not the final area: factory boss has been defeated.
	 */
	private static boolean facBoss = false;

	/**
	 * Signals whether or not the final area: urban boss has been defeated.
	 */
	private static boolean urbBoss = false;

	/**
	 * Signals whether or not the final area: laboratory boss has been defeated.
	 */
	private static boolean labBoss = false;

	/**
	 * Signals whether or not the final area: military base boss has been defeated.
	 */
	private static boolean milBoss = false;

	/**
	 * Signals whether or not the final boss has been defeated.
	 */
	private static boolean malBoss = false;

	/**
	 * Line length.
	 * <p>
	 * This variable's only purpose is to make it easier to change the line length argument of all n+ lineWrap method
	 * calls simultaneously.
	 * </p>
	 */
	public final static int lineLength = 80;

	/**
	 * Text to be displayed upon arrival at the town location.
	 */
	public static void town()
	{
		//Use print, not println, before a Util.skitPause() call.
		if(placeQuoteCounter == 0)
		{
			Util.bigLineBreak();
			System.out.print(Util.lineWrap("\n\"Hmm... is this it? ...why yes... yes it is!...\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Finally, my search is complete!\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Now I need only to find a way to properly utilize this power...\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Yes... after a mere weeks' time, I, Malus, will control the power of Ultima Chaos...!\"", lineLength));

			Util.skitPause();
			Util.bigLineBreak();
			Util.skitPause();
			Util.bigLineBreak();

			System.out.print(Util.lineWrap("Something doesn't feel right... your sixth sense is telling you that some danger, some sort of evil, looms in the air.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But, you don't quite know what.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Such a trivial fact doesn't deter your heroic responsibilities, however. You quickly prepare for a new adventure.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You then step outside, and try to feel for where the evil is...", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("...and fail utterly.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("So instead, you head to the nearest town, hoping to find your way from there.", lineLength));

			Util.skitPause();
			Util.bigLineBreak();
			Util.skitPause();

			System.out.println(Util.lineWrap("Once at the town, you see an Inn, several markets, and the desert beyond that.",lineLength));
			System.out.print(Util.lineWrap("With a slight smirk, you set off, hoping to stop whatever evil lurks over the land.", lineLength));
			Util.skitPause();
			
			placeQuoteCounter++;
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You arrive at the town, hoping for some R&R.",lineLength));
		}
	}

	/**
	 * Text to be displayed upon arrival at the desert location.
	 *
	 * @param d - boolean value indicating whether or not the desert boss has been defeated.
	 */
	public static void desert(boolean d)
	{
		if(placeQuoteCounter == 1)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You arrive at the desert past the town with a level of dread; deserts are far from comfortable environments, after all.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But this is merely the beginning of your adventure; surely other locales will be more welcoming?", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Either way, you set your jaw and look forward, ready to defeat anything that comes your way!", lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(d)
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("The desert's a quieter place with the Sand Stone eradicated - which also opens up the second path to the plains.", lineLength));
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You have arrived at the desert, ready to once again search for the evil that lurks within.", lineLength));
		}
	}

	/**
	 * Text to be displayed upon reaching the end of desert path 1.
	 */
	public static void desertPathOne()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Disappointed, you turn back toward the way you came.", lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed upon reaching the end of desert path 2.
	 */
	public static void desertPathThree()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Annoyed, you turn back toward the way you came.", lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed upon reaching the end of desert path 3.
	 * <p>
	 * This method displays the text introduction to the desert boss, and as such will not be displayed ever again once
	 * the boss has been defeated.
	 * <p>
	 */
	public static void desertBoss()
	{
		if(!desBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("Ah! There, off in the distance - it's plains!", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Excited to finally be past the horrid desert heat, you speed up your pace, hoping that you at least won't get dirt in your eyes on the plains.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("However, before you can get very far a sudden sandstorm whips up, nearly blinding you and concealing the plains behind a curtain of sand.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You quickly adjust to the sand, though the first thing you spot is a floating, sand-colored stone.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Even though it has no eyes, it seems as though it's glaring down at you contemptuously, laughing at your plight.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Obviously, it must be the source of the sandstorm!", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("...Though even if it isn't, destroying it could offer some solace.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But never mind the details; it's time for battle!", lineLength));
			Util.skitPause();
			desBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to face off with the Sand Stone, prepared to offer it the beat down that it prevented you from giving last time!", lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed once the desert boss's HP falls beneath the "emergency" threshold.
	 */
	public static void desertBossEmergency()
	{
		System.out.print(Util.lineWrap("Before the Sand Stone attacks again, it seems to rear up into the air.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Immediately after doing so the sand storm around you intensifies. It would appear that you've succeeded in making it angry!", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But you can't lose now; you've almost won!", lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed once the player deals the final blow to the desert boss.
	 */
	public static void desertBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("With a final blow you shatter the Sand Stone to millions of tiny pieces, each disappearing into the very sandstorm the stone conjured.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Now that the Sand Stone is no more, the sandstorm begins to subside - soon, the plains become visible once again.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("And with a closer look, you see a forest beyond the plains, and a distant mountain range beyond that.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It looks like it could be bothersome to trek through all that terrain, but you can't shake off this feeling of lurking evil.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("So with an intrepid step you continue your journey onward, hoping that you'll have more of an idea as to what this evil is before long.", lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the desert boss.
	 */
	public static void desertBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("Realizing that you aren't strong enough to defeat the Sand Stone, you turn around and high-tail it out of there.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You won't be able to get to the Plains this way... you'll have to get stronger!", lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the desert boss.
	 */
	public static void desertBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("Your ability to correctly estimate your own, well, abilities, is severely lacking.", lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With this defeat you trudge back to the town, battered and nearly in pieces; be sure to heal up before you head out recklessly again!", lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player arrives at the plains location.
	 *
	 * @param p - boolean value signaling whether or not the plains boss has been defeated.
	 */
	public static void plains(boolean p)
	{
		if(placeQuoteCounter == 2)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("Finally, you step onto ground that isn't unstable, uncomfortable sand. You breath a sigh of relief; even the air is more comfortable.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But the sun is still an issue - there's no cover or shade in the Plains. And the enemies are bound to be more difficult as well.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Either way, you prepare to continue your adventure.",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(p)
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("The plains are a safer place, now that you're eradicated the Grass Stone in the hills.",lineLength));
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You return to the plains, prepared to face the enemies ahead once again.",lineLength));
		}
	}

	/**
	 * Text to be displayed when the player reaches the end of the plains/plains path.
	 */
	public static void plainsPlainsPath()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Exhausted, you turn back toward the way from which you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of the plains/grasslands path.
	 */
	public static void plainsGrasslandsPath()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Irritated, you turn back toward the way from which you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of the plains/hills path.
	 * <p>
	 * This method displays the text introduction to the plains boss, and as such will not be displayed ever again once
	 * the boss has been defeated.
	 * <p>
	 */
	public static void plainsBoss()
	{
		if(!plaBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("As you progress through the hills you note that you're almost upon the forest; while not exactly overjoyed, you're certainly happy that the next stage of your adventure is near complete.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("However, before you're able to reach the treeline the grass beneath you suddenly becomes very stiff and sharp; with a yelp of pain, you leap back, glaring at the offending plants. Soon, though, the real culprit reveals itself: a levitating green stone.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It bears a remarkable resemblance to the Sand Stone... maybe by destroying it, you'll be able to access the forest!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You quickly prepare for battle, ready to destroy the mysterious green stone!",lineLength));
			Util.skitPause();
			plaBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to face off with the Grass Stone, prepared to defeat it like it defeated you last time!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the plains boss's HP crosses the "emergency" threshold.
	 */
	public static void plainsBossEmergency()
	{
		System.out.print(Util.lineWrap("Before the Grass Stone attacks again, it seems to almost rear up into the air.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Immediately after doing so the grass around you is uprooted and rises into the air, surrounding the Grass Stone.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It would appear that you've succeeded in making it angry!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But you can't lose now; you've almost won!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player deals the final blow to the plains boss.
	 */
	public static void plainsBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("With a final blow you shatter the Grass Stone to a million tiny pieces, each disappearing into the grass it once controlled.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Finally the grass settles, allowing you passage over the remaining hills without your feet being impaled.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You cautiously cross the remaining distance (in case there are any more enemies) but reach the forest unharmed.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("This close to the forest, it's impossible to see anything past it - but you know that the mountains are there, and beyond them, a great evil.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With the same determination as before you head into the trees, prepared to face anything that's thrown your way.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player flees from the plains boss.
	 */
	public static void plainsBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("Realizing that you aren't strong enough to defeat the Grass Stone, you quickly turn tail and leave.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You'll have to be stronger before you can hope to defeat it!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player loses to the plains boss.
	 */
	public static void plainsBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving a critical hit you finally realize that you aren't strong enough to fight the Grass Stone.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You quickly limp away, returning to town to recuperate.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player arrives at the forest location.
	 * @param f - boolean value signaling whether or not the forest boss has been defeated.
	 */
	public static void forest(boolean f)
	{
		if(placeQuoteCounter == 3)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("So you've finally made it to the shade of the forest. The sun's no longer an issue; no more sunburns for you!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("However, this forest looks a tad spookier on the inside than the out - there's bound to be tons of enemies here.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You quickly gear up - there's still a lot to fight through in front of you!",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(f)
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("The forest seems a more peaceful place now that the Leaf Stone is destroyed. On top of that, the third path is open to the mountains!",lineLength));
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You step into the forest, prepared to face the enemies lurking there.",lineLength));
		}
	}

	/**
	 * Text to be displayed when the player reaches the end of forest path 1.
	 */
	public static void forestPathOne()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Tired, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of forest path 2.
	 */
	public static void forestPathTwo()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Cross, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of forest path 3.
	 * <p>
	 * This method displays the text that introduces the forest boss; as such this method will never be called again
	 * once the player defeats the boss.
	 * <p>
	 */
	public static void forestBoss()
	{
		if(!forBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("After dodging past the next tree, you spot a sliver of light, brighter than any location within the forest.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You conclude that it must be the treeline - you're at a higher altitude than when you first entered the forest, anyway.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("However, before you can get much closer to the light all of the leaves around you suddenly come to life.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Swirling around you, they begin to lacerate your skin one by one; possessing no desire to die by 1000 papercuts, you quickly jump out of the vortex.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Now outside of the leaves, you see a floating, dark green stone behind it. It looks rather similar to the Sand and Grass Stones.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Realizing this, you prepare to take it down, hoping to clear the way to the edge of the forest!",lineLength));
			Util.skitPause();
			forBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the Leaf Stone, this time prepared to destroy it like the two Stones before!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the forest boss's HP crosses the "emergency" threshold.
	 */
	public static void forestBossEmergency()
	{
		System.out.print(Util.lineWrap("Before the Leaf Stone attacks again, it seems to almost rear up into the air.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Immediately after doing so the leaf storm in front of you intensifies. It would appear as though you've succeeded in making it angry!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But you can't lose now; you've almost won!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed after the player deals the final blow to the forest boss.
	 */
	public static void forestBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You land a final, critical hit on the Leaf Stone, shattering it into a million pieces, each landing amongst the leaves they once controlled.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With nothing more blocking your path, you make your way to the edge of the forest.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Once you emerge from the treeline you find that you're now in the mountains, with a Volcano barely visible in the distance.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Before you set off to continue adventuring, though, you think back to the three Stones you've beaten: the Sand, Grass, and now, Leaf Stone.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("They can't be coincidences... Stones like those just aren't natural. And neither are several of the enemies you've encountered.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Not to mention all those robots and drones you've defeated! Someone, or something, must be behind this. ...Likely, the very evil you're chasing.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With that thought you continue onward, resolving to find and defeat this evil!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the forest boss.
	 */
	public static void forestBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("Recognizing the gap in capability between you and the Leaf Stone, you quickly pull out, staging a tactical retreat.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You'll need to be stronger if you hope to defeat the Leaf Stone!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the forest boss.
	 */
	public static void forestBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving a critical hit you realize that you simply aren't strong enough to take on the Leaf Stone.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You disengage and manage to crawl back to town, hoping to recuperate before heading out once more.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player arrives at the mountains location.
	 *
	 * @param m - boolean value signaling whether or not the mountains boss has been defeated.
	 */
	public static void mountains(boolean m)
	{
		if(placeQuoteCounter == 4)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("Now in the mountains, you notice a certain biting coolness that wasn't present before (and certainly not in the desert).",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You may not have the shade that the forest offered, but the lack of heat makes up for it.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("After taking a second to gaze upon the beauty of the mountains you gear up, prepared to continue your adventure.",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(m)
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("With the Blizzard Stone defeated, the biting sensation that came with the coolness is now gone. Plus, path one is open to the Village.",lineLength));
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You arrive in the mountains, prepared to take on anything in your path.",lineLength));
		}
	}

	/**
	 * Text to be displayed when the player reaches the end of mountains path two.
	 */
	public static void mountainsPathTwo()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Bitter, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of mountains path three.
	 */
	public static void mountainsPathThree()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Exasperated, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of mountains path one.
	 * <p>
	 * This method displays the text that introduces the mountains boss, and as such will never be called again once the
	 * mountains boss has been defeated.
	 * <p>
	 */
	public static void mountainsBoss()
	{
		if(!mounBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You've been constantly approaching the Volcano through the mountain range, and now you need only to clear one more peak.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You can see a village at the peak; it would be an excellent place to rest-up before venturing toward the Volcano itself.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("However, before you can even reach it the snow all around you suddenly kicks up into a blinding Blizzard!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("This isn't the first time the environment has risen against you, though.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Expecting a Stone to be behind these shenanigans, you slowly scan the area until you spot a hovering silhouette in the distance.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It must be the offending Stone - pulling out your weapon, you approach even quicker, prepared to take it down!",lineLength));
			Util.skitPause();
			mounBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the Blizzard Stone, this time prepared to obliterate it like no other!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed once the mountains boss's HP crosses the "emergency" threshold.
	 */
	public static void mountainsBossEmergency()
	{
		System.out.print(Util.lineWrap("Before the Blizzard Stone attacks again, it seems to almost rear up into the air.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Immediately after doing so the snow storm around you intensifies. It would appear that you've succeeded in making it angry!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But you can't lose now; you've almost won!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed once the player deals the final blow to the mountains boss.
	 */
	public static void mountainsBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You land a final critical hit on the Blizzard Stone, shattering it into a million pieces, each disappearing into the Blizzard it created.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Slowly, the weather calms down, until you can once again see the sky - and also the village.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("As you approach the village, you think back to the four Stones you've defeated: Sand, Grass, Leaf, and Blizzard.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Is there a connection? You believe that there must be one, but what it is, you aren't quite sure.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Maybe you'll find some answers near the Volcano... after stopping at the village, of course.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the mountains boss.
	 */
	public static void mountainsBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("The gap in ability between you and the Blizzard Stone is simply too large. You quickly initiate a retrograde advance.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You'll need to be stronger if you hope to defeat the Blizzard Stone!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the mountains boss.
	 */
	public static void mountainsBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After nearly getting frostbitten for the nth time, you recognize that there's an incomprehensible gap in ability between you and the Blizzard Stone.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Managing to escape the Stone's influence, you limp back to town, wishing for a nice cup of hot cocoa and maybe some life insurance.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player arrives at the village location.
	 */
	public static void village()
	{
		if(placeQuoteCounter == 5)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You finally reach the village, a safe-haven for adventurers such as yourself.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Looking around, you realize that it isn't as nicely equipped as the town - there's no healing or special attack market - but at least there's an inn.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You then step into the village, hoping to better prepare yourself for further adventuring.",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You step into the village, hoping to rest, recuperate, and better equip yourself.",lineLength));
		}
	}

	/**
	 * Text to be displayed when the player arrives at the volcano location.
	 *
	 * @param v - boolean value signaling whether or not the volcano boss has been defeated.
	 */
	public static void volcano(boolean v)
	{
		if(placeQuoteCounter == 6)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You near the base of the volcano and can already feel the heat; it's far more uncomfortable than the desert.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You aren't sure what you'll find here - or even what you're doing here - but you can sense the evil presence even stronger than before.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("So, obviously, you must be going in the correct direction... right?",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Well, you hope to find an answer at the volcano anyways, and thus prepare to withstand the heat and defeat any enemies that present themselves.",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(v)
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You arrive at the volcano, which is still pretty damn hot, but at least the Wyvern is defeated and path one is open to the caverns.",lineLength));
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You return to the volcano, trying your best to withstand the heat while seeking out answers to your quest(ions).",lineLength));
		}
	}

	/**
	 * Text to be displayed when the player reaches the end of volcano path 2.
	 */
	public static void volcanoPathTwo()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here, besides far too much magma... Vexed, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of volcano path 3.
	 */
	public static void volcanoPathThree()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Irked, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of volcano path 1.
	 * <p>
	 * This method displays the text that introduces the volcano boss, and as such will never be called again once the
	 * player defeats the boss.
	 * <p>
	 */
	public static void volcanoBoss()
	{
		if(!volBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("As you walk around the base of the Volcano you spot a cave that isn't flooded with lava. Curious, you begin to approach.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Halt right there!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Startled, you pause and look about. Your eyes soon land on an armored individual to your side, holding a gun in your direction!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("The sense of danger and evil you felt at the beginning of your adventure suddenly overwhelms you. Certainly, this person is the source!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But at your current ability level there's no way you could defeat him. Though any further thought is cut off as the individual begins to speak.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Ah, another one of those hardy adventure types, hoping to defeat me, is that it?\" he smirks, \"Pft. As if I could lose to the likes of you!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You take a step back; if this man intends to attack you, then you intend to retreat. As fast as humanly possible.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Hmm... you're scared of me. I can see that you're intelligent enough to recognize my power,\" the man comments, \"...perhaps I won't kill you now.\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("He then takes a step back and taps his wrist - it looks as if he's typing something - and then looks back to you.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Instead...\" he sneers, as a giant, flying robot swoops down behind him, \"I'll pit you against this Boss Class Aerial 'Bot.\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Suddenly, the ground below you shudders and begins rising into the air, revealing itself to be a large, levitating metal platform!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("With apprehension you turn to look down at the man, only to see the robot flying up at you and the man shouting after it:",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Wyvern... destroy this pest!\"",lineLength));
			Util.skitPause();
			volBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("\"So you actually returned, eh?\" Malus sneered, gesturing for the BCA Wyvern to approach you. \"I simply thought you had taken the coward's way out!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You back into a battle stance, unfazed by Malus' taunts. This time... you'll defeat his Wyvern!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the volcano boss's HP crosses the "emergency" threshold.
	 */
	public static void wyvernBossEmergency()
	{
		System.out.print(Util.lineWrap("With a mechanical screech the Wyvern launches into the air, coming to a stop and hovering a fair distance over the platform.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It then pulls its tail down between its legs, as if its pointing at you, and then - a spike suddenly appears on the tip!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("For it to pull a trick out of its sleeve... you must be fairly close to defeating it.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With that thought, your expression hardens - you're ready for anything its about to throw at you!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player deals the final blow to the volcano boss.
	 */
	public static void volcanoBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You land a final critical blow on the Wyvern, and then step back and watch as it explodes and falls to pieces, thoroughly destroyed and unsalvageable.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Hmm... not bad, not bad,\" the man nods, as the platform you are on starts lowering to the ground, \"though still not strong enough to beat me.\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"You could actually be entertaining to me...\" he comments as he engages a jetpack attached to his back, \"Yes... I like the sound of that.\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"I have nothing else to do currently, anyway.\" You simply stand back and watch as he lifts off the ground, not sure what to think of the comment.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Ah, but before I go,\" the man adds, \"I think I'll go ahead and allow you to know my name... the name of your superior, in all ways!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"I am Malus... future overlord of the world!!\"",lineLength));
		Util.skitPause();
		Util.bigLineBreak();
		System.out.print(Util.lineWrap("So... Malus. He's the evil you first sensed. With his aura... his claims to future overlord-hood may be justified.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You quickly deduce that you have to defeat him... ...Though you aren't ready to face him just yet. You need to find his lair first, anyway.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("There's no readily available pathway around the volcano... the only path you can see is the cavern, no longer blocked by Malus or a robot.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("For now, it'll have to do. Hopefully, it will lead you one step closer to Malus' location!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the volcano boss.
	 */
	public static void volcanoBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("\"Ha ha ha, that's what I thought!\" Malus shouts after your retreating form, \"You aren't strong enough to face me! At all!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Well, as annoying as he might be, Malus is right about one thing: you need to get stronger. Heading back, you intend to do just that.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the volcano boss.
	 */
	public static void volcanoBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("\"AH ha ha ha ha!!\" Malus laughs loud and long as you fall to the ground, almost every bone in your body broken.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"You aren't strong enough to face me, and you never will be.\" He sneers, and then turns away with the Wyvern.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"I'll let you live, for now. Maybe you'll serve as a lesson for others who ignorantly wish to face me!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("As he leaves the scene you slowly begin to crawl back to the village...",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You'll definitely need to get stronger before you can even hope to defeat Malus!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player arrives at the caverns location.
	 *
	 * @param c - boolean value signaling whether or not the caverns boss has been defeated.
	 */
	public static void caverns(boolean c)
	{
		if(placeQuoteCounter == 7)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("As you walk through the cavern under the volcano, you note that it isn't becoming hot. In fact, it's actually getting colder.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("That defeats all logic... technically, you should have reached a lava flow by now!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You continue down the caves... and a thought pops into your head: What if this geographic phenomenon was created by Malus?",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("If so, then he must have a great deal of resources and time on his side... but it also means that you're likely close to his base!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It's time to up the ante. You resolutely decide to blast through the caves and find Malus' base, and then stop him!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("...Easier said than done. ...well, time to find your way through the caves!",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if(c)
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You've already defeated the BCG Cerberus... time to head through path two to Malus' base!",lineLength));
		}
		else
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You return to the caverns, prepared to continue your search for the path to Malus' base.",lineLength));
		}
	}

	/**
	 * Text to be displayed when the player reaches the end of caverns path 1.
	 */
	public static void cavernsPathOne()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("Even after all those damn rocks, there's nothing here... Fatigued, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of caverns path 3.
	 */
	public static void cavernsPathThree()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("There's nothing here... Enervated, you turn back toward the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of caverns path 2.
	 * <p>
	 * This method displays the text that introduces the caverns boss; as such this method will never be called again
	 * once the player defeats the boss.
	 * <p>
	 */
	public static void cavernsBoss()
	{
		if(!cavBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You round another corner, finding yourself in a rather large cavern. Wary of locales of such size, you cautiously make your way to the other side.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But your caution is to no avail. Previously unknown to you, one of the walls is actually a door - and through it bursts a large robot!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It looks like a huge dog... surely, this is one of Malus' creations. And if it is... then you must be getting closer to his base!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You back into a battle stance, prepared to take on the robot!",lineLength));
			Util.skitPause();
			cavBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the BCG Cerberus, prepared to send it to its oblivion!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed once the caverns boss's HP crosses the "emergency" threshold.
	 */
	public static void cerberusBossEmergency()
	{
		System.out.print(Util.lineWrap("The Cerberus rears up and lets loose an electronic roar; upon doing so you can see various small internal fires.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It's almost destroyed... and it seems to know that. You harden your stance, prepared for whatever the Cerberus is about to do!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed once the player deals the final blow to the caverns boss.
	 */
	public static void cavernsBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After suffering a final critical blow the Cerberus shuts down catastrophically... that is, it explodes.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With that obstacle out of your way, you're now ready to move on, one step closer to Malus' base!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the caverns boss.
	 */
	public static void cavernsBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("The way this battle is going, you'll never win. Recognizing this, you quickly pull out.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You'll need to get stronger before you can pass the Cerberus!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the caverns boss.
	 */
	public static void cavernsBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You suffer a critical blow at the hands of the Cerberus...",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Your body broken, you somehow manage to disengage from the Cerberus and begin your long, painful trek back to the village.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With battles ending like that you'll *have* to get stronger before you can even think about reaching Malus' base!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player arrives at Malus's base.
	 *
	 * @param f - boolean value signalling whether or not the Factory boss has been defeated.
	 * @param u - boolean value signalling whether or not the Urban boss has been defeated.
	 * @param l - boolean value signalling whether or not the Laboratory boss has been defeated.
	 * @param m - boolean value signalling whether or not the Military Base boss has been defeated.
	 * @param b - boolean value signalling whether or not Malus has been defeated.
	 */
	public static void base(boolean f, boolean u, boolean l, boolean m, boolean b)
	{
		if(placeQuoteCounter == 8)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You emerge from the caverns to find yourself in a completely unknown locale. Everything around you looks industrial...",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Ah, so you finally arrived!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You look up, though you have no need - you already know the identity of the speaker.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"I must say, well done!\" Malus smirks from his position atop a nearby building, \"Defeating both the Wyvern and the Cerberus... impressive!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"But you still aren't at my level! And if you don't defeat me within the next 24 hours... then you never will be!!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("He then jumps into the air and engages his jet pack, flying backward into the industrial complex. \"Good luck reaching me before then!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You watch him leave, and then what he says hits you. 24 hours? What could possibly happen after that...?",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Well, you at least know you don't want to find out. All you know is that you're standing at the entrance to Malus' domain...",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("...and it's time to kick some ass!!",lineLength));
			Util.skitPause();
			placeQuoteCounter++;
		}
		else if((f || u  || l  || m) && !(f && u && l && m))
		{
			Util.lineBreak();
			System.out.println(Util.lineWrap("You've destroyed some of Malus' mechanical minions... but you've yet to destroy them all. It's time to remedy that situation.",lineLength));
			System.out.println(Util.lineWrap("Defeated bosses:",lineLength));
			if(f)
			{
				System.out.println(Util.lineWrap("\tIncomplete Bug Crawler(Factory)",lineLength));
			}
			if(u)
			{
				System.out.println(Util.lineWrap("\tCivil Control Mech(Urban)",lineLength));
			}
			if(l)
			{
				System.out.println(Util.lineWrap("\tPrototype Mantis Crawler(Lab)",lineLength));
			}
			if(m)
			{
				System.out.println(Util.lineWrap("\tInsecti Crawler(Military)",lineLength));
			}
			System.out.println("");
			Util.skitPause();
		}
		else if(b)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("With Malus dead, his base has fallen into a state of disrepair. No more evil lurks here... though his minions still do.",lineLength));
			Util.skitPause();
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to Malus' base, ready and willing to kick some ass!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the player enters battle with the factory boss.
	 * <p>
	 * As a boss introduction method, this method will never be called again once the factory boss is defeated.
	 * <p>
	 */
	public static void baseFactoryBoss()
	{
		if(!facBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("After fighting through Malus' construction and production facilities you find yourself in a large hanger.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You suspect that something is amiss... and sure enough, a large door in the back opens to reveal a large mech!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It almost appears to be a cross between a spider and a dog... but its appearance doesn't matter. You plan to defeat it no matter what!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("And once you do... you'll be just one step closer to Malus!",lineLength));
			Util.skitPause();
			facBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the Bug Crawler, determined to utterly destroy it this time!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the factory boss's HP crosses the "emergency" threshold.
	 */
	public static void bugCrawlerModeOneEmergency()
	{
		System.out.print(Util.lineWrap("The Bug Crawler lets loose a metallic roar and then flaps its wings strongly, apparently attempting to put out the many fires on its wings.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It then zooms in close, evidently prepared to unleash some ferocious attack.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But it doesn't intimidate you... you stand back and plant your feet, ready to face the robot's mad charge!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the factory boss transitions into its second phase.
	 */
	public static void bugCrawlerTransform()
	{
		System.out.print(Util.lineWrap("Suddenly the Bug Crawler dives down toward the ground, coming to a stop just before it hits.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It lands with a metallic crash and then discards its wings; surprised, you back off a bit, not sure how to react.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But the Crawler evidently isn't destroyed yet, so you set yourself back into a battle stance, prepared to utterly obliterate it!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed after the player lands the final blow on the factory boss.
	 */
	public static void baseFactoryBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("The Bug Crawler collapses to the ground, overloading and shutting down after the beat-down you offered it.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("That's one of Malus' mechs defeated... time to move onward!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player flees from the factory boss.
	 */
	public static void baseFactoryBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You soon realize that you can't defeat the Bug Crawler in your current state. You quickly disengage, turning back the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player loses to the factory boss.
	 */
	public static void baseFactoryBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving another critical blow you finally realize that you simply can't beat the Bug Crawler.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("In massive pain, you retreat as quickly as broken bones allow, hoping to reach the village and get some rest.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of the factory path after already defeating the factory
	 * boss.
	 */
	public static void baseFactoryBossBeat()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You already defeated the Bug Crawler! You turn back, confident that nothing else lurks in the factory.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player engages the urban boss at the end of the urban path.
	 * <p>
	 * As a boss introduction method, this method will never be called again once the urban boss has been defeated.
	 * <p>
	 */
	public static void baseUrbanBoss()
	{
		if(!urbBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("After walking through what may be the most un-populated city you've ever seen, you find yourself in a large parking lot surrounding by buildings.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You suspect that something is amiss... and sure enough, a large, nearby garage door opens to reveal a large mech!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It doesn't appear too impressive, but it certainly has guns equipped... though that doesn't matter. You plan to defeat it no matter what!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("And once you do... you'll be just one step closer to Malus!",lineLength));
			Util.skitPause();
			urbBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the Civil Control Mech, confident in your ability to smash it this time!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the urban boss's HP crosses the "emergency" threshold.
	 */
	public static void civilMechEmergency()
	{
		System.out.print(Util.lineWrap("Seemingly fed up with its attacks failing, the Civil Control Mech takes a step back and then opens a hidden hatch on its front side.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("And out of it... emerges an Alpha Cannon!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Seeing that the mech seems to have finally resorted to actual force, you decide to do the same - otherwise known as smashing it into smithereens!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed after the player lands the final blow on the urban boss.
	 */
	public static void baseUrbanBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("The Civil Control Mech crumbles to the ground, overloading and shutting down permanently.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("That's one of Malus' mechs defeated... time to move onward!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the urban boss.
	 */
	public static void baseUrbanBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You quickly realize that you are unable to defeat the Civil Control Mech in your current state. You quickly disengage, turning back the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the urban boss.
	 */
	public static void baseUrbanBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving another painful shock you finally realize that you simply can't beat the Civil Control Mech.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("In unbearable pain, you retreat as quickly as stunned limbs allow, hoping to reach the village and get some rest.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of the urban path after already defeating the urban boss.
	 */
	public static void baseUrbanBossBeat()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You already defeated the Civil Control Mech! You turn back, confident that nothing else lurks in the Urban area.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player engages the lab boss at the end of the laboratory path.
	 */
	public static void baseLabBoss()
	{
		if(!labBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("After destroying a fair lot of Malus' experiments and protection units you find yourself in a large, circular room.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You suspect that something is amiss... and sure enough, a large door in the far wall opens to reveal a large mech!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("It looks something like a Mantis... though real Mantises surely don't have tons of weaponry equipped!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Its appearance doesn't matter though - you'll defeat it easily enough anyway!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("And once you do... you'll be just one step closer to Malus!",lineLength));
			Util.skitPause();
			labBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the Prototype Mantis Crawler, positive that you'll absolutely demolish it this time!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the lab boss's HP crosses the "emergency" threshold.
	 */
	public static void mantisCrawlerEmergency()
	{
		System.out.print(Util.lineWrap("After receiving sufficient damage much of the Mantis Crawler's bulkier armor suddenly falls off.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("On first thought, this seems like a Godsend, but in actuality it allows the Mantis to move at much higher speeds!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("That won't keep you from obliterating it, though!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed after the player lands the final blow on the lab boss.
	 */
	public static void baseLabBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("The Prototype Mantis Crawler crashes to the ground, its systems failing and causing a catastrophic overload.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("That's one of Malus' mechs defeated... time to move onward!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the lab boss.
	 */
	public static void baseLabBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You rapidly realize that you can't defeat the Prototype Mantis Crawler in your current state. You quickly disengage, turning back the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the lab boss.
	 */
	public static void baseLabBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving another painful slash you finally realize that you simply can't beat the Prototype Mantis Crawler.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("In unprecedented pain, you retreat as quickly as sliced limbs allow, hoping to reach the village and get some rest.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of the lab path after already defeating the lab boss.
	 */
	public static void baseLabBossBeat()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You already defeated the Prototype Mantis Crawler! You turn back, confident that nothing else lurks in the Lab.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player engages the military boss.
	 * <p>
	 * As a boss introduction method, this method will never be called again once the player defeats the military boss.
	 * <p>
	 */
	public static void baseMilitaryBoss()
	{
		if(!milBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("After obliterating a great deal of Malus' mainstay force you find yourself in a large barracks.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You suspect that something is amiss... and sure enough, a large door in the far wall opens to reveal a large mech!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("This one looks something like an insect... and appears to be by far more powerful than any of Malus' other mechs.",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("But its appearance doesn't matter - you'll defeat it easily enough!",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("And once you do... you'll be just one step closer to Malus!",lineLength));
			Util.skitPause();
			milBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You return to battle the Insecti Crawler, certain that you'll defeat it this time!",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed when the military boss transitions into phase two.
	 */
	public static void insectiCrawlerTransform()
	{
		System.out.print(Util.lineWrap("The Insecti Crawler takes a step back and then lets loose a metallic roar as some of its armor falls off.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It then reveals a new, more powerful set of weapons, and turns to face you, all of them actively targeting you!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But such a sight doesn't intimidate you... you're prepared to defeat it, no matter its form!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the military boss's HP crosses the "emergency" threshold.
	 */
	public static void insectiCrawlerEmergency()
	{
		System.out.print(Util.lineWrap("Suddenly the Insecti Crawler seems to flare up - if it could properly display emotion then 'enraged' would be the most applicable.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It then pulls out a weapon that you haven't seen before... it appears to be a cannon, but unlike any other you've seen.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But wait... you remember reading something about a newfangled 'black hole cannon' that researchers were working on... could this really be it?",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It looks like what you imagined a Black Hole Cannon to look like... but surely such a thing is impossible-!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Though as the cannon begins charging you decide you don't want to find out first-hand. You quickly back away, hoping to dodge whatever is thrown your way!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed after the player lands the final blow on the military boss.
	 */
	public static void baseMilitaryBossBeaten()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("The Insecti Crawler fails and its Prototype Black Hole Cannon overloads, causing the entire mech to implode on itself.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("That's one of Malus' mechs defeated... time to move onward!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player flees from the military boss.
	 */
	public static void baseMilitaryBossFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You speedily realize that you're unable to defeat the Insecti Crawler in your current state.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You quickly disengage, turning back the way you came.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to the military boss.
	 */
	public static void baseMilitaryBossLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving another critical blow you finally realize that you simply can't beat the Insecti Crawler.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("In uncomprehensible pain, you retreat as quickly as near-imploded bones allow, hoping to reach the village and get some rest.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player reaches the end of the military path after already defeating the military
	 * boss.
	 */
	public static void baseMilitaryBossBeat()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You already defeated the Insecti Crawler! You turn back, confident that nothing else lurks in the Military area.",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player engages the final boss, Malus.
	 * <p>
	 * As a boss introduction method, this method will never be called again once the player defeats Malus.
	 * <p>
	 */
	public static void malusBoss()
	{
		if(!malBoss)
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("You've fought through scorching desert... rolling plains...", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Leafy forest... freezing mountains...", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("A burning volcano... dark caverns...", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You reached Malus' base... you cleared out most of his forces...", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("You destroyed his four main guardian mechs...", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("And now... it's time to face Malus himself!", lineLength));
			Util.skitPause();
			Util.bigLineBreak();
			System.out.print(Util.lineWrap("You slowly walk down the pathways of Malus' base, attempting to discern his whereabouts.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Eventually you find yourself standing in what appears to be a courtyard nearly the size of two football fields.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Automatically wary of large, open spaces, you thoroughly inspect the area with your eyes before even considering crossing the courtyard.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("And in doing so, your eyes alight on none other than Malus, standing on the far battlements!", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Well!\" he exclaims, jumping down to the courtyard, \"I'm surprised you actually made it this far! You actually got to me before 24 hours were up!\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Just another few hours and my plan would've been complete... I suppose I should've killed you back at the volcano, hm?\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Ah... but that wouldn't have been any fun.\" Malus sneers as he begins to approach you slowly. As he does so you can see the numerous armaments attached to his powered armor.", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"I need only to destroy you right here... barring that, at least hold you off for some time.\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"After the power of Ultima Chaos is mine...\" he clenches his fist dramatically, \"...no one will be able to stop me!\"", lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("He then backs into a fighting stance, gesturing for you to come forward. \"For now, I'll just have to keep you busy! Come at me!!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("Your brow furrowed, you quickly accept Malus' challenge. It's time to defeat him once and for all!",lineLength));
			Util.skitPause();
			Util.bigLineBreak();
			malBoss = true;
		}
		else
		{
			Util.lineBreak();
			System.out.print(Util.lineWrap("\"Decided that you actually have the guts to try and fight me?\" Malus sneers, \"You've only got so much time!\"",lineLength));
			Util.skitPause();
			System.out.print(Util.lineWrap("\"Now... come at me!!\"",lineLength));
			Util.skitPause();
		}
	}

	/**
	 * Text to be displayed if the player flees from Malus.
	 */
	public static void malusFlee()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("\"You're giving up? Ha! I expected better!\" Malus shouts after your retreating form.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Do you actually wish to defeat me? Or are you just screwing around?\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Either way, you're on the clock! Hurry back so I can have more fun destroying you!!\"",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed if the player loses to Malus.
	 */
	public static void malusLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("\"Well, that was fun!\" Malus exclaims, strutting over to stand over your broken form, \"But... not enough!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"I'll go ahead and let you live, since I'm bored... but when you come back you had better be sure to be stronger!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("With that you slowly and painfully pick yourself up, turning back the way you came.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You'll need to rest up and get stronger before fighting Malus again!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed in between the two phases of the Malus boss fight.
	 */
	public static void malusPhaseTwo()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("\"Huaargh!...\" Malus stumbles backward, holding a hand to his stomach in pain. \"Ooooh... you... you...!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You smirk, enjoying the sight of Malus having to face the fact that he lost. His angrish is most amusing.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Damn it...\" he mutters, \"I'll... I'll just have to activate my plan earlier than I'd hoped...\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Your expression quickly darkens; what's this about activating his plan early?",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("It doesn't sound good... raising your weapon, you intend to cut him down now.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("But right as you go for the final blow the four towers at the corners of the courtyard spontaneously begin to glow. The sudden distraction causes you to miss, as well.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Yes... yes...!\" Malus slowly begins to grin as he regains his former, arrogant stature, \"...the power of Ultima Chaos... I... can feel it!...\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("That's an alarming phrase. 'Ultima Chaos'? You have no idea what that is, but it doesn't sound good - at least, not in Malus' hands.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Quickly, you again attempt to attack Malus - but when your attack connects, instead of injuring him, a sudden sparkstorm kicks up and blows the two of you apart.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("After recovering from the blow, you start to feel... oddly enough, rejuvenated!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"...Wha... what?!\" Malus exclaims as he realizes what just happened, \"...no! You just stole some of the Ultima Chaos!!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You still aren't sure what that means - and you doubt that you'll ever care - but the fact that you seem to have thrown a wrench in Malus's plans puts a smirk on your face.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Well... I'm still more powerful than you are,\" Malus muses, \"...if I kill you... then the power you stole should return to me. And then... I'd have it all!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Now, you certainly don't like that logic. But as Malus begins to advance, you realize that even if he doesn't have all the Ultima Chaos, he still has plenty.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("And plenty... is way too much. Malus is dangerous, very dangerous - and you may be the only one who can stop him!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You back into a battle stance, prepared to do battle once more.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Oh? So you actually plan to fight?\" Malus sneers, \"That'd almost be commendable if it weren't so stupid!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"I won't go easy this time... I'll destroy you!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("His words certainly sound like the truth, but that won't intimidate you! You aren't running!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"...So you really wish to stay and fight?\" Malus shakes his head as if scolding a small child.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Well, at least that makes my job easier... Anyway, it's time...\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Time... to destroy you!!\"",lineLength));
		Util.skitPause();
		Util.bigLineBreak();
	}

	/**
	 * Text to display if the player loses to Ultima Malus - and therefore loses the entire game.
	 */
	public static void malusPhaseTwoLose()
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("After receiving a critical blow you stumble backward and then collapse to the ground, unable to summon the energy to move further.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Heh,\" Malus chuckles, slowly approaching you while letting his hands spark with electricity, \"You finally lost.\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"You had a chance to start over every time you failed in the past, but...\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Malus moves his arm to direct his palm at your face.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"This time, you won't. Good-bye... I'll be seeing you in the afterlife!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("The next thing you see is a lightning strike, and then... nothing.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You died...",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You lost!!",lineLength));
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
			System.out.println(Util.lineWrap("Hope you had a fun time playing the game... better luck next time!",lineLength));
			Util.lineBreak();
		}
	}

	/**
	 * Text to display when the player lands the final blow on Ultima Malus.
	 * @param pN - the player's name.
	 */
	public static void malusBeaten(String pN)
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("\"Ungh...!\" Malus collapses to the ground, taking in shallow, ragged breaths. \"I... I... ...lost?!\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"How... can that... be?!...\" he splutters as he attempts to stand back up, only to fail.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You simply watch on, feeling no sympathy for the villain.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Urgh... agh... no... my power... it's... leaving...!\" Malus groans; almost immediately afterward he begins glowing a dark red.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Before you can react it almost appears that a huge, spectacular energy explosion ignites from Malus. The second afterward he's no longer glowing.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("On top of that... he seems to have aged a great deal... and is still alive!",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"Come...\" he whispers hoarsely, managing to manipulate one of his fingers to gesture for you. Cautiously, you approach.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"You...\" he starts, \"I... I never... got... your name...\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("You smirk. He's clearly dying; you may as well allow him to know the name of his superior before he does.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"My name... is " + pN + ",\" you quietly state.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"" + pN + "... not bad...\" Malus mutters, and then closes his eyes.",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("\"" + pN + "... I'm glad... you were my last... opponent... ...\"",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("...He's dead. You slowly crouch down and close his eyelids before turning to leave. Malus is now defeated...",lineLength));
		Util.skitPause();
		System.out.print(Util.lineWrap("Your adventure... is over!",lineLength));
		Util.skitPause();
		Util.bigLineBreak();
	}

	/**
	 * Text to display after winning the game.
	 * @param p - the player.
	 */
	public static void gameWon(Player p)
	{
		Util.lineBreak();
		System.out.println(Util.lineWrap("Congratulations! You have beaten the game!",lineLength));
		System.out.println(Util.lineWrap("Your final stats are as follows:",lineLength));
		p.showAll();
		Util.skitPause();
		Util.lineBreak();
		System.out.print(Util.lineWrap("However, you can continue to play the game if you wish. Have fun!",lineLength));
		Util.skitPause();
	}

	/**
	 * Text to be displayed when the player travels to the base area but has already defeated Malus.
	 */
	public static void gameBeat() //if game has been beaten and player goes to the base
	{
		Util.lineBreak();
		System.out.print(Util.lineWrap("You already defeated Malus... what else do you want? Sheesh! There's nothing here, turn around!",lineLength));
		Util.skitPause();
	}

	/**
	 * Malus' battle quotes.
	 *
	 * @param maxHP - Malus' maximum HP.
	 * @param curHP - Malus' current HP.
	 */
	public static void ultimaMalusBattleQuotes(double maxHP, double curHP)
	{
		//quote cycle for 100% - 33% health
		if (curHP > (maxHP / 3)) {
			malusQuoteCounter++;
			switch(malusQuoteCounter) {
				case 1:
					System.out.print(Util.lineWrap("Malus: \"Do you really think you can beat me? Ha! Don't make me laugh!\"",lineLength));
					break;
				case 2:
					System.out.print(Util.lineWrap("Malus: \"Your attacks mean nothing!\"",lineLength));
					break;
				case 3:
					System.out.print(Util.lineWrap("Malus: \"If you think you can win... then you aren't nearly as intelligent as I thought!\"",lineLength));
					break;
				case 4:
					System.out.print(Util.lineWrap("Malus: \"Haha! That's right, squirm!!\"",lineLength));
					break;
				case 5:
					System.out.print(Util.lineWrap("Malus: \"Ultima Chaos is on my side... the puny amount you hold means nothing!\"",lineLength));
					malusQuoteCounter = 0;
					break;
			}
			Util.skitPause();
		}
		//quote cycle for 33% - 10% health
		else if (curHP < (maxHP / 3) && curHP > (maxHP/10))
		{
			malusQuoteCounter++;
			switch(malusQuoteCounter) {
				case 1:
					System.out.print(Util.lineWrap("Malus: \"Hmm, not bad, not bad... but not good enough!\"",lineLength));
					break;
				case 2:
					System.out.print(Util.lineWrap("Malus: \"You've got my respect... too bad you won't live long enough to tell the tale!\"",lineLength));
					break;
				case 3:
					System.out.print(Util.lineWrap("Malus: \"As if I could lose to you...!\"",lineLength));
					break;
				case 4:
					System.out.print(Util.lineWrap("Malus: \"Your Ultima Chaos... it can't hold a candle to mine...!\"",lineLength));
					malusQuoteCounter = 0;
					break;
			}
			Util.skitPause();
		}
		//quote cycle for 10% - 0% health
		else
		{
			malusQuoteCounter++;
			switch (malusQuoteCounter) {
				case 1:
					System.out.print(Util.lineWrap("Malus: \"Time to step it up! Take this!\"",lineLength));
					break;
				case 2:
					System.out.print(Util.lineWrap("Malus: \"No... I can't be losing! I'm Malus, future overlord of the world! I WILL win!!\"",lineLength));
					break;
				case 3:
					System.out.print(Util.lineWrap("Malus: \"Why. Won't. You. Just. DIE?!\"",lineLength));
					malusQuoteCounter = 0;
					break;
			}
			Util.skitPause();
		}
	}

	/**
	 * Retrieves the boolean boss values for saving purposes.
	 * @return Returns a string with each character a 1 or a 0, corresponding to the value of the boos booleans.
	 */
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

	/**
	 * Sets the boolean boss values.
	 * @param data - a String of 1's and 0's; the same format as returned by {@link #getAll}.
	 */
	public static void setAll(String data)
	{
		malusQuoteCounter = Integer.parseInt(data.substring(0,1));
		placeQuoteCounter = Integer.parseInt(data.substring(1,2));
		
		desBoss = data.charAt(2) == '1';
		plaBoss = data.charAt(3) == '1';
		forBoss = data.charAt(4) == '1';
		mounBoss = data.charAt(5) == '1';
		volBoss = data.charAt(6) == '1';
		cavBoss = data.charAt(7) == '1';
		facBoss = data.charAt(8) == '1';
		urbBoss = data.charAt(9) == '1';
		labBoss = data.charAt(10) == '1';
		milBoss = data.charAt(11) == '1';
		malBoss = data.charAt(12) == '1';
	}
}