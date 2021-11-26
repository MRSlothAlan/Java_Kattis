import java.util.*;
import java.io.*;


class point {
	public int r_pt, c_pt;
	public point(int in_r, int in_c) {
		this.r_pt = in_r;
		this.c_pt = in_c;
	}
}

public class Main {
	public static int[][] map;
	// public static boolean[][] checked;
	// public static boolean closed;
	public static int N, M;
	// public static ArrayList<Integer> r_checked, c_checked;
	
	// new way: find all the cells which are seas.
	
	// check touch recursively, problem?
	// unnecessary recursive layers that might overlap the checking
	// the counting method for edges might not be correct afterall.
	/*
	public static void check_closed(int r_cell, int c_cell) {
		// closed is first init. as true;
		// base conditions: not_closed?	
		if (!closed || checked[r_cell][c_cell] || map[r_cell][c_cell] == 1) {
			checked[r_cell][c_cell] = true;
			return;
		}
		else if (r_cell <= 0 || 
					c_cell <= 0 || 
					r_cell >= N - 1 || 
					c_cell >= M - 1) {	// base conditions: touched the borders.
			if (map[r_cell][c_cell] == 0) {
				closed = false;
			}
			checked[r_cell][c_cell] = true;
			return;
		}
		else {
			checked[r_cell][c_cell] = true; 
			r_checked.add(r_cell);
			c_checked.add(c_cell);
			if (closed) { check_closed(r_cell - 1, c_cell);	}
			if (closed) { check_closed(r_cell + 1, c_cell);	}
			if (closed) { check_closed(r_cell, c_cell - 1);	}
			if (closed) { check_closed(r_cell, c_cell + 1);	}
		}
	}
	*/
	// using the logic in the recursion that you have just built.
	public static boolean toCheck(int in_r, int in_c) {
		if (in_r < 0 || in_c < 0 || in_r >= N + 1 || in_c >= M + 1) {
			return false;
		}
		if (map[in_r][in_c] != 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		try {
			// File file = new File(
		 	//  	"C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_coast_L\\src\\coast-sample-1.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in); 
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N + 2][M + 2];
			// checked = new boolean[N][M];
			/*
			 * Trick from others: spare two rows and columns to store value s.
			 * top and bottom, left and right.
			 * useful for counting outside border as well.
			 * instead of checking four sides.
			 * just count the number of s(sea) cells.
			 * sss...sss
			 * s       s
			 * s       s
			 * .       s
			 * .	   s
			 * s.......s
			 * 
			 * concept: start from 0, 0 (MUST be s)
			 * just like pouring water in from top left corner,
			 * use a queue, store the next point to be checked.
			 */
			for (int i = 1; i < N + 1; i++) {
				String in_row = sc.next();
				int col_idx = 1;
				for (char cell : in_row.toCharArray()) {
					map[i][col_idx] = Integer.valueOf(cell) - 48;
					col_idx++;
				}
			}
			ArrayList<point> toCheck = new ArrayList<point>();
			toCheck.add(new point(0, 0));
			while(!toCheck.isEmpty()) {
				point cur_pt = toCheck.get(0);
				toCheck.remove(0);
				if (map[cur_pt.r_pt][cur_pt.c_pt] == 0) {	// water
					map[cur_pt.r_pt][cur_pt.c_pt] = 2;
					if (toCheck(cur_pt.r_pt + 1, cur_pt.c_pt)) {
						toCheck.add(new point(cur_pt.r_pt + 1, cur_pt.c_pt));
					}
					if (toCheck(cur_pt.r_pt - 1, cur_pt.c_pt)) {
						toCheck.add(new point(cur_pt.r_pt - 1, cur_pt.c_pt));
					}
					if (toCheck(cur_pt.r_pt, cur_pt.c_pt + 1)) {
						toCheck.add(new point(cur_pt.r_pt, cur_pt.c_pt + 1));
					}
					if (toCheck(cur_pt.r_pt, cur_pt.c_pt - 1)) {
						toCheck.add(new point(cur_pt.r_pt, cur_pt.c_pt - 1));
					}
				}
			}
			int count = 0;
			// now calculate the number of surrounding 2s of the 1s. (the sea of the surrounding land)
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (map[r][c] == 1) {
						if (map[r + 1][c] == 2) { count++; }
						if (map[r - 1][c] == 2) { count++; }
						if (map[r][c + 1] == 2) { count++; }
						if (map[r][c - 1] == 2) { count++; }
					}
				}
			}
			System.out.println(count);
			/*
			 * Problem of the code below:
			 * 		cannot check whether the entire space is enclosed.
			 * solution:
			 * 		NOPE(build a checked matrix)
			 * 		smarter recursion.
			 */
			/*
			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < M - 1; c++) {
					if (map[r][c] == 0 && !checked[r][c]) {
						r_checked = new ArrayList<Integer>();
						c_checked = new ArrayList<Integer>();
						closed = true;
						check_closed(r, c);
						if (!closed) {
							System.out.printf("row: %d, col: %d ==> Not closed\n", r, c);
						}
						else {
							for (int ck_idx = 0; ck_idx < r_checked.size(); ck_idx++) {
								map[r_checked.get(ck_idx)][c_checked.get(ck_idx)] = 1;
							}
						}
					}
				}
			}
			// flood fill? should not be hard.
			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < M - 1; c++) {
					if (map[r][c] == 0) {
						int l_, r_, u_, b_, idx;
						// check left.
						for (idx = c - 1; idx >= 0 && map[r][idx] != 1; idx--) {}
						if (idx < 0 && c > 0) 
							break;
						l_ = idx + 1;
						// check right.
						for (idx = c + 1; idx < M && map[r][idx] != 1; idx++) {}
						if (idx >= M && c < M - 1) 
							break;
						r_ = idx - 1;
						// check top.
						for (idx = r - 1; idx >= 0 && map[idx][c] != 1; idx--) {}
						if (idx < 0 && r > 0) 
							break;
						u_ = idx + 1;
						// check bottom.
						for (idx = r + 1; idx < N && map[idx][c] != 1; idx++) {}
						if (idx >= N && r < N - 1) 
							break;
						b_ = idx - 1;
						
						for (idx = u_; idx <= b_; idx++) {
							map[idx][c] = 1;
						}
						for (idx = l_; idx <= r_; idx++) {
							map[r][idx] = 1;
						}
					}
				}
			}
			int count = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						// left
						if (c == 0) {
							count++;
						} else if (map[r][c - 1] == 0) {
							count++;
						}
						// right
						if (c == M - 1) {
							count++;
						} else if (map[r][c + 1] == 0) {
							count++;
						}
						// top
						if (r == 0) {
							count++;
						} else if (map[r - 1][c] == 0) {
							count++;
						}
						// bottom
						if (r == N - 1) {
							count++;
						} else if (map[r + 1][c] == 0) {
							count++;
						}
					}
				}
			}
			System.out.println(count);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
