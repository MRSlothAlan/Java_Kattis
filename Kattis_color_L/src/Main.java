import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		try {
			/*
			File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\"
					+ "eclipse_workspace_coding\\Kattis_color_L\\src\\sample01.in");
			Scanner sc = new Scanner(file);
			*/
			Scanner sc = new Scanner(System.in);
			/*
			 * A color, 0 ... 10^9
			 * wash any socks with a maximum color diff of ?
			 */
			long S, C, K;
			S = sc.nextLong(); 	// number of socks
			C = sc.nextLong();	// capacity of a laundry machine
			K = sc.nextLong();	// max. color difference
			long[] D = new long[(int)S];
			
			for (int i = 0; i < S; i++) {
				D[i] = sc.nextLong();
			}
			// number of machines needed.
			Arrays.sort(D);
			int idx = 0;
			int machine_count = 0;
			
			while (idx < S) {	// just put into the same machine
				int capacity = 1;	// UPDATE: initialize this as 1.
				long starting = D[idx];
				idx++;
				while(idx < S && 
						D[idx] - starting <= K && 
						capacity < C) {
					idx++;
					capacity++;
				}
				machine_count++;
			}
			System.out.println(machine_count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
