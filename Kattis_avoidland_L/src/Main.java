import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)
	{
		try {
			// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_avoidland\\src\\2.in");
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_avoidland_L\\src\\1.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();	// the size of board, and n pawn
			int[] row_occp = new int[n + 1];
			int[] col_occp = new int[n + 1];
			
			// please make your code O(N)
			for (int i = 0; i < n; i++) {
				// move the pawn, avoid each other.
				// cannot be a row / column > 1 pawn, pawn can move along the sides, given cell unoccupied
				int init_r = sc.nextInt();
				int init_c = sc.nextInt();
				row_occp[init_r] += 1;
				col_occp[init_c] += 1;
			}
			
			// MINIMUM number of steps ar.
			// bipartite matching? ???http://pages.cs.wisc.edu/~shuchi/courses/787-F09/scribe-notes/lec5.pdf
			// greedy?? find the nearest. (some weird case?)
			int total = 0;
			int ith_r = 0;
			int jth_c = 0;
			
			for (int i = 1; i <= n; i++) {
				for (int r = 0; r < row_occp[i]; r++) {
					total += Math.abs(i - 1 - ith_r);	// move the ith pawn at row to a location
					ith_r++;	// that pawn has moved.
				}
				for (int c = 0; c < col_occp[i]; c++) {
					total += Math.abs(i - 1 - jth_c);
					jth_c++;
				}
			}
			System.out.println(total);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}