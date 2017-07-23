package benyon_p1;

import java.util.Scanner;

public class P1 {
	private static int owins = 0;
	private static int xwins = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String keepPlaying = "y";
		while(keepPlaying.equals("y")) {
			gamePlay();
			System.out.printf("\nX has %d wins\nO has %d wins\n", xwins, owins);
			System.out.print("\nDo you want to play again?\n");
			keepPlaying = scanner.nextLine();
		}
		System.out.print("Thank you for playing!");
	}
	
	public static void gamePlay() {
		TicTacToe array = new TicTacToe();
		String gameWinner = "Tie";
		int rounds = 0;
		boolean over = false;
		while(over == false) {
			over = round(array, "X");
			if(over == true) {
				gameWinner = "X";
				break;
			}
			rounds++;
			if(rounds == 9) {
				break;
			}
			over = round(array, "0");
			if(over == true) {
				gameWinner = "O";
				break;
			}
			rounds++;
		}
		if(gameWinner == "O") {
			owins += 1;
		}else if(gameWinner == "X") {
			xwins += 1;
		}
		printBoard(array.getBoard());
		if(gameWinner!="Tie") {
			System.out.printf("%s wins the game!\n", gameWinner);
		}else{
			System.out.print("No one wins, it's a tie!\n");
			}
	}
	
	public static boolean round(TicTacToe array, String xOrY) {
		printBoard(array.getBoard());
		System.out.printf("\n%s, it is your turn.\n", xOrY);
		aPlayerMove(array, xOrY);
		return array.win(xOrY);
	}
	
	public static void aPlayerMove(TicTacToe array, String xOrY) {
		boolean correctAnswer = false;
			while(correctAnswer == false) {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Which row?");
				int row = scanner.nextInt();
				while(row >= array.getBoard().length||row<0) {
					System.out.println("\nThat number isn't on the board! "
							+ "Please try again\n");
					row = scanner.nextInt();
				}
				System.out.print("Which column?");
				int column = scanner.nextInt();
				while(column >= array.getBoard().length||column<0) {
					System.out.println("\nThat number isn't on the board! "
							+ "Please try again\n");
					column = scanner.nextInt();
				}
				correctAnswer = array.playerMove(row, column, xOrY);
			}
	}
	
	public static void printBoard(String[][] newlist) {
		//Loop to print through the array
		int lenvar = newlist[0].length;
		for(int rowlen = 0; rowlen < lenvar; rowlen++) {
			System.out.printf("  %d", rowlen);
		}
		System.out.println();
		for (int row = 0; row < lenvar; row++) {
			//If statement to start a new line with each new row
			if(row>0) {
				System.out.println();}
			//Create totaled variable
			int total = 0;
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
				System.out.printf("%s|",newlist[row][col]);
				//If the end of the row, print out the totaled variable
			}
		}
		String lines = new String(new char[lenvar]).replace("\0", "---");
		System.out.print("\n "+lines+"\n");
	}
}
