package Controller;



/**
 * @version 1.0
 * @author theodora
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import Model.Deck;
import Model.Pawn;
import Model.Player;
import Model.Cards.Card;
import View.View;

public class Controller {

	private View view;
	private Deck deck;
	
	int red1counter = 0;
	int red2counter = 0;
	int yellow1counter = 0;
	int yellow2counter = 0;
	String red = "red";
	String yellow = "yellow";

	Card c;

	/**
	 * Initialises listeners and the deck
	 * 
	 * @throws IOException
	 */
	public Controller() throws IOException {

		view = new View();
		initialize();
		setListeners();
		PawnMovementListener pawnmove = new PawnMovementListener();
		view.addPawnMovementListener(pawnmove);

	}

	/**
	 * moves the player to the right position
	 * 
	 * @param player
	 * @param c
	 * @return true
	 */
	public boolean movePlayer(Player player, Card c) {
		player.movePosition(c.getValue());
		return true;
	}

	/**
	 * 
	 * class for listeners
	 *
	 */
	private class CardListener implements MouseListener {

		@Override
		/**
		 * implements the listener for cards
		 */
		public void mouseClicked(MouseEvent e) {

			if (SwingUtilities.isRightMouseButton(e)) {

			} else if (SwingUtilities.isLeftMouseButton(e)) {

				Card c = deck.drawCard();
				deck.setSelectedCard(c);

				try {
					view.updateCard(c);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	/**
	 * sets the listeners
	 */
	public void setListeners() {
		view.getCardsb().addMouseListener(new CardListener());

	}

	/**
	 * this method initialises the game
	 */
	public void initialize() {
		deck = new Deck();
		deck.initialiseCards();
		deck.shuffleCards();
		deck.initializeDashboard();

	}

	/**
	 * @return the deck postconditon:returns deck
	 */
	public Deck getDeck() {
		return deck;
	}



	/**
	 * player is pressed checks if he can play,plays,changes turns
	 *
	 */
	class PawnMovementListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Card c = deck.keepCard();

			Pawn player1Pawn1 = new Pawn(140, 50, red);
			String pawnClicked = ((JButton) e.getSource()).getName();
			if ("fold".equals(pawnClicked)) {
				if (deck.getyellowPlayer().canPlay()) {
					deck.getredPlayer().toggleTurn();
					deck.getyellowPlayer().toggleTurn();
					view.getText().append("Yellow player pressed fold\n");
				} else if (deck.getredPlayer().canPlay()) {
					deck.getyellowPlayer().toggleTurn();
					deck.getredPlayer().toggleTurn();
					view.getText().append("Red Player pressed fold\n");
				}

			}
			if ("red1".equals(pawnClicked)) {
				if (deck.getredPlayer().canPlay()) {

					int red1position = deck.moveRedPawn1(c.getValue());
					if (red1counter == 0) {
						if (c.getValue() == 1 || c.getValue() == 2) {
							int rred1position = 4;
							view.updateRedPawn(rred1position, 0);
							red1counter = 1;
							deck.getyellowPlayer().toggleTurn();
							deck.getredPlayer().toggleTurn();

						}
					} else if (red1counter == 1) {
						view.updateRedPawn(red1position, 0);
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();

					} else {
						view.getText().append("You can't play\n");
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();
					}

				} else {
					view.getText().append("It's yellow's player turn.Draw a new card\n");
				}
			}

			else if ("red2".equals(pawnClicked)) {

				if (deck.getredPlayer().canPlay()) {
					Pawn player1Pawn2 = new Pawn(180, 50, red);
					int red2position = deck.moveRedPawn2(c.getValue());
					if (red2counter == 0) {
						if (c.getValue() == 1 || c.getValue() == 2) {
							int rred2position = 4;
							view.updateRedPawn(rred2position, 1);
							red2counter = 1;
							deck.getyellowPlayer().toggleTurn();
							deck.getredPlayer().toggleTurn();

						}
					} else if (red2counter == 1) {
						view.updateRedPawn(red2position, 1);
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();
					} else {
						view.getText().append("You can't play\n");
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();
					}
				} else {
					view.getText().append("It's yellow's player turn.Draw a new card\n");
				}

			} else if ("yellow1".equals(pawnClicked)) {
				if (deck.getyellowPlayer().canPlay()) {

					Pawn player2Pawn1 = new Pawn(420, 550, yellow);
					int yellow1position = deck.moveYellowPawn1(c.getValue());
					if (yellow1counter == 0) {
						if (c.getValue() == 1 || c.getValue() == 2) {
							int yyellow1position = 34;
							view.updateYellowPawn(yyellow1position, 0);
							yellow1counter = 1;
							deck.getyellowPlayer().toggleTurn();
							deck.getredPlayer().toggleTurn();

						}
					} else if (yellow1counter == 1) {
						view.updateYellowPawn(yellow1position, 0);
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();

					} else {
						view.getText().append("You can't play\n");
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();
					}

				} else {
					view.getText().append("It's red's player turn.Draw a new card\n");
				}
			} else if ("yellow2".equals(pawnClicked)) {
				if (deck.getyellowPlayer().canPlay()) {
					Pawn player2Pawn2 = new Pawn(460, 550, red);
					int position = deck.moveYellowPawn2(c.getValue());
					if (yellow2counter == 0) {
						if (c.getValue() == 1 || c.getValue() == 2) {
							int yyellow2position = 34;
							view.updateYellowPawn(yyellow2position, 1);
							yellow2counter = 1;
							deck.getyellowPlayer().toggleTurn();
							deck.getredPlayer().toggleTurn();

						}
					} else if (yellow2counter == 1) {
						view.updateYellowPawn(position, 1);
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();

					} else {
						view.getText().append("You can't play\n");
						deck.getyellowPlayer().toggleTurn();
						deck.getredPlayer().toggleTurn();
					}
				} else {
					view.getText().append("It's red's player turn.Draw a new card\n");
				}

			}
		}

	}

}
