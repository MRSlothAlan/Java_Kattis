import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		// find primes beforehand?
		/*
		 * Your problem: NEVER think REVERSIBLY.
		 */
		/*
		int size = 1000000000;
		boolean[] isPrime = new boolean[size + 1];
		isPrime[1] = false; // anyway.
		isPrime[2] = true;
		isPrime[3] = true;
		
		for (int i = 2; i < size; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < size; j += i) {
					isPrime[j] = true;
				}
			}
		}
		if (isPrime[N]) {
			System.out.println(N - 1);
		}
		*/
		// fast way to find prime?
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 0;

		// just go and find the nearest factor.
		/*
		for (i = N / 2 + 1; i >= 1; i--) {
			// counter = counter + 1;
			if (N % i == 0)
				break;
		}
		System.out.println(N - i);
		*/
		if (N == 1) {
			System.out.println(0);
			return;
		}
		else {
			for (i = 2; i < Math.sqrt(N) + 1; i++) {
				if (N % i == 0) {
					System.out.println(N - N / i);
					return;
				}
			}
		}
		// 1 is the only possible factor now.
		System.out.println(N - 1);
	}
}
