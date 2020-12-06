package JUnits;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.Deck;

class redpawn1 {

	@Test
	void test() {
		Deck deck=new Deck();
		int moveOutputR1=deck.moveRedPawn1(7);
		assertEquals(10,moveOutputR1);
	}

}
