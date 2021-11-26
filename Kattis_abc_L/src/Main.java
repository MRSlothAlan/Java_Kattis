import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_abc_L\\src\\2.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int[] in_abc = new int[3];
			for (int i = 0; i < 3; i++) {
				in_abc[i] = sc.nextInt();
			}
			int A, B, C;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (i != j && j != k && k != i) {
							if (in_abc[i] > in_abc[j] &&
									in_abc[j] > in_abc[k]) {
								A = in_abc[k];
								B = in_abc[j];
								C = in_abc[i];
								char[] in_seq = sc.next().toCharArray();
								String res = "";
								for (char c : in_seq) {
									switch(c) {
									case('A'):
										res += String.valueOf(A) + " ";
										break;
									case('B'):
										res += String.valueOf(B) + " ";
										break;
									case('C'):
										res += String.valueOf(C) + " ";
										break;
									}
								}
								System.out.println(res.trim());
								return;
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
