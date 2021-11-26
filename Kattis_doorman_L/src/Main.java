import java.util.*;
import java.io.*;

/*
 * people waiting : in queue.
 * let second person cut the line and slip into the club?
 * example case:
 * 2 (1 = ok?)
 * W2
 * M4
 * WMMMMWWMMMWWMW
 * 1111*1^1(*)
 * * : let W in front,
 * ^ : now, M = 4, W = 3.
 * ( : M = 6
 * ) : M = 7, W = 4, diff > 2 
 * let second person cut the line?
 */

public class Main {
	public static void main(String[] args) {
		try {
			/*
			File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\"
					+ "Kattis_practices_repo\\eclipse_workspace_coding\\"
					+ "Kattis_doorman_L\\src\\doorman.2.in");
					*/
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int X = sc.nextInt();	// largest absolute difference between the number of women and number of men
			char[] queue = sc.next().toCharArray();
			int m_count = 0, w_count = 0, tot_count = 0;
			for (int i = 0; i < queue.length; i++) {
				// Update: I should have checked the count earlier.
				int tmp_m_count = queue[i] == 'M' ? m_count + 1 : m_count;
				int tmp_w_count = queue[i] == 'W' ? w_count + 1 : w_count;
				
				if (Math.abs(tmp_m_count - tmp_w_count) > X) {
					// check whether a swap is possible.
					if (i < queue.length - 1 && queue[i] != queue[i + 1]) {
						char tmp = queue[i];
						queue[i] = queue[i + 1];
						queue[i + 1] = tmp;
					}
					else {
						System.out.println(tot_count);
						return;
					}
				}
				// after checking the swapping, count people.
				tot_count++;
				switch(queue[i]) {
				case('M'):
					m_count++;
					break;
				case('W'):
					w_count++;
					break;
				}
			}
			System.out.println(tot_count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
