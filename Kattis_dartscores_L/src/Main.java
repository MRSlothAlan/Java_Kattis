import java.io.*;
import java.util.*;


/*
 * 10 circles,
 * smallest circle, enclosing / passing pt,
 * 20 * (11 - p) 
 */
public class Main {
	public static void main(String[] args) {
		try {
			/*
			File file = new File("C:\\Users\\tingk\\Desktop\\"
					+ "kattis\\Kattis_practices_repo\\"
					+ "eclipse_workspace_coding\\"
					+ "Kattis_dartscores_L\\src\\1.in");
			Scanner sc = new Scanner(file);
			*/
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			while(T > 0) {
				int N = sc.nextInt();
				int res = 0;
				for (int n = 0; n < N; n++) {
					// origin = 0, 0
					int x, y;
					x = sc.nextInt();
					y = sc.nextInt();
					double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
					if (radius == 0) {
						res--;
					}
					while (radius <= 200) {
						res++;
						radius += 20;
					}
					// int res_r = (int)Math.ceil(radius / 20);
					/*
					if (11 - res_r > 10) {
						res += 10;
					}
					else {
						res += 11 - res_r;
					}
					*/
				}
				System.out.println(res);
				T--;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
