/*
 * Nick Benyo
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package benyon_lab1;
import java.util.Random;
import java.util.Scanner;

/**
 * Begins a loop that allows the user specify the size of an array,
 * prints the array to console with totals of columns, rows, and
 * diagonals, and repeats if the user desires
 * @author Nick Benyo
 */
public class TwoDimArray {

	public static void main(String[] args) {
		System.out.print("This program asks for the size of a 2d square\n"
				+ "array of integers, then creates the square array, fills\n"
				+ "it with random integers, then prints it out along with\n"
				+ "sums in both directions and along the diagonals.\n\n");
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		String generate = "y";
		while (generate.contentEquals("y")) {
			System.out.println("How many rows (something between 1 and 10)?");
			int array_size = scanner.nextInt();
			while (array_size > 10 || array_size < 0) {
				System.out.println("Please try again, select a value "
						+ "between 1 and 10");
				array_size = scanner.nextInt();
			}
			print(array(array_size));
			System.out.println();
			System.out.println("Go again? (y for yes)");
			generate = scanner2.nextLine();
		}
		System.out.println("Thank you for playing!");
	}
	
	/**
	 * Generates a random n x n two dimensional array of numbers
	 * @param A is the array length (A x A, array is always square)
	 * @return Two dimensional array of random numbers
	 */
	public static int[][] array(int A) {
		Random randomNumbers = new Random();
		int ROWS = A;
		int COLS = A;
		int[][] x  = new int[ROWS][COLS];
		//Nested loop assigning random numbers to each value in the array
		for (int row = 0; row < ROWS; row++){		
			for (int col = 0; col < COLS; col++) {
				int number = randomNumbers.nextInt(100);
				x[row][col] = number;
			}
		}
		return x;
	}
	
	/**
	 * Calculates the totals and diagonals of an array and prints
	 * to the screen
	 * @param newlist an n x n array (must be square) to calculate
	 * and print to screen
	 */
	public static void print(int[][] newlist) {
		//Loop to print through the array
		for (int row = 0; row < newlist.length; row++) {
			//If statement to start a new line with each new row
			if(row>0) {
				System.out.println();}
			//Create totaled variable
			int total = 0;
			//Loop through each value in the array
			for (int col = 0; col < newlist[row].length; col++) {
				//Create indent with each row for diagonals total
				if(col==0) {
					System.out.print("\t");
				}
				total += newlist[row][col];
				System.out.print(newlist[row][col]);
				System.out.print("\t");
				//If the end of the row, print out the totaled variable
				if(col == newlist[row].length-1) {
					System.out.printf(" = %d", total);
				}
			}
		}
		//Print a new line for all the column totals
		System.out.println();
		//Calculate the first diagonal total value
		int d_total = 0;
		int r_diag = newlist.length-1;
		for (int diag = 0; diag < newlist.length; diag++) {
			d_total += newlist[diag][r_diag];
			r_diag--;
			if(diag == newlist.length-1) {
				System.out.print(d_total);
				System.out.print("\t");
			}
		}		
		//Print all column totals
		for (int col = 0; col < newlist[0].length; col++) {
			int total = 0;
			for (int row = 0; row < newlist.length; row++) {
				total += newlist[row][col];
				if(row == newlist[row].length-1) {
					System.out.print(total);
					System.out.print("\t");
				}
			}
		}
		//Calculate the second diagonal value
		int d2_total = 0;
		for (int diag = 0; diag < newlist.length; diag++) {
			d2_total += newlist[diag][diag];
			if(diag == newlist.length-1) {
				System.out.print("   ");
				System.out.print(d2_total);
			}
		}
	}
}
