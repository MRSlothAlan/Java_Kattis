import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\"
			//		+ "eclipse_workspace_coding\\Kattis_temperature_L\\src\\2.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int X, Y;
			X = sc.nextInt();	// point on B, A = 0
			Y = sc.nextInt();	// no. of degrees in B = change of 1 degree in A
			// output : a temperature, both scales are the same.
			/* 
			 * e.g.
			 * B = 1, A = 0
			 * A 0 -> 1, B = 1 -> 4
			 * 0 -> -0.5, B moves -1.5 = -0.5
			 */
			// 3 1, impossible, because 0 1, cannot map with 3 1 at all.
			int tmp_Y = Y - 1;
			if (tmp_Y <= 0.5) {
				if (X == 0) {  // && Y == 1) {
					System.out.println("ALL GOOD");
				}
				else {
					System.out.println("IMPOSSIBLE");
				}
			}
			else {
				double val = (double)X / (1 - (double)Y);
				/*
				double neg_val = -1 * val;
				if (X + Y * val == X + Y * neg_val) {
					System.out.println("ALL GOOD");
				}
				else {
					System.out.printf("%.10f", val);
				}
				*/
				System.out.printf("%.10f", val);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
