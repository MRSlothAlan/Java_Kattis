import java.io.File;
import java.util.Scanner;

/*
 * Abstract painting
 * 		red, green, blue
 * 		all edges of unit squares must be painted, each edge -> 1 color
 * 		exactly 2 colors must be used to paint 4 edges
 * 			each color --> exactly used to paint 2 edges.
 * 
 * 1 <= R <= 14, 1 <= C <= 2000
 * 
 * First square --> 6 possible orientations, 6 pairs of colors each = 6 x 6 = 36
 * 
 * https://open.kattis.com/problems/abstractpainting
 */

public class Main {
	
	public static int T, i, R, C;
	public static long mod_num = 1000000007;
	
	
	public static void main(String[] arg)
	{		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_abstractpainting\\src\\1.in");
		try {
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			for (i = 0; i < T; i++)
			{
				R = sc.nextInt();	// rows of canvas
				C = sc.nextInt();	// columns of canvas
				// paint all the edges of all unit squares.
				// output the number of good paintings.
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
