package Model.Cards;

abstract public class NumberCard extends Card {
	private int number;
	private boolean isPlayed;

	/**
	 * inherit functions from Card
	 */
	public NumberCard(boolean isPlayed, String description, String image, int value) {
		super(isPlayed, description, image, value);
	}

	

	/**
	 * this number returns number of card postcondiiton:returns isplayed
	 * 
	 * @return this.isPlayed
	 */
	public boolean getisPlayed() {
		return this.isPlayed;
	}

	/**
	 * this number returns number of card
	 * 
	 * @return this.number
	 */
	public int getNumber(int number) {
		return this.number;
	}

}
