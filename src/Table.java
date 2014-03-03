import java.util.ArrayList;

public class Table
{
	ArrayList < Player > players = new ArrayList < Player >();

	Dealer dealer = new Dealer( players );

	/**
	 * Creates a new "table" with the given number of players.
	 * 
	 * @param playerCount is the number of players to include initially on the table.
	 */
	Table( int playerCount )
	{
		if ( playerCount <= 10 )
		{
			for ( int i = 0; i < playerCount; i++ )
			{
				players.add( new Player( i ) );
			}
		}
		else
		{
			System.out.println( "Too many players: 10 maximum." );
		}

	}
}
