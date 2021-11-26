import java.util.*;
import java.io.*;


/*
 * https://open.kattis.com/problems/malfunctioningrobot
 * 
 * damn. CHECK LATER.
 * 
 * 0 to 2? 3 = 2 + 1 , 0 to 4? 7 = 4 + 3
 * 0 to 6? 11 = 6 + 5 
 * 
 * move from 0 to 3?
 *      5 steps = 3 + 2
 * move from 0 to 5?
 *      9 steps = 5 + 4
 */

public class Main {
    public static int zigzagDistSameAxis(int start, int end)
    {
        int diff = Math.abs(start - end);
        if (diff % 2 == 0 && diff > 1)
        	return diff + diff;
        else if (diff <= 0)
        	return 0;
        else
        	return diff + diff - 1;
    }
    public static void main(String[] args) {
        try {
            // File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_malfunctioningrobot\\src\\1.in");
        	File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_malfunctioningrobot_L\\src\\1.in");
            Scanner sc = new Scanner(file);
            // Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                int start_x, start_y, end_x, end_y;
                start_x = sc.nextInt();
                start_y = sc.nextInt();
                end_x = sc.nextInt();
                end_y = sc.nextInt();
                // solve from start x to end x first
                int dist = 0;
                if (start_x == end_x && start_y == end_y) {
                	dist = 0;
                }
                else if (start_x == end_x) {
                    // just calculate the zigzag path along y axis
                    dist = zigzagDistSameAxis(start_y, end_y);
                }
                else if (start_y == end_y) {
                    // calculate the zigzag path along x axis
                    dist = zigzagDistSameAxis(start_x, end_x);
                }
                else {
                    // modify this part.
                	// alternative way to solve : 
                    int diff_x = Math.abs(start_x - end_x);
                    int diff_y = Math.abs(start_y - end_y);
                	int min_diff = Math.min(diff_x, diff_y);
                    dist += min_diff * 2;
                	if (min_diff == diff_y)
                	{
                		// reached y, just for x axis now.
                		start_x += min_diff;
                		dist += zigzagDistSameAxis(start_x, end_x);
                	}
                	else
                	{
                		start_y += min_diff;
                		dist += zigzagDistSameAxis(start_y, end_y);
                	}
                	/*
                    int final_diff = Math.abs(diff_y - diff_x);
                    dist = diff_x + diff_y + final_diff;
                    if (final_diff % 2 != 0)
                        dist++;
                    */
                }
                System.out.println(dist);
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
