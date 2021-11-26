import java.io.File;
import java.util.Scanner;

public class Main {
	public static int t, m, i, j, k;
	
	public static void main(String[] arg)
	{
		/*
		 * combine 2 substances, i and j --> get i bitwise_xor j
		 * same = 0, different = 1
		 * 
		 * want to make substance m
		 * 	--> given 1 to m, substances
		 * 
		 * print n (largest number of substances?)
		 * next n int: substances used.
		 * > 1 opt ans -> print the one with smallest lexicographical order
		 * > output shall be sorted.
		 * 0001
		 * 0010
		 * -----
		 * 0011
		 * 0011
		 * -----
		 * 0000
		 * 0101
		 * -----
		 * 0101
		 */
		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_Alchemy 101\\src\\1.in");
		try {
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			t = sc.nextInt();
			while(t > 0)
			{
				m = sc.nextInt();
				t--;
				System.out.println(m);
			}
			// a state transition problem?
			// Btw, m is only 1000.
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
