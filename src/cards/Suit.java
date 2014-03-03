package cards;

public class Suit
{
	final static int CLUBS = 0;
	final static int DIAMONDS = 1;
	final static int HEARTS = 2;
	final static int SPADES = 3;

	public static String toString( int cardSuit )
	{
		if ( cardSuit == 0 )
		{
			return "Clubs";
		}
		else if ( cardSuit == 1 )
		{

			return "Diamonds";
		}
		else if ( cardSuit == 2 )
		{

			return "Hearts";
		}
		else if ( cardSuit == 3 )
		{
			return "Spades";
		}
		else
		{
			return null;
		}
	}
}
