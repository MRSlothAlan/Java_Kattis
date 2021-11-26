import java.io.File;
import java.util.Scanner;

/*
 * Q1 = x >=
 */
public class Main {
	public static int x, y;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			x = sc.nextInt();
			y = sc.nextInt();
			if (x > 0 && y > 0)
			{
				System.out.println(1);
			}
			else if (x < 0 && y > 0)
			{
				System.out.println(2);
			}
			else if (x < 0 && y < 0)
			{
				System.out.println(3);
			}
			else if (x > 0 && y < 0)
			{
				System.out.println(4);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
