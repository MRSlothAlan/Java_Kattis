import java.util.Scanner;
import java.io.File;

public class Main {
	public static void main(String[] args)
	{
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_bishops\\src\\sample.in");
		try
		{
			Scanner sc = new Scanner(System.in);
			// Scanner sc = new Scanner(file);
			// fuck you, input !!!!
			while (sc.hasNext())
			{
				int n = sc.nextInt(); // size of chessboard.
				// max number of bishops that can be placed onto the chessboard?
				// bishop : can moves diagonally.
				if(n == 0) System.out.println(0);
				else if (n == 1) System.out.println(1);
				/*
				 * Fuck you I am correct!!!
				 */
				else System.out.println(n + n - 2);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
