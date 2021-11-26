import java.io.File;
import java.util.Scanner;

/*
 *  Output the day of the week on day D of month M in 2009. 
 *  The output should be one of the words 
 *  ¡§Monday¡¨, ¡§Tuesday¡¨, ¡§Wednesday¡¨, ¡§Thursday¡¨, ¡§Friday¡¨, ¡§Saturday¡¨ or ¡§Sunday¡¨.
 */

public class Main {
	public static int D, M;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			D = sc.nextInt();
			M = sc.nextInt();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
