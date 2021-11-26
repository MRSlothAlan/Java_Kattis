import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 	Ants : walk on a horizontal pole --> l cm
 * 	constant speed 1 cm / s
 * 		0	1	2	3	4	5	6	7	8	9	10
 * 	0			*				*	*				
 * 	1				*		*	*					
 * 	2					**	*						
 * 	3 				*	
 */
public class Main {
	public static int T;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_ants\\src\\ants.in");
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_ants\\src\\ants.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			for (int i = 0; i < T; i++)
			{
				int earlist, latest, tmp_earlist;
				int l, n; 
				l = sc.nextInt();	// length of pole
				n = sc.nextInt();	// number of ants
				
				int[] position = new int[n];
				for (int j = 0; j < n; j++)
				{
					position[j] = sc.nextInt();
				}
				Arrays.sort(position);
				
				earlist = 0;
				latest = 0;
				
				for (int j = 0; j < n; j++)
				{
					tmp_earlist = Math.min(position[j] - 0, l - position[j]);
					if (tmp_earlist > earlist)
						earlist = tmp_earlist;
					if (l - position[j] > latest)
						latest = l - position[j];
					if (position[j] > latest)
						latest = position[j];
				}
				System.out.println(String.valueOf(earlist) + " " + String.valueOf(latest));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
