import java.util.*;
import java.io.*;

/*
 * Area of polygon?
 * just groups of triangles
 * 
 * Expected values?
 * 2500 points, can have infinite possibilities in selecting points ...
 * only way: make a record 
 */

public class Main {
	public static double[] x_coor, y_coor;
	public static int N, k;
	
	public static double calPolyArea() {
		double ori_x = x_coor[0];
		double ori_y = y_coor[0];
		double area = 0;
		for (int idx = 1; idx < N - 1; idx++) {
			double vec_1_x = x_coor[idx] - ori_x;
			double vec_1_y = y_coor[idx] - ori_y;
			double vec_2_x = x_coor[idx + 1] - ori_x;
			double vec_2_y = y_coor[idx + 1] - ori_y;
			area += Math.abs((vec_1_x * vec_2_y - vec_1_y * vec_2_x) / 2);
		}
		return area;
	}
	public static void main(String[] args) {
		try  {
			// it is easy to find area, 
			// it is fxxking hard to find expected values for 2500 points
			File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_pieceofcake\\src\\CuttingCake-0000.in");
			Scanner sc = new Scanner(file);
			N = sc.nextInt();
			k = sc.nextInt();
			x_coor = new double[N];
			y_coor = new double[N];
			for (int i = 0; i < N; i++) {
				x_coor[i] = sc.nextDouble();
				y_coor[i] = sc.nextDouble();
			}
			// a temp. area first
			double area = calPolyArea();
			System.out.println(area);
			// wait, randomly pick 3 points...
			for (int idx = 0; idx < N; idx++) {
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}