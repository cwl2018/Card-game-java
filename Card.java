/**
 * Javadoc of the Card Class
 * 
 * @author ChanWangLeung
 */
public class Card {
	private int suit;
	private int card;

	/**
	 * Constructor, takes 2 integer values
	 * 
	 * @param suit The suit of the card.
	 * 
	 * @param card The card value of the card.
	 */
	public Card(int suit, int card) {
		this.card = card;
		this.suit = suit;
	}

	/**
	 * Getter of card.
	 */
	public int getCard() {
		return this.card;
	}

	/**
	 * Getter of suit
	 */
	public int getSuit() {
		return this.suit;
	}
}