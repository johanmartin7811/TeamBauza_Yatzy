package Yatzyyy;



public class MakePlayer {

	String playerName = "";
	int bonus=0;
	int total=0;
	


	int[] scoreCard = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};//new code


	public MakePlayer(String name) {

		playerName = name;

	}


	public int[] getScorecard() {//new code

		return scoreCard;
	}

	public void setScoreCard(int cat, int score) {  // new code

		scoreCard[cat-1]=score;


	}



	public String getName() {
		return playerName;

	}


	public int getTotal() {
		return total;

	}

	public void setTotal(int sum) {

		total=sum;


	}

	



}
