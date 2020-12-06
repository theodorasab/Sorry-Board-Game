package Model;

import Model.Square.EndSlideSquare;
import Model.Square.HomeSquare;
import Model.Square.InternalSlideSquare;
import Model.Square.SafetyZoneSquare;
import Model.Square.SimpleSquare;
import Model.Square.Square;
import Model.Square.StartSlideSquare;
import Model.Square.StartSquare;

public class Dashboard {
	Square[] dashboard;

	/**
	 * constructor initialises squares of every type
	 */
	public Dashboard() {
		dashboard = new Square[74];
		initializeSimpleSquares();
		initializeSlideSquares();
		initializeHomeSquares();
		initializeSafetyZoneSquares();
		initializeStartSquares();

	}

	/**
	 * initialises home squares
	 */
	public void initializeHomeSquares() {
		dashboard[72] = new HomeSquare();
		dashboard[73] = new HomeSquare();
	}

	/**
	 * initialises start squares
	 */
	public void initializeStartSquares() {
		dashboard[70] = new StartSquare();
		dashboard[71] = new StartSquare();
	}

	/**
	 * initializes safety zone squares
	 */
	public void initializeSafetyZoneSquares() {
		for (int i = 60; i < 70; i++) {
			dashboard[i] = new SafetyZoneSquare();
		}

	}

	/**
	 * initialises simple squares
	 */
	public void initializeSimpleSquares() {

		dashboard[0] = new SimpleSquare();
		dashboard[1] = new SimpleSquare();
		dashboard[7] = new SimpleSquare();
		dashboard[8] = new SimpleSquare();
		dashboard[9] = new SimpleSquare();
		dashboard[10] = new SimpleSquare();
		dashboard[15] = new SimpleSquare();
		dashboard[20] = new SimpleSquare();
		dashboard[21] = new SimpleSquare();
		dashboard[22] = new SimpleSquare();
		dashboard[23] = new SimpleSquare();
		dashboard[29] = new SimpleSquare();
		dashboard[30] = new SimpleSquare();
		dashboard[35] = new SimpleSquare();
		dashboard[36] = new SimpleSquare();
		dashboard[37] = new SimpleSquare();
		dashboard[38] = new SimpleSquare();
		dashboard[44] = new SimpleSquare();
		dashboard[45] = new SimpleSquare();
		dashboard[50] = new SimpleSquare();
		dashboard[51] = new SimpleSquare();
		dashboard[52] = new SimpleSquare();
		dashboard[53] = new SimpleSquare();
		dashboard[59] = new SimpleSquare();
	}

	/**
	 * initialises start slide squares
	 */
	public void initializeSlideSquares() {
		dashboard[16] = new StartSlideSquare();
		dashboard[24] = new StartSlideSquare();
		dashboard[31] = new StartSlideSquare();
		dashboard[39] = new StartSlideSquare();
		dashboard[46] = new StartSlideSquare();
		dashboard[54] = new StartSlideSquare();
		dashboard[6] = new StartSlideSquare();
		dashboard[14] = new StartSlideSquare();

		dashboard[17] = new InternalSlideSquare();
		dashboard[18] = new InternalSlideSquare();
		dashboard[25] = new InternalSlideSquare();
		dashboard[26] = new InternalSlideSquare();
		dashboard[27] = new InternalSlideSquare();
		dashboard[32] = new InternalSlideSquare();
		dashboard[33] = new InternalSlideSquare();
		dashboard[40] = new InternalSlideSquare();
		dashboard[41] = new InternalSlideSquare();
		dashboard[42] = new InternalSlideSquare();
		dashboard[47] = new InternalSlideSquare();
		dashboard[48] = new InternalSlideSquare();
		dashboard[55] = new InternalSlideSquare();
		dashboard[56] = new InternalSlideSquare();
		dashboard[57] = new InternalSlideSquare();
		dashboard[3] = new InternalSlideSquare();
		dashboard[4] = new InternalSlideSquare();
		dashboard[5] = new InternalSlideSquare();
		dashboard[12] = new InternalSlideSquare();
		dashboard[13] = new InternalSlideSquare();

		dashboard[19] = new EndSlideSquare();
		dashboard[28] = new EndSlideSquare();
		dashboard[34] = new EndSlideSquare();
		dashboard[43] = new EndSlideSquare();
		dashboard[49] = new EndSlideSquare();
		dashboard[58] = new EndSlideSquare();
		dashboard[2] = new EndSlideSquare();
		dashboard[11] = new EndSlideSquare();

	}

	/**
	 * gets position in dashboard
	 * 
	 * @param i
	 * @return
	 */
	public Square getPosition(int i) {
		return dashboard[i];
	}

}
