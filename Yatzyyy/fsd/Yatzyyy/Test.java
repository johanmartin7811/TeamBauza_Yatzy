package Yatzyyy;





public class Test {
	String playername1 ="Mala";
	MakePlayer player1 = new MakePlayer(playername1);
	
	String playername2 ="Pranesh";
	MakePlayer player2 = new MakePlayer(playername2);
	
	ChooseCategory category = new ChooseCategory();

	

	public void testingchoosecategorytwopair() {
			
//		{5,5,5,6,5};
	//	{2,2,3,3,3}; tested
			
		
			
			    int[] aDice1= {1,1,1,1,3};
			    int[] aDice2= {2,2,2,2,2};
			    int[] aDice3= {3,3,3,1,3};
			    int[] aDice4= {4,4,4,4,4};
			    int[] aDice5= {5,5,5,1,5};
			    int[] aDice6= {6,6,6,6,6};
			    int[] aDice7= {1,2,1,3,3};
			    int[] aDice8= {4,2,3,4,2};
			    int[] aDice9= {1,4,2,4,3};
			    int[] aDice10= {2,3,3,3,3};
			    int[] aDice11= {1,2,3,4,5};
			    int[] aDice12= {1,2,3,4,5};
			    int[] aDice13= {2,3,4,4,4};
			    int[] aDice14= {3,2,4,4,4};
			    int[] aDice15= {5,4,4,4,4};
			    
				
			    category.choice=1;
				category.checkWinnings(aDice1,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=2;
				category.checkWinnings(aDice2,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=3;
				category.checkWinnings(aDice3,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=4;
				category.checkWinnings(aDice4,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=5;
				category.checkWinnings(aDice5,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=6;
				category.checkWinnings(aDice6,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=7;
				category.checkWinnings(aDice7,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=8;
				category.checkWinnings(aDice8,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=9;
				category.checkWinnings(aDice9,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=10;
				category.checkWinnings(aDice10,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=11;
				category.checkWinnings(aDice11,player1);
				player1.setScoreCard(category.choice, category.score());
				
				category.choice=12;
				category.checkWinnings(aDice12,player1);
				player1.setScoreCard(category.choice, category.score());
				category.choice=13;
				category.checkWinnings(aDice13,player1);
				player1.setScoreCard(category.choice, category.score());
				category.choice=14;
				category.checkWinnings(aDice14,player1);
				player1.setScoreCard(category.choice, category.score());
				category.choice=15;
				category.checkWinnings(aDice15,player1);
				player1.setScoreCard(category.choice, category.score());
				
				 
				category.choice=14;
				category.checkWinnings(aDice14,player2);
				player2.setScoreCard(category.choice, category.score());
				
				MakePlayer[] players = { player1, player2};
				
				
				MakeScoreBoard ms1= new MakeScoreBoard();
				ms1.print_card(player1);
				MakeScoreBoard ms2= new MakeScoreBoard();
				ms2.print_card(player2);
				System.out.println(" Player 1 Score "+player1.getTotal());
				System.out.println(" Player 2 Score "+player2.getTotal());
				
				
				MakeYatzy yazty = new MakeYatzy();
				MakePlayer winner = yazty.getWinner(players);
				System.out.println(" Winner :"+winner.getName());
			
			
			
			
			
			
			
			}
	
	public static void main (String args []) {
		
		Test test = new Test();
		test.testingchoosecategorytwopair();
		
	}
	


}
