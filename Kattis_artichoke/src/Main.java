import java.util.*;
import java.io.File;

/*
 * 		Max decline (NO escalation) in the stock price.
 * 			price(1), ... price(n)
 */

public class Main {
	
	public static int p, a, b, c, d, n;
	
	public static double price(int k)
	{
		return p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2);
	}
	
	public static void main(String[] args)
	{
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_artichoke\\src\\3.in");
		try
		{
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			p = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			n = sc.nextInt();
			double[] stock_prices = new double[n+1];
			for (int k = 1; k <= n; k++)
			{
				stock_prices[k] = price(k);
			}
			/*
			 * 	Linear scan?  
			 * 	e.g. 19 12 13 11 20 14
			 * 		(* -> 7 -> -1 -> 2 -> -9 -> 6)  
			 *  Pattern:
			 *  	every time sees a larger value --> use that.
			 *  	if positive -> cum. and check cur. decline as well.
			 */
			double cur_peak, out_max_decline, tmp_diff, tmp_diff_top;
			cur_peak  = out_max_decline = tmp_diff = tmp_diff_top = 0;
			for (int idx = 1; idx <= n - 1; idx++)
			{
				if (cur_peak < stock_prices[idx])
				{
					cur_peak = stock_prices[idx];
					// every time peak updated, the cur_decline_sum resets
				}
				tmp_diff = stock_prices[idx] - stock_prices[idx + 1];
				if (tmp_diff > 0)
				{
					// ** then, calculate the diff. between cur. top and that point. 
					tmp_diff_top = cur_peak - stock_prices[idx + 1]; 
					if (tmp_diff_top > out_max_decline)
						out_max_decline = tmp_diff_top;
				}
			}
			System.out.println((double)Math.round(out_max_decline * 1000000d) / 1000000d);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
