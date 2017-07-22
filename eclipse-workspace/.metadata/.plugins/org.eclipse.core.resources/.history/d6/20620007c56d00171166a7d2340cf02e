/*
 * Nick Benyo
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package benyon_lab3;

import java.util.Random;

/**
 * GuessGame class, constructs objects useful for building
 * a random number guessing game. Objects allow for range changes
 * of the number, number is always randomly assigned by Random class
 * @author Nick Benyo
 *
 */
public class GuessGame {
	private int actualNumber;//The number to be guessed in the game
	private int guesses;//A count of the user guesses
	private int rangeMinimum;//The lower bounds of the number
	private int rangeMaximum;//The upper bounds of the number
	
	/**
	 * Constructs a GuessGame object, takes in values for each data member
	 * @param guesses the number of user made guesses
	 * @param RangeMinimum lower bounds of number being guessed
	 * @param RangeMaximum upper bounds of number being guessed
	 */
	public GuessGame(int guesses, int RangeMinimum,int RangeMaximum) {
		this.guesses = guesses;
		this.rangeMinimum = RangeMinimum;
		this.rangeMaximum = RangeMaximum;
		newTarget();//generates a random value using bounds for actualNumber
	}
	
	/**
	 * GuessGame constructor, setting the default values to 0 guesses,
	 * 100 minimum value, and 200 maximum value.
	 */
	public GuessGame() {
		this(0,100,200);
		newTarget();
	}
	
	/**
	 * Prints the statistics of the match, to be used after the user
	 * has successfully guessed the number
	 */
	public void displayStatistics() {
		System.out.printf("That's correct!\nYou guessed %d time(s)\n",guesses);
	}
	
	/**
	 * Generates a new random integer and assigns to the the actualNumber data
	 * member
	 */
	public void newTarget() {
		Random rand = new Random();
		this.actualNumber = this.rangeMinimum + 
				rand.nextInt(this.rangeMaximum - this.rangeMinimum + 1);
	}
	
	/**
	 * Takes in an integer guess value, adds 1 count to the 
	 * guesses class field, compares to actualNumber, and returns
	 * a boolean value
	 * @param num the guess value being made
	 * @return a true or false value on if num matches actualNumber
	 */
	public boolean Guess(int num) {
		this.guesses++;
		displayHint(num);
		return num == this.actualNumber;
	}
	
	/**
	 * Returns the rangeMinimum field
	 * @return data member, the lower limit of the guessing game 
	 */
	public int getRangeMinimum() {
		return rangeMinimum;
	}
	
	/**
	 * Returns the rangeMaximum field
	 * @return data member, the upper limit of the guessing game
	 */
	public int getRangeMaximum() {
		return rangeMaximum;
	}

	
	/**
	 * Takes in an integer, compares to the actualNumber, and prints out
	 * a hint as to whether actualNumber is higher or lower than num.
	 * @param num an integer value guess of actualNumber
	 */
	private void displayHint(int num) {
		if(num > actualNumber){
			System.out.printf("%d is too high\n", num);
		} else if(num < actualNumber){
			System.out.printf("%d is too low\n", num);
		}
	}
	
}
