import java.util.HashMap;

import cards.ClubCard;
import cards.Deck;
import cards.DiamondCard;
import cards.HeartCard;
import cards.PlayingCard;
import cards.SpadeCard;

public class Test
{
	public static void main( String[] args )
	{
		System.out.print( "/// TEST ///\n\n" );

		Test test = new Test();
		test.hand();
		// test.deck();
		// test.table();

		System.out.print( "\n\n/// END TEST ///" );
	}

	/**
	 * Tests the Hand class by instantiating it with cards, printing those cards,
	 * printing the hand value (in hexadecimal), printing the high hand, and printing
	 * the multiples occurences of cards.
	 */
	public void hand()
	{
		System.out.print( "\n\n--- Hand Test ---\n\n" );

		Hand hand1 = new Hand( new DiamondCard( 10 ), new DiamondCard( 11 ), new DiamondCard( 12 ),
				new DiamondCard( 13 ), new DiamondCard( 1 ) );
		Hand hand2 = new Hand( new DiamondCard( 3 ), new DiamondCard( 1 ), new DiamondCard( 4 ),
				new DiamondCard( 2 ), new DiamondCard( 5 ) );
		Hand hand3 = new Hand( new DiamondCard( 10 ), new DiamondCard( 9 ), new DiamondCard( 8 ),
				new DiamondCard( 7 ), new DiamondCard( 6 ) );
		Hand hand4 = new Hand( new DiamondCard( 10 ), new ClubCard( 11 ), new HeartCard( 12 ),
				new SpadeCard( 13 ), new DiamondCard( 1 ) );
		Hand hand5 = new Hand( new SpadeCard( 3 ), new SpadeCard( 1 ), new SpadeCard( 4 ),
				new SpadeCard( 2 ), new ClubCard( 5 ) );
		Hand hand6 = new Hand( new ClubCard( 10 ), new ClubCard( 9 ), new DiamondCard( 8 ),
				new DiamondCard( 7 ), new HeartCard( 6 ) );
		Hand hand7 = new Hand( new DiamondCard( 10 ), new DiamondCard( 11 ), new DiamondCard( 12 ),
				new DiamondCard( 13 ), new DiamondCard( 2 ) );
		Hand hand8 = new Hand( new SpadeCard( 3 ), new SpadeCard( 1 ), new SpadeCard( 4 ),
				new SpadeCard( 2 ), new SpadeCard( 6 ) );
		Hand hand9 = new Hand( new ClubCard( 10 ), new ClubCard( 9 ), new ClubCard( 8 ),
				new ClubCard( 7 ), new ClubCard( 5 ) );
		// Just a pair
		Hand hand10 = new Hand( new ClubCard( 10 ), new ClubCard( 9 ), new ClubCard( 8 ),
				new ClubCard( 7 ), new DiamondCard( 10 ) );
		// Just a three of a kind
		Hand hand11 = new Hand( new DiamondCard( 10 ), new DiamondCard( 11 ), new ClubCard( 10 ),
				new DiamondCard( 13 ), new SpadeCard( 10 ) );
		// Full House
		Hand hand12 = new Hand( new DiamondCard( 10 ), new DiamondCard( 11 ), new ClubCard( 10 ),
				new SpadeCard( 11 ), new SpadeCard( 10 ) );
		// Four of a Kind
		Hand hand13 = new Hand( new DiamondCard( 10 ), new ClubCard( 9 ), new DiamondCard( 9 ),
				new SpadeCard( 9 ), new HeartCard( 9 ) );
		Hand hand14 = new Hand( new DiamondCard( 10 ), new ClubCard( 11 ), new HeartCard( 12 ),
				new SpadeCard( 13 ), new DiamondCard( 3 ) );
		Hand hand15 = new Hand( new SpadeCard( 10 ), new SpadeCard( 11 ), new DiamondCard( 10 ),
				new ClubCard( 11 ), new ClubCard( 5 ) );

		hand1.evaluateHand();
		hand2.evaluateHand();
		hand3.evaluateHand();
		hand4.evaluateHand();
		hand5.evaluateHand();
		hand6.evaluateHand();
		hand7.evaluateHand();
		hand8.evaluateHand();
		hand9.evaluateHand();
		hand10.evaluateHand();
		hand11.evaluateHand();
		hand12.evaluateHand();
		hand13.evaluateHand();
		hand14.evaluateHand();
		hand15.evaluateHand();

		// Straight Flush checks:
		if ( hand1.handType == HandType.FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand1 was determined as a flush instead of a straight flush. Check your evaluateHand and checkForStraight logic" );
		}
		else if ( hand1.handType == HandType.STRAIGHT )
		{
			System.out
					.println( "FAILURE: Your hand1 was determined as a straight instead of a straight flush. Check your evaluateHand and checkForFlush logic" );
		}
		else if ( hand1.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out.println( "SUCCESS: Your hand1 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand1 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		if ( hand2.handType == HandType.FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand2 was determined as a flush instead of a straight flush. Check your evaluateHand and checkForStraight logic" );
		}
		else if ( hand2.handType == HandType.STRAIGHT )
		{
			System.out
					.println( "FAILURE: Your hand2 was determined as a straight instead of a straight flush. Check your evaluateHand and checkForFlush logic" );
		}
		else if ( hand2.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out.println( "SUCCESS: Your hand2 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand2 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		if ( hand3.handType == HandType.FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand3 was determined as a flush instead of a straight flush. Check your evaluateHand and checkForStraight logic" );
		}
		else if ( hand3.handType == HandType.STRAIGHT )
		{
			System.out
					.println( "FAILURE: Your hand3 was determined as a straight instead of a straight flush. Check your evaluateHand and checkForFlush logic" );
		}
		else if ( hand3.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out.println( "SUCCESS: Your hand3 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand3 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		// Straight checks:
		if ( hand4.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand4 was determined as a straight flush instead of a straight. Check your evaluateHand and checkForFlush logic" );
		}
		else if ( hand4.handType == HandType.STRAIGHT )
		{
			System.out.println( "SUCCESS: Your hand4 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand4 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		if ( hand5.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand5 was determined as a straight flush instead of a straight. Check your evaluateHand and checkForFlush logic" );
		}
		else if ( hand5.handType == HandType.STRAIGHT )
		{
			System.out.println( "SUCCESS: Your hand5 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand5 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		if ( hand6.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand6 was determined as a straight flush instead of a straight. Check your evaluateHand and checkForFlush logic" );
		}
		else if ( hand6.handType == HandType.STRAIGHT )
		{
			System.out.println( "SUCCESS: Your hand6 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand6 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		// Flush checks:
		if ( hand7.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand7 was determined as a straight flush instead of a flush. Check your evaluateHand and checkForStraight logic" );
		}
		else if ( hand7.handType == HandType.FLUSH )
		{
			System.out.println( "SUCCESS: Your hand7 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand7 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		if ( hand8.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand8 was determined as a straight flush instead of a flush. Check your evaluateHand and checkForStraight logic" );
		}
		else if ( hand8.handType == HandType.FLUSH )
		{
			System.out.println( "SUCCESS: Your hand8 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand8 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		if ( hand9.handType == HandType.STRAIGHT_FLUSH )
		{
			System.out
					.println( "FAILURE: Your hand9 was determined as a straight flush instead of a flush. Check your evaluateHand and checkForStraight logic" );
		}
		else if ( hand9.handType == HandType.FLUSH )
		{
			System.out.println( "SUCCESS: Your hand9 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand9 was incorrectly evaluated. Check your checkForStraight, checkForFlush, checkForStraightFlush, and evaluateHand logic" );
		}

		// Pair check:
		if ( hand10.handType == HandType.PAIR )
		{
			System.out.println( "SUCCESS: Your hand10 was evaluated correctly!" );
		}
		else
		{
			System.out
					.println( "FAILURE: Your hand10 was incorrectly evaluated. Check your checkForPair and evaluateHand logic" );
		}

		// Three of a Kind check:
		if ( hand11.handType == HandType.PAIR )
		{
			System.out
					.println( "FAILURE: Your hand11 was incorrectly evaluated as a pair instead of a three-of-a-kind. Check your checkForThreeOfAKind and evaluateHand logic" );
		}
		else if ( hand11.handType == HandType.THREE_OF_A_KIND )
		{
			System.out.println( "SUCCESS: Your hand11 was evaluated correctly!" );
		}
		else
		{
			System.out.println( "FAILURE: Your hand11 was incorrectly evaluated. Check your logic" );
		}

		// Full House check:
		if ( hand12.handType == HandType.PAIR )
		{
			System.out
					.println( "FAILURE: Your hand12 was incorrectly evaluated as a pair instead of a full house. Check your checkForThreeOfAKind, checkForFullHouse and evaluateHand logic" );
		}
		else if ( hand12.handType == HandType.TWO_PAIR )
		{
			System.out
					.println( "FAILURE: Your hand12 was incorrectly evaluated as two pair instead of a full house. Check your checkForThreeOfAKind, checkForFullHouse, and evaluateHand logic" );
		}
		else if ( hand12.handType == HandType.THREE_OF_A_KIND )
		{
			System.out
					.println( "FAILURE: Your hand12 was incorrectly evaluated as a three-of-a-kind instead of a full house. Check your checkForFullHouse and evaluateHand logic" );
		}
		else if ( hand12.handType == HandType.FULL_HOUSE )
		{
			System.out.println( "SUCCESS: Your hand12 was evaluated correctly!" );
		}
		else
		{
			System.out.println( "FAILURE: Your hand12 was incorrectly evaluated. Check your logic" );
		}

		// Four of a Kind check:
		if ( hand13.handType == HandType.PAIR )
		{
			System.out
					.println( "FAILURE: Your hand13 was incorrectly evaluated as a pair instead of a four-of-a-kind. Check your checkForFourOfAKind and evaluateHand logic" );
		}
		else if ( hand13.handType == HandType.THREE_OF_A_KIND )
		{
			System.out
					.println( "FAILURE: Your hand13 was incorrectly evaluated as a three-of-a-kind instead of a four-of-a-kind. Check your checkForFourOfAKind and evaluateHand logic" );
		}
		else if ( hand13.handType == HandType.FOUR_OF_A_KIND )
		{
			System.out.println( "SUCCESS: Your hand13 was evaluated correctly!" );
		}
		else
		{
			System.out.println( "FAILURE: Your hand13 was incorrectly evaluated. Check your logic" );
		}

		// High Card check:
		if ( hand14.handType == HandType.HIGH_CARD )
		{
			System.out.println( "SUCCESS: Your hand14 was evaluated correctly!" );
		}
		else
		{
			System.out.println( "FAILURE: Your hand14 was incorrectly evaluated. Check your logic" );
		}

		// Two Pair check:
		if ( hand15.handType == HandType.PAIR )
		{
			System.out
					.println( "FAILURE: Your hand15 was incorrectly evaluated as a pair instead of two pair. Check your checkForTwoPair and evaluateHand logic" );
		}
		else if ( hand15.handType == HandType.TWO_PAIR )
		{
			System.out.println( "SUCCESS: Your hand15 was evaluated correctly!" );
		}
		else
		{
			System.out.println( "FAILURE: Your hand15 was incorrectly evaluated. Check your logic" );
		}

		/*
		 * Hand myHand = new Hand( new ClubCard( 11 ), new HeartCard( 11 ), new DiamondCard( 3 ),
		 * new SpadeCard( 12 ), new ClubCard( 12 ) );
		 * 
		 * System.out.println( "\nCards:" );
		 * for ( PlayingCard currentCard : myHand.getCards() )
		 * {
		 * System.out.println( currentCard.toString() );
		 * }
		 * 
		 * System.out.println( "\nHand Value:" );
		 * System.out.println( Integer.toString( myHand.getValue(), 16 ) );
		 * 
		 * System.out.println( "\n" + "High Hand: " + HandType.toString( myHand.highHand ) );
		 * 
		 * HashMap < Integer, Integer > checkForMultipleResult = myHand.checkForMultiple();
		 * System.out.println( "\n" + "Multiples:" );
		 * System.out.println( "Card\tOccurrences" );
		 * for ( int i : myHand.checkForMultiple().keySet() )
		 * {
		 * System.out.println( i + "\t" + checkForMultipleResult.get( i ) );
		 * }
		 */

		System.out.print( "\n\n--- End Hand Test ---\n\n" );
	}

	/**
	 * Tests the Deck class by printing out all the cards in the deck then randomly
	 * drawing cards until the deck is empty.
	 */
	public void deck()
	{
		System.out.print( "\n\n--- Deck Test ---\n\n" );
		Deck myDeck = new Deck();
		for ( PlayingCard currentCard : myDeck.getDeck() )
		{
			System.out.println( currentCard.toString() );
		}

		while ( myDeck.getDeck().size() > 0 )
		{
			System.out.println( myDeck.drawCard() );
		}
		System.out.print( "\n\n--- End Deck Test ---\n\n" );
	}

	/**
	 * Tests the Table class
	 */
	public void table()
	{
		System.out.print( "\n\n--- Table Test ---\n\n" );
		Table table = new Table( 4 );
		for ( Player currentPlayer : table.players )
		{
			System.out.println( currentPlayer.index + "\t" + currentPlayer.getName() + "\t"
					+ currentPlayer.getHand() );
		}

		table.dealer.dealPocketCards( table.players );

		for ( Player currentPlayer : table.players )
		{
			System.out.println( currentPlayer.index + "\t" + currentPlayer.getName() + "\t"
					+ currentPlayer.getHand() );
		}

		System.out.print( "\n\n--- End Table Test ---\n\n" );
	}
}
