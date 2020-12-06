package JUnits;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.Deck;

class yellowpawn1 {

	@Test
	void test() {
		Deck deck=new Deck();
		int moveOutputY1=deck.moveYellowPawn1(5);
		assertEquals(38,moveOutputY1);
	}

}
