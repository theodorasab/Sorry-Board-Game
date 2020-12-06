package Model.Cards;

public class SimpleNumberCard extends NumberCard {

	/**
	 * inherit functions from NumberCard
	 */
	public SimpleNumberCard( String description, int value) {
		super(false, description, "/images\\cards\\card"+value+".png", value);
		
	}
	
	

	


	
}
