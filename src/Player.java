import cards.PlayingCard;

public class Player
{
	private Hand myHand = new Hand();

	int money = 0;

	int index = -1;

	private String name;

	public String getName()
	{
		return name;
	}

	public Hand getHand()
	{
		return myHand;
	}

	public int getMoney()
	{
		return money;
	}

	int bid;

	Player( int index )
	{
		this.index = index;
		this.name = "Anonymous" + this.index;
	}

	Player( int index, PlayingCard card1, PlayingCard card2 )
	{
		this.index = index;
		this.name = "Anonymous" + this.index;
		myHand = new Hand( card1, card2 );
	}
}
