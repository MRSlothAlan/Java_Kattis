import java.util.*;
import java.io.*;


public class Main {
	public static void printStars(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		/*
		 * Good morning!
		 */
		try {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int M = sc.nextInt();
			while(N > 0) {
				int people = (int) Math.floor(M /N);
				if (M % N == 0) {
					while(N > 0) {
						printStars(people);
						N--;
					}
				}
				else {
					printStars(people);
					N--;
					M -= people;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
