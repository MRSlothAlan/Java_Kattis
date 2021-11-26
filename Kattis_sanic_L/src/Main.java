import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		// circle of radius one for sanic.
		// circle, r, 
		// https://en.wikipedia.org/wiki/Tusi_couple#:~:text=The%20Tusi%20couple%20is%20a,diameter%20of%20the%20larger%20circle.
		// Tusi couple
		try {
			Scanner sc = new Scanner(System.in);
			double r = sc.nextDouble();
			// the movement of the center! offset by one.
			// https://upload.wikimedia.org/wikipedia/commons/0/08/Tusi_couple_ellipses.gif
			System.out.println(r - 1);
		}
		catch (Exception e) {
			
		}
	}
}
