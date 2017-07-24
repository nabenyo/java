package benyon_p1;


/**
 * TicTacToe class generates an object with a string array used 
 * for playing tic-tac-toe. Contains classes for marking moves 
 * in the array, and for testing rows, columns, and diagonals 
 * to determin if a win has occurred. Wins result in a true boolean
 * @author Nick Benyo
 *
 */
public class TicTacToe {
	private String[][] gameBoard;//An array used to track the values in game
	private int boardSize = 3;//The size of the gameboard (n X n)
	
	/**
	 * Initializes TicTacToe object, will build an array 
	 * used to track the game
	 * @param size the size of the game-board/array
	 */
	public TicTacToe() {
		this.gameBoard = array(boardSize);
	}
	
	/**
	 * Setter to change board size variable and reinitialize board
	 * @param size The square size of the board
	 */
	public void setBoardSize(int size) {
		this.boardSize = size;
		this.gameBoard = array(boardSize);
	}
	
	/**
	 * Getter for size of board. 
	 * @return Integer value of board size (n X n)
	 */
	public int getBoardSize() {
		return this.boardSize;
	}
	
	/**
	 * Array, builds the array used for the game-board data member
	 * @param size of the array initialized
	 * @return Returns a size x size array
	 */
	public static String[][] array(int size) {
		int ROWS = size;
		int COLS = size;
		String[][] x  = new String[ROWS][COLS];
		//Nested loop assigning random numbers to each value in the array
		for (int row = 0; row < ROWS; row++){		
			for (int col = 0; col < COLS; col++) {
				String blanks = " ";
				x[row][col] = blanks;//Assigns blank space array positions
			}
		}
		return x;//finalized array with blank space
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
				//Compares every value in row to player value
				if(player!= this.gameBoard[row][col]) {
					//win becomes false if a mismatch occurs in row
					win = false;
				}
			}
			//adds win boolean to the passfail array
			passfail[row] = win;
		}
		//for loop iterates through every value of passfail looking for
		//a true value (true = a win)
		for(boolean gameover:passfail) {
			if (gameover == true) {
				//Assigns a true to rowwinner of a true value is found
				rowwinner = true;
				break;
			}
		}
		return rowwinner;//Returns a boolean if there was a row win at any point
	}
	
	/**
	 * Evaluates if a win has occurred on the column level
	 * @param player a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the player has won on a row level
	 */
	public boolean colWin(String player) {
		/*Functions nearly the same as rowWin but inverted to test
		 *  column wins instead of rows
		 */
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
				colwinner = true;
				break;
			}
		}
		return colwinner;
	}
	
	/**
	 * Evaluates if a win has occurred on the diagonal level
	 * @param player a string of the player/value on the board (X or O)
	 * @return a boolean value indicating if the 
	 * player has won on a diagonal level
	 */
	public boolean diagWin(String player) {
		boolean[] passfail = new boolean[2];
		boolean winner = false;
		boolean win = true;
		int rdiag = this.gameBoard.length-1;
		//Loops to test diagonal from bottom left to top right
		for (int diag = 0; diag < this.gameBoard.length; diag++) {
			if(player!= this.gameBoard[diag][rdiag]) {
				win = false;
			}
			rdiag--;
		}
		passfail[0] = win;
		win = true;
		//Loops to test diagonal from top left to bottom right
		for (int diag = 0; diag < this.gameBoard.length; diag++) {
			if(player!= this.gameBoard[diag][diag]) {
				win = false;
			}
		}
		passfail[1] = win;
		for(boolean gameover:passfail) {
			if (gameover == true) {
				winner = true;
				break;
			}
		}
		return winner;
	}


}