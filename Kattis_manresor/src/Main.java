import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)
	{
		try
		{
			File file = new File("C:\\Users\\tingk\\Desktop\\"
					+ "kattis\\Kattis_practices_repo\\"
					+ "eclipse_workspace_coding\\Kattis_manresor\\src\\1.in");
			Scanner sc = new Scanner(file);
			int N, M, K;
			N = sc.nextInt();	// days which Luna visits Solomon
			M = sc.nextInt();	// number of types of tickets
			K = sc.nextInt();	// number of days Luna travels due to work
			for (int n = 0; n < N; n++) {
				int day_visit;
				day_visit = sc.nextInt();
			}
			for (int m = 0; m < M; m++) {
				int valid_time;
				valid_time = sc.nextInt();
			}
			for (int m = 0; m < M; m++) {
				int ticket_price;
				ticket_price = sc.nextInt();
			}
			for (int k = 0; k < K; k++) {
				int day_for_work;	// tickets half the price
				day_for_work = sc.nextInt();
			}
			// She does not need any kind of ticket when she goes on a work trip.
			
		} catch (Exception e)
		{
			
		}
	}
}
