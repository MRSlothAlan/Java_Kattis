import java.util.*;
import java.io.*;

/*
 * 01101
 * 0 1, 1 1 => 2
 * 1132012000031
 * 0 2
 * 2 1
 * 1 2
 * 1320120
 * 
 * problem : efficient way to check whether requirements satisfied.
 */
/*
class rcount {
	int expectedQ, count;
	public rcount(int in_Q) {
		this.expectedQ = in_Q;
		this.count = 0;
	}
	public boolean isOverflow() {
		return this.expectedQ < this.count;
	}
	public void addCount() {
		this.count++;
	}
	public void minusCount() {
		this.count--;
	}
	public boolean isSatisfied() {
		return this.expectedQ == this.count;
	}
}
*/

// I don't need this class anymore.
/*
 * public static Map<Integer, rcount> count;
	public static boolean isAllSatisfied() {
		for (Integer key : count.keySet()) {
			if (!count.get(key).isSatisfied()) {
				return false;
			}
		}
		return true;
	}
	
	public static void addCount(int index) {
		if (count.containsKey(index)) {
			rcount tmp_count = count.get(index);
			tmp_count.addCount();
			count.put(index, tmp_count);
		}
	}
	
	public static void minusCount(int index) {
		if (count.containsKey(index)) {
			rcount tmp_count = count.get(index);
			tmp_count.minusCount();
			count.put(index, tmp_count);
		}
	}
	
	public static boolean checkOverflow(int index) {
		if (count.containsKey(index)) {
			return count.get(index).isOverflow();
		}
		return false;
	}
 */

public class Main {
	public static int[] countR, qty, checkR, currentR;
	/*
	public static boolean isAllSatisfied() {
		for (int toCheck : checkR) {
			if (countR[toCheck] != qty[toCheck]) {
				return false;
			}
		}
		return true;
	} */
	
	public static void main(String[] args) {
		try {
			/*
			File file = new File("C:\\Users\\tingk\\"
					+ "Desktop\\kattis\\Kattis_practices_repo\\"
					+ "eclipse_workspace_coding\\Kattis_martiandna_L\\"
					+ "src\\1.in");
			Scanner sc = new Scanner(file);
			*/
			Scanner sc = new Scanner(System.in);
			int N, K, R;
			N = sc.nextInt();	// total length of the martian DNA
			K = sc.nextInt();	// alphabet size
			R = sc.nextInt();	// number of nucleobases
			int[] D = new int[N];
			countR = new int[2000005];
			
			for (int i = 0; i < N; i++) {	// martian DNA string.
				D[i] = sc.nextInt();	// 0 <= D < K
				countR[D[i]]++;
			}
			// count = new HashMap<Integer, rcount>();
			qty = new int[2000005];
			checkR = new int[R];
			
			int num = 0;
			for (int i = 0; i < R; i++) {
				int B = sc.nextInt();	// nucleobase;
				int Q = sc.nextInt();	// minimum required quantity.
				// count.put(B, new rcount(Q));
				if (Q > countR[B]) {
					System.out.println("impossible");
					return;
				}
				qty[B] = Q;
				checkR[i] = B;
			}
			num = R;
			/*
			 * length of the shortest consecutive substring of the DNA?
			 * count from the start then reduce it?
			 */
			currentR = new int[2000005];
			int left = 0, right = 0;
			int minimum_length = Integer.MAX_VALUE;
			
			while (true) {
				if (num > 0) {	
					if (right == N)
						break;
					currentR[D[right]]++;
					if (currentR[D[right]] == qty[D[right]]) // this avoids sequential counting haha... a simple trick.
						num--;
					right++;
				}
				else {
					minimum_length = Math.min(right - left, minimum_length);
					if (currentR[D[left]] == qty[D[left]])
						num++;
					currentR[D[left]]--;
					left++;
				}
			}
			/*
			for (int i = 0; i < N; i++) {
				// addCount(D[i]);
				countR[i]++;
				if (isAllSatisfied()) {	// this involves sequencial search every time...
					minimum_length = i - left + 1 < minimum_length || minimum_length == -1 ? i - left + 1 : minimum_length;
					// move which pointer????
					if (countR[D[left]] == qty[D[left]] &&
							countR[D[i]] == qty[D[i]]) {
						countR[D[left]]--;
						left++;
					}
					else if () {
						
					}
				}
			}
			*/
			System.out.println(minimum_length);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
