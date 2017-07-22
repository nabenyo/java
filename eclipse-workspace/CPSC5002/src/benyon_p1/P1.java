package benyon_p1;

import java.util.Random;

public class P1 {

	public static void main(String[] args) {
		TicTacToe testarray = new TicTacToe(3);
		print(testarray.getBoard());
		testarray.playerMove(0, 0, "X");
		print(testarray.getBoard());
		testarray.playerMove(1, 0, "X");
		print(testarray.getBoard());
		testarray.playerMove(2, 0, "X");
		print(testarray.getBoard());
	}
	public static void print(String[][] newlist) {
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