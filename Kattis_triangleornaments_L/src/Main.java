import java.util.*;
import java.io.*;


/*
 * A B C;
 * 
 */

public class Main {
	
	public static double cosineAngle(double A, double B, double C) {
		return Math.acos((double) (Math.pow(C, 2) - Math.pow(A, 2) - Math.pow(B, 2)) / (double) (-2 * A * B));
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\"
					+ "Kattis_practices_repo\\eclipse_workspace_coding\\"
					+ "Kattis_triangleornaments_L\\src\\test2.in");
			Scanner sc = new Scanner(file);
			int N = sc.nextInt();
			double l = 0;
			for (int i = 0; i < N; i++) {
				double A, B, C;
				A = sc.nextDouble();
				B = sc.nextDouble();
				C = sc.nextDouble();
				// the triangle, hang in the corners of side A B
				// output the required L?
				if (A == B) {
					l += C;
				}
				else {
					/*
					 * => problem of my assumption:
					 * 		the vertical line, starting from the hanging angle,
					 *		is perpendicular to the ground, but that is 
					 * 		not true at all (l not minimized.)
					 */
					
					double hang_angle = cosineAngle(A, B, C);
					double angle = 0;
					// calculate the cos angle for the triangle.
					if (A < B) { double tmp = A; A = B; B = tmp; }
					angle = cosineAngle(A, C, B);
					/*
					 * the trick is to ... use vectors??
					 */
					
					double res_a = (Math.PI - hang_angle) / 2 - angle;
					
					
					l += Math.cos(res_a) * C;
				}
			}
			System.out.println(l);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
