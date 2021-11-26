import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	/*
	 * formula:
	 * 		= SUM ((p * i) - floor(p * i / q) * q)) 
	 * yea still recall those series.
	 * 	p * i, pick p out, is 1 + 2 + 3...  + i
	 * floor calculation is the real deal. 
	 */
	
	public static long f(long p, long q, long n) {
		long ans = n*(n+1)/2 * (p/q);
		p %= q;
		if (p != 0) {
			long N = (p*n)/q;
			ans += n * N - f(q, p, N) + N/p;
		}
		return ans;
	}
	
	public static long gcd (long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_itsamodmodmodmodworld_L\\src\\modmodmod-0000.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int W = sc.nextInt();
			while (W --> 0) {
				long p = sc.nextLong();
				long q = sc.nextLong();
				long n = sc.nextLong();
				long gcd = gcd(p, q);
				System.out.println(n*(n+1)/2*p - q*f(p/gcd, q/gcd, n));
			}
					
		}
		catch (Exception e) {
			
		}
	}
}

// Well, the entire world of concrete math awaits.

/*
BigInteger res = new BigInteger("0");
BigInteger one = new BigInteger("1");
BigInteger two = new BigInteger("2");
*/
/*
 * Problem: 10^5, inner loop 10^6 , TLE. 
 * trap : module cannot be extracted as common factor
 * solution : a predefined mod loop.
 * 
 * ** improved, but just realized that p * i actually changed the mod sequence greatly.
 * Can complete at home.
 * 
 * 3 8 10?
 * 
 * 3 * 1 % 8 + 3 * 2 % 8 + 3 * 3 % 8 + ...
 * pattern: find LCM of p and q, this is the pattern.
 */
/* 
for (int i = 1; i <= W; i++) {
	BigInteger p, q, n;
	p = new BigInteger(sc.next());
	q = new BigInteger(sc.next());
	n = new BigInteger(sc.next());
	// BigInteger tmp = n.multiply(n.add(one)).divide(two);
	BigInteger tmp_set = n.divide(q);	// number of set of mod values to be added
	BigInteger tmp_last_max = n.mod(q);
	BigInteger tmp_q = q.subtract(one);	// recall the pattern 1, 2.. q - 1.
	BigInteger tmp_mod_sum = (tmp_q.multiply(tmp_q.add(one)).divide(two)).multiply(tmp_set);
	BigInteger tmp_mod_sum_last = tmp_last_max.multiply(tmp_last_max.add(one)).divide(two);
	
	res = (tmp_mod_sum.add(tmp_mod_sum_last)).multiply(p);
	// BigInteger tmp = n.multiply(val)
	// res = tmp.multiply(p).mod(q);
	System.out.println(res.toString());
}
*/