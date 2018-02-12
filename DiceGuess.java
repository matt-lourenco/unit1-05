/****************************************************************************
 *
 * Created by: Matthew lourenco
 * Created on: Feb 2018
 * This program asks you to guess the number that was rolled on a simulated
 *     die.
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DiceGuess {

	public static void main(String[] args) {
		// Rolls a simulated dice and asks the user to guess what was rolled
		
		int numberOfGuesses = 1;
		String input = "";
		int guess = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(System.in));
		
		System.out.println("Guess the number that was rolled on the dice:");
		try {
			//Get user input
			input = reader.readLine();
		} catch (IOException noInput) {
			noInput.printStackTrace();
		}
		try {
			//Convert string to integer
			guess = Integer.parseInt(input);
		} catch (NumberFormatException stringInput) {
			System.out.println("Please enter an integer");
		}
		
		Random rand = new Random();
		int roll = rand.nextInt(6) + 1;
		
		//Loop until guess is correct
		while(guess != roll) {
			System.out.println("Wrong. Guess again:");
			try {
				//Get user input
				input = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			try {
				//Convert string to integer
				guess = Integer.parseInt(input);
				//Add to number of guesses
				numberOfGuesses++;
			} catch (NumberFormatException stringInput) {
				System.out.println("Please enter an integer");
			}
		}
		
		if(numberOfGuesses==1) {
			System.out.println("Congrats you got it! The number was "+roll+
					"! It took you "+numberOfGuesses+" guess.");
		} else {
			System.out.println("Congrats you got it! The number was "+roll+
					"! It took you "+numberOfGuesses+" guesses.");
		}
	}
}