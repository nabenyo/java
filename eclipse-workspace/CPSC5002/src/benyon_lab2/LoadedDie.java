package benyon_lab2;

import java.util.Random;

/**
* The constructor performs an initial roll of the die.
* @param loadedNumber        which number should come up more often
* @param moreTimesPerHundred how many times per 100 rolls to come up with 
*                            the loaded number (instead of uniform random)
* @param result				 the resulting die roll value
*/
public class LoadedDie {
	private int loadedNumber;
	private int moreTimesPerHundred;
	private int result;
	
	/**
	 * Default constructor for loaded die, rolls when created
	 */
	public LoadedDie() {
		this(6,30);
		roll();
	}
	
	/**
	 * Constructor with pass through values
	 */
	public LoadedDie(int loadedNumber, int moreTimesPerHundred) {
		this.loadedNumber = loadedNumber;
		this.moreTimesPerHundred = moreTimesPerHundred;
		roll();
	}
	
	 /**
	 * The roll method simulates the rolling of the die.
	 * It will typically set this die's value to a random value
	 * with uniform distribution between 1 and 6. Occasionally,
	 * it will a priori return the favored value (with frequency
	 * determined by the moreTimesPerHundred argument that was passed
	 * to the constructor).
	 */
	public void roll() {
		Random randomNumbers = new Random();
		int number = randomNumbers.nextInt(6)+1;//roll value
		int loadedProbability = randomNumbers.nextInt(100);
		//loaded probability used to determine if die will be loaded
		if (loadedProbability >= this.moreTimesPerHundred) {
			this.result = number;
		}
		else {
			this.result = loadedNumber;
		}
	}
	
	public int getResult() {
		return this.result;
	}
	
}