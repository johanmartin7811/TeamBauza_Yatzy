package Yatzyyy;

import Yatzyyy.ChooseCategory;
import Yatzyyy.MakeDie;


@SuppressWarnings("unused")
public class MakeYatzy {



	public void rollDice(MakePlayer player)  {

		int scorea = 0;


		int[] aDice = new int[] { 0, 0, 0, 0, 0 };// creates an array
		int roll = 0;
		int rollcount=1;
		int x, y, w;
		int rerolla = 0, rerollb = 03;
		MakeDie die = new MakeDie();
		for (x = 0; x < 5; x++) {

			die.roll();
			aDice[x] = die.get();// sets the dice values
		}
		rollcount = roll+rollcount;
		System.out.println("Kast :" + rollcount);
		System.out.println(showDice(aDice));

		//reroll the dices how many do you want to reroll?
		do {
			rerolla = inputInt("Hur många tärningar vill du kasta igenom? (0-5)");
			if (rerolla > 0 && rerolla < 6 ) {
				int[] reroll = new int[rerolla];
				for (y = 0; y < rerolla; y++) {
					rerollb = inputInt("Vilka?");
					reroll[y] = rerollb;
				}
				for (w = 0; w < rerolla; w++) {
					if (reroll[w] == 1) {
						die.roll();
						aDice[0] = die.get();
					}
					if (reroll[w] == 2) {
						die.roll();
						aDice[1] = die.get();
					}
					if (reroll[w] == 3) {
						die.roll();
						aDice[2] = die.get();
					}
					if (reroll[w] == 4) {
						die.roll();
						aDice[3] = die.get();
					}
					if (reroll[w] == 5) {
						die.roll();
						aDice[4] = die.get();
					}
					


				}
				roll++;
				int rollcount2 = 1;
				rollcount2 = roll + rollcount2;
				//System.out.println("Roll :" + roll+1 );
				System.out.println("Kast :" + rollcount2 );

				System.out.println(showDice(aDice));
			}
		} while ((roll < 2) && (rerolla > 0));

		// ScoreBoard Class
		MakeScoreBoard score = new MakeScoreBoard();
		score.print_card(player);// New Code blank ScoreCard
		////////////////////



		// ChooseCategory Class 
		ChooseCategory p = new ChooseCategory();
		p.checkWinnings(aDice,player);
		///////////////////////

		scorea += p.score();

		player.setScoreCard(p.choice(), scorea);// New Code
		//System.out.println("För denna kategori �r din total po�ng:" + scorea);
		score.print_card(player);




	}


	static int inputInt(String Prompt) {
		int result = 0;
		try {
			result = Integer.parseInt(input(Prompt).trim());
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	static String input(String prompt) {
		String inputLine = "";
		System.out.print(prompt);
		try {
			java.io.InputStreamReader sys = new java.io.InputStreamReader(System.in);
			java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
			inputLine = inBuffer.readLine();
		} catch (Exception e) {
			String err = e.toString();
			System.out.println(err);
		}
		return inputLine;
	}

	public static StringBuffer showDice(int[] dice)

	{
		
		//show dicevalue
		StringBuffer showDiceValues= new StringBuffer(); 

		showDiceValues.append("----------------------------");
		showDiceValues.append("\n");
		showDiceValues.append("|Tärning|");

		for(int j=1;j<=dice.length;j++) {
			showDiceValues.append(" "+j+" ");
			showDiceValues.append("|");
		}
		showDiceValues.append("\n");
		showDiceValues.append("----------------------------");
		showDiceValues.append("\n");
		showDiceValues.append("|Nummer |");

		for(int j=0;j<dice.length;j++) {

			showDiceValues.append(" "+dice[j]+" ");
			showDiceValues.append("|");
		}
		showDiceValues.append("\n");
		showDiceValues.append("---------------------------- ");
		return showDiceValues;


	}
	
	
	//take care of the points to present the winner
	public MakePlayer getWinner (MakePlayer[] players) {
		   int currentWinner = 0;
		   MakePlayer winningPlayer=null; 
		   for (int i = 0; i<players.length; i++) {
		      if (currentWinner < players[i].getTotal() ) {
		         currentWinner =  players[i].getTotal();
		         winningPlayer = players[i];
		      }
		   }
		    return winningPlayer;
		}
}