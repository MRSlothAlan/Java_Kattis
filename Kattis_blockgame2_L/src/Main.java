import java.util.*;
import java.io.*;


public class Main {
	public static void main (String [] args){
		// assume that I always strike first.
	      Scanner st = new Scanner(System.in);
	      long n = st.nextLong();
	      long m = st.nextLong();
	      System.out.println(solve(m,n));
	   }

	   private static String solve(long a, long b){
	      if (a == b)
	         return "win";
	      if (a < b){
	         long help = a;
	         a = b;
	         b = help;
	      }
	      //a > b
	      boolean myTurn = true;
	      while (2 * b > a){
	          long help = b;
	          b = a - b;
	          a = help;
	          // a > b
	          myTurn = !myTurn;
	      }
	      if (myTurn)
	         return "win";
	      else
	         return "lose";
	   }
}
