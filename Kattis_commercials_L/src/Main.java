import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_commercials_L\\src\\commercials.in");
			// sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int N, P;
			N = sc.nextInt();	// total number of commercial breaks in a day
			P = sc.nextInt();	// price of one commercial break
			int[] in_seq = new int[N];
			
			for (int i = 0; i < N; i++) {
				int students = sc.nextInt();
				in_seq[i] = students - P;
			}
			int cur_sum = 0, 
					cur_start = 0, 
					best_sum = 0,
					best_start = 0,
					best_end = 0;
			
			for (int i = 0; i < N; i++) {
				if (cur_sum <= 0) {
					cur_start = i;
					cur_sum = in_seq[i];
				}
				else {
					cur_sum += in_seq[i];
				}
				if (cur_sum > best_sum) {
					best_sum = cur_sum;
					best_start = cur_start;
					best_end = i + 1;
				}
			}
			System.out.println(best_sum);
			/*
			Stack<Integer> tmpStore = new Stack<Integer>();
			int res_sum = 0, tmp_sum = 0;
			for (int i = 0; i < N; i++) {
				int students = sc.nextInt();	// people listen to commercial breaks
				tmpStore.add(students - P);
				tmp_sum += tmpStore.peek();
				while (tmp_sum < 0) {
					tmp_sum -= tmpStore.pop();
				}
				res_sum = Math.max(tmp_sum, res_sum);
				// in_seq[i] = students - P;
			}
			System.out.println(res_sum);
			*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
