import java.io.*;
import java.util.*;

/*
test case:

102
RATE
TEAR
ETAEAA

*/

public class Main {
	public static int x;
	public static Map<Character, Integer> S_pos, P_pos;	// I believe that the positions are distinct.
	
	/*
	 * My own logic:
	 * 		try out all possible ways to fit the form x ^ y = z
	 * 		as for idx = d, just put the value into M.
	 */
	/*
	public static void recursive_generate(int idx, int d, int n, 
											char[] M, char[] P, char[] C, char[] S) {
		int tmpIdx = idx + 1;
		if (idx >= n) {
			for (int i = 0; i < C.length; i++) {
				System.out.print(M[i]);
			}
			System.out.println();
			return;
		}
		else if (idx == d) {	// in this case, idx + 1 term not generated at all for recursion... plz add that
			char tmp_char = P[S_pos.get(C[d])];
			if (M[d] != 0 && M[d] != tmp_char) {	// can check empty.
				return;
			}
			else if (M[d] == 0){	// initial value : \u0000?
				M[d] = tmp_char;
			}
			// else if (M[d] != 0 && M[d] == tmp_char) {
			// }
			int sp = S_pos.get(C[tmpIdx]);
			int m_0 = idx;
			int m_1 = (idx + 1) % n;
			
			for (int f = 0; f < P.length; f++) {
				for (int s = 0; s < S.length; s++) {
					if ((f ^ s) == sp && M[m_0] == P[f]) {
						char tmp = M[m_1];
						M[m_1] = S[s];
						recursive_generate(tmpIdx, d, n, M, P, C, S);
						S[s] = tmp;
					}
				}
			}
		}
		else {
			int sp = S_pos.get(C[idx]);
			int m_0 = idx;
			int m_1 = (idx + 1) % n;
			
			if (idx == 0) {	// cannot check previous, just generate and see.
				for (int f = 0; f < P.length; f++) {
					for (int s = 0; s < S.length; s++) {
						if ((f ^ s) == sp) {
							char tmp_0 = M[m_0];
							char tmp_1 = M[m_1];
							M[m_0] = P[f];
							M[m_1] = S[s];
							recursive_generate(tmpIdx, d, n, M, P, C, S);
							M[m_0] = tmp_0;
							M[m_1] = tmp_1;
						}
					}
				}
			}
			else if (idx == n - 1){
				// this will generate M[last] and M[0];
				for (int f = 0; f < P.length; f++) {
					for (int s = 0; s < S.length; s++) {
						if ((f ^ s) == sp && M[0] == S[s] && M[n - 1] == P[f]) {
							// M[m_0] = P[f];
							// M[m_1] = S[s];
							recursive_generate(tmpIdx, d, n, M, P, C, S);
						}
					}
				}
			}
			else {
				for (int f = 0; f < P.length; f++) {
					for (int s = 0; s < S.length; s++) {
						if ((f ^ s) == sp && M[m_0] == P[f]) {
							// M[m_0] = P[f];
							char tmp = M[m_1];
							M[m_1] = S[s];
							recursive_generate(tmpIdx, d, n, M, P, C, S);
							M[m_1] = tmp;
						}
					}
				}
			}
		}
	}
	*/
	
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_permcode_L\\src\\sample.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				x = sc.nextInt();
				if (x == 0)
					return;
				char[] S = sc.next().toCharArray();
				S_pos = new HashMap<Character, Integer>();
				for (int i = 0; i < S.length; i++) {
					S_pos.put(S[i], i);
				}
				char[] P = sc.next().toCharArray();
				P_pos = new HashMap<Character, Integer>();
				for (int i = 0; i < P.length; i++) {
					P_pos.put(P[i], i);
				}
				char[] C = sc.next().toCharArray();
				char[] M = new char[C.length];
				
				// missing M: plain text message.
				int n = C.length;
				int d = (int) (Math.pow(n, 1.5) + x) % n;
				
				M[d] = P[S_pos.get(C[d])];
				// start at j = d - 1?
				// BECAUSE YOU FUCKING KNOW THE VALUE OF d, WHICH IS j + 1 in this case
				// M[j] = C[j], such that j is the same I mean.
				for (int k = 1; k < n; k++) {
					int j = (d - k + n) % n;
					M[j] = P[(S_pos.get(C[j]) ^ S_pos.get(M[(j + 1) % n]))];
				}
				for (int i = 0; i < M.length; i++) {
					System.out.print(M[i]);
				}
				System.out.println();
				// What the fuck are you doing? recursion? generate all xor?
				// you have M[d] as the starting point !!!
				// you will NEVER be successful as a businessman.
				
				// recursive_generate(0, d, n, M, P, C, S);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
