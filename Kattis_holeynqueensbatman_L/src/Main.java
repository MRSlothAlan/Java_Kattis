import java.util.*;
import java.io.*;


public class Main {
	public static int N, M, total;		// M = location of a unique hole on the board
	public static Map<Integer, ArrayList<Integer>> emptyCells;
	
	public static void search(int cur_row, int[] grid) {
		if (cur_row == N) { total++; }
		else {
			for (int i = 0; i < N; i++) {
				boolean ok = true;
				if (!(emptyCells.containsKey(cur_row) && 
						emptyCells.get(cur_row).contains(i))) {	// required: check for holes
					grid[cur_row] = i;	// set a column index.		
					for (int j = 0; j < cur_row; j++) { 	// check previous rows
						if (grid[cur_row] == grid[j] ||
								cur_row - grid[cur_row] == j - grid[j] ||
								cur_row + grid[cur_row] == j + grid[j]) {
							
							
							ok = false;
							break;
						}
					}
					if (ok) {
						search(cur_row + 1, grid);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_holeynqueensbatman_L\\src\\sample.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				total = 0;
				N = sc.nextInt();
				M = sc.nextInt();
				if (N == 0 && M == 0)
					return;
				emptyCells = new HashMap<Integer, ArrayList<Integer>>();
				for (int i = 0; i < M; i++) {
					int tmp_r, tmp_c;
					tmp_r = sc.nextInt();
					tmp_c = sc.nextInt();
					if (!emptyCells.containsKey(tmp_r)) {
						emptyCells.put(tmp_r, new ArrayList<Integer>());
					}
					emptyCells.get(tmp_r).add(tmp_c);
				}
				int[] grid = new int[N];
				search(0, grid);
				System.out.println(total);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
