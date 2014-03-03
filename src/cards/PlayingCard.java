package cards;

import java.util.Comparator;

public class PlayingCard
{
	private int number = 0;

	/**
	 * @return value of current card.
	 */
	public int getNumber()
	{
		return number;
	}

	private int suit = -1;

	/**
	 * @return the suit of the current card.
	 */
	public int getSuit()
	{
		return suit;
	}

	public PlayingCard( int number, int suit )
	{
		this.number = number;
		this.suit = suit;
	}

	@Override
	public String toString()
	{
		String cardString = "";

		if ( this.number == 1 )
		{
			cardString += "Ace";
		}
		else if ( this.number == 11 )
		{
			cardString += "Jack";
		}
		else if ( this.number == 12 )
		{
			cardString += "Queen";
		}
		else if ( this.number == 13 )
		{
			cardString += "King";
		}
		else
		{
			cardString += ( Integer.toString( this.number ) );
		}

		cardString += " of ";

		if ( this.suit == Suit.CLUBS )
		{
			cardString += "Clubs";
		}
		else if ( this.suit == Suit.DIAMONDS )
		{
			cardString += "Diamonds";
		}
		else if ( this.suit == Suit.HEARTS )
		{
			cardString += "Hearts";
		}
		else
		{
			cardString += "Spades";
		}
		return cardString;
	}

	public static class Comparators
	{
		/**
		 * Compares cards, weighing aces as 1 (lower than all the other cards).
		 */
		public static Comparator < PlayingCard > ACELOW = new Comparator < PlayingCard >()
		{
			@Override
			public int compare( PlayingCard card1, PlayingCard card2 )
			{
				int card1Value = card1.getNumber();
				int card2Value = card2.getNumber();

				return Integer.compare( card1Value, card2Value );
			}
		};

		/**
		 * Compares cards, weighing aces as 14 (higher than all the other cards).
		 */
		public static Comparator < PlayingCard > ACEHIGH = new Comparator < PlayingCard >()
		{
			@Override
			public int compare( PlayingCard card1, PlayingCard card2 )
			{
				int card1Value = card1.getNumber();
				int card2Value = card2.getNumber();
				if ( card1Value == 1 )
				{
					card1Value = 14;
				}
				else if ( card2Value == 1 )
				{
					card2Value = 14;
				}

				return Integer.compare( card1Value, card2Value );
			}
		};
	}
}
