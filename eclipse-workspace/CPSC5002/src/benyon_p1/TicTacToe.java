package benyon_p1;

import java.util.Random;
import java.util.Arrays;

public class TicTacToe {
	private String[][] gameBoard;//measures
	
	/**
	 * Initializes TicTacToe object, will build an array used to track the game
	 * @param size the size of the game-board/array
	 */
	public TicTacToe(int size) {
		this.gameBoard = array(size);
	}
	
	/**
	 * Overloaded constructor, defaults to 3X3 game-board
	 */
	public TicTacToe() {
		this.gameBoard = array(3);
	}
	
	/**
	 * Array, builds the array used for the game-board data member
	 * @param size of the array initialized
	 * @return Returns a size x size array
	 */
	public static String[][] array(int size) {
		Random randomNumbers = new Random();
		int ROWS = size;
		int COLS = size;
		String[][] x  = new String[ROWS][COLS];
		//Nested loop assigning random numbers to each value in the array
		for (int row = 0; row < ROWS; row++){		
			for (int col = 0; col < COLS; col++) {
				String blanks = " ";
				x[row][col] = blanks;
			}
		}
		return x;
	}
	
	/**
	 * Used as a getter for the game-board data member
	 * @return the game-board array data member
	 */
	public String[][] getBoard(){
		return this.gameBoard;
	}
	
	/**
	 * Use to execute a move for a player. Will print to terminal if 
	 * the space has already been taken and return a boolean indicating
	 * if the move is valid.
	 * @param row the row of the 2D game-board array to be filled
	 * @param col the column of the 2D game-board array to be filled
	 * @param player a string value representing the player (X or O)
	 * @return Returns a boolean indicating if the move was valid
	 */
	public boolean playerMove(int row, int col, String player) {
		boolean valid = true;
		if (this.gameBoard[row][col] == " ") {
			this.gameBoard[row][col] = player;
		}else {
			System.out.print("That space is already taken!\n");
			valid = false;
		}
		return valid;
	}
	
	/**
	 * Use to determine if a winning configuration exists on the game-board
	 * @param player a string of the player/value on the board (X or O)
	 * @return a boolean value indicating whether or not the player passed
	 * through is a winner
	 */
	public boolean win(String player) {
		boolean winner = false;
		if (diagWin(player)||rowWin(player)|| colWin(player) == true) {
			winner = true;
		}
		return winner;
	}
	
	/**
	 * Evaluates if a win has occurred on the row level
	 * @param player a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a row level
	 */
	public boolean rowWin(String player) {
		boolean rowwinner = false;
		boolean win = true;
		boolean[] passfail = new boolean[this.gameBoard.length];
		for (int row = 0; row < this.gameBoard.length; row++) {
			win = true;
			for (int col = 0; col < this.gameBoard[row].length; col++) {
				if(player!= this.gameBoard[row][col]) {
					win = false;
				}
			}
			passfail[row] = win;
		}
		for(boolean gameover:passfail) {
			if (gameover == true) {
				//System.out.println(gameover);
				rowwinner = true;
				break;
			}
		}
		return rowwinner;
	}
	
	/**
	 * Evaluates if a win has occurred on the column level
	 * @param player a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a row level
	 */
	public boolean colWin(String player) {
		boolean colwinner = false;
		boolean win = true;
		boolean[] passfail = new boolean[this.gameBoard.length];
		for (int col = 0; col < this.gameBoard[0].length; col++) {
			win = true;
			for (int row = 0; row < this.gameBoard.length; row++) {
				if(player!= this.gameBoard[row][col]) {
					win = false;
				}
			}
			passfail[col] = win;
		}
		for(boolean gameover:passfail) {
			if (gameover == true) {
				//System.out.println(gameover);
				colwinner = true;
				break;
			}
		}
		return colwinner;
	}
	
	/**
	 * Evaluates if a win has occurred on the diagonal level
	 * @param player a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a diagonal level
	 */
	public boolean diagWin(String player) {
		boolean[] passfail = new boolean[2];
		boolean winner = false;
		boolean win = true;
		int rdiag = this.gameBoard.length-1;
		for (int diag = 0; diag < this.gameBoard.length; diag++) {
			//System.out.print(this.gameBoard[diag][rdiag]);
			if(player!= this.gameBoard[diag][rdiag]) {
				win = false;
			}
			rdiag--;
		}
		passfail[0] = win;
		win = true;
		int d2_total = 0;
		for (int diag = 0; diag < this.gameBoard.length; diag++) {
			if(player!= this.gameBoard[diag][diag]) {
				win = false;
			}
		}
		passfail[1] = win;
		for(boolean gameover:passfail) {
			if (gameover == true) {
				//System.out.println(gameover);
				winner = true;
				break;
			}
		}
		return winner;
	}


}