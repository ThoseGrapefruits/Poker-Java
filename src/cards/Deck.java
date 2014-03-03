package cards;

import java.util.ArrayList;
import java.util.Random;

public class Deck
{
	private Random randomGenerator = new Random();

	/**
	 * Deck of cards to pull from
	 */
	ArrayList < PlayingCard > deck = new ArrayList < PlayingCard >()
	{ // Initializes deck with every card by iterating through numbers and suits.
		{
			for ( int number = 1; number <= 13; number++ )
			{
				for ( int suit = 0; suit <= 3; suit++ )
				{
					this.add( new PlayingCard( number, suit ) );
				}
			}
		}
	};

	public void shuffle()
	{
		this.deck = new Deck().deck;
	}

	public ArrayList < PlayingCard > getDeck()
	{
		return this.deck;
	}

	/**
	 * Removes a random card from the deck.
	 * 
	 * @return the card removed.
	 */
	public PlayingCard drawCard()
	{
		return this.deck.remove( randomGenerator.nextInt( this.deck.size() ) );
	}
}
