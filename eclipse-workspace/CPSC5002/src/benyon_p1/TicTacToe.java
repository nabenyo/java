package benyon_p1;

import java.util.Random;

public class TicTacToe {
	private String[][] gameBoard;
	
	public TicTacToe(int A) {
		this.gameBoard = array(A);
	}
	
	public TicTacToe() {
		this.gameBoard = array(3);
	}
	
	public static String[][] array(int A) {
		Random randomNumbers = new Random();
		int ROWS = A;
		int COLS = A;
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
	
	public String[][] getBoard(){
		return this.gameBoard;
	}
	
	public void playerMove(int row, int col, String val) {
		this.gameBoard[row][col] = val;
	}
}
