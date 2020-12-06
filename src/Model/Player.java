package Model;

import java.util.ArrayList;

import Controller.Controller;
import Model.Cards.Card;

public class Player {
	private int position;
	String color, name;
	Pawn pawn1, pawn2;
	boolean played;
	private Deck d;

	/**
	 * returns if the color is red or yellow in a boolean form
	 * 
	 * @param color
	 */
	public Player(String color) {
		if (color.equals("red")) {
			this.played = false;
		} else {
			this.played = true;
		}
	}

	/**
	 * gets position
	 * 
	 * @return
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * moves position
	 * 
	 * @param x
	 */
	public void movePosition(int x) {

		this.position += x;
	}

	/**
	 * return what color is the players pawns
	 * 
	 * @return color
	 */
	public String getcolor() {
		return color;
	}

	/**
	 * this returns the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * this gets the pawn 1
	 * 
	 * @return pawn 1
	 */
	public Pawn getPawn1() {
		return this.pawn1;
	}

	/**
	 * this sets the pawn 2
	 */
	private void setPawn2() {

	}

	/**
	 * this gets the pawn 1
	 * 
	 * @return pawn 2
	 */
	public Pawn getPawn2() {
		return this.pawn2;
	}

	/**
	 * if the player played returns true if he didnt it returns false
	 * 
	 * @return played
	 */
	public boolean getPlayed() {
		return played;
	}

	/**
	 * precondition: must have got cards from getCards in deck gets getCard
	 * 
	 * @return
	 */
	public ArrayList<Card> getCards() {
		return d.getCards();
	}

	/**
	 * toggles turn
	 */
	public void toggleTurn() {
		this.played = !this.played;

	}

	/**
	 * checks if the player can play
	 * 
	 * @return true or false
	 */
	public boolean canPlay() {
		
		if (this.played == false) {
			
			return true;
		}
		return false;
	}

}
