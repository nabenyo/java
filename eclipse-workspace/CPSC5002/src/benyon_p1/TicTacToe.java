package benyon_p1;

import java.util.Random;
import java.util.Arrays;

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
	
	public boolean playerMove(int row, int col, String val) {
		boolean valid = true;
		if (this.gameBoard[row][col] == " ") {
			this.gameBoard[row][col] = val;
		}else {
			System.out.print("That space is already taken!\n");
			valid = false;
		}
		return valid;
	}
	
	public boolean win(String player) {
		boolean winner = false;
		if (diagWin(player)||rowWin(player)|| colWin(player) == true) {
			winner = true;
		}
		return winner;
	}
	
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