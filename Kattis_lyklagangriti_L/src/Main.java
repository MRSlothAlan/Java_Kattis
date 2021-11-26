import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		try {
			/*
			File file = new File("C:\\Users\\tingk\\Desktop\\"
					+ "kattis\\Kattis_practices_repo\\"
					+ "eclipse_workspace_coding\\Kattis_lyklagangriti_L\\"
					+ "src\\02.in");
			Scanner sc = new Scanner(file);
			*/
			// think of a way to optimize it?
			Scanner sc = new Scanner(System.in);
			String in_str = sc.next();
			// L : left arrow, R = right arrow, B = backspace
			// no L, B appears before 1st word
			// no R appears after the last character.
			// List<Character> resL = new ArrayList<Character>();
			
			Deque<Character> resLeft = new ArrayDeque<Character>();
			Deque<Character> resRight = new ArrayDeque<Character>();
			/*
			 * Last time: use a sum variable to check whether all variables are checked
			 * this time: use two queues to track left and right neighbors.
			 * 
			 */
			for (char c : in_str.toCharArray()) {
				if(c == 'R') {	// arna, r --> arnar
					char top = resRight.pollFirst();
					resLeft.addLast(top);
				}
				else if (c == 'L') {
					char last = resLeft.pollLast();
					resRight.addFirst(last);
				}
				else if (c == 'B') {
					resLeft.pollLast();
				}
				else {
					resLeft.addLast(c);
				}
			}
			while (!resLeft.isEmpty()) {
				System.out.print(resLeft.pollFirst());
			}
			while (!resRight.isEmpty()) {
				System.out.print(resRight.pollFirst());
			}
			/*
			// String res_ = "";
			int idx = 0;
			// String nextPart, subStr;
			int cur_len = 0;
			for (char c : in_str.toCharArray()) {
				switch(c) {
				case('L'):
					if (idx > 0)
						idx--;
					break;
				case('R'):
					// System.out.printf("R => %d\n", idx);
					if (idx < cur_len)
						idx++;
					break;
				case('B'):
					resL.remove(idx - 1);
					idx--;
					cur_len--;
					
					subStr = res_.substring(0, idx - 1);
					nextPart = res_.substring(idx);
					idx--;
					res_ = subStr + nextPart; 
					break;
				default:
					
					resL.add(idx, c);
					cur_len++;
					idx++;
					break;
					
					if (idx == 0) {
						res_ = c + res_;
						idx++;
					}
					else if (idx > res_.length() - 1) {
						res_ += c;
						idx++;
					}
					else {
						subStr = res_.substring(0, idx);
						nextPart = res_.substring(idx);
						res_ = subStr + c + nextPart;
						idx++;
					}
					break;
				}
			}
			*/
			// System.out.println(res_);
			/*
			while(!resL.isEmpty()) {
				System.out.print(resL.get(0));
				resL.remove(0);
			}
			*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
