import java.util.*;
import java.io.*;


public class Main {
	/*
	 * Time limit exceeded anyway.
	 */
	public static void computeLPSArray(String in_pat, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;	// longest prefix suffix
		// the loop calculates lps[i] for i = 1 to M - 1
		while (i < M) {
			if (in_pat.charAt(i) == in_pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if (len != 0) {
					len = lps[len - 1];
				}
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	
	// or not opt...
	public static void KMP_opt(String in_pat, String in_str) {
		int M = in_pat.length();
		int N = in_str.length();
		// create lps[] that will hold the longest prefix suffix values
		int lps[] = new int[M];
		int j = 0;	// index for pat
		computeLPSArray(in_pat, M, lps);
		int i = 0;
		while (i < N) {
			if (in_pat.charAt(j) == in_str.charAt(i)) {
				j++; i++;
			}
			if (j == M) {
				System.out.printf("%d ", i - j);
				j = lps[j - 1];
			}
			else if (i < N && in_pat.charAt(j) != in_str.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else 
					i = i + 1;
			}
		}
	}
	
	public static void KMP(String in_pat, String in_str) {
		int idx_pat = 0,
			idx_str = 0;
		int pat_len = in_pat.length();
		String res = "";
		
		while (idx_str <= in_str.length()) {
			if (idx_pat == pat_len) {
				res += String.valueOf(idx_str - pat_len) + " ";
				idx_pat--;
			}
			else if (idx_str >= in_str.length())
				break;
			else if (in_pat.charAt(idx_pat) == 
				in_str.charAt(idx_str)) {
				idx_str++;
				idx_pat++;
			}
			else if (in_pat.charAt(idx_pat) !=
					in_str.charAt(idx_str)) {
				idx_pat--;
				// if idx_pat is now zero, do i++
				if (idx_pat <= 0) {
					idx_pat = 0;
					idx_str++;
				}
			}
		}
		System.out.println(res.trim());
	}
	
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_stringmatching_L\\src\\stringmatching.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			
			while (sc.hasNext()) {
				String pattern = sc.nextLine();
				String sentence = sc.nextLine();
				// spaces are included in the string for comparison
				// System.out.printf("%s || %s\n", pattern, sentence);
				// naive way. TLE
				// try to implement KMP for pattern searching.
				// KMP();
				KMP_opt(pattern, sentence);
				System.out.println();
				/*
				String res_str = "";
				for (int i = 0; i <= sentence.length() - pattern.length(); i++) {
					int j = 0;
					boolean flag = true;
					for (j = 0; j < pattern.length() && flag; j++) {
						if (sentence.charAt(i + j) != pattern.charAt(j)) {
							flag = false;
						}
					}
					if (j == pattern.length() && flag) {
						res_str += String.valueOf(i) + " ";
					}
				}
				System.out.println(res_str.trim());
				*/
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
