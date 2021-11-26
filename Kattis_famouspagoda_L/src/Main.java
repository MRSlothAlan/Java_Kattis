import java.util.*;
import java.io.*;

public class Main {
	public static int[] staircase;
	public static int k, G;
	public static ArrayList<Integer> costs;
	// let's try a dp solution anyway?
	// my recursive solution somehow doesn't pass the test cases.
	// but the logic is the same.

	public static int cal_min(int low_idx, int up_idx) // well, low_idx >= 1
	{
		int v = 0;
		 int mid = up_idx - (up_idx - low_idx) / 2; 
		 if ((up_idx - low_idx + 1) % 2 ==0) { 
			 v = (staircase[mid] + staircase[mid- 1]) / 2; 
			 } 
		 else { 
			 v = staircase[mid]; 
		}
		
		/*
		for (int i = low_idx; i <= up_idx; i++) {
			v += staircase[i];
		}
		v /= (up_idx - low_idx + 1);
		*/
		// System.out.println(v);
		int sum = 0;
		for (int i = low_idx; i <= up_idx; i++) {
			sum += Math.pow(Math.abs(staircase[i] - v), k);
		}
		return sum;
	}

	public static void cal_segments(int total_cost, int up_idx, int low_idx, int g_no) {
		// base case:
		if (g_no >= G - 1) { // the last worker? takes up all the remaining staircases!!
			total_cost += cal_min(low_idx, up_idx);
			costs.add(total_cost);
			return;
		} else {
			// e.g. for 3 workers, last idx up to N - 2 element (other two workers need to
			// work)
			/*
			 * e.g. 1 2 3 4 5, 3 workers tmp_idx up to 3 ar (5 - (3 - 0) + 1)
			 */
			int next_g_no = g_no + 1;
			for (int tmp_idx = low_idx; tmp_idx <= up_idx - (G - g_no) + 1; tmp_idx++) {
				total_cost += cal_min(low_idx, tmp_idx);
				int next_low_idx = tmp_idx + 1;
				cal_segments(total_cost, up_idx, next_low_idx, next_g_no);
			}
			return;
		}
	}

	public static void main(String[] args) {
		try {
			
			// https://open.kattis.com/problems/famouspagoda
			// File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_famouspagoda\\src\\3.in");
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_famouspagoda_L\\src\\3.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt(); // number of staircases
			G = sc.nextInt(); // number of workers
			k = sc.nextInt(); // either 1 or 2, thank god
			// to optimize ? find that v, which is an integer
			staircase = new int[N + 1];
			costs = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
				staircase[i] = sc.nextInt(); // already sorted
			}
			
			int res_cost = -1;
			// a recursive way to find minimized segments.
			cal_segments(0, N, 1, 0);
			res_cost = costs.get(0);
			for (int cost : costs) {
				if (res_cost > cost) {
					res_cost = cost;
				}
			}
			System.out.println(res_cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// Notes:

// when g_no is still < G, do it! init. g_no as 0 to avoid confusion
// init. min_idx as 1, upper idx = N

/*
 * test case 2:
 * 	5 1 2
	1 2 3 4 5
 */

/*
 * Design: e.g. [1, 2, 3, 4, 5], three workers. possible arrangements: [1], [2],
 * [3, 4, 5] [1, 2], [3], [4, 5] [1, 2, 3], [4], [5] [1], [2, 3], [4, 5] [1],
 * [2, 3, 4], [5]
 */
/*
 * int min_idx = 1;
 * 
 * for (int g = G - 1; g > 0; g--) { // last worker will need to work on all the
 * remaining staircases. int tmp_sum = -1; int tmp_idx = min_idx; for (int i =
 * min_idx + 1; i <= N - g; i++) { int tmp = cal_min(min_idx, i); // need to set
 * it as at least 2 elements for workers? if (tmp_sum == -1 || tmp < tmp_sum) {
 * tmp_sum = tmp; tmp_idx = i; } } res_cost += tmp_sum; min_idx = tmp_idx + 1;
 * // next one is the starting point. } res_cost += cal_min(min_idx, N);
 */

/*
 * Staircase N pos : a1 ... aN, ai = height of pos G builders, build in parallel
 * N pos --> div to G seg.
 * 
 * segment min solved odd : v = mid even : v = avg(mid + 1, mid)
 * 
 * segment division problem? O(N^2) for each loop, ... pick the part with min
 * val update the min val, next loop, start from min. well, this looks like
 * bull-shit but that's the only algo that I could think of that certainly
 * works.
 */
// each segment is a set of consecutive positions.
// at most 2000 workers, definitely fail for brute force.
// thank god, CONSECUTIVE segments, makes life MUCH easier.
/*
 * Hints: divide and conquer, dp optimization? Using the current looping
 * structure, record down the cost. As for the minimization method... I think it
 * is correct. Or set the mean instead? Impossible to do recursion here? Some
 * good guys : https://github.com/tossy310/procon_libs.git a set of general
 * competitive programming algorithms.
 */
/*
 * how about the case: 1 1000 2000 3000 1, 1000 2000 3000? 0, 2000 1 1000, 2000
 * 3000? 499 + 500, 500 + 500 --> wow, total cost < first case = I am right ????
 * wrong answer, where?
 */