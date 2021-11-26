import java.io.File;
import java.util.Scanner;
import java.util.*;

/*
 * Incognito
 * 		within a test case all names are distinct, but not for category.
 */

public class Main {
	public static int t, n, tmp_val, tmp_idx, i, j, k;
	public static String name;
	public static String attribute;
	public static int[] to_process;
	public static int[] tmp_idx_set;
	// public static HashMap<String, Integer> category;
	
	public static void brute_force_calculate_combination()
	{
		/*
		 * Lets' say you have categories a, b, c, each of them have 2, 2, 3
		 * when only putting on one (whatever) : 2 + 2 + 3
		 * when putting on two : 2 * 2 + 2 * 3 + 3 * 2
		 * when putting on three : 2 * 2 * 3
		 * total combination --> ar :-)  
		 */
		int out_sum = 0;
		for (i = 0; i < to_process.length; i++)
		{
			out_sum += to_process[i];
		}
		if (to_process.length > 1)
		{
			for (i = 2; i < to_process.length; i++)
			{
				for (j = 0; j < to_process.length; j++)
				{
					// index = val % length.
					// make a logic to set the idx to be multiplied.
					for (k = 0; k < i; k++)
					{
						// j && j + 1, etc. mod len
						tmp_idx_set[k] = (j + k) % to_process.length;
					}
					// continue here for combination calculation.
					tmp_val = 1;
					for (k = 0; k < i; k++)
					{
						tmp_val *= to_process[tmp_idx_set[k]];
					}
					out_sum += tmp_val;
				}
			}
			tmp_val = 1;
			for (i = 0; i < to_process.length; i++)
			{
				tmp_val *= to_process[i];
			}
			out_sum += tmp_val;
		}
		System.out.println(out_sum);
		return;
	}
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_incognito\\src\\I.in");
		HashMap<String, Integer> category;
				
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			t = sc.nextInt();
			while(t > 0)
			{
				category = new HashMap<String, Integer>();
				n = sc.nextInt();
				while(n > 0)
				{
					name = sc.next();
					attribute = sc.next();
					if (!category.containsKey(attribute))
					{
						category.put(attribute, 1);
					}
					else
					{
						tmp_val = category.get(attribute);
						category.put(attribute, tmp_val + 1);
					}
					n--;
				}
				// algorithm here.
				to_process = new int[category.size()];
				tmp_idx_set = new int[category.size()];
				tmp_idx = 0;
				for (String key: category.keySet())
				{
					to_process[tmp_idx] = category.get(key);
					tmp_idx_set[tmp_idx] = 0;
					tmp_idx++;
				}
				brute_force_calculate_combination();
				t--;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
