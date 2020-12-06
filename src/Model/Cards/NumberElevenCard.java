package Model.Cards;

import Model.Pawn;

public class NumberElevenCard extends NumberCard {

	/**
	 * inherit functions from NumberCard
	 */
	public NumberElevenCard(String description, int value) {
		super(false, description, "/images\\cards\\card11.png", value);

	}

	/**
	 * this method exchanges the pawns of players
	 * 
	 * @param pawn
	 * @param pawn1
	 */
	public void exchange(Pawn pawn, Pawn pawn1) {

	}

	/**
	 * gets image path
	 * 
	 * @param path
	 * @return path
	 */
	public String getImage(String path) {
		return path;
	}
}
