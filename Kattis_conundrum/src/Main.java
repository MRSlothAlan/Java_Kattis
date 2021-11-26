/*
Yes, I am still here. I am PASSIONATE in this shit.
*/
import java.io.File;
import java.util.Scanner;

/*
 * everyday, replace one character --> form a chiper text.
 */
public class Main {
	public static String in_str;
	public static int i, j, count;
	public static char[] pattern = {'P', 'E', 'R'};
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			in_str = sc.next();
			count = 0;
			for (i=0; i < in_str.length(); i+=3)
			{
				for (j=0; j < 3; j++)
				{
					if (in_str.charAt(j+i) != pattern[j]) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

