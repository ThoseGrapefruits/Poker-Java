public class HighHands
{
	final static int STRAIGHTFLUSH = 8;
	final static int FOUROFAKIND = 7;
	final static int FULLHOUSE = 6;
	final static int FLUSH = 5;
	final static int STRAIGHT = 4;
	final static int THREEOFAKIND = 3;
	final static int TWOPAIR = 2;
	final static int PAIR = 1;
	final static int HIGHCARD = 0;

	public static String toString( int highHand )
	{
		String[] list =
		{ "High Card", "Pair", "Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush" };
		return list[ highHand ];
	}
}
