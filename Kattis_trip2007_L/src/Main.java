import java.util.*;
import java.io.*;


public class Main {
	public static int[] bag;
	// sol_top;
	// public static int[][] sol;
			
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_trip2007_L\\src\\trip2007.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			/*
			 * Sample case:
			 * 		6
			 * 		1 1 2 2 2 3
			 * 		0
			 */
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if (n == 0)
					return;
				bag = new int[n];
				// sol_top = new int[n];
				// sol = new int[n][n];
				for (int i = 0; i < n; i++) {
					bag[i] = sc.nextInt();
				}
				Arrays.sort(bag);
				/*
				 * This approach : e.g. 1 1 2 2 2 3
				 * push both 1s to two list first,
				 * curK will store the idx, distribute accordingly
				 * 		=> THIS, is SMART, businessman like logic.
				 * 		save resources, time and effort, SAME result = SUCCESS
				 */
				List<List<Integer>> sol = new ArrayList<>();
	            int k = 0;
	            int cur = Integer.MIN_VALUE;
	            int curK = 0;
	            sol.add(new ArrayList<>());
	            for (int i = 0; i < n; i++) {
	                int x = bag[i];
	                if (x > cur) {
	                    cur = x;
	                    curK = -1;
	                }
	                ++curK;
	                if (curK > k) {
	                    k++;
	                    sol.add(new ArrayList<>());
	                }
	                sol.get(curK).add(x);
	            }
				System.out.println(sol.size());
				for (int i = 0; i < sol.size(); i++) {
					String tmp_res = "";
					for (int val : sol.get(i)) {
						tmp_res += String.valueOf(val) + " ";
					}
					System.out.println(tmp_res.trim());
				}
				
				// greedy : pick the largest, than pick gradually.
				
	            /*
	            int tot_pieces_idx = 0;
				int count_picked = 0;
				
				while(count_picked < n) {
					int last_picked = -1;
					for (int i = n - 1; i >= 0; i--) {
						if (bag[i] != -1 && (last_picked == -1 || last_picked > bag[i])) {
							count_picked++;
							sol[tot_pieces_idx][sol_top[tot_pieces_idx]] = bag[i];
							sol_top[tot_pieces_idx]++;	// point to next empty slot.
							last_picked = bag[i];
							bag[i] = -1;
						}
					}
					tot_pieces_idx++;
				}
				// the top part is correct, it is the next part that need some changes.
				
				int tmp_p, tmp_other;
				
				for (int p_idx = 0; p_idx < tot_pieces_idx; p_idx++) {
					for (int others_idx = 0; 
							others_idx < tot_pieces_idx;
							others_idx++) {
						if (others_idx != p_idx && sol_top[p_idx] > sol_top[others_idx])
						{
							while (sol_top[p_idx] > sol_top[others_idx]) {
								tmp_p = sol[p_idx][sol_top[p_idx] - 1];
								tmp_other = sol[others_idx][sol_top[others_idx] - 1];
								
								if (tmp_p < tmp_other) {
									sol[others_idx][sol_top[others_idx]] = tmp_p; 
									sol_top[others_idx]++;
									sol[p_idx][sol_top[p_idx] - 1] = 0;
									sol_top[p_idx]--;
								}
								else {
									break;
								}
							}
						}
					}
				}
				
				*/
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
