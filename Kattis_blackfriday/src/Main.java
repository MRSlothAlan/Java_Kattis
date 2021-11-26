import java.io.File;
import java.util.Scanner;

/*
 * This is the Java framework for solving the Kattis problems.
 */
class ParticipantData
{
	public int participant_idx;
	public int count;
	public ParticipantData()
	{
		count = 0;
		participant_idx = -1;
	}
}

public class Main {
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_blackfriday\\src\\2.in");
		try {
			int n, max_unique_value, out_idx;
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			ParticipantData[] dice_value_count = new ParticipantData[7];
			for (int i = 1; i < 7; i++)
			{
				dice_value_count[i] = new ParticipantData();
			}
			for (int i = 1; i <= n; i++)
			{
				int tmp = sc.nextInt();
				dice_value_count[tmp].count++;
				dice_value_count[tmp].participant_idx = i;
			}
			// output the index of the participant with the highest unique value
			max_unique_value = 0;
			out_idx = -1;
			for (int i = 1; i < 7; i++)
			{
				if(dice_value_count[i].count == 1 && i > max_unique_value)
				{
					out_idx = dice_value_count[i].participant_idx;
					max_unique_value = i;
				}
			}
			if (out_idx != -1)
				System.out.println(out_idx);
			else
				System.out.println("none");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
