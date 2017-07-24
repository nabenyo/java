package benyon_p1;

import java.util.Scanner;

/**
 * P1 class used to play a game of Tic-tac-toe. Formatting, loop execution, and 
 * game board formatting all handled in this class. Game-board manipulation
 * and logic for testing rows/cols/diagonals for wins found in TicTacToe class
 * @author Nick Benyo
 *
 */
public class P1 {
	//data members below used for the game stats
	private static int owins = 0;//Score for O
	private static int xwins = 0;//Score for X
	private static int ties = 0;//Score for ties
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner playmore = new Scanner(System.in);
		String keepPlaying = "y";
		//Player must select y to continue with each game end
		while(keepPlaying.equals("y")) {
			gamePlay();
			System.out.printf("\nGame Stats\nX has %d wins"
					+ "\nO has %d wins\nThere have been %d ties\n"
					, xwins, owins, ties);
			System.out.print("\nDo you want to play again? (y for yes) ");
			keepPlaying = playmore.nextLine();//Ask player to keep playing
		}
		System.out.print("Thank you for playing!");
	}
	
	/**
	 * Gameplay used to initiate the game, will continue until a winner
	 * is determined or a tie occurs. Adds to the win/loss count using
	 * owins/xwins/ties data members
	 */
	public static void gamePlay() {
		TicTacToe array = new TicTacToe();
		int size = array.getBoardSize();
		int numofsquares = size * size;//Counts number of spaces in game
		String gameWinner = "Tie";
		int rounds = 0;
		boolean over = false;
		while(!over && rounds < numofsquares) {
			over = turn(array, "X");
			if(over) {
				gameWinner = "X";
				break;
			}
			rounds++;
			//If statement below kills game when all spaces have been filled.
			//Moves are odd number of moves and must terminate mid-loop if tie
			if(rounds == numofsquares) {
				break;
			}
			over = turn(array, "O");
			if(over) {
				gameWinner = "O";
				break;
			}
			rounds++;
		}
		//If statement to track wins below at end of each game
		if(gameWinner == "O") {
			owins += 1;
		}else if(gameWinner == "X") {
			xwins += 1;
		}else {
			ties += 1;
		}
		printBoard(array.getBoard());//Ensure the board is printed on win
		if(gameWinner!="Tie") {
			System.out.printf("%s wins the game!\n", gameWinner);
		}else{
			System.out.print("No one wins, it's a tie!\n");
			}
	}
	
	/**
	 * Executes a full turn of the game, printing the board and calling
	 * the aPlayerMove method to record a move from the player
	 * @param gameboard a TicTacToe object to be manipulated by the player
	 * @param a string value representing the player (X or O)
	 * @return a boolean indicating whether or not this turn resulted in a win
	 */
	public static boolean turn(TicTacToe gameboard, String player) {
		System.out.println();
		printBoard(gameboard.getBoard());
		System.out.printf("\n%s, it is your turn.\n", player);
		aPlayerMove(gameboard, player);
		return gameboard.win(player);
	}
	
	/**
	 * A method specifically manipulating the TicTacToe object from user input with
	 * the scanner package. Prints out instructions to the terminal when taking in values
	 * @param gameboard a TicTacToe object to be manipulated by the player
	 * @param player a string value representing the player (X or O)
	 */
	public static void aPlayerMove(TicTacToe gameboard, String player) {
		boolean correctAnswer = false;
			//correctAnswer returns a boolean if valid, loop terminates
			//as soon as the player selects a valid move
			while(!correctAnswer) {
				System.out.print("Which row? ");
				int row = scanner.nextInt();//Reads in player row choice
				//While loop ensures player selects values in range of array
				while(row >= gameboard.getBoard().length||row<0) {
					System.out.println("\nThat number isn't on the board! "
							+ "Please try again ");
					row = scanner.nextInt();
				}
				System.out.print("Which column? ");
				int column = scanner.nextInt();
				while(column >= gameboard.getBoard().length||column<0) {
					System.out.println("\nThat number isn't on the board! "
							+ "Please try again ");
					column = scanner.nextInt();
				}
				correctAnswer = gameboard.playerMove(row, column, player);
			}
	}
	
	/**
	 * Method for printing a TicTacToe game-board array in a terminal in
	 * a terminal optimized format
	 * @param gameboard a square array of string type
	 */
	public static void printBoard(String[][] gameboard) {
		//Loop to print through the array
		int lenvar = gameboard[0].length;
		for(int rowlen = 0; rowlen < lenvar; rowlen++) {
			System.out.printf("  %d", rowlen);
		}
		System.out.println();
		for (int row = 0; row < lenvar; row++) {
			//If statement to start a new line with each new row
			if(row>0) {
				System.out.println();}
			//Loop through each value in the array
			for (int col = 0; col < lenvar; col++) {
				//Create indent with each row for diagonals total
				if(col==0 && row >= 1) {
					String lines = new String(new char[lenvar]).replace("\0", "---");
					System.out.print(" "+lines+"\n");
				}
				if(col==0) {
					System.out.print(row);
				}
				System.out.printf(" ");
				System.out.printf("%s|",gameboard[row][col]);
				//If the end of the row, print out the totaled variable
			}
		}
		String lines = new String(new char[lenvar]).replace("\0", "---");
		System.out.print("\n "+lines+"\n");
	}
}
