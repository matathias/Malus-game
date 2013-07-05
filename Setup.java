import java.util.*;

public class Setup
{
	/*
	 * First class and methods that are called.
	 * Introduces the player to the game and initializes their starting class and equipment.
	 */
	 private static Scanner inputWord = new Scanner(System.in);
	 public static Player player;

	 public static void Introduction()
	 {
		Util.lineBreak();
	 	System.out.println("\nWelcome to... The Game!");
	 	System.out.println("The Game is a text-based RPG,\nwith input and output involving the keyboard and text only.");
	 	System.out.println("You will face many dangers in the game, from monsters to\nrobots to an evil villain who can end your game permanently.");
	 	System.out.println("Are you ready for this challenge?");
	 	String answer = Util.yesNoLoop();
	 	if(answer.equalsIgnoreCase("Yes"))
	 	{
	 		System.out.println("Then we begin!!");
	 		Util.pause();
	 		Util.lineBreak();
	 		basicRules();
	 	}
	 	else
	 	{
	 		System.out.println("Oh. Well then. See you later, I guess.");
	 	}
	 }
	 public static void basicRules()
	 {
	 	System.out.println("The rules are simple.\nFollow the prompts to enter either a number or a word (usually \"yes\" or \"no\"),\nand don't die.");
	 	Util.pause();
	 	Util.lineBreak();
	 	System.out.println("\nBattles work in turns.\nFirst, you choose your attack and deal damage to the enemy,\nand then the enemy will do the same to you.");
	 	System.out.println("Through battling you will gain experience and money;\nthe former will increase your HP, EP, and damage,\nwhile the latter will allow you to buy weapons, new attacks, and healing spells.");
	 	System.out.println("\tHP: Health Points; if these reach zero then you die.\n\t    The same applies to your enemies.");
	 	System.out.println("\tEP: Extra Points; these allow you to use special attacks\n\t    and healing spells. You won't die if your EP reaches zero,\n\t    but you'll be sorely disadvantaged.");
	 	System.out.println("\tDamage: Your attack power.\n\t\tYour damage is the base damage you deal with each attack.");
	 	Util.pause();
	 	Util.lineBreak();
	 	System.out.println("HP and EP can be refilled by a level up or by visiting an inn.\nVisiting an inn costs money though, and the price rises as your level increases.");
	 	System.out.println("In each area there will be three or four paths to choose from;\nyou just have to pick one and hope it brings you to the next area!");
	 	System.out.println("Of course, if you pick the wrong path,\nyou'll be forced to go back the way you came.");
	 	System.out.println("This isn't all bad, though - you may want to consider taking dead-end\npaths several times to gain more experience!");
	 	Util.pause();
	 	Util.lineBreak();
	 	System.out.println("Also, sometimes the game will pause without displaying\n\"Press Enter to Continue\",such as with skits.");
	 	System.out.println("All you have to do is press enter, and the game will continue. Example:");
	 	Util.skitPause();
	 	Util.lineBreak();
	 	System.out.println("Now, are you ready... to play The Game?");
	 	String answer = Util.yesNoLoop();
	 	if(answer.equalsIgnoreCase("Yes"))
	 	{
	 		System.out.println("Well said! Time to choose a class!\n");
	 		System.out.println("(But before that - do you have a saved game you wish to load instead?)");
	 		String ans = Util.yesNoLoop();
	 		if(ans.equalsIgnoreCase("Yes"))
	 		{
	 			while (ans.equalsIgnoreCase("Yes"))
	 			{
	 				System.out.print("Enter the file name:   ");
	 				ans = inputWord.nextLine().trim();
	 				boolean success = Util.gameLoad(ans);
	 				if(!success)
	 				{
	 					System.out.print("Try again with a different file name?");
	 					ans = Util.yesNoLoop();
	 				}
	 				else
	 				{
	 					ans = "No";
	 				}
	 			}
	 		}
	 		if(ans.equalsIgnoreCase("No"))
	 		{
	 			System.out.println("Alright then. Onwards!");
	 			Util.pause();
	 			chooseClass();
	 		}
	 	}
	 	else
	 	{
	 		System.out.println("Oh? Perhaps it's good that you quit now.\nThere's no way a sissy could make it through The Game.");
	 	}
	 }
	 public static void chooseClass()
	 {
		Util.lineBreak();
	 	System.out.println("There are six classes in The Game:\nCommando, Berserker, Sentinel, Ravager, Reliever, and Entrepreneur.");
	 	System.out.println("1. Commandos are well-balanced, with average HP, EP, and Damage.");
	 	System.out.println("2. Berserkers are offense-oriented, sacrificing HP to obtain higher\n   damage-dealing power. Berserkers have the highest Damage out of all\n   the classes.");
	 	System.out.println("3. Sentinels are defense-oriented, sacrificing damage-dealing power\n   to obtain higher HP. Sentinels have the highest HP out of all the classes.");
	 	System.out.println("4. Ravagers are offense-oriented special-attack users, sacificing HP\n   to obtain higher EP. Ravagers have the highest EP out of all the classes.");
	 	System.out.println("5. Relievers are defense-oriented special-attack users, sacrificing Damage\n   to obtain higher HP and EP. They have exclusive access to most\n   healing spells.");
	 	System.out.println("6. Entrepreneurs sacrifice a little of everything in order to obtain more\n   money per battle, recieve money from a level up, and pay less at markets.");
	 	System.out.println("Which will you be? (Pick 1-6)");
	 	int choice = Util.numberSelect("",6);
	 	switch(choice)
	 	{
	 		//(HP,Damage,EP,Exp,Money,PlayerName,PlayerClass,Weapon)
	 		case 1:
	 			System.out.println("You choose the Commando Class!"); //80HP, 30EP, 5 Damage
	 			player = new Player(Player.HPMULT*80,Player.DAMMULT*5,Player.EPMULT*30,0,100,"","Commando",new Weapon("Slingshot",0,0,0,0));
	 			break;
	 		case 2:
	 			System.out.println("You choose the Berserker Class!"); //40HP, 20EP, 10 Damage
	 			player = new Player(Player.HPMULT*40,Player.DAMMULT*10,Player.EPMULT*20,0,100,"","Berserker",new Weapon("Wooden Sword",0,0,0,0));
	 			break;
	 		case 3:
	 			System.out.println("You choose the Sentinel Class!"); //160HP, 20EP, 3.5 Damage
	 			player = new Player(Player.HPMULT*160,Player.DAMMULT*3.5,Player.EPMULT*20,0,100,"","Sentinel",new Weapon("Wood Board",0,0,0,0));
	 			break;
	 		case 4:
	 			System.out.println("You choose the Ravager Class!"); //50HP, 90EP, 8 Damage
	 			player = new Player(Player.HPMULT*50,Player.DAMMULT*8,Player.EPMULT*90,0,100,"","Ravager",new Weapon("Worn-down Tome",0,0,0,0));
	 			SpecialAttack ravFirst = new SpecialAttack("Ravager's Genesis","Ravager",25,20,-1,0,5,1.25);
	 			SpecialAttack ravSecond = new SpecialAttack("Beginners' Luck","Ravager",10,10,-1,0,40,10);
	 			player.addSpecialAttack(ravFirst);
	 			player.addSpecialAttack(ravSecond);
	 			break;
	 		case 5:
	 			System.out.println("You choose the Reliever Class!"); //130HP, 75EP, 5 Damage
	 			player = new Player(Player.HPMULT*130,Player.DAMMULT*5,Player.EPMULT*75,0,100,"","Reliever",new Weapon("Wooden Stave",0,0,0,0));
	 			SpecialAttack relFirst = new SpecialAttack("Reliever's Genesis","Reliever",15,15,-1,0,5,1.25);
	 			Healing relSecond = new Healing("Patch Up","Reliever",25,15,1,0);
	 			player.addSpecialAttack(relFirst);
	 			player.addHealing(relSecond);
	 			break;
	 		case 6:
	 			System.out.println("You choose the Entrepreneur Class!");//60HP, 20EP, 3.5 Damage
	 			player = new Player(Player.HPMULT*60,Player.DAMMULT*3.5,Player.EPMULT*20,0,250,"","Entrepreneur",new Weapon("Playing Card",0,0,0,0));
	 			break;
	 	}
	 	Util.pause();
	 	Util.lineBreak();
	 	chooseName();
	 }
	 public static void chooseName()
	 {
	 	System.out.println("Now that you've chosen your class... what's your name?");
	 	String name;
	 	String confirm;
	 	do
	 	{
	 		do
	 		{
	 			System.out.print("Enter a name: ");
	 			name = inputWord.nextLine();
	 			if(name.length()>25)
	 				System.out.println("Really? *That's* your name? Pick something shorter, show-off. Preferrably less than 25 characters.");
	 		}while(name.length()>25);
	 		System.out.print("Are you sure you want the name " + name + "?");
	 		confirm = Util.yesNoLoop();
	 	}while(confirm.equalsIgnoreCase("No"));
	 	player.setPlayerName(name);
	 	System.out.println("Alright! You are now " + player.getPlayerName() + " the " + player.getPlayerClass() + "!\n");
	 	confirmation();
	 }
	 public static void showChoices()
	 {
	 	System.out.println("You have chosen:");
	 	System.out.println("Class: " + player.getPlayerClass());
	 	System.out.println("Name: " + player.getPlayerName());
	 }
	 public static void confirmation()
	 {
	 	showChoices();
	 	System.out.println("Are you okay with these choices?");
	 	String confirm = Util.yesNoLoop();
	 	if(confirm.equalsIgnoreCase("Yes"))
	 	{
	 		System.out.println("You are finally ready to play... The Game!");
	 		PlaceActions game = new PlaceActions(player);
	 		game.end();
	 	}
	 	else
	 	{
	 		System.out.println("Do you:");
	 		System.out.println("1. Want to see the rules again?");
	 		System.out.println("2. Want to pick a different class?");
	 		System.out.println("3. Want to pick a different name?");
	 		int choice = Util.numberSelect("",3);
	 		switch(choice)
	 		{
	 			case 1:
	 				basicRules();
	 				break;
	 			case 2:
	 				chooseClass();
	 				break;
	 			case 3:
	 				chooseName();
	 				break;
	 		}
	 	}
	 }
}
