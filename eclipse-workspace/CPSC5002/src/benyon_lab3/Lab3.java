/*
 * Nick Benyo
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package benyon_lab3;

import java.util.Scanner;

/**
 * Starts the Guessing Game, allowing the user unlimited attempts until
 * they guess correctly. The user can continue or exit at the end of each
 * round.
 * @author Nick Benyo
 *
 */
public class Lab3 {

	public static void main(String[] args) {
		gamePlay();
		
	}
	
	/**
	 * gamePlay repeats matches until the user enters no through the terminal.
	 */
	public static void gamePlay() {
		String  repeat = "yes";
		Scanner userInput = new Scanner(System.in);
		while (!repeat.equals("no")) {
			GuessGame example = new GuessGame(0,100,200);
			oneRound(example);
			System.out.print("Ready to play again? (no to quit)\n");
			repeat = userInput.nextLine();
		}
		System.out.print("Thanks for playing!");
	}
	
	/**
	 * Takes in a GuessGame object and loops
	 * @param object an object of the GuessGame class
	 */
	public static void oneRound(GuessGame object) {
		boolean succeed = false;
		welcome();
		while (succeed == false) {
			succeed = captureGuess(object);
		}
		object.displayStatistics();
		
	}
	
	/**
	 * captureGuess accepts a GuessGame object and takes in a user guess
	 * through scanner, executing .Guess() to check value, returns boolean
	 * @param example a GuessGame object
	 * @return a boolean true or false from .Guess() comparing
	 */
	public static boolean captureGuess(GuessGame object) {
		Scanner userInput = new Scanner(System.in);
		roundPrint(object.getRangeMinimum(), object.getRangeMaximum());
		int newGuess = userInput.nextInt();
		return object.Guess(newGuess);
	}
	
	/**
	 * Prints the welcome statement at the start of the game.
	 */
	public static void welcome() {
		System.out.print("This is a guessing game where you will guess a"
				+ "number and I tell you if it is too low or too high.\n");
	}
	
	/**
	 * roundPrint takes two values to print out a statement for each round
	 * of the Guessing Game
	 * @param min the minimum value of the guessing range
	 * @param max the maximum value of the guessing range
	 */
	public static void roundPrint(int min, int max) {
		System.out.printf("Guess a number between %d and %d\n", min, max);
	}

}
