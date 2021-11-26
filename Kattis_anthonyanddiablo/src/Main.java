import java.io.File;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */

public class Main {
	public static double A, N;	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_anthonyanddiablo\\src\\diablo-01.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			A = sc.nextDouble();	// area in square meters
			N = sc.nextDouble();	// meters of fencing.
			double radius = N / (2 * Math.PI);
			if (N / 2 * radius >= A)
			{
				System.out.println("Diablo is happy!");		// circle has infinite number of sides to cover area
			}
			else
			{
				System.out.println("Need more materials!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
