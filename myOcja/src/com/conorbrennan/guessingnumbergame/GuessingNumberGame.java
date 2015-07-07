package com.conorbrennan.guessingnumbergame;



import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {

	public static void main(String[] args) {

		Random rand = new Random();

		Scanner scan = new Scanner(System.in);

		boolean playAgain = false;



		boolean haveWeGuessedYet = false;


		do{

			int guess = 0;

			int randomNumber = rand.nextInt(20) + 1;

			boolean[] guesses = new boolean[20];

			int countGuess = 0;

			boolean invalid = true;
			boolean validGuess = false;

			do{

				//System.out.println(randomNumber);



				do{	

					if(haveWeGuessedYet){
						System.out.print("The numbers you have already guessed are: ");
					}

					for( int i = 0 ; i <guesses.length ; i++){

						if(guesses[i]){

							System.out.print( i + 1 + " ");

						}
					}

					System.out.print("\nThe numbers you have left to guess are: ");

					for( int i = 0 ; i <guesses.length ; i++){

						if(!guesses[i]){

							System.out.print( i + 1 + " ");

						}
					}



					System.out.println("\nGuess a number between 1 and 20: ");
					try {

						String input = scan.next();

						guess = Integer.parseInt(input);

						validGuess = true;

					} catch (Exception e) {

						System.out.println("Put in a proper digit(1-20)");

						validGuess = false;

					}

					if(guess > 0 && guess < 21){
						if(guesses[guess - 1]){
							validGuess = false;
							System.out.println("You have already picked this number,\nPick another number please!\n");
						} else {
							guesses[guess-1] = true;
							validGuess = true;
							haveWeGuessedYet = true;
						}


					} else {
						validGuess = false;
						System.out.println("Enter between 1-20");
					}


				}while(!validGuess);

				if(guess == randomNumber){

					System.out.println("You got it right, the number was " + randomNumber 
							+ " and you used " + (countGuess + 1) + " guesses.");
					invalid = false;
				}else{

					System.out.println("Wrong guess, Guess again.");


					countGuess++;


				}

			}while(invalid);

			validGuess = false;
			haveWeGuessedYet = false;

			do{
				System.out.println("Would you like to play agian? Y/N: ");

				String exit = scan.next();

				exit = exit.toUpperCase();

				if(exit.equals("Y")){
					System.out.println("Y");
					validGuess = true;
					playAgain = true;

				} else if (exit.equals("N")) {
					System.out.println("Thank you for playing, good bye");
					validGuess = true;
					playAgain = false;
				} else {
					System.out.println("Please Y or N");
					validGuess = false;
				}
			}while(!validGuess);

		}while(playAgain);

		scan.close();
	}

}

