import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.printf(k % (m + n) < m ? "Barb\n" : "Alex\n");
		// Sprague–Grundy_theorem
	}
}
