package Model;

import java.util.ArrayList;
import java.util.Collections;

import Model.Cards.Card;
import Model.Cards.NumberElevenCard;
import Model.Cards.NumberFourCard;
import Model.Cards.NumberOneCard;
import Model.Cards.NumberSevenCard;
import Model.Cards.NumberTenCard;
import Model.Cards.NumberTwoCard;
import Model.Cards.SimpleNumberCard;
import Model.Cards.SorryCard;

//import View.Board;
public class Deck {
	private Dashboard dash;
	private Player redPlayer, yellowPlayer;
	private int red1position = 3;
	private int red2position = 3;
	private int yellow1position = 33;
	private int yellow2position = 33;
	private static ArrayList<Card> cards = new ArrayList<Card>();
	private static ArrayList<Card> cardsremoved = new ArrayList<Card>();
	private boolean nomore = false;
	Card selectedCard;

	/**
	 * constructor that initialises players
	 */

	public Deck() {

		this.redPlayer = new Player("red");
		this.yellowPlayer = new Player("yellow");

	}

	/**
	 * postcondition:returns dashboard
	 * 
	 * @return dashboard
	 */

	public Dashboard getDash() {

		return dash;
	}

	/**
	 * postcondition:returns red player
	 * 
	 * @return redPlayer
	 */

	public Player getredPlayer() {

		return redPlayer;
	}

	/**
	 * postcondition: returns yellow player
	 * 
	 * @return yellowPlayer
	 */

	public Player getyellowPlayer() {
		return yellowPlayer;
	}

	/**
	 * postcondition:has initialised cards Initialises cards
	 */
	public static void initialiseCards() {

		for (int i = 0; i < 4; i++) {
			cards.add(new NumberOneCard("Number One", 1));
			cards.add(new NumberTwoCard("Number Two", 2));
			cards.add(new NumberFourCard("Number Four", 4));
			cards.add(new NumberSevenCard("Number Seven", 7));
			cards.add(new NumberTenCard("Number ten", 10));
			cards.add(new NumberElevenCard("Number Eleven", 11));
			cards.add(new SorryCard("Sorry card", 13));
			cards.add(new SimpleNumberCard("Number three", 3));
			cards.add(new SimpleNumberCard("Number five", 5));
			cards.add(new SimpleNumberCard("Number eight", 8));
			cards.add(new SimpleNumberCard("Number twelve", 12));

		}

	}

	/**
	 * pre conditions: has chosen the first element of array list gets the first
	 * card in the stack and removes it and save it in c
	 * 
	 * @return c;
	 */
	public Card keepCard() {
		Card c = cardsremoved.get(0);
		cardsremoved.remove(0);
		return c;

	}

	/**
	 * removes the card of the index we want
	 * 
	 * @param index
	 * @return
	 */
	public Card removeCard(int index) {
		return this.cards.remove(index);
	}

	/** initialises dashboard */

	public void initializeDashboard() {

		dash = new Dashboard();

	}

	/**
	 * precondition: must have chosen a card
	 * 
	 * @param selected
	 * @return selectedCard
	 */
	public Card setSelectedCard(Card selected) {
		return this.selectedCard = selected;
	}

	/**
	 * this is a method that a player can draw a card precondition:must have cards
	 * postcondition:array list has cards and the second element goes as first
	 * element
	 * 
	 * @param p
	 * @return cardremoved
	 */
	public Card drawCard() {
		Card cardremoved;
		if (checkNoMore()) {
			initialiseCards();
			shuffleCards();
			cardremoved = removeCard(0);
			cardsremoved.add(cardremoved);
			return cardremoved;
		} else {

			cardremoved = removeCard(0);
			cardsremoved.add(cardremoved);
			return cardremoved;

		}

	}

	/**
	 * this method returns if there are no more cards
	 * 
	 * @return true there are no cards
	 */
	public boolean checkNoMore() {

		if (cards.size() <= 0)
			nomore = true;
		else
			nomore = false;
		return nomore;
	}

	/**
	 * returns cards
	 * 
	 * @return cards
	 */
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	/**
	 * preconditions:must have cards to shuffle this method shuffles cards
	 */
	public static void shuffleCards() {

		Collections.shuffle(cards);
	}

	/**
	 * moves pawn to the right position from the last one
	 * 
	 * @param x
	 * @return position
	 */
	public int moveYellowPawn2(int x) {

		if (x == 4) {
			int position = this.yellow2position -= x;
			return position;
		}

		else {
			int position = this.yellow2position += x;
			if (position > 59) {
				this.yellow2position = -4;
				position = this.yellow2position += x;
				return position;
			}

			return position;
		}
	}

	/**
	 * moves position of yellow pawn1 from the last one
	 * 
	 * @param x
	 * @return position
	 */
	public int moveYellowPawn1(int x) {

		if (x == 4) {
			int position = this.yellow1position -= x;
			return position;
		}

		int position = this.yellow1position += x;
		if (position > 59) {
			this.yellow1position = -4;
			position = this.yellow1position += x;
			return position;
		}

		return position;
	}

	/**
	 * moves red pawn 2 position from the last position to the right
	 * 
	 * @param x
	 * @return positiom
	 */
	public int moveRedPawn2(int x) {
		if (x == 4) {
			int position = this.red2position -= x;
			return position;

		}

		else {
			int position = this.red2position += x;
			if (position > 59) {
				this.red2position = 2;
				position = this.red2position += x;
				return position;
			}

			return position;
		}
	}

	/**
	 * moves red pawn 1 position from the last to the right one
	 * 
	 * @param x
	 * @return position
	 */
	public int moveRedPawn1(int x) {
		int position;
		if (x == 4) {
			position = this.red1position -= x;
			return position;
		} else {
			position = this.red1position += x;
		}
		if (position > 59) {
			this.red1position = 0;
			position = this.red1position += x;
			return position;
		}

		return position;

	}

	/**
	 * preconditon:must be your turn postconditon:pressed fold this method checks if
	 * the player said fold
	 * 
	 * @return true
	 */
	public boolean checkFold() {
		return true;
	}

}
