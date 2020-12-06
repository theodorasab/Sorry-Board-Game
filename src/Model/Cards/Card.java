package Model.Cards;

/**
 * @version 1.0
 * @author theodora
 */

abstract public class Card {

	private boolean isPlayed;
	private String description;
	private String image;
	private int value;

	/**
	 * constructor that initialises if the card has played,the description,the image
	 * and the value of card
	 */
	public Card(boolean isPlayed, String description, String image, int value) {
		this.isPlayed = isPlayed;
		this.description = description;
		this.image = image;
		this.value = value;

	}

	/**
	 * this method sets if a card is played
	 */
	public void setPlayed(boolean isPlayed) {
		this.isPlayed = isPlayed;
	}

	/**
	 * postcondition: returns isPlayed
	 * 
	 * @return that is played
	 */
	public boolean getPlayed() {
		return this.isPlayed;
	}

	/**
	 * this method sets the description
	 */
	public void setDescription(String description) {
		this.description = description;

	}

	/**
	 * postcondition:returns description
	 * 
	 * @return the descriptions
	 */
	public String getDescription() {
		return this.description;

	}

	/**
	 * gets image path
	 * 
	 * @return image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * gets value of card
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}

}
