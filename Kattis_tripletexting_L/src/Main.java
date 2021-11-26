import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in_str = sc.next();
		int pat = in_str.length() / 3;
		// 0 1 2 3 4, 5 6 7 8 9, 10 11 12 13 14
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < 3; i++) {
			String tmp = in_str.substring(pat * i, pat * i + pat);
			// System.out.println(tmp);
			if (!m.containsKey(tmp)) {
				m.put(tmp, 1);
			}
			else {
				int v = m.get(tmp) + 1;
				m.put(tmp, v);
			}
		}
		int max = 0;
		String res = "";
		for (String key : m.keySet()) {
			if (m.get(key) > max) {
				max = m.get(key);
				res = key;
			}
		}
		System.out.println(res);
		/*
		char start = in_str.charAt(0);
		String res = "" + start;
		for (int i = 1; i < in_str.length() && in_str.charAt(i) != start; i++) {
			res += in_str.charAt(i);
		}
		System.out.println(res);
		*/
	}
}
