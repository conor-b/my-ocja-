package com.conorbrennan.dowhile;


import java.util.Scanner;


public class GameApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		boolean playAgain = true;
		String games ;
		do{
			try {

				System.out.println("How many games would you like to play?(press 0 to quit)");
				games = scan.next();
				int newGame = Integer.parseInt(games);
				if(newGame==0){
					System.out.println("Thanks for playing");
					playAgain = false;
				}

				while(newGame>0){
					System.out.println("playing game...");
					newGame--;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Not a valid choice ... Please pick a number");
			}


		}while(playAgain);
		scan.close();
	}

}
