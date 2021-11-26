import java.io.*;
import java.util.*;

/*
 * Test case:
 * 
 * 
	2
	5 5
	00000
	00100
	01001
	01101
	00101
	1 7
	0110010

Sample out:
	00101
	0110010
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();	// n people
			int m = sc.nextInt();	// m issues
			String opt = "";
			int[] M = new int[m];
			if (n == 1) {
				opt = sc.next();
				System.out.println(opt);
			}
			else {
				for (int i = 0; i < n; i++) {
					// each line: opinion on m issues;
					opt = sc.next();
					char[] arr = opt.toCharArray();
					for (int issue = 0; issue < m; issue++) {
						if (arr[issue] - '0' == 1) {
							M[issue]++;
						}
					}
				}
				int avg = n / 2;
				for (int issue = 0; issue < m; issue++) {
					if (M[issue] > avg) {
						System.out.print(1);
					}
					else {
						System.out.print(0);
					}
				}
				System.out.println();
			}
			t--;
		}
	}
}
