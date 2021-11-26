import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Towering problem.
 */
public class Main {
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_towering\\src\\002.in");
		try {
			// Scanner sc = new Scanner(file);
			int[] heights = new int[6];
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < 6; i++)
			{
				heights[i] = sc.nextInt();
			}
			int height_first, height_second;
			height_first = sc.nextInt();
			height_second = sc.nextInt();
			
			int[] first_tower = new int[3];
			int[] second_tower = new int[3];
			
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					for (int k = j + 1; k < 6; k++) {
						if (heights[i] + heights[j] + heights[k] == height_first)
						{
							first_tower[0] = heights[i];
							first_tower[1] = heights[j];
							first_tower[2] = heights[k];
							heights[i] = -1;
							heights[j] = -1;
							heights[k] = -1;
							i = 7;
							j = 7;
							k = 7;
							break;
						}
					}
				}
			}
			int idx_tmp = 0;
			for (int i = 0; i < 6; i++) {
				if (heights[i] != -1) {
					second_tower[idx_tmp] = heights[i];
					idx_tmp++;
				}
			}
			Arrays.sort(first_tower);
			Arrays.sort(second_tower);
			for (int i = 2; i >= 0; i--)
				System.out.print(String.valueOf(first_tower[i]) + " ");
			for (int i = 2; i >= 1; i--)
				System.out.print(String.valueOf(second_tower[i]) + " ");
			System.out.println(String.valueOf(second_tower[0]));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
