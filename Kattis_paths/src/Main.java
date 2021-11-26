import java.io.File;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static int N, M, K, i, j, k, ver_1, ver_2, total_count, tmp_root;
	public static int[] color;
	/*
	 * color: for each node, the color.
	 * color_existed: for each color, the count of existance;
	 */
	public static int[][] path_matrix;
	
	
	public static void recursive_path_traversial(int cur_node, int[] cur_color_existed)
	{
		// base case. Glad that those variables are all static.
		if (cur_color_existed[color[cur_node]] > 1 || cur_node == ver_1)
		{
			return;
		}
		/*
		 * 2 cases for return:
		 * 		-> no next node in path matrix
		 * 		-> a cycle formed.
		 * This thing will not have infinite loop.
		 * 
		 * -> modification: color-existed should be a variable copy by value, not static.
		 */
		for (int idx = 1; idx <= N; idx++)
		{
			int[] next_color_existed = new int[cur_color_existed.length];
			for (k = 1; k < cur_color_existed.length; k++)
			{
				next_color_existed[k] = cur_color_existed[k];
			}
			
			if (path_matrix[cur_node][idx] == 1 
					&& next_color_existed[color[idx]] <= 0 
					&& cur_node != ver_1)
			{
				total_count++;
				// small bug : plz create a new instance of color_set for all possible paths
				// another small bug : plz DON't use static for j. You know why.
				next_color_existed[color[idx]]++; 		
				recursive_path_traversial(idx, next_color_existed);
			}
		}
		return;
	}
	
	public static void path_finding()
	{
		total_count = 0;
		// for each node, explore possible paths!
		for (int ver_1_tmp = 1; ver_1_tmp <= N; ver_1_tmp++)
		{
			for (int idx = 1; idx <= N; idx++)
			{
				if (path_matrix[ver_1_tmp][idx] == 1)
				{
					// start exploring!
					int ver_2_tmp = idx;
					int[] color_existed = new int[K + 1];
					color_existed[color[ver_2_tmp]] += 1;
					color_existed[color[ver_1_tmp]] += 1;
					if (color_existed[color[ver_1_tmp]] > 1) { break; } // oops
					else
					{
						total_count++;
						recursive_path_traversial(ver_2_tmp, color_existed);
					}
				}
			}
		}
	}
	
	public static void combinatorics_method()
	{
		/*
		 * 
		 * Time limit exceeded ar and also wrong answer. Try other ways la.
		 */
	}
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_paths\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();	// number of vertices.
			M = sc.nextInt();	// number of edges
			K = sc.nextInt();	// number of different colors	(between 1 and K)
			
			color = new int[N + 1];
			path_matrix = new int[N + 1][N + 1];
			
			// mistake: color array not matching to the node index.
			for (i = 1; i <= N; i++)
			{
				// one integer : color of node.
				color[i] = sc.nextInt();
			}
			for (i = 0; i < M; i++)
			{
				// two integers : the valid edges.
				ver_1 = sc.nextInt();
				ver_2 = sc.nextInt();
				path_matrix[ver_1][ver_2] = 1;
				path_matrix[ver_2][ver_1] = 1;
			}
			path_finding();
			System.out.println(total_count);
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
