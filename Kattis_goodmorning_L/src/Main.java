import java.util.*;
import java.io.*;

/*
 * move downwards or to the right.
 * cannot go back left / move up, can press same key again.
 */
public class Main {
	public static int[][] grid = {{1,2,3},
								  {4,5,6},
								  {7,8,9},	
								  {-1,0,-1}};
	public static int[] rowMax = {3, 6, 9, 0};
	public static char[] in_seq;
	
	public static int min_diff = -1;
	public static int next_x, next_y;
	
	
	public static int[] xPos = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
	public static int[] yPos = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2};
	
	public static void Search(int in_x, int in_y, int in_val) {
		min_diff = -1;
		if (in_y == 3) { next_x = 1; next_y = 3; }
		else if (Math.abs(grid[in_x][in_y] - in_val) == 0) { next_x = in_x; next_y = in_y; }
		else {
			for (int ty = in_y; ty < 4; ty++) {
				for (int tx = in_x; tx < 3; tx++) {
					if (grid[ty][tx] != -1) {
						if (min_diff == -1 || Math.abs(in_val - grid[ty][tx]) < min_diff) {
							next_x = tx;
							next_y = ty;
							min_diff = Math.abs(in_val - grid[ty][tx]);
						}
					}
				}
			}
		}
	}
	public static boolean[] valid = new boolean[210];

	
	public static void setValid() {
		valid = new boolean[201];
		// thinking: cannot go back upward && left
		// that means, if next int pos < cur x y, not valid.
		for (int num = 0; num <= 200; num++) {
			String n_str = String.valueOf(num);
			boolean isValid = true;
			for (int i = 0; i < n_str.length() - 1; i++) {
				if (xPos[n_str.charAt(i) - '0'] > xPos[n_str.charAt(i + 1) - '0'] ||
						yPos[n_str.charAt(i) - '0'] > yPos[n_str.charAt(i + 1) - '0']) {
					valid[num] = false;
					isValid = false;
					break;
				}
			}
			if (isValid) {
				valid[num] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			// wrong case: 192.
			// should be 189, not 199.
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_goodmorning_L\\src\\sample.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			setValid();
			while (T > 0) {
				int num = sc.nextInt();
				if (valid[num]) {
					System.out.println(num);
				}
				else {
					int left = num, right = num;
					while (!valid[left] && left > 0) left--;
					while (!valid[right] && right <= 200) right++;
					if (right - num > num - left) {
						System.out.println(left);
					}
					else {
						System.out.println(right);
					}
				}
				T--;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * 					int same = tmp;
					// same numbers
					while (same <= 200) {
						valid[same] = true;
						same = same * 10 + same;
					}
					// two digits
					if (tx + 1 < 3 && grid[ty][tx + 1] != -1) {
						valid[tmp * 10 + grid[ty][tx + 1]] = true;
					}
					if (ty + 1 < 4 && grid[ty + 1][tx] != -1) {
						valid[tmp * 10 + grid[ty + 1][tx]] = true;
					}
 */
// old code
/*
 * 				int x, y;
				x = 0;	// 0123
				y = 0;	// 012
				// 1 <= k <= 200
				in_seq = sc.next().toCharArray();
 
int intVal = (int)in_seq[0] - 48;
while (intVal > rowMax[y]) {y++;}
while (intVal != grid[y][x]) {x++;}
int res = intVal;

for (int i = 1; i < in_seq.length; i++) {
	intVal = (int)in_seq[i] - 48;
	// find next_x, next_y
	Search(x, y, intVal);
	res = res * 10 + grid[next_y][next_x];
	// update x, y to next_x, next_y
	x = next_x;
	y = next_y;
}
System.out.println(res);
*/