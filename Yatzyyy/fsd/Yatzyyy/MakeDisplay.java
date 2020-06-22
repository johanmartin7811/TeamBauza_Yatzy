
package Yatzyyy;


import java.util.Scanner;

public class MakeDisplay {

	public static void main(String[] args) {
		System.out.println("\nVälkommen till Yatzy");
		while (true) {
			System.out.println("********Menu********\n");
			System.out.println("Hur många spelare vill du spela");
			System.out.println("1. En spelare");
			System.out.println("2. Två spelare");
			System.out.println("3. Tre spelare ");
			System.out.println("4. Fyra spelare");
			System.out.println("Om du behöver hjälp. Tryck på H");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			String selection = input.next();
			if (selection.equals("1")) {
				createPlayers(1);

				break;
				// if 1 is selected 2 players can play
			} else if (selection.equals("2")) {
				createPlayers(2);

				// if 2 is selected 3 players can play
				break;
			} else if (selection.equals("3")) {
				createPlayers(3);

				// if 2 is selected 3 players can play
				break;
			} else if (selection.equals("4")) {
				createPlayers(4);
				// if 3 is selected 4 players can play
				break;
			} else if (selection.equalsIgnoreCase("H")) {
				yatzyHelp();
			} else {
				System.out.println("Fel val välj igen");
			}
		}

	}

	public static void yatzyHelp() // the "help" screen
	{
		System.out.println("Yatzy kan spelas av 1 till 4 spelare.\n"
				+ "Spelare använder sig av fem tärningar.\n"
				+ "Spelarna har 3 kast var.\n"
				+ "Efter varje kast väljer spelaren vilka tärningar som ska sparas och vilka som skall kastas igen detta upp till två gånger i tur och ordning.\n"
				+ "Spelaren måste sätta sina poäng i någon av rutorna varje tur.\n"
				+ "Om en spelare inte kan sätta någon poäng i någon av rutorna behöver användaren välja att sätta 0 poång i någon av rutorna.\n"
				+ "Spelet slutar när alla rutor är användna. Spelaren med den högsta totala poängen vinner spelet, efter 15 rundor.\n");
		System.out.println("Följande kombinationer får man poäng av:\r\n" 
				+ "Ettor: Summan av alla tärningar som visar siffran 1.\r\n"
				+ "Tvåor: Summan av alla tärningar som visar siffran 2.\r\n"
				+ "Treor: Summan av alla tärningar som visar siffran 3.\r\n"
				+ "Fyror: Summan av alla tärningar som visar numret 4.\r\n"
				+ "Femmor: Summan av alla tärningar som visar numret 5.\r\n"
				+ "Sexor: Summan av alla tärningar som visar siffran 6.\r\n"
				+ "Om en spelare lyckas få minst 63 poäng  i det övre avsnittet tilldelas de en bonus på 50 poäng.\r\n"
				+ "\r\n"
				+ "Ett par: Två tärningar som visar samma nummer. Summan av dessa två tärningar.\r\n"
				+ "Två par: Två olika par tärningar.  Summan av tärningarna av de två paren tärningar.\r\n"
				+ "Triss: Tre tärningar som visar samma nummer. Summan av dessa tre tärningar.\r\n"
				+ "Fyrtal: Fyra tärningar med samma nummer. Summan av dessa fyra tärningarna.\r\n"
				+ "Liten stege:  Ger 15 poäng Kombinationen 1-2-3-4-5. (summan av alla tärningar).\r\n"
				+ "Stor stege:   Ger 20 poäng Kombinationen 2-3-4-5-6. (summan av alla tärningar).\r\n"
				+ "Kåk: För att få kåk skall tre av tärningarna visa ett och samma tal, samtidigt som övriga två tärningar ska visa ett och samma tal. Exempelvis 6, 6, 6, 4 och 4.\r\n"
				+ "Chans: Summan av alla tärningar.\r\n"
				+ "Yatzy: Alla fem ärningar har samma nummer . Detta ger 50 poäng.\r\n" + "");

	}



	public  static void createPlayers(int playerNumber)

	{

		// Declare players array to hold number of Players selected for the game
		MakePlayer[] players= new MakePlayer[playerNumber];//

		//Initialise each Player by creating Player Object by passing player name
		for (int i = 0; i < playerNumber; i++) {
			System.out.println("Ange ditt " + (i+1)  + " spelare namn");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			String playerName = input.next();
			// Create Player Object and place it in the players array at the specified index
			players[i]= new MakePlayer(playerName);
			System.out.println("Spelare " + (i+1) + ": " + players[i].getName());//i=0 (i+1) means player starts from :player1

		}

		MakeYatzy yatzy = new MakeYatzy();
		
		
	   for(int r = 1; r < 16; r++)// j: rounds
			{
				System.out.println("Runda " + r);
				
				for(int j=0;j<players.length;j++) {

					System.out.println("Hej Spelare "+ players[j].getName());
					System.out.print("Tryck Enter för att spela ...");
					@SuppressWarnings("resource")
					Scanner s = new Scanner(System.in);
					s.nextLine();
					yatzy.rollDice(players[j]);//To roll the dice ,calling the method rollDice() in YatzyGame class ;
				    System.out.println("Runda " + r + " färdig.");
				// rollDicedice.reset();   
				   
			  }

		  }
		
		//print the winner of the game
		MakePlayer winner = yatzy.getWinner(players);
		
		System.out.print("Tryck Enter to know the winner ...");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		s.nextLine();
		System.out.println(" Winner is :"+winner.getName());
		
		

	}


}






