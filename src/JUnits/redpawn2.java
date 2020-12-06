package JUnits;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.Deck;

class redpawn2 {

	@Test
	void test() {
		Deck deck=new Deck();
		int moveOutputR2=deck.moveRedPawn2(2);
		assertEquals(5,moveOutputR2);
	}

}
