public class Game
{
	public static void main (String args[])
	{
		if(args.length > 1 && args[0].equals("--debug"))
		{
			if(args[1].equalsIgnoreCase("Com"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"","Commando",new Weapon("Debug Gun",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Ber"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"","Berserker",new Weapon("Debug Sword",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Sen"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"","Sentinel",new Weapon("Debug Shield",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Rav"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"","Ravager",new Weapon("Debug Tome",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Rel"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"","Reliever",new Weapon("Debug Staff",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else if(args[1].equalsIgnoreCase("Ent"))
			{
				Player player = new Player(1000000,500,1000000,0,1000000,"","Entrepreneur",new Weapon("Debug Card",1000000,10,10,50));
				player.setLvl(100);
				PlaceActions game = new PlaceActions(player);
		 		game.end();
			}
			else
			{
				usage(args);
			}
		}
		else if(args.length == 0)
		{
			Setup.Introduction();
		}
		else
		{
			usage(args);
		}
	}
	public static void usage(String args[])
	{
		System.out.println("Usage: java Game [--debug] [debug class]");
	}
}