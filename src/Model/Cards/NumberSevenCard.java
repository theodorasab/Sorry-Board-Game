package Model.Cards;

import Model.Pawn;

public class NumberSevenCard extends NumberCard {
	/**
	 * inherit functions from NumberCard
	 */
	public NumberSevenCard( String description, int value) {
		super(false, description, "/images\\cards\\card7.png", value);
		
	}
	
/**
 * this method checks card
 * @param pawn
 * @param pawn1
 * @param x
 * @param y
 * @return
 */
	
	
	public boolean checkCard(Pawn pawn,Pawn pawn1,int x,int y) {
		
		return true;
	}
	
	
}
