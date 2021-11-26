import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_deathknight_L\\src\\1.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int count = 0;
			for (int i = 0; i < n; i++) {
				// C -> D
				char[] ability = sc.next().toCharArray();
				char prev = ability[0];
				boolean loss = false;
				for (int j = 1; j < ability.length; j++) {
					if (prev == 'C' && ability[j] == 'D') {
						loss = true;
						break;
					}
					prev = ability[j];
 				}
				if (!loss) {
					count++;
				}
			}
			System.out.println(count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
