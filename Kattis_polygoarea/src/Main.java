import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * 
 * Polygon area
 * https://open.kattis.com/problems/polygonarea
 * 
 */

class Point{
	
	public double x;
	public double y;
	public Point()
	{
		x = 0;
		y = 0;
	}
}

public class Main {
	public static int n, i, j;
	public static ArrayList<Point> pts;
	public static double area;
	
	public static void CheckDirection()
	{
		for (i = 1; i < pts.size(); i++)
		{
			if (pts.get(i).y > pts.get(i-1).y)
			{
				System.out.print("CCW ");
				return;
			}
			else if (pts.get(i).y < pts.get(i-1).y)
			{
				System.out.print("CW ");
				return;
			}
		}
	}
	
	public static void CalculateArea()
	{
		for (i = 1; i < pts.size(); i++)
		{
			area += pts.get(i-1).x * pts.get(i).y - pts.get(i).x * pts.get(i-1).y;
		}
		// last index with the first one.
		area += pts.get(i - 1).x * pts.get(0).y - pts.get(0).x * pts.get(i - 1).y;
		area /= 2;
		if (area < 0)
		{
			area *= -1;
		}
		System.out.printf("%.1f\n",area);
	}
	
	public static void main(String[] arg)
	{	
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_polygoarea\\src\\polygonarea_sample.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while(true){
				n = sc.nextInt();
				if (n == 0)
					return;
				else {
					pts = new ArrayList<Point>();
					for (i=0; i<n; i++)
					{
						// value bounded by 10000, in clockwise / counterclockwise order.
						Point tmp_pt = new Point();
						tmp_pt.x = sc.nextDouble();
						tmp_pt.y = sc.nextDouble();
						pts.add(tmp_pt);
					}
					area = 0;
					// check cw / ccw.
					CheckDirection();
					CalculateArea();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
