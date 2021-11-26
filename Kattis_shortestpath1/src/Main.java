import java.util.*;
import java.io.*;

public class Main {

	public static boolean[] checked;

	public static boolean allChecked() {
		for (int i = 0; i < checked.length; i++) {
			if (checked[i] == false)
				return false;
		}
		return true;
	}
	/*
	 * Problem :
	 * 
	 * 		HOW TO SPEED UP THE ALGORITHM? 
	 */

	public static void main(String[] args) {
		try {
			// File file = new File(
			//		"C:\\Users\\tingk\\Desktop\\kattis\\" + "Kattis_practices_repo\\eclipse_workspace_coding\\"
			//				+ "Kattis_shortestpath1\\src\\shortestpath1.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				int n, m, q, s;
				n = sc.nextInt(); // number of node, [0 ... n - 1]
				m = sc.nextInt(); // number of edges
				q = sc.nextInt(); // number of queries
				s = sc.nextInt(); // index of starting node

				int[][] in_graph = new int[n][n];
				// int[][] in_weight = new int[n][n];
				int u, v, w;
				for (int i = 0; i < m; i++) {
					u = sc.nextInt();
					v = sc.nextInt();
					w = sc.nextInt();
					in_graph[u][v] = w;	// not 1
					// in_weight[u][v] = w;
				}
				for (int i = 0; i < q; i++) {
					int in_end_node;
					in_end_node = sc.nextInt();
					// find distance from s to in_end_node
					int[] cur_weight = new int[n];
					checked = new boolean[n];

					for (int j = 0; j < n; j++) { // initialize weights
						if (j == s)
							cur_weight[j] = 0;
						else
							cur_weight[j] = 1001;
					}

					while (!allChecked()) {
						// pick the node with minimum weight
						int idx_node_picked = -1;
						int cur_min = 1010;
						for (int k = 0; k < n; k++) {
							if (cur_weight[k] < cur_min && !checked[k]) {
								cur_min = cur_weight[k];
								idx_node_picked = k;
							}
						}
						checked[idx_node_picked] = true;
						// check the outgoing edges.
						for (int l = 0; l < n; l++) {
							if (in_graph[idx_node_picked][l] > 0) {
								cur_weight[l] = Math.min(cur_weight[idx_node_picked] + in_graph[idx_node_picked][l],
										cur_weight[l]);
							}
						}
					}
					if (cur_weight[in_end_node] == 1001)
						System.out.println("Impossible");
					else
						System.out.println(cur_weight[in_end_node]);
				}
				System.out.println();
			}
		} catch (Exception e) {

		}

	}
}
