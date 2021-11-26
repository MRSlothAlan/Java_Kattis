import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float in_num = sc.nextFloat();
		if (in_num >= 1.0)
			in_num = (float) 1.0;
		System.out.println(Math.pow((in_num / 2), 2));
	}
}
