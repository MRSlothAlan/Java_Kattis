import java.util.*;
import java.io.*;


public class Main {
	public static ArrayList<Integer> prime; 
	public static boolean[] isNotPrime;
	
	public static long binpower(long base, long e, long mod) {
		long result = 1;
		long one = 1;
		base %= mod;
		while (e > 0) {
			if ((e & one) > 0)
				result = (long)result * base % mod;
			base = (long)base * base % mod;
			e >>= 1;
		}
		return result;
	}
	
	public static boolean check_composite(long n, long a, long d, int s) {
		long x = binpower(a, d, n);
		if (x == 1 || x == n - 1)
			return false;
		for (int r = 1; r < s; r++) {
			x = (long) x * x % n;
			if (x == n - 1)
				return false;
		}
		return true;
	};
	
	public static boolean MillerRabinDet(long n) { // returns true if n is prime, else returns false.
		if (n < 2)
			return false;

		int r = 0;
		long d = n - 1;
		while ((d & 1) == 0) {
			d >>= 1;
			r++;
		}
		int[] primeFac = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		for (int a : primeFac) {
			if (n == a)
				return true;
			if (check_composite(n, a, d, r))
				return false;
		}
		return true;
	}
	
	public static int segSieve(long n) {
		prime = new ArrayList<Integer>();
		int S = 10000;
		int nsqrt = (int)Math.sqrt(n);
		isNotPrime = new boolean[(int) (nsqrt + 1)];
		for (int i = 2; i <= nsqrt; i++) {
			if (!isNotPrime[i]) {
				prime.add(i);
				for (int j = i * i; j <= nsqrt; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		int result = 0;
		boolean[] blockNotPrime;
		for (int k = 0; k * S <= n; k++) {
			blockNotPrime = new boolean[S];
			int start = k * S;
			for (int p : prime) {
				int start_idx = (start + p - 1) / p;
				int j = Math.max(start_idx, p) * p - start;
				for (; j < S; j += p) {
					blockNotPrime[j] = true;
				}
			}
			if (k == 0) {
				blockNotPrime[0] = true;
				blockNotPrime[1] = true;
			}
			for (int i = 0; i < S && start + i <= n; i++) {
				if (!blockNotPrime[i]) {
					// isNotPrime[i + k * S] = false;
					result++;
				}
				else {
					// isNotPrime[i + k * S] = true;
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n, q;
		n = sc.nextLong(); q = sc.nextLong();
		// number of primes <= to n
		int count = segSieve(n);
		System.out.println(count);
		while (q > 0) {
			// 0 if x is composite.
			long in_num = sc.nextLong();
			if(MillerRabinDet(in_num)) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			q--;
		}
	}
}
