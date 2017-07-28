/*
 * Nick Benyo
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package benyon_p1;

/**
 * TicTacToe class used to create and track a game of Tic Tac Toe. Checks for
 * winners and has flexible board sizes
 * 
 * @author Nick Benyo
 *
 */
public class TicTacToe {
	private String[][] gameBoard;// An array used to track the values in game
	private int boardSize = 3;// The size of the game-board (n X n)

	/**
	 * Initializes TicTacToe object, will build an array used to track the game
	 */
	public TicTacToe() {
		generateBlankBoard();
	}

	/**
	 * Setter to change board size variable and reinitialize board
	 * 
	 * @param size
	 *            The square size of the board
	 */
	public void setBoardSize(int size) {
		this.boardSize = size;
		generateBlankBoard();
	}

	/**
	 * Getter for size of board.
	 * 
	 * @return Integer value of board size (n X n)
	 */
	public int getBoardSize() {
		return this.boardSize;
	}

	/**
	 * Array, builds the array used for the game-board data member
	 */
	public void generateBlankBoard() {
		int ROWS = this.boardSize;
		int COLS = this.boardSize;
		String[][] x = new String[ROWS][COLS];
		// Nested loop assigning random numbers to each value in the array
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				String blanks = " ";
				x[row][col] = blanks;// Assigns blank space array positions
			}
		}
		this.gameBoard = x;// finalized board with blank values
	}

	/**
	 * Used as a getter for the game-board data member
	 * 
	 * @return the game-board array data member
	 */
	public String[][] getBoard() {
		return this.gameBoard;
	}

	/**
	 * Use to execute a move for a player. Will print to terminal if the 
	 * space has already been taken and return a boolean indicating if 
	 * the move is valid.
	 * 
	 * @param row
	 *            the row of the 2D game-board array to be filled
	 * @param col
	 *            the column of the 2D game-board array to be filled
	 * @param player
	 *            a string value representing the player (X or O)
	 * @return Returns a boolean indicating if the move was valid
	 */
	public boolean playerMove(int row, int col, String player) {
		boolean valid = true;// The passed through move is valid
		if (this.gameBoard[row][col] == " ") {
			this.gameBoard[row][col] = player;
		} else {
			System.out.print("That space is already taken!\n");
			valid = false;
		}
		return valid;
	}

	/**
	 * Use to determine if a winning configuration exists on the game-board
	 * 
	 * @param player
	 *            a string of the player/value on the board (X or O)
	 * @return a boolean value indicating whether or not the player passed 
	 * through is a winner
	 */
	public boolean win(String player) {
		boolean winner = false;// Whether player won the game
		if (diagWin(player) || rowWin(player) || colWin(player) == true) {
			winner = true;
		}
		return winner;
	}

	/**
	 * Evaluates if a win has occurred on the row level
	 * 
	 * @param player
	 *            a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a row level
	 */
	private boolean rowWin(String player) {
		boolean rowwinner = false;// A win occurred at some point
		boolean win = true;// The row tested was a win
		boolean[] passfail = new boolean[this.gameBoard.length];
		for (int row = 0; row < this.gameBoard.length; row++) {
			win = true;
			for (int col = 0; col < this.gameBoard[row].length; col++) {
				// Compares every value in row to player value
				if (player != this.gameBoard[row][col]) {
					// win becomes false if a mismatch occurs in row
					win = false;
				}
			}
			// adds win boolean to the passfail array
			passfail[row] = win;
		}
		// for loop iterates through every value of passfail looking for
		// a true value (true = a win)
		for (boolean gameover : passfail) {
			if (gameover == true) {
				// Assigns a true to rowwinner of a true value is found
				rowwinner = true;
				break;
			}
		}
		return rowwinner;// Returns a boolean if there was a row win
	}

	/**
	 * Evaluates if a win has occurred on the column level
	 * 
	 * @param player
	 *            a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a row level
	 */
	private boolean colWin(String player) {
		/*
		 * Functions nearly the same as rowWin but inverted to test 
		 * column wins instead of rows
		 */
		boolean colwinner = false;// A win occurred at some point
		boolean win = true;// The column tested was a win
		boolean[] passfail = new boolean[this.gameBoard.length];
		for (int col = 0; col < this.gameBoard[0].length; col++) {
			win = true;
			for (int row = 0; row < this.gameBoard.length; row++) {
				if (player != this.gameBoard[row][col]) {
					win = false;
				}
			}
			passfail[col] = win;
		}
		for (boolean gameover : passfail) {
			if (gameover == true) {
				colwinner = true;
				break;
			}
		}
		return colwinner;
	}

	/**
	 * Evaluates if a win has occurred on the diagonal level
	 * 
	 * @param player
	 *            a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a 
	 * diagonal level
	 */
	private boolean diagWin(String player) {
		boolean[] passfail = new boolean[2];
		boolean winner = false;// There was a win at some point
		boolean win = true;// The diagonal tested was a win
		int rdiag = this.gameBoard.length - 1;
		// Loops to test diagonal from bottom left to top right
		for (int diag = 0; diag < this.gameBoard.length; diag++) {
			if (player != this.gameBoard[diag][rdiag]) {
				win = false;
			}
			rdiag--;
		}
		passfail[0] = win;
		win = true;
		// Loops to test diagonal from top left to bottom right
		for (int diag = 0; diag < this.gameBoard.length; diag++) {
			if (player != this.gameBoard[diag][diag]) {
				win = false;
			}
		}
		passfail[1] = win;
		for (boolean gameover : passfail) {
			if (gameover == true) {
				winner = true;
				break;
			}
		}
		return winner;
	}

}