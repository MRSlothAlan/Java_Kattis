import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * anagrams?
 * arrangement of words
 * 		upper && lower case letters are considered distinct.
 * 		
 */

public class Main {
	public static BigInteger out_count, tmp;
	public static String in_str;
	public static int[] char_count, mul_result;
	public static String tmp_mul_result;
	public static int idx, carry, mul_result_size, tmp_val, tmp_div_size;
	public static boolean HasDuplicate;
	public static BigInteger tmp_one = new BigInteger("1");
	public static BigInteger tmp_zero = new BigInteger("0");

	// better way: use an array for containing carry bits

	/*
	 * Permutation with duplicates all combinations / (*) * : for each elements, if
	 * has total count of n divide the number by n! imagine that all the possible
	 * combinations of all elements as states In each state, n values are placed in
	 * the slots for that state, there are n! ways to place the elements with same
	 * type into the slots
	 */

	public static BigInteger factorial(BigInteger in_num) {
		BigInteger out_num = in_num;
		in_num.subtract(tmp_one);
		while (!in_num.equals(tmp_zero)) {
			out_num.multiply(in_num);
			in_num.subtract(tmp_one);
		}
		return out_num;
	}

	public static void permutation_solve() {
		/*
		 * Ah I should mod the value and multiply it back. No, it is still too costly.
		 */
		BigInteger str_len = new BigInteger(String.valueOf(in_str.length()));
		if (!HasDuplicate) {
			System.out.println(factorial(str_len));
		} else {
			out_count = factorial(str_len);
			for (int count_val : char_count) {
				BigInteger tmp = new BigInteger(String.valueOf(count_val));
				out_count.divide(factorial(tmp));
			}
			System.out.println(out_count);
		}
	}

	/*
	 * Hints : use arrays and mimic the way to do multiplication in primary school.
	 */

	// this is needed, one for calculating main result, one for calculating
	// division.
	public static int[] multiply_div(int tmp_val, int[] div_res) {
		carry = 0;
		for (idx = 0; idx < tmp_div_size; idx++) {
			int prod = div_res[idx] * tmp_val + carry;
			div_res[idx] = prod % 10;
			carry = prod / 10;
		}
		while (carry != 0) {
			div_res[tmp_div_size] = carry / 10;
			tmp_div_size++;
		}
		return div_res;
	}

	public static void multiply(int tmp_val) {
		carry = 0;
		for (idx = 0; idx < mul_result_size; idx++) {
			int prod = mul_result[idx] * tmp_val + carry;
			mul_result[idx] = prod % 10;
			carry = prod / 10; // recall that if you multiply,
								// 18 / 10 = 1 will be the carry and
								// 18 % 10 = 8 will be the current value
		}
		while (carry != 0) {
			mul_result[mul_result_size] = carry % 10;
			carry = carry / 10;
			mul_result_size++;
		}
	}

	public static void factorial_calculation_main(int n) {
		mul_result[0] = 1;
		mul_result_size = 1;
		for (tmp_val = 2; tmp_val <= n; tmp_val++) {
			multiply(tmp_val);
		}
	}

	public static int factorial_calculation_div(int in_div) {
		/*
		 * Calculate the factorial of div, and set the tmp_div_size
		 */
		int[] div_res = new int[500];
		div_res[0] = 1;
		tmp_div_size = 1; // a static variable controlling the div size.
		
		for (tmp_val = 2; tmp_val <= in_div; tmp_val++) {
			div_res = multiply_div(tmp_val, div_res);
		}
		int div_res_int = 0;
		for (int i = tmp_div_size - 1; i >= 0; i--) {
			div_res_int += div_res[i] * Math.pow(10, i);
		}
		return div_res_int;
	}

	public static void divide_mul_result(int fact_div) {
		// divide the tmp_mul_result with the divisor provided.
		StringBuilder result = new StringBuilder();
		char[] dividend = tmp_mul_result.toCharArray();
		int carry = 0;
		for (int i = 0; i < dividend.length; i++) {
			int x = carry * 10 + Character.getNumericValue(dividend[i]);
			result.append(x / fact_div);
			carry = x % fact_div;
		}
		// Remove leading zeros
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) != '0') {
				// Return the result
				tmp_mul_result = result.substring(i);
				return;
			}
		}
		tmp_mul_result = "";
	}

	public static void divide_with_factorial(int in_div) {
		// System.out.println("divide now");
		divide_mul_result(factorial_calculation_div(in_div));
		return;
	}

	public static void permutation_optimized() {
		factorial_calculation_main(in_str.length());
		if (!HasDuplicate) {
			for (idx = mul_result_size - 1; idx >= 0; idx--) {
				System.out.print(mul_result[idx]);
			}
			System.out.print("\n");
		} else // divide the result with the number given. The number itself is a factorial.
		{
			tmp_mul_result = "";
			for (idx = mul_result_size - 1; idx >= 0; idx--) {
				tmp_mul_result += (mul_result[idx]);
			}
			for (int j = 0; j < char_count.length; j++) {
				if (char_count[j] > 1) {
					divide_with_factorial(char_count[j]);
				}
			}
			System.out.println(tmp_mul_result);
		}
	}

	public static void main(String[] arg) {
		Map<Character, Integer> unique_characters = new HashMap<>();

		// File file = new
		// File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_anagramcounting\\src\\sample.in");
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\"
		// 		+ "eclipse_workspace_coding\\Kattis_anagramcounting\\src\\sample.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				mul_result = new int[500];
				unique_characters = new HashMap<>();
				in_str = sc.next();
				HasDuplicate = false;
				for (char c : in_str.toCharArray()) {
					if (unique_characters.containsKey(c)) {
						unique_characters.put(c, unique_characters.get(c) + 1);
						HasDuplicate = true;
					} else {
						unique_characters.put(c, 1);
					}
				}
				char_count = new int[unique_characters.size()];
				idx = 0;
				for (Character c : unique_characters.keySet()) {
					char_count[idx] = unique_characters.get(c);
					idx++;
				}
				// permutation_solve();
				permutation_optimized();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
