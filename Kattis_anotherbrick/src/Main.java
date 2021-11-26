import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 	Another brick in the wall.
 * 	Place the brick, first layer, left to right.
 * 	lay bricks horizontally, without rotation.
 * 	
 */
public class Main {
	public static int h, w, n, i, tmp, tmp_layer, tmp_idx;
	public static ArrayList<Integer> bricks;
	
	public static void LayBricks()
	{
		tmp_layer = 0;
		tmp_idx = 0;
		// h must > 0
		while (h > 0 && tmp_idx < bricks.size())
		{
			tmp_layer += bricks.get(tmp_idx);
			if (tmp_layer > w)
			{
				System.out.println("NO");
				return;
			}
			else if (tmp_layer == w)
			{
				h--;
				tmp_layer = 0;
			}
			tmp_idx++;
		}
		if (h <= 0)
		{
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
		return;
	}
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_anotherbrick\\src\\2.in");
		try {
			// Scanner sc = new Scanner(file);
			bricks = new ArrayList<Integer>();
			Scanner sc = new Scanner(System.in);
			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			for (i = 0; i < n; i++)
			{
				// bricks has height 1, and diff. length
				tmp = sc.nextInt();
				bricks.add(tmp);
			}
			LayBricks();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
