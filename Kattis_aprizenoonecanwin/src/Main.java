import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * no one can win
 * 		subset of n items for sale
 * people buy exactly 2 of those items, cost is strictly more than X euros
 * 		prize
 * 
 * pick items such that no one can win?
 */


public class Main {
	public static int n, i, out_max;
	
	public static void main(String[] arg)
	{		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_aprizenoonecanwin\\src\\4.in");
		try {
			out_max = 0;
			long tmp_cur = 0;
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			long X = sc.nextLong();
			int[] products_prices = new int[n];
			
			for (i = 0; i < n; i++)
			{
				products_prices[i] = sc.nextInt();
			}
			// edge cases.
			if (n == 0)
			{
				System.out.println(0);
				return;
			}
			if (n == 1)
			{
				System.out.println(1);
				return;
			}
			Arrays.sort(products_prices);
			tmp_cur = products_prices[0];
			
			if (tmp_cur > X)
			{
				System.out.println(1);
				return;
			}
			out_max++;
			
			long prev = tmp_cur; 
			
			for (i = 1; i < n; i++)
			{
				tmp_cur = products_prices[i];
				if ((prev + tmp_cur) > X)
				{
					System.out.println(out_max);
					return;
				}
				else if ((prev + tmp_cur) <= X)		// can have duplicated values.
				{
					out_max++;
				}
				prev = tmp_cur;
			}
			System.out.println(out_max);
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
