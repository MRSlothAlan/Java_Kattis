import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		try {
			/*
			 * Good morning, I am in a new job env! Haven't sign the contract tho.
			 */
			Scanner sc = new Scanner(System.in);
			int wc, hc, ws, hs;	// 4 integers
			wc = sc.nextInt();
			hc = sc.nextInt();
			ws = sc.nextInt();
			hs = sc.nextInt();
			// wrong ans?
			// output 0 or 1, whether the sticker fits
			// with one centimeter.
			/*
			 * Test case: wc = 35, hc = 30, ws = 25, hs = 29?
			 */
			if (wc - 2 >= ws && hc - 2 >= hs) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
