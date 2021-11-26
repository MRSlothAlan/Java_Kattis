/*
Yes, I am still here. I am PASSIONATE in this shit.
*/
import java.io.File;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static String in_str;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			in_str = sc.nextLine();
			// in_str = in_str.replace(" ", "").trim();
			System.out.println("Thank you, " + in_str + ", and farewell!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

