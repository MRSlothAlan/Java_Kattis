import java.io.File;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static int T, i, t;
	public static long in_value, tmp, N;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_anothercandies\\src\\a.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			for (i = 0; i < T; i++)
			{
				tmp = 0;
				N = sc.nextInt();
				for (t = 0; t < N; t++)
				{
					// input candies. Use nextLong(), not integer
					in_value = sc.nextLong();
					tmp += in_value % N;
				}
				if (tmp % N == 0)
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
