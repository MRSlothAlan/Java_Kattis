import java.io.File;
import java.util.Scanner;

/*
 * Pokemon, gettodadae !
 */


public class Main {
	public static int n, i, out_miles, time_tmp, speed_tmp, prev_time;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_speedlimit\\src\\sample.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) 
			{
				n = sc.nextInt();
				if (n == -1)
					return;
				out_miles = 0;
				prev_time = 0;
				for (i = 0; i < n; i++)
				{
					speed_tmp = sc.nextInt();
					time_tmp = sc.nextInt();
					out_miles += (time_tmp - prev_time) * speed_tmp;
					prev_time = time_tmp;
				}
				System.out.println(out_miles + " miles");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
