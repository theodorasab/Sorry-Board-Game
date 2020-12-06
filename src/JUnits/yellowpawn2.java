package JUnits;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.Deck;

class yellowpawn2 {

	@Test
	void test() {
		Deck deck=new Deck();
		int moveOutputY2=deck.moveYellowPawn2(3);
		assertEquals(36,moveOutputY2);
		
	}

}
