public class HandType
{
	final static int STRAIGHT_FLUSH = 8;
	final static int FOUR_OF_A_KIND = 7;
	final static int FULL_HOUSE = 6;
	final static int FLUSH = 5;
	final static int STRAIGHT = 4;
	final static int THREE_OF_A_KIND = 3;
	final static int TWO_PAIR = 2;
	final static int PAIR = 1;
	final static int HIGH_CARD = 0;

	public static String toString( int highHand )
	{
		String[] list =
		{ "High Card", "Pair", "Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush" };
		return list[ highHand ];
	}
}
