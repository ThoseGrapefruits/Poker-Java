package cards;

import Hand;
import HandType;

import java.util.ArrayList;
import java.util.HashMap;

public class Test
{

	public static void main( String[] args )
	{
		Test test = new Test();
	}

	public void Hand()
	{
		System.out.println( "/// DEBUG ///" );
		Hand myHand = new Hand( new ClubCard( 10 ), new ClubCard( 11 ), new ClubCard( 12 ),
				new ClubCard( 13 ), new ClubCard( 1 ) );

		System.out.println( "\nCards:" );
		for ( PlayingCard currentCard : myHand.hand )
		{
			System.out.println( currentCard.toString() );
		}

		System.out.println( "\nAce High:" );
		ArrayList < PlayingCard > sortListAceHigh = myHand.orderCardsAceHigh();
		for ( PlayingCard currentCard : sortListAceHigh )
		{
			System.out.println( currentCard.toString() );
		}
		System.out.println( "\nAce Low:" );
		ArrayList < PlayingCard > sortListAceLow = myHand.orderCardsAceLow();
		for ( PlayingCard currentCard : sortListAceLow )
		{
			System.out.println( currentCard.toString() );
		}

		System.out.println( "\nHand Value:" );
		System.out.println( Integer.toString( myHand.processHand(), 16 ) );

		System.out.println( "\n" + "High Hand: " + HandType.toString( myHand.highHand ) );

		HashMap < Integer, Integer > checkForMultipleResult = myHand.checkForMultiple();
		System.out.println( "\n" + "Multiples:" );
		for ( int i : myHand.checkForMultiple().keySet() )
		{
			System.out.println( i + "\t" + checkForMultipleResult.get( i ) );
		}

		System.out.println( "\n/// END DEBUG ///" );
	}

}
