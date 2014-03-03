import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import cards.PlayingCard;

public class Hand implements Comparable < Hand >
{

	int handType = -1;

	int value = 0;

	/**
	 * The list of PlayingCards making up the current hand.
	 */
	private ArrayList < PlayingCard > cards = new ArrayList < PlayingCard >();

	private ArrayList < PlayingCard > usedCards = new ArrayList < PlayingCard >();

	private ArrayList < PlayingCard > unusedCards = new ArrayList < PlayingCard >();

	public int getValue()
	{
		return value;
	}

	public int getHandType()
	{
		return handType;
	}

	public ArrayList < PlayingCard > getCards()
	{
		return cards;
	}

	/**
	 * Initialize a hand from an array of cards
	 * 
	 * @param initCards
	 */
	Hand( ArrayList < PlayingCard > initCards )
	{
		if ( initCards.size() > 5 )
		{
			System.out.println( "ERROR: Too many cards given." );
		}
		else
		{
			this.cards = initCards;
			this.evaluateHand();
		}
	}

	Hand()
	{
		this.cards = new ArrayList < PlayingCard >();
	}

	/**
	 * Initialize a hand with individual cards as parameters.
	 * 
	 * @param card1
	 * @param card2
	 * @param card3
	 * @param card4
	 * @param card5
	 */
	Hand( PlayingCard card1, PlayingCard card2, PlayingCard card3, PlayingCard card4,
			PlayingCard card5 )
	{
		this.cards.add( card1 );
		this.cards.add( card2 );
		this.cards.add( card3 );
		this.cards.add( card4 );
		this.cards.add( card5 );

		this.evaluateHand();
	}

	Hand( PlayingCard card1, PlayingCard card2 )
	{
		this.cards.add( card1 );
		this.cards.add( card2 );

		this.evaluateHand();
	}

	/**
	 * Adds a card to the hand if there aren't already 5 cards. This is just a safety check, this should never happen.
	 * 
	 * @param addedCard is the card to be added
	 * @return true if a card was added successfully and false if not.
	 */
	public boolean addCard( PlayingCard addedCard )
	{
		if ( this.cards.size() < 5 )
		{
			for ( PlayingCard currentCard : this.cards )
			{
				if ( currentCard.getNumber() == 0 )
				{
					currentCard = addedCard;
					break;
				}
			}
			this.evaluateHand();
			return true;
		}
		return false;
	}

	/**
	 * Sets the highest hand value provided, first making sure that it hasn't been used already.
	 * 
	 * @param newHighHand is the hand value to be set.
	 */
	void setHighHand( int newHighHand )
	{
		if ( newHighHand > this.handType )
		{
			this.handType = newHighHand;
		}
	}

	/**
	 * Function to be called once a full hand is made. Takes care of setting the hand's values correctly.
	 * 
	 * @return the value of the hand.
	 */
	int evaluateHand()
	{
		calcHighHand();
		return setHandValue();
	}

	/**
	 * Calculates the highest scoring combination in the current hand.
	 * 
	 * @return the integer value of the highest hand.
	 */
	int calcHighHand()
	{
		HashMap < Integer, Integer > checkForMultipleResult = this.checkForMultiple();
		// TODO add high card ordering.
		if ( checkForMultipleResult.containsValue( 2 ) )
		{
			if ( checkForMultipleResult.containsValue( 3 ) )
			{ // Full House
				setHighHand( HandType.FULL_HOUSE );
				this.usedCards = this.cards;
			}
			else
			{
				int pairCount = 0;
				for ( int key : checkForMultipleResult.keySet() )
				{
					if ( checkForMultipleResult.get( key ) == 2 )
					{
						pairCount++;
					}
				}
				if ( pairCount == 2 )
				{ // Two pair
					setHighHand( HandType.TWO_PAIR );
					setOrder( checkForMultipleResult );
				}
				else
				{
					setHighHand( HandType.PAIR );
					setOrder( checkForMultipleResult );
				}
			}
		}
		else if ( checkForMultipleResult.containsValue( 3 ) )
		{ // Three of a Kind
			setHighHand( HandType.THREE_OF_A_KIND );
			setOrder( checkForMultipleResult );
		}
		else if ( checkForMultipleResult.containsValue( 4 ) )
		{ // Four of a Kind
			setHighHand( HandType.FOUR_OF_A_KIND );
			setOrder( checkForMultipleResult );
		}
		else
		{
			if ( this.checkForStraightAceLow() || this.checkForStraightAceHigh() )
			{
				if ( this.checkForFlush() )
				{ // Straight Flush
					setHighHand( HandType.STRAIGHT_FLUSH );
					this.usedCards = this.cards;
				}
				else
				{ // Straight
					setHighHand( HandType.STRAIGHT );
					this.usedCards = this.cards;
				}
			}
			else if ( this.checkForFlush() )
			{ // Flush
				setHighHand( HandType.FLUSH );
				this.usedCards = this.cards;
			}
			else
			{
				setHighHand( HandType.HIGH_CARD );
				this.usedCards = this.cards;
			}
		}

		return this.getHandType();
	}

	/**
	 * Decides which cards to use first for calculating the high card based on the current hand.
	 * 
	 * @param checkForMultipleResult is the HashMap of multiple cards and the number of times they occur.
	 */
	void setOrder( HashMap < Integer, Integer > checkForMultipleResult )
	{
		ArrayList < PlayingCard > tempUsedCards = new ArrayList < PlayingCard >();
		ArrayList < PlayingCard > tempUnusedCards = new ArrayList < PlayingCard >();
		ArrayList < Integer > keySet = new ArrayList < Integer >();
		keySet.addAll( checkForMultipleResult.keySet() );
		Collections.sort( keySet );
		Collections.reverse( keySet );

		for ( PlayingCard currentCard : this.cards )
		{
			for ( int currentKey : keySet )
			{
				if ( currentCard.getNumber() == currentKey )
				{
					tempUsedCards.add( currentCard );
				}
				else if ( !keySet.contains( currentCard.getNumber() )
						&& !tempUsedCards.contains( currentCard )
						&& !tempUnusedCards.contains( currentCard ) )
				{
					tempUnusedCards.add( currentCard );
				}
			}
		}
		this.usedCards = tempUsedCards;

		this.unusedCards = tempUnusedCards;

	}

	/**
	 * Checks the current hand for a flush.
	 * 
	 * @return true if it is a flush, false if not.
	 */
	boolean checkForFlush()
	{
		for ( int i = 1; i < this.cards.size(); i++ )
		{ // Flush
			if ( this.cards.get( i ).getSuit() != this.cards.get( 0 ).getSuit() )
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the current hand for an ace-low straight (both ace high and ace low).
	 * 
	 * @return true if it is a straight, false if not.
	 */
	boolean checkForStraightAceLow()
	{
		ArrayList < PlayingCard > sortedListAceLow = this.orderCardsAceLow();
		int startValue = sortedListAceLow.get( 0 ).getNumber();
		for ( int i = 1; i < sortedListAceLow.size(); i++ )
		{ // Straight Ace Low
			if ( !( sortedListAceLow.get( i ).getNumber() == startValue + i ) )
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the current hand for an ace-high straight (both ace high and ace low).
	 * 
	 * @return true if it is a straight, false if not.
	 */
	boolean checkForStraightAceHigh()
	{
		ArrayList < PlayingCard > sortedListAceHigh = this.orderCardsAceHigh();
		int startValue = sortedListAceHigh.get( 0 ).getNumber();
		for ( int i = 1; i < sortedListAceHigh.size(); i++ )
		{ // Straight Ace High
			if ( !( sortedListAceHigh.get( i ).getNumber() == startValue + i ) )
			{
				if ( ( sortedListAceHigh.get( i ).getNumber() != 1 ) || ( startValue + i != 14 ) )
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Updates the current hand's value with a base-16 representation of the hand's value.
	 * 
	 * Handles card ordering using the cards that have been used and have not been used in the hand, as provided by setOrder().
	 * 
	 * @return integer representation of the card's value
	 */
	int setHandValue()
	{
		int handValue = this.handType * 0x100000;
		int i = 0;
		int n = 0x10000;
		ArrayList < PlayingCard > reverseUsedList = this.usedCards;
		Collections.sort( reverseUsedList, PlayingCard.Comparators.ACEHIGH );

		Collections.reverse( reverseUsedList );
		while ( i < reverseUsedList.size() )
		{
			int currentNumber = reverseUsedList.get( i ).getNumber();

			if ( currentNumber == 1 && !( this.checkForStraightAceLow() ) )
			{
				handValue += 0xe * n;
			}
			else
			{
				handValue += currentNumber * n;
			}

			i++;
			n /= 0x10;
		}
		if ( this.unusedCards != null )
		{
			ArrayList < PlayingCard > reverseUnusedList = this.unusedCards;
			Collections.sort( reverseUnusedList, PlayingCard.Comparators.ACEHIGH );
			Collections.reverse( reverseUnusedList );
			i = 0;
			while ( i < reverseUnusedList.size() )
			{
				int currentNumber = reverseUnusedList.get( i ).getNumber();

				if ( currentNumber == 1 && !( this.checkForStraightAceLow() ) )
				{
					handValue += 0xe * n;
				}
				else
				{
					handValue += currentNumber * n;
				}

				i++;
				n /= 0x10;
			}
		}
		this.value = handValue;
		return handValue;
	}

	/**
	 * Sorts cards with aces as high card.
	 * 
	 * @return a sorted list, with aces as the high card.
	 */
	ArrayList < PlayingCard > orderCardsAceHigh()
	{
		ArrayList < PlayingCard > sortList = this.cards;

		Collections.sort( sortList, PlayingCard.Comparators.ACEHIGH );

		return sortList;
	}

	/**
	 * Sorts cards with aces as low card.
	 * 
	 * @return a sorted list, with aces as the low card.
	 */
	ArrayList < PlayingCard > orderCardsAceLow()
	{
		ArrayList < PlayingCard > sortList = this.cards;

		Collections.sort( sortList, PlayingCard.Comparators.ACELOW );

		return sortList;
	}

	/**
	 * Checks for multiples of cards, including pairs, two pairs, three of a kind, and four of a kind.
	 * 
	 * @return HashMap of cards that are multiple and their counts.
	 */
	HashMap < Integer, Integer > checkForMultiple()
	{
		HashMap < Integer, Integer > cardsFound = new HashMap < Integer, Integer >();
		HashMap < Integer, Integer > multiplesFound = new HashMap < Integer, Integer >();
		for ( int i = 0; i < this.cards.size(); i++ )
		{
			PlayingCard card = this.cards.get( i );
			if ( !cardsFound.containsKey( card.getNumber() ) )
			{
				cardsFound.put( card.getNumber(), 1 );
			}
			else
			{
				cardsFound.put( card.getNumber(), cardsFound.get( card.getNumber() ) + 1 );
			}
		}

		for ( int i : cardsFound.keySet() )
		{
			if ( cardsFound.get( i ) > 1 )
			{
				multiplesFound.put( i, cardsFound.get( i ) );
			}
		}
		return multiplesFound;
	}

	/**
	 * OBSOLETE. Using checkForMultiple instead, as it is faster and can be used for more things.
	 * 
	 * Checks hand of cards for a pair (2 cards of equal value).
	 * 
	 * @return true if pair is found in hand, false if not.
	 */
	/*
	 * boolean checkForPair()
	 * {
	 * // Iterate through hand and check the cards following the current position
	 * // for equivalent value to the card at the current position in the hand.
	 * for ( int i = 0; i < this.hand.length; i++ )
	 * {
	 * PlayingCard card = this.hand[ i ];
	 * 
	 * for ( int n = i + 1; n <= this.hand.length; n++ )
	 * {
	 * if ( card.getValue() == this.hand[ n ].getValue() )
	 * {
	 * return true;
	 * }
	 * }
	 * }
	 * return false;
	 * }
	 * 
	 * PlayingCard[] checkForPairHelper( PlayingCard[] inputList )
	 * {
	 * // Iterate through hand and check the cards following the current position
	 * // for equivalent value to the card at the current position in the hand.
	 * for ( int i = 0; i < inputList.length; i++ )
	 * {
	 * PlayingCard card = inputList[ i ];
	 * 
	 * for ( int n = i + 1; n <= inputList.length; n++ )
	 * {
	 * if ( card.getValue() == inputList[ n ].getValue() )
	 * {
	 * return true;
	 * }
	 * }
	 * }
	 * return false;
	 * }
	 * 
	 * boolean checkForTwoPair()
	 * {
	 * PlayingCard[] copyList = this.hand;
	 * 
	 * PlayingCard[] firstPair = this.checkForPairHelper( copyList );
	 * if ( !firstPair.length != 0 )
	 * {
	 * 
	 * }
	 * }
	 */

	@Override
	public int compareTo( Hand o )
	{
		return Integer.compare( this.getValue(), o.getValue() );
	}
}

class HandComparator implements Comparator < Hand >
{
	@Override
	public int compare( Hand a, Hand b )
	{
		return Integer.compare( a.value, b.value );
	}
}
