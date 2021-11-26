import java.io.File;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static int i;
	
	public static void main(String[] arg)
	{		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
