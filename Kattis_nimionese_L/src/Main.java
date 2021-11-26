import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		String firstLetter = "bcdgknpt";
		char[] last = {'a', 'o', 'u'};
		try {
			/*
			File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\"
					+ "Kattis_practices_repo\\"
					+ "eclipse_workspace_coding\\"
					+ "Kattis_nimionese_L\\src\\2.in");
					*/
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			String in_str = sc.nextLine();
			String res = "";
			for (String word : in_str.trim().split("\\s+")) {
				char[] tmpW = word.toCharArray();
				char tmpF = tmpW[0];
				if (firstLetter.indexOf(tmpW[0]) < 0) {
					char tmpResF = 'b';
					int minDiff = 1000;
					tmpF = Character.toLowerCase(tmpF);
					for (char c : firstLetter.toCharArray()) {	// just 8 characters
						int tmpDiff = Math.abs((int)c - (int)tmpF);
						if (minDiff > tmpDiff) {
							minDiff = tmpDiff;
							tmpResF = c;
						}
					}
					tmpF = tmpResF;
					if (Character.isUpperCase(tmpW[0])) {
						tmpW[0] = Character.toUpperCase(tmpResF);
					}
					else {
						tmpW[0] = tmpResF;
					}
				}
				String tmp_res = "";
				for (char r : tmpW) tmp_res += r;
				word = tmp_res;
				String[] wordD = word.split("-");
				
				for (int i = 1; i < wordD.length; i++) {
					// ANY subsequent char
					char[] tmpD = wordD[i].toCharArray();
					for (int idx = 0; idx < tmpD.length; idx++) {
						for (char c : firstLetter.toCharArray()) {
							if (Character.toLowerCase(tmpD[idx]) == c) {
								char t = tmpD[idx];
								tmpD[idx] = Character.isUpperCase(t)? Character.toUpperCase(tmpF) : tmpF;
								break;
							}
						}
					}
					tmp_res = "";
					for (char r : tmpD) tmp_res += r;
					wordD[i] = tmp_res;
				}
				tmp_res = "";
				for (String r : wordD) tmp_res += r;
				word = tmp_res;
				// last?
				for (char c : firstLetter.toCharArray()) {
					char last_char = word.charAt(word.length() - 1);
					if (Character.toLowerCase(last_char) == c) {
						int min = 1000;
						char resLastChar = 'a';
						for (char l : last) {
							int tmpMin = Math.abs(l - last_char);
							if (tmpMin < min) {
								min = tmpMin;
								resLastChar = l;
							}
						}
						word += resLastChar + "h";
						break;
					}
				}
				res += word + " ";
			}
			System.out.println(res);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
