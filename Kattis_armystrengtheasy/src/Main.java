import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * War --> several monsters.
 * 		each battle : weakest one of all is killed
 * 		--> several weakest monster, all on same team, one of them is killed.
 * 		--> both army, >= 1 weakest monster, One in MechaGodzilla's team killed.
 * 
 * Case for uncertain?
 * 		
 */
public class Main {
	public static int T;
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_armystrengtheasy\\src\\sample.in");
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_armystrengtheasy\\src\\sample.in");
		
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			for (int i = 0; i < T; i++)
			{
				int Ng, Nm;
				Ng = sc.nextInt();		// in Godzilla's army
				Nm = sc.nextInt();		// in MechaGodzilla's army
				int[] G_army_power = new int[Ng];
				int[] M_army_power = new int[Nm];
				for (int j = 0; j < Ng; j++)
				{
					G_army_power[i] = sc.nextInt();
				}
				for (int j = 0; j < Nm; j++)
				{
					M_army_power[i] = sc.nextInt();
				}
				if (Ng == Nm && Ng == 0)
				{
					System.out.println("uncertain");
				}
				else
				{
					int G_ptr = 0;
					int M_ptr = 0;
					Arrays.sort(G_army_power);
					Arrays.sort(M_army_power);
					while (G_ptr < Ng && M_ptr < Nm)
					{
						if (G_army_power[G_ptr] < M_army_power[M_ptr])
						{
							G_ptr++;
						}
						else
						{
							M_ptr++;
						}
					}
					if (M_ptr == Nm)
						System.out.println("Godzilla");
					else if (G_ptr == Ng)
						System.out.println("MechaGodzilla");
					else
						System.out.println("uncertain");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
