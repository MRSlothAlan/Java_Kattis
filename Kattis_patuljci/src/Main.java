import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
public class Main {
	public static int[] nine_hats, outsiders;
	public static int i, j, k, l, m, n, o, tmp, sum;
	
	public static void VeryBruteForce()
	{
		// chi sin
		for (i = 0; i <= 2; i++) {
			for (j = i + 1; j <= 3; j++) {
				for (k = j + 1; k <= 4; k++) {
					for (l = k + 1; l <= 5; l++) {
						for (m = l + 1; m <= 6; m++) {
							for (n = m + 1; n <= 7; n++) {
								for (o = n + 1; o <= 8; o++) {
									if (nine_hats[i] + 
											nine_hats[j] + 
												nine_hats[k] + 
													nine_hats[l] + 
														nine_hats[m] + 
															nine_hats[n] + 
																nine_hats[o] == 100) {
																	System.out.println(nine_hats[i]);
																		System.out.println(nine_hats[j]);
																			System.out.println(nine_hats[k]);
																				System.out.println(nine_hats[l]);
																					System.out.println(nine_hats[m]);
																						System.out.println(nine_hats[n]);
																							System.out.println(nine_hats[o]);
																								return;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void BruteForce()
	{
		// how about cases like having a number 99 in array? 
		for (i = 0; i < 9; i++)
		{
			for (j = i; j < 9; j++)
			{
				if (sum - nine_hats[i] - nine_hats[j] == 100)
				{
					outsiders[i] = 1;
					outsiders[j] = 1;
					i = j = 9;
				}
			}
		}
		for (i = 0; i < 9; i++)
		{
			if (outsiders[i] == 0)
				System.out.println(nine_hats[i]);
		}
	}
	
	public static void main(String[] arg)
	{		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_patuljci\\1.in");
		try {
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			nine_hats = new int[9];
			outsiders = new int[9];
			i = 0;
			sum = 0;
			while(sc.hasNext())
			{
				tmp = sc.nextInt();
				sum += tmp;
				nine_hats[i] = tmp;
				outsiders[i] = 0;
				i++;
			}
			VeryBruteForce();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
