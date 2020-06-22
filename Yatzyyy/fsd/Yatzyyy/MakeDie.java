package Yatzyyy;


	import java.util.Random;

	public class MakeDie {

		private int value;
		  private Random rand;
		 
		  public MakeDie() {
		    value = 0;
		    rand = new Random();
		  }
		 
		  public void roll() {
		    value = 1 + rand.nextInt(6);
		  }
		 
		  public int get() {
		    return (value);
		  }
		}
	
	


