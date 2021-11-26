/*
Yes, I am still here. I am PASSIONATE in this shit.
*/
import java.io.File;
import java.util.Scanner;

import java.lang.*;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static String in_str;
	public static int N, i, j, k_i, k_j, row_idx;
	public static int[][] dp_table;
	
	// pattern: 2 then 1. if not 0, step no = min(prev + 1, cur)
	public static void KnightMove()
	{
		
	}
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			dp_table = new int[N][N];
			row_idx = 0;
			while (N > 0)
			{
				in_str = sc.next();
				for (i=0; i<N; i++)
				{
					switch(in_str.charAt(i)) {
					case('#'):
						dp_table[row_idx][i] = -1;
						break;
					case('K'):
						k_i = row_idx;
						k_j = i;
						break;
					case('.'):
						dp_table[row_idx][i] = 0;
						break;
					}
				}
				N--;
				row_idx++;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

