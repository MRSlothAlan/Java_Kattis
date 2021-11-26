import java.io.File;
import java.util.Scanner;

/*
 * Spider
 */
public class Main {
	public static int t, m, i, j, k;
	
	public static void main(String[] arg)
	{		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			t = sc.nextInt();
			while(t > 0)
			{
				m = sc.nextInt();
				t--;
				System.out.println(m);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
