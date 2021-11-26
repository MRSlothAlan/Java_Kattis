import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * enemy must at least 3 detected --> pinpoint the location.
 * detection valid if ranges touch at more that one point.
 */
public class Main {
	public static int cx, cy, n, i;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_areyoulistening\\src\\1.in");
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_areyoulistening\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			cx = sc.nextInt();		// current x location
			cy = sc.nextInt();		// current y location
			n = sc.nextInt();		// number of listening devices, guaranteed at least 3.
			int x, y, r;
			// show radius of max broadcast area, nearest integer. Any edge cases?
			double[] calculated_distance = new double[n];
			
			for (i = 0; i < n; i++)
			{
				// x y r, all location distinct, -1000, 1000
				x = sc.nextInt();
				y = sc.nextInt();
				r = sc.nextInt();
				calculated_distance[i] = Math.sqrt(Math.pow((x - cx), 2) + Math.pow((y - cy), 2)) - r;
			}
			Arrays.sort(calculated_distance);
			double ans = calculated_distance[0];
			
			int cnt = 0;
			for (i = 1; i < calculated_distance.length; ++i)
			{
				cnt++;
				if(calculated_distance[i] != calculated_distance[i - 1])
				{
					ans = calculated_distance[i];
				}
				if (cnt == 2)
					break;
			}
			// for most of the time, pick the 3rd smallest radius (at most 2 areas included.)
			System.out.println((int) Math.max(0, Math.floor(ans)));
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
