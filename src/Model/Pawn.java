package Model;

import java.util.ArrayList;

import Model.Square.Square;

public class Pawn {

	private String color;
	private Square square;
	private boolean on, end;
	private int x, y, position;

	public Square[] dashboard;

	/** constructor that initialises x and y coordinates and the color of pawn */
	public Pawn(int x, int y, String color) {

		this.x = x;
		this.y = y;
		this.color = color;
		// this.position=position;
	}

	/**
	 * sets coordinates
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * sets y coordinates
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * gets position in dashboard
	 * 
	 * @return dashboard[position]
	 */
	public Square getPositionOfArray() {
		return dashboard[position];
	}

	/** returns the color */
	public String getcolor() {
		return color;
	}

	/**
	 * gets y coordinate
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * gets x coordinate
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

}
