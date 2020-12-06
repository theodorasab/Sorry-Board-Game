package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

import Controller.Controller;
import Model.Deck;
import Model.Cards.Card;

public class View extends JFrame {
	JButton fold;
	private JTextArea area;
	public JButton cardsb = new JButton();
	private JButton[] redpawns = new JButton[2];
	private JButton[] yellowpawns = new JButton[2];
	private JButton[] pawns = new JButton[5];
	private JLabel startred;
	JLabel startyellow;
	private JLabel[] array = new JLabel[80];

	static JFrame frame;

	JPanel panel = new JPanel();
	JLayeredPane layeredPane = new JLayeredPane();
	JLayeredPane layeredPane2 = new JLayeredPane();
	JMenuBar menuBar = new JMenuBar();
	private AbstractButton cards1;

	public View() throws IOException {
		frame = new JFrame("Sorry Game");

		new Deck();

//menu
		/**
		 * creates menu
		 */
		JMenu newg = new JMenu("New Game");
		JMenu save = new JMenu("Save Game");
		JMenu continues = new JMenu("Continue Saved Game");
		JMenu exit = new JMenu("Exit Game");

		menuBar.add(newg);
		menuBar.add(save);
		menuBar.add(continues);
		menuBar.add(exit);
		frame.setJMenuBar(menuBar);

		/**
		 * adds background image
		 */
		JLabel label1 = new JLabel();
		Image background = ImageIO.read(getClass().getResource("/images\\background.png")).getScaledInstance(1300, 800,
				5);
		label1.setBounds(0, 0, 1300, 800);
		label1.setIcon(new ImageIcon(background));
		label1.setOpaque(true);
		layeredPane.add(label1, 10);

		// galazia eikona
		panel.setBackground(Color.cyan);
		panel.setBounds(40, 40, 600, 600);
		panel.setOpaque(true);
		layeredPane.add(panel, 0);
		// soory sthn mesh tou board
		JLabel label = new JLabel();
		Image img = ImageIO.read(getClass().getResource("/images\\sorryImage.png")).getScaledInstance(210, 180, 7);
		label.setBounds(200, 400, 0, 0);
		label.setIcon(new ImageIcon(img));
		label.setOpaque(true);
		layeredPane.add(label, 0);

		// creating text area
		
		Border line;
		line = BorderFactory.createLineBorder(Color.black);
		area = new JTextArea("Info Box\n");
		Font font = new Font("Squad", Font.BOLD, 13);
		area.setFont(font);
		area.setBounds(720, 450, 370, 220);
		area.setForeground(Color.black);
		area.setBorder(line);
		area.setOpaque(true);
		layeredPane.add(area, 0);

		createRow1();
		createRow2();
		createColumn1();
		createColumn2();
		createYellowButtons();
		createRedButtons();
		/**
		 * create home for red pawns
		 */
		JButton homered = new JButton("Home");
		homered.setVerticalAlignment(SwingConstants.BOTTOM);
		homered.setFont(new Font("Serif", Font.BOLD, 15));
		homered.setBounds(50, 240, 100, 80);
		homered.setBackground(Color.white);
		homered.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		homered.setVisible(true);
		layeredPane.add(homered, 0);
		/**
		 * creates start for yellow pawns
		 */
		startyellow = new JLabel("Start");
		startyellow.setVerticalAlignment(SwingConstants.TOP);
		startyellow.setBounds(400, 520, 100, 80);
		startyellow.setFont(new Font("Serif", Font.BOLD, 15));
		startyellow.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		startyellow.setBackground(Color.white);
		startyellow.setVisible(true);
		startyellow.setOpaque(true);
		layeredPane.add(startyellow, 0);
		/**
		 * creates start for red pawns
		 */
		startred = new JLabel("Start");
		startred.setVerticalAlignment(SwingConstants.BOTTOM);
		startred.setBounds(130, 40, 100, 80);
		startred.setFont(new Font("Serif", Font.BOLD, 15));
		startred.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		startred.setBackground(Color.white);
		startred.setVisible(true);
		startred.setOpaque(true);
		layeredPane.add(startred, 0);

		/**
		 * home for yellow pawns
		 */
		JButton homeyellow = new JButton("Home");
		homeyellow.setVerticalAlignment(SwingConstants.BOTTOM);
		homeyellow.setFont(new Font("Serif", Font.BOLD, 15));
		homeyellow.setBounds(490, 320, 100, 80);
		homeyellow.setBackground(Color.white);
		homeyellow.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		homeyellow.setVisible(true);
		layeredPane.add(homeyellow, 0);

		/**
		 * creates all pawns
		 */
		JButton redPawn1 = new JButton();
		URL c2 = this.getClass().getResource("/images/pawns/redPawn1.png");
		Image redpawn1image = new ImageIcon(c2).getImage();
		redpawn1image = redpawn1image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		redPawn1.setIcon(new ImageIcon(redpawn1image));
		redPawn1.setBounds(140, 50, 35, 35);
		redPawn1.setName("red1");
		redpawns[0] = redPawn1;
		layeredPane.add(redPawn1, 0);

		JButton redPawn2 = new JButton();
		URL c1 = this.getClass().getResource("/images/pawns/redPawn2.png");
		Image redpawn2 = new ImageIcon(c1).getImage();
		redpawn2 = redpawn2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		redPawn2.setIcon(new ImageIcon(redpawn2));
		redPawn2.setBounds(180, 50, 35, 35);
		redPawn2.setName("red2");
		redpawns[1] = redPawn2;
		layeredPane.add(redPawn2, 0);

		JButton yellowPawn1 = new JButton();
		URL yellow = this.getClass().getResource("/images/pawns/yellowPawn1.png");
		Image yellowpawn1 = new ImageIcon(yellow).getImage();
		yellowpawn1 = yellowpawn1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		yellowPawn1.setIcon(new ImageIcon(yellowpawn1));
		yellowPawn1.setBounds(420, 550, 35, 35);
		yellowPawn1.setName("yellow1");
		yellowPawn1.setOpaque(true);
		yellowpawns[0] = yellowPawn1;
		layeredPane.add(yellowPawn1, 2);

		JButton yellowPawn2 = new JButton();
		URL yellow2 = this.getClass().getResource("/images/pawns/yellowPawn2.png");
		Image yellowpawn2 = new ImageIcon(yellow2).getImage();
		yellowpawn2 = yellowpawn2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		yellowPawn2.setIcon(new ImageIcon(yellowpawn2));
		yellowPawn2.setBounds(460, 550, 35, 35);
		yellowPawn2.setName("yellow2");
		yellowpawns[1] = yellowPawn2;
		layeredPane.add(yellowPawn2, 2);
		/**
		 * creates the area where cards we draw show
		 */
		cards1 = new JButton();
		cards1.setBounds(870, 90, 130, 200);
		cards1.setVisible(true);
		layeredPane.add(cards1, 0);
		/**
		 * creates area where cards we havent draw yet are
		 */
		Image back = ImageIO.read(getClass().getResource("/images\\cards\\backCard.png")).getScaledInstance(150, 250,
				100);
		cardsb.setIcon(new ImageIcon(back));
		cardsb.setBounds(710, 90, 130, 200);
		cardsb.setBackground(Color.white);
		cardsb.setVisible(true);
		layeredPane.add(cardsb, 0);

		/**
		 * create fold button
		 */
		fold = new JButton("Fold Button");
		fold.setBounds(720, 370, 270, 50);
		fold.setBackground(Color.red);
		fold.setName("fold");
		fold.setVisible(true);
		layeredPane.add(fold, 0);

		/**
		 * texts
		 */
		JLabel text1 = new JLabel("Receive Cards");
		text1.setBounds(720, 260, 100, 100);
		layeredPane.add(text1, 0);

		JLabel text2 = new JLabel("Current Card");
		text2.setBounds(890, 260, 100, 100);
		layeredPane.add(text2, 0);
		/**
		 * adds things to panel and frame
		 */
		panel.add(label);
		layeredPane.setOpaque(true);
		frame.setContentPane(layeredPane);
		frame.setBounds(700, 700, 200, 200);
		frame.setSize(1300, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	/**
	 * shows the image of the card we drew
	 * 
	 * @param c
	 * @throws IOException
	 */

	public void updateCard(Card c) throws IOException {

		Image cardicon = ImageIO.read(getClass().getResource(c.getImage())).getScaledInstance(150, 210, 100);
		cards1.setIcon(new ImageIcon(cardicon));

		panel.revalidate();
	}

	/**
	 * creates simple squares
	 * 
	 * @param x
	 * @param y
	 * @return b
	 */
	public JLabel createButton(int x, int y) {

		JLabel b = new JLabel();
		b.setBounds(x, y, 40, 40);
		b.setBackground(Color.white);
		b.setVisible(true);
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		b.setBorder(border);
		b.setOpaque(true);
		layeredPane.add(b, 0);
		return b;

	}

	/**
	 * puts squares in the first column
	 */
	private void createColumn1() {
		int y = 560;
		for (int i = 46; i < 60; i++) {
			array[i] = createButton(0, y);
			y -= 40;

		}
	}

	/**
	 * puts the squares of first row
	 * 
	 * @throws IOException
	 */
	private void createRow1() throws IOException {
		int x = 0;
		for (int i = 0; i < 16; i++) {
			array[i] = createButton(x, 0);
			x += 40;
		}
		Image redslidestart = ImageIO.read(getClass().getResource("/images\\slides\\redSlideStart.png"))
				.getScaledInstance(38, 38, 4);
		array[1].setIcon(new ImageIcon(redslidestart));
		Image redslide = ImageIO.read(getClass().getResource("/images\\slides\\redSlideMedium.png"))
				.getScaledInstance(38, 38, 4);
		array[2].setIcon(new ImageIcon(redslide));
		array[3].setIcon(new ImageIcon(redslide));
		Image redslideend = ImageIO.read(getClass().getResource("/images\\slides\\redSlideEnd.png"))
				.getScaledInstance(38, 38, 4);
		array[4].setIcon(new ImageIcon(redslideend));
		array[9].setIcon(new ImageIcon(redslidestart));
		array[10].setIcon(new ImageIcon(redslide));
		array[11].setIcon(new ImageIcon(redslide));
		array[12].setIcon(new ImageIcon(redslide));
		array[13].setIcon(new ImageIcon(redslideend));
	}

	/**
	 * creats second column
	 * 
	 * @throws IOException
	 */
	private void createColumn2() throws IOException {
		int y1 = 40;
		for (int i = 16; i < 31; i++) {
			array[i] = createButton(600, y1);
			y1 += 40;
		}
		/**
		 * puts images of slides in the right squares
		 */
		Image blueslidestart = ImageIO.read(getClass().getResource("/images\\slides\\blueSlideStart.png"))
				.getScaledInstance(39, 38, 4);
		array[16].setIcon(new ImageIcon(blueslidestart));
		Image blueslide = ImageIO.read(getClass().getResource("/images\\slides\\blueSlideMedium.png"))
				.getScaledInstance(39, 38, 4);
		array[17].setIcon(new ImageIcon(blueslide));
		array[18].setIcon(new ImageIcon(blueslide));
		Image blueslideend = ImageIO.read(getClass().getResource("/images\\slides\\blueSlideEnd.png"))
				.getScaledInstance(39, 38, 4);
		array[19].setIcon(new ImageIcon(blueslideend));
		array[24].setIcon(new ImageIcon(blueslidestart));
		array[25].setIcon(new ImageIcon(blueslide));
		array[26].setIcon(new ImageIcon(blueslide));
		array[27].setIcon(new ImageIcon(blueslide));
		array[28].setIcon(new ImageIcon(blueslideend));
	}

	/**
	 * creates second row
	 * 
	 * @throws IOException
	 */
	private void createRow2() throws IOException {
		int x1 = 560;
		for (int i = 31; i < 46; i++) {
			array[i] = createButton(x1, 600);
			x1 -= 40;
		}
		Image yellowslidestart = ImageIO.read(getClass().getResource("/images\\slides\\yellowSlideStart.png"))
				.getScaledInstance(38, 38, 4);
		array[31].setIcon(new ImageIcon(yellowslidestart));
		Image yellowslide = ImageIO.read(getClass().getResource("/images\\slides\\yellowSlideMedium.png"))
				.getScaledInstance(38, 38, 4);
		array[32].setIcon(new ImageIcon(yellowslide));
		array[33].setIcon(new ImageIcon(yellowslide));
		Image yellowslideend = ImageIO.read(getClass().getResource("/images\\slides\\yellowSlideEnd.png"))
				.getScaledInstance(38, 38, 4);
		array[34].setIcon(new ImageIcon(yellowslideend));
		array[39].setIcon(new ImageIcon(yellowslidestart));
		array[40].setIcon(new ImageIcon(yellowslide));
		array[41].setIcon(new ImageIcon(yellowslide));
		array[42].setIcon(new ImageIcon(yellowslide));
		array[43].setIcon(new ImageIcon(yellowslideend));

	}

	/**
	 * creates safety zone of yellow
	 * 
	 * @throws IOException
	 */
	private void createYellowButtons() throws IOException {
		int y = 560;
		for (int i = 65; i < 70; i++) {
			array[i] = createYellowButton(y);
			y -= 40;
		}

		Image greenslidestart = ImageIO.read(getClass().getResource("/images\\slides\\greenSlideStart.png"))
				.getScaledInstance(38, 38, 4);
		array[46].setIcon(new ImageIcon(greenslidestart));
		Image greenslide = ImageIO.read(getClass().getResource("/images\\slides\\greenSlideMedium.png"))
				.getScaledInstance(38, 38, 4);
		array[47].setIcon(new ImageIcon(greenslide));
		array[48].setIcon(new ImageIcon(greenslide));
		Image greenslideend = ImageIO.read(getClass().getResource("/images\\slides\\greenSlideEnd.png"))
				.getScaledInstance(38, 38, 4);
		array[49].setIcon(new ImageIcon(greenslideend));
		array[54].setIcon(new ImageIcon(greenslidestart));
		array[55].setIcon(new ImageIcon(greenslide));
		array[56].setIcon(new ImageIcon(greenslide));
		array[57].setIcon(new ImageIcon(greenslide));
		array[58].setIcon(new ImageIcon(greenslideend));

	}

	/**
	 * creates yellow squares
	 * 
	 * @param y
	 * @return
	 */
	private JLabel createYellowButton(int y) {
		JLabel by0 = new JLabel();
		by0.setBounds(520, y, 40, 40);
		by0.setBackground(Color.yellow);
		by0.setVisible(true);
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		by0.setBorder(border);
		by0.setOpaque(true);
		layeredPane.add(by0, 0);
		return by0;
	}

	/**
	 * creates red safety zone
	 */
	private void createRedButtons() {
		int y = 40;
		for (int i = 60; i < 65; i++) {
			array[i] = createRedButton(y);
			y += 40;
		}
	}

	/**
	 * creates safety zone squares
	 * 
	 * @param y
	 * @return by0
	 */
	private JLabel createRedButton(int y) {
		JLabel by0 = new JLabel();
		by0.setBounds(80, y, 40, 40);
		by0.setBackground(Color.red);
		by0.setVisible(true);
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		by0.setBorder(border);
		by0.setOpaque(true);
		layeredPane.add(by0, 0);
		return by0;
	}

	/**
	 * get array of squares
	 * 
	 * @return array
	 */
	public JLabel[] getButtons() {
		return array;
	}

	/**
	 * gets cards that havent been drew
	 * 
	 * @return cardsb
	 */
	public JButton getCardsb() {
		return cardsb;
	}


	/**
	 * puts red pawn in the right square
	 * 
	 * @param positionPawn
	 * @param i
	 */
	public void updateRedPawn(int positionPawn, int i) {
		redpawns[i].setBounds(array[positionPawn].getX(), array[positionPawn].getY(), 40, 40);

	}

	/**
	 * puts yellow pawn to the right square
	 * 
	 * @param positionPawn
	 * @param i
	 */
	public void updateYellowPawn(int positionPawn, int i) {
		yellowpawns[i].setBounds(array[positionPawn].getX(), array[positionPawn].getY(), 40, 40);
	}

//	/**
//	 * main method
//	 * 
//	 * @param args
//	 * @throws IOException
//	 */
//	public static void main(String[] args) throws IOException {
//
//		new Controller();
//
//	}

	/**
	 * gets pawns
	 * 
	 * @return pawns
	 */
	public JButton[] getPawns() {

		return pawns;
	}

	/**
	 * gets red pawns
	 * 
	 * @return redpawns
	 */
	public JButton[] getRedPawns() {
		return redpawns;
	}

	/**
	 * gets text area
	 * 
	 * @return area
	 */
	public JTextArea getText() {
		return area;
	}

	public JButton[] getYellowPawns() {
		return yellowpawns;
	}

	/**
	 * adds listener to the pawns and the fold button
	 * 
	 * @param listenForPawnButton
	 */
	public void addPawnMovementListener(ActionListener listenForPawnButton) {

		redpawns[0].addActionListener(listenForPawnButton);
		redpawns[1].addActionListener(listenForPawnButton);
		yellowpawns[0].addActionListener(listenForPawnButton);
		yellowpawns[1].addActionListener(listenForPawnButton);
		fold.addActionListener(listenForPawnButton);
	}


}