import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger N = new BigInteger(sc.next());
		BigInteger a, b;
		BigInteger two = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		a = N.divide(two).add(one);
		b = N.divide(two).add(a);
		if (N.mod(two).longValue() != 0) {
			b = b.add(one);
		}
		System.out.println(a.multiply(b));
	}
}
