import java.io.File;
import java.util.Scanner;
import java.util.*;

/*
 * Awkwardness level = min(no. of seats, separating ANY 2 ppl, same lang.)
 * if NO 2 ppl, same lang, awkwardness level = n.
 *  
 */
public class Main {
	public static int n;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_awkwardparty\\src\\1.in");
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_awkwardparty\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt(); // number of guests
			long[] language_spoken = new long[n];
			Map<Long, Long> separation_record = new HashMap<Long, Long>();
			long min_diff = n;
			long tmp_diff = 0;
			boolean duplicated = false;
			// array, idx = language, value = location within table.
			for (int i = 0; i < n; i++)
			{
				language_spoken[i] = sc.nextLong();
				if (! separation_record.containsKey(language_spoken[i])) {
					separation_record.put(language_spoken[i], (long) i);
				}
				else {
					duplicated = true;
					tmp_diff = (long) i - separation_record.get(language_spoken[i]);
					if (tmp_diff < min_diff)
						min_diff = tmp_diff;
					separation_record.put(language_spoken[i], (long) i);
				}
			}
			if (duplicated)
				System.out.println(min_diff);
			else
				System.out.println(n);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
