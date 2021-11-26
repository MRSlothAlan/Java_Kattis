import java.util.*;
import java.io.*;
import java.util.ArrayList;

// https://open.kattis.com/submissions/7198171

/*
 * 
 * small struggle --> REMEMBERS THAT KNOWLEDGE FOR THE REST OF YOR LIFE.
 * IT people (including IT DOG) --> smart in general, > art
 * 
 * */

class Node {
	public int count;
	public int value;

	public Node(int in_count, int in_value) {
		this.count = in_count;
		this.value = in_value;
	}

	public Node left;
	public Node right;
}

public class Main {

	private static int N, t, idx, i, j, k;
	private static long tmp_sum, tmp_count, tmp_value;
	private static boolean[] binary_checked;
	private static boolean array_unique = true;

	public static int search_algo(long[] in_sorted_arr, long in_expected, int high) {
		/*
		 * O log N !! vs O N^2 !!!! (great improvement) -> one thing: need to allow
		 * user-defined high value.
		 */
		int low = 0;
		// high = in_sorted_arr.length - 1;
		int prev_idx = 0;

		while (true) {
			int mid = (high + low) / 2;
			if (in_sorted_arr[mid] == in_expected) // more sophisticated condition here to do what you want.
			{
				return mid;
			} else if (binary_checked[mid] == true && in_sorted_arr[mid] < in_expected) {
				if (in_sorted_arr[prev_idx] < in_expected && in_sorted_arr[prev_idx] > in_sorted_arr[mid]) {
					return prev_idx;
				}
				return mid;
			}
			if (in_expected > in_sorted_arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			binary_checked[mid] = true;
			prev_idx = mid;
		}
	}

	public static int binary_closest_search(long[] in_sorted_arr, long in_expected, int high) {
		// try to find the closest value, such that 0 <= target <= in_max_range
		// in here, construct an array, check for value being checked? Or no need?
		binary_checked = new boolean[in_sorted_arr.length];
		int idx = search_algo(in_sorted_arr, in_expected, high);
		return idx;
	}

	public static long[] merge_unique(long[] in_front_arr, long[] in_end_arr) {
		// UPDATE: how about removing duplicate at the same time?
		ArrayList<Long> tmp = new ArrayList<Long>();
		int tmp_ptr_front = 0;
		int tmp_ptr_end = 0;
		int merged_ptr = 0;

		while (tmp_ptr_front < in_front_arr.length && tmp_ptr_end < in_end_arr.length) {
			if (in_front_arr[tmp_ptr_front] < in_end_arr[tmp_ptr_end]) {
				tmp.add(in_front_arr[tmp_ptr_front]);
				tmp_ptr_front++;
			} else if (in_front_arr[tmp_ptr_front] > in_end_arr[tmp_ptr_end]) {
				tmp.add(in_end_arr[tmp_ptr_end]);
				tmp_ptr_end++;
			} else {
				// both equal? push one, increase both pointers' values
				array_unique = false;
				tmp.add(in_end_arr[tmp_ptr_front]);
				tmp_ptr_front++;
				tmp_ptr_end++;
			}
			merged_ptr++;
		}
		// push any remaining values
		// arrays are sorted in previous recursive layer(s).
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
		// merged array with size of both array
		long[] merged = new long[tmp.size()];
		for (i = 0; i < tmp.size(); i++) {
			merged[i] = tmp.get(i);
		}
		tmp = null;
		return merged;
	}

	public static long[] merge(long[] in_front_arr, long[] in_end_arr) {
		// merged array with size of both array
		long[] merged = new long[in_front_arr.length + in_end_arr.length];
		int tmp_ptr_front = 0;
		int tmp_ptr_end = 0;
		int merged_ptr = 0;

		while (tmp_ptr_front < in_front_arr.length && tmp_ptr_end < in_end_arr.length) {
			if (in_front_arr[tmp_ptr_front] < in_end_arr[tmp_ptr_end]) {
				merged[merged_ptr] = in_front_arr[tmp_ptr_front];
				tmp_ptr_front++;
			} else {
				merged[merged_ptr] = in_end_arr[tmp_ptr_end];
				tmp_ptr_end++;
			}
			merged_ptr++;
		}
		// push any remaining values
		// arrays are sorted in previous recursive layer(s).
		while (tmp_ptr_front < in_front_arr.length) {
			merged[merged_ptr] = in_front_arr[tmp_ptr_front];
			tmp_ptr_front++;
			merged_ptr++;
		}
		while (tmp_ptr_end < in_end_arr.length) {
			merged[merged_ptr] = in_end_arr[tmp_ptr_end];
			tmp_ptr_end++;
			merged_ptr++;
		}
		return merged;
	}

	// return array with unique values.
	public static long[] merge_sort_unique(int low, int high, long[] in_array) {
		if (high - low == 0) // single value? Nothing to sort actually.
		{
			// return a new array of long, with one value.
			long[] tmp = new long[1];
			tmp[0] = in_array[low];
			return tmp;
		} else {
			int mid = (high + low) / 2;
			// long[] front_part = merge_sort(0, mid, Arrays.copyOfRange(in_array, 0, mid));
			// long[] end_part = merge_sort(mid + 1, high, Arrays.copyOfRange(in_array, mid
			// + 1, high));
			// pass the original array to remove the wrong index problem.
			long[] front_part = merge_sort(low, mid, in_array);
			long[] end_part = merge_sort(mid + 1, high, in_array);
			long[] result = merge_unique(front_part, end_part);
			return result;
		}
	}

	public static long[] merge_sort(int low, int high, long[] in_array) {
		/*
		 * 1st issue report: Two problems: 1. copy range: missing the middle part? 2.
		 * the array index of low high needed to be adjusted accordingly, if you use
		 * copy range.
		 */

		/*
		 * 2nd issue report: One problem: 1. The front array is correctly sorted 2. But
		 * the lower index is always 0, failed to merge middle parts. (change the
		 * argument to low, not 0)
		 */

		/*
		 * 3rd issue report: One problem: 1. front part sorted perfectly 2. but you
		 * forgot the case when the array length is odd or whatever. Problem found, the
		 * high index should be (len - 1), 0-based index ar.
		 */

		/*
		 * 4th issue report: One problem: The merge function is ok logically, but when
		 * you append the remaining values back You forget the while loop! (U are NOT
		 * detail-minded.) Solution: add back the while loop logic.
		 */

		if (high - low == 0) // single value? Nothing to sort actually.
		{
			// return a new array of long, with one value.
			long[] tmp = new long[1];
			tmp[0] = in_array[low];
			return tmp;
		} else {
			int mid = (high + low) / 2;
			// long[] front_part = merge_sort(0, mid, Arrays.copyOfRange(in_array, 0, mid));
			// long[] end_part = merge_sort(mid + 1, high, Arrays.copyOfRange(in_array, mid
			// + 1, high));
			// pass the original array to remove the wrong index problem.
			long[] front_part = merge_sort(low, mid, in_array);
			long[] end_part = merge_sort(mid + 1, high, in_array);
			long[] result = merge(front_part, end_part);
			return result;
		}
	}

	/*
	 * start from the large number which is <= 7777 (binary search here...?) then,
	 * binary search for the number in the remaining portion of the list, such that
	 * sum <= 7777
	 */

	public static void CheckXY_optimized(long[] in_data) {
		// x != y, x + y = 7777?
		int in_len = in_data.length;
		long[] sorted_data = merge_sort_unique(0, in_len - 1, in_data);
		int upper_bound = sorted_data.length - 1;
		while (upper_bound >= 1) {
			int closest_idx = binary_closest_search(sorted_data, 7777, upper_bound);
			int closest_idx_remaining = binary_closest_search(sorted_data, 7777 - sorted_data[closest_idx],
					closest_idx);
			if (sorted_data[closest_idx] + sorted_data[closest_idx_remaining] == 7777) {
				System.out.println("Yes");
				return;
			}
			upper_bound--;
		}
		System.out.println("No");
		return;
	}

	public static void CheckXY(long[] in_data) {
		// any fast algo to handle 200,000 entries?
		// MUST BE MADE BY YOU, no web searching.
		// OBVIOUS algo: N^2 time.
		int in_len = in_data.length;
		long[] sorted_data = merge_sort(0, in_len - 1, in_data);
		if (sorted_data[in_len - 1] + sorted_data[in_len - 2] < 7777) {
			// already impossible to have x != y and x + y = 7777
			// time complicity: O(N*log(N)) + O(C) < O(N^2)
			System.out.println("No");
			return;
		} else {
			// just use N^2 way la?
			// BUT 200000 data... really double for loop ?
			// Make a condition:
			// you have sorted data ma, then find from end to front,
			// if current val, x + y < 7777, sou pei la.
			for (i = in_len - 1; i >= 0; i--) { // starter i is the largest number possible.
				for (j = in_len - 1; j >= 0; j--) {
					tmp_sum = sorted_data[i] + sorted_data[j];
					if (i != j) // make sure that they are not the same numbers first.
					{
						if (tmp_sum >= 7777) {
							if (sorted_data[i] != sorted_data[j] && tmp_sum == 7777) {
								System.out.println("Yes");
								i = 0;
								j = 0;
								return;
							}
						} else {
							System.out.println("No");
							i = 0;
							j = 0;
							return;
						}
					}
				}
			}
		}
		System.out.println("No");
		return;
	}

	public static void CheckUniqueOptimized(long[] in_data) {
		array_unique = true;
		int in_len = in_data.length;
		merge_sort_unique(0, in_len - 1, in_data);
		if (!array_unique) {
			System.out.println("Contains duplicate");
			return;
		}
		System.out.println("Unique");
		return;
	}

	public static void CheckUnique(long[] in_data) {
		// implement it yourself la, true programmers implement ideas into real-life.
		// Weak programmers copies from others and take it for granted.
		// recall NUS database course? Database: Used a tree like structure, time
		// complexity for data retrieval is low.
		// you have two ways: implement a binary search tree, or modified sequential
		// search.
		/*
		 * Binary tree: worst case complexity: log N base 2. NUS : a kind of tree, then
		 * search in patches of datatable? Modified sequential search, worst case: N.
		 * EM...
		 */
		int in_len = in_data.length;
		// the sorting ?
		long[] sorted_data = merge_sort(0, in_len - 1, in_data);
		j = 0;
		for (i = 1; i < in_len; i++) {
			if (sorted_data[i] == sorted_data[j]) // looks simple, but have higher worst case complexity.
			{
				System.out.println("Contains duplicate");
				return;
			}
			j++;
		}
		System.out.println("Unique");
		return;
	}

	public static void CheckIntegerAppearance(long[] in_data) {
		// appears > N / 2 times in A?
		int in_len = in_data.length;
		int check_size = in_len / 2;
		long[] sorted_data = merge_sort(0, in_len - 1, in_data);
		// Modified sequential search again?
		tmp_count = 1;
		tmp_value = sorted_data[0];
		for (i = 1; i < in_len; i++) {
			if (tmp_value != sorted_data[i]) {
				tmp_value = sorted_data[i];
				tmp_count = 1;
			} else {
				tmp_count++;
				if (tmp_count > check_size) {
					System.out.println(tmp_value);
					return;
				}
			}
		}
		System.out.println(-1);
		return;
	}

	public static void PrintMedianIntegers(long[] in_data) {
		/*
		 * Problem log: well, the index... u know
		 */
		int in_len = in_data.length;
		long[] sorted_data = merge_sort(0, in_len - 1, in_data);
		if (in_len % 2 == 0) {
			System.out.println(sorted_data[in_len / 2 - 1] + " " + sorted_data[in_len / 2]);
			return;
		} else // odd
		{
			// num / 2 already has that subtle -1 logic in there
			System.out.println(sorted_data[in_len / 2]);
			return;
		}
	}

	public static void PrintIntegersInRange(long[] in_data) {
		int in_len = in_data.length;
		long[] sorted_data = merge_sort(0, in_len - 1, in_data);
		// range from 100 to 999
		String result_str = "";
		for (i = 0; i < in_len; i++) {
			if (sorted_data[i] >= 100 && sorted_data[i] <= 999) {
				result_str += String.valueOf(sorted_data[i]) + " ";
			}
		}
		System.out.println(result_str.trim());
	}

	public static void OLD_driver_program(long[] in_data) {
		/*
		 * For your reference.
		 */
		// merge_sort(0, N - 1, in_data); // remembered this for the rest of your life.
		switch (t) {
		case 1:
			// CheckXY(in_data);
			CheckXY_optimized(in_data);
			break;
		case 2:
			// CheckUnique(in_data);
			CheckUniqueOptimized(in_data);
			break;
		case 3:
			CheckIntegerAppearance(in_data);
			break;
		case 4:
			PrintMedianIntegers(in_data);
			break;
		case 5:
			PrintIntegersInRange(in_data);
			break;
		}
	}

	public static void main(String[] args) {
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\" +
		// "Kattis_basicprogramming2\\src\\2.in");
		/*
		File file = new File("C:\\Users\\tingk\\Desktop\\"
				+ "kattis\\Kattis_practices_repo\\"
				+ "eclipse_workspace_coding\\"
				+ "Kattis_basicprogramming2\\src\\5.in");
		*/
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			t = sc.nextInt();
			
			long[] in_data = new long[N];
			
			Map<Integer, Boolean> exist = new HashMap<Integer, Boolean>();
			Map<Integer, Integer> occurance = new HashMap<Integer, Integer>();
			int max_occur_int_count = -1;
			int max_occur_int = -1; 
			
			idx = 0;
			while (sc.hasNextInt()) {
				in_data[idx] = sc.nextInt();
				int tmp_in_num = (int) in_data[idx];
				exist.put(tmp_in_num, true);
				
				if (!occurance.containsKey(tmp_in_num)) {
					occurance.put(tmp_in_num, 1);
				} else {
					occurance.put(tmp_in_num, occurance.get(tmp_in_num) + 1);
				}
				max_occur_int_count = Math.max(max_occur_int_count, occurance.get(tmp_in_num));
				if (max_occur_int_count == occurance.get(tmp_in_num)) {
					max_occur_int = tmp_in_num;
				}
				idx++;
			}
			Arrays.sort(in_data);
			/*
			 * Modified way to perform tasks
			 */
			switch (t) {
			case 1:
				boolean result = false;
				for (int i = 0; i < N && !result; i++) {
					if (exist.containsKey(7777 - (int) in_data[i]))
						result = exist.get(7777 - (int) in_data[i]);
				}
				if (result)
					System.out.println("Yes");
				else
					System.out.println("No");
				break;
			case 2:
				if (max_occur_int_count > 1) 
					System.out.println("Contains duplicate");
				else
					System.out.println("Unique");
				break;
			case 3:
				if (max_occur_int_count > N / 2)
					System.out.println(max_occur_int);
				else
					System.out.println(-1);
				break;
			case 4:
				PrintMedianIntegers(in_data);
				break;
			case 5:
				PrintIntegersInRange(in_data);
				break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
