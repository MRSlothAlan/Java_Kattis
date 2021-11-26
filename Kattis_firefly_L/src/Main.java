import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        try {
            // File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_firefly_L\\src\\sample2.in");
            // Scanner sc = new Scanner(file);
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int H = sc.nextInt();
            int[] count_bottom = new int[H];	// count for the bottom walls.
            int[] count_top = new int[H];
            // down up down up obstacles, alternate.
            for (int i = 1; i <= N; i++) {
                int obs = sc.nextInt();
                if (i % 2 > 0) {
                	// this is dumb and a waste of resources and time.
                    /*for (int j = 0; j < obs; j++) {
                        count[j]++;
                    }*/
                	count_bottom[obs - 1]++;
                }
                else {
                	/*for (int j = H - 1; j >= H - obs; j--) {
                        count[j]++;
                    }*/
                	count_top[H - obs]++;
                }
            }
            // Arrays.sort(count);
            int min = Integer.MAX_VALUE;
            int res_count = 0;
            int cur_overlap = 0;
            
            // calculate the cumulative sum of walls overlap.
            /* 3	|	|	|
             * 2	|	|
             * 1	|
             * 1	|
             * 0
             * 0
             */
            int sum = 0;
            for (int i = 0; i < H; i++) {
            	sum += count_top[i];
            	count_top[i] = sum;
            }
            sum = 0;
            for (int i = H - 1; i >= 0; i--) {
            	sum += count_bottom[i];
            	count_bottom[i] = sum;
            }
            
            for (int i = 0; i < H; i++) {
            	// overlapping walls?
            	cur_overlap = count_bottom[i] + count_top[i];
            	if (cur_overlap < min) {
            		// reset minimum. this works, since it is known that 
            		// closer to the top or bottom sides, denser are the walls.
            		min = cur_overlap;
            		res_count = 1;
            	}
            	else if (cur_overlap == min) {
            		res_count++;
            	}
            }
            System.out.printf("%d %d\n", min, res_count);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}