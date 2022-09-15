package studio2;
import java.util.*;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Start Amount: ");
		int startAmount = in.nextInt();
		System.out.println("Enter Win Chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter Win Limit: ");
		int winLimit = in.nextInt();
		int totalSimulations=0;
		System.out.println("Enter Playing Days: ");
		int days = in.nextInt();
		double a = (1-winChance)/winChance;
		int c = startAmount;
		if(winChance == 0.5) {
			double expectedRuin = 1.0 - ((double)startAmount/(double)winLimit);
			System.out.println("Expected Ruin Rate Is " + expectedRuin);
		}
		else {
			double expectedRuin = (Math.pow(a,startAmount)-Math.pow( a,winLimit))/(1-Math.pow(a,winLimit));
			System.out.println("Expected Ruin Rate Is " + expectedRuin);
		}

		for (int d = 0; d <= days;d++){
			startAmount=c;
			while (startAmount>0 && startAmount < winLimit) {
					totalSimulations++;
				double b= Math.random();
				if (b>1-winChance) {
					startAmount++;
					System.out.println("Simulation " +totalSimulations+" Success!");
				}
				else {
					startAmount--;
					System.out.println("Simulation " +totalSimulations+" Failure");
				}
			}
		
			}
		System.out.println("Total Simulations= "+totalSimulations);
	}
	}


