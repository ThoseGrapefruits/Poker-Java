import java.util.ArrayList;

import cards.Deck;
import cards.PlayingCard;

public class Dealer
{
	ArrayList < Player > players;

	Dealer( ArrayList < Player > players )
	{
		this.players = players;
	}

	Deck deck = new Deck();

	/**
	 * Deals the initial 2 cards to each player then
	 */
	void dealPocketCards( ArrayList < Player > players )
	{
		ArrayList < PlayingCard > drawnCards = new ArrayList < PlayingCard >();

		for ( int i = 0; i < players.size() * 2; i++ )
		{
			drawnCards.add( deck.drawCard() );
			if ( i % 2 == 1 )
			{
				System.out.println( drawnCards.get( i ) );
			}
			else
			{
				System.out.print( drawnCards.get( i ) + "\t" );
			}
		}

		for ( int i = 0; i < players.size() * 2; i++ )
		{
			players.get( i % players.size() ).getHand().addCard( drawnCards.get( i ) );
		}
	}

	/**
	 * Draws the initial 3 community cards
	 */
	ArrayList < PlayingCard > drawCommunityCards()
	{
		ArrayList < PlayingCard > communityCards = new ArrayList < PlayingCard >();
		for ( int i = 0; i != 3; i++ )
		{
			communityCards.add( this.deck.drawCard() );

		}
		return communityCards;
	}
}
