import java.io.*;
import java.util.*;

/*
 * Output: minimum no. of interval\n, indices of interval(s)
 * else -> impossible.
 */
class Interval {
	public double lower_bound;
	public double upper_bound;
	public int index;
	public Interval(int in_index)
	{
		index = in_index;
		lower_bound = 0.0;
		upper_bound = 0.0;
	}
}


public class Main {
	public static double A, B, a, b;
	public static int n, i, j;
	public static Interval[] in_intervals;
	
	public static Interval[] merge_select_interval(Interval[] in_front_arr, Interval[] in_end_arr, 
														double lower_bound, double upper_bound) {
		/*
		 * merge array, but remove out of required bound interval.
		 * sort by lower bound btw.
		 */
		ArrayList<Interval> tmp = new ArrayList<Interval>();
		int tmp_ptr_front = 0;
		int tmp_ptr_end = 0;
		int merged_ptr = 0;

		while (tmp_ptr_front < in_front_arr.length && tmp_ptr_end < in_end_arr.length) {
			if (in_front_arr[tmp_ptr_front].lower_bound < in_end_arr[tmp_ptr_end].lower_bound) {
				
				if (in_front_arr[tmp_ptr_front].lower_bound <= lower_bound || 
						in_front_arr[tmp_ptr_front].upper_bound >= upper_bound)
				{
					tmp.add(in_front_arr[tmp_ptr_front]);
				}
				tmp_ptr_front++;
			} else {
				if (in_end_arr[tmp_ptr_end].lower_bound <= lower_bound || 
						in_end_arr[tmp_ptr_end].upper_bound >= upper_bound)
				{
					tmp.add(in_end_arr[tmp_ptr_end]);
				}
				tmp_ptr_end++;
			}
			merged_ptr++;
		}
		while (tmp_ptr_front < in_front_arr.length) {
			tmp.add(in_front_arr[tmp_ptr_front]);
			tmp_ptr_front++;
			merged_ptr++;
		}
		while (tmp_ptr_end < in_end_arr.length) {
			tmp.add(in_end_arr[tmp_ptr_end]);
			tmp_ptr_end++;
			merged_ptr++;
		}
		Interval[] merged = new Interval[tmp.size()];
		for (i = 0; i < tmp.size(); i++)
		{
			merged[i] = tmp.get(i);
		}
		return merged;
	}
	
	public static Interval[] merge_sort(int low, int high, Interval[] in_array, double lower_bound, double upper_bound) {
		if (high - low == 0) // single value? Nothing to sort actually.
		{
			Interval[] tmp = new Interval[1];
			tmp[0] = in_array[low];
			return tmp;
		} else {
			int mid = (high + low) / 2;
			Interval[] front_part = merge_sort(low, mid, in_array, lower_bound, upper_bound);
			Interval[] end_part = merge_sort(mid + 1, high, in_array, lower_bound, upper_bound);
			Interval[] result = merge_select_interval(front_part, end_part, lower_bound, upper_bound);
			return result;
		}
	}

	
	public static void main(String[] args) {
		
		try
		{
			Scanner sc = new Scanner(System.in);
			A = sc.nextDouble();
			B = sc.nextDouble();
			n = sc.nextInt();
			in_intervals = new Interval[n];
			for (i = 0; i < n; i++)
			{
				in_intervals[i] = new Interval(i);
				in_intervals[i].lower_bound = sc.nextDouble();
				in_intervals[i].upper_bound = sc.nextDouble();
			}
			Interval[] processed_interval = merge_sort(0, n - 1, in_intervals, A, B);
			// for the remaining covers (already get the maximum number of intervals to cover)
			// check for minimum one.
			if (processed_interval[0].lower_bound > A)
			{
				System.out.println("impossible");
				return;
			}
			else
			{
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}