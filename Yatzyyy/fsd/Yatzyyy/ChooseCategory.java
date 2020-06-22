package Yatzyyy;

import java.util.Arrays;

public class ChooseCategory {

	public int score;
	public int choice;


	public ChooseCategory() {
		// score = 0;
	}

	public void checkWinnings(int[] aDice,MakePlayer player) {
		//choose category
		System.out.println("Vilken kategori vill du välja?");

		if(choice==0)
			choice = MakeYatzy.inputInt("");
		
		//if wrong category chosen
		while (choice > 15 || choice <= 0) {

			System.out.println("\r\n" + "Ogiltig kategori. Välj rätt kategori ");
			choice = MakeYatzy.inputInt("");
		}


		//if  category already used choose another category
		while(player.scoreCard[choice-1]>=0) {

			System.out.println("Kategorien är redan änvänd");
			System.out.println(MakeYatzy.showDice(aDice));
			System.out.println("Välj en annan kategori");
			choice = MakeYatzy.inputInt("");

		}


		int y = 0,x = 0, winings = 0, winingsa=0;
		int onepair_score=0,twopair_score=0,threeofkind_score=0,fourofkind_score=0;


		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		int win1=0,win2=0,win3=0,win4=0;
		Arrays.sort(aDice);

		//Numbers
		for (y = 0; y < 5; y++) {
			if (aDice[y] == 1) {
				ones++;
			}
			if (aDice[y] == 2) {
				twos++;
			}
			if (aDice[y] == 3) {
				threes++;
			}
			if (aDice[y] == 4) {
				fours++;
			}
			if (aDice[y] == 5) {
				fives++;
			}
			if (aDice[y] == 6) {
				sixes++;
			}
		}


		//Pairs {4,4,4,6,6};
		for (x = 0; x < 5; x++) {
			if (x != 0) {
				if ((aDice[0] == aDice[x]))
				{

					onepair_score = aDice[0] + aDice[x];

					winings++;	
					win1++;
					if(win1==2) {
						threeofkind_score=aDice[x]*3;

					}
					if(win1==3) {
						fourofkind_score=aDice[x]*4;
						twopair_score=0;

					}
					if(!( win1>1)) {

						{
							twopair_score+=aDice[x]*2;
							//	        		  System.out.println("X :"+x+" aDice["+x+"] :"+ aDice[x]+" Winings "+winings+"Win1 " +win1+ " TwoPair Score "+twopair_score+" Score "+score);

						}

					}




				}
			}
			//one pair, two pair, three of kind and four of kind
			if ((x != 0) && (x != 1)) {
				if ((aDice[1] == aDice[x])) {
					onepair_score = aDice[1] + aDice[x];
					winings++;
					win2++;
					if(win2==2) {
						threeofkind_score=aDice[x]*3;

					}
					if(win2==3) {
						fourofkind_score=aDice[x]*4;
						twopair_score=0;

					}
					if(!( win2>1 && win1<1) && (aDice[0] != aDice[x]) )
					{
						twopair_score+=aDice[x]*2;
						//	        	  System.out.println("X :"+x+" aDice["+x+"] :"+ aDice[x]+" Winings "+winings+" Win3 " +win3+ " TwoPair Score "+twopair_score+" Score "+score);

					}


				}
			}
			if ((x != 0) && (x != 1) && (x != 2)) {
				if ((aDice[2] == aDice[x])) {
					onepair_score = aDice[2] + aDice[x];
					winings++;
					win3++;
					if(win3==2) {
						//System.out.println("three of a kind");
						threeofkind_score=aDice[x]*3;

					}
					if(win3==3) {
						//System.out.println("four of a kind");
						fourofkind_score=aDice[x]*4;
						twopair_score=0;

					}
					if(!( win3>1)) {
						twopair_score+=aDice[x]*2;
						//	        	  System.out.println("X :"+x+" aDice["+x+"] :"+ aDice[x]+" Winings "+winings+" Win3 " +win3+ " TwoPair Score "+twopair_score+" Score "+score);

					}





				}

			}
			if ((x != 0) && (x != 1) && (x != 2) && (x != 3)) {
				if ((aDice[3] == aDice[x])) {
					onepair_score= aDice[3]+aDice[x];
					winings++;
					win4++;
					if(win4==2) {
						//System.out.println("three of a kind");
						threeofkind_score=aDice[x]*3;

					}
					if(win4==3) {
						//System.out.println("four of a kind");
						fourofkind_score=aDice[x]*4;
						twopair_score=0;

					}
					if(!( win3>1) ) {
						twopair_score+=aDice[x]*2;
						//	        	  System.out.println("X :"+x+" aDice["+x+"] :"+ aDice[x]+" Winings "+winings+" Win4 " +win4+ " TwoPair Score "+twopair_score+" Score "+score);
					}




				}

			}
		}

		//Small Straight and Large Straight  
		if ((aDice[0] == aDice[1] - 1) && (aDice[1] == aDice[2] - 1)
				&& (aDice[2] == aDice[3] - 1) && (aDice[3] == aDice[4] - 1) 
				&& (choice == 11)) {
			winingsa = 1;
		} else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)&& (fives > 0)) {
			winingsa = 2;
		} else if ((twos > 0) &&(threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) {
			winingsa = 2;
		} 





		//Winnings
		score=0;

		if (choice == 1) {
			//System.out.println("Du har " + ones + " Ettor.");
			score = ones;
		} else if (choice == 2) {
			//System.out.println("Du har " + twos + " Tv�or.");
			score = twos * 2;
		} else if (choice == 3) {
			//System.out.println("Du har " + threes + " Treor.");
			score = threes * 3;
		} else if (choice == 4) {
			//System.out.println("Du har " + fours + " Fyror.");
			score = fours * 4;
		} else if (choice == 5) {
			//system.out.println("Du har " + fives + " Femmor.");
			score = fives * 5;
		} else if (choice == 6) {
			//System.out.println("Du har " + sixes + " Sexor.");
			score = sixes * 6;
		} else if ((choice == 9) && (winings >= 3)) {
			//System.out.println("You have three of kind.");

			score =  threeofkind_score;
		} else if ((winings >=6) && (choice ==10 )) {
			//System.out.println("You have four of a kind.");
			score = fourofkind_score;

		}else if ((choice == 7) && (winings > 0)) {
			//System.out.println("You have a One pair.");
			score = onepair_score;
		} else if ((winings >= 2) && (winings < 6) && (choice == 8)) {
			//System.out.println("You have two pairs.");
			if(!(winings < 6))
				twopair_score=0;
			score=twopair_score;


		}
		// Small Straight: The combination 1-2-3-4-5. Score: 15 points (sum of all the dice).
		// Large Straight: The combination 2-3-4-5-6. Score: 20 points (sum of all the dice)


		if ((winingsa == 1) && aDice[0] ==1 && (choice == 11)) {
			//System.out.println("You have a small straight.");
			score = 15;
		} else if ((winingsa == 2) && aDice[0] ==2 && (choice == 12)) {
			//System.out.println("You have a large straight.");
			score = 20;
		} 
		else if ((winings == 4) && (choice == 13)) {
			//System.out.println("You have a full house.");
			score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
		}
		//chance
		else if(choice == 14) {
			score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
		}
		else if(choice == 15) {
			//Yatzy
			if ((aDice[0] == aDice[1])&& (aDice[0] == aDice[2])&& (aDice[0] == aDice[3])&& (aDice[0] == aDice[4]) && (choice == 15)){
				//System.out.println("You have a Yatzy.");
				score =50;
			}


		}


	}

	public int score() {
		return (score);
	}

	public int choice() {
		return (choice);
	}


}
