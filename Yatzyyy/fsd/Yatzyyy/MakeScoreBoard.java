
package Yatzyyy;

public class MakeScoreBoard {
	// array of categories
	String[] scores_map = { "1-Ettor       ", "2-Tvåor       ", "3-Treor       ", "4-Fyror       ", "5-Femor       ",
			"6-Sexor       ", "7-Ett par     ", "8-Två par     ", "9-Triss       ", "10-Fyrtal     ", "11-Liten stege",
			"12-Stor stege ", "13-Kåk        ", "14-Chans      ", "15-Yatzy      " };
	int[] totals = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	int total_score = 0;
	int chooseposition = 0;
	int sum = 0;
	String[] catScore = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };

	public void print_card(MakePlayer player) {
		
        sum= 0 ;
		int[] scoreCard = player.getScorecard();
		String t_num = "";
		String leftAlignFormat = "| %-33s      | %n";
	
		// print scoreBoard
		System.out.format("+------------------------------+---------+%n");
		System.out.format("| Kategori                     | score	 |%n");
		System.out.format("+------------------------------+---------+%n");

		for (int j = 0; j < 15; j++) {
			
			
			t_num = Integer.toString(this.totals[j]);
			if (t_num.equals("-1")) {
				t_num = "               |";

				String score = "";

				if (scoreCard[j] < 0)
					score = "";

				else {
					sum+=scoreCard[j];
					score = String.valueOf(scoreCard[j]);
				}

				

				System.out.format(leftAlignFormat, this.scores_map[j] + "" + t_num + "" + score);

			}

			System.out.format("+------------------------------+---------+%n");
			
			
			
			if (j==5)    {
	              //Print total for upper section.
	              System.out.format(leftAlignFormat, "Summa         " + "" + t_num + "" + getUpperCategorySum(scoreCard));
	              System.out.format("+------------------------------+---------+%n");
	             
	            //Print bonus for upper section.
	              int bonus=getBonus(scoreCard);
	              System.out.format(leftAlignFormat, "Bonus         " + "" + t_num + "" + bonus);
	              System.out.format("+------------------------------+---------+%n");
	              }
		
          
          

		}
		
		
		//Print total for the whole scoreBoard.
		player.setTotal(sum);
		 String totalText="Total         " ;
		System.out.format(leftAlignFormat, totalText + "" + t_num + "" + player.getTotal());
  	    System.out.format("+------------------------------+---------+%n");
		

	}
	
	

	public int getUpperCategorySum(int[] scoreCard) {

		int sum = 0;

		for (int i = 0; i < 6; i++) {

			if (scoreCard[i] >= 0)
				sum += scoreCard[i];

		}

		return sum;

	}

	public int getBonus(int [] scoreCard) {

		if (getUpperCategorySum(scoreCard) >= 63) {

			return 50;

		}

		else {

			return 0;

		}

	}
}
