import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int rec[] = new int[2000];
			int end_p[] = new int[2000];
			rec[0] = 0;
			rec[1] = 0;
			int tmp = 1, tmp_start = 1;
			for (int num = 2; num < 1200; num++) {
				tmp ^= num;
				if (tmp == 0) {
					end_p[num] = num; // tmp_start;
					rec[num] = num - tmp_start + 1 + rec[num - 1];
					tmp_start = num + 1;
				}
				else {
					rec[num] = rec[num - 1];
					end_p[num] = end_p[num - 1];
				}
			}
			int t = sc.nextInt();
			while (t > 0) {
				int m = sc.nextInt();
				if (m == 1) {
					System.out.println("1");
					System.out.println("1");
				}
				else {
					// from 1 to m, use only once.
					// find all the patterns that = 0;
					if (end_p[m] == m) {
						System.out.println(rec[m]);
						for (int i = 1; i < end_p[m]; i++) {
							System.out.format("%d ", i);
						}
						System.out.format("%d\n", m);
					}
					else {
						System.out.println(rec[m] + 1);
						for (int i = 1; i <= end_p[m]; i++) {
							System.out.format("%d ", i);
						}
						System.out.format("%d\n", m);
					}
				}
				t -= 1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
