import java.util.*;
import java.io.*;


public class Main {
	public static String lookup = " abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_progressivescramble_L\\src\\01.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();	// test cases 
			while (n > 0) {
				String command = sc.next();
				String line = sc.nextLine().substring(1);
				if (command.equals("e")) {
					System.out.print(line.charAt(0));
					int prev = lookup.indexOf(line.charAt(0));
					int next = prev;
					for (int i = 1; i < line.length(); i++) {
						next += lookup.indexOf(line.charAt(i));
						System.out.print(lookup.charAt(next % 27));
					}
					System.out.println();
				}
				else if (command.equals("d")) {
					System.out.print(line.charAt(0));
					int prev = lookup.indexOf(line.charAt(0));
					for (int i = 1; i < line.length(); i++) {
						int cur = lookup.indexOf(line.charAt(i));
						int ori = 0;
						for (; ori <= lookup.length(); ori++) {
							if (cur == (ori + prev) % 27) {
								break;
							}
						}
						prev = ori + prev;
						System.out.print(lookup.charAt(ori));
					}
					System.out.println();
				}
				// System.out.printf("%s || %s\n", command, line);
				n--;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
