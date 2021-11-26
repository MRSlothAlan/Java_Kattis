import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static long in_X, factor, i, j;
	public static int score;
	public static ArrayList<Long> values_cache;
	
	public static boolean[] find_prime(boolean[] isPrime)
	{
		for (i = 2; i < isPrime.length; i++)
		{
			if(isPrime[(int)i]){
				values_cache.add(i);
				for (j = i*2; j < isPrime.length; j += i)
				{
					isPrime[(int)j] = false;
				}
			}
		}
		return isPrime;
	}
	
	public static void brute_force_find_sol()
	{
		boolean[] isPrime = new boolean[(int)(Math.pow(10, 5) + 5)];
		Arrays.fill(isPrime, Boolean.TRUE);
		isPrime[0] = false;	// not allowed
		isPrime[1] = false; // no need to check 
		values_cache = new ArrayList<Long>();
		isPrime = find_prime(isPrime);
		
		while(in_X > 1)
		{
			for (long factor : values_cache)
			{
				if (in_X % factor == 0)
				{
					score += 1;
					in_X /= factor;
					break;
				}
			}
		}
		System.out.println(score);
	}
	
	public static void faster_approach()
	{
		/*
		 * Moral of the story:
		 * 		You are not too dumb, at least you know the use of prime
		 * 		however, sequencial search is costly
		 * 		more importantly, you break down the problem into sub-problems, which is good,
		 * 		but you can't really produce an integrated 'thing'
		 * 			--> in here, it is also checking for factors. the trick is,
		 * 				--> the number is reducing while the factor is increasing at the same time
		 * 				--> but if the same factor works then it is reasonable to stick with it
		 * 		Your code's problem:
		 * 			--> a lot of time is wasted in creating a prime array, with LIMITED upper bound
		 * 			--> time spent to sequencially search for factors everytime is costly.
		 */
		int factor = 2;
		while (factor * factor <= in_X)
		{
			if (in_X % factor == 0)
			{
				in_X /= factor;
				score++;
			}
			else
			{
				factor++;
			}
		}
		System.out.println(++score);
		return;
	}
	
	public static void main(String[] arg)
	{	
		score = 0;
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_listgame\\src\\listgame.01.in");
		try {
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			in_X = sc.nextInt();
			// brute_force_find_sol();
			faster_approach();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
