import java.util.Comparator;

public class PlayingCard
{
	private int value;

	public int getValue()
	{
		return value;
	}

	private int suit;

	public int getSuit()
	{
		return suit;
	}

	PlayingCard( int number, int suit )
	{
		this.value = number;
		this.suit = suit;
	}

	@Override
	public String toString()
	{
		String cardString = "";

		if ( this.value == 1 )
		{
			cardString += ( "Ace" );
		}
		else if ( this.value == 11 )
		{
			cardString += ( "Jack" );
		}
		else if ( this.value == 12 )
		{
			cardString += ( "Queen" );
		}
		else if ( this.value == 13 )
		{
			cardString += ( "King" );
		}
		else
		{
			cardString += ( Integer.toString( this.value ) );
		}

		cardString += ( " " );

		if ( this.suit == Suit.CLUBS )
		{
			cardString += ( "of Clubs" );
		}
		else if ( this.suit == Suit.DIAMONDS )
		{
			cardString += ( "of Diamonds" );
		}
		else if ( this.suit == Suit.HEARTS )
		{
			cardString += ( "of Hearts" );
		}
		else
		{
			cardString += ( "of Spades" );
		}
		return cardString;
	}

	public static class Comparators
	{
		// Compares the cards by their integer value. If equal, compares by value of suit.
		// (this second part isn't entirely necessary, but it's an easy way to order them)
		public static Comparator < PlayingCard > ACELOW = new Comparator < PlayingCard >()
		{
			@Override
			public int compare( PlayingCard card1, PlayingCard card2 )
			{
				int card1Value = card1.getValue();
				int card2Value = card2.getValue();
				// if ( card1Value != card2Value )
				// {
				return Integer.compare( card1Value, card2Value );
				// }
				// else
				// {
				// return Integer.compare( card1.getSuit(), card2.getSuit() );
				// }
			}
		};

		public static Comparator < PlayingCard > ACEHIGH = new Comparator < PlayingCard >()
		{
			@Override
			public int compare( PlayingCard card1, PlayingCard card2 )
			{
				int card1Value = card1.getValue();
				int card2Value = card2.getValue();
				if ( card1Value == 1 )
				{
					card1Value = 14;
				}
				else if ( card2Value == 1 )
				{
					card2Value = 14;
				}

				// if ( card1Value != card2Value )
				// {
				return Integer.compare( card1Value, card2Value );
				// }
				// else
				// {
				// return Integer.compare( card1.getSuit(), card2.getSuit() );
				// }
			}
		};
	}
}
