/**
 * @author		David Warrick <warrick.david58@gmail.com>
 * @version		0.1
 * @since		2013-06-14
 */
// Man I don't know what the version is, I'm still trying to sort out all my shitty code
public class Game
{
	public static void main (String args[])
	{
		if(args.length > 1 && args[0].equals("--debug"))
		{
			if(args[1].equalsIgnoreCase("Com"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"Debug","Commando",new Weapon("Debug Gun",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Ber"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"Debug","Berserker",new Weapon("Debug Sword",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Sen"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"Debug","Sentinel",new Weapon("Debug Shield",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Rav"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"Debug","Ravager",new Weapon("Debug Tome",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Rel"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"Debug","Reliever",new Weapon("Debug Staff",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Ent"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"Debug","Entrepreneur",new Weapon("Debug Card",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else
			{
				usage();
			}
		}
		else if(args.length == 0)
		{
			Setup.Introduction();
		}
		else
		{
			usage();
		}
	}
	public static void usage()
	{
		System.out.println("Usage: java Game [--debug] [debug class]");
	}
}